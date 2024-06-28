package tests.restTests;

import behaviours.GetPet;
import behaviours.PetCreation;
import behaviours.PetDeletion;
import com.consol.citrus.annotations.CitrusTest;
import com.consol.citrus.context.TestContext;
import com.consol.citrus.testng.spring.TestNGCitrusSpringSupport;
import org.testng.annotations.Test;


public class CreatePetTest extends TestNGCitrusSpringSupport {

private TestContext testContext;

@Test
@CitrusTest
public void createPet() {
	this.testContext = citrus.getCitrusContext().createTestContext();
	
	String name= "doggy";
	Integer id=6;
	
	run(applyBehavior(new PetCreation(testContext, id, name)));
	run(applyBehavior(new GetPet(testContext, id, name)));
	run(applyBehavior(new PetDeletion(testContext, id)));
}
}
