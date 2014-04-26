


public class MyHand implements StackInterface  
{
    
    
    //set all fields:
    private Node top; 
    private int count;
   
      /**
         Default constructor sets fields to null
      */
   	public MyHand() 
      {
   	     top = null;
           setCount(0);
   	}
  
    /** 
      isEmpty checks if stack is empty
      @return true or false
    */
    public boolean isEmpty() 
    {
      	return top == null;
    }

    /**
      setCardCount sets card count for player hand
      @param c 
    */
    public void setCount(int c) 
    {
        count = c;
    }

    /**
      getCardCount returns count
      @return count
    */
    public int getCount() 
    {
        return count;
    }
  
    /** 
      Removes all the items from the stack.
    */
    public void popAll() 
    {
  	    top = null;
       setCount(0);
    }

    /** 
      push method adds an item to a stack
      @param newItem object being added to stack...
    */
    public void push(Object newItem) throws StackException 
    {
      	top = new Node(newItem,top);
         setCount(getCount() + 1);
    }
  
    /** 
      pop removes top of a stack and returns it..
      @return item most recently added 
    */
    public Object pop() throws StackException 
    {
	    if (!isEmpty()) //as long as hand isnt empty..
       {
    		Node temp = top;  //get the top of stack  
	    	top = top.getNext(); //get the next in line

            setCount(getCount() - 1);//get rid of top node

		    return temp.getItem(); //retrun it..
	    } 
       
       
       else 
       {
		    throw new StackException("stack empty!!");
       }
    }
  
    /** 
      etrieves the top of a stack
      @return the item that was added most recently
    */
    public Object peek() throws StackException
  {
	if (!isEmpty())
	{
		return top.getItem();
	}
	else
		throw new StackException("peek on empty stack");
  }
} 