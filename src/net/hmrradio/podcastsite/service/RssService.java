package net.hmrradio.podcastsite.service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import net.hmrradio.podcastsite.define.Values;
import net.hmrradio.podcastsite.model.AudioFile;
import net.hmrradio.podcastsite.model.BlogEntry;
import net.hmrradio.podcastsite.rss.PodcastChannel;
import net.hmrradio.podcastsite.rss.PodcastItem;
import net.hmrradio.podcastsite.rss.YattsukeFactory;

import com.sun.syndication.feed.module.itunes.types.Duration;
import com.sun.syndication.feed.synd.SyndContentImpl;
import com.sun.syndication.feed.synd.SyndEnclosureImpl;

public class RssService {

    private Logger log = Logger.getLogger(RssService.class.getName());

    private BlogEntryService blogEntryService = new BlogEntryService();
    private AudioFileService audioFileService = new AudioFileService();

    public PodcastChannel getRss() {
        log.info("RSS 作成 start");

        List<BlogEntry> list = blogEntryService.list();

        PodcastChannel result = YattsukeFactory.createChannel();
        for (BlogEntry blog : list) {
            log.info("記事[" + blog.getTitle() + "] start");
            try {
                PodcastItem item = new PodcastItem();

                item.title = blog.getTitle();
                item.author = result.author;
                item.subtitle = blog.getContent().getValue();
                item.summary = blog.getContent().getValue();
                item.description = new SyndContentImpl();
                item.description.setValue(blog.getContent().getValue());
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
                item.guid = Values.SITE_URL + "/?p=" + blog.getKeyString();

                item.keywords =
                    blog.getTags().toArray(new String[blog.getTags().size()]);
                item.explicit = true;

                result.items.add(item);
            } catch (Exception e) {
                log.log(Level.WARNING, "記事[" + blog.getTitle() + "] でエラー", e);
                break;
            }

            log.info("記事[" + blog.getTitle() + "] end");
        }

        log.info("RSS 作成 end");
        return result;
    }

}
