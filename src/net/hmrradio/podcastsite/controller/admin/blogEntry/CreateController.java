package net.hmrradio.podcastsite.controller.admin.blogEntry;

import net.hmrradio.podcastsite.common.BlogEntryCopyOptions;
import net.hmrradio.podcastsite.controller.BasePostController;
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
import org.slim3.util.StringUtil;

public class CreateController extends BasePostController {

    private BlogEntryMeta b = BlogEntryMeta.get();
    private BlogEntryService service = new BlogEntryService();

    @Override
    protected Navigation exec() throws Exception {

        BlogEntry newData = new BlogEntry();
        BeanUtil.copy(request, newData, new BlogEntryCopyOptions());
        String content = newData.getContent().getValue();
        if (!StringUtil.isEmpty(content)) {
            newData.setMembers(service.getPersonalities(content));
            newData.setCorners(service.getCorners(content));
        }

        if (newData.getKey() == null) {
            service.create(newData);
        } else {
            service.update(newData);
        }

        BlogEntry result;
        try {
            result = service.parseContent(newData);
        } catch (Exception e) {
            return forwardJsonError();
        }

        return forwardJson(result);
    }

    @Override
    protected boolean validate() {
        Validators v = new Validators(request);

        v.add(b.title, RequiredValidator.INSTANCE, new MaxlengthValidator(20));
        v.add(b.audioFileURL, new RegexpValidator(Values.URL_PATTERN));
        v.add(b.recordingDate, new DateTypeValidator("yyyy/MM/dd"));
        v.add("content", RequiredValidator.INSTANCE, new MaxlengthValidator(
            2000));

        return v.validate();
    }

}
