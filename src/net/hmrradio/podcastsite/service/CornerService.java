package net.hmrradio.podcastsite.service;

import java.util.List;

import net.hmrradio.podcastsite.exception.EntityAlreadyDeletedException;
import net.hmrradio.podcastsite.exception.EntityAlreadyExistsException;
import net.hmrradio.podcastsite.meta.CornerMeta;
import net.hmrradio.podcastsite.model.Corner;

import org.slim3.datastore.Datastore;

import com.google.appengine.api.datastore.Query.FilterOperator;

public class CornerService {

    private static CornerMeta meta = CornerMeta.get();
    private static String _title = meta.title.getName();

    public Corner findByTitle(String title) {
        return Datastore.query(Corner.class).filter(
            _title,
            FilterOperator.EQUAL,
            title).asSingle();
    }

    public void create(Corner corner) {
        if (findByTitle(corner.getTitle()) != null) {
            throw new EntityAlreadyExistsException();
        }
        Datastore.put(corner);
    }

    public List<Corner> list() {
        return Datastore.query(Corner.class).sort(_title).asList();
    }

    public void update(Corner corner) {
        Corner base = findByTitle(corner.getTitle());
        if (base == null) {
            throw new EntityAlreadyDeletedException();
        }

        base.setDescription(corner.getDescription());
        Datastore.put(base);
    }

    public void delete(String title) {
        Corner base = findByTitle(title);
        if (base == null) {
            throw new EntityAlreadyDeletedException();
        }

        Datastore.delete(base.getKey());
    }

    public void put(Corner corner) {
        if (corner == null) {
            return;
        }
        Datastore.put(corner);
    }

}
