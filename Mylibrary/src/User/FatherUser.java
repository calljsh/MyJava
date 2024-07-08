package User;
import Book.BOOK;
import Book.BookList;
import Operation.WORK;

public  abstract class  FatherUser
{
    public FatherUser(String name)
    {
        this.name = name;
    }

    public  abstract int menu();
    protected  String name;
    protected  WORK[] works;
    public   void Doop(int choice,BookList bookList)
    {
        works[choice].work(bookList);
    }
}
