package com.dynamic.api;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

/**
 * Hello world!
 *
 */
public class DynamicApi extends Application<DAConfiguration> {
    public static void main( String[] args ) throws Exception {
        new DynamicApi().run(args);
    }

    public String getName() {
        return "Dynamic Api";
    }

    @Override
    public void run(DAConfiguration daConfiguration, Environment environment) throws Exception {
        final DynamicApiResources resources = new DynamicApiResources(daConfiguration.getTemplate(), daConfiguration.getDefaultName());
        final TemplateHealthCheck healthCheck = new TemplateHealthCheck(daConfiguration.getTemplate());
        environment.healthChecks().register("template", healthCheck);
        environment.jersey().register(resources);
    }

    @Override
    public void initialize(Bootstrap<DAConfiguration> bootstrap) {

    }
}
