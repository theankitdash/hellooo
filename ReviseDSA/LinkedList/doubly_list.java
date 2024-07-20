package LinkedList;
import java.util.Scanner;

class doubly {
	class Node{

		int info;
		Node prev, next;
		
	
		Node(int x){
			info=x;
			prev=null;
			next=null;
		}	
	
		public Node() {
		}
	}

	Scanner input = new Scanner(System.in);
    static Node head, end;

    public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
        doubly obj = new doubly();
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
        Node p = new Node(); 
        System.out.println("Input node info: ");
        p.info = input.nextInt();
        p.prev = p.next = null; 
        head = end =p; 
        System.out.println("Do you want more nodes?(1/0) ");
        int ch = input.nextInt();
        while(ch!=0){
            Node q = new Node();
            System.out.println("Input node info: ");
            q.info = input.nextInt();
            q.next = q.prev = null; 
            p.next = q; 
			q.prev = p;
            p=q;
			end = p;
            System.out.println("Do you want more nodes?(1/0) ");
             ch = input.nextInt();
        }
               
    }
	//display
    public void display(){
        Node node = head;
        while(node!=null){
            System.out.print(node.info+ " ");
            node = node.next;
        }
        System.out.println();
    }

    //count
      public static int count(){
        int c = 0;
        Node p = head;
        while(p!=null){
            c++;
            p=p.next;
        }
        return c;
    }

    //Search
    public void search(){
        int pos = 0;
        Node n= head;
        System.out.print("Enter the info to be searched:"); 
        int ele=input.nextInt();
        while(n!=null) {
            pos++;
            if(n.info==ele) 
               System.out.println(pos);
            n=n.next;
        }
        System.out.println("Not found");
    }       

        //Insertion at Start
		public void InsBeg() {
			Node p = new Node();
				System.out.println("Input node info: ");
				p.info = input.nextInt();
				p.next = p.prev = null; 
			if(head==null) {
				head=end=p;
			}
			else {
				p.next=head; 
				head.prev = p;
				p.prev = null;
				head = p;
			}
		}
		//Insertion at End
		public void InsEnd(){
			Node p = new Node();
			System.out.println("Input node info: ");
			p.info = input.nextInt();
			p.next = p.prev = null;  
			if(head==null) {
				head=end=p;
			}
			else {
				end.next = p;
				p.prev=end;
				p.next=null; 
				end = p;
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
				p.next = p.prev = null; 
	
				Node q = head;
				int cnt = 1;
				while(cnt < loc-1) {
					cnt++;
					q=q.next;
				}
				p.next = q.next;
				q.next.prev = p;
				q.next = p;
				p.prev = q;
			}
		}    
		}
		//Deletion at Start
		public void DelBeg(){
			if(head == null){
				System.out.println("Empty linked list");
				System.out.println();
			}
			if(head.next == null)
			    head = end =null;
			else{
				Node p= new Node();
				head =head.next;
				head.prev=null;
				p.next = null;
			}	
		}
		//Deletion at End
		public void DelEnd() { 
			if(head==null) {
				System.out.println("Please Create a Linked List First"); 
				System.out.println(head);
			}
			else if(head.next==null) {
				head=end=null;
			}
			else{
				Node p= new Node();
				end =end.prev;
				end.next = null;
				p.prev = null; 
				
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
				Node p = head;
				int cnt = 1;
				while(cnt < loc) {
					cnt++;
					p=p.next;
				}
				p.prev.next = p.next;
				p.next.prev = p.prev;
				p.next = p.prev = null;
			}
		}    
		}

		public void reverse() {
			if(count() >= 2){
				Node p = null;
				Node q = head;
				Node r = head.next;
				q.next = null;
				while(r!=null){
					p=q;
					q=r;
					r=r.next;
					q.next=p;
				}
				head = q;
				}
			}
	
		//sort
		public void sort() {
			if(head==null) {
				System.out.println("Linked List is Empty"); 	
			}
			else {
				Node i,j;
				for(i=head;i.next!=null;i=i.next){
					for(j=head;j.next!=null;j=j.next) {
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