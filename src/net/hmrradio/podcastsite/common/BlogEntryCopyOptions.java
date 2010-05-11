package net.hmrradio.podcastsite.common;

import java.util.Set;

import net.hmrradio.podcastsite.meta.BlogEntryMeta;

import org.slim3.util.Converter;
import org.slim3.util.CopyOptions;
import org.slim3.util.StringUtil;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.Text;
import com.google.appengine.repackaged.com.google.common.collect.Sets;

public class BlogEntryCopyOptions extends CopyOptions {

    private BlogEntryMeta b = BlogEntryMeta.get();

    public BlogEntryCopyOptions() {
        super();

        dateConverter("yyyy/MM/dd", b.recordingDate);

        converter(new Converter<Text>() {
            public Text getAsObject(String value) {
                return new Text(value);
            }

            public String getAsString(Object value) {
                return value.toString();
            }

            public boolean isTarget(Class<?> clazz) {
                return clazz == Text.class;
            }
        }, "content");

        converter(new Converter<Set<String>>() {
            public Set<String> getAsObject(String value) {
                String[] splited = value.split(",");
                Set<String> result = Sets.newHashSet();
                for (String tag : splited) {
                    if (!StringUtil.isEmpty(tag)) {
                        result.add(tag.trim());
                    }
                }
                return result;
            }

            public String getAsString(Object value) {
                return value.toString();
            }

            public boolean isTarget(Class<?> clazz) {
                return Set.class == clazz;
            }
        }, b.tags);

        converter(new Converter<Key>() {

            public Key getAsObject(String value) {
                if (StringUtil.isEmpty(value)) {
                    return null;
                } else {
                    return KeyFactory.stringToKey(value);
                }
            }

            public String getAsString(Object value) {
                if (value == null) {
                    return "null";
                } else if (value instanceof Key) {
                    return KeyFactory.keyToString((Key) value);
                } else {
                    return value.toString();
                }
            }

            public boolean isTarget(Class<?> clazz) {
                return Key.class == clazz;
            }
        }, b.key);
    }
}
