package net.hmrradio.podcastsite.common;

import java.util.Calendar;
import java.util.Date;
import java.util.Set;

import org.slim3.util.Converter;
import org.slim3.util.DateConverter;
import org.slim3.util.StringUtil;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.Text;
import com.google.appengine.repackaged.com.google.common.collect.Sets;

public class CopyOptions extends org.slim3.util.CopyOptions {

    /**
     * 「undefined」とか「null」は変換対象としないDateConverter.
     * 
     * @author daishi
     */
    protected class MyDateConverter extends DateConverter {

        public MyDateConverter(String pattern) throws NullPointerException {
            super(pattern);
        }

        @Override
        public Date getAsObject(String value) {
            if (StringUtil.isEmpty(value)
                || "undefined".equals(value)
                || "null".equals(value)) {
                return null;
            }
            Calendar cal = Calendar.getInstance();
            Date date = super.getAsObject(value);
            cal.setTime(date);
            return cal.getTime();
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.slim3.util.CopyOptions#dateConverter(java.lang.String,
     * java.lang.CharSequence[])
     */
    @Override
    public org.slim3.util.CopyOptions dateConverter(String pattern,
            CharSequence... propertyNames) {
        return converter(new MyDateConverter(pattern), propertyNames);
    }

    /**
     * String←→Text
     * 
     * @param propertyNames
     * @return
     */
    public org.slim3.util.CopyOptions textConverter(
            CharSequence... propertyNames) {
        return converter(new Converter<Text>() {

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

    /**
     * String←→Key
     * 
     * @param propertyNames
     * @return
     */
    public org.slim3.util.CopyOptions keyConverter(
            CharSequence... propertyNames) {
        return converter(new Converter<Key>() {

            public Key getAsObject(String value) {
                if (StringUtil.isEmpty(value)) {
                    return null;
                } else {
                    return KeyFactory.stringToKey(value);
                }
            }

            public String getAsString(Object value) {
                if (value == null) {
                    return "";
                } else if (value instanceof Key) {
                    return KeyFactory.keyToString((Key) value);
                } else {
                    return value.toString();
                }
            }

            public boolean isTarget(Class<?> clazz) {
                return Key.class == clazz;
            }

        }, propertyNames);
    }

    /**
     * カンマ区切りString←→Set
     * 
     * @param propertyNames
     * @return
     */
    public org.slim3.util.CopyOptions setConverter(
            CharSequence... propertyNames) {
        return converter(new Converter<Set<String>>() {

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

        }, propertyNames);
    }
}
