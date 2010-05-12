package net.hmrradio.podcastsite.util;

import net.hmrradio.podcastsite.model.ModelCount;

import org.junit.Test;
import org.slim3.datastore.Datastore;
import org.slim3.tester.AppEngineTestCase;

import com.google.appengine.api.datastore.Key;

public class JSONUtilTest extends AppEngineTestCase {

    @Test
    public void go() throws Exception {
        ModelCount mc = new ModelCount();
        Key key = Datastore.allocateId(ModelCount.class);
        mc.setKey(key);
        Datastore.put(mc);

        ModelCount mc2 = Datastore.get(ModelCount.class, key);

        System.out.println(mc2);
    }
}
