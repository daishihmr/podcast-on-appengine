package net.hmrradio.podcastsite.controller.admin.image;

import net.hmrradio.podcastsite.controller.BasePostController;
import net.hmrradio.podcastsite.model.ImageFile;
import net.hmrradio.podcastsite.service.ImageFileService;

import org.slim3.controller.Navigation;
import org.slim3.controller.upload.FileItem;
import org.slim3.controller.validator.RequiredValidator;
import org.slim3.controller.validator.Validators;

public class UploadController extends BasePostController {

    private ImageFileService service = new ImageFileService();

    public UploadController() {
        necessaryLoggedIn = true;
    }

    @Override
    protected Navigation exec() throws Exception {
        FileItem formFile = requestScope("formFile");
        ImageFile result = service.upload(formFile);
        requestScope("imageKey", result.getKeyString());
        return forward("index.jsp");
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
