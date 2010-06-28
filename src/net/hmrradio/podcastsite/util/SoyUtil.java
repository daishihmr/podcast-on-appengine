package net.hmrradio.podcastsite.util;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.arnx.jsonic.JSON;

import com.google.appengine.repackaged.com.google.common.collect.Maps;
import com.google.template.soy.SoyFileSet;
import com.google.template.soy.jssrc.SoyJsSrcOptions;
import com.google.template.soy.msgs.SoyMsgBundle;
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
        // 使用不可
    }

    public static String render(String namespace, String template, Object arg) {
        return render(namespace, template, arg, arg);
    }

    @SuppressWarnings("unchecked")
    public static String render(String namespace, String template,
            Object mainArg, Object afterArg) {
        mainArg = wrapCollection(mainArg);
        afterArg = wrapCollection(afterArg);

        Map<String, ?> data;
        if (mainArg != null) {
            data = JSON.decode(JSON.encode(mainArg), Map.class);
        } else {
            data = null;
        }

        return tofu.render(template, data, null);
    }

    @SuppressWarnings("unchecked")
    private static Object wrapCollection(Object o) {
        if (o instanceof List || o instanceof Set || o instanceof Object[]) {
            Map map = Maps.newHashMap();
            map.put("list", o);
            return map;
        } else {
            return o;
        }
    }

    public static String generateJs() {
        SoyJsSrcOptions opt = new SoyJsSrcOptions();
        SoyMsgBundle bundle = null;
        List<String> jsSrc =
            (new SoyFileSet.Builder())
                .add(new File("soy/template.soy"))
                .build()
                .compileToJsSrc(opt, bundle);

        StringBuffer result = new StringBuffer();
        for (String line : jsSrc) {
            result.append(line + "\n");
        }
        return result.toString();
    }
}
