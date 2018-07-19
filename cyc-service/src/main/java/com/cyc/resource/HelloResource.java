package com.cyc.resource;

import com.cyc.service.HelloService;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/greeting")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class HelloResource
{
    @GET
    public String getGreeting()
    {
        HelloService service = new HelloService();
        return service.getGreeting();
    }

}
