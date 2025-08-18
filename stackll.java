import java.util.Scanner;

public class stackll {
 class   Node{
        int data;
        Node next;
    }
    public Node top;
    public stackll(){
    top=null;
    }

    public void Push(int value){
        Node newNode=new Node();
        newNode.data=value;
        newNode.next=top;
        top=newNode;
        System.out.println(value + " Pushed  into the LL-Stack. ");
    }
public void Pop(){
    if(top==null){
        System.out.println("The Stack is Under-flow");
    }else{
        top=top.next;
        System.err.println(top +" Poped from Strack");
    }
}

public void Peek(){
    if(top==null){
       System.out.println("The Stcak is Underflow");
    } else{
System.err.println(top+" Top Elemewnt From Stack.");
    }
}

public void Display(){
    if(top==null){
        System.out.println("The Stack is Undertflow");
    }else{
        Node curNode=top;
        while(curNode!=null){
            curNode=curNode.next;
            System.out.println("The Elemnts are : "+curNode);
        }
    }
}
public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);

                boolean istrue=true;
while(istrue){
        System.out.println("1. Push Element Into Stack. ");
        System.out.println("2. Pop Element Into Stack. ");
        System.out.println("3. Peek of The Stack.");
        System.out.println("4. Display Stack. ");
        stackll css=new stackll();

        System.out.println("Enter Your Option : ");
        int option =sc.nextInt();
        switch (option) {
            case 1:
            System.out.println("Enter Value to Push.");
            int val=sc.nextInt();
                css.Push(val);
                break;
                case 2:
                css.Pop();
                break;
                case 3:
                css.Peek();
                break;
                case 4:
                css.Display();
                break;
            default:
                throw new AssertionError();
        }}
        
}
    
}
