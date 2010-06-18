package net.hmrradio.podcastsite.util;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class WikiUtilTest {

    @Test
    public void test() {
        String r = WikiUtil.toHtml("=a=");
        assertThat(r, is("<h1>a</h1>"));
    }
}
