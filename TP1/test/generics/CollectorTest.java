package generics;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CollectorTest {
	
	Collector<Apple> appleCollector;
	Collector<Carrot> carrotCollector;
	Collector<Carrot> carrotCollector2;
	Collector<Vegetable> vegetableCollector;
	Apple apple;
	Carrot carrot;
	
	@Before
	public void init() {
		appleCollector = new Collector<>("apple-collector");
		carrotCollector = new Collector<>("carrot-collector");
		carrotCollector2 = new Collector<>("carrot-collector-2");
		vegetableCollector = new Collector<>("vegetable-collector");
		apple = new Apple(1);	
		carrot = new Carrot(1);
	}

	@Test
	public void takeTest() throws AlreadyCarryingException {
		assertEquals(null, appleCollector.getCarriedObject());
		appleCollector.take(apple);
		assertEquals(apple, appleCollector.getCarriedObject());
	}
	
	@Test(expected = AlreadyCarryingException.class)
	public void takeExceptionTest() throws AlreadyCarryingException {
		appleCollector.take(apple);
		appleCollector.take(apple);
	}
	
	@Test
	public void giveToTest() throws AlreadyCarryingException {
		carrotCollector.take(carrot);
		carrotCollector.giveTo(carrotCollector2);
		carrotCollector2.giveTo(vegetableCollector);
		assertEquals(null,carrotCollector.getCarriedObject());
		assertEquals(null,carrotCollector2.getCarriedObject());
		assertEquals(carrot,vegetableCollector.getCarriedObject());
	}
	
	@Test ( expected = AlreadyCarryingException.class)
	public void giveToExceptionTest() throws AlreadyCarryingException{
		carrotCollector2.take(carrot);
		carrotCollector.giveTo(carrotCollector2);
	}
	
	@Test
	public void dropTest() throws AlreadyCarryingException {
		appleCollector.take(apple);
		assertEquals(apple, appleCollector.drop());
		assertEquals(null, appleCollector.getCarriedObject());
	}

}
