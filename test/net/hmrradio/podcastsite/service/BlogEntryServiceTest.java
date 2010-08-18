package net.hmrradio.podcastsite.service;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.List;
import java.util.Set;

import net.hmrradio.podcastsite.bean.BlogEntryQueryBean;
import net.hmrradio.podcastsite.model.BlogEntry;

import org.junit.Test;
import org.slim3.datastore.Datastore;
import org.slim3.tester.AppEngineTestCase;
import org.slim3.util.DateUtil;

public class BlogEntryServiceTest extends AppEngineTestCase {

    private BlogEntryService service = new BlogEntryService();

    @Test
    public void test() throws Exception {
        assertThat(service, is(notNullValue()));
    }

    @Test
    public void 全検索() throws Exception {
        for (int i = 1; i <= 30; i++) {
            BlogEntry entry = new BlogEntry();
            entry.setTitle("title" + i);
            Calendar cal = Calendar.getInstance();
            cal.set(2010, 7, i, 0, 0, 0);
            entry.setCreateDate(cal.getTime());

            Datastore.put(entry);
        }

        List<BlogEntry> list = service.list();

        assertThat(list.size(), is(30));
        assertThat(list.get(0).getTitle(), is("title30"));
        assertThat(
            list.get(29).getCreateDate().toString(),
            is(DateUtil
                .toDate("2010/08/01 00:00:00", "yyyy/MM/dd HH:mm:ss")
                .toString()));
    }

    @Test
    public void 条件指定検索() throws Exception {
        for (int i = 1; i <= 30; i++) {
            BlogEntry entry = new BlogEntry();
            entry.setTitle("title" + i);
            Calendar cal = Calendar.getInstance();
            cal.set(2010, 7, i, 0, 0, 0);
            entry.setCreateDate(cal.getTime());

            Datastore.put(entry);
        }

        BlogEntryQueryBean queryBean = new BlogEntryQueryBean();
        queryBean.setCreateDateLt(DateUtil.toDate(
            "2010/08/10 00:00:00",
            "yyyy/MM/dd HH:mm:ss").getTime());

        List<BlogEntry> list = service.list(queryBean);

        assertThat(list.size(), is(5));
        assertThat(list.get(0).getTitle(), is("title9"));
    }

    @Test
    public void コーナー名抽出() throws Exception {
        Set<String> set =
            service
                .findCorners("あああ\\n[/corner/テスト] テスト\\n[/corner/テスト２] テスト２\\n"
                    + "[/member/だいし] だいし\\n[aaa]");

        assertThat(set.contains("テスト"), is(true));
        assertThat(set.contains("テスト２"), is(true));
        assertThat(set.size(), is(2));
    }

    @Test
    public void メンバー名抽出() throws Exception {
        Set<String> set =
            service
                .findPersonalities("あああ\\n[/corner/テスト] テスト\\n[/corner/テスト２] テスト２\\n"
                    + "[/member/だいし] だいし\\n[aaa]");

        assertThat(set.contains("だいし"), is(true));
        assertThat(set.size(), is(1));
    }

}
