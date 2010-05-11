package net.hmrradio.podcastsite.service;

import static com.google.appengine.api.datastore.Query.FilterOperator.*;

import java.util.List;

import net.hmrradio.podcastsite.exception.EntityAlreadyDeletedException;
import net.hmrradio.podcastsite.meta.PersonalityMeta;
import net.hmrradio.podcastsite.model.Personality;

import org.slim3.datastore.Datastore;

import com.google.appengine.api.datastore.Query.SortDirection;

public class PersonalityService {

    private static final PersonalityMeta meta = PersonalityMeta.get();
    private static final String _name = meta.name.getName();

    public Personality findByName(String name) {
        return Datastore
            .query(Personality.class)
            .filter(_name, EQUAL, name)
            .asSingle();
    }

    public List<Personality> list() {
        return Datastore.query(Personality.class).sort(
            _name,
            SortDirection.ASCENDING).asList();
    }

    public void update(Personality p) {
        Personality data = findByName(p.getName());
        if (data == null) {
            throw new EntityAlreadyDeletedException();
        }

        data.setTwitterId(p.getTwitterId());
        data.setProfile(p.getProfile());
        Datastore.put(data);
    }

    public void delete(String name) {
        Personality data = findByName(name);
        if (data == null) {
            throw new EntityAlreadyDeletedException();
        }

        Datastore.delete(data.getKey());
    }

    public void put(Personality personality) {
        if (personality == null) {
            return;
        }
        Datastore.put(personality);
    }

}
