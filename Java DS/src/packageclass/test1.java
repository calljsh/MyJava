package packageclass;

public class test1
{
    public static void main(String[] args) {
        Integer a=128;
        Integer b=229;
        System.out.println(a);
        System.out.println(b);
        if(a==b)
        {
            System.out.println("ok");
        }
        else
        {
            System.out.println("no");
        }
        // 为什么是NO 呢,看源码就知道了!
    }
}
