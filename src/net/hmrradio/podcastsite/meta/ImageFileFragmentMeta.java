package net.hmrradio.podcastsite.meta;

//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2013-04-19 17:20:30")
/** */
public final class ImageFileFragmentMeta extends org.slim3.datastore.ModelMeta<net.hmrradio.podcastsite.model.ImageFileFragment> {

    /** */
    public final org.slim3.datastore.CoreUnindexedAttributeMeta<net.hmrradio.podcastsite.model.ImageFileFragment, byte[]> bytes = new org.slim3.datastore.CoreUnindexedAttributeMeta<net.hmrradio.podcastsite.model.ImageFileFragment, byte[]>(this, "bytes", "bytes", byte[].class);

    /** */
    public final org.slim3.datastore.ModelRefAttributeMeta<net.hmrradio.podcastsite.model.ImageFileFragment, org.slim3.datastore.ModelRef<net.hmrradio.podcastsite.model.ImageFile>, net.hmrradio.podcastsite.model.ImageFile> imageDataRef = new org.slim3.datastore.ModelRefAttributeMeta<net.hmrradio.podcastsite.model.ImageFileFragment, org.slim3.datastore.ModelRef<net.hmrradio.podcastsite.model.ImageFile>, net.hmrradio.podcastsite.model.ImageFile>(this, "imageDataRef", "imageDataRef", org.slim3.datastore.ModelRef.class, net.hmrradio.podcastsite.model.ImageFile.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<net.hmrradio.podcastsite.model.ImageFileFragment, java.lang.Integer> index = new org.slim3.datastore.CoreAttributeMeta<net.hmrradio.podcastsite.model.ImageFileFragment, java.lang.Integer>(this, "index", "index", int.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<net.hmrradio.podcastsite.model.ImageFileFragment, com.google.appengine.api.datastore.Key> key = new org.slim3.datastore.CoreAttributeMeta<net.hmrradio.podcastsite.model.ImageFileFragment, com.google.appengine.api.datastore.Key>(this, "__key__", "key", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<net.hmrradio.podcastsite.model.ImageFileFragment, java.lang.Long> version = new org.slim3.datastore.CoreAttributeMeta<net.hmrradio.podcastsite.model.ImageFileFragment, java.lang.Long>(this, "version", "version", java.lang.Long.class);

    private static final ImageFileFragmentMeta slim3_singleton = new ImageFileFragmentMeta();

    /**
     * @return the singleton
     */
    public static ImageFileFragmentMeta get() {
       return slim3_singleton;
    }

    /** */
    public ImageFileFragmentMeta() {
        super("ImageFileFragment", net.hmrradio.podcastsite.model.ImageFileFragment.class);
    }

    @Override
    public net.hmrradio.podcastsite.model.ImageFileFragment entityToModel(com.google.appengine.api.datastore.Entity entity) {
        net.hmrradio.podcastsite.model.ImageFileFragment model = new net.hmrradio.podcastsite.model.ImageFileFragment();
        model.setBytes(blobToBytes((com.google.appengine.api.datastore.Blob) entity.getProperty("bytes")));
        if (model.getImageDataRef() == null) {
            throw new NullPointerException("The property(imageDataRef) is null.");
        }
        model.getImageDataRef().setKey((com.google.appengine.api.datastore.Key) entity.getProperty("imageDataRef"));
        model.setIndex(longToPrimitiveInt((java.lang.Long) entity.getProperty("index")));
        model.setKey(entity.getKey());
        model.setVersion((java.lang.Long) entity.getProperty("version"));
        return model;
    }

    @Override
    public com.google.appengine.api.datastore.Entity modelToEntity(java.lang.Object model) {
        net.hmrradio.podcastsite.model.ImageFileFragment m = (net.hmrradio.podcastsite.model.ImageFileFragment) model;
        com.google.appengine.api.datastore.Entity entity = null;
        if (m.getKey() != null) {
            entity = new com.google.appengine.api.datastore.Entity(m.getKey());
        } else {
            entity = new com.google.appengine.api.datastore.Entity(kind);
        }
        entity.setUnindexedProperty("bytes", bytesToBlob(m.getBytes()));
        if (m.getImageDataRef() == null) {
            throw new NullPointerException("The property(imageDataRef) must not be null.");
        }
        entity.setProperty("imageDataRef", m.getImageDataRef().getKey());
        entity.setProperty("index", m.getIndex());
        entity.setProperty("version", m.getVersion());
        entity.setProperty("slim3.schemaVersion", 1);
        return entity;
    }

    @Override
    protected com.google.appengine.api.datastore.Key getKey(Object model) {
        net.hmrradio.podcastsite.model.ImageFileFragment m = (net.hmrradio.podcastsite.model.ImageFileFragment) model;
        return m.getKey();
    }

    @Override
    protected void setKey(Object model, com.google.appengine.api.datastore.Key key) {
        validateKey(key);
        net.hmrradio.podcastsite.model.ImageFileFragment m = (net.hmrradio.podcastsite.model.ImageFileFragment) model;
        m.setKey(key);
    }

    @Override
    protected long getVersion(Object model) {
        net.hmrradio.podcastsite.model.ImageFileFragment m = (net.hmrradio.podcastsite.model.ImageFileFragment) model;
        return m.getVersion() != null ? m.getVersion().longValue() : 0L;
    }

    @Override
    protected void assignKeyToModelRefIfNecessary(com.google.appengine.api.datastore.AsyncDatastoreService ds, java.lang.Object model) {
        net.hmrradio.podcastsite.model.ImageFileFragment m = (net.hmrradio.podcastsite.model.ImageFileFragment) model;
        if (m.getImageDataRef() == null) {
            throw new NullPointerException("The property(imageDataRef) must not be null.");
        }
        m.getImageDataRef().assignKeyIfNecessary(ds);
    }

    @Override
    protected void incrementVersion(Object model) {
        net.hmrradio.podcastsite.model.ImageFileFragment m = (net.hmrradio.podcastsite.model.ImageFileFragment) model;
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
        net.hmrradio.podcastsite.model.ImageFileFragment m = (net.hmrradio.podcastsite.model.ImageFileFragment) model;
        writer.beginObject();
        org.slim3.datastore.json.Default encoder0 = new org.slim3.datastore.json.Default();
        if(m.getBytes() != null){
            writer.setNextPropertyName("bytes");
            encoder0.encode(writer, new com.google.appengine.api.datastore.ShortBlob(m.getBytes()));
        }
        if(m.getImageDataRef() != null && m.getImageDataRef().getKey() != null){
            writer.setNextPropertyName("imageDataRef");
            encoder0.encode(writer, m.getImageDataRef(), maxDepth, currentDepth);
        }
        writer.setNextPropertyName("index");
        encoder0.encode(writer, m.getIndex());
        if(m.getKey() != null){
            writer.setNextPropertyName("key");
            encoder0.encode(writer, m.getKey());
        }
        if(m.getVersion() != null){
            writer.setNextPropertyName("version");
            encoder0.encode(writer, m.getVersion());
        }
        writer.endObject();
    }

    @Override
    protected net.hmrradio.podcastsite.model.ImageFileFragment jsonToModel(org.slim3.datastore.json.JsonRootReader rootReader, int maxDepth, int currentDepth) {
        net.hmrradio.podcastsite.model.ImageFileFragment m = new net.hmrradio.podcastsite.model.ImageFileFragment();
        org.slim3.datastore.json.JsonReader reader = null;
        org.slim3.datastore.json.Default decoder0 = new org.slim3.datastore.json.Default();
        reader = rootReader.newObjectReader("bytes");
        if(m.getBytes() != null){
            m.setBytes(decoder0.decode(reader, new com.google.appengine.api.datastore.ShortBlob(m.getBytes())).getBytes());
        } else{
            com.google.appengine.api.datastore.ShortBlob v = decoder0.decode(reader, (com.google.appengine.api.datastore.ShortBlob)null);
            if(v != null){
                m.setBytes(v.getBytes());
            } else{
                m.setBytes(null);
            }
        }
        reader = rootReader.newObjectReader("imageDataRef");
        decoder0.decode(reader, m.getImageDataRef(), maxDepth, currentDepth);
        reader = rootReader.newObjectReader("index");
        m.setIndex(decoder0.decode(reader, m.getIndex()));
        reader = rootReader.newObjectReader("key");
        m.setKey(decoder0.decode(reader, m.getKey()));
        reader = rootReader.newObjectReader("version");
        m.setVersion(decoder0.decode(reader, m.getVersion()));
        return m;
    }
}