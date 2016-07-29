package com.burakdede.jersey;

import com.amazonaws.services.sqs.AmazonSQSClient;
import org.glassfish.hk2.api.Factory;

/**
 * Created by burakdede on 29/07/16.
 */
public class SQSClientFactory implements Factory<AmazonSQSClient> {

    private final AmazonSQSClient sqs;

    public SQSClientFactory(AmazonSQSClient sqs) {
        this.sqs = sqs;
    }

    @Override
    public AmazonSQSClient provide() {
        return sqs;
    }

    @Override
    public void dispose(AmazonSQSClient o) {

    }
}
