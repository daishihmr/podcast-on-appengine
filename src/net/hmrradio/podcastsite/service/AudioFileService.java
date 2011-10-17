package net.hmrradio.podcastsite.service;

import static com.google.appengine.api.datastore.Query.FilterOperator.*;
import static com.google.appengine.api.datastore.Query.SortDirection.*;

import java.util.Date;
import java.util.List;

import net.hmrradio.podcastsite.exception.EntityAlreadyDeletedException;
import net.hmrradio.podcastsite.exception.EntityAlreadyExistsException;
import net.hmrradio.podcastsite.meta.AudioFileMeta;
import net.hmrradio.podcastsite.model.AudioFile;

import org.slim3.datastore.Datastore;
import org.slim3.datastore.ModelQuery;
import org.slim3.util.StringUtil;

import com.google.appengine.api.datastore.Key;

public class AudioFileService {

    private static final AudioFileMeta meta = AudioFileMeta.get();
    private static final String _url = meta.url.getName();
    private static final String _ed = meta.entryDate.getName();

    public void create(AudioFile audio) {
        if (findByUrl(audio.getUrl()) != null) {
            throw new EntityAlreadyExistsException();
        }
        audio.setKey(Datastore.createKey(AudioFile.class, audio.getUrl()));
        audio.setEntryDate(new Date());
        Datastore.put(audio);
    }

    public void update(AudioFile audio) {
        AudioFile data = findByUrl(audio.getUrl());

        data.setDuration(audio.getDuration());
        data.setType(audio.getType());
        data.setLength(audio.getLength());

        Datastore.put(data);
    }

    public void delete(String url) {
        AudioFile data = findByUrl(url);
        if (data == null) {
            throw new EntityAlreadyDeletedException();
        }
        Datastore.delete(data.getKey());
    }

    public AudioFile findByUrl(String url) {
        if (StringUtil.isEmpty(url)) {
            return null;
        }
        Key key = Datastore.createKey(AudioFile.class, url);
        AudioFile audio = Datastore.getOrNull(AudioFile.class, key);
        if (audio != null) {
            return audio;
        } else {
            return Datastore
                .query(AudioFile.class)
                .filter(_url, EQUAL, url)
                .asSingle();
        }
    }

    public List<AudioFile> list() {
        return Datastore.query(AudioFile.class).sort(_ed, DESCENDING).asList();
    }

    public List<AudioFile> list(Date min, Date max) {
        ModelQuery<AudioFile> q =
            Datastore.query(AudioFile.class).sort(_ed, DESCENDING);
        if (min != null) {
            q.filter(_ed, GREATER_THAN_OR_EQUAL, min);
        }
        if (max != null) {
            q.filter(_ed, LESS_THAN_OR_EQUAL, max);
        }
        return q.asList();
    }
}
