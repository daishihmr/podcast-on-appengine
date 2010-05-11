package net.hmrradio.podcastsite.controller;

import java.util.List;
import java.util.Map;

import net.hmrradio.podcastsite.model.BlogEntry;
import net.hmrradio.podcastsite.service.BlogEntryService;

import org.slim3.controller.Navigation;

import com.google.appengine.repackaged.com.google.common.collect.Maps;

public class TagListController extends BaseController {

    private BlogEntryService service = new BlogEntryService();

    @Override
    protected Navigation exec() throws Exception {
        List<BlogEntry> entries = service.list();
        Map<String, Integer> map = Maps.newHashMap();
        for (BlogEntry entry : entries) {
            for (String tag : entry.getTags()) {
                int i = 8;
                if (map.containsKey(tag)) {
                    i = map.get(tag);
                }
                i++;
                map.put(tag, Math.min(i, 24));
            }
        }
        requestScope("map", map);

        return forward("/dialog/tagList.jsp");
    }

}
