package net.hmrradio.podcastsite.controller;

import java.io.File;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

import com.google.template.soy.SoyFileSet;
import com.google.template.soy.data.SoyMapData;
import com.google.template.soy.tofu.SoyTofu;

public class TestController extends Controller {

    @Override
    public Navigation run() throws Exception {
        long c = System.currentTimeMillis();
        SoyFileSet sfs =
            (new SoyFileSet.Builder()).add(new File("soy/test.soy")).build();
        SoyTofu tofu = sfs.compileToJavaObj();

        requestScope("tofu", tofu.render("test.test", (SoyMapData) null, null));
        System.out.println(System.currentTimeMillis() - c);
        return forward("templateTest.jsp");
    }
}
