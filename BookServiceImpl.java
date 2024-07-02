import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookServiceImpl implements BookServiceInterface
{
	    public static final String RED="\u001B[31m";
	    public static final String RESET="\u001B[0m";
	    public static final String BLUE="\u001B[34m";
	    public static final String GREEN="\u001B[32m";
	    public static final String CYAN="\u001B[36m";
	    public static final String BLACK="\u001B[30m";
	    
	    Scanner sc=new Scanner(System.in);
	    
	    Validator validator=new Validator();
	    
	    List<Book> books=new ArrayList<>();
	
	
	@Override
	public void addBook() 
	{
	       String bookid= validator.validateId();
	       String Author=validator.validateAuthorTitle("Author");
	       String Title=validator.validateAuthorTitle("Title");
	       String year=validator.validatePublishYear();
	       Book book=new Book(bookid,Author,Title,year,"Available");
	       books.add(book);
	       System.out.println("Book Added Successfully !!!");
	}

	@Override
	public void showAllBooks()
	{
		 boolean flag=false;
	        System.out.println("\n----------------------------------------------------------------------------------------------");
	        System.out.format("%s%15s%15s%15s%15s","ID","TITLE","AUTHOR","PUBLISH YEAR","STATUS");
	       System.out.println("\n----------------------------------------------------------------------------------------------");

	          for (Book book:books){
	              System.out.format("%s%15s%15s%15s%15s",book.getId(),book.getTitle(),book.getAuthor(),book.getPublishYear(),book.getStatus());
	              System.out.println();
	              flag=true;
	            }
	        System.out.println("\n----------------------------------------------------------------------------------------------");
	       if(flag==false)
	           System.out.println("There are no Books in Library");
	}

	@Override
	public void showAllAvailableBooks() 
	{
		 boolean flag=false;
	        System.out.println("\n----------------------------------------------------------------------------------------------");
	        System.out.format("%s%15s%15s%15s%15s","ID","TITLE","AUTHOR","PUBLISH YEAR","STATUS");
	        System.out.println("\n----------------------------------------------------------------------------------------------");

	        if(books.size()>0)
	        {
	            for (Book book:books)
	            {
	                if(book.getStatus()=="Available")
	                {
	                    System.out.format("%s%15s%15s%15s%15s",book.getId(),book.getTitle(),book.getAuthor(),book.getPublishYear(),book.getStatus());
	                    System.out.println();
	                    flag=true;
	                }
	            }
	        }
	        else
	        {
	            System.out.format("\t\t No Books in the Available status");
	        }
	        System.out.println("\n----------------------------------------------------------------------------------------------");
	        if(flag==false)
	            System.out.println("There are no books with status Available");
	}

	@Override
	public void borrowBook() 
	{
		
	}

	@Override
	public void returnBook() 
	{
		
	}

}
