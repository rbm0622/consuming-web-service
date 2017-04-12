package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hello.wsdl.GetCitiesByCountryResponse;


@RestController
public class ApplicationController {
	
	private static Logger log = LoggerFactory.getLogger(ApplicationController.class);

	@Autowired
	QuoteClient quoteClient;
	
	@RequestMapping("/weather")
	public String dailyContent(@RequestParam(value="country") String country) {
		GetCitiesByCountryResponse response = quoteClient.getQuote(country);
		return response.getGetCitiesByCountryResult();
	}

}
