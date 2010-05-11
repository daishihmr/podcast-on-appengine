package net.hmrradio.podcastsite.rss;

import com.sun.syndication.feed.module.itunes.types.Category;
import com.sun.syndication.feed.synd.SyndPersonImpl;

public class YattsukeFactory {
    private YattsukeFactory() {
    }

    public static PodcastChannel createChannel() {
        PodcastChannel result = new PodcastChannel();

        // rss2.0
        result.title = "HMRのやっつけラジオ";
        result.link = "http://www.hmr-radio.net/";
        result.subtitle = "佐世保出身の30代男性集団が送る、笑いと情熱のポッドキャスト";
        result.description =
            "佐世保出身の30代男性集団が送る、笑いと情熱のポッドキャスト。\n"
                + "車、電脳、オタク、映画、風俗、音楽、ゲームなどをネタに、幅広い話題を提供。\n"
                + "やっつけ仕事でなるべく週１回ぐらいで更新していくネットラジオです。";
        result.summary =
            "佐世保出身の30代男性集団が送る、笑いと情熱のポッドキャスト。\n"
                + "車、電脳、オタク、映画、風俗、音楽、ゲームなどをネタに、幅広い話題を提供。\n"
                + "やっつけ仕事でなるべく週１回ぐらいで更新していくネットラジオです。";
        result.language = "ja-JP";
        result.author = "HMR";
        result.image = new PodcastImage();
        {
            result.image.url = "http://www.hmr-radio.net/yattsu-ke.jpg";
            result.image.title = result.title;
            result.image.link = result.link;
            result.image.description = "やっつけ";
        }
        result.copyright = "Copyright 2006,2010 HMR";

        // itunes
        result.owner = new SyndPersonImpl();
        {
            result.owner.setName("HMR");
            result.owner.setEmail("hmrblog@gmail.com");
        }
        {
            Category category = new Category("Comedy");
            result.categories.add(category);
        }
        result.block = false;
        result.explicit = true;
        result.keywords.add("ネットラジオ");
        result.keywords.add("九州ネットラジオ組合");
        result.keywords.add("関東ネットラジオリンク");
        result.keywords.add("佐世保");
        result.keywords.add("車");
        result.keywords.add("電脳");
        result.keywords.add("オタク");
        result.keywords.add("映画");
        result.keywords.add("風俗");
        result.keywords.add("音楽");
        result.keywords.add("コンビニ");
        result.keywords.add("ゲーム");

        return result;
    }
}
