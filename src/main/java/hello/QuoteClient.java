
package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import hello.wsdl.GetCitiesByCountry;
import hello.wsdl.GetCitiesByCountryResponse;
import hello.wsdl.GetWeather;
import hello.wsdl.GetWeatherResponse;

public class QuoteClient extends WebServiceGatewaySupport {

	private static final Logger log = LoggerFactory.getLogger(QuoteClient.class);

	public GetCitiesByCountryResponse getQuote(String ticker) {

		GetCitiesByCountry request = new GetCitiesByCountry();
		request.setCountryName("US");
		//request.setSymbol(ticker);

		log.info("Requesting quote for " + ticker);

		GetCitiesByCountryResponse response = (GetCitiesByCountryResponse) getWebServiceTemplate()
				.marshalSendAndReceive("http://www.webservicex.net/globalweather.asmx",
						request,
						new SoapActionCallback("http://www.webserviceX.NET/GetCitiesByCountry"));

		return response;
	}

}
