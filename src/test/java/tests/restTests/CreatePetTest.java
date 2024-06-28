package tests.restTests;

import behaviours.GetPet;
import behaviours.PetCreation;
import behaviours.PetDeletion;
import com.consol.citrus.annotations.CitrusTest;
import com.consol.citrus.context.TestContext;
import com.consol.citrus.testng.spring.TestNGCitrusSpringSupport;
import models.PetCategory;
import models.PetDTO;
import models.PetTag;
import org.testng.annotations.Test;

import java.util.Arrays;


public class CreatePetTest extends TestNGCitrusSpringSupport {

private TestContext testContext;

@Test
@CitrusTest
public void createPet() {
	this.testContext = citrus.getCitrusContext().createTestContext();
	PetCategory category = new PetCategory(1, "my category");
	PetTag tag = new PetTag(1, "my tag");
	PetDTO pet = new PetDTO(3, category, "my little pretty pet", Arrays.asList("url 1"), Arrays.asList(tag), "approved");
	Integer id = 3;
	String name = "doggie";
	
	run(applyBehavior(new PetCreation(testContext, id, name)));
	run(applyBehavior(new GetPet(testContext, id, name)));
	run(applyBehavior(new PetDeletion(testContext, id)));
}
}
