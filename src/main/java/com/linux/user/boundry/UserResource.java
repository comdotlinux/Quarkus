package com.linux.user.boundry;

import io.quarkus.security.identity.SecurityIdentity;
import org.jboss.resteasy.annotations.cache.NoCache;

import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/api/users")
public class UserResource {

	@GET
	@Path("/me")
	@Produces(MediaType.APPLICATION_JSON)
	@NoCache
	public JsonObject user() {
		return Json.createObjectBuilder().
				build();
	}

}
