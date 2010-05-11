package net.hmrradio.podcastsite.model;

import java.io.Serializable;
import java.util.Date;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.Model;
import org.slim3.util.LongUtil;
import org.slim3.util.StringUtil;

import com.google.appengine.api.datastore.Key;

@Model
public class AudioFile extends AbstractModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Attribute(primaryKey = true)
    private Key key;

    @Attribute(version = true)
    private Long version;

    private Integer schemaVersion = 1;

    /** URL */
    @Attribute
    private String url;

    /** ファイルサイズ(バイト) */
    @Attribute
    private Long length;

    /** MIMEタイプ */
    @Attribute
    private String type;

    /** 総再生時間 */
    @Attribute
    private String duration;

    /** 登録日 */
    @Attribute
    private Date entryDate;

    /**
     * Returns the key.
     * 
     * @return the key
     */
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

    /**
     * Returns the schema version.
     * 
     * @return the schema version
     */
    public Integer getSchemaVersion() {
        return schemaVersion;
    }

    /**
     * Sets the schema version.
     * 
     * @param schemaVersion
     *            the schema version
     */
    public void setSchemaVersion(Integer schemaVersion) {
        this.schemaVersion = schemaVersion;
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
        AudioFile other = (AudioFile) obj;
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
     * URLを取得します。
     * 
     * @return URL
     */
    public String getUrl() {
        return url;
    }

    /**
     * URLを設定します。
     * 
     * @param url
     *            URL
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * ファイルサイズ(バイト)を取得します。
     * 
     * @return ファイルサイズ(バイト)
     */
    public Long getLength() {
        return length;
    }

    /**
     * ファイルサイズ(バイト)を設定します。
     * 
     * @param length
     *            ファイルサイズ(バイト)
     */
    public void setLength(Long length) {
        this.length = length;
    }

    /**
     * MIMEタイプを取得します。
     * 
     * @return MIMEタイプ
     */
    public String getType() {
        return type;
    }

    /**
     * MIMEタイプを設定します。
     * 
     * @param type
     *            MIMEタイプ
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 総再生時間を取得します。
     * 
     * @return 総再生時間
     */
    public String getDuration() {
        return duration;
    }

    /**
     * 総再生時間を設定します。
     * 
     * @param duration
     *            総再生時間
     */
    public void setDuration(String duration) {
        this.duration = duration;
    }

    /**
     * 登録日を取得します。
     * 
     * @return 登録日
     */
    public Date getEntryDate() {
        return entryDate;
    }

    /**
     * 登録日を設定します。
     * 
     * @param entryDate
     *            登録日
     */
    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    @Override
    public String getKeyString() {
        return keyToString(key);
    }

    /**
     * 総再生時間をミリ秒で取得
     * 
     * @return
     */
    public long getDurationMillisecond() {
        String d = getDuration();
        try {
            if (StringUtil.isEmpty(d)) {
                return 0;
            } else if (d.length() <= 2) {
                return LongUtil.toPrimitiveLong(d);
            } else if (d.length() <= 5) {
                String[] sp = d.split(":");
                return LongUtil.toPrimitiveLong(sp[0])
                    * 60
                    * 1000
                    + LongUtil.toPrimitiveLong(sp[1])
                    * 1000;
            } else if (d.length() <= 8) {
                String[] sp = d.split(":");
                return LongUtil.toPrimitiveLong(sp[0])
                    * 60
                    * 60
                    * 1000
                    + LongUtil.toPrimitiveLong(sp[1])
                    * 60
                    * 1000
                    + LongUtil.toPrimitiveLong(sp[2])
                    * 1000;
            } else {
                return 0;
            }
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
