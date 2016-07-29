package com.burakdede.jersey;

import com.amazonaws.services.s3.AmazonS3Client;
import org.glassfish.hk2.api.Factory;

/**
 * Created by burakdede on 29/07/16.
 */
public class S3ClientFactory implements Factory<Object> {
    private final AmazonS3Client s3;

    public S3ClientFactory(AmazonS3Client s3) {
        this.s3 = s3;
    }

    @Override
    public Object provide() {
        return s3;
    }

    @Override
    public void dispose(Object o) {

    }
}
