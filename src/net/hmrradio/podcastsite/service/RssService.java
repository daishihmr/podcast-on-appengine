package net.hmrradio.podcastsite.service;

import java.util.List;

import net.hmrradio.podcastsite.model.AudioFile;
import net.hmrradio.podcastsite.model.BlogEntry;
import net.hmrradio.podcastsite.rss.PodcastChannel;
import net.hmrradio.podcastsite.rss.PodcastItem;
import net.hmrradio.podcastsite.rss.YattsukeFactory;

import com.sun.syndication.feed.module.itunes.types.Duration;
import com.sun.syndication.feed.synd.SyndContentImpl;
import com.sun.syndication.feed.synd.SyndEnclosureImpl;

public class RssService {

    private BlogEntryService blogEntryService = new BlogEntryService();
    private AudioFileService audioFileService = new AudioFileService();

    public PodcastChannel getRss() {
        List<BlogEntry> list = blogEntryService.listAll();

        PodcastChannel result = YattsukeFactory.createChannel();
        for (BlogEntry _blog : list) {
            try {
                BlogEntry blog = blogEntryService.plainText(_blog);
                PodcastItem item = new PodcastItem();

                item.title = blog.getTitle();
                item.author = result.author;
                item.subtitle = blog.getContent().getValue();
                item.summary = blog.getContent().getValue();
                item.description = new SyndContentImpl();
                item.description.setValue(blog
                    .getContent()
                    .getValue()
                    .replaceAll("\\n", ""));
                item.description.setType("text/plain");
                item.pubDate = blog.getCreateDate();
                if (item.pubDate != null) {
                    if (result.pubDate == null
                        || result.pubDate.compareTo(item.pubDate) < 0) {
                        result.pubDate = item.pubDate;
                    }
                }

                item.enclosure = new SyndEnclosureImpl();
                AudioFile audio =
                    audioFileService.findByUrl(blog.getAudioFileURL());
                if (audio != null) {
                    item.enclosure.setUrl(audio.getUrl());
                    item.enclosure.setType(audio.getType());
                    item.enclosure.setLength(audio.getLength());
                    item.duration =
                        new Duration(audio.getDurationMillisecond());
                }
                item.guid =
                    "http://www.hmr-radio.net/?p=" + blog.getKeyString();

                item.keywords =
                    blog.getTags().toArray(new String[blog.getTags().size()]);
                item.explicit = true;

                result.items.add(item);
            } catch (Exception e) {
            }
        }

        return result;
    }

}
