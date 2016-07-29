package com.burakdede;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sqs.AmazonSQSClient;
import com.burakdede.jersey.AwsBinder;
import io.dropwizard.Configuration;
import io.dropwizard.ConfiguredBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

/**
 * Created by burakdede on 29/07/16.
 */
public abstract class AwsBundle<C extends Configuration>
        implements ConfiguredBundle<C>, AwsConfiguration<C> {

    private AmazonSQSClient sqs;

    private AmazonSNSClient sns;

    private AmazonS3Client s3;

    public AmazonSQSClient getSqs() {
        return sqs;
    }

    public AmazonSNSClient getSns() {
        return sns;
    }

    public AmazonS3Client getS3() {
        return s3;
    }

    @Override
    public void run(C c, Environment environment) throws Exception {
        sns = getAwsFactory(c).buildAmazonSNSClient();
        sqs = getAwsFactory(c).buildAmazonSQSClient();
        s3 = getAwsFactory(c).buildS3Client();

        environment.jersey().register(new AwsBinder(sns, sqs, s3));
    }

    @Override
    public void initialize(Bootstrap<?> bootstrap) {

    }
}
