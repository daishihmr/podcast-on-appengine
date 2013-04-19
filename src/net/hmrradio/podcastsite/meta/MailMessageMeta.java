package net.hmrradio.podcastsite.meta;

//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2013-04-19 17:20:30")
/** */
public final class MailMessageMeta extends org.slim3.datastore.ModelMeta<net.hmrradio.podcastsite.model.MailMessage> {

    /** */
    public final org.slim3.datastore.StringUnindexedAttributeMeta<net.hmrradio.podcastsite.model.MailMessage> content = new org.slim3.datastore.StringUnindexedAttributeMeta<net.hmrradio.podcastsite.model.MailMessage>(this, "content", "content");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<net.hmrradio.podcastsite.model.MailMessage, com.google.appengine.api.datastore.Key> key = new org.slim3.datastore.CoreAttributeMeta<net.hmrradio.podcastsite.model.MailMessage, com.google.appengine.api.datastore.Key>(this, "__key__", "key", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<net.hmrradio.podcastsite.model.MailMessage> mailAddress = new org.slim3.datastore.StringAttributeMeta<net.hmrradio.podcastsite.model.MailMessage>(this, "mailAddress", "mailAddress");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<net.hmrradio.podcastsite.model.MailMessage> name = new org.slim3.datastore.StringAttributeMeta<net.hmrradio.podcastsite.model.MailMessage>(this, "name", "name");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<net.hmrradio.podcastsite.model.MailMessage, java.lang.Integer> schemaVersion = new org.slim3.datastore.CoreAttributeMeta<net.hmrradio.podcastsite.model.MailMessage, java.lang.Integer>(this, "schemaVersion", "schemaVersion", java.lang.Integer.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<net.hmrradio.podcastsite.model.MailMessage, java.util.Date> sendDate = new org.slim3.datastore.CoreAttributeMeta<net.hmrradio.podcastsite.model.MailMessage, java.util.Date>(this, "sendDate", "sendDate", java.util.Date.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<net.hmrradio.podcastsite.model.MailMessage, java.lang.Long> version = new org.slim3.datastore.CoreAttributeMeta<net.hmrradio.podcastsite.model.MailMessage, java.lang.Long>(this, "version", "version", java.lang.Long.class);

    private static final MailMessageMeta slim3_singleton = new MailMessageMeta();

    /**
     * @return the singleton
     */
    public static MailMessageMeta get() {
       return slim3_singleton;
    }

    /** */
    public MailMessageMeta() {
        super("MailMessage", net.hmrradio.podcastsite.model.MailMessage.class);
    }

    @Override
    public net.hmrradio.podcastsite.model.MailMessage entityToModel(com.google.appengine.api.datastore.Entity entity) {
        net.hmrradio.podcastsite.model.MailMessage model = new net.hmrradio.podcastsite.model.MailMessage();
        model.setContent(textToString((com.google.appengine.api.datastore.Text) entity.getProperty("content")));
        model.setKey(entity.getKey());
        model.setMailAddress((java.lang.String) entity.getProperty("mailAddress"));
        model.setName((java.lang.String) entity.getProperty("name"));
        model.setSchemaVersion(longToInteger((java.lang.Long) entity.getProperty("schemaVersion")));
        model.setSendDate((java.util.Date) entity.getProperty("sendDate"));
        model.setVersion((java.lang.Long) entity.getProperty("version"));
        return model;
    }

    @Override
    public com.google.appengine.api.datastore.Entity modelToEntity(java.lang.Object model) {
        net.hmrradio.podcastsite.model.MailMessage m = (net.hmrradio.podcastsite.model.MailMessage) model;
        com.google.appengine.api.datastore.Entity entity = null;
        if (m.getKey() != null) {
            entity = new com.google.appengine.api.datastore.Entity(m.getKey());
        } else {
            entity = new com.google.appengine.api.datastore.Entity(kind);
        }
        entity.setUnindexedProperty("content", stringToText(m.getContent()));
        entity.setProperty("mailAddress", m.getMailAddress());
        entity.setProperty("name", m.getName());
        entity.setProperty("schemaVersion", m.getSchemaVersion());
        entity.setProperty("sendDate", m.getSendDate());
        entity.setProperty("version", m.getVersion());
        return entity;
    }

    @Override
    protected com.google.appengine.api.datastore.Key getKey(Object model) {
        net.hmrradio.podcastsite.model.MailMessage m = (net.hmrradio.podcastsite.model.MailMessage) model;
        return m.getKey();
    }

    @Override
    protected void setKey(Object model, com.google.appengine.api.datastore.Key key) {
        validateKey(key);
        net.hmrradio.podcastsite.model.MailMessage m = (net.hmrradio.podcastsite.model.MailMessage) model;
        m.setKey(key);
    }

    @Override
    protected long getVersion(Object model) {
        net.hmrradio.podcastsite.model.MailMessage m = (net.hmrradio.podcastsite.model.MailMessage) model;
        return m.getVersion() != null ? m.getVersion().longValue() : 0L;
    }

    @Override
    protected void assignKeyToModelRefIfNecessary(com.google.appengine.api.datastore.AsyncDatastoreService ds, java.lang.Object model) {
    }

    @Override
    protected void incrementVersion(Object model) {
        net.hmrradio.podcastsite.model.MailMessage m = (net.hmrradio.podcastsite.model.MailMessage) model;
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
        net.hmrradio.podcastsite.model.MailMessage m = (net.hmrradio.podcastsite.model.MailMessage) model;
        writer.beginObject();
        org.slim3.datastore.json.Default encoder0 = new org.slim3.datastore.json.Default();
        if(m.getContent() != null){
            writer.setNextPropertyName("content");
            encoder0.encode(writer, m.getContent());
        }
        if(m.getKey() != null){
            writer.setNextPropertyName("key");
            encoder0.encode(writer, m.getKey());
        }
        if(m.getMailAddress() != null){
            writer.setNextPropertyName("mailAddress");
            encoder0.encode(writer, m.getMailAddress());
        }
        if(m.getName() != null){
            writer.setNextPropertyName("name");
            encoder0.encode(writer, m.getName());
        }
        if(m.getSchemaVersion() != null){
            writer.setNextPropertyName("schemaVersion");
            encoder0.encode(writer, m.getSchemaVersion());
        }
        if(m.getSendDate() != null){
            writer.setNextPropertyName("sendDate");
            encoder0.encode(writer, m.getSendDate());
        }
        if(m.getVersion() != null){
            writer.setNextPropertyName("version");
            encoder0.encode(writer, m.getVersion());
        }
        writer.endObject();
    }

    @Override
    protected net.hmrradio.podcastsite.model.MailMessage jsonToModel(org.slim3.datastore.json.JsonRootReader rootReader, int maxDepth, int currentDepth) {
        net.hmrradio.podcastsite.model.MailMessage m = new net.hmrradio.podcastsite.model.MailMessage();
        org.slim3.datastore.json.JsonReader reader = null;
        org.slim3.datastore.json.Default decoder0 = new org.slim3.datastore.json.Default();
        reader = rootReader.newObjectReader("content");
        m.setContent(decoder0.decode(reader, m.getContent()));
        reader = rootReader.newObjectReader("key");
        m.setKey(decoder0.decode(reader, m.getKey()));
        reader = rootReader.newObjectReader("mailAddress");
        m.setMailAddress(decoder0.decode(reader, m.getMailAddress()));
        reader = rootReader.newObjectReader("name");
        m.setName(decoder0.decode(reader, m.getName()));
        reader = rootReader.newObjectReader("schemaVersion");
        m.setSchemaVersion(decoder0.decode(reader, m.getSchemaVersion()));
        reader = rootReader.newObjectReader("sendDate");
        m.setSendDate(decoder0.decode(reader, m.getSendDate()));
        reader = rootReader.newObjectReader("version");
        m.setVersion(decoder0.decode(reader, m.getVersion()));
        return m;
    }
}