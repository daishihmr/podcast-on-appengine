package net.hmrradio.podcastsite.util;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.arnx.jsonic.JSON;

import org.slim3.util.StringUtil;

import com.google.appengine.repackaged.com.google.common.collect.Maps;
import com.google.template.soy.SoyFileSet;
import com.google.template.soy.jssrc.SoyJsSrcOptions;
import com.google.template.soy.msgs.SoyMsgBundle;
import com.google.template.soy.tofu.SoyTofu;
import com.google.template.soy.tofu.SoyTofuException;

public class SoyUtil {

    private SoyUtil() {
        // 使用不可
    }

    private static SoyTofu getTofu() {
        return (new SoyFileSet.Builder())
            .add(new File("soy/template.soy"))
            .build()
            .compileToJavaObj();
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

        StringBuffer sb = new StringBuffer();
        sb.append(getTofu().render(namespace + "." + template, data, null));
        try {
            StringBuffer asb = new StringBuffer();
            asb.append("<script type=\"text/javascript\">");
            asb.append(getTofu().render(
                namespace + "." + "after" + StringUtil.capitalize(template),
                data,
                null));
            asb.append("</script>");
            sb.append(asb);
        } catch (SoyTofuException e) {
        }

        return sb.toString();
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
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
