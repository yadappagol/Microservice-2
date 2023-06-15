package com.microservice.serviceregistry.service;

import org.springframework.cloud.client.loadbalancer.reactive.ReactorLoadBalancerExchangeFilterFunction;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.microservice.serviceregistry.model.Course;

import reactor.core.publisher.Mono;

@Service
public class ApiCallUsingWebClient {

	private final WebClient.Builder loadBalancedWebClientBuilder;

	private static final String COURSE_MICROSERVICE_BASEURL = "http://course-service";

	public ApiCallUsingWebClient(WebClient.Builder webClientBuilder,
			ReactorLoadBalancerExchangeFilterFunction lbFunction) {
		this.loadBalancedWebClientBuilder = webClientBuilder;
	}

	public Mono<Course> getCourseDetails(int courseId) {
		return loadBalancedWebClientBuilder.build().get().uri(COURSE_MICROSERVICE_BASEURL + "/course/id?id=" + courseId)
				.retrieve().bodyToMono(Course.class);
	}

}
