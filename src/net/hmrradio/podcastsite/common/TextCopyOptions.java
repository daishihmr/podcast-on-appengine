package net.hmrradio.podcastsite.common;

import org.slim3.util.Converter;
import org.slim3.util.CopyOptions;

import com.google.appengine.api.datastore.Text;

public class TextCopyOptions extends CopyOptions {

    public TextCopyOptions(String... propertyNames) {
        super();
        this.converter(new Converter<Text>() {

            public Text getAsObject(String value) {
                return new Text(value);
            }

            public String getAsString(Object value) {
                return value.toString();
            }

            public boolean isTarget(Class<?> clazz) {
                return clazz == Text.class;
            }

        }, propertyNames);
    }
}
