package net.hmrradio.podcastsite.util;

import java.io.StringWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.java.textilej.parser.MarkupParser;
import net.java.textilej.parser.builder.HtmlDocumentBuilder;
import net.java.textilej.parser.markup.trac.TracWikiDialect;

import com.google.appengine.api.datastore.Text;

public final class WikiUtil {

    private WikiUtil() {
    }

    public static Text parse(Text wiki) {
        if (wiki == null) {
            return new Text("");
        }
        return new Text(toHtml(wiki.getValue()));
    }

    public static String toHtml(String wiki) {
        if (wiki == null) {
            return "";
        }

        wiki = convertLink(wiki, "member");
        wiki = convertLink(wiki, "corner");

        StringWriter out = new StringWriter();

        HtmlDocumentBuilder builder = new HtmlDocumentBuilder(out);
        builder.setDefaultAbsoluteLinkTarget("_blank");
        builder.setEmitAsDocument(false);

        MarkupParser parser = new MarkupParser(new TracWikiDialect());
        parser.setBuilder(builder);
        parser.parse(wiki);

        return out.toString();
    }

    private static String convertLink(String src, String folder) {
        StringBuffer sb = new StringBuffer();
        Pattern p = Pattern.compile("(\\[/" + folder + "/([^ \\]]+)\\])");

        Matcher m = p.matcher(src);
        int i = 0;
        for (i = 0; m.find(i); i = m.end()) {
            sb.append(src.substring(i, m.start()));
            sb.append(String.format(
                "[/" + folder + "/%s %s]",
                m.group(2),
                m.group(2)));
        }
        sb.append(src.substring(i));
        return sb.toString();
    }

}
