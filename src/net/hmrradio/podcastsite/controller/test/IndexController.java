package net.hmrradio.podcastsite.controller.test;

import java.util.List;

import net.hmrradio.podcastsite.model.BlogEntry;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.datastore.Datastore;

import com.google.appengine.api.datastore.Text;
import com.google.appengine.repackaged.com.google.common.collect.Lists;

public class IndexController extends Controller {

    @Override
    public Navigation run() throws Exception {

        List<BlogEntry> l = Lists.newArrayList();
        for (int i = 0; i < 5; i++) {
            BlogEntry b;
            b = new BlogEntry();
            b.setKey(Datastore.allocateId(BlogEntry.class));
            b.setTitle("タイトル" + i);
            b.setContent(new Text("=見出し=\n\n__あああ__\n\n[/member/daishi]"));
            l.add(b);
        }
        requestScope("result", l);
        return forward("index.jsp");
    }
}
