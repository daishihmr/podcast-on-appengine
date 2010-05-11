package net.hmrradio.podcastsite.model;

import java.io.Serializable;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

public abstract class AbstractModel implements Serializable {
    private static final long serialVersionUID = 1L;

    public abstract String getKeyString();

    protected String keyToString(Key key) {
        return KeyFactory.keyToString(key);
    }

    public void setKeyString(String key) {
        // no op
    }
}
