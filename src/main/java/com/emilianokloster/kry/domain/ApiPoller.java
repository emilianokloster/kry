package com.emilianokloster.kry.domain;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emilianokloster.kry.model.Endpoint;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@Service
public class ApiPoller {
	private OkHttpClient client;

	@Autowired
	private EndpointService endpointService;
	
	/*
	 * There are many options available to customize this http client
	 * in charge of API's validation. It's possible to set timeouts,
	 * cache memory, accept redirect, autentication to private API's...
	 */
	private OkHttpClient httpClient() {
		if (client == null)
			client = new OkHttpClient.Builder()
		      .readTimeout(10, TimeUnit.SECONDS)
		      .callTimeout(10, TimeUnit.SECONDS)
		      .build();
		
		return client;
	}

    public void poll() {
    	endpointService.getAll().forEach(ep -> asyncRequest(ep));
    }
    
    private void asyncRequest(Endpoint ep) {
		Request request = new Request.Builder()
				.url(ep.getUrl())
				.build();
		
		Call call = httpClient().newCall(request);
		call.enqueue(new Callback() {
			
			@Override
			public void onResponse(Call call, Response response) throws IOException {
				ep.setStatus(response.code() == 200 ? "OK" : "FAIL");
				System.out.println(ep.getName() + ": " + ep.getStatus());
			}
			
			@Override
			public void onFailure(Call call, IOException e) {
				System.out.println(e.getMessage());
				ep.setStatus("FAIL");
			}
		});
    }
	
}
