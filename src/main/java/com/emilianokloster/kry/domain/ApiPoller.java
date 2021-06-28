package com.emilianokloster.kry.domain;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emilianokloster.kry.entities.Endpoint;

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
	
	private OkHttpClient httpClient() {
		if (client == null)
			client = new OkHttpClient.Builder()
		      .readTimeout(10, TimeUnit.SECONDS)
		      .callTimeout(10, TimeUnit.SECONDS)
		      .build();
		
		return client;
	}

    public void poll() {
    	endpointService.getAll().stream()
    		.map(Endpoint::getUrl)
    		.forEach(url -> asyncRequest(url));
    }
    
    private void asyncRequest(String url) {
		Request request = new Request.Builder()
				.url(url)
				.build();
		
		Call call = httpClient().newCall(request);
		call.enqueue(new Callback() {
			
			@Override
			public void onResponse(Call call, Response response) throws IOException {
		    	System.out.println(response.request().url());
				System.out.println(response.code());
			}
			
			@Override
			public void onFailure(Call call, IOException e) {
				System.out.println(e.getMessage());
			}
		});
    }
	
}
