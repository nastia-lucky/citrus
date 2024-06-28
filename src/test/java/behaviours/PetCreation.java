package behaviours;

import com.consol.citrus.TestActionRunner;
import com.consol.citrus.TestBehavior;
import com.consol.citrus.context.TestContext;
import com.consol.citrus.message.MessageType;
import org.springframework.http.HttpStatus;

import static com.consol.citrus.http.actions.HttpActionBuilder.http;

public class PetCreation implements TestBehavior {

private TestContext testContext;
private Integer Id;
private String name;

public PetCreation(TestContext testContext, Integer id, String name) {
	this.testContext = testContext;
	this.name = name;
	this.Id = id;
}

@Override
public void apply(TestActionRunner testActionRunner) {
	testActionRunner.run(http().
			                     client("restHelper")
			                     .send()
			                     .post("pet")
			                     .message()
			                     .type(MessageType.JSON)
			                     .body("{\n" +
					                           "  \"id\": " + Id + ",\n" +
					                           "  \"category\": {\n" +
					                           "    \"id\": 1,\n" +
					                           "    \"name\": \"category\"\n" +
					                           "  },\n" +
					                           "  \"name\": " + "\"" + name + "\",\n" +
					                           "  \"photoUrls\": [\n" +
					                           "    \"my url\"\n" +
					                           "  ],\n" +
					                           "  \"tags\": [\n" +
					                           "    {\n" +
					                           "      \"id\": 1,\n" +
					                           "      \"name\": \"tag\"\n" +
					                           "    }\n" +
					                           "  ],\n" +
					                           "  \"status\": \"available\"\n" +
					                           "}"));
	
	testActionRunner.run(http()
			                     .client("restHelper")
			                     .receive()
			                     .response(HttpStatus.OK)
			                     .message()
			                     .type(MessageType.JSON));
}
}
