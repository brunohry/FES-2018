

public class Main {

	private static Controller controller;

	public static void main(String[] args) {
		controller = new Controller();
		controller.imputByFile();
		controller.fazRelatorio("relatoriosImput.xml");
		

	}
}
