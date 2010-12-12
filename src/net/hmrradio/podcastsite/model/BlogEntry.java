package net.hmrradio.podcastsite.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import net.arnx.jsonic.JSONHint;
import net.hmrradio.podcastsite.util.WikiUtil;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.Model;
import org.slim3.util.StringUtil;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.Text;
import com.google.appengine.repackaged.com.google.common.collect.Sets;

@Model(schemaVersion = 1)
public class BlogEntry implements Serializable {

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

    public void listupCorners() {
        if (content == null) {
            return;
        }
        Set<String> result = Sets.newHashSet();
        StringBuffer content = new StringBuffer(getContentWiki());

        while (content.indexOf("[/corner/") != -1) {
            int from = content.indexOf("[/corner/");
            int to = content.indexOf("]", from);
            if (from == -1 || to == -1) {
                break;
            }
            result.add(content.substring(from + "[/corner/".length(), to));
            content.delete(from, to + 1);
        }

        corners = result;
    }

    public void listupMembers() {
        if (content == null) {
            return;
        }
        Set<String> result = Sets.newHashSet();
        StringBuffer content = new StringBuffer(getContentWiki());

        while (content.indexOf("[/member/") != -1) {
            int from = content.indexOf("[/member/");
            int to = content.indexOf("]", from);
            if (from == -1 || to == -1) {
                break;
            }
            result.add(content.substring(from + "[/member/".length(), to));
            content.delete(from, to + 1);
        }

        members = result;
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

    public String getAudioFileURL() {
        return audioFileURL;
    }

    public String getAudioFileName() {
        if (StringUtil.isEmpty(audioFileURL)) {
            return "";
        }
        return audioFileURL.substring(audioFileURL.lastIndexOf("/") + 1);
    }

    @JSONHint(ignore = true)
    public Text getContent() {
        return content;
    }

    public String getContentHtml() {
        if (content == null) {
            return "";
        }
        return WikiUtil.toHtml(content.getValue());
    }

    public String getContentWiki() {
        if (content == null) {
            return "";
        }
        return content.getValue();
    }

    public Set<String> getCorners() {
        return corners;
    }

    public String getCoverImageKey() {
        return coverImageKey;
    }

    @JSONHint(format = "yyyy/MM/dd HH:mm:ss")
    public Date getCreateDate() {
        return createDate;
    }

    @JSONHint(ignore = true)
    public Key getKey() {
        return key;
    }

    public String getKeyString() {
        if (key == null) {
            return "";
        }
        return KeyFactory.keyToString(key);
    }

    public Set<String> getMembers() {
        return members;
    }

    @JSONHint(format = "yyyy/MM/dd HH:mm:ss")
    public Date getPubDate() {
        return pubDate;
    }

    @JSONHint(format = "yyyy/MM/dd")
    public Date getRecordingDate() {
        return recordingDate;
    }

    public Set<String> getTags() {
        return tags;
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

    public void setAudioFileURL(String audioFile) {
        this.audioFileURL = audioFile;
    }

    public void setContent(Text content) {
        this.content = content;
    }

    public void setCorners(Set<String> corners) {
        this.corners = corners;
    }

    public void setCoverImageKey(String coverImageKey) {
        this.coverImageKey = coverImageKey;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public void setKey(Key key) {
        this.key = key;
    }

    public void setMembers(Set<String> members) {
        this.members = members;
    }

    public void setPubDate(Date pubDate) {
        this.pubDate = pubDate;
    }

    public void setRecordingDate(Date recordingDate) {
        this.recordingDate = recordingDate;
    }

    public void setTags(Set<String> keyword) {
        this.tags = keyword;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

}
