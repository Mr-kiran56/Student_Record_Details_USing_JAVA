/******************************************************************************
                               Queue Using Arrays
*******************************************************************************/
import java.util.*;
class Array{
    int font;
    int rear;
    int maxsize;
 int QueueArray[];
    Array(int size){
        this.font=0;
        this.rear=-1;
        this.maxsize=size;
          this.QueueArray=new int[maxsize];
    }
   
        void enQueue(int value){
            if(rear==maxsize-1){
                System.out.println("Queue if Overflow..");
            }else{
                QueueArray[++rear]=value;
                System.out.println("Value inseted : "+value);
            }
        }

        void DeQueue(){
            if(font>rear){
                System.out.println("Queue is Underflow..");
            }else{
                System.out.println("The Element is Dequeued :"+QueueArray[font++]);
            }
        }
        void Peek(){
            if(font>rear){
                System.out.println("The QUeue is Underflow..");
            }else{
                System.out.println("The peek of the Queue is :"+QueueArray[font]);
            }
        }

        void Display(){
              if(font>rear){
                System.out.println("The QUeue is Underflow..");
            }else{
                for(int i=font;i<=maxsize-1;i++){
                    System.out.println("The Queue Elements are : "+QueueArray[i]);
                }
            }
        }
    }
 public class Main{
   
            public static void main(String[]args){
                Scanner sc=new Scanner(System.in);
System.out.println("Enter the Size of The Array : ");
int size =sc.nextInt();
Array au=new Array(size);

boolean istrue=true;
while(istrue){
    System.out.println("1. EnQueue ");
        System.out.println("2. DeQueue ");
            System.out.println("3. Peek ");
                System.out.println("4.Display ");
    System.out.println("Enter Your Option : ");
int option=sc.nextInt();
switch(option){
    case 1:{
        System.out.println("Enter Your Value to Insert : ");
        int val=sc.nextInt();
        au.enQueue(val);
        break;
    }
    case 2:{
        au.DeQueue();
        break;
    }
    case 3:{
        au.Peek();
        break;
    }
    case 4:{
        au.Display();
        break;
    }
}
}
            }
        }



