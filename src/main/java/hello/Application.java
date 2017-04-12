
package hello;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hello.wsdl.GetCitiesByCountryResponse;
import hello.wsdl.GetWeatherResponse;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class);
	}

	@Bean
	CommandLineRunner lookup(QuoteClient quoteClient) {
		return args -> {
/**
  			String ticker = "MSFT";
 

			if (args.length > 0) {
				ticker = args[0];
			}
**/
			GetCitiesByCountryResponse response = quoteClient.getQuote("US");
			
			System.out.println("##### cjd" + response);
			System.err.println(response.getGetCitiesByCountryResult());
		};
	}

}
