package net.hmrradio.podcastsite.meta;

//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2013-04-19 17:20:30")
/** */
public final class AudioFileMeta extends org.slim3.datastore.ModelMeta<net.hmrradio.podcastsite.model.AudioFile> {

    /** */
    public final org.slim3.datastore.StringAttributeMeta<net.hmrradio.podcastsite.model.AudioFile> duration = new org.slim3.datastore.StringAttributeMeta<net.hmrradio.podcastsite.model.AudioFile>(this, "duration", "duration");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<net.hmrradio.podcastsite.model.AudioFile, java.util.Date> entryDate = new org.slim3.datastore.CoreAttributeMeta<net.hmrradio.podcastsite.model.AudioFile, java.util.Date>(this, "entryDate", "entryDate", java.util.Date.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<net.hmrradio.podcastsite.model.AudioFile, com.google.appengine.api.datastore.Key> key = new org.slim3.datastore.CoreAttributeMeta<net.hmrradio.podcastsite.model.AudioFile, com.google.appengine.api.datastore.Key>(this, "__key__", "key", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<net.hmrradio.podcastsite.model.AudioFile, java.lang.Long> length = new org.slim3.datastore.CoreAttributeMeta<net.hmrradio.podcastsite.model.AudioFile, java.lang.Long>(this, "length", "length", java.lang.Long.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<net.hmrradio.podcastsite.model.AudioFile, java.lang.Integer> schemaVersion = new org.slim3.datastore.CoreAttributeMeta<net.hmrradio.podcastsite.model.AudioFile, java.lang.Integer>(this, "schemaVersion", "schemaVersion", java.lang.Integer.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<net.hmrradio.podcastsite.model.AudioFile> type = new org.slim3.datastore.StringAttributeMeta<net.hmrradio.podcastsite.model.AudioFile>(this, "type", "type");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<net.hmrradio.podcastsite.model.AudioFile> url = new org.slim3.datastore.StringAttributeMeta<net.hmrradio.podcastsite.model.AudioFile>(this, "url", "url");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<net.hmrradio.podcastsite.model.AudioFile, java.lang.Long> version = new org.slim3.datastore.CoreAttributeMeta<net.hmrradio.podcastsite.model.AudioFile, java.lang.Long>(this, "version", "version", java.lang.Long.class);

    private static final AudioFileMeta slim3_singleton = new AudioFileMeta();

    /**
     * @return the singleton
     */
    public static AudioFileMeta get() {
       return slim3_singleton;
    }

    /** */
    public AudioFileMeta() {
        super("AudioFile", net.hmrradio.podcastsite.model.AudioFile.class);
    }

    @Override
    public net.hmrradio.podcastsite.model.AudioFile entityToModel(com.google.appengine.api.datastore.Entity entity) {
        net.hmrradio.podcastsite.model.AudioFile model = new net.hmrradio.podcastsite.model.AudioFile();
        model.setDuration((java.lang.String) entity.getProperty("duration"));
        model.setEntryDate((java.util.Date) entity.getProperty("entryDate"));
        model.setKey(entity.getKey());
        model.setLength((java.lang.Long) entity.getProperty("length"));
        model.setSchemaVersion(longToInteger((java.lang.Long) entity.getProperty("schemaVersion")));
        model.setType((java.lang.String) entity.getProperty("type"));
        model.setUrl((java.lang.String) entity.getProperty("url"));
        model.setVersion((java.lang.Long) entity.getProperty("version"));
        return model;
    }

    @Override
    public com.google.appengine.api.datastore.Entity modelToEntity(java.lang.Object model) {
        net.hmrradio.podcastsite.model.AudioFile m = (net.hmrradio.podcastsite.model.AudioFile) model;
        com.google.appengine.api.datastore.Entity entity = null;
        if (m.getKey() != null) {
            entity = new com.google.appengine.api.datastore.Entity(m.getKey());
        } else {
            entity = new com.google.appengine.api.datastore.Entity(kind);
        }
        entity.setProperty("duration", m.getDuration());
        entity.setProperty("entryDate", m.getEntryDate());
        entity.setProperty("length", m.getLength());
        entity.setProperty("schemaVersion", m.getSchemaVersion());
        entity.setProperty("type", m.getType());
        entity.setProperty("url", m.getUrl());
        entity.setProperty("version", m.getVersion());
        return entity;
    }

    @Override
    protected com.google.appengine.api.datastore.Key getKey(Object model) {
        net.hmrradio.podcastsite.model.AudioFile m = (net.hmrradio.podcastsite.model.AudioFile) model;
        return m.getKey();
    }

    @Override
    protected void setKey(Object model, com.google.appengine.api.datastore.Key key) {
        validateKey(key);
        net.hmrradio.podcastsite.model.AudioFile m = (net.hmrradio.podcastsite.model.AudioFile) model;
        m.setKey(key);
    }

    @Override
    protected long getVersion(Object model) {
        net.hmrradio.podcastsite.model.AudioFile m = (net.hmrradio.podcastsite.model.AudioFile) model;
        return m.getVersion() != null ? m.getVersion().longValue() : 0L;
    }

    @Override
    protected void assignKeyToModelRefIfNecessary(com.google.appengine.api.datastore.AsyncDatastoreService ds, java.lang.Object model) {
    }

    @Override
    protected void incrementVersion(Object model) {
        net.hmrradio.podcastsite.model.AudioFile m = (net.hmrradio.podcastsite.model.AudioFile) model;
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
        net.hmrradio.podcastsite.model.AudioFile m = (net.hmrradio.podcastsite.model.AudioFile) model;
        writer.beginObject();
        org.slim3.datastore.json.Default encoder0 = new org.slim3.datastore.json.Default();
        if(m.getDuration() != null){
            writer.setNextPropertyName("duration");
            encoder0.encode(writer, m.getDuration());
        }
        if(m.getEntryDate() != null){
            writer.setNextPropertyName("entryDate");
            encoder0.encode(writer, m.getEntryDate());
        }
        if(m.getKey() != null){
            writer.setNextPropertyName("key");
            encoder0.encode(writer, m.getKey());
        }
        if(m.getLength() != null){
            writer.setNextPropertyName("length");
            encoder0.encode(writer, m.getLength());
        }
        if(m.getSchemaVersion() != null){
            writer.setNextPropertyName("schemaVersion");
            encoder0.encode(writer, m.getSchemaVersion());
        }
        if(m.getType() != null){
            writer.setNextPropertyName("type");
            encoder0.encode(writer, m.getType());
        }
        if(m.getUrl() != null){
            writer.setNextPropertyName("url");
            encoder0.encode(writer, m.getUrl());
        }
        if(m.getVersion() != null){
            writer.setNextPropertyName("version");
            encoder0.encode(writer, m.getVersion());
        }
        writer.endObject();
    }

    @Override
    protected net.hmrradio.podcastsite.model.AudioFile jsonToModel(org.slim3.datastore.json.JsonRootReader rootReader, int maxDepth, int currentDepth) {
        net.hmrradio.podcastsite.model.AudioFile m = new net.hmrradio.podcastsite.model.AudioFile();
        org.slim3.datastore.json.JsonReader reader = null;
        org.slim3.datastore.json.Default decoder0 = new org.slim3.datastore.json.Default();
        reader = rootReader.newObjectReader("duration");
        m.setDuration(decoder0.decode(reader, m.getDuration()));
        reader = rootReader.newObjectReader("entryDate");
        m.setEntryDate(decoder0.decode(reader, m.getEntryDate()));
        reader = rootReader.newObjectReader("key");
        m.setKey(decoder0.decode(reader, m.getKey()));
        reader = rootReader.newObjectReader("length");
        m.setLength(decoder0.decode(reader, m.getLength()));
        reader = rootReader.newObjectReader("schemaVersion");
        m.setSchemaVersion(decoder0.decode(reader, m.getSchemaVersion()));
        reader = rootReader.newObjectReader("type");
        m.setType(decoder0.decode(reader, m.getType()));
        reader = rootReader.newObjectReader("url");
        m.setUrl(decoder0.decode(reader, m.getUrl()));
        reader = rootReader.newObjectReader("version");
        m.setVersion(decoder0.decode(reader, m.getVersion()));
        return m;
    }
}