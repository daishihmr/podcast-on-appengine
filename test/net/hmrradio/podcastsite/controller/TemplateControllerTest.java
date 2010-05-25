package net.hmrradio.podcastsite.controller;

import java.io.File;

import org.junit.Test;
import org.slim3.tester.ControllerTestCase;

import com.google.template.soy.SoyFileSet;
import com.google.template.soy.data.SoyMapData;
import com.google.template.soy.tofu.SoyTofu;

public class TemplateControllerTest extends ControllerTestCase {

    @Test
    public void run() throws Exception {
        File f = new File(".");
        System.out.println(f.getCanonicalPath());
        SoyFileSet sfs =
            (new SoyFileSet.Builder())
                .add(new File("war/soy/test.soy"))
                .build();
        SoyTofu tofu = sfs.compileToJavaObj();
        String s = tofu.render("test.test", (SoyMapData) null, null);
        System.out.println(s);
    }
}
