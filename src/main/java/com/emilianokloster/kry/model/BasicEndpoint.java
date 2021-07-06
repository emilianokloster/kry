package com.emilianokloster.kry.model;

/*
 * Spring Data JPA Projection
 * It is used by BasicEndpointRepository to limit the columns in a sql select sentence.
 * It's basically providing a [select id, url, name, status] query instead of a [select *].
 */
public interface BasicEndpoint {
	String getId();
	String getUrl();
	String getName();
	String getStatus();
}
