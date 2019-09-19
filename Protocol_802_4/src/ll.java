import java.util.Scanner;

/*  Class Node  */
class Node
{
    protected int data;
    protected Node link;
    protected int token;
    protected String stationName;
    /*  Constructor  */
    public Node()
    {
        link = null;
        token = 0;
        data = 0;
        stationName = null;
    }
    /*  Constructor  */
    public Node(int d,Node n,String stname,int token_sta)
    {
        data = d;
        link = n;
        token = token_sta;
        stationName = stname;
    }
    /*  Function to set link to next Node  */
    public void setLink(Node n)
    {
        link = n;
    }
    /*  Function to set data to current Node  */
    public void setData(int d)
    {
        data = d;
    }
    public void setStationName(String stname)
    {
        stationName = stname;
    }

    public String getStationName()
    {
        return stationName;
    }

    public void setToken(int to)
    {
        token = to;
    }

    public int getToken()
    {
        return token;
    }

    /*  Function to get link to next node  */
    public Node getLink()
    {
        return link;
    }
    /*  Function to get data from current Node  */
    public int getData()
    {
        return data;
    }
}

/* Class linkedList */
class linkedList
{
    protected Node start ;
    protected Node end ;
    public int size ;

    /* Constructor */
    public linkedList()
    {
        start = null;
        end = null;
        size = 0;
    }
    /* Function to check if list is empty */
    public boolean isEmpty()
    {
        return start == null;
    }
    /* Function to get size of the list */
    public int getSize()
    {
        return size;
    }


    /* Function to insert element at end */
    public void insertAtEnd(int val,String stname,int token)
    {
        Node nptr = new Node(val,null,stname,token);
        nptr.setLink(start);
        if(start == null)
        {
            start = nptr;
            nptr.setLink(start);
            end = start;
        }
        else
        {
            end.setLink(nptr);
            end = nptr;
        }
        size++ ;
    }

    /* Function to display contents */
    public void display()
    {
        System.out.print("\n Station Map == ");
        Node ptr = start;
        if (size == 0)
        {
            System.out.print("empty\n");
            return;
        }
        if (start.getLink() == start)
        {
            System.out.print("Addr : "+start.getData()+ "  St.Name : "+start.getStationName()+"  T.st : "+start.getToken()+" --> "+"Addr : "+ptr.getData()+" St.Name : "+ptr.getStationName()+"  T.st : "+ptr.getToken()+" \n");
            return;
        }
        System.out.print("Addr : "+start.getData()+ "  St.Name : "+start.getStationName()+"  T.st : "+start.getToken()+" --> ");
        ptr = start.getLink();
        while (ptr.getLink() != start)
        {
            System.out.print("Addr : "+ptr.getData()+" St.Name : "+ptr.getStationName()+"  T.st : "+ptr.getToken()+" --> ");
            ptr = ptr.getLink();
        }
        System.out.print("Addr : "+ptr.getData()+" St.Name : "+ptr.getStationName()+"  T.st : "+ptr.getToken()+" --> ");
        ptr = ptr.getLink();
        System.out.print("Addr : "+ptr.getData()+" St.Name : "+ptr.getStationName()+"  T.st : "+ptr.getToken()+ "\n");
    }

    public void transport(frameformat ff)
    {
        Node ptr = start;
        if (size == 0)
        {
            System.out.print("This operation cannot be performed on null map \n");
            return;
        }

        if (start.getLink() == start)
        {
            System.out.println("Cannot send and recieve from the same station");
            return;
        }

        //System.out.print("Addr : "+start.getData()+ "  St.Name : "+start.getStationName()+"  T.st : "+start.getToken()+" --> ");
        ptr = start.getLink();
        while (ptr.getLink() != start)
        {
            //System.out.print("Addr : "+ptr.getData()+" St.Name : "+ptr.getStationName()+"  T.st : "+ptr.getToken()+" --> ");
            if(ff.get_dest_add()==ptr.getData())
            {
                System.out.println("Recieving............");
                System.out.println("Data Succesfully unloaded at station "+ptr.getStationName());
                System.out.println("Address  : "+ptr.getData());
                System.out.println("Data : "+ff.get_data());
                System.out.println("Checksum from the frame : "+ff.get_checksum());
                ChecksumMethod checksumMethod = new ChecksumMethod();
                System.out.println("Checksum regenerated at station "+ptr.getStationName()+" is "+checksumMethod.generateChecksum(ff.get_data()));
                if (checksumMethod.generateChecksum(ff.get_data()) != ff.get_checksum())
                {
                    System.out.println("Errors in data received......");
                }
                return;
            }
            ptr = ptr.getLink();
        }
        //System.out.print("Addr : "+ptr.getData()+" St.Name : "+ptr.getStationName()+"  T.st : "+ptr.getToken()+" --> ");
        ptr = ptr.getLink();
        //System.out.print("Addr : "+ptr.getData()+" St.Name : "+ptr.getStationName()+"  T.st : "+ptr.getToken()+ "\n");
    }
}

/* Class CircularSinglyLinkedList */
public class ll
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        /* Creating object of linkedList */
        linkedList list = new linkedList();
        System.out.println("802.4 Protocol\n");
        char ch;
        /*  Perform list operations  */
        Scanner sc = new Scanner(System.in);
        do
        {
            System.out.println("1. insert at end");

            int choice = scan.nextInt();
            switch (choice)
            {
                case 1 :
                    System.out.println("Enter address of node : ");
                    int address = scan.nextInt();
                    System.out.println("Enter the station Name : ");
                    String stationName = sc.nextLine();
                    System.out.println("Enter the token status : ");
                    int tokenStatus = scan.nextInt();
                    if (tokenStatus == 1)
                    {
                        System.out.println("Sending............");
                        frameformat ff = new frameformat();
                        ff.sour_add = address;
                        System.out.println("Enter the Destination Address : ");
                        int des = scan.nextInt();
                        ff.dest_add = des;
                        System.out.println("Enter the Data to be Sent : ");
                        String dt = sc.nextLine();
                        ff.data = dt;
                        ChecksumMethod checksumMethod = new ChecksumMethod();
                        ff.checksum = checksumMethod.generateChecksum(dt);
                        System.out.println("Checksum generated is : "+ff.get_checksum());
                        System.out.println("Data Succesfully Loaded from station "+stationName);
                        list.insertAtEnd(address, stationName, tokenStatus);
                        list.transport(ff);
                    }
                    else {
                        list.insertAtEnd(address, stationName, tokenStatus);
                    }
                    break;
                case 5 :
                    System.out.println("Empty status = "+ list.isEmpty());
                    break;
                case 6 :
                    System.out.println("Size = "+ list.getSize() +" \n");
                    break;
                default :
                    System.out.println("Wrong Entry \n ");
                    break;
            }
            /*  Display List  */
            list.display();
            System.out.println("\nDo you want to continue (Type y or n) \n");
            ch = scan.next().charAt(0);
        } while (ch == 'Y'|| ch == 'y');
    }
}