package net.hmrradio.podcastsite.util;

import org.junit.Test;

public class WikiUtilTest {

    @Test
    public void test() {
        String r = WikiUtil.parse("= a =");
        System.out.println(r);
    }
}
