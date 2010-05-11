package net.hmrradio.podcastsite.controller;

import javax.transaction.NotSupportedException;

public abstract class BasePostController extends BaseController {

    @Override
    protected void beforeExec() throws Exception {
        if (!isPost()) {
            throw new NotSupportedException("POST");
        }
    }

}
