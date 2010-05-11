package net.hmrradio.podcastsite.rss;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.sun.syndication.feed.module.itunes.types.Category;
import com.sun.syndication.feed.synd.SyndPerson;

public class PodcastChannel implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * title
     * 
     * <pre>
     * チャンネル名です。
     * それは、貴方のサービスへの参照方法です。
     * もし貴方が、貴方の RSS ファイルと同じ情報を含む HTML ウェブサイトを
     * 持っているなら、貴方のチャンネルのタイトルは、貴方のウェブサイトの
     * タイトルと同じであるべきです。
     * 
     * 「名前」の列に表示
     * </pre>
     */
    public String title;

    /**
     * link
     * 
     * <pre>
     * チャンネルに対応する HTML ウェブサイトへの URL
     * 
     * 「名前」の列に表示されるWeb サイトへのリンクと矢印
     * </pre>
     */
    public String link;

    /**
     * description
     * 
     * <pre>
     * チャネルの説明文
     * </pre>
     */
    public String description;

    /**
     * language
     * 
     * <pre>
     * チャンネルを記述している言語です。
     * これにより、アグリゲータは、例えば、単一のページ上ですべての
     * イタリア語サイトと分類することができます。
     * さらに、W3C によって定義された値も使うことができます。
     * </pre>
     */
    public String language;

    /**
     * copyright
     * 
     * <pre>
     * チャンネル内のコンテンツの著作権表示です。
     * 
     * 非表示
     * </pre>
     */
    public String copyright;

    /**
     * managingEditor
     * 
     * <pre>
     * コンテンツ編集に携わった人の Email アドレスです。
     * </pre>
     */
    @Deprecated
    public String managingEditor;

    /**
     * webMaster
     * 
     * <pre>
     * チャンネルに関する技術的な問題に責任を持つ人の Email アドレスです。
     * </pre>
     */
    @Deprecated
    public String webMaster;

    /**
     * pubDate
     * 
     * <pre>
     * チャンネル内のコンテンツの発行日時です。
     * 例えば、New York Times が日次で発行するなら、発効日時は、24 時間に
     * 一度めくられます。それは、チャンネルの発行日時が変更になった時です。
     * すべての RSS 内の日時は、RFC 822?で規定されている日時に準拠します。
     * ただし、西暦を 2 文字で表現するかもしれないし、4 桁で表現するかもしれません。
     * （4 桁が優先です。）
     * 
     * リリース日
     * </pre>
     */
    public Date pubDate;

    /**
     * lastBuildDate
     * 
     * <pre>
     * チャンネルのコンテンツが変更された最終日時です。
     * </pre>
     */
    @Deprecated
    public Date lastBuildDate;

    /**
     * generator
     * 
     * <pre>
     * チャンネルを生成するのに使われたプログラムを指し示す文字列です。
     * </pre>
     */
    @Deprecated
    public String generator;

    /**
     * docs
     * 
     * <pre>
     * RSS ファイルで使われているフォーマットを表す文書を指し示す URL です。
     * それは、恐らくこのページへのポインターとなります。
     * これは、今から 25 年間、ウェブサーバ上にある RSS ファイルを偶然見つけ、
     * それはなんだろうと疑問に思うかもしれない人々のためにあります。
     * </pre>
     */
    @Deprecated
    public String docs;

    /**
     * cloud
     * 
     * <pre>
     * RSS フィード用のライトウェイトな配信予約プロトコルを使って、
     * チャンネルへ更新を通知してもらうために、cloud に登録することができます。
     * 詳細情報はこちらをご覧下さい。
     * </pre>
     */
    @Deprecated
    public String cloud;

    /**
     * ttl
     * 
     * <pre>
     * ttl は、time to live （有効期間）の略語です。
     * それは、ソースからリフレッシュする前に、どれだけの期間、チャンネルを
     * キャッシュすることができるかを指し示す分数です。
     * </pre>
     */
    @Deprecated
    public String ttl;

    /**
     * image
     * 
     * <pre>
     * チャンネルと一緒に表示可能な GIF, JPEG, PNG 画像を指定します。
     * </pre>
     */
    public PodcastImage image;

    /**
     * rating
     * 
     * <pre>
     * チャンネルのPICSレーティングです。
     * </pre>
     */
    @Deprecated
    public String rating;

    /**
     * textInput
     * 
     * <pre>
     * チャンネルと一緒に表示表示可能なテキスト入力ボックスを指定します。
     * </pre>
     */
    @Deprecated
    public String textInput;

    /**
     * skipHours
     * 
     * <pre>
     * アグリゲータは何時にスキップすることができるかを伝える暗示です。
     * </pre>
     */
    @Deprecated
    public String skipHours;

    /**
     * skipDays
     * 
     * <pre>
     * アグリゲータは何曜日をスキップすることができるかを伝える暗示です。
     * </pre>
     */
    @Deprecated
    public String skipDays;

    /**
     * category
     * 
     * <pre>
     * チャンネルが属するカテゴリーを一つ以上指定します。
     * &lt;item&gt; レベルのcategory属性と同じルールが適用されます。
     * 
     * カテゴリー列、iTunes Music Storeのブラウズ
     * </pre>
     */
    public List<Category> categories = new ArrayList<Category>();

    /**
     * 「アーティスト」の列に表示
     */
    public String author;

    /**
     * エピソード、Podcastを表示しない
     */
    public boolean block;

    /**
     * 「名前」の列に表示（露骨な表現を含む）
     */
    public boolean explicit;

    /**
     * 非表示、検索可能
     */
    public List<String> keywords = new ArrayList<String>();

    /**
     * 非表示、iTunes への新しいフィー ドの URL の通知に使用
     */
    @Deprecated
    public String newFeedUrl;

    /**
     * 非表示、連絡時にのみ使用
     */
    public SyndPerson owner;

    /**
     * 「説明」の列に表示
     */
    public String subtitle;

    /**
     * 説明列の「丸で囲まれたi」がクリックされた場合
     */
    public String summary;

    /**
     * item
     */
    public List<PodcastItem> items = new ArrayList<PodcastItem>();

}
