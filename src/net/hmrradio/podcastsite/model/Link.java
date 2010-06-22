package net.hmrradio.podcastsite.model;

import java.io.Serializable;

import net.arnx.jsonic.JSONHint;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.Model;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.Text;

@Model(schemaVersion = 1)
public class Link extends AbstractModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Attribute(primaryKey = true)
    private Key key;

    @Attribute(version = true)
    private Long version;

    /** URL */
    @Attribute
    private String url;

    /** タイトル */
    @Attribute
    private String title;

    /** 説明 */
    @Attribute
    private Text text;

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Link other = (Link) obj;
        if (key == null) {
            if (other.key != null) {
                return false;
            }
        } else if (!key.equals(other.key)) {
            return false;
        }
        return true;
    }

    @JSONHint(ignore = true)
    public Key getKey() {
        return key;
    }

    @Override
    public String getKeyString() {
        return keyToString(key);
    }

    @JSONHint(ignore = true)
    public Text getText() {
        return text;
    }

    public String getTextString() {
        if (text == null) {
            return "";
        } else {
            return text.getValue();
        }
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    @JSONHint(ignore = true)
    public Long getVersion() {
        return version;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((key == null) ? 0 : key.hashCode());
        return result;
    }

    public void setKey(Key key) {
        this.key = key;
    }

    public void setText(Text text) {
        this.text = text;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

}
