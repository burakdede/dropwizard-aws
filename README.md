Dropwizard Aws Bundle
======================

Bundle for connecting common aws services in Dropwizard application.

Dependency
----------

```xml
<dependency>
    <groupId>com.burakdede</groupId>
    <artifactId>dropwizard-aws</artifactId>
    <version>0.0.3</version>
</dependency>
```

Usage
-----

Add `AwsFactory` to your application `Configuration` file

```java
@JsonProperty("aws")
public AwsFactory awsFactory;

public AwsFactory getAwsFactory() {
    return awsFactory;
}
```

Add `AwsBundle` to your startup `App` class.

```java
bootstrap.addBundle(new AwsBundle<ServiceConfiguration>() {
    @Override
    public AwsFactory getAwsFactory(ServiceConfiguration configuration) {
        return configuration.getAwsFactory();
    }
});
```

`Context` injection will be auto enabled across `Resource` classes with injection.

```java
@GET
@Path("/person/{id}")
public Response getPerson(@PathParam("id") Integer id, @Context AmazonSNSClient sns) {
    ...
}
```

Configuration
------------

```yml
aws:
    accessKey: <your-access-key>
    secretKey: <your-secret-key>
```

