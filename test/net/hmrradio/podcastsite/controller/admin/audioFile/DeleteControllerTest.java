package net.hmrradio.podcastsite.controller.admin.audioFile;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import net.hmrradio.podcastsite.bean.ResultBean;
import net.hmrradio.podcastsite.define.AttrName;

import org.junit.Test;
import org.slim3.tester.ControllerTestCase;

public class DeleteControllerTest extends ControllerTestCase {

    @Test
    public void run() throws Exception {
        tester.start("/admin/audioFile/delete");
        DeleteController controller = tester.getController();
        assertThat(controller, is(notNullValue()));
        assertThat(tester.isRedirect(), is(false));
        assertThat(tester.getDestinationPath(), is("/json.jsp"));
    }

    @Test
    public void testAlreadyDeleted() throws Exception {
        tester.param("url", "zzzzzzz");
        tester.start("/admin/audioFile/delete");

        Object result = tester.request.getAttribute(AttrName.RESULT_JSON);
        assertThat(result, is(ResultBean.class));

        ResultBean b = (ResultBean) result;
        assertThat(b.getMessages().get(0), is("データが見つかりません。"));

        assertThat(tester.getDestinationPath(), is("/json.jsp"));
    }
}
