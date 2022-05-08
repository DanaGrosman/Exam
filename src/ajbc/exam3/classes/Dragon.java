package ajbc.exam3.classes;

import java.io.Serializable;
import java.time.LocalDate;

public class Dragon implements Serializable{
	private static final long serialVersionUID = -1115647619808216133L;
	protected String name;
	protected LocalDate birthDate;
	protected int flameIntensity;
	
	public Dragon(String name, LocalDate birthDate, int flameIntensity) {
		this.name = name;
		this.birthDate = birthDate;
		this.flameIntensity = flameIntensity;
	}
	@Override
	public String toString() {
		return "Dragon [name=" + name + ", birthDate=" + birthDate + ", flameIntensity=" + flameIntensity + "]";
	}
	
	
}
