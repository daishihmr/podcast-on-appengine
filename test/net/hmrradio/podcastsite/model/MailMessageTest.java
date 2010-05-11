package net.hmrradio.podcastsite.model;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class MailMessageTest {

    private MailMessage model = new MailMessage();

    @Test
    public void test() throws Exception {
        assertThat(model, is(notNullValue()));
    }
}
