package laba12;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.io.File;
import java.io.*;
import java.io.IOException;
public class test {
	
	
	 public static Library[] createlib() 
	 { 
		 	Library[] band = new Library[5];

			band[0] = new Library();
			band[0].addBookToCatalog(new Book(AppLocale.getString(AppLocale.Crime_and_Punishment), AppLocale.getString(AppLocale.Fedor_Dostoevsky)));
			band[0].addBookToCatalog(new Book(AppLocale.getString(AppLocale.Romeo_and_Juliet), AppLocale.getString(AppLocale.William_Shakespeare)));
			
			band[1]=new Library();
			band[1].addBookToCatalog(new Book(AppLocale.getString(AppLocale.War_and_Peace), AppLocale.getString(AppLocale.Lev_Tolstoy)));
			band[1].addBookToCatalog(new Book(AppLocale.getString(AppLocale.A_Tale_of_Two_Cities), AppLocale.getString(AppLocale.Charles_Dickens)));
		
			band[2] = new Library();
			band[2].addBookToCatalog(new Book(AppLocale.getString(AppLocale.roman1984), AppLocale.getString(AppLocale.George_Orwell)));
			band[2].addBookToCatalog(new Book(AppLocale.getString(AppLocale.Julius_Caesar), AppLocale.getString(AppLocale.William_Shakespeare)));
			
			band[3]=new Library();
			band[3].addBookToCatalog(new Book(AppLocale.getString(AppLocale.Politics_and_English), AppLocale.getString(AppLocale.George_Orwell)));
			band[3].addBookToCatalog(new Book(AppLocale.getString(AppLocale.At_a_dead_end), AppLocale.getString(AppLocale.Charles_Dickens)));
		
			band[4] = new Library();
			band[4].addBookToCatalog(new Book(AppLocale.getString(AppLocale.Dead_Souls), AppLocale.getString(AppLocale.Nikolay_Gogol)));
			band[4].addBookToCatalog(new Book(AppLocale.getString(AppLocale.Auditor), AppLocale.getString(AppLocale.Nikolay_Gogol)));
			
			return band;
	  }
	 
	 static Locale createLocale(String[] args) {
			if (args.length == 2) {
				return new Locale(args[0], args[1]);
			} else if (args.length == 4) {
				return new Locale(args[2], args[3]);
			}
			return null;
		}
	 
	 static void setupConsole(String[] args) {
			if (args.length >= 2) {
				if (args[0].equals("-encoding")) {
					try {
						System.setOut(new PrintStream(System.out, true, args[1]));
					} catch (UnsupportedEncodingException ex) {
						System.err.println("Unsupported encoding: " + args[1]);
						System.exit(1);
					}
				}
			}
		}
	 
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		try {
			setupConsole(args);
			Locale loc = createLocale(args);
			if (loc == null) {
				System.err.println("Invalid argument(s)\n"
						+ "Syntax: [-encoding ENCODING_ID] language country\n"
						+ "Example: -encoding Cp855 be BY");
				System.exit(1);
			}
			AppLocale.set(loc);
		  
			Library library = new Library();
	        library.addBookToCatalog(new Book("Преступление и наказание", "Федор Достоевский"));
	        library.addBookToCatalog(new Book("Война и мир", "Лев Толстой"));

	        Scanner scanner = new Scanner(System.in);
	        String reader;

	        do {
	            System.out.print("Введите ваше имя: ");
	            reader = scanner.nextLine();

	            if (library.isInBlackList(reader)) {
	                System.out.println("Вы находитесь в черном списке и не можете брать книги.");
	                continue;
	            }

	            System.out.print("Введите название книги, которую хотите взять: ");
	            String bookTitle = scanner.nextLine();

	            library.borrowBook(bookTitle);

	            System.out.print("Хотите вернуть книгу? (да/нет): ");
	            String returnChoice = scanner.nextLine();

	            if (returnChoice.equalsIgnoreCase("да")) {
	                library.returnBook(bookTitle);
	            }

	            System.out.print("Хотите выйти? (да/нет): ");
	            String exitChoice = scanner.nextLine();

	            if (exitChoice.equalsIgnoreCase("да")) {
	                break;
	            }

	        } while (true);
	        Library[] lib=new Library[1];
	        lib[0]=library;
	        Connector con = new Connector(new File("band_stage1.dat"));
			con.write(lib);
			 Library [] band = con.read();
			 for (Library n : band) {
					System.out.println(n);
				}
				System.out.println(lib[0].getCreationDate());
				
			
				Connector con1 = new Connector(new File("band_stage2.dat"));
				con1.write(createlib());
				Library[] band1 = con.read();
				System.out.println(AppLocale.getString(AppLocale.libraries) + ":");
				for (Library n : band1) {
					System.out.println(n);
				}
	    	}
		catch (Exception e) {
			System.err.println(e);
		}
	}
	}


