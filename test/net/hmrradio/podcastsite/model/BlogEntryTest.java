package net.hmrradio.podcastsite.model;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;
import org.slim3.tester.AppEngineTestCase;

public class BlogEntryTest extends AppEngineTestCase {

    private BlogEntry model = new BlogEntry();

    @Test
    public void test() throws Exception {
        assertThat(model, is(notNullValue()));
    }

}
