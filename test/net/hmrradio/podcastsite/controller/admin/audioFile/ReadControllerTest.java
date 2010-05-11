package net.hmrradio.podcastsite.controller.admin.audioFile;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import net.hmrradio.podcastsite.bean.ResultBean;
import net.hmrradio.podcastsite.define.AttrName;
import net.hmrradio.podcastsite.model.AudioFile;

import org.junit.Test;
import org.slim3.datastore.Datastore;
import org.slim3.tester.ControllerTestCase;

public class ReadControllerTest extends ControllerTestCase {

    @Test
    public void run() throws Exception {
        tester.start("/admin/audioFile/read");
        ReadController controller = tester.getController();
        assertThat(controller, is(notNullValue()));
        assertThat(tester.isRedirect(), is(false));
        assertThat(tester.getDestinationPath(), is("/json.jsp"));
    }

    @Test
    public void testReadNoData() throws Exception {
        tester.param("url", "xxxxx");
        tester.start("/admin/audioFile/read");

        Object o = tester.requestScope(AttrName.RESULT_JSON);
        assertThat(o, is(ResultBean.class));

        ResultBean result = (ResultBean) o;
        assertThat(result.getMessages().get(0), is("データが見つかりません。"));
    }

    @Test
    public void testReadSuccess() throws Exception {
        AudioFile audio = new AudioFile();
        audio.setUrl("test://test/test.mp3");
        audio.setDuration("11:11");
        audio.setLength(11111111L);
        audio.setType("audio/mpeg");
        Datastore.put(audio);

        tester.param("url", "test://test/test.mp3");
        tester.start("/admin/audioFile/read");

        ResultBean o = tester.requestScope(AttrName.RESULT_JSON);
        assertThat(o.getBody(), is(AudioFile.class));

        AudioFile result = (AudioFile) o.getBody();
        assertThat(result.getType(), is("audio/mpeg"));
        assertThat(result.getLength(), is(11111111L));
    }
}
