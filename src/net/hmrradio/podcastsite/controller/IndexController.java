package net.hmrradio.podcastsite.controller;

import java.util.List;
import java.util.logging.Logger;

import net.hmrradio.podcastsite.bean.BlogEntryQueryBean;
import net.hmrradio.podcastsite.define.AttrName;
import net.hmrradio.podcastsite.define.Values;
import net.hmrradio.podcastsite.model.BlogEntry;
import net.hmrradio.podcastsite.model.Link;
import net.hmrradio.podcastsite.service.BlogEntryService;
import net.hmrradio.podcastsite.service.LinkService;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.datastore.EntityNotFoundRuntimeException;
import org.slim3.util.ApplicationMessage;
import org.slim3.util.StringUtil;

import com.google.appengine.repackaged.com.google.common.collect.Lists;

public class IndexController extends Controller {

    private Logger log = Logger.getLogger(IndexController.class.getName());

    private BlogEntryService blogEntryService = new BlogEntryService();
    private LinkService linkService = new LinkService();

    @Override
    public Navigation run() throws Exception {
        log.info("index start");

        // 記事
        try {
            List<BlogEntry> list;

            if (!StringUtil.isEmpty(asString("p"))) {

                list = Lists.newArrayList(blogEntryService.get(asKey("p")));

                StringBuffer tags = new StringBuffer();
                for (String tag : list.get(0).getTags()) {
                    tags.append(", " + tag);
                }
                if (tags.length() != 0) {
                    requestScope("tags", tags.substring(2));
                }

            } else if (!StringUtil.isEmpty(param("member"))) {

                BlogEntryQueryBean query = new BlogEntryQueryBean();
                query.setMemberEq(param("member"));
                list = blogEntryService.list(query);

                requestScope("tags", Values.DEFAULT_TAGS);

            } else if (!StringUtil.isEmpty(param("corner"))) {

                BlogEntryQueryBean query = new BlogEntryQueryBean();
                query.setCornerEq(param("corner"));
                list = blogEntryService.list(query);

                requestScope("tags", Values.DEFAULT_TAGS);

            } else if (!StringUtil.isEmpty(param("tag"))) {

                BlogEntryQueryBean query = new BlogEntryQueryBean();
                query.setTagEq(param("tag"));
                list = blogEntryService.list(query);

                requestScope("tags", Values.DEFAULT_TAGS);

            } else {

                list = blogEntryService.list(null);

                requestScope("tags", Values.DEFAULT_TAGS);

            }
            requestScope(AttrName.ENTRY_LIST, list);
            log.info("エントリ数 = " + list.size());

        } catch (IllegalArgumentException e) {
            return notFound();
        } catch (EntityNotFoundRuntimeException e) {
            return notFound();
        }

        // リンク集
        List<Link> linkList = linkService.list();
        requestScope(AttrName.LINK_LIST, linkList);
        log.info("リンク数 = " + linkList.size());

        // 広告を表示
        requestScope("showAds", true);

        log.info("index end");

        return forward("/index.jsp");
    }

    private Navigation notFound() {
        errors.put("global", ApplicationMessage.get("message.noSuchBlogEntry"));
        requestScope(AttrName.RETURN_TOP, true);
        return forward("error.jsp");
    }

}
