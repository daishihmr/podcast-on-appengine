package net.hmrradio.podcastsite.model;

import org.slim3.tester.AppEngineTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class LinkTest extends AppEngineTestCase {

    private Link model = new Link();

    @Test
    public void test() throws Exception {
        assertThat(model, is(notNullValue()));
    }
}
