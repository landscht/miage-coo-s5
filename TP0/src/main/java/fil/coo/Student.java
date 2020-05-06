package fil.coo;

/**
 * @author landschoot, congin
 * 
 * Classe définissant un étudiant à travers son nom et son numéro d'étudiant
 */

public class Student {
	
	String number;
	String name;
	
	public Student(String number, String name) {
		this.number = number;
		this.name = name;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean equals(Student s){
		if(this.name.equals(s.getName()) && this.number.equals(s.getNumber())){
			return true;
		}
		return false;
	}
	
	public String toString() {
		return "nom : " + this.getName() + " numéro : " + this.getNumber();
	}
}
