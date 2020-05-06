package fil.coo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StudentTest {
	
	Student tony;
	Student gabriel;
	
	@Before
	public void init(){
		tony = new Student("1","Tony");
		gabriel = new Student("2","Gabriel");
	}

	@Test
	public void equalTest() {
		assertNotEquals(tony,gabriel);
	}
	
	@Test
	public void setterGetterTests(){
		String newNumber = "3";
		tony.setNumber(newNumber);
		assertEquals(newNumber,tony.getNumber());
		
		String newName = "rémi";
		gabriel.setName(newName);
		assertEquals(newName, gabriel.getName());
	}

}
