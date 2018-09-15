package com.dynamic.api;

import org.glassfish.jersey.process.Inflector;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.model.Resource;
import org.glassfish.jersey.server.model.ResourceMethod;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.core.MediaType;

public class DynamicResourceConfig extends ResourceConfig {
    public DynamicResourceConfig() {
    }

    public static Resource getHelloWorldResource() {
        final Resource.Builder resourceBuilder = Resource.builder();
        resourceBuilder.path("hellomyworld");

        final ResourceMethod.Builder methodBuilder = resourceBuilder.addMethod("GET");
        methodBuilder.produces(MediaType.TEXT_PLAIN_TYPE)
                .handledBy(new Inflector<ContainerRequestContext, String>() {
                    @Override
                    public String apply(ContainerRequestContext containerRequestContext) {
                        return "Hello World!";
                    }
                });

        return resourceBuilder.build();
    }
}
