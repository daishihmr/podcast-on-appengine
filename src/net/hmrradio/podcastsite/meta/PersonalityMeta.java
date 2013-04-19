package net.hmrradio.podcastsite.meta;

//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2013-04-19 18:05:59")
/** */
public final class PersonalityMeta extends org.slim3.datastore.ModelMeta<net.hmrradio.podcastsite.model.Personality> {

    /** */
    public final org.slim3.datastore.StringAttributeMeta<net.hmrradio.podcastsite.model.Personality> icon = new org.slim3.datastore.StringAttributeMeta<net.hmrradio.podcastsite.model.Personality>(this, "icon", "icon");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<net.hmrradio.podcastsite.model.Personality, com.google.appengine.api.datastore.Key> key = new org.slim3.datastore.CoreAttributeMeta<net.hmrradio.podcastsite.model.Personality, com.google.appengine.api.datastore.Key>(this, "__key__", "key", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<net.hmrradio.podcastsite.model.Personality> name = new org.slim3.datastore.StringAttributeMeta<net.hmrradio.podcastsite.model.Personality>(this, "name", "name");

    /** */
    public final org.slim3.datastore.UnindexedAttributeMeta<net.hmrradio.podcastsite.model.Personality, com.google.appengine.api.datastore.Text> profile = new org.slim3.datastore.UnindexedAttributeMeta<net.hmrradio.podcastsite.model.Personality, com.google.appengine.api.datastore.Text>(this, "profile", "profile", com.google.appengine.api.datastore.Text.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<net.hmrradio.podcastsite.model.Personality> twitterId = new org.slim3.datastore.StringAttributeMeta<net.hmrradio.podcastsite.model.Personality>(this, "twitterId", "twitterId");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<net.hmrradio.podcastsite.model.Personality, java.lang.Long> version = new org.slim3.datastore.CoreAttributeMeta<net.hmrradio.podcastsite.model.Personality, java.lang.Long>(this, "version", "version", java.lang.Long.class);

    private static final PersonalityMeta slim3_singleton = new PersonalityMeta();

    /**
     * @return the singleton
     */
    public static PersonalityMeta get() {
       return slim3_singleton;
    }

    /** */
    public PersonalityMeta() {
        super("Personality", net.hmrradio.podcastsite.model.Personality.class);
    }

    @Override
    public net.hmrradio.podcastsite.model.Personality entityToModel(com.google.appengine.api.datastore.Entity entity) {
        net.hmrradio.podcastsite.model.Personality model = new net.hmrradio.podcastsite.model.Personality();
        model.setIcon((java.lang.String) entity.getProperty("icon"));
        model.setKey(entity.getKey());
        model.setName((java.lang.String) entity.getProperty("name"));
        model.setProfile((com.google.appengine.api.datastore.Text) entity.getProperty("profile"));
        model.setTwitterId((java.lang.String) entity.getProperty("twitterId"));
        model.setVersion((java.lang.Long) entity.getProperty("version"));
        return model;
    }

    @Override
    public com.google.appengine.api.datastore.Entity modelToEntity(java.lang.Object model) {
        net.hmrradio.podcastsite.model.Personality m = (net.hmrradio.podcastsite.model.Personality) model;
        com.google.appengine.api.datastore.Entity entity = null;
        if (m.getKey() != null) {
            entity = new com.google.appengine.api.datastore.Entity(m.getKey());
        } else {
            entity = new com.google.appengine.api.datastore.Entity(kind);
        }
        entity.setProperty("icon", m.getIcon());
        entity.setProperty("name", m.getName());
        entity.setUnindexedProperty("profile", m.getProfile());
        entity.setProperty("twitterId", m.getTwitterId());
        entity.setProperty("version", m.getVersion());
        entity.setProperty("slim3.schemaVersion", 1);
        return entity;
    }

    @Override
    protected com.google.appengine.api.datastore.Key getKey(Object model) {
        net.hmrradio.podcastsite.model.Personality m = (net.hmrradio.podcastsite.model.Personality) model;
        return m.getKey();
    }

    @Override
    protected void setKey(Object model, com.google.appengine.api.datastore.Key key) {
        validateKey(key);
        net.hmrradio.podcastsite.model.Personality m = (net.hmrradio.podcastsite.model.Personality) model;
        m.setKey(key);
    }

    @Override
    protected long getVersion(Object model) {
        net.hmrradio.podcastsite.model.Personality m = (net.hmrradio.podcastsite.model.Personality) model;
        return m.getVersion() != null ? m.getVersion().longValue() : 0L;
    }

    @Override
    protected void assignKeyToModelRefIfNecessary(com.google.appengine.api.datastore.AsyncDatastoreService ds, java.lang.Object model) {
    }

    @Override
    protected void incrementVersion(Object model) {
        net.hmrradio.podcastsite.model.Personality m = (net.hmrradio.podcastsite.model.Personality) model;
        long version = m.getVersion() != null ? m.getVersion().longValue() : 0L;
        m.setVersion(Long.valueOf(version + 1L));
    }

    @Override
    protected void prePut(Object model) {
    }

    @Override
    protected void postGet(Object model) {
    }

    @Override
    public String getSchemaVersionName() {
        return "slim3.schemaVersion";
    }

    @Override
    public String getClassHierarchyListName() {
        return "slim3.classHierarchyList";
    }

    @Override
    protected boolean isCipherProperty(String propertyName) {
        return false;
    }

    @Override
    protected void modelToJson(org.slim3.datastore.json.JsonWriter writer, java.lang.Object model, int maxDepth, int currentDepth) {
        net.hmrradio.podcastsite.model.Personality m = (net.hmrradio.podcastsite.model.Personality) model;
        writer.beginObject();
        org.slim3.datastore.json.Default encoder0 = new org.slim3.datastore.json.Default();
        if(m.getIcon() != null){
            writer.setNextPropertyName("icon");
            encoder0.encode(writer, m.getIcon());
        }
        if(m.getKey() != null){
            writer.setNextPropertyName("key");
            encoder0.encode(writer, m.getKey());
        }
        if(m.getName() != null){
            writer.setNextPropertyName("name");
            encoder0.encode(writer, m.getName());
        }
        if(m.getProfile() != null && m.getProfile().getValue() != null){
            writer.setNextPropertyName("profile");
            encoder0.encode(writer, m.getProfile());
        }
        if(m.getTwitterId() != null){
            writer.setNextPropertyName("twitterId");
            encoder0.encode(writer, m.getTwitterId());
        }
        if(m.getVersion() != null){
            writer.setNextPropertyName("version");
            encoder0.encode(writer, m.getVersion());
        }
        writer.endObject();
    }

    @Override
    protected net.hmrradio.podcastsite.model.Personality jsonToModel(org.slim3.datastore.json.JsonRootReader rootReader, int maxDepth, int currentDepth) {
        net.hmrradio.podcastsite.model.Personality m = new net.hmrradio.podcastsite.model.Personality();
        org.slim3.datastore.json.JsonReader reader = null;
        org.slim3.datastore.json.Default decoder0 = new org.slim3.datastore.json.Default();
        reader = rootReader.newObjectReader("icon");
        m.setIcon(decoder0.decode(reader, m.getIcon()));
        reader = rootReader.newObjectReader("key");
        m.setKey(decoder0.decode(reader, m.getKey()));
        reader = rootReader.newObjectReader("name");
        m.setName(decoder0.decode(reader, m.getName()));
        reader = rootReader.newObjectReader("profile");
        m.setProfile(decoder0.decode(reader, m.getProfile()));
        reader = rootReader.newObjectReader("twitterId");
        m.setTwitterId(decoder0.decode(reader, m.getTwitterId()));
        reader = rootReader.newObjectReader("version");
        m.setVersion(decoder0.decode(reader, m.getVersion()));
        return m;
    }
}