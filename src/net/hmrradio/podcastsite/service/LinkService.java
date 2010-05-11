package net.hmrradio.podcastsite.service;

import static com.google.appengine.api.datastore.Query.FilterOperator.*;

import java.util.List;

import net.hmrradio.podcastsite.define.AttrName;
import net.hmrradio.podcastsite.exception.EntityAlreadyDeletedException;
import net.hmrradio.podcastsite.exception.EntityAlreadyExistsException;
import net.hmrradio.podcastsite.meta.LinkMeta;
import net.hmrradio.podcastsite.model.Link;
import net.hmrradio.podcastsite.util.Cachestore;

import org.slim3.datastore.Datastore;

public class LinkService {

    private LinkMeta l = LinkMeta.get();

    public Link findByUrl(String url) {
        return Datastore
            .query(Link.class)
            .filter(l.url.getName(), EQUAL, url)
            .asSingle();
    }

    public List<Link> list() {
        List<Link> result = Cachestore.get(AttrName.LINK_LIST);
        if (result == null) {
            result = Datastore.query(Link.class).asList();
            Cachestore.put(AttrName.LINK_LIST, result);
        }
        return result;
    }

    public void create(Link link) {
        if (findByUrl(link.getUrl()) != null) {
            throw new EntityAlreadyExistsException();
        }
        Datastore.put(link);
        refreshCache();
    }

    public Link update(Link link) {
        Link data = findByUrl(link.getUrl());
        if (data == null) {
            throw new EntityAlreadyDeletedException();
        }
        data.setUrl(link.getUrl());
        data.setTitle(link.getTitle());
        data.setText(link.getText());

        Datastore.put(data);
        refreshCache();
        return data;
    }

    public void delete(Link link) {
        Link data = findByUrl(link.getUrl());
        if (data == null) {
            throw new EntityAlreadyDeletedException();
        }

        Datastore.delete(data.getKey());
        refreshCache();
    }

    private void refreshCache() {
        List<Link> list = Datastore.query(Link.class).asList();
        Cachestore.put(AttrName.LINK_LIST, list);
    }

}
