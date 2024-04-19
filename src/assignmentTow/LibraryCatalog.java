package assignmentTow;

//Abedalkreem Ingas
//1200507
import java.util.*;

public class LibraryCatalog {

	private BookIndex[] BookCatalog;

	public LibraryCatalog() {
		BookCatalog = new BookIndex[20];
		for (int i = 0; i < BookCatalog.length ; i++) {
			BookCatalog[i] = null;
		}

	}
//this method  for adding a new book to the library 
	public void addNewBook(BookIndex b) {
		for (int i = 0; i < BookCatalog.length ; i++) {
			if (BookCatalog[i] == null) {
				BookCatalog[i] = b;
				break;
			}
		}
	}
	//this method adds the book to the catalog with n copies

	public void addNewBook(BookIndex b, int NoCop) {
		for (int i = 0; i < BookCatalog.length ; i++) {
			if (BookCatalog[i] == null) {
				b.setCopies(NoCop);
				BookCatalog[i] = b;
				break;

			}
		}

	}
//this method  for adds a quantity number of copies to the book
	public boolean add_copies(String title, int quantity) {
		for (int i = 0; i < BookCatalog.length ; i++) {
			if (BookCatalog[i].getTitle().equals(title)) {
				BookCatalog[i].setCopies(BookCatalog[i].getCopies() + quantity);
				return true;
			}

		}
		return false;
	}
//this method  for returns the number of copies
	public int findInCatalog(String title) {
		for (int i = 0; i < BookCatalog.length ; i++) {
			if (BookCatalog[i].getTitle().equals(title)) {
				return BookCatalog[i].getCopies();
			}

		}

		return 0;
	}
//this method  for returns the index of the Book
	public int searchBook(String title) {
		for (int i = 0; i < BookCatalog.length ; i++) {
			if (BookCatalog[i] != null) {
				if (BookCatalog[i].getTitle().equals(title)) {
					return i;
				}
			}
		}
		return -1;
	}
//this method to lists all the titles of the books with its information in the LibraryCatalog
	public void list_titles() {
		for (int i = 0; i < BookCatalog.length ; i++) {
			if (BookCatalog[i] != null)
				System.out.println("Title: " + BookCatalog[i].getTitle() + "|| Auther: " + BookCatalog[i].getAuthor()
						+ " || Copies: " + BookCatalog[i].getCopies() + "|| CopyRight: " + BookCatalog[i].getCopyright());

		}
	}
//this method  for list a information of a specific book
	public void listOne(int x) {
		for (int i = 0; i < BookCatalog.length ; i++) {
			if (BookCatalog[i] != null) {
				if(i == x) {
					System.out.println("Title: " + BookCatalog[i].getTitle() + " || Auther: " + BookCatalog[i].getAuthor()
							+ "|| Copies: " + BookCatalog[i].getCopies() + "|| CopyRight: " + BookCatalog[i].getCopyright());

				}
			}
		}
	}
//this method for loans a book with the title to a borrower
	public boolean borrowBook(String title) {
		for (int i = 0; i < BookCatalog.length ; i++) {
			if (BookCatalog[i].getTitle().equals(title)) {
				if (BookCatalog[i].getCopies() > 0) {
					BookCatalog[i].setCopies(BookCatalog[i].getCopies() - 1);
					return true;
				}
				return false ;
			}
			return false;

		}

		return false;

	}
//this method for returns a book with the title
	public boolean returnBook(String title) {
		for (int i = 0; i < BookCatalog.length ; i++) {
			if (BookCatalog[i].getTitle().equals(title)) {

				BookCatalog[i].setCopies(BookCatalog[i].getCopies() + 1);
				return true;

			}

		}

		return false;
	}

}
