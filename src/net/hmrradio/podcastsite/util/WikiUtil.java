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
        StringBuffer sb = new StringBuffer(wiki);

        {
            Pattern p = Pattern.compile("\\[/member/(.+)\\]");

            Matcher m;
            // while ((m = p.matcher(sb)).matches()) {
            // System.out.println(m.group(1));
            // sb.replace(
            // m.regionStart(),
            // m.regionEnd(),
            // String.format("[/member/%s %s]", m.group(1), m.group(1)));
            // }
        }

        {
            Pattern p = Pattern.compile("\\[/corner/(\\S+)\\]");

            Matcher m;
            while ((m = p.matcher(sb)).matches()) {
                sb.replace(
                    m.regionStart(),
                    m.regionEnd(),
                    String.format("[/corner/%s %s]", m.group(1), m.group(1)));
            }
        }
        StringWriter out = new StringWriter();

        HtmlDocumentBuilder builder = new HtmlDocumentBuilder(out);
        builder.setEmitAsDocument(false);

        MarkupParser parser = new MarkupParser(new TracWikiDialect());
        parser.setBuilder(builder);
        parser.parse(sb.toString());

        return out.toString();
    }

}
