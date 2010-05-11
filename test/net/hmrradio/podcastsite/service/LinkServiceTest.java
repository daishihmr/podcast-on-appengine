package net.hmrradio.podcastsite.service;

import org.slim3.tester.AppEngineTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class LinkServiceTest extends AppEngineTestCase {

    private LinkService service = new LinkService();

    @Test
    public void test() throws Exception {
        assertThat(service, is(notNullValue()));
    }
}
