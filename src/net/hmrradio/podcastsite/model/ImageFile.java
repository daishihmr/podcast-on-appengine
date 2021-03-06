package net.hmrradio.podcastsite.model;

import java.io.Serializable;
import java.util.Date;

import net.arnx.jsonic.JSONHint;
import net.hmrradio.podcastsite.meta.ImageFileFragmentMeta;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.InverseModelListRef;
import org.slim3.datastore.Model;
import org.slim3.datastore.Sort;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

@Model(schemaVersion = 1)
public class ImageFile implements Serializable {

    private static final long serialVersionUID = 1L;

    @Attribute(primaryKey = true)
    private Key key;

    @Attribute(version = true)
    private Long version;

    private String fileName;

    private int length;

    private Date updateAt;

    /**
     * @return the fileName
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * @param fileName
     *            the fileName to set
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * @return the length
     */
    public int getLength() {
        return length;
    }

    /**
     * @param length
     *            the length to set
     */
    public void setLength(int length) {
        this.length = length;
    }

    /**
     * @return the fragmentListRef
     */
    public InverseModelListRef<ImageFileFragment, ImageFile> getFragmentListRef() {
        return fragmentListRef;
    }

    @Attribute(persistent = false)
    private InverseModelListRef<ImageFileFragment, ImageFile> fragmentListRef =
        new InverseModelListRef<ImageFileFragment, ImageFile>(
            ImageFileFragment.class,
            ImageFileFragmentMeta.get().imageDataRef,
            this,
            new Sort(ImageFileFragmentMeta.get().index));

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
        ImageFile other = (ImageFile) obj;
        if (key == null) {
            if (other.key != null) {
                return false;
            }
        } else if (!key.equals(other.key)) {
            return false;
        }
        return true;
    }

    public String getKeyString() {
        if (key == null) {
            return "";
        }
        return KeyFactory.keyToString(key);
    }

    /**
     * @return the updateAt
     */
    public Date getUpdateAt() {
        return updateAt;
    }

    /**
     * @param updateAt
     *            the updateAt to set
     */
    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }
}
