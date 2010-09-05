package net.hmrradio.podcastsite.common;

import net.hmrradio.podcastsite.meta.BlogEntryMeta;

public class BlogEntryCopyOptions extends CopyOptions {

    private BlogEntryMeta b = BlogEntryMeta.get();

    public BlogEntryCopyOptions() {
        super();

        keyConverter(b.key);

        dateConverter("yyyy/MM/dd HH:mm:ss", b.createDate);
        dateConverter("yyyy/MM/dd HH:mm:ss", b.pubDate);
        dateConverter("yyyy/MM/dd", b.recordingDate);

        textConverter("content");

        setConverter(b.tags);
    }
}
