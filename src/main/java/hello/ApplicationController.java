package hello;

import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.stream.XMLInputFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hello.wsdl.GetCitiesByCountryResponse;
import jaxbmarshall.CountryCityPair;

@RestController
public class ApplicationController {

	private static Logger log = LoggerFactory.getLogger(ApplicationController.class);

	@Autowired
	QuoteClient quoteClient;

	@RequestMapping("/weather")
	public CountryCityPair dailyContent(@RequestParam(value = "country") String country) throws Exception {
		GetCitiesByCountryResponse response = quoteClient.getQuote(country);
		JAXBContext jc = JAXBContext.newInstance(CountryCityPair.class.getPackage().getName());
		log.info(response.getGetCitiesByCountryResult());
		CountryCityPair result =  (CountryCityPair) jc.createUnmarshaller().unmarshal(XMLInputFactory.newFactory()
				.createXMLStreamReader(new StringReader(response.getGetCitiesByCountryResult())));
		return result;
	}

}
