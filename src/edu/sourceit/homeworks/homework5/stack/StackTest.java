package edu.sourceit.homeworks.homework5.stack;

public class StackTest {
    public static void main(String[] args) {
        Stack stack = new Stack(5) {{
            System.out.println(pop());
            print();
            push(1);
            push(5);
            push(10);
            push(17);
            push(33);
            //ToDo : and this will not work
            push(179);
        }};
        stack.print();
        System.out.println("Peeking " + stack.peek());
        System.out.println("Popping " + stack.pop());
        System.out.println("Popping " + stack.pop());
        stack.print();

        stack.push(45);
        stack.push(50);
        stack.push(55);
        stack.push(60);
        stack.push(65);
        stack.push(70);
        stack.push(75);
        stack.print();
        System.out.println("Popping " + stack.pop());
        System.out.println("Popping " + stack.pop());
        stack.print();
    }
}
