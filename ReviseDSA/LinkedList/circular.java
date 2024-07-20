package LinkedList;
import java.util.Scanner;

class Node {
    int info; 
    Node next;

    Node(int x) {
        info=x;
        next=null;
    }

    public Node() {
    }
    
}

class circular {
    Scanner input = new Scanner(System.in);
    static Node head;

    //MainMethod
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        circular obj = new circular();
        while(true) {
            System.out.println("****MENU*****");
            System.out.println("0:Exit");
            System.out.println("1:Creation");
            System.out.println("2:Display");
            System.out.println("3:Insert in Beginning");
            System.out.println("4:Insert in Ending");
            System.out.println("5:Insert at any Position");
            System.out.println("6:Delete in Beginning");
            System.out.println("7:Delete in Ending");
            System.out.println("8:Delete at any Position");
            System.out.println("9:Search the Linked List");
            System.out.println("10:Sort the Linked List");
            System.out.println("11:Count the number of elements in the Linked List");
            System.out.println("12:Reverse the Linked List"); 
            System.out.println("Enter the choice");
            int choice=input.nextInt();
            switch(choice) {
                case 0:
                System.out.println("Exiting the Program"); 
                input.close();
                System.exit(0);
                case 1:
                obj.create(); 
                break; 
                case 2:
                obj.display(); 
                break; 
                case 3:
                obj.InsBeg();
                break; 
                case 4:
                obj.InsEnd();
                break;
                case 5:
                obj.InsAny();
                break;
                case 6: 
                obj.DelBeg();
                break;
                case 7:
                obj.DelEnd();
                break;
                case 8:
                obj.DelAny();
                break;
                case 9:
                obj.search();
                break;
                case 10:
                obj.sort();
                break; 
                case 11:
                System.out.println("Number of Nodes in the Linked List=" +count());
                break; 
                case 12:
                obj.reverse();
                break; 
                default:
                System.out.println("Wrong choice");
            }
        }
    }
    //create
    public void create() {
        head = null;
        Node p = new Node(); 
        System.out.println("Input node info: ");
        p.info = input.nextInt();
        head = p;
        p.next = head; 
        System.out.println("Do you want more nodes?(1/0) ");
        int ch = input.nextInt();
        while(ch!=0){
            Node q = new Node();
            System.out.println("Input node info: ");
            q.info = input.nextInt();
            p.next = q; 
            p=q;
            p.next=head;
            System.out.println("Do you want more nodes?(1/0) ");
             ch = input.nextInt();
        }
               
    }
    //display
    public void display(){
        
        Node node = head;
        do{
            System.out.print(node.info+ " ");
            node = node.next;
        }while(node!=head);
        System.out.println();
    }

    //count
      public static int count(){
        int c = 0;
        Node p = head;
        if(head!=null){
            do{
                p=p.next;  
                c++;              
            }while(p!=head);
        }
        return c;
    }

    //Search
    public void search(){
        int pos = 0;
        int f=0;
        Node n= head;
        if (head == null) 
            System.out.println("Empty");
        else{
            System.out.print("Enter the info to be searched:"); 
            int ele=input.nextInt();
            do{
                pos++;
                if(n.info==ele) {
                    System.out.println(pos);
                    f=1;
                    break;
                }
                n=n.next;
            }while(n!=head);
            if(f==0)
                System.out.println("Not found");    
        }
    }
      

    //Insertion at Start
    public void InsBeg() {
        Node p = new Node();
            System.out.println("Input node info: ");
            p.info = input.nextInt();
            p.next = null; 
        if(head==null) {
            head=p;
            p.next = head;
        }
        else {
            Node q = head;
            while(q.next!=head){
                q = q.next;
            }
            p.next = head;
            head = p;
            q.next=head;
        }
    }
    //Insertion at End
    public void InsEnd(){
        Node p = new Node();
            System.out.println("Input node info: ");
            p.info = input.nextInt();
        if(head==null) {
            head=p;
            p.next = head;
        }
        else {
            Node q = head;
            while(q.next != head){
                q=q.next; 
            }
            q.next = p;
            p.next = head;
        }
    }
  

    //Insertion at Any
    public void InsAny(){
        System.out.print("Enter the Postion number to insert Node at:"); 
        int loc=input.nextInt();
        int c = count();
        if(loc <= c+1) {
            if(loc==1)
                InsBeg();
            else if (loc == c+1)
                InsEnd();
            else {
            Node p= new Node();
            System.out.print("Enter Node info: "); 
            p.info=input.nextInt(); 
            p.next=head;

            Node q = head;
            int cnt = 1;
            while(cnt < loc-1) {
                cnt++;
                q=q.next;
            }
            p.next = q.next;
            q.next = p;
            
        }
    }    
    }
    //Deletion at Start
    public void DelBeg(){
        if(head == null){
            System.out.println("Empty linked list");
            System.out.println();
        }
        Node p = head, q = head;
        if(p.next == p){
            head=null;
            System.out.println();
        }
        while(p.next != head){
            p=p.next;
        }
        p.next = q.next;
        head=p.next;
        System.out.println();
    }
    //Deletion at End
    public void DelEnd() { 
        if(head==null) {
            System.out.println("Please Create a Linked List First"); 
            System.out.println(head);
        }
        else if(head.next==null) {
            DelBeg();
            System.out.println("Deletion Successful");
            
        }
        else{
            Node q = head;
            while(q.next.next!=head){
                q=q.next;
            }
            q.next=head;
            System.out.println("Deletion Successful"); 
            
        }
    }
    //Deletion at Any
    public void DelAny(){
        if(head==null){
            System.out.println("Empty linked list");
        }
        System.out.print("Enter the Position number to Delete Node at:");
        int loc=input.nextInt();
        int c = count();
        if (loc <= c){
            if(loc==1)
                DelBeg();
            else if (loc == c)
                DelEnd();
            else {
            Node q=null, p = head;
            int cnt = 1;
            while(cnt < loc) {
                cnt++;
                q=p;
                p=p.next;
            }
            q.next = p.next;
            p.next = p;
        }
    }    
    }

    //reverse
    public void reverse() {
        if(count() >= 2){
            Node p = null;
            Node q = head;
            Node r = head.next;
            do{
                r=q.next;
                q.next=p;
                p=q;
                q=r;
            }while(q!=head);
            head.next = p;
            head=p;
            
            }
        }
    //sort
    public void sort() {
        if(head==null) {
            System.out.println("Linked List is Empty"); 
            
        }
        else {
            Node i,j;
            for(i=head;i.next!=head;i=i.next){
                for(j=head;j.next!=head;j=j.next) {
                    if(j.info>j.next.info) {
                        
                        int temp=j.info; 
                        j.info=j.next.info;
                        j.next.info=temp;
                    }
                }
            }
            System.out.println("Linked List Sorted"); 
            
        }
    } 
}
