package Project1;

import java.util.Scanner;

public class lockedMeFront {
	boolean stayInMenu=true;
	Scanner sc = new Scanner(System.in);
	
	
	public void menufile() {
		String userInput;
		do {
			System.out.println("LockedMe.com File Handling Console. ### File Operations Menu ###\nOptions:\n1-Add File\n2-Delete File\n3-Search for File\n4-Back to main menu.");
			userInput = this.sc.next();
			switch(userInput.toLowerCase()) {
			case "1":
				System.out.println("Define/Write the new user file name:");
				userInput = this.sc.next();
				fileHandling.writeFile(fileHandling.updatePath(userInput));
				break;
			case "2":
				System.out.println("Define the user file to delete:");
				userInput = this.sc.next();
				fileHandling.deleteFile(fileHandling.updatePath(userInput));
				break;
			case "3":
				System.out.println("Define the user file to search:");
				userInput = this.sc.next();
				fileHandling.searchFile(fileHandling.updatePath(userInput));
				break;
			case "4":
				System.out.println("Back to main Menu.");
				this.stayInMenu=false;
				break;
			default :
				System.out.println("Invalid Option.");
			}
		}
			while(this.stayInMenu);

	}
	

	
	
	public static void main(String[] args) {
		lockedMeFront lockedMeFrontend = new lockedMeFront();
		String userInput;
		do {
			System.out.println("LockedMe.com File Handling Console. ### by pedro.vieira.pancho@gmail.com\nOptions:\n1-Return Files by ascending order\n2-File option (add, search,delete)\n3-Exit.");
			userInput = lockedMeFrontend.sc.next();
			switch(userInput.toLowerCase()) {
			case "1":
				fileHandling.diplaySortedDir(fileHandling.updatePath("").toString());
				break;
			case "2":
				lockedMeFrontend.menufile();
				lockedMeFrontend.stayInMenu=true;
				break;
			case "3":
				lockedMeFrontend.stayInMenu=false;
				break;
			default:
				System.out.println("Invalid Option.");
			}
			}
			while(lockedMeFrontend.stayInMenu);
		System.out.println("Terminating after file operations... bye");
		lockedMeFrontend.sc.close();
		System.exit(0);
		
	}

}
