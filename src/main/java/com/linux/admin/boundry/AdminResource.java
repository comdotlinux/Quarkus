package com.linux.admin.boundry;

import javax.json.Json;
import javax.json.JsonArray;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/api/admin")
public class AdminResource {

	@GET
	public JsonArray users() {
		return Json.createArrayBuilder().add("Alice").add("admin").build();
	}
}
