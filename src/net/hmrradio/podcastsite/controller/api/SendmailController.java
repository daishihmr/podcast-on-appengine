package net.hmrradio.podcastsite.controller.api;

import java.io.IOException;

import net.hmrradio.podcastsite.controller.BaseController;
import net.hmrradio.podcastsite.model.MailMessage;
import net.hmrradio.podcastsite.service.MailMessageService;

import org.slim3.controller.Navigation;
import org.slim3.controller.validator.MaxlengthValidator;
import org.slim3.controller.validator.RequiredValidator;
import org.slim3.controller.validator.Validators;
import org.slim3.util.BeanUtil;

public class SendmailController extends BaseController {

    private MailMessageService service = new MailMessageService();

    @Override
    protected Navigation exec() throws Exception {

        MailMessage mail = new MailMessage();
        BeanUtil.copy(request, mail);

        try {
            service.send(mail);
        } catch (IOException e) {
            return forwardJsonError();
        }

        return forwardJson(mail);
    }

    @Override
    protected boolean validate() {
        Validators v = new Validators(request);
        v.add("name", new RequiredValidator(), new MaxlengthValidator(30));
        v.add("mailAddress", new MaxlengthValidator(50));
        v.add("content", new RequiredValidator(), new MaxlengthValidator(1000));

        return v.validate();
    }

    @Override
    protected Navigation input() throws Exception {
        return forwardJsonError();
    }
}
