package net.hmrradio.podcastsite.controller.ajax.blogEntry;

import java.util.List;
import java.util.logging.Logger;

import net.hmrradio.podcastsite.bean.BlogEntryQueryBean;
import net.hmrradio.podcastsite.controller.BaseController;
import net.hmrradio.podcastsite.define.AttrName;
import net.hmrradio.podcastsite.model.BlogEntry;
import net.hmrradio.podcastsite.service.BlogEntryService;

import org.slim3.controller.Navigation;
import org.slim3.controller.validator.LongTypeValidator;
import org.slim3.controller.validator.RequiredValidator;
import org.slim3.controller.validator.Validators;

public class IndexController extends BaseController {

    private Logger log = Logger.getLogger(IndexController.class.getName());

    private BlogEntryService blogEntryService = new BlogEntryService();

    @Override
    protected Navigation input() throws Exception {
        response.setCharacterEncoding("UTF-8");
        response.getWriter().print("error");
        response.flushBuffer();
        return null;
    }

    @Override
    protected Navigation exec() throws Exception {
        log.info("start");

        response.setCharacterEncoding("UTF-8");

        BlogEntryQueryBean query = new BlogEntryQueryBean();
        query.setCreateDateLt(asLong("createDateLt"));

        List<BlogEntry> list = blogEntryService.list(query);

        if (list.size() == 0) {
            response.setCharacterEncoding("UTF-8");
            response.getWriter().print("no data");
            response.flushBuffer();
            return null;
        }

        requestScope(AttrName.ENTRY_LIST, list);

        response.setCharacterEncoding("UTF-8");

        log.info("success");

        return forward("index.jsp");
    }

    @Override
    protected boolean validate() {
        log.info("validate start");

        Validators v = new Validators(request);

        v.add(
            "createDateLt",
            RequiredValidator.INSTANCE,
            new LongTypeValidator());

        log.info("validate end");
        return v.validate();
    }
}
