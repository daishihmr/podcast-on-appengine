package net.hmrradio.podcastsite.controller.admin.image;

import net.hmrradio.podcastsite.controller.BasePostController;
import net.hmrradio.podcastsite.define.AttrName;
import net.hmrradio.podcastsite.define.MsgKey;
import net.hmrradio.podcastsite.model.ImageFile;
import net.hmrradio.podcastsite.service.ImageFileService;

import org.slim3.controller.Navigation;
import org.slim3.controller.upload.FileItem;
import org.slim3.controller.validator.RequiredValidator;
import org.slim3.controller.validator.Validators;
import org.slim3.util.ApplicationMessage;

import com.google.appengine.api.images.Image;

public class UploadThumbsController extends BasePostController {

    private ImageFileService service = new ImageFileService();

    public UploadThumbsController() {
        necessaryLoggedIn = true;
    }

    @Override
    protected Navigation exec() throws Exception {
        try {

            FileItem formFile = requestScope("formFile");

            Image image = service.toImage(formFile);
            if (image.getWidth() > 2000 || image.getHeight() > 2000) {
                requestScope(AttrName.ERROR_MESSAGES, ApplicationMessage.get(
                    MsgKey.IMAGE_SIZE_ERROR,
                    "2000"));
                return forward("thumbs");
            }

            image = service.sizeCoverImage(image);

            ImageFile result = service.upload(formFile);
            requestScope("imageKey", result.getKeyString());

        } catch (Exception e) {
            requestScope(AttrName.ERROR_MESSAGES, e.getMessage());
        }

        return forward("thumbs");
    }

    @Override
    protected boolean validate() {
        Validators v = new Validators(request);

        v.add("formFile", RequiredValidator.INSTANCE);

        return v.validate();
    }

    @Override
    protected Navigation validationError() {
        return redirect(basePath);
    }
}
