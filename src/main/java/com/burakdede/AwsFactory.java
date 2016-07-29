package com.burakdede;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sqs.AmazonSQSClient;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

/**
 * Created by burakdede on 29/07/16.
 */
public class AwsFactory {

    @JsonProperty
    @NotNull
    private String accessKey;

    @JsonProperty
    @NotNull
    private String secretKey;

    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public AmazonSQSClient buildAmazonSQSClient() {
        final AWSCredentials awsCredentials = new BasicAWSCredentials(accessKey, secretKey);
        AmazonSQSClient sqs = new AmazonSQSClient(awsCredentials);
        return sqs;
    }

    public AmazonSNSClient buildAmazonSNSClient() {
        final AWSCredentials awsCredentials = new BasicAWSCredentials(accessKey, secretKey);
        AmazonSNSClient sns = new AmazonSNSClient(awsCredentials);
        return sns;
    }

    public AmazonS3Client buildS3Client() {
        final AWSCredentials awsCredentials = new BasicAWSCredentials(accessKey, secretKey);
        AmazonS3Client s3 = new AmazonS3Client(awsCredentials);
        return s3;
    }
}
