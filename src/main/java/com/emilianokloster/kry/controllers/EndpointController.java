package com.emilianokloster.kry.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.emilianokloster.kry.domain.EndpointService;
import com.emilianokloster.kry.model.Endpoint;

/*
 * This REST API is intended to be consumed by any front-end technology.
 */

@RestController
@CrossOrigin
public class EndpointController {
	
	@Autowired
	private EndpointService endpointService;
	
	@RequestMapping("/endpoints")
	private List<Endpoint> getAll() {
		return endpointService.getAll();
	}
	
	@RequestMapping("/endpoints/{id}")
	private Endpoint get(@PathVariable Long id) {
		return endpointService.get(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/endpoints")
	public void add(@RequestBody Endpoint endpoint) {
		endpointService.add(endpoint);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/endpoints/{id}")
	public void update(@RequestBody Endpoint topic, @PathVariable Long id	) {
		endpointService.update(topic, id);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/endpoints/{id}")
	public void delete(@PathVariable Long id	) {
		endpointService.delete(id);
	}
	
}
