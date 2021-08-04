package ray.integration.demo.rest;

import org.apache.camel.Header;
import org.springframework.stereotype.Service;

@Service("greetingsService")
public class GreetingsService {


	public Greetings getGreetings(@Header("name") String name) {
		return new Greetings("Hello " + name);   //If you want, you can also return a string.
	}
}
