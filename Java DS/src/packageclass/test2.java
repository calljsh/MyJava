package packageclass;

class  Myarr <T>
{
    public Object [] arr=new Object[10];
    public  T Getarr(int pos)
    {
     return   (T)arr[pos];
    }
    public  void Setarr(int pos,T  val)
    {
           arr[pos]=val;
    }
}
public class test2
{
    public static void main(String[] args) {
         Myarr<Integer> arr1=new Myarr<>();
         arr1.Setarr(1,10);
         int num1=arr1.Getarr(1);
        System.out.println(num1);
    }
}


