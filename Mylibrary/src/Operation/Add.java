package Operation;
import Book.BOOK;
import Book.BookList;
import java.util.Scanner;
public class Add implements WORK
{
    @Override
    public void work(BookList bookList)
    {
        System.out.println("增加图书");
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入您要添加的图书的书名：");
        String name = scanner.nextLine();
        System.out.println("请输入您要添加的图书的作者名：");
        String author = scanner.nextLine();
        System.out.println("请输入您要添加的图书的类型：");
        String type = scanner.nextLine();
        System.out.println("请输入您要添加的图书的价格：");
        int price = scanner.nextInt();
        BOOK book=new BOOK( name,author,price,type);
        int size=bookList.getUsedsize();
        for(int i=0;i<size;i++)
        {
            BOOK temp=bookList.getBook(i);
            if(temp.equals(book))
            {
                System.out.println("不能添加一样的书");
                return ;
            }
        }
        System.out.println("添加成功");
        bookList.setBook(size,book);
        bookList.setUsedsize(size+1);
    }
}
