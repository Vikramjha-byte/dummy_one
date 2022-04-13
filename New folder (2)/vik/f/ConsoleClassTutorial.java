import java.io.Console;

public class ConsoleClassTutorial {

		public static void gettingInputFromConsole() {
			Console console=System.console();
			System.out.println("Enter your username: ");
			String username= console.readLine();
			System.out.println("Enter your password :");
			char[] password=console.readPassword();
			String pass= String.valueOf(password);
			System.out.println("Welcome "+ username+", you have entered your password as :"+ pass);
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		gettingInputFromConsole();
	}

}
