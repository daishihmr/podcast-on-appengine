package net.hmrradio.podcastsite.rss;

public class PodcastImage {

	/**
	 * <pre>
	 * チャンネルを表す GIF, JPEG, PNG 画像の URLです。
	 * </pre>
	 */
	public String url;

	/**
	 * <pre>
	 * イメージを説明します。
	 * チャンネルが HTML で表示される際に、HTML &lt;img&gt; タグの ALT 属性で使われます。
	 * </pre>
	 */
	public String title;

	/**
	 * <pre>
	 * チャンネルが表示され、画像がそのサイトへリンクされる際に使われる、
	 * そのリンク先 URL です。
	 * （実際面では、image の &lt;title&gt; と &lt;link&gt; は、
	 * channel の &lt;title&gt; と &lt;link&gt; と同じ値になるべきです。）
	 * </pre>
	 */
	public String link;

	/**
	 * <pre>
	 * ピクセルで表した画像の幅を表す数字です。
	 * 最大値は 144 です。デフォルト値は 88 です。
	 * </pre>
	 */
	@Deprecated
	public String width;

	/**
	 * <pre>
	 * ピクセルで表した画像の高さを表す数字です。
	 * 最大値は 400 です。デフォルト値は 31 です。
	 * </pre>
	 */
	@Deprecated
	public String height;

	/**
	 * HTML 表示の際に画像のリンクの TITLE 属性のテキストとなります。
	 */
	public String description;
}
