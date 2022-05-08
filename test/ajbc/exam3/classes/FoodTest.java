package ajbc.exam3.classes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ajbc.exam3.classes.Food.Macronutrients;
import ajbc.exam3.classes.Food.Taste;

class FoodTest {

	private Food food1;
	private Food food2;

	
	public FoodTest() {
		food1= new Food("Bamba", Taste.SALTY, Macronutrients.PROTEIN);
		food2 = new Food("Pineapple", Taste.SWEET, Macronutrients.CARBOHYDRATE);
	}
	
	@Test
	void isDesetTest() {
		assertFalse(food1.isDesert());
		assertTrue(food2.isDesert());
	}
}
