package net.hmrradio.podcastsite.util;

import com.google.appengine.api.memcache.MemcacheService;
import com.google.appengine.api.memcache.MemcacheServiceFactory;

@SuppressWarnings("unchecked")
public class Cachestore {

    private static MemcacheService memcacheService =
        MemcacheServiceFactory.getMemcacheService();

    public static <T> T get(Object key) {
        return (T) memcacheService.get(key);
    }

    public static void put(Object key, Object value) {
        memcacheService.put(key, value);
    }
}
