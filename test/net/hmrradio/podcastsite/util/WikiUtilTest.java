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

    @Test
    public void member() {
        assertThat(
            WikiUtil.toHtml("[/member/daishi]"),
            is("<p><a href=\"/member/daishi\">daishi</a></p>"));
    }

    @Test
    public void member2() {
        assertThat(
            WikiUtil.toHtml("[/member/daishi1][/member/daishi2][/member/daishi3]"),
            is("<p><a href=\"/member/daishi1\">daishi1</a>"
                + "<a href=\"/member/daishi2\">daishi2</a>"
                + "<a href=\"/member/daishi3\">daishi3</a></p>"));
    }

    @Test
    public void corner() {
        assertThat(
            WikiUtil.toHtml("[/corner/daishi]"),
            is("<p><a href=\"/corner/daishi\">daishi</a></p>"));
    }
}
