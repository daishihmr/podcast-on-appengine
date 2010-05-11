package net.hmrradio.podcastsite.service;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.List;

import net.hmrradio.podcastsite.model.Personality;

import org.junit.Test;
import org.slim3.datastore.Datastore;
import org.slim3.tester.AppEngineTestCase;

import com.google.appengine.api.datastore.Text;

public class PersonalityServiceTest extends AppEngineTestCase {

    private PersonalityService service = new PersonalityService();

    @Test
    public void test() throws Exception {
        assertThat(service, is(notNullValue()));
    }

    @Test
    public void testFindByName() throws Exception {
        Personality personality = new Personality();
        personality.setName("だいし");
        Datastore.put(personality);

        Personality result = service.findByName("だいし");

        assertThat(result, is(personality));
    }

    @Test
    public void testRead() throws Exception {
        Personality p;
        for (int i = 0; i < 10; i++) {
            p = new Personality();
            p.setName("name" + i);
            Datastore.put(p);
        }

        List<Personality> list = service.list();
        assertThat(list.size(), is(10));
    }

    @Test
    public void testUpdate() throws Exception {
        Personality p = new Personality();
        p.setName("福田");
        p.setProfile(new Text("変態ベーシスト"));
        Datastore.put(p);

        try {
            service.update(p);
        } catch (Exception e) {
            fail();
        }

        try {
            p.setName("福田２");
            service.update(p);
        } catch (Exception e) {
            assertTrue(true);
            return;
        }
        fail();
    }

    @Test
    public void testDelete() throws Exception {
        Personality p = new Personality();
        p.setName("斉藤");
        p.setProfile(new Text("コンビニ"));
        Datastore.put(p);

        try {
            service.delete("斉藤");
        } catch (Exception e) {
            fail();
        }

        try {
            service.delete("だいし");
        } catch (Exception e) {
            assertTrue(true);
            return;
        }
        fail();
    }
}
