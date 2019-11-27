package com.linux.shower.boundry;

import com.linux.shower.entity.Shower;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.metrics.annotation.Counted;

import javax.inject.Inject;
import javax.json.Json;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import java.net.URI;
import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

@Path("/showers")
public class ShowersResource {

    @Inject
    @ConfigProperty(name = "shower.location")
    String showerLocation;

    ThreadLocalRandom random = ThreadLocalRandom.current();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Counted(name = "getShower", absolute = true)
    @Fallback(fallbackMethod = "defaultShower")
    public Shower shower() {
        if(random.nextBoolean()) {
            throw new RuntimeException();
        }
        return new Shower(LocalDate.now(), 2, TimeUnit.MINUTES, "note at " + System.currentTimeMillis());
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response takeShower(Shower shower) {
        System.out.println(".");

        if(shower.duration != 0) {
            return Response.created(URI.create("1")).build();
        }
        return Response.status(Status.BAD_REQUEST).entity(Json.createObjectBuilder().add("reason", "no data").build()).build();
    }



    public Shower defaultShower() {
        return new Shower(LocalDate.now(), 5, TimeUnit.MINUTES, "usual shower nothing special.");
    }




}
