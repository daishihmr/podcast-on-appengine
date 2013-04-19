package net.hmrradio.podcastsite.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import net.hmrradio.podcastsite.meta.ImageFileFragmentMeta;
import net.hmrradio.podcastsite.meta.ImageFileMeta;
import net.hmrradio.podcastsite.model.ImageFile;
import net.hmrradio.podcastsite.model.ImageFileFragment;

import org.slim3.controller.upload.FileItem;
import org.slim3.datastore.Datastore;
import org.slim3.datastore.EntityNotFoundRuntimeException;
import org.slim3.util.ByteUtil;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.Query.SortDirection;
import com.google.appengine.api.datastore.Transaction;
import com.google.appengine.api.images.CompositeTransform;
import com.google.appengine.api.images.Image;
import com.google.appengine.api.images.ImagesService;
import com.google.appengine.api.images.ImagesServiceFactory;
import com.google.appengine.api.images.Transform;
import com.google.common.collect.Lists;

public class ImageFileService {

    private static final ImageFileMeta f = ImageFileMeta.get();
    private static final ImageFileFragmentMeta ff = ImageFileFragmentMeta.get();
    private static final int FRAGMENT_SIZE = 900000;

    public ImageFile upload(FileItem formFile) {
        if (formFile == null) {
            return null;
        }

        String fileName = formFile.getShortFileName();
        byte[] bytes = formFile.getData();

        ImageFile data = putImageFile(fileName, bytes);

        return data;
    }

    public ImageFile put(String fileName, Image image) {
        if (image == null) {
            return null;
        }

        byte[] bytes = image.getImageData();

        ImageFile data = putImageFile(fileName, bytes);

        return data;
    }

    private ImageFile putImageFile(String fileName, byte[] bytes) {
        List<Object> models = new ArrayList<Object>();
        ImageFile data = new ImageFile();
        models.add(data);
        data.setKey(Datastore.allocateId(f));
        data.setFileName(fileName);
        data.setLength(bytes.length);
        data.setUpdateAt(new Date());
        byte[][] bytesArray = ByteUtil.split(bytes, FRAGMENT_SIZE);
        Iterator<Key> keys =
            Datastore
                .allocateIds(data.getKey(), ff, bytesArray.length)
                .iterator();
        for (int i = 0; i < bytesArray.length; i++) {
            byte[] fragmentData = bytesArray[i];
            ImageFileFragment fragment = new ImageFileFragment();
            models.add(fragment);
            fragment.setKey(keys.next());
            fragment.setBytes(fragmentData);
            fragment.setIndex(i);
            fragment.getImageDataRef().setModel(data);
        }

        Transaction tx = Datastore.beginTransaction();
        for (Object model : models) {
            Datastore.put(tx, model);
        }
        tx.commit();
        return data;
    }

    public ImageFile getData(Key key) {
        try {
            return Datastore.get(f, key);
        } catch (EntityNotFoundRuntimeException e) {
            return null;
        }
    }

    public Image toImage(FileItem formFile) {
        if (formFile == null) {
            return null;
        }
        byte[] bytes = formFile.getData();
        return ImagesServiceFactory.makeImage(bytes);
    }

    public byte[] getBytes(ImageFile data) {
        if (data == null) {
            throw new NullPointerException(
                "The data parameter must not be null.");
        }

        List<ImageFileFragment> fragmentList =
            data.getFragmentListRef().getModelList();
        byte[][] bytesArray = new byte[fragmentList.size()][0];
        for (int i = 0; i < fragmentList.size(); i++) {
            bytesArray[i] = fragmentList.get(i).getBytes();
        }

        return ByteUtil.join(bytesArray);
    }

    public void delete(Key key) {
        Datastore.deleteAll(key);
    }

    public Image getImage(ImageFile data) {
        return ImagesServiceFactory.makeImage(getBytes(data));
    }

    public Image sizeCoverImage(Image image) {
        int w = image.getWidth();
        int h = image.getHeight();
        if (w > h) {
            h = h * w / 300;
            w = 300;
        } else {
            w = w * h / 300;
            h = 300;
        }

        ImagesService service = ImagesServiceFactory.getImagesService();
        Transform resize = ImagesServiceFactory.makeResize(w, h);

        CompositeTransform t = ImagesServiceFactory.makeCompositeTransform();
        t.concatenate(resize);

        return service.applyTransform(t, image);
    }

    public List<String> list() {
        List<Key> keyList =
            Datastore
                .query(ImageFile.class)
                .sort(f.updateAt.getName(), SortDirection.DESCENDING)
                .asKeyList();
        List<String> result = Lists.newArrayList();
        for (Key key : keyList) {
            result.add(KeyFactory.keyToString(key));
        }
        return result;
    }

}
