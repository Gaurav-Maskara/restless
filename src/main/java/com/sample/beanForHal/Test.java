package com.sample.beanForHal;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

import com.consumer.beans.Joke;
import com.consumer.beans.Quote;
import com.google.api.client.util.Maps;
import com.google.cloud.dialogflow.v2.DetectIntentResponse;
import com.google.cloud.dialogflow.v2.QueryInput;
import com.google.cloud.dialogflow.v2.QueryResult;
import com.google.cloud.dialogflow.v2.SessionName;
import com.google.cloud.dialogflow.v2.SessionsClient;
import com.google.cloud.dialogflow.v2.TextInput;
import com.google.cloud.dialogflow.v2.TextInput.Builder;

public class Test {

	public static void main(String args[]) throws Exception {

		
		try {
		   System.out.println(1/0);
		}
		catch(Exception e) {
			System.out.println(1/0);
			System.out.println("hello");
		}finally {
			System.out.println("final");
		}
	}

}
