import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Book
{
private String title;
private String author;

public Book(String title, String author)
{
this.title=title;
this.author=author;
}
public String gettitle()
{
return title;
}
public String getauthor()
{
return author;
}
}

class Library
{
    private List<Book> books;
    public Library(){
        books = new ArrayList<>();
    }
    public void addBook(BOOK book)
    {
        books.add(book);
    }
    public void displayBooks(){
        if (books.isEmpty()){
            System.out.println("no books in the library:");
        }else{
            
        }
    }
}
