package net.hmrradio.podcastsite.service;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Date;

import net.hmrradio.podcastsite.rss.PodcastChannel;
import net.hmrradio.podcastsite.rss.PodcastItem;
import net.hmrradio.podcastsite.rss.PodcastUtil;
import net.hmrradio.podcastsite.rss.YattsukeFactory;

import org.junit.Test;
import org.slim3.tester.AppEngineTestCase;

import com.sun.syndication.feed.module.itunes.types.Duration;
import com.sun.syndication.feed.synd.SyndEnclosureImpl;
import com.sun.syndication.io.FeedException;

public class RssServiceTest extends AppEngineTestCase {

    private RssService service = new RssService();

    @Test
    public void test() throws Exception {
        assertThat(service, is(notNullValue()));
    }

    @Test
    public void exec() throws Exception {
        PodcastChannel channel = YattsukeFactory.createChannel();
        {
            PodcastItem item = new PodcastItem();
            channel.items.add(item);

            item.title = "ヴェネチア映画祭は人気復活となるか？";
            item.author = channel.author;
            item.subtitle = "サブタイトル";
            item.summary = "サマリー";
            item.enclosure = new SyndEnclosureImpl();
            item.enclosure.setUrl("http://a.hmrradio.net/aaa.mp3");
            item.enclosure.setType("audio/mpeg");
            item.enclosure.setLength(1015324L);
            item.guid = item.enclosure.getUrl();
            item.pubDate = new Date();
            item.duration = new Duration(item.enclosure.getLength());
            item.keywords = new String[] { "aaa", "bbb" };
            item.explicit = true;
        }

        // PodcastUtil.out(channel, new OutputStreamWriter(System.out));
    }

    @Test
    public void getRss() throws IOException, FeedException {
        PodcastChannel channel = service.getRss();
        PodcastUtil.out(channel, new OutputStreamWriter(System.out));
    }
}
