package net.hmrradio.podcastsite.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import net.arnx.jsonic.JSONHint;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.Model;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.Text;
import com.google.appengine.repackaged.com.google.common.collect.Sets;

@Model(schemaVersion = 1)
public class BlogEntry extends AbstractModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Attribute(primaryKey = true)
    private Key key;

    @Attribute(version = true)
    private Long version;

    /** タイトル */
    @Attribute
    private String title;

    /** 収録日 */
    @Attribute
    private Date recordingDate;

    /** カバー画像のKey */
    @Attribute
    private String coverImageKey;

    /** 音声ファイルのURL */
    @Attribute
    private String audioFileURL;

    /** 本文 */
    @Attribute
    private Text content;

    /** 公開日 */
    @Attribute
    private Date pubDate;

    @Attribute
    private Set<String> members = Sets.newHashSet();

    @Attribute
    private Set<String> corners = Sets.newHashSet();

    /** キーワード */
    @Attribute
    private Set<String> tags = Sets.newHashSet();

    /** 投稿日時 */
    @Attribute
    private Date createDate;

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
        BlogEntry other = (BlogEntry) obj;
        if (key == null) {
            if (other.key != null) {
                return false;
            }
        } else if (!key.equals(other.key)) {
            return false;
        }
        return true;
    }

    public Text getContent() {
        return content;
    }

    @JSONHint(ignore = true)
    public Key getKey() {
        return key;
    }

    @Override
    public String getKeyString() {
        return keyToString(key);
    }

    public Date getPubDate() {
        return pubDate;
    }

    public Date getRecordingDate() {
        return recordingDate;
    }

    public String getTitle() {
        return title;
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

    public void setContent(Text content) {
        this.content = content;
    }

    public void setKey(Key key) {
        this.key = key;
    }

    public void setPubDate(Date pubDate) {
        this.pubDate = pubDate;
    }

    public void setRecordingDate(Date recordingDate) {
        this.recordingDate = recordingDate;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public String getCoverImageKey() {
        return coverImageKey;
    }

    public void setCoverImageKey(String coverImageKey) {
        this.coverImageKey = coverImageKey;
    }

    public Set<String> getTags() {
        return tags;
    }

    public void setTags(Set<String> keyword) {
        this.tags = keyword;
    }

    /**
     * @return the audioFile
     */
    public String getAudioFileURL() {
        return audioFileURL;
    }

    /**
     * @param audioFile
     *            the audioFile to set
     */
    public void setAudioFileURL(String audioFile) {
        this.audioFileURL = audioFile;
    }

    /**
     * @return the createDate
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * @param createDate
     *            the createDate to set
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * @return the members
     */
    public Set<String> getMembers() {
        return members;
    }

    /**
     * @param members
     *            the members to set
     */
    public void setMembers(Set<String> members) {
        this.members = members;
    }

    /**
     * @return the corners
     */
    public Set<String> getCorners() {
        return corners;
    }

    /**
     * @param corners
     *            the corners to set
     */
    public void setCorners(Set<String> corners) {
        this.corners = corners;
    }

}
