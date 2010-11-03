package net.hmrradio.podcastsite.controller.blogEntry;

import net.hmrradio.podcastsite.common.BlogEntryCopyOptions;
import net.hmrradio.podcastsite.controller.BaseController;
import net.hmrradio.podcastsite.define.Values;
import net.hmrradio.podcastsite.meta.BlogEntryMeta;
import net.hmrradio.podcastsite.model.BlogEntry;
import net.hmrradio.podcastsite.service.BlogEntryService;

import org.slim3.controller.Navigation;
import org.slim3.controller.validator.DateTypeValidator;
import org.slim3.controller.validator.MaxlengthValidator;
import org.slim3.controller.validator.RegexpValidator;
import org.slim3.controller.validator.RequiredValidator;
import org.slim3.controller.validator.Validators;
import org.slim3.util.BeanUtil;

import com.google.appengine.repackaged.org.apache.commons.logging.Log;
import com.google.appengine.repackaged.org.apache.commons.logging.LogFactory;

public class PutController extends BaseController {

    private BlogEntryMeta b = BlogEntryMeta.get();

    private BlogEntryService blogEntryService = new BlogEntryService();

    private Log log = LogFactory.getLog(PutController.class);

    public PutController() {
        necessaryLoggedIn = true;
    }

    @Override
    protected Navigation exec() throws Exception {

        BlogEntry blogEntry = new BlogEntry();
        BeanUtil.copy(request, blogEntry, new BlogEntryCopyOptions());

        log.info(blogEntry);

        blogEntry.listupMembers();
        blogEntry.listupCorners();

        blogEntryService.put(blogEntry);

        return forward("/dashboard/index.jsp");
    }

    @Override
    protected boolean validate() {
        Validators v = new Validators(request);

        v.add(b.title, RequiredValidator.INSTANCE, new MaxlengthValidator(50));
        v.add(b.audioFileURL, new RegexpValidator(Values.URL_PATTERN));
        v.add(b.recordingDate, new DateTypeValidator("yyyy/MM/dd"));
        v.add("content", RequiredValidator.INSTANCE, new MaxlengthValidator(
            5000));

        return v.validate();
    }

    @Override
    protected Navigation input() {
        return forward("/dashboard/index.jsp");
    }

}
