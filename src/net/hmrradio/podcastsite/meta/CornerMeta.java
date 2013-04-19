package net.hmrradio.podcastsite.meta;

//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2013-04-19 17:20:30")
/** */
public final class CornerMeta extends org.slim3.datastore.ModelMeta<net.hmrradio.podcastsite.model.Corner> {

    /** */
    public final org.slim3.datastore.UnindexedAttributeMeta<net.hmrradio.podcastsite.model.Corner, com.google.appengine.api.datastore.Text> description = new org.slim3.datastore.UnindexedAttributeMeta<net.hmrradio.podcastsite.model.Corner, com.google.appengine.api.datastore.Text>(this, "description", "description", com.google.appengine.api.datastore.Text.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<net.hmrradio.podcastsite.model.Corner, com.google.appengine.api.datastore.Key> key = new org.slim3.datastore.CoreAttributeMeta<net.hmrradio.podcastsite.model.Corner, com.google.appengine.api.datastore.Key>(this, "__key__", "key", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<net.hmrradio.podcastsite.model.Corner> title = new org.slim3.datastore.StringAttributeMeta<net.hmrradio.podcastsite.model.Corner>(this, "title", "title");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<net.hmrradio.podcastsite.model.Corner, java.lang.Long> version = new org.slim3.datastore.CoreAttributeMeta<net.hmrradio.podcastsite.model.Corner, java.lang.Long>(this, "version", "version", java.lang.Long.class);

    private static final CornerMeta slim3_singleton = new CornerMeta();

    /**
     * @return the singleton
     */
    public static CornerMeta get() {
       return slim3_singleton;
    }

    /** */
    public CornerMeta() {
        super("Corner", net.hmrradio.podcastsite.model.Corner.class);
    }

    @Override
    public net.hmrradio.podcastsite.model.Corner entityToModel(com.google.appengine.api.datastore.Entity entity) {
        net.hmrradio.podcastsite.model.Corner model = new net.hmrradio.podcastsite.model.Corner();
        model.setDescription((com.google.appengine.api.datastore.Text) entity.getProperty("description"));
        model.setKey(entity.getKey());
        model.setTitle((java.lang.String) entity.getProperty("title"));
        model.setVersion((java.lang.Long) entity.getProperty("version"));
        return model;
    }

    @Override
    public com.google.appengine.api.datastore.Entity modelToEntity(java.lang.Object model) {
        net.hmrradio.podcastsite.model.Corner m = (net.hmrradio.podcastsite.model.Corner) model;
        com.google.appengine.api.datastore.Entity entity = null;
        if (m.getKey() != null) {
            entity = new com.google.appengine.api.datastore.Entity(m.getKey());
        } else {
            entity = new com.google.appengine.api.datastore.Entity(kind);
        }
        entity.setUnindexedProperty("description", m.getDescription());
        entity.setProperty("title", m.getTitle());
        entity.setProperty("version", m.getVersion());
        entity.setProperty("slim3.schemaVersion", 1);
        return entity;
    }

    @Override
    protected com.google.appengine.api.datastore.Key getKey(Object model) {
        net.hmrradio.podcastsite.model.Corner m = (net.hmrradio.podcastsite.model.Corner) model;
        return m.getKey();
    }

    @Override
    protected void setKey(Object model, com.google.appengine.api.datastore.Key key) {
        validateKey(key);
        net.hmrradio.podcastsite.model.Corner m = (net.hmrradio.podcastsite.model.Corner) model;
        m.setKey(key);
    }

    @Override
    protected long getVersion(Object model) {
        net.hmrradio.podcastsite.model.Corner m = (net.hmrradio.podcastsite.model.Corner) model;
        return m.getVersion() != null ? m.getVersion().longValue() : 0L;
    }

    @Override
    protected void assignKeyToModelRefIfNecessary(com.google.appengine.api.datastore.AsyncDatastoreService ds, java.lang.Object model) {
    }

    @Override
    protected void incrementVersion(Object model) {
        net.hmrradio.podcastsite.model.Corner m = (net.hmrradio.podcastsite.model.Corner) model;
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
        net.hmrradio.podcastsite.model.Corner m = (net.hmrradio.podcastsite.model.Corner) model;
        writer.beginObject();
        org.slim3.datastore.json.Default encoder0 = new org.slim3.datastore.json.Default();
        if(m.getDescription() != null && m.getDescription().getValue() != null){
            writer.setNextPropertyName("description");
            encoder0.encode(writer, m.getDescription());
        }
        if(m.getKey() != null){
            writer.setNextPropertyName("key");
            encoder0.encode(writer, m.getKey());
        }
        if(m.getTitle() != null){
            writer.setNextPropertyName("title");
            encoder0.encode(writer, m.getTitle());
        }
        if(m.getVersion() != null){
            writer.setNextPropertyName("version");
            encoder0.encode(writer, m.getVersion());
        }
        writer.endObject();
    }

    @Override
    protected net.hmrradio.podcastsite.model.Corner jsonToModel(org.slim3.datastore.json.JsonRootReader rootReader, int maxDepth, int currentDepth) {
        net.hmrradio.podcastsite.model.Corner m = new net.hmrradio.podcastsite.model.Corner();
        org.slim3.datastore.json.JsonReader reader = null;
        org.slim3.datastore.json.Default decoder0 = new org.slim3.datastore.json.Default();
        reader = rootReader.newObjectReader("description");
        m.setDescription(decoder0.decode(reader, m.getDescription()));
        reader = rootReader.newObjectReader("key");
        m.setKey(decoder0.decode(reader, m.getKey()));
        reader = rootReader.newObjectReader("title");
        m.setTitle(decoder0.decode(reader, m.getTitle()));
        reader = rootReader.newObjectReader("version");
        m.setVersion(decoder0.decode(reader, m.getVersion()));
        return m;
    }
}