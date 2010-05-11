package net.hmrradio.podcastsite.service;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;
import org.slim3.tester.AppEngineTestCase;

public class BlogEntryServiceTest extends AppEngineTestCase {

    private BlogEntryService service = new BlogEntryService();

    @Test
    public void test() throws Exception {
        assertThat(service, is(notNullValue()));
    }

}
