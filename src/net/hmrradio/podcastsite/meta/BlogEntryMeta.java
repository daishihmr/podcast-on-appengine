package net.hmrradio.podcastsite.meta;

//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2013-04-19 17:20:54")
/** */
public final class BlogEntryMeta extends org.slim3.datastore.ModelMeta<net.hmrradio.podcastsite.model.BlogEntry> {

    /** */
    public final org.slim3.datastore.StringAttributeMeta<net.hmrradio.podcastsite.model.BlogEntry> audioFileURL = new org.slim3.datastore.StringAttributeMeta<net.hmrradio.podcastsite.model.BlogEntry>(this, "audioFileURL", "audioFileURL");

    /** */
    public final org.slim3.datastore.UnindexedAttributeMeta<net.hmrradio.podcastsite.model.BlogEntry, com.google.appengine.api.datastore.Text> content = new org.slim3.datastore.UnindexedAttributeMeta<net.hmrradio.podcastsite.model.BlogEntry, com.google.appengine.api.datastore.Text>(this, "content", "content", com.google.appengine.api.datastore.Text.class);

    /** */
    public final org.slim3.datastore.StringCollectionAttributeMeta<net.hmrradio.podcastsite.model.BlogEntry, java.util.Set<java.lang.String>> corners = new org.slim3.datastore.StringCollectionAttributeMeta<net.hmrradio.podcastsite.model.BlogEntry, java.util.Set<java.lang.String>>(this, "corners", "corners", java.util.Set.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<net.hmrradio.podcastsite.model.BlogEntry> coverImageKey = new org.slim3.datastore.StringAttributeMeta<net.hmrradio.podcastsite.model.BlogEntry>(this, "coverImageKey", "coverImageKey");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<net.hmrradio.podcastsite.model.BlogEntry, java.util.Date> createDate = new org.slim3.datastore.CoreAttributeMeta<net.hmrradio.podcastsite.model.BlogEntry, java.util.Date>(this, "createDate", "createDate", java.util.Date.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<net.hmrradio.podcastsite.model.BlogEntry, com.google.appengine.api.datastore.Key> key = new org.slim3.datastore.CoreAttributeMeta<net.hmrradio.podcastsite.model.BlogEntry, com.google.appengine.api.datastore.Key>(this, "__key__", "key", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.StringCollectionAttributeMeta<net.hmrradio.podcastsite.model.BlogEntry, java.util.Set<java.lang.String>> members = new org.slim3.datastore.StringCollectionAttributeMeta<net.hmrradio.podcastsite.model.BlogEntry, java.util.Set<java.lang.String>>(this, "members", "members", java.util.Set.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<net.hmrradio.podcastsite.model.BlogEntry, java.util.Date> pubDate = new org.slim3.datastore.CoreAttributeMeta<net.hmrradio.podcastsite.model.BlogEntry, java.util.Date>(this, "pubDate", "pubDate", java.util.Date.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<net.hmrradio.podcastsite.model.BlogEntry, java.util.Date> recordingDate = new org.slim3.datastore.CoreAttributeMeta<net.hmrradio.podcastsite.model.BlogEntry, java.util.Date>(this, "recordingDate", "recordingDate", java.util.Date.class);

    /** */
    public final org.slim3.datastore.StringCollectionAttributeMeta<net.hmrradio.podcastsite.model.BlogEntry, java.util.Set<java.lang.String>> tags = new org.slim3.datastore.StringCollectionAttributeMeta<net.hmrradio.podcastsite.model.BlogEntry, java.util.Set<java.lang.String>>(this, "tags", "tags", java.util.Set.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<net.hmrradio.podcastsite.model.BlogEntry> title = new org.slim3.datastore.StringAttributeMeta<net.hmrradio.podcastsite.model.BlogEntry>(this, "title", "title");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<net.hmrradio.podcastsite.model.BlogEntry, java.lang.Long> version = new org.slim3.datastore.CoreAttributeMeta<net.hmrradio.podcastsite.model.BlogEntry, java.lang.Long>(this, "version", "version", java.lang.Long.class);

    private static final BlogEntryMeta slim3_singleton = new BlogEntryMeta();

    /**
     * @return the singleton
     */
    public static BlogEntryMeta get() {
       return slim3_singleton;
    }

    /** */
    public BlogEntryMeta() {
        super("BlogEntry", net.hmrradio.podcastsite.model.BlogEntry.class);
    }

    @Override
    public net.hmrradio.podcastsite.model.BlogEntry entityToModel(com.google.appengine.api.datastore.Entity entity) {
        net.hmrradio.podcastsite.model.BlogEntry model = new net.hmrradio.podcastsite.model.BlogEntry();
        model.setAudioFileURL((java.lang.String) entity.getProperty("audioFileURL"));
        model.setContent((com.google.appengine.api.datastore.Text) entity.getProperty("content"));
        model.setCorners(new java.util.HashSet<java.lang.String>(toList(java.lang.String.class, entity.getProperty("corners"))));
        model.setCoverImageKey((java.lang.String) entity.getProperty("coverImageKey"));
        model.setCreateDate((java.util.Date) entity.getProperty("createDate"));
        model.setKey(entity.getKey());
        model.setMembers(new java.util.HashSet<java.lang.String>(toList(java.lang.String.class, entity.getProperty("members"))));
        model.setPubDate((java.util.Date) entity.getProperty("pubDate"));
        model.setRecordingDate((java.util.Date) entity.getProperty("recordingDate"));
        model.setTags(new java.util.HashSet<java.lang.String>(toList(java.lang.String.class, entity.getProperty("tags"))));
        model.setTitle((java.lang.String) entity.getProperty("title"));
        model.setVersion((java.lang.Long) entity.getProperty("version"));
        return model;
    }

    @Override
    public com.google.appengine.api.datastore.Entity modelToEntity(java.lang.Object model) {
        net.hmrradio.podcastsite.model.BlogEntry m = (net.hmrradio.podcastsite.model.BlogEntry) model;
        com.google.appengine.api.datastore.Entity entity = null;
        if (m.getKey() != null) {
            entity = new com.google.appengine.api.datastore.Entity(m.getKey());
        } else {
            entity = new com.google.appengine.api.datastore.Entity(kind);
        }
        entity.setProperty("audioFileURL", m.getAudioFileURL());
        entity.setUnindexedProperty("content", m.getContent());
        entity.setProperty("corners", m.getCorners());
        entity.setProperty("coverImageKey", m.getCoverImageKey());
        entity.setProperty("createDate", m.getCreateDate());
        entity.setProperty("members", m.getMembers());
        entity.setProperty("pubDate", m.getPubDate());
        entity.setProperty("recordingDate", m.getRecordingDate());
        entity.setProperty("tags", m.getTags());
        entity.setProperty("title", m.getTitle());
        entity.setProperty("version", m.getVersion());
        entity.setProperty("slim3.schemaVersion", 1);
        return entity;
    }

    @Override
    protected com.google.appengine.api.datastore.Key getKey(Object model) {
        net.hmrradio.podcastsite.model.BlogEntry m = (net.hmrradio.podcastsite.model.BlogEntry) model;
        return m.getKey();
    }

    @Override
    protected void setKey(Object model, com.google.appengine.api.datastore.Key key) {
        validateKey(key);
        net.hmrradio.podcastsite.model.BlogEntry m = (net.hmrradio.podcastsite.model.BlogEntry) model;
        m.setKey(key);
    }

    @Override
    protected long getVersion(Object model) {
        net.hmrradio.podcastsite.model.BlogEntry m = (net.hmrradio.podcastsite.model.BlogEntry) model;
        return m.getVersion() != null ? m.getVersion().longValue() : 0L;
    }

    @Override
    protected void assignKeyToModelRefIfNecessary(com.google.appengine.api.datastore.AsyncDatastoreService ds, java.lang.Object model) {
    }

    @Override
    protected void incrementVersion(Object model) {
        net.hmrradio.podcastsite.model.BlogEntry m = (net.hmrradio.podcastsite.model.BlogEntry) model;
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
        net.hmrradio.podcastsite.model.BlogEntry m = (net.hmrradio.podcastsite.model.BlogEntry) model;
        writer.beginObject();
        org.slim3.datastore.json.Default encoder0 = new org.slim3.datastore.json.Default();
        if(m.getAudioFileURL() != null){
            writer.setNextPropertyName("audioFileURL");
            encoder0.encode(writer, m.getAudioFileURL());
        }
        if(m.getContent() != null && m.getContent().getValue() != null){
            writer.setNextPropertyName("content");
            encoder0.encode(writer, m.getContent());
        }
        if(m.getCorners() != null){
            writer.setNextPropertyName("corners");
            writer.beginArray();
            for(java.lang.String v : m.getCorners()){
                encoder0.encode(writer, v);
            }
            writer.endArray();
        }
        if(m.getCoverImageKey() != null){
            writer.setNextPropertyName("coverImageKey");
            encoder0.encode(writer, m.getCoverImageKey());
        }
        if(m.getCreateDate() != null){
            writer.setNextPropertyName("createDate");
            encoder0.encode(writer, m.getCreateDate());
        }
        if(m.getKey() != null){
            writer.setNextPropertyName("key");
            encoder0.encode(writer, m.getKey());
        }
        if(m.getMembers() != null){
            writer.setNextPropertyName("members");
            writer.beginArray();
            for(java.lang.String v : m.getMembers()){
                encoder0.encode(writer, v);
            }
            writer.endArray();
        }
        if(m.getPubDate() != null){
            writer.setNextPropertyName("pubDate");
            encoder0.encode(writer, m.getPubDate());
        }
        if(m.getRecordingDate() != null){
            writer.setNextPropertyName("recordingDate");
            encoder0.encode(writer, m.getRecordingDate());
        }
        if(m.getTags() != null){
            writer.setNextPropertyName("tags");
            writer.beginArray();
            for(java.lang.String v : m.getTags()){
                encoder0.encode(writer, v);
            }
            writer.endArray();
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
    protected net.hmrradio.podcastsite.model.BlogEntry jsonToModel(org.slim3.datastore.json.JsonRootReader rootReader, int maxDepth, int currentDepth) {
        net.hmrradio.podcastsite.model.BlogEntry m = new net.hmrradio.podcastsite.model.BlogEntry();
        org.slim3.datastore.json.JsonReader reader = null;
        org.slim3.datastore.json.Default decoder0 = new org.slim3.datastore.json.Default();
        reader = rootReader.newObjectReader("audioFileURL");
        m.setAudioFileURL(decoder0.decode(reader, m.getAudioFileURL()));
        reader = rootReader.newObjectReader("content");
        m.setContent(decoder0.decode(reader, m.getContent()));
        reader = rootReader.newObjectReader("corners");
        {
            java.util.HashSet<java.lang.String> elements = new java.util.HashSet<java.lang.String>();
            org.slim3.datastore.json.JsonArrayReader r = rootReader.newArrayReader("corners");
            if(r != null){
                reader = r;
                int n = r.length();
                for(int i = 0; i < n; i++){
                    r.setIndex(i);
                    java.lang.String v = decoder0.decode(reader, (java.lang.String)null)                    ;
                    if(v != null){
                        elements.add(v);
                    }
                }
                m.setCorners(elements);
            }
        }
        reader = rootReader.newObjectReader("coverImageKey");
        m.setCoverImageKey(decoder0.decode(reader, m.getCoverImageKey()));
        reader = rootReader.newObjectReader("createDate");
        m.setCreateDate(decoder0.decode(reader, m.getCreateDate()));
        reader = rootReader.newObjectReader("key");
        m.setKey(decoder0.decode(reader, m.getKey()));
        reader = rootReader.newObjectReader("members");
        {
            java.util.HashSet<java.lang.String> elements = new java.util.HashSet<java.lang.String>();
            org.slim3.datastore.json.JsonArrayReader r = rootReader.newArrayReader("members");
            if(r != null){
                reader = r;
                int n = r.length();
                for(int i = 0; i < n; i++){
                    r.setIndex(i);
                    java.lang.String v = decoder0.decode(reader, (java.lang.String)null)                    ;
                    if(v != null){
                        elements.add(v);
                    }
                }
                m.setMembers(elements);
            }
        }
        reader = rootReader.newObjectReader("pubDate");
        m.setPubDate(decoder0.decode(reader, m.getPubDate()));
        reader = rootReader.newObjectReader("recordingDate");
        m.setRecordingDate(decoder0.decode(reader, m.getRecordingDate()));
        reader = rootReader.newObjectReader("tags");
        {
            java.util.HashSet<java.lang.String> elements = new java.util.HashSet<java.lang.String>();
            org.slim3.datastore.json.JsonArrayReader r = rootReader.newArrayReader("tags");
            if(r != null){
                reader = r;
                int n = r.length();
                for(int i = 0; i < n; i++){
                    r.setIndex(i);
                    java.lang.String v = decoder0.decode(reader, (java.lang.String)null)                    ;
                    if(v != null){
                        elements.add(v);
                    }
                }
                m.setTags(elements);
            }
        }
        reader = rootReader.newObjectReader("title");
        m.setTitle(decoder0.decode(reader, m.getTitle()));
        reader = rootReader.newObjectReader("version");
        m.setVersion(decoder0.decode(reader, m.getVersion()));
        return m;
    }
}