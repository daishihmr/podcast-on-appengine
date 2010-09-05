package net.hmrradio.podcastsite.common;

import net.hmrradio.podcastsite.meta.PersonalityMeta;

public class PersonalityCopyOptions extends CopyOptions {

    private PersonalityMeta p = PersonalityMeta.get();

    public PersonalityCopyOptions() {
        super();

        keyConverter(p.key);

        textConverter("profile");
    }
}
