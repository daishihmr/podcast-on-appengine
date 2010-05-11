package net.hmrradio.podcastsite.service;

import org.slim3.tester.AppEngineTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class ImageFileServiceTest extends AppEngineTestCase {

    private ImageFileService service = new ImageFileService();

    @Test
    public void test() throws Exception {
        assertThat(service, is(notNullValue()));
    }
}
