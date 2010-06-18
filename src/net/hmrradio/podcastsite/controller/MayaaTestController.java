package net.hmrradio.podcastsite.controller;

import java.util.List;
import java.util.Map;

import net.arnx.jsonic.JSON;
import net.hmrradio.podcastsite.model.BlogEntry;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.datastore.Datastore;

import com.google.appengine.repackaged.com.google.common.collect.Maps;

public class MayaaTestController extends Controller {

    @Override
    protected Navigation run() throws Exception {
        List<BlogEntry> list = Datastore.query(BlogEntry.class).asList();
        BlogEntry e = list.get(0);
        for (int i = 0; i < 100; i++) {
            list.add(e);
        }

        Map<String, Object> result = Maps.newHashMap();
        result.put("episodes", list);
        requestScope("result", JSON.encode(result));

        return forward("mayaa-test.html");
    }

}
