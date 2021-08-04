package ray.integration.demo.rest;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.apache.camel.model.rest.RestParamType;
import org.springframework.stereotype.Component;

@Component
public class HelloRoute extends RouteBuilder{

	@Override
	public void configure() throws Exception {

		restConfiguration()
		.component("undertow").scheme("http").port("8443").bindingMode(RestBindingMode.json)
		
	        .apiContextPath("/api-doc")
	        .apiContextRouteId("apiDoc")
	        .apiProperty("api.title", "Demo REST Service")
	        .apiProperty("api.description", "A simple REST API to say hello.")
	        .apiProperty("api.version", "0.0.1");

	
		rest("/api/hello")
		    .get("{name}").id("helloRoute")
	    	.produces("application/json")
		    .description("Returns a greeting by a name and a language.")
			.to("bean:greetingsService?method=getGreetings");
	
	}
}
