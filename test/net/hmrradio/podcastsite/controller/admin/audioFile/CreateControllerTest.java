package net.hmrradio.podcastsite.controller.admin.audioFile;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import net.hmrradio.podcastsite.bean.ResultBean;
import net.hmrradio.podcastsite.define.AttrName;
import net.hmrradio.podcastsite.model.AudioFile;

import org.junit.Test;
import org.slim3.datastore.Datastore;
import org.slim3.tester.ControllerTestCase;

import com.google.appengine.api.datastore.Query.FilterOperator;

public class CreateControllerTest extends ControllerTestCase {

    @Test
    public void run() throws Exception {
        tester.start("/admin/audioFile/create");
        CreateController controller = tester.getController();
        assertThat(controller, is(notNullValue()));
        assertThat(tester.isRedirect(), is(false));
        assertThat(tester.getDestinationPath(), is("/json.jsp"));
    }

    @Test
    public void testCreate() throws Exception {
        tester.param("url", "test://test/test.mp3");
        tester.param("duration", "11:11");
        tester.param("length", "123456789");
        tester.param("type", "audio/mpeg");
        tester.request.setMethod("POST");
        tester.start("/admin/audioFile/create");

        CreateController controller = tester.getController();
        assertThat(controller, is(notNullValue()));
        assertThat(tester.getDestinationPath(), is("/json.jsp"));

        ResultBean srb = tester.requestScope(AttrName.RESULT_JSON);
        assertThat(srb.getBody(), is(notNullValue()));
        assertThat(srb.getBody(), is(AudioFile.class));
        AudioFile responseAudio = srb.getBody();

        AudioFile storedAudio =
            Datastore.query(AudioFile.class).filter(
                "url",
                FilterOperator.EQUAL,
                "test://test/test.mp3").asSingle();
        assertThat(storedAudio, is(notNullValue()));
        assertThat(storedAudio.getDuration(), is("11:11"));

        assertThat(responseAudio, is(storedAudio));
    }
}
