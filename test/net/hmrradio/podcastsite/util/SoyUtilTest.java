package net.hmrradio.podcastsite.util;

import net.hmrradio.podcastsite.define.Values;
import net.hmrradio.podcastsite.model.Link;
import net.hmrradio.podcastsite.service.LinkService;

import org.junit.Test;
import org.slim3.datastore.Datastore;
import org.slim3.tester.AppEngineTestCase;

import com.google.appengine.api.datastore.Text;

public class SoyUtilTest extends AppEngineTestCase {

    private LinkService linkService = new LinkService();

    @Test
    public void testRender() throws Exception {
        Link link;
        for (int i = 0; i < 10; i++) {
            link = new Link();
            link.setUrl("http://www.google.co.jp");
            link.setTitle("ぐーぐる" + i);
            link.setText(new Text("ぐーぐる" + i));
            Datastore.put(link);
        }

        String result =
            SoyUtil.render(Values.SOY_NS, "showLinks", linkService.list());
        System.out.println(result);
    }

    @Test
    public void testJsSrc() throws Exception {
        System.out.println(SoyUtil.generateJs());
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testError() {
        Link[] linkArray = null;
        Object links = linkArray;
        System.out.println(links instanceof Object[]); // => true
        System.out.println(links instanceof Iterable); // => false
    }
}
