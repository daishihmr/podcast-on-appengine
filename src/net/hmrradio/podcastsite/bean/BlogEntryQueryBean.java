package net.hmrradio.podcastsite.bean;

import java.io.Serializable;

import com.google.appengine.api.datastore.Key;

public class BlogEntryQueryBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private Key keyEq;

    private String cornerEq;

    private String memberEq;

    private String tagEq;

    private long createDateLt;

    /**
     * @return the createDateLt
     */
    public long getCreateDateLt() {
        return createDateLt;
    }

    /**
     * @param createDateLt
     *            the createDateLt to set
     */
    public void setCreateDateLt(long createDateLt) {
        this.createDateLt = createDateLt;
    }

    /**
     * @return the keyEq
     */
    public Key getKeyEq() {
        return keyEq;
    }

    /**
     * @param keyEq
     *            the keyEq to set
     */
    public void setKeyEq(Key keyEq) {
        this.keyEq = keyEq;
    }

    /**
     * @return the cornerEq
     */
    public String getCornerEq() {
        return cornerEq;
    }

    /**
     * @param cornerEq
     *            the cornerEq to set
     */
    public void setCornerEq(String cornerEq) {
        this.cornerEq = cornerEq;
    }

    /**
     * @return the memberEq
     */
    public String getMemberEq() {
        return memberEq;
    }

    /**
     * @param memberEq
     *            the memberEq to set
     */
    public void setMemberEq(String memberEq) {
        this.memberEq = memberEq;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "BlogEntryQueryBean [cornerEq="
            + cornerEq
            + ", createDateLt="
            + createDateLt
            + ", keyEq="
            + keyEq
            + ", memberEq="
            + memberEq
            + "]";
    }

    /**
     * @return the tagEq
     */
    public String getTagEq() {
        return tagEq;
    }

    /**
     * @param tagEq
     *            the tagEq to set
     */
    public void setTagEq(String tagEq) {
        this.tagEq = tagEq;
    }

}
