package com.emilianokloster.kry.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emilianokloster.kry.model.BasicEndpoint;
import com.emilianokloster.kry.model.Endpoint;
import com.emilianokloster.kry.model.EndpointRepository;

@Service
public class EndpointService {
	
	@Autowired
	private EndpointRepository repository;
	
	private List<Endpoint> endpoints;
	
	/*
	 * This method is called repeatedly by the polling service.
	 * It's configured to fetch data from the database just once, otherwise, 
	 * it would be too expensive. It fills a list with all the values and that 
	 * collection is constantly updated to provide the url's to validate. 
	 */
	public List<Endpoint> getAll() {
		if (endpoints == null) {
			endpoints = new ArrayList<>(); 
			repository.findAll().forEach(endpoints::add);
		}
		return endpoints;
	}
	
	public List<BasicEndpoint> getAllBasic() {
		// TODO Implement to be used by polling service
		return null;
	}
	
	public Endpoint get(Long id) {
		if (id == null) return null;
		return endpoints.stream()
				.filter(ep -> ep.getId().equals(id))
				.findFirst().get();
	}

	public void add(Endpoint endpoint) {
		if (endpoint != null) {
			endpoint.setDateInsert(LocalDate.now());
			endpoint.setDateLastUpdate(LocalDate.now());
			
			// TODO endpoint.setUserInsert()
			
			final Endpoint newInstance = repository.save(endpoint);
			endpoints.add(newInstance);
		}
	}

	public void update(Endpoint endpoint, Long id) {
		if (endpoint != null && id != null) {
			final Endpoint updated = repository.save(endpoint);
			endpoints.stream()
				.filter(ep -> ep.getId().equals(id))
				.findFirst()
				.ifPresent(ep -> {
					ep.setName(updated.getName());
					ep.setUrl(updated.getUrl());
					ep.setComment(updated.getComment());
					ep.setDateLastUpdate(LocalDate.now());
				});
		}
	}

	public void delete(Long id) {
		if (id != null && !id.equals("")) {
			repository.deleteById(id);
			endpoints.removeIf(ep -> ep.getId().equals(id));
		}
	}

}
