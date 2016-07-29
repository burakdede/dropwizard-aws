package com.burakdede;

import io.dropwizard.Configuration;

/**
 * Created by burakdede on 29/07/16.
 */
public interface AwsConfiguration<C extends Configuration> {

    AwsFactory getAwsFactory(C configuration);
}
