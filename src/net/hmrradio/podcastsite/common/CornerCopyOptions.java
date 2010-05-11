package net.hmrradio.podcastsite.common;

import net.hmrradio.podcastsite.meta.CornerMeta;

import org.slim3.util.Converter;
import org.slim3.util.CopyOptions;
import org.slim3.util.StringUtil;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.Text;

public class CornerCopyOptions extends CopyOptions {

    private CornerMeta c = CornerMeta.get();

    public CornerCopyOptions() {

        converter(new Converter<Key>() {
            public Key getAsObject(String value) {
                if (StringUtil.isEmpty(value)) {
                    return null;
                }
                return KeyFactory.stringToKey(value);
            }

            public String getAsString(Object value) {
                return value.toString();
            }

            public boolean isTarget(Class<?> clazz) {
                return Key.class == clazz;
            }
        }, c.key);

        converter(new Converter<Text>() {
            public Text getAsObject(String value) {
                if (StringUtil.isEmpty(value)) {
                    return null;
                }
                return new Text(value);
            }

            public String getAsString(Object value) {
                return value.toString();
            }

            public boolean isTarget(Class<?> clazz) {
                return Text.class == clazz;
            }
        }, "description");
    }
}
