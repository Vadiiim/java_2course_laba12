package laba12;
import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;
import java.text.DateFormat;
import java.util.Date;
public class Library implements Serializable  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private catalog catalog;
    private List<Book> borrowedBooks;
    private List<String> blackList;
    public final Date creationDate = new Date();

	public String getCreationDate() {
		DateFormat dateFormatter = DateFormat.getDateTimeInstance(DateFormat.DEFAULT, DateFormat.DEFAULT, AppLocale.get());
		String dateOut = dateFormatter.format(creationDate);
		return dateOut;
	}
    public Library() {
        this.catalog = new catalog();
        this.borrowedBooks = new ArrayList<>();
        this.blackList = new ArrayList<>();}
    

    public void addBookToCatalog(Book book) {
        catalog.addBook(book);
    }

    public void borrowBook(String title) {
        Book book = catalog.findBook(title);
        if (book != null) {
            borrowedBooks.add(book);
            System.out.println("Выдана книга \"" + book.getTitle() + "\" на абонемент.");
        } else 
        {
            System.out.println("Книга \"" + title + "\" не найдена в каталоге.");
        }
    }
        public void returnBook(String title) {
            for (Book book : borrowedBooks) {
                if (book.getTitle().equals(title)) {
                    borrowedBooks.remove(book);
                    System.out.println("Книга \"" + book.getTitle() + "\" успешно возвращена.");
                    return;
                }
            }
            System.out.println("Книга \"" + title + "\" не найдена в списке взятых книг.");
        }

        public void addToBlackList(String reader) {
            blackList.add(reader);
            System.out.println("Читатель \"" + reader + "\" добавлен в черный список.");
        }

        public boolean isInBlackList(String reader) {
            return blackList.contains(reader);
        }
        
        public String toString() {
    		return "Book list: "+catalog.toString()+"\nBlack list: "+blackList.toString()+"\nList of books borrowed for subscription or reading room: "+borrowedBooks.toString();
    	}
}
    


