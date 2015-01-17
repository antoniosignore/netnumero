package com.numhero.server.model.daolite;

import com.numhero.server.model.BlobPojo;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class BlobTest extends BaseDaoTest{

    BlobDao blobDao;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        blobDao = new BlobDao(); //NumheroUtils.injector.getInstance(BlobDao.class);
    }

    @Test
    public void testBlob() throws Exception {
        BlobPojo b = createBlob();
        assertNotNull(b);
        assertEquals(100000, b.fBlob.getValue().length);
    }

    @Test
    public void testSave() {
        BlobPojo blob = createBlob();
        blobDao.save(blob);
        assertNotNull(blob.getId());
    }

    @Test
    public void testGet() {
        BlobPojo blob = createBlob();
        blobDao.save(blob);

        BlobPojo b2 = blobDao.get(blob.getId());
        assertEquals(100000, b2.fBlob.getValue().length);
    }

    @Test
    public void testSaveNull() {
        BlobPojo blob = createBlob();
        blob.fBlob.setValue(null);
        blobDao.save(blob);
        assertNotNull(blob.getId());

        BlobPojo b2 = blobDao.get(blob.getId());
        assertEquals(0, b2.fBlob.getValue().length);
    }

    private BlobPojo createBlob() {
        BlobPojo b = new BlobPojo();

        byte[] bin = new byte[100000];
        b.fBlob.setValue(bin);
        return b;
    }
}
