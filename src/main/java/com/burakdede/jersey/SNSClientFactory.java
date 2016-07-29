package com.burakdede.jersey;

import com.amazonaws.services.sns.AmazonSNSClient;
import org.glassfish.hk2.api.Factory;

/**
 * Created by burakdede on 29/07/16.
 */
public class SNSClientFactory implements Factory<AmazonSNSClient> {

    private final AmazonSNSClient sns;

    public SNSClientFactory(AmazonSNSClient sns) {
        this.sns = sns;
    }

    @Override
    public AmazonSNSClient provide() {
        return sns;
    }

    @Override
    public void dispose(AmazonSNSClient amazonSNSClient) {

    }
}
