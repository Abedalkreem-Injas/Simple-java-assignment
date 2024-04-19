package assignmentTow;
//Abedalkreem Ingas
//1200507
import java.util.*;
public class BookIndex {
    private String Title;
    private String Author;
    private int Copies;
    private int Copyright;
    public BookIndex(int copyRight , int coopies , String author , String title) {
    	this.Copyright=copyRight;
    	this.Copies=coopies;
    	this.Author=author;
    	this.Title=title;
    }
	public String getTitle() {
		return Title;
	}
	public int getCopies() {
		return Copies;
	}
	public void setCopies(int copies) {
		Copies = copies;
	}
	public int getCopyright() {
		return Copyright;
	}
	public void setCopyright(int copyright) {
		Copyright = copyright;
	}
	public String getAuthor() {
		return Author;
	}
	@Override
	public String toString() {
		return "BookIndex [Title=" + Title + ", Author=" + Author + ", Copies=" + Copies + ", Copyright=" + Copyright+ "]";
	}
	
}
