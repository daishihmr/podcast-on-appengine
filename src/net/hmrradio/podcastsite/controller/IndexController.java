package net.hmrradio.podcastsite.controller;

import java.util.List;
import java.util.logging.Logger;

import net.hmrradio.podcastsite.define.AttrName;
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

            if (StringUtil.isEmpty(asString("p"))) {
                list = blogEntryService.list();
                requestScope(
                    "tags",
                    "ネットラジオ,佐世保,Podcast,九州ネットラジオ組合,関東ネットラジオリンク,電脳,オタク,映画,風俗,音楽,コンビニ,ゲーム");
            } else {
                list = Lists.newArrayList(blogEntryService.get(asKey("p")));
                StringBuffer tags = new StringBuffer();
                for (String tag : list.get(0).getTags()) {
                    tags.append(", " + tag);
                }
                if (tags.length() != 0) {
                    requestScope("tags", tags.substring(2));
                }
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

        log.info("index end");
        return forward("/index.jsp");
    }

    private Navigation notFound() {
        errors.put("global", ApplicationMessage.get("message.noSuchBlogEntry"));
        requestScope(AttrName.RETURN_TOP, true);
        return forward("error.jsp");
    }

}
