package Operation;
import Book.BOOK;
import Book.BookList;
import java.util.Scanner;
public class Show  implements WORK
{
    @Override
    public void work(BookList bookList)
    {
        int size= bookList.getUsedsize();
        for(int i=0;i<size;i++)
        {
            System.out.println(bookList.getBook(i));
            System.out.print(" ");
        }
    }
}
