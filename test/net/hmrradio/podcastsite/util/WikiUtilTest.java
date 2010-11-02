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
            WikiUtil.toHtml("さっき[/member/daishi1]と[/member/daishi2]が[/member/daishi3]を殴ってた"),
            is("<p>さっき<a href=\"/member/daishi1\">daishi1</a>と"
                + "<a href=\"/member/daishi2\">daishi2</a>が"
                + "<a href=\"/member/daishi3\">daishi3</a>を殴ってた</p>"));
    }

    @Test
    public void corner() {
        assertThat(
            WikiUtil.toHtml("[/corner/daishi]"),
            is("<p><a href=\"/corner/daishi\">daishi</a></p>"));
    }

    @Test
    public void corner2() {
        assertThat(
            WikiUtil.toHtml("さっき[/corner/daishi1]と[/corner/daishi2]が[/corner/daishi3]を殴ってた"),
            is("<p>さっき<a href=\"/corner/daishi1\">daishi1</a>と"
                + "<a href=\"/corner/daishi2\">daishi2</a>が"
                + "<a href=\"/corner/daishi3\">daishi3</a>を殴ってた</p>"));
    }

    @Test
    public void both() {
        assertThat(
            WikiUtil.toHtml("さっき[/corner/daishi1]で"
                + "[/member/daishi2]と"
                + "[/member/daishi3]が"
                + "[/member/daishi4]を殴ってた"
                + "[/corner/daishi5]"),
            is("<p>さっき<a href=\"/corner/daishi1\">daishi1</a>で"
                + "<a href=\"/member/daishi2\">daishi2</a>と"
                + "<a href=\"/member/daishi3\">daishi3</a>が"
                + "<a href=\"/member/daishi4\">daishi4</a>を殴ってた"
                + "<a href=\"/corner/daishi5\">daishi5</a></p>"));
    }

}
