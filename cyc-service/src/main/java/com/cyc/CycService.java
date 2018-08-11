package com.cyc;

import com.cyc.resource.SortingProblemResource;
import com.cyc.resource.HelloResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

/**
 *
 */
public class CycService extends Application<CycConfiguration> {

    @Override
    public void run(CycConfiguration configuration, Environment environment) throws Exception
    {
        HelloResource helloResource = new HelloResource();
        SortingProblemResource sortingProblemResource = new SortingProblemResource();
        environment.jersey().register(helloResource);
        environment.jersey().register(sortingProblemResource);
    }
    public static void main(String[] args) throws Exception
    {
        new CycService().run(args);
    }
}
