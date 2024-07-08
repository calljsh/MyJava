package Operation;
import Book.BOOK;
import Book.BookList;
import java.util.Scanner;
public class Borrow  implements WORK
{
    @Override
    public void work(BookList bookList)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入你要借的书的名字");
        String name=sc.nextLine();
        int size= bookList.getUsedsize();
        for(int i=0;i<size;i++)
        {
            BOOK temp= bookList.getBook(i);
             if(temp.getName().equals(name)&&temp.isBorrowed()==false)
             {
                 System.out.println("成功借出");
                 temp.setBorrowed(true);
                 return ;
             }
        }
        System.out.println("借阅失败");
    }
}
