package behaviours;

import com.consol.citrus.TestActionRunner;
import com.consol.citrus.TestBehavior;
import com.consol.citrus.context.TestContext;
import org.springframework.http.HttpStatus;
import static com.consol.citrus.dsl.JsonPathSupport.jsonPath;
import static com.consol.citrus.http.actions.HttpActionBuilder.http;

public class GetPet implements TestBehavior {

private final TestContext testContext;
private final String name;
private final Integer Id;

public GetPet(TestContext context, Integer id, String name) {
	this.testContext = context;
	this.Id = id;
	this.name = name;
}

@Override
public void apply(TestActionRunner testActionRunner) {
	testActionRunner.run(http()
			                     .client("restHelper")
			                     .send()
			                     .get("pet/" + Id));
	
	testActionRunner.run(http()
			                     .client("restHelper")
			                     .receive()
			                     .response(HttpStatus.OK)
			                     .validate(jsonPath()
					                               .expression("$.name", name))
			                     .validate(jsonPath()
					                               .expression("$.id", Id)));
	
}
}
