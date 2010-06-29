package net.hmrradio.podcastsite.model;

import java.io.Serializable;

import net.arnx.jsonic.JSONHint;
import net.hmrradio.podcastsite.util.WikiUtil;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.Model;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.Text;

@Model(schemaVersion = 1)
public class Personality implements Serializable {

    private static final long serialVersionUID = 1L;

    @Attribute(primaryKey = true)
    private Key key;

    @Attribute(version = true)
    private Long version;

    /**
     * 名前
     */
    @Attribute
    private String name;

    /**
     * Twitter ID
     */
    @Attribute
    private String twitterId;

    /**
     * icon image key
     */
    @Attribute
    private String icon;

    /**
     * プロフィール
     */
    @Attribute
    private Text profile;

    /**
     * Returns the key.
     * 
     * @return the key
     */
    @JSONHint(ignore = true)
    public Key getKey() {
        return key;
    }

    /**
     * Sets the key.
     * 
     * @param key
     *            the key
     */
    @JSONHint(ignore = true)
    public void setKey(Key key) {
        this.key = key;
    }

    /**
     * Returns the version.
     * 
     * @return the version
     */
    @JSONHint(ignore = true)
    public Long getVersion() {
        return version;
    }

    /**
     * Sets the version.
     * 
     * @param version
     *            the version
     */
    @JSONHint(ignore = true)
    public void setVersion(Long version) {
        this.version = version;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((key == null) ? 0 : key.hashCode());
        return result;
    }

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
        Personality other = (Personality) obj;
        if (key == null) {
            if (other.key != null) {
                return false;
            }
        } else if (!key.equals(other.key)) {
            return false;
        }
        return true;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the profile
     */
    public Text getProfile() {
        return profile;
    }

    /**
     * @param profile
     *            the profile to set
     */
    public void setProfile(Text profile) {
        this.profile = profile;
    }

    /**
     * @return the twitterId
     */
    public String getTwitterId() {
        return twitterId;
    }

    /**
     * @param twitterId
     *            the twitterId to set
     */
    public void setTwitterId(String twitterId) {
        this.twitterId = twitterId;
    }

    public String getKeyString() {
        if (key == null) {
            return "";
        }
        return KeyFactory.keyToString(key);
    }

    public String getProfileHtml() {
        return WikiUtil.parse(profile).getValue();
    }

    /**
     * @return the icon
     */
    public String getIcon() {
        return icon;
    }

    /**
     * @param icon
     *            the icon to set
     */
    public void setIcon(String icon) {
        this.icon = icon;
    }

}
