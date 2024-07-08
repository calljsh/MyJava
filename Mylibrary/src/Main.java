import Book.BookList;
import User.Adminuser;
import User.FatherUser;
import User.Nomaluser;
import java.util.Scanner;
class  IncorrectPasswordException extends RuntimeException
{
    public IncorrectPasswordException(String message) {
        super(message);
    }
}
public class Main
{
    public  static boolean Password()
    {
        System.out.println("请输入密码");
        {
            Scanner sc=new Scanner(System.in);
            String password= sc.nextLine();
            if(password.equals("jsh"))
            {
                return true;
            }
            else
            {
                throw   new IncorrectPasswordException("密码错误");
            }
        }
    }
     public  static FatherUser login()
     {
         Scanner sc=new Scanner(System.in);
         System.out.println("请输入你的姓名");
         String name=sc.nextLine();
         System.out.println("请输入你的身份: 1.管理员 2.用户");
         int identify = sc.nextInt();
         if(identify==1)
         {
             try
             {
              if(Password())
              {
                  System.out.println("密码正确");
                  return new Adminuser(name);
              }
             }
             catch (IncorrectPasswordException e)
             {
                  e.printStackTrace();
                  return null;
             }
         }
       else
         {
             return new Nomaluser(name);
         }
  return null;
     }
    public static void main(String[] args)
    {
        BookList bookList=new BookList();
        FatherUser user;
        while(true)
        {
            user=login();
            if(user!=null)
            {
                break;
            }
        }
        while(true)
        {
            int choice= user.menu();
            user.Doop(choice,bookList);
        }
    }
}