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
            WikiUtil.toHtml("[/member/だいし]"),
            is("<p><a href=\"/member/だいし\">だいし</a></p>"));
    }

    @Test
    public void member2() {
        assertThat(
            WikiUtil.toHtml("さっき[/member/だいし1]と[/member/だいし2]が[/member/だいし3]を殴ってた"),
            is("<p>さっき<a href=\"/member/だいし1\">だいし1</a>と"
                + "<a href=\"/member/だいし2\">だいし2</a>が"
                + "<a href=\"/member/だいし3\">だいし3</a>を殴ってた</p>"));
    }

    @Test
    public void corner() {
        assertThat(
            WikiUtil.toHtml("[/corner/だいし]"),
            is("<p><a href=\"/corner/だいし\">だいし</a></p>"));
    }

    @Test
    public void corner2() {
        assertThat(
            WikiUtil.toHtml("さっき[/corner/だいし1]と[/corner/だいし2]が[/corner/だいし3]を殴ってた"),
            is("<p>さっき<a href=\"/corner/だいし1\">だいし1</a>と"
                + "<a href=\"/corner/だいし2\">だいし2</a>が"
                + "<a href=\"/corner/だいし3\">だいし3</a>を殴ってた</p>"));
    }

    @Test
    public void both() {
        assertThat(WikiUtil.toHtml("さっき[/corner/だいし1]で"
            + "[/member/だいし2]と"
            + "[/member/だいし3]が"
            + "[/member/だいし4]を殴ってた"
            + "[/corner/だいし5]"), is("<p>さっき<a href=\"/corner/だいし1\">だいし1</a>で"
            + "<a href=\"/member/だいし2\">だいし2</a>と"
            + "<a href=\"/member/だいし3\">だいし3</a>が"
            + "<a href=\"/member/だいし4\">だいし4</a>を殴ってた"
            + "<a href=\"/corner/だいし5\">だいし5</a></p>"));
    }

    @Test
    public void alink() {
        assertThat(
            WikiUtil.toHtml("[http://www.google.co.jp g]"),
            is("<p>"
                + "<a href=\"http://www.google.co.jp\" target=\"_blank\">g</a></p>"));
    }

}
