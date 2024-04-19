package assignmentTow;
//Abedalkreem ingas
//1200507
import java.util.*;

public class MyLibray {

	static LibraryCatalog catalog = new LibraryCatalog();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int choise;
//display a menu
		do {
			System.out.println("Library Catalog Menu:");
			System.out.println("1) Add a book to the Library Catalog\r\n" + "2) Search a Book\r\n"
					+ "3) Borrow a Book \r\n" + "4) Return a Book\r\n"
					+ "5) List all the book titles in Library Catalog\r\n" + "6) Quit");
			System.out.println("Enter your choise : ");
			choise = input.nextInt();
			switch (choise) {
			case 1:
				addBookToCatalog();
				break;
			case 2:
				searchBook();
				break;
			case 3:
				BorrowABook();
				break;
			case 4 :
				ReturnABook();
				break;
			case 5:
				catalog.list_titles();
			case 6:
				System.out.println("Exiting the library catalog. Goodbye!");
				break;
			default:
				System.out.println("Invalid choice. Please try again.");
			}

		} while (choise != 6);

	}

	private static void addBookToCatalog() {
		System.out.println("Enter the title of the book: ");
		Scanner scanner = new Scanner(System.in);
		String title = scanner.nextLine();
		
		if (catalog.searchBook(title) != -1) {
			System.out.println("Alredy Exisits");
			System.out.println("Enter The number of extra copies you want to add : ");
			int q = scanner.nextInt();
			catalog.add_copies(title, q);
		} else {
			System.out.println("Enter the Author: ");
			String author = scanner.nextLine();
			System.out.print("Enter the copies of the book: ");
			int copies = scanner.nextInt();
			System.out.print("Enter the copyright of the book: ");
			int copyright = scanner.nextInt();
			BookIndex b = new BookIndex(copyright, copies, author, title);
			catalog.addNewBook(b);
		}
		System.out.println("Done!");
	}

	private static void searchBook() {
		System.out.println("Enter the title of the book");
		Scanner scanner = new Scanner(System.in);
		String Title = scanner.nextLine();
		int isExist = catalog.searchBook(Title);
		if (catalog.searchBook(Title) == -1) {
			System.out.println("This book is not available in the library. ");
		} else {
			System.out.println("This Book is Exixst at index : " + catalog.searchBook(Title));
			catalog.listOne(catalog.searchBook(Title));
		}

	}
	private static void BorrowABook() {
		System.out.println("Enter the title of the book you want Borrow :");
		Scanner scanner = new Scanner(System.in);
		String title = scanner.nextLine();
		boolean check = catalog.borrowBook(title);
        if (check) {

            System.out.println("The book has been successfully loaned. ");
            System.out.println("Must be returned in 10 days.");
            System.out.println(" ");
			catalog.listOne(catalog.searchBook(title));

            
        } else {
            System.out.println("The book is not available in the library.");
        }

		
	}
	
	private static void ReturnABook() {
		System.out.print("Enter the title of the book: ");
		Scanner scanner = new Scanner(System.in);

        String title = scanner.nextLine();

        boolean check = catalog.returnBook(title);
        if (check) {
            System.out.println("the book has been successfully returned. ");
            System.out.println("Thank you for returning the book on time.");

        } else {
            System.out.println("A book with the entered title has not been found in the library.");
            System.out.println("Please re-repeat the search.");
        }
	}
}
