package stack;

public class Test
{
    public static void main(String[] args) {
     Stack stack=new Stack();
     stack.push(341);
        stack.push(6741);
        stack.push(3554);
        stack.push(4231);
        stack.push(31);
        int num= stack.peek();
        stack.pop();
        int num2=stack.peek();
        System.out.println(num+" "+num2);
    }
}
