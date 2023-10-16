package laba12;
import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;
public class catalog implements Serializable  {
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	
	private List<Book> books;

	    public catalog() {
	        this.books = new ArrayList<>();
	    }

	    public void addBook(Book book) {
	        books.add(book);
	    }

	    public Book findBook(String title) {
	        for (Book book : books) {
	            if (book.getTitle().equals(title)) {
	                return book;
	            }
	        }
	        return null;
	    }
	    public String toString() {
        	return books.toString();
    	}
}
