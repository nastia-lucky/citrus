package tests.soapTests;

import com.consol.citrus.annotations.CitrusTest;
import com.consol.citrus.context.TestContext;
import com.consol.citrus.testng.spring.TestNGCitrusSpringSupport;
import com.dataaccess.webservicesserver.NumberToDollars;
import com.dataaccess.webservicesserver.NumberToDollarsResponse;
import org.testng.annotations.Test;
import utils.CustomMarshaller;

import java.math.BigDecimal;

import static com.consol.citrus.ws.actions.SoapActionBuilder.soap;

public class SOAPTests extends TestNGCitrusSpringSupport {

private TestContext testContext;

@Test
@CitrusTest
public void soapTest() {
	this.testContext = citrus.getCitrusContext().createTestContext();
	
	CustomMarshaller<Class<NumberToDollars>> request = new CustomMarshaller<>();
	CustomMarshaller<Class<NumberToDollarsResponse>> response = new CustomMarshaller<>();
	
	run(soap()
			    .client("soapHelper")
			    .send()
			    .message()
			    .body(request.convert(NumberToDollars.class, getNumberToDollarsRequest(),
					    "http://www.dataaccess.com/webservicesserver/", "NumberToDollars")));
	
	run(soap()
			    .client("soapHelper")
			    .receive()
			    .message()
			    .body(response.convert(NumberToDollarsResponse.class, getNumberToDollarsResponse(),
					    "http://www.dataaccess.com/webservicesserver/", "NumberToDollarsResponse")));
}

public NumberToDollars getNumberToDollarsRequest() {
	NumberToDollars numberToDollars = new NumberToDollars();
	numberToDollars.setDNum(new BigDecimal("15"));
	return numberToDollars;
}

public NumberToDollarsResponse getNumberToDollarsResponse() {
	NumberToDollarsResponse numberToDollarsResponse = new NumberToDollarsResponse();
	numberToDollarsResponse.setNumberToDollarsResult("fifteen dollars");
	return numberToDollarsResponse;
}
}
