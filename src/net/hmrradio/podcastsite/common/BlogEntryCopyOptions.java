package net.hmrradio.podcastsite.common;

import java.util.Date;

import net.hmrradio.podcastsite.meta.BlogEntryMeta;

import org.slim3.util.Converter;
import org.slim3.util.StringUtil;

public class BlogEntryCopyOptions extends CopyOptions {

    private BlogEntryMeta b = BlogEntryMeta.get();

    public BlogEntryCopyOptions() {
        super();

        keyConverter(b.key);

        converter(new Converter<Date>() {

            @Override
            public String getAsString(Object value) {
                if (value == null) {
                    return "0";
                }
                return value.toString();
            }

            @Override
            public Date getAsObject(String value) {
                if (StringUtil.isEmpty(value)) {
                    return null;
                }
                long l = Long.parseLong(value);
                return new Date(l);
            }

            @Override
            public boolean isTarget(Class<?> clazz) {
                return Date.class == clazz;
            }
        }, b.createDate);

        converter(new Converter<Date>() {

            @Override
            public String getAsString(Object value) {
                if (value == null) {
                    return "0";
                }
                return value.toString();
            }

            @Override
            public Date getAsObject(String value) {
                if (StringUtil.isEmpty(value)) {
                    return null;
                }
                long l = Long.parseLong(value);
                return new Date(l);
            }

            @Override
            public boolean isTarget(Class<?> clazz) {
                return Date.class == clazz;
            }
        }, b.pubDate);

        dateConverter("yyyy/MM/dd", b.recordingDate);

        textConverter("content");

        setConverter(b.tags);
    }
}
