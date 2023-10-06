import javax.swing.text.html.parser.Element;

public class DoubleLinkedList<T> implements List{
    private Node<T> head; 
    private Node<T> current;

    public DoubleLinkedList()
    {
        head=current=null;
    }

    public boolean empty()
    {
        return head==null;
    }

    public boolean last()
    {
        return current.next==null;
    }

    public boolean first ()
    {
        return current.previous==null;
    }

    public boolean full()
    {
        return false;
    }
    public void findFirst ()
    {
        current=head;
    }
    public void findNext ()
    {
        current=current.next;
    }
    public void findPrevious()
    {
        current=current.previous;
    }

    public T retrieve()
    {
        return current.data;
    }
    public void update(T val)
    {
        current.data=val;
    }
    //adding contact need to reWrite
    // Each contact in the phonebook should be unique. You can ensure this by checking if a contact with
// the same name or phone number already exists in the list before adding a new contact.
    public void insert(T element){
        if(element instanceof Contact)
            if(!addContact(element)){
                System.out.println("contact already exixsts");
                return;
            }
        if(element instanceof Event)
            if(!addEvent(element)){
                System.out.println("there is conflict with a current schedueld event");                
                return;
            }
            }
    //searching contact
// When you search for a contact by email address, address, or birthday, you should return all contacts
// that have these values

// the search for an event is based on the event title or contact name
    public void search(T val){

    }

    //Layan tst
    //deleting contact need to reWrite
    public void remove(){
        if(current == head)
        {
            head=head.next;
            if(head !=null)
                head.previous=null;
        }
        else
        {
            current.previous.next=current.next;
            if(current.next!=null)
                current.next.previous=current.previous;
        }

        if(current.next==null)
            current=head;
        else
            current=current.next;
    }
    

    public boolean addContact(T element)
    {
        int compareResult;
        // Contact contact = (Contact) element;
            // contact.getContactName();
        while(current!=null)
        {
            // return this.contactName.compareTo(other.getContactName());
  
            compareResult= ((Contact)(current.data)).compareTo(element);
            // integer depending on whether the current contact's name is less than, equal to, or greater than the contact name of the object being compared.
            Node<T> tmp=new Node<T> (element);

            if(compareResult==0)//i did it in the Contact class
                return false;
            else if(compareResult<0)
            {
                //add befor the current
                //need to be check other situations
                tmp.next=current;
                tmp.previous=current.previous;
                if(current.previous!=null)
                current.previous.next=tmp;
                current.previous=tmp;
                current=tmp;
            }
            else if(compareResult>0)
            {
                //add after the current
                //need to be check other situations && if =0 , add it after ot befor
                tmp.next=current.next;
                tmp.previous=current;
                if(current.next!=null)
                    current.next.previous=tmp;
                current.next=tmp;
                current=tmp;
            }


            current=current.next;
        }
        return true;
    } 
    public boolean addEvent(Event event)
    {
        //check schedule
        if(!true)
        // event.d<Contact>.getDate();
        else
        {
            Node<T> tmp=new Node<T> (event);
                if(empty()){
                    head=current=tmp;
                }
                else{
                    tmp.next=current.next;
                    tmp.previous=current;
                    if(current.next != null)
                        current.next.previous=tmp;
                    current.next=tmp;
                    current=tmp;
                }   
        }
    }   
}
