package ajbc.exam3.classes;

public class NonCapatilizedException extends Exception {
	private static final long serialVersionUID = 808678353527776559L;

	private String name;

	public NonCapatilizedException() {
		super();
		this.name = "The name does not begin with a capital letter";
	}

	public NonCapatilizedException(String name) {
		super();
		this.name = "The name " + getName() + " does not begin with a capital letter";
	}

	public String getName() {
		return name;
	}
}
