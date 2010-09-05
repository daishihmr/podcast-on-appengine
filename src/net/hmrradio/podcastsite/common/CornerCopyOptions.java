package net.hmrradio.podcastsite.common;

import net.hmrradio.podcastsite.meta.CornerMeta;

public class CornerCopyOptions extends CopyOptions {

    private CornerMeta c = CornerMeta.get();

    public CornerCopyOptions() {

        keyConverter(c.key);

        textConverter("description");
    }
}
