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

<repositories>
    <repository>
        <id>bintray</id>
        <url>https://dl.bintray.com/burakdd/maven/</url>
    </repository>
</repositories>
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

`@Context` injection will be auto enabled across all `Resource` classes with injection.

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

License
-------

Copyright (C) Burak Dede.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.


