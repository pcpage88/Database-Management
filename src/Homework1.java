import java.io.*;
import java.util.*;

public class Homework1 {
	boolean exit = false;
		
	public static void main(String args[]){
			
		Homework1 h = new Homework1();
		h.runMenu();
	}
		
	public void runMenu()
	{
		while(!exit)
		{
			printMenu();
			int choice = getInput();
			menuAction(choice);
		}
	}
		
	private int getInput() throws NoSuchElementException
	{
		Scanner input = new Scanner(System.in);
		int c = -1;
			
		while(c < 0 || c > 9){
			try
			{
				System.out.print("Select one of the following options: ");
				c = Integer.parseInt(input.nextLine());
			}catch(NumberFormatException e){
				System.out.println("Invalid Selection Entered! Please try again");
			}
		}
		return c;
	}
		
	private void menuAction(int choice)
	{
		switch(choice){
			case 9:
				exit =  true;
				System.out.println("Thank you for using the Parks Database Program. Goodbye");
				break;
			case 1:
				try {
					createDatabase();
				} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 2:
				try {
					openDatabase();
				} catch(IOException e) {
					e.printStackTrace();
				}
		}
	}
		
	private void printMenu()
	{
		System.out.println("+--------------------------------------------------------------+");
		System.out.println("|                   Parks Database Menu:                       |");
		System.out.println("+--------------------------------------------------------------+\n");
			
		System.out.println("1. Create database\n");
		System.out.println("2. Open database\n");
		System.out.println("3. Close database\n");
		System.out.println("4. Display record\n");
		System.out.println("5. Update record\n");
		System.out.println("6. Create report\n");
		System.out.println("7. Add record\n");
		System.out.println("8. Delete report\n");
		System.out.println("9. Quit\n");
	}
		
	private void createDatabase() throws FileNotFoundException
	{
		System.out.print("Enter filename: ");
		Scanner userInput = new Scanner(System.in);
		String userFile = userInput.nextLine();
		FileOutputStream fopen = new FileOutputStream("database.txt");
		PrintWriter fout = new PrintWriter(fopen);

		try {
			File myObj = new File(userFile);
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) 
			{
				String data = myReader.nextLine();
				data = data.replace(',',' ');
				fout.println(data);
			}
			myReader.close();
			fout.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}
	
	private void openDatabase() throws IOException 
	{
		Runtime rt = Runtime.getRuntime();
		System.out.print("Enter filename: ");
		Scanner userInput = new Scanner(System.in);
		String dbName = userInput.nextLine();
		Process p = rt.exec("Notepad "+dbName);
	}
	
	private void closeDatabase()
	{
		
	}
}


