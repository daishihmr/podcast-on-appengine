package net.hmrradio.podcastsite.util;

import java.io.StringWriter;

import net.java.textilej.parser.MarkupParser;
import net.java.textilej.parser.builder.HtmlDocumentBuilder;
import net.java.textilej.parser.markup.trac.TracWikiDialect;

import com.google.appengine.api.datastore.Text;

public class WikiUtil {

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
        StringWriter out = new StringWriter();

        HtmlDocumentBuilder builder = new HtmlDocumentBuilder(out);
        builder.setEmitAsDocument(false);

        MarkupParser parser = new MarkupParser(new TracWikiDialect());
        parser.setBuilder(builder);
        parser.parse(wiki);

        return out.toString();
    }

}
