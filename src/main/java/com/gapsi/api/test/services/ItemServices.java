/**
 * 
 */
package com.gapsi.api.test.services;

import java.util.Optional;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.Response.StatusType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.gapsi.api.test.bo.ItemUpdBo;
import com.gapsi.api.test.entities.Item;
import com.gapsi.api.test.repositories.ItemRepository;

@Component
@Path("/item")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ItemServices {

	@Autowired
	private ItemRepository itemRepository;

	@GET
	// public Response getItemById(@PathVariable String id) {
	@Path("/{id}")
	public Response getItemById(@PathParam("id") String id) {
		Response response;
		if (StringUtils.isEmpty(id)) {
			response = Response.status(400, "Invalid ID supplied").build();
		} else {
			Optional<Item> item = itemRepository.findById(id);
			if (item.isPresent()) {
				response = Response.ok(item.get()).build();
			} else {
				response = Response.status(404, "Item not found").build();
			}
		}
		return response;
	}

	@PUT
	public Response updateItem(@RequestBody ItemUpdBo itemBo) {
		Response response = response = Response.serverError().build();
		if (null == itemBo || StringUtils.isEmpty(itemBo.getId())) {
			response = Response.status(400, "Invalid ID supplied").build();

		} else if (StringUtils.isEmpty(itemBo.getDescription()) || StringUtils.isEmpty(itemBo.getModel())) {
			response = Response.status(405, "Invalid ID supplied").build();
			
		} else {
			Optional<Item> resp = itemRepository.findById(itemBo.getId());
			if (resp.isPresent()) {
				Item item = resp.get();
				item.setDescription(itemBo.getDescription());
				item.setModel(itemBo.getModel());
				itemRepository.save(item);
				response = Response.ok(resp).build();
			} else {
				// Response.status(StatusType);

				// Response.status(Status.NOT_FOUND)
				// .entity(errorMessage)
				// .type(MediaType.APPLICATION_JSON)
				// .build();
				//
				// Response.status(Status.NOT_FOUND,"");

				response = Response.status(404, "Item not found").build();
			}
		}
		return response;
	}

}
