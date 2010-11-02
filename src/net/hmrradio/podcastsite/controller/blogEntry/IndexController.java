package net.hmrradio.podcastsite.controller.blogEntry;

import net.hmrradio.podcastsite.controller.BaseController;
import net.hmrradio.podcastsite.define.AttrName;
import net.hmrradio.podcastsite.model.BlogEntry;
import net.hmrradio.podcastsite.service.BlogEntryService;

import org.slim3.controller.Navigation;
import org.slim3.util.DateUtil;

public class IndexController extends BaseController {

    private BlogEntryService blogEntryService = new BlogEntryService();

    public IndexController() {
        necessaryLoggedIn = true;
    }

    @Override
    public Navigation exec() throws Exception {

        if (param("key") != null) {
            BlogEntry entry = blogEntryService.get(asKey("key"));
            requestScope("key", entry.getKeyString());
            requestScope("title", entry.getTitle());
            requestScope("audioFileURL", entry.getAudioFileURL());
            requestScope("content", entry.getContentWiki());
            requestScope(
                "recordingDate",
                DateUtil.toString(entry.getRecordingDate(), "yyyy/MM/dd"));
            requestScope(
                "createDate",
                DateUtil.toString(entry.getCreateDate(), "yyyy/MM/dd"));
            requestScope(
                "pubDate",
                DateUtil.toString(entry.getPubDate(), "yyyy/MM/dd"));
        } else {
            requestScope("content", "参加メンバー:\n"
                + "[/member/○○]\n"
                + "[/member/○○]\n"
                + "[/member/○○]\n"
                + "\n"
                + "【[/corner/オープニング]】 ○○[[BR]]\n"
                + "【[/corner/○○]】 ○○[[BR]]\n"
                + "【[/corner/○○]】 ○○[[BR]]\n"
                + "【[/corner/○○]】 ○○[[BR]]\n"
                + "【[/corner/エンディング]】 ○○[[BR]]\n"
                + "\n"
                + "[[BR]]\n"
                + "\n"
                + "== 編集後記 ==\n");
        }

        return forward("index.jsp");
    }

    @Override
    protected Navigation input() throws Exception {
        requestScope(AttrName.RETURN_TOP, true);
        return forward("/error.jsp");
    }

}
