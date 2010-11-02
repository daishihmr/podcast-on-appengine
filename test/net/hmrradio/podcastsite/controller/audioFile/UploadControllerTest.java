package net.hmrradio.podcastsite.controller.audioFile;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Test;
import org.slim3.controller.validator.RegexpValidator;
import org.slim3.tester.ControllerTestCase;

import com.google.appengine.repackaged.com.google.common.collect.Maps;

public class UploadControllerTest extends ControllerTestCase {

    @Test
    public void run() throws Exception {
        tester.start("/audioFile/upload");
        UploadController controller = tester.getController();
        assertThat(controller, is(notNullValue()));
        assertThat(tester.isRedirect(), is(false));
        assertThat(tester.getDestinationPath(), is("/audioFile/complete.jsp"));
    }

    @Test
    public void regexp() {
        Map<String, Object> parameters = Maps.newHashMap();
        RegexpValidator v =
            new RegexpValidator("(\\d+:)?\\d?\\d:\\d\\d", "エラー");

        parameters.put("test", "3:10");
        assertThat(v.validate(parameters, "test"), not("エラー"));

        parameters.put("test", "03:10");
        assertThat(v.validate(parameters, "test"), not("エラー"));

        parameters.put("test", "2:03:10");
        assertThat(v.validate(parameters, "test"), not("エラー"));

        parameters.put("test", "100:03:10");
        assertThat(v.validate(parameters, "test"), not("エラー"));
    }
}
