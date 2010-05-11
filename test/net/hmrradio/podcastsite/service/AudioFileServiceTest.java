package net.hmrradio.podcastsite.service;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import net.hmrradio.podcastsite.meta.AudioFileMeta;
import net.hmrradio.podcastsite.model.AudioFile;

import org.junit.Test;
import org.slim3.datastore.Datastore;
import org.slim3.tester.AppEngineTestCase;

import com.google.appengine.api.datastore.Query.FilterOperator;

public class AudioFileServiceTest extends AppEngineTestCase {

    private AudioFileService service = new AudioFileService();

    @Test
    public void test() throws Exception {
        assertThat(service, is(notNullValue()));
    }

    @Test
    public void testCreate() throws Exception {
        AudioFile audio = new AudioFile();
        audio.setUrl("test://test/test.mp3");
        audio.setDuration("1:50:39");
        audio.setLength(120000L);
        audio.setType("audio/mpeg");

        service.create(audio);

        AudioFileMeta meta = AudioFileMeta.get();
        AudioFile after =
            Datastore.query(AudioFile.class).filter(
                meta.url.getName(),
                FilterOperator.EQUAL,
                "test://test/test.mp3").asSingle();
        assertThat(after.getDuration(), is("1:50:39"));
    }

    @Test
    public void testUpdate() throws Exception {
        AudioFile audio = new AudioFile();
        audio.setUrl("test://test/test.mp3");
        audio.setDuration("1:50:39");
        audio.setLength(120000L);
        audio.setType("audio/mpeg");

        service.create(audio);

        AudioFile audio2 = new AudioFile();
        audio2.setUrl("test://test/test.mp3");
        audio2.setDuration("2:22:22");
        audio2.setLength(120000L);
        audio2.setType("audio/mpeg");

        service.update(audio2);

        AudioFileMeta meta = AudioFileMeta.get();
        AudioFile after =
            Datastore.query(AudioFile.class).filter(
                meta.url.getName(),
                FilterOperator.EQUAL,
                "test://test/test.mp3").asSingle();
        assertThat(after.getDuration(), is("2:22:22"));
    }

    @Test
    public void testDelete() throws Exception {
        AudioFile audio = new AudioFile();
        audio.setUrl("test://test/test.mp3");
        audio.setDuration("1:50:39");
        audio.setLength(120000L);
        audio.setType("audio/mpeg");

        service.create(audio);

        service.delete("test://test/test.mp3");

        AudioFileMeta meta = AudioFileMeta.get();
        AudioFile after =
            Datastore.query(AudioFile.class).filter(
                meta.url.getName(),
                FilterOperator.EQUAL,
                "test://test/test.mp3").asSingle();
        assertThat(after, is(nullValue()));
    }
}
