package net.hmrradio.podcastsite.common;

import net.hmrradio.podcastsite.meta.PersonalityMeta;

import org.slim3.util.Converter;
import org.slim3.util.CopyOptions;
import org.slim3.util.StringUtil;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.Text;

public class PersonalityCopyOptions extends CopyOptions {

    private PersonalityMeta p = PersonalityMeta.get();

    public PersonalityCopyOptions() {
        super();

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
        }, p.key);

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
        }, "profile");
    }
}
