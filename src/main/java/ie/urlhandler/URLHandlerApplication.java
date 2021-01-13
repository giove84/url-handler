package ie.urlhandler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@SpringBootApplication
@RestController
public class URLHandlerApplication {

	public static void main(String[] args) {
		SpringApplication.run(URLHandlerApplication.class, args);
	}

	@GetMapping("/home")
	public ModelAndView home() {
    return new ModelAndView("home");
	}

}
