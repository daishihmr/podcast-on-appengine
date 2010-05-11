package net.hmrradio.podcastsite.rss;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.sun.syndication.feed.module.itunes.types.Duration;
import com.sun.syndication.feed.synd.SyndContent;
import com.sun.syndication.feed.synd.SyndEnclosure;
import com.sun.syndication.feed.synd.SyndFeed;

public class PodcastItem implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * <pre>
     * 記事のタイトルです。
     * 
     * 「名前」の列に表示
     * </pre>
     */
    public String title;

    /**
     * <pre>
     * 記事の URL です。
     * </pre>
     */
    public String link;

    /**
     * <pre>
     * 記事の粗筋です。
     * </pre>
     */
    public SyndContent description;

    /**
     * <pre>
     * 記事の著者の Email アドレスです。
     * 
     * 「アーティスト」の列に表示
     * </pre>
     */
    public String author;

    /**
     * <pre>
     * 記事に関連するコメントのページ URL です。
     * </pre>
     */
    public String comments;

    /**
     * <pre>
     * 記事に添付されるメディアオブジェクトを記述します。
     * </pre>
     */
    public SyndEnclosure enclosure;

    /**
     * <pre>
     * 記事を一意に特定できる文字列です。
     * guid は、globally unique identifier の略語で、記事を一意に
     * 識別する文字列です。
     * guid が存在したら、アグリゲータは、この文字列を再審記事か
     * どうかの判定に使っても構いません。
     * </pre>
     */
    public String guid;

    /**
     * <pre>
     * 記事が発行された日時を表します。
     * 
     * リリース日
     * </pre>
     */
    public Date pubDate;

    /**
     * <pre>
     * 記事が引用された RSS チャンネルです。
     * この値は、その記事が引用している RSS チャンネルの名前で、
     * その &lt;title&gt; から引用されます。
     * この要素には、必須属性が一つだけあります。それは url ですが、
     * 引用元の XML 化されたものにリンクします。
     * &lt;source url="http://static.userland.com/tomalak/links2.xml"&gt;Tomalak's Realm&lt;/source&gt;
     * この要素の目的は、引用元の評判を広め、ニュース記事の引用元を
     * 公にするためです。
     * それは、アグリゲータの Post コマンドで使われることができます。
     * それは、アグリゲータからウェブログオーサリングツールへ記事を
     * 転送する時、自動的に生成されるべきです。
     * </pre>
     */
    public SyndFeed source;

    /**
     * エピソード、Podcastを表示しない
     */
    public boolean block;

    /**
     * 「時間」の列に表示
     */
    public Duration duration;

    /**
     * 「名前」の列に表示（露骨な表現を含む）
     */
    public boolean explicit;

    /**
     * 非表示、検索可能
     */
    public String[] keywords;

    /**
     * 「説明」の列に表示
     */
    public String subtitle;

    /**
     * 説明列の「丸で囲まれたi」がクリックされた場合
     */
    public String summary;

    /**
     * <pre>
     * 一つ以上のカテゴリー内に記事を含みます。
     * </pre>
     */
    @Deprecated
    public List<String> categories = new ArrayList<String>();

}
