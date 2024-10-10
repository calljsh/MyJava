package stack;

public interface MyStack
{
    void push(int x);
    // 进栈

    int size();
    // 栈内有多少元素

    int peek();
    // 显示最近入栈的元素

    int pop();
    // 弹出栈顶的元素

    boolean empty();
  // 判断是否为空

}
