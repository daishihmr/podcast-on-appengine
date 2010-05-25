package net.hmrradio.podcastsite.controller.bbs;

import java.util.List;

import net.hmrradio.podcastsite.controller.BaseController;
import net.hmrradio.podcastsite.model.BlogEntry;

import org.slim3.controller.Navigation;

import com.google.appengine.api.datastore.Text;
import com.google.common.collect.Lists;

public class IndexController extends BaseController {

    @Override
    protected Navigation exec() throws Exception {
        List<BlogEntry> list = Lists.newArrayList();
        for (int i = 0; i < 10; i++) {
            BlogEntry b = new BlogEntry();
            b.setTitle("title" + i);
            b.setContent(new Text("content" + i));
            list.add(b);
        }
        requestScope("list", list);
        return forward("index.jsp");
    }

}
