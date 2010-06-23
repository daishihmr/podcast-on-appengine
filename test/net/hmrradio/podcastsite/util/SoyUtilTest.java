package net.hmrradio.podcastsite.util;

import java.util.Map;

import net.hmrradio.podcastsite.model.Link;
import net.hmrradio.podcastsite.service.LinkService;

import org.junit.Test;
import org.slim3.datastore.Datastore;
import org.slim3.tester.AppEngineTestCase;

import com.google.appengine.api.datastore.Text;
import com.google.appengine.repackaged.com.google.common.collect.Maps;

public class SoyUtilTest extends AppEngineTestCase {

    private LinkService linkService = new LinkService();

    @Test
    public void testRender() throws Exception {
        Link link;
        for (int i = 0; i < 10; i++) {
            link = new Link();
            link.setUrl("http://www.google.co.jp");
            link.setText(new Text("ぐーぐる" + i));
            Datastore.put(link);
        }

        Map<String, Object> links = Maps.newHashMap();
        links.put("links", linkService.list());
        String result = SoyUtil.render("showLinks", links);
        System.out.println(result);
    }

}
