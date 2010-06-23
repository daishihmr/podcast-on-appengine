package net.hmrradio.podcastsite.util;

import java.io.File;
import java.util.Map;

import net.arnx.jsonic.JSON;

import com.google.template.soy.SoyFileSet;
import com.google.template.soy.tofu.SoyTofu;

public class SoyUtil {

    private static SoyTofu tofu;
    static {
        tofu =
            (new SoyFileSet.Builder())
                .add(new File("soy/template.soy"))
                .build()
                .compileToJavaObj();
    }

    private SoyUtil() {
        // util
    }

    @SuppressWarnings("unchecked")
    public static String render(String template, Object object) {
        Map data = JSON.decode(JSON.encode(object), Map.class);
        return tofu.render(
            "net.hmrradio.podcastsite.templates." + template,
            data,
            null);
    }
}
