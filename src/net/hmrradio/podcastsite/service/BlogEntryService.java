package net.hmrradio.podcastsite.service;

import java.util.Date;
import java.util.List;
import java.util.Set;

import net.hmrradio.podcastsite.bean.BlogEntryQueryBean;
import net.hmrradio.podcastsite.exception.EntityAlreadyDeletedException;
import net.hmrradio.podcastsite.meta.BlogEntryMeta;
import net.hmrradio.podcastsite.model.BlogEntry;
import net.hmrradio.podcastsite.util.WikiUtil;

import org.slim3.datastore.Datastore;
import org.slim3.datastore.ModelQuery;
import org.slim3.util.BeanUtil;
import org.slim3.util.StringUtil;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.Text;
import com.google.appengine.api.datastore.Query.FilterOperator;
import com.google.appengine.api.datastore.Query.SortDirection;
import com.google.appengine.repackaged.com.google.common.collect.Sets;

public class BlogEntryService {

    private BlogEntryMeta b = BlogEntryMeta.get();

    public List<BlogEntry> list() {
        return Datastore.query(BlogEntry.class).sort(
            b.createDate.getName(),
            SortDirection.DESCENDING).asList();
    }

    public List<BlogEntry> list(ModelQuery<BlogEntry> query) {
        if (query == null) {
            return list();
        }
        return query
            .sort(b.createDate.getName(), SortDirection.DESCENDING)
            .limit(5)
            .asList();
    }

    public List<BlogEntry> list(BlogEntryQueryBean queryBean) {
        return list(createQuery(queryBean));
    }

    public ModelQuery<BlogEntry> createQuery(BlogEntryQueryBean queryBean) {
        if (queryBean == null) {
            return null;
        }

        ModelQuery<BlogEntry> result = Datastore.query(BlogEntry.class);

        if (queryBean.getKeyEq() != null) {
            result.filter(b.key.getName(), FilterOperator.EQUAL, queryBean
                .getKeyEq());
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
            result.filter(b.corners.getName(), FilterOperator.EQUAL, queryBean
                .getCornerEq());
        }

        if (!StringUtil.isEmpty(queryBean.getMemberEq())) {
            result.filter(b.members.getName(), FilterOperator.EQUAL, queryBean
                .getMemberEq());
        }

        if (!StringUtil.isEmpty(queryBean.getTagEq())) {
            result.filter(b.tags.getName(), FilterOperator.EQUAL, queryBean
                .getTagEq());
        }

        return result;
    }

    public BlogEntry parseContent(BlogEntry entry) throws Exception {
        BlogEntry result = new BlogEntry();

        BeanUtil.copy(entry, result);
        result.setContent(WikiUtil.parse(result.getContent()));

        return result;
    }

    public BlogEntry get(Key key) {
        try {
            return Datastore.get(BlogEntry.class, key);
        } catch (Exception e) {
            throw new EntityAlreadyDeletedException();
        }
    }

    public void create(BlogEntry newEntry) {
        newEntry.setCreateDate(new Date());
        newEntry.setPubDate(new Date());
        Datastore.put(newEntry);
    }

    public void update(BlogEntry entry) {
        BlogEntry base = Datastore.get(BlogEntry.class, entry.getKey());
        entry.setCreateDate(base.getCreateDate());
        entry.setPubDate(new Date());
        entry.setVersion(base.getVersion());
        Datastore.put(entry);
    }

    public List<BlogEntry> listAll() {
        List<BlogEntry> result =
            Datastore.query(BlogEntry.class).sort(
                b.createDate.getName(),
                SortDirection.DESCENDING).asList();

        return result;
    }

    public BlogEntry plainText(BlogEntry blog) {
        BlogEntry result = new BlogEntry();

        BeanUtil.copy(blog, result);
        String content = blog.getContent().getValue();
        content =
            content.replaceAll("\\[\\[BR\\]\\]", "").replaceAll(
                "\\[/corner/",
                "").replaceAll("\\[/member/", "").replaceAll("\\]", "");
        result.setContent(new Text(content));

        return result;
    }

    public void delete(Key key) {
        Datastore.delete(key);
    }

    public Set<String> getCorners(String entry) {
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

    public Set<String> getPersonalities(String entry) {
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

}
