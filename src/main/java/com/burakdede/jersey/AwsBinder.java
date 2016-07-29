package com.burakdede.jersey;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sqs.AmazonSQSClient;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.process.internal.RequestScoped;

/**
 * Created by burakdede on 29/07/16.
 */
public class AwsBinder extends AbstractBinder {

    private final AmazonSNSClient sns;
    private final AmazonSQSClient sqs;
    private final AmazonS3Client s3;

    public AwsBinder(AmazonSNSClient sns, AmazonSQSClient sqs, AmazonS3Client s3) {
        this.sns = sns;
        this.sqs = sqs;
        this.s3 = s3;
    }

    @Override
    protected void configure() {
        bind(sns).to(AmazonSNSClient.class);
        bind(sqs).to(AmazonSQSClient.class);
        bind(s3).to(AmazonS3Client.class);

        bindFactory(new SNSClientFactory(sns))
                .to(AmazonSNSClient.class)
                .in(RequestScoped.class);

        bindFactory(new SQSClientFactory(sqs))
                .to(AmazonSQSClient.class)
                .in(RequestScoped.class);

        bindFactory(new S3ClientFactory(s3))
                .to(AmazonS3Client.class)
                .in(RequestScoped.class);
    }
}
