
import java.util.Scanner;

 class Creation { 
    private int max_size;
    private int arrstack[];
    private int top;

    public Creation(int size) {
        max_size=size;
        arrstack=new int[max_size];
        top=-1;
    }

    public void Push(int value){
        if(top==max_size-1){
            System.out.println("Stack Is Over Flow ");
        }else{
            arrstack[++top]=value;
        }
    }
    public void Pop(){
         if(top==-1){
            System.out.println("Stack is Under Flow ");
        }else{
            System.out.println("the poped ELement : "+arrstack[top--]);

        }
    }
    public void Peek(){
          if(top==-1){
            System.out.println("Stack is Under Flow ");
        }else{
            System.out.println("the poped ELement : "+arrstack[top]);

        }
    }
     public void Diaplay(){
          if(top==-1){
            System.out.println("Stack is Under Flow ");
        }else{
            for(int i=max_size-1;i>=0;i--)
            System.out.println("the  ELement : "+arrstack[i]);

        }
    }


}

public class Stack {
    public static void main(String[] args) {
Scanner sc=new Scanner(System.in);

        System.out.println("Enter The Stack Size : ");
        int size=sc.nextInt();
                Creation c=new Creation(size);

                boolean istrue=true;
while(istrue){
        System.out.println("1. Push Element Into Stack. ");
        System.out.println("2. Pop Element Into Stack. ");
        System.out.println("3. Peek of The Stack.");
        System.out.println("4. Display Stack. ");

        System.out.println("Enter Your Option : ");
        int option =sc.nextInt();
        switch (option) {
            case 1:
            System.out.println("Enter Value to Push.");
            int val=sc.nextInt();
                c.Push(val);
                break;
                case 2:
                c.Pop();
                break;
                case 3:
                c.Peek();
                break;
                case 4:
                c.Diaplay();
                break;
            default:
                throw new AssertionError();
        }}
        
    }
}
