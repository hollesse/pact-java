package com.example;

import static junit.framework.TestCase.assertEquals;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Rule;
import org.junit.Test;

import au.com.dius.pact.consumer.Pact;
import au.com.dius.pact.consumer.PactProviderRule;
import au.com.dius.pact.consumer.PactVerification;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.model.PactFragment;

public class ConsumerClientContractTest {

	   @Rule
	    public PactProviderRule rule = new PactProviderRule("Course_Provider", this);

	    @Pact(provider="Course_Provider", consumer="Course_Consumer")
	    public PactFragment createFragment(PactDslWithProvider builder) {
	        Map<String, String> headers = new HashMap<>();
	        headers.put("Content-Type", "application/json;charset=UTF-8");

	        return builder.uponReceiving("a request for Foos")
	                .path("/courses")
	                .method("GET")

	                .willRespondWith()
	                .headers(headers)
	                .status(200)
	                .body("[{\"name\":\"TINF15AIBC\",\"numberOfStudents\":21},{\"name\":\"TINF15AIBI\",\"numberOfStudents\":23}]").toFragment();
	    }

	    @Test
	    @PactVerification("Course_Provider")
	    public void runTest() {
	        assertEquals(new ConsumerClient(rule.getConfig().url()).courses(), Arrays.asList(new Course("TINF15AIBC",21), new Course("TINF15AIBI",23)));
	    }
}
