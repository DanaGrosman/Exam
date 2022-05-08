package ajbc.exam3.classes;

import java.io.Serializable;

public class Food implements Serializable {
	private static final long serialVersionUID = -8504670010822100362L;

	protected String name;
	protected Taste taste;
	protected Macronutrients macronutrients;

	public Food(String name, Taste taste, Macronutrients macronutrients) {
		super();
		setName(name);
		this.taste = taste;
		this.macronutrients = macronutrients;
	}

	public void setName(String name) {
		try {
			if (checkName(name))
				this.name = name;
			else
				throw new NonCapatilizedException(name);
		} catch (NonCapatilizedException e) {
			e.printStackTrace();
		}
	}

	private boolean checkName(String name) throws NonCapatilizedException {
		return Character.isUpperCase(name.charAt(0)) ? true : false;
	}

	@Override
	public String toString() {
		return "Food [name=" + name + ", taste=" + taste + ", macronutrients=" + macronutrients + "]";
	}

	public boolean isDesert() {
		return taste == Taste.SWEET && macronutrients == Macronutrients.CARBOHYDRATE ? true : false;
	}

	public static enum Taste {
		SWEET, SOUR, SALTY, BITTER, UMAMI;
	}

	public static enum Macronutrients {
		PROTEIN, CARBOHYDRATE, FAT;
	}
}
