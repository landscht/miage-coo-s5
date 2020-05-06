package courrier;

public class Main {
	
	public static void main(String[] args) {
		if(args[0].equals("1")) {
			FirstSimulation.startSimulation();
		}else if(args[0].equals("2")) {
			SecondSimulation.startSimulation();
		}else {
			System.out.println("Wrong argument, try again (1/2)");
		}
	}

}
