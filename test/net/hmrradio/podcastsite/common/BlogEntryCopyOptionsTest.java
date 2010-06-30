package net.hmrradio.podcastsite.common;

import org.junit.Test;

public class BlogEntryCopyOptionsTest {

    @Test
    public void testTrim() throws Exception {
        String tags = "タグ１,   タグ２,    タグ３";

        String[] s = tags.split(",");
        for (String t : s) {
            System.out.println("[" + t.trim() + "]");
        }
    }
}
