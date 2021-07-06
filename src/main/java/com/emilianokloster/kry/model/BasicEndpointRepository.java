package com.emilianokloster.kry.model;

import java.util.List;

import org.springframework.data.repository.Repository;

public interface BasicEndpointRepository extends Repository<Endpoint, String>  {

	/*
	 * An improvement would be to set this as the default findAll() method that the
	 * scheduler and the React HomePage component are invoking, because the retreived
	 * data is limited (defined in BasicEndpoint) so less networking resources will be used.
	 */
	public List<BasicEndpoint> findAll();
}
