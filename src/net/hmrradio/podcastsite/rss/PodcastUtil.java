package net.hmrradio.podcastsite.rss;

import java.io.IOException;
import java.io.Writer;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

import net.hmrradio.podcastsite.define.Values;

import com.sun.syndication.feed.module.itunes.EntryInformation;
import com.sun.syndication.feed.module.itunes.EntryInformationImpl;
import com.sun.syndication.feed.module.itunes.FeedInformation;
import com.sun.syndication.feed.module.itunes.FeedInformationImpl;
import com.sun.syndication.feed.synd.SyndEnclosure;
import com.sun.syndication.feed.synd.SyndEnclosureImpl;
import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndEntryImpl;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.feed.synd.SyndFeedImpl;
import com.sun.syndication.io.FeedException;
import com.sun.syndication.io.SyndFeedOutput;

public class PodcastUtil {

    private static Logger log = Logger.getLogger(PodcastUtil.class.getName());

    @SuppressWarnings("unchecked")
    public static void out(PodcastChannel channel, Writer writer)
            throws IOException, FeedException {
        log.info("RSS 出力 start");

        try {
            validate(channel);

            SyndFeed feed = new SyndFeedImpl();
            feed.setFeedType("rss_2.0");
            FeedInformation itunesFeed = new FeedInformationImpl();
            feed.getModules().add(itunesFeed);

            // rss2.0
            setFeed(channel, feed);

            // itunes
            setItunesFeed(channel, itunesFeed);

            for (PodcastItem item : channel.items) {
                validate(item);

                SyndEntry entry = new SyndEntryImpl();
                EntryInformation itunesEntry = new EntryInformationImpl();
                entry.getModules().add(itunesEntry);
                feed.getEntries().add(entry);

                // rss2.0
                setEntry(item, entry);

                // itunes
                setItunesEntry(item, itunesEntry);
            }

            SyndFeedOutput output = new SyndFeedOutput();
            output.output(feed, writer);

        } catch (IllegalArgumentException e) {
            log.log(Level.WARNING, "RSS 出力中にエラー", e);
        } finally {
            try {
                writer.flush();
                writer.close();

                log.info("RSS 出力 end");
            } catch (Exception e) {
            }
        }
    }

    @SuppressWarnings("unchecked")
    private static void setEntry(PodcastItem item, SyndEntry entry) {
        entry.setTitle(item.title);
        entry.setLink(item.link);
        entry.setDescription(item.description);
        entry.setAuthor(item.author);
        if (item.enclosure != null) {
            SyndEnclosure cover = new SyndEnclosureImpl();
            {
                cover.setUrl(Values.SITE_URL + "/yattsu-ke.jpg");
                cover.setType("image/jpeg");
                cover.setLength(19987L);
            }
            entry.getEnclosures().add(cover);
            entry.getEnclosures().add(item.enclosure);
        }
        entry.setPublishedDate(item.pubDate);
        entry.setSource(item.source);
    }

    private static void setFeed(PodcastChannel channel, SyndFeed feed) {
        feed.setTitle(channel.title);
        feed.setLink(channel.link);
        feed.setDescription(channel.description);
        feed.setLanguage(channel.language);
        feed.setCopyright(channel.copyright);
        feed.setPublishedDate(channel.pubDate);
    }

    private static void setItunesEntry(PodcastItem item,
            EntryInformation itunesEntry) {
        itunesEntry.setAuthor(item.author);
        itunesEntry.setBlock(item.block);
        itunesEntry.setDuration(item.duration);
        itunesEntry.setExplicit(item.explicit);
        itunesEntry.setSubtitle(item.subtitle);
        itunesEntry.setSummary(item.summary);
        itunesEntry.setKeywords(item.keywords);
    }

    private static void setItunesFeed(PodcastChannel channel,
            FeedInformation itunesFeed) throws MalformedURLException {
        itunesFeed.setAuthor(channel.author);
        itunesFeed.setBlock(channel.block);
        itunesFeed.setCategories(channel.categories);
        if (channel.image != null) {
            itunesFeed.setImage(new URL(channel.image.url));
        }
        itunesFeed.setExplicit(channel.explicit);
        itunesFeed.setKeywords(channel.keywords
            .toArray(new String[channel.keywords.size()]));
        if (channel.owner != null) {
            itunesFeed.setOwnerName(channel.owner.getName());
            itunesFeed.setOwnerEmailAddress(channel.owner.getEmail());
        }
        itunesFeed.setSubtitle(channel.subtitle);
        itunesFeed.setSummary(channel.summary);
    }

    private static void validate(PodcastChannel channel) {
        if (channel == null) {
            throw new IllegalArgumentException();
        }

        if (channel.title == null) {
            throw new IllegalArgumentException();
        }

        if (channel.link == null) {
            throw new IllegalArgumentException();
        }

        if (channel.description == null) {
            throw new IllegalArgumentException();
        }

        if (channel.image != null) {
            PodcastImage im = channel.image;
            if (im.url == null) {
                throw new IllegalArgumentException();
            }
            if (im.title == null) {
                throw new IllegalArgumentException();
            }
            if (im.link == null) {
                throw new IllegalArgumentException();
            }
        }
    }

    private static void validate(PodcastItem item) {
        if (item.title == null && item.description == null) {
            throw new IllegalArgumentException();
        }
    }

}
