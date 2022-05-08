package ajbc.exam3.runner.copy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.Random;

import ajbc.exam3.classes.Dragon;
import ajbc.exam3.classes.Food;
import ajbc.exam3.classes.Food.Macronutrients;
import ajbc.exam3.classes.Food.Taste;

public class Runner {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		Food pineapple = new Food("pineapple", Taste.SWEET, Macronutrients.CARBOHYDRATE);
		Food lemon = new Food("Lemon", Taste.SOUR, Macronutrients.CARBOHYDRATE);
		Dragon dragon1 = new Dragon("Drogon", LocalDate.of(800, 12, 12), 10);
		Dragon dragon2 = new Dragon("Rhaegal", LocalDate.of(770, 3, 6), 8);

		System.out.println(pineapple);
		System.out.println(lemon);
		System.out.println(dragon1);
		System.out.println(dragon2);

		randomObjectAndWriteToFile(pineapple, lemon, dragon1, dragon2);
		randomObjectAndWriteToFile(pineapple, lemon, dragon1, dragon2);
		readObjectsFromFile();
	}

	private static void readObjectsFromFile() {
		try (FileInputStream file = new FileInputStream("files/selectedObjects.dat");
				ObjectInputStream objStream = new ObjectInputStream(file);) {

			for (int i = 1; i <= 2; i++) {
				try {
					System.out.println("Object" + i + ": " + objStream.readObject());
				} catch (ClassNotFoundException | IOException e) {
					e.printStackTrace();
				}
			}
			objStream.close();
			file.close();
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	private static void randomObjectAndWriteToFile(Food pineapple, Food lemon, Dragon dragon1, Dragon dragon2)
			throws FileNotFoundException, IOException {
		Random rand = new Random();
		int selectedObject = rand.nextInt(4) + 1;

		try (FileOutputStream fileOut = new FileOutputStream("files/selectedObjects.dat", true);
				ObjectOutputStream objOut = new ObjectOutputStream(fileOut)) {

			switch (selectedObject) {
			case 1: {
				objOut.writeObject(pineapple);
				break;
			}
			case 2: {
				objOut.writeObject(lemon);
				break;
			}
			case 3: {
				objOut.writeObject(dragon1);
				break;
			}
			case 4: {
				objOut.writeObject(dragon2);
				break;
			}
			}
			objOut.close();
			fileOut.close();
		}
	}
}