package stack;

import java.util.Scanner;
import java.util.Stack;

public class Test
{
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        int num = scanner.nextInt();
        int n=scanner.nextInt();
        Stack<Integer> stack=new Stack<>();
        int x=num;
        while(x!=0)
        {
            int y=x%n;
            stack.add(y);
            x=x/n;
        }
        while(stack.size()!=0)
        {
            System.out.print(stack.pop()+" ");
        }
    }
}
