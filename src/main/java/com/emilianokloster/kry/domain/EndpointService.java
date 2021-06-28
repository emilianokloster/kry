package com.emilianokloster.kry.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emilianokloster.kry.entities.Endpoint;

@Service
public class EndpointService {
	
	@Autowired
	private EndpointRepository repository;
	
	private List<Endpoint> endpoints = new ArrayList<>();
	
	public List<Endpoint> getAll() {
		endpoints = new ArrayList<>(); 
		repository.findAll().forEach(endpoints::add);
		return endpoints;
	}
	
	public Optional<Endpoint> get(String id) {
		return repository.findById(id);
		
//		return endpoints.stream()
//				.filter(ep -> ep.getId().equals(id))
//				.findFirst().get();
	}

	public void add(Endpoint endpoint) {
		repository.save(endpoint);
		
//		endpoints.add(endpoint);
	}

	public void update(Endpoint endpoint, String id) {
		repository.save(endpoint);
		
//		endpoints.stream()
//			.filter(ep -> ep.getId().equals(id))
//			.findFirst()
//			.ifPresent(ep -> {
//				ep.setName(endpoint.getName());
//				ep.setUrl(endpoint.getUrl());
//			});
	}

	public void delete(String id) {
		repository.deleteById(id);
		
//		endpoints.removeIf(t -> t.getId().equals(id));
	}

}
