

import java.util.List;
import java.util.Scanner;

import controller.HurricaneHelper;
import model.Hurricane;

public class StartProgram {

		static Scanner in = new Scanner(System.in);
		static HurricaneHelper hh = new HurricaneHelper();

		private static void addHurricane() {
			System.out.print("Enter a hurricane name: ");
			String name = in.nextLine();
			System.out.print("Enter the hurricane's year: ");
			int year = in.nextInt();
			System.out.print("Enter the hurricane's category (1-5): ");
			int cat = in.nextInt();
			Hurricane toAdd = new Hurricane(name, year, cat);;
			hh.insertHurricane(toAdd);
		}

		private static void deleteHurricane() {
			System.out.print("Enter the hurricane name to delete: ");
			String name = in.nextLine();
			System.out.print("Enter the hurricane year to delete: ");
			int year = in.nextInt();
			System.out.print("Enter the hurricane category to delete: ");
			int cat = in.nextInt();
			Hurricane toDelete = new Hurricane(name, year, cat);
			hh.deleteItem(toDelete);

		}

		private static void editHurricane() {
			System.out.println("How would you like to search? ");
			System.out.println("1 : Search by Name");
			System.out.println("2 : Search by Year");
			System.out.println("3 : Search by Category");
			int searchBy = in.nextInt();
			in.nextLine();
			List<Hurricane> foundHurricanes;
			if (searchBy == 1) {
				System.out.print("Enter the hurricane name: ");
				String name = in.nextLine();
				foundHurricanes = hh.searchForHurricaneByName(name);
			} 
			else if (searchBy == 2) {
				System.out.print("Enter the year: ");
				int year = in.nextInt();
				foundHurricanes = hh.searchForHurricaneByYear(year);
			}
			else {
				System.out.print("Enter the category (1-5): ");
				int cat = in.nextInt();
				foundHurricanes = hh.searchForHurricaneByCategory(cat);
			}

			if (!foundHurricanes.isEmpty()) {
				System.out.println("Found Results.");
				for (Hurricane h : foundHurricanes) {
					System.out.println(h.getId() + " : " + h.toString());
				}
				System.out.print("Which ID to edit: ");
				int idToEdit = in.nextInt();

				Hurricane toEdit = hh.searchForHurricaneById(idToEdit);
				System.out.println("Retrieved Hurricane " + toEdit.getName() + ", a category " + toEdit.getCategory() + " storm from " + toEdit.getYear() + ".");
				System.out.println("1 : Update Name");
				System.out.println("2 : Update Year");
				System.out.println("3 : Update Category");
				int update = in.nextInt();
				in.nextLine();

				if (update == 1) {
					System.out.print("New Name: ");
					String newName = in.nextLine();
					toEdit.setName(newName);
				} 
				else if (update == 2) {
					System.out.print("New Year: ");
					int newYear = in.nextInt();
					toEdit.setYear(newYear);
				}
				else if (update == 3) {
					System.out.print("New Category: ");
					int newCat = in.nextInt();
					toEdit.setCategory(newCat);
				}

				hh.updateHurricane(toEdit);

			} else {
				System.out.println("---- No results found");
			}
		}

		public static void main(String[] args) {
			runMenu();
		}

		public static void runMenu() {
			boolean goAgain = true;
			System.out.println("--- Welcome to our hurricane tracker! ---");
			while (goAgain) {
				System.out.println("*  Select an item:");
				System.out.println("*  1 -- Add a hurricane");
				System.out.println("*  2 -- Edit an hurricane");
				System.out.println("*  3 -- Delete an hurricane");
				System.out.println("*  4 -- View the list");
				System.out.println("*  5 -- Exit the program");
				System.out.print("*  Your selection: ");
				int selection = in.nextInt();
				in.nextLine();

				if (selection == 1) {
					addHurricane();
				} else if (selection == 2) {
					editHurricane();
				} else if (selection == 3) {
					deleteHurricane();
				} else if (selection == 4) {
					viewList();
				} else {
					hh.cleanUp();
					System.out.println("   Goodbye!   ");
					goAgain = false;
				}

			}

		}

		private static void viewList() {
			List<Hurricane> allHurricanes = hh.showAllHurricanes();
			for(Hurricane hurricane : allHurricanes){
				System.out.println(hurricane.returnStormDetails());
			}
		}

	}