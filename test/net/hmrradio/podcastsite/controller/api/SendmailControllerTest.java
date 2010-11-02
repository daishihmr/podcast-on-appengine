package net.hmrradio.podcastsite.controller.api;

import static net.hmrradio.podcastsite.define.AttrName.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import net.hmrradio.podcastsite.bean.ResultBean;
import net.hmrradio.podcastsite.meta.MailMessageMeta;
import net.hmrradio.podcastsite.model.MailMessage;

import org.junit.Test;
import org.slim3.datastore.Datastore;
import org.slim3.tester.ControllerTestCase;

public class SendmailControllerTest extends ControllerTestCase {

    @Test
    public void run() throws Exception {
        tester.param("name", "名前");
        tester
            .param("mailAddress", "mailaddress-aaa-bbb-ccc-ddd@mail.test.org");
        tester.param("content", "本文本文本文本文本文本文本文本文本文本文本文本文本文本文本文本文本文本文本文");

        tester.start("/api/sendmail");
        SendmailController controller = tester.getController();
        assertThat(controller, is(notNullValue()));
        assertThat(tester.isRedirect(), is(false));
        assertThat(tester.getDestinationPath(), is(nullValue()));

        MailMessageMeta m = MailMessageMeta.get();
        int count =
            Datastore
                .query(MailMessage.class)
                .filter(m.name.equal("名前"))
                .count();
        assertThat(count, is(1));

        MailMessage mail =
            Datastore
                .query(MailMessage.class)
                .filter(m.name.equal("名前"))
                .asSingle();
        assertThat(
            mail.getMailAddress(),
            is("mailaddress-aaa-bbb-ccc-ddd@mail.test.org"));
        assertThat(
            mail.getContent(),
            is("本文本文本文本文本文本文本文本文本文本文本文本文本文本文本文本文本文本文本文"));

        System.out.println(mail.getSendDate());

    }

    @Test
    public void validate() throws Exception {
        tester.param("name", "1234567890123456789012345678901");
        tester.param("mailAddress", "");
        tester.param("content", "");

        tester.start("/api/sendmail");

        ResultBean result = tester.requestScope(RESULT_JSON);
        assertThat(result.isSuccess(), is(false));
        assertThat(result.getMessages().size(), is(2));
        assertThat(result.getMessages().get(0), is("名前の長さが最大値(30)を超えています。"));
        assertThat(result.getMessages().get(1), is("本文は必須です。"));
    }
}
