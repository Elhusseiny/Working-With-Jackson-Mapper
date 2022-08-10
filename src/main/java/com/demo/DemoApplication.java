package com.demo;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// 1
		ObjectMapper mapper = new ObjectMapper( );
		String exampleJsonPayload =  "{\"age\": \"20\" , \"name\": \"nick\" ,\"location\": {\"lang\": \"228\", \"latt\": \"200\"}}";
		JsonNode node = mapper.readTree(exampleJsonPayload);
		Person p1 = mapper.convertValue(node , Person.class); // configured but we haven't specified a specific type for field "data"

		//2
		Person p2 = mapper.readValue(exampleJsonPayload , Person.class ); // configured but we haven't specified a specific type for field "data"

		//3
		JavaType T = mapper.constructType(Location.class) ; // use object mapper helper method to get the type of any class
		Person p3 = mapper.readValue(exampleJsonPayload , mapper.getTypeFactory().constructParametricType(Person.class , T)) ; // do the mapping with this constructor. If there is any parameterized type it will be given a class type.




	}
}
