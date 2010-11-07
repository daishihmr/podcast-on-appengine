package net.hmrradio.podcastsite.service;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

import net.hmrradio.podcastsite.bean.BlogEntryQueryBean;
import net.hmrradio.podcastsite.exception.EntityAlreadyDeletedException;
import net.hmrradio.podcastsite.meta.BlogEntryMeta;
import net.hmrradio.podcastsite.model.BlogEntry;

import org.slim3.datastore.Datastore;
import org.slim3.datastore.ModelQuery;
import org.slim3.util.StringUtil;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.Query.FilterOperator;
import com.google.appengine.api.datastore.Query.SortDirection;
import com.google.appengine.repackaged.com.google.common.collect.Sets;

public class BlogEntryService {

    private BlogEntryMeta b = BlogEntryMeta.get();
    private Logger log = Logger.getLogger(BlogEntryService.class.getName());

    /**
     * データをDELETEする。
     * 
     * @param key
     */
    public void delete(Key key) {
        Datastore.delete(key);
    }

    /**
     * 記事内からコーナー名の集合を抽出する。
     * 
     * @param entry
     * @return
     */
    public Set<String> findCorners(String entry) {
        if (entry == null) {
            return null;
        }
        Set<String> result = Sets.newHashSet();
        StringBuffer content = new StringBuffer(entry);

        while (content.indexOf("[/corner/") != -1) {
            int from = content.indexOf("[/corner/");
            int to = content.indexOf("]", from);
            if (from == -1 || to == -1) {
                break;
            }
            result.add(content.substring(from + "[/corner/".length(), to));
            content.delete(from, to + 1);
        }

        return result;
    }

    /**
     * 記事内からメンバー名の集合を抽出する。
     * 
     * @param entry
     * @return
     */
    public Set<String> findPersonalities(String entry) {
        if (entry == null) {
            return null;
        }
        Set<String> result = Sets.newHashSet();
        StringBuffer content = new StringBuffer(entry);

        while (content.indexOf("[/member/") != -1) {
            int from = content.indexOf("[/member/");
            int to = content.indexOf("]", from);
            if (from == -1 || to == -1) {
                break;
            }
            result.add(content.substring(from + "[/member/".length(), to));
            content.delete(from, to + 1);
        }

        return result;
    }

    /**
     * データをGETする。
     * 
     * @param key
     * @return
     */
    public BlogEntry get(Key key) {
        log.info("key = " + ((key == null) ? "null" : key.toString()));
        try {
            return Datastore.get(BlogEntry.class, key);
        } catch (Exception e) {
            throw new EntityAlreadyDeletedException();
        }
    }

    /**
     * 全検索。<br />
     * 投稿日時の降順で抽出する。
     * 
     * @return
     */
    public List<BlogEntry> list() {
        return Datastore
            .query(BlogEntry.class)
            .sort(b.createDate.getName(), SortDirection.DESCENDING)
            .asList();
    }

    /**
     * 条件指定検索。<br />
     * 条件に合致するブログ記事を５件、投稿日時の降順で抽出する。
     * 
     * @param queryBean
     * @return
     */
    public List<BlogEntry> list(BlogEntryQueryBean queryBean) {
        return list(createQuery(queryBean));
    }

    /**
     * データをPUTする。
     * 
     * @param blogEntry
     */
    public void put(BlogEntry blogEntry) {
        Date date = new Date();
        if (blogEntry.getKey() != null) {
            blogEntry.setPubDate(date);
        } else {
            blogEntry.setCreateDate(date);
            blogEntry.setPubDate(date);
        }
        Datastore.put(blogEntry);
    }

    private ModelQuery<BlogEntry> createQuery(BlogEntryQueryBean queryBean) {
        ModelQuery<BlogEntry> result = Datastore.query(BlogEntry.class);

        if (queryBean == null) {
            return result;
        }

        if (queryBean.getKeyEq() != null) {
            result.filter(
                b.key.getName(),
                FilterOperator.EQUAL,
                queryBean.getKeyEq());
            return result;
        }

        if (queryBean.getCreateDateLt() != 0) {
            Date date = new Date(queryBean.getCreateDateLt());
            result.filter(
                b.createDate.getName(),
                FilterOperator.LESS_THAN,
                date);
        }

        if (!StringUtil.isEmpty(queryBean.getCornerEq())) {
            result.filter(
                b.corners.getName(),
                FilterOperator.EQUAL,
                queryBean.getCornerEq());
        }

        if (!StringUtil.isEmpty(queryBean.getMemberEq())) {
            result.filter(
                b.members.getName(),
                FilterOperator.EQUAL,
                queryBean.getMemberEq());
        }

        if (!StringUtil.isEmpty(queryBean.getTagEq())) {
            result.filter(
                b.tags.getName(),
                FilterOperator.EQUAL,
                queryBean.getTagEq());
        }

        return result;
    }

    private List<BlogEntry> list(ModelQuery<BlogEntry> query) {
        if (query == null) {
            return list();
        }
        return query
            .sort(b.createDate.getName(), SortDirection.DESCENDING)
            .limit(5)
            .asList();
    }

}
