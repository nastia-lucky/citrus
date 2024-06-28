package behaviours;

import com.consol.citrus.TestActionRunner;
import com.consol.citrus.TestBehavior;
import com.consol.citrus.context.TestContext;

import static com.consol.citrus.http.actions.HttpActionBuilder.http;

public class PetDeletion implements TestBehavior {

private final TestContext context;
private final Integer id;


public PetDeletion(TestContext context, Integer id) {
	this.context = context;
	this.id = id;
}

@Override
public void apply(TestActionRunner testActionRunner) {
	testActionRunner.run(http()
			                     .client("restHelper")
			                     .send()
			                     .delete("pet/" + id));
}
}
