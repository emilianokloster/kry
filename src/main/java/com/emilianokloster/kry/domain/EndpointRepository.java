package com.emilianokloster.kry.domain;

import org.springframework.data.repository.CrudRepository;

import com.emilianokloster.kry.entities.Endpoint;

public interface EndpointRepository extends CrudRepository<Endpoint, String> {

}
