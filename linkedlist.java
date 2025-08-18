

import com.sun.source.tree.WhileLoopTree;
import java.util.*;
class Node{
    int data;
    int pos;
    Node next;
    Node(int data){
        this.data=data;
        this.next=null;
    }
}
 class  deltion{

  static Node NodeDetelete(Node head){
Node temp=head;

System.out.println("The Deleted First Node is : "+temp.data);
head=head.next;
temp=null;
return head;

}


  static Node NodeDeteleteSpecific(Node head){
    int i;
Node temp=head;
Node prev=temp;
 for( i=0 ;i<=3-1;i++){
    prev=temp;
    temp=temp.next;

}
  prev.next=temp.next;
     
System.out.println("The Deleted specific Node At Index 3 : "+temp.data);
return head;

}

  static Node Detelete(Node head){
Node temp=head;
Node prev=temp;
while(temp.next!=null){
  prev=temp;
    temp=temp.next;

    
}

prev.next=null;
System.out.println("The Deleted Last Node is : "+temp.data);
return head;

}
        static void printList(Node curr) {
         
        while (curr != null) {
         
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }

    public static void main(String[]args){



Node head=new Node(90);
 head.next=new Node(80);
 head.next.next=new Node(70);
 head.next.next.next=new Node(60);
 head.next.next.next.next=new Node(50);
  printList(head);
  System.out.println(" ");
   Scanner sc=new Scanner(System.in);
   boolean Istrue=true;
   while(Istrue){
 System.out.println("1. Deletion at the First ");
  System.out.println("2. Deletion at the Last");
   System.out.println("3. Deletion At the Specific Position ");
   System.out.println("4. Print LinkedList .");
      System.out.println("Enter Your Option : ");
int option=sc.nextInt();

 switch (option) {
     case 1:{
          head=NodeDetelete(head);
         break;}
         case 2:{
 head=Detelete(head); 
 break;
         }
         case 3:{
                
             
     head=NodeDeteleteSpecific(head);
     break;
         }
         case 4:{
            System.out.println("The Linked List Nodes : ");
             printList(head);
        System.out.println(" ");
             break;
         }
  
 }
   }

    }
}