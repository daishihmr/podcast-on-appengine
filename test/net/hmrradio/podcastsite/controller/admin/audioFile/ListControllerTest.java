package net.hmrradio.podcastsite.controller.admin.audioFile;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import net.hmrradio.podcastsite.bean.ResultBean;
import net.hmrradio.podcastsite.define.AttrName;
import net.hmrradio.podcastsite.model.AudioFile;

import org.junit.Test;
import org.slim3.datastore.Datastore;
import org.slim3.tester.ControllerTestCase;
import org.slim3.util.DateUtil;

public class ListControllerTest extends ControllerTestCase {

    @Test
    public void run() throws Exception {
        tester.start("/admin/audioFile/list");
        ListController controller = tester.getController();
        assertThat(controller, is(notNullValue()));
        assertThat(tester.isRedirect(), is(false));
        assertThat(tester.getDestinationPath(), is("/json.jsp"));
    }

    @Test
    public void testList() throws Exception {
        AudioFile a;
        for (int i = 1; i <= 9; i++) {
            a = new AudioFile();
            a.setUrl("test1");
            a.setDuration("00:01");
            a.setLength(1L);
            a.setType("audio/mpeg");
            Date entryDate =
                DateUtil.toDate("2010030" + i + "000000", "yyyyMMddHHmmss");
            a.setEntryDate(entryDate);

            Datastore.put(a);
        }

        tester.param("min", "2010/03/03 00:00:00");
        tester.param("max", "2010/03/06 23:59:59");
        tester.start("/admin/audioFile/list");

        ResultBean srb = tester.requestScope(AttrName.RESULT_JSON);
        List<AudioFile> list = srb.getBody();
        assertThat(list.size(), is(4));
    }

    @Test
    public void testList2() throws Exception {
        AudioFile a;
        for (int i = 1; i <= 9; i++) {
            a = new AudioFile();
            a.setUrl("test1");
            a.setDuration("00:01");
            a.setLength(1L);
            a.setType("audio/mpeg");
            Date entryDate =
                DateUtil.toDate("2010030" + i + "000000", "yyyyMMddHHmmss");
            a.setEntryDate(entryDate);

            Datastore.put(a);
        }

        tester.start("/admin/audioFile/list");

        ResultBean srb = tester.requestScope(AttrName.RESULT_JSON);
        List<AudioFile> list = srb.getBody();
        assertThat(list.size(), is(9));
    }

    @Test
    public void testList3() throws Exception {
        AudioFile a;
        for (int i = 1; i <= 9; i++) {
            a = new AudioFile();
            a.setUrl("test1");
            a.setDuration("00:01");
            a.setLength(1L);
            a.setType("audio/mpeg");
            Date entryDate =
                DateUtil.toDate("2010030" + i + "000000", "yyyyMMddHHmmss");
            a.setEntryDate(entryDate);

            Datastore.put(a);
        }

        tester.param("max", "2010/03/06 23:59:59");
        tester.start("/admin/audioFile/list");

        ResultBean srb = tester.requestScope(AttrName.RESULT_JSON);
        List<AudioFile> list = srb.getBody();
        assertThat(list.size(), is(6));
    }

    @Test
    public void testList4() throws Exception {
        AudioFile a;
        for (int i = 1; i <= 9; i++) {
            a = new AudioFile();
            a.setUrl("test1");
            a.setDuration("00:01");
            a.setLength(1L);
            a.setType("audio/mpeg");
            Date entryDate =
                DateUtil.toDate("2010030" + i + "000000", "yyyyMMddHHmmss");
            a.setEntryDate(entryDate);

            Datastore.put(a);
        }

        tester.param("min", "2010/03/05 00:00:00");
        tester.start("/admin/audioFile/list");

        ResultBean srb = tester.requestScope(AttrName.RESULT_JSON);
        List<AudioFile> list = srb.getBody();
        assertThat(list.size(), is(5));
    }

}
