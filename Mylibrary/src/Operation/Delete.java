package Operation;
import Book.BOOK;
import Book.BookList;
import java.util.Scanner;
public class Delete implements WORK
{
    @Override
    public void work(BookList bookList)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("输入你要删除图书的名字");
        String name = sc.nextLine();
        int size=bookList.getUsedsize();
        int pd=0;
        int flag=0;
        for(int i=0;i<size;i++)
        {
            BOOK temp=bookList.getBook(i);
           if(temp.getName().equals(name))
           {
               pd=1;
               flag=i;
               break;
           }
        }
        if(pd==0)
        {
            System.out.println("没有这本书,删除失败");
            return ;
        }
       else
        {
            for(int j=flag;j<size;j++)
            {
                BOOK book=bookList.getBook(j+1);
                bookList.setBook(j,book);
                // 把前一个的信息填进来
            }
        }
       bookList.setBook(size,null);
       bookList.setUsedsize(size-1);
    }
}
