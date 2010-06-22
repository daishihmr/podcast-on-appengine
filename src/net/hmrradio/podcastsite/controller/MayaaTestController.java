package net.hmrradio.podcastsite.controller;

import java.util.Map;

import net.arnx.jsonic.JSON;
import net.hmrradio.podcastsite.model.Link;
import net.hmrradio.podcastsite.service.BlogEntryService;
import net.hmrradio.podcastsite.service.LinkService;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.datastore.Datastore;

import com.google.appengine.api.datastore.Text;
import com.google.appengine.repackaged.com.google.common.collect.Maps;

public class MayaaTestController extends Controller {

    private BlogEntryService blogEntryService = new BlogEntryService();
    private LinkService linkService = new LinkService();

    @Override
    protected Navigation run() throws Exception {
        Link l = new Link();
        l.setTitle("テスト");
        l.setUrl("http://test.com");
        l.setText(new Text("テストです。"));
        Datastore.put(l);

        Map<String, Object> blogEntriesJson = Maps.newHashMap();
        blogEntriesJson.put("blogEntries", blogEntryService.list());
        requestScope("blogEntriesJson", JSON.encode(blogEntriesJson));

        // リンク集
        Map<String, Object> linksJson = Maps.newHashMap();
        linksJson.put("links", linkService.list());
        requestScope("linksJson", JSON.encode(linksJson));

        return forward("mayaa-test.html");
    }

}
