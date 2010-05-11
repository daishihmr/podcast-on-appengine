package net.hmrradio.podcastsite.model;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class AudioFileTest {

    private AudioFile model = new AudioFile();

    @Test
    public void test() throws Exception {
        assertThat(model, is(notNullValue()));
    }

    @Test
    public void d() throws Exception {
        AudioFile audio = new AudioFile();
        audio.setDuration("aa");
        assertThat(audio.getDurationMillisecond(), is(0L));

        audio.setDuration("11");
        assertThat(audio.getDurationMillisecond(), is(11L));

        audio.setDuration("1:00");
        assertThat(audio.getDurationMillisecond(), is(60000L));

        audio.setDuration("10:03");
        assertThat(audio.getDurationMillisecond(), is(603000L));

        audio.setDuration("1:10:03");
        assertThat(audio.getDurationMillisecond(), is(4203000L));

        audio.setDuration("11:10:03");
        assertThat(audio.getDurationMillisecond(), is(40203000L));

        audio.setDuration(":10:03");
        assertThat(audio.getDurationMillisecond(), is(603000L));

        audio.setDuration(":02");
        assertThat(audio.getDurationMillisecond(), is(2000L));
    }

}