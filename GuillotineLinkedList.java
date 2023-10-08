import java.util.NoSuchElementException;
/**
* The guillotineLinkedList class stores a linkedList of all the persons
*
* @author  Adam Kerkemeyer
* @author Dr. Connamacher
* @version 1.0
* @since   2022-04-12
*/
public class GuillotineLinkedList<T> implements Iterable<T> {
  /** the first node of the list, or null if the list is empty */
  private LLNode<T> firstNode;
  
  /**
   * Creates an initially empty linked list
   */
  public GuillotineLinkedList() {
    firstNode = null;
  }
  
  /**
   * Returns the first node.
   */
  protected LLNode<T> getFirstNode() {
    return firstNode;
  }
  /**
   * Changes the front node.
   * @param node  the node that will be the first node of the new linked list
   */
  protected void setFirstNode(LLNode<T> node) {
    this.firstNode = node;
  }
  /**
   * Return whether the list is empty
   * @return true if the list is empty
   */
  public boolean isEmpty() {
    return (getFirstNode() == null);
  }
  
  /**
   * Add an element to the front of the linked list
   */
  public void addToFront(T element) {
    setFirstNode(new LLNode<T>(element, getFirstNode()));
  }
  
  /**
   * Removes and returns the element at the front of the linked list
   * @return the element removed from the front of the linked list
   * @throws NoSuchElementException if the list is empty
   */
  public T removeFromFront() {
    if (isEmpty())
      throw new NoSuchElementException();
    else {
      T save = getFirstNode().getElement();
      setFirstNode(getFirstNode().getNext());
      return save;
    }
  }
    /**
   * Removes and returns the element at the end of the linked list
   * @return the element removed from the end of the linked list
   * @throws NoSuchElementException if the list is empty
   */
  public T removeFromEnd() {
    if (isEmpty())
      throw new NoSuchElementException();
    else{
      LLNode<T> save = getLastNode();
      LLNode<T> nodeptr = getFirstNode();
      while (nodeptr.getNext() != save) 
        nodeptr = nodeptr.getNext();
      LLNode<T> nulls;
      nodeptr.setNext(null); //second to last is now the last
      return save.getElement();
    }
  }
  
  /**
   * Returns the length of the linked list
   * @return the number of nodes in the list
   */
  public int length() {
    int count = 0;
    LLNode<T> nodeptr = getFirstNode();
    while (nodeptr != null) {
      count++;
      nodeptr = nodeptr.getNext();
    }
    return count;
  }
  
  /**
   * Adds an element to the end of the linkd list
   * @param element the element to insert at the end
   */
  public void addToEnd(T element) {
    if (isEmpty())
      addToFront(element);
    else {
      LLNode<T> nodeptr = getFirstNode();
      while (nodeptr.getNext() != null) 
        nodeptr = nodeptr.getNext();
      nodeptr.setNext(new LLNode<T>(element, null));
    }
  }
  
  /**
   * Returns the element at the end of the linkd list
   * @return T the element at the end
   */
  public LLNode<T> getLastNode() {
    LLNode<T> nodeptr = getFirstNode();
      while (nodeptr.getNext() != null) 
        nodeptr = nodeptr.getNext();
      return nodeptr;
  }
  
  /**
   * Return an iterator for this list
   * @return the iterator for the list
   */
  @Override
  public LinkedListIterator<T> iterator() {
    return new LinkedListIterator<T>(getFirstNode());
  }
  
  /* Static methods and generics: 
   *   Generic types only go with instance methods and fields
   *   If I want a generic here, I must declare it in the method header,
   *   before the return type 
   */
  
  /**
   * Prints the contents of a list to System.out.
   * @param list the list to print
   */
  public static <S> void printList(GuillotineLinkedList<S> list) {
    for (S element : list) {
      System.out.print(element);
      System.out.print(" ");
    }
    System.out.println();
  }
  
  /* Generic types and wildcards:
   *    If we don't care what the generic type is because we don't use that type 
   *     (other than calling Object methods on it)
   *    we can use a wildcard that means we don't care what the generic type is 
   */
  
  /**
   * Prints the contents of a linked list to System.out.
   * @param list the linked list to print
   */
  public static String printList2(GuillotineLinkedList<?> list) {
    StringBuilder builder = new StringBuilder();
    for (Object element : list) {
      builder.append(element.toString());
      builder.append(" ");
    }
    return builder.toString();
  }
    
  /**
   * Determines whether an element is stored in the list
   * @param element  the element to search for in the list
   * @return true if and only if the parameter element is in the list
   */
  public boolean contains(T element) {
    if (getFirstNode().getNext() != null) {
      if (getFirstNode().getElement().equals(element)) {
        return true;
      }
      else {
      getFirstNode().contains(element);
      }
      
    }
    return false;
  }
    
  /**
   * Take a linked list that is already sorted in order and add a new element
   * into the correct location
   * @param list the linked list
   * @param element the element to add
   */
  public static <S extends Comparable<? super S>> void insertInOrder(LinkedList<S> 
list, S element) {
    if (list.isEmpty()) {
      list.addToFront(element);
    }
    else {
      // case 1: the element goes to front of list
      if (element.compareTo(list.getFirstNode().getElement()) < 0)
        list.addToFront(element);
      // case 2: the element goes elsewhere, create a nodeptr to find where it goes
      else {
        LLNode<S> nodeptr = list.getFirstNode();
        while (nodeptr.getNext() != null && 
               nodeptr.getNext().getElement().compareTo(element) < 0)
          nodeptr = nodeptr.getNext();
        // when the loop ends the element goes after nodeptr
        nodeptr.setNext(new LLNode<>(element, nodeptr.getNext()));
      }
    }
  }
  
  /**
   * Moves the first node to the last node of the list so that the
   * second node in the list in the new first node.
   */
  public void moveFirstToLast(){
    if (this.isEmpty()) {
    }
    else{
      this.addToEnd(this.getFirstNode().getElement());
      this.removeFromFront();
    }
  }
  
  /**
   * Moves the last node to the first node of the list so that the
   * second to last node in the list in the new last node.
   */
  public void moveLastToFirst(){
    if (this.isEmpty()) {
    }
    else{
      this.addToFront(this.getLastNode().getElement());
      this.removeFromEnd();
    }
  }
  
  /**
   * Reverses the list so that the linked list goes in reverse order
   */
  public  void reverseList(){
    LLNode<T> current = getFirstNode();
    LLNode<T> previous = null;
    LLNode<T> next = getFirstNode();
    //LLNode<T> current = getFirstNode();
    while(current != null){
      next = current.getNext();
      current.setNext(previous);
      previous = current;
      current = next;
    }
    this.setFirstNode(previous);
  } 

  
  /**
   * Moves the first node of the list back n places, leaving the rest of
   * the nodes unchanged.If the input parameter is longer than the list
   * then the first node will not be moved.
   * @param spaces number of spaces the first node will be moved back
   */
  public void moveBack(int spaces){
    //This method assumes that an input of 1 puts the first node
    //in the location of the second node so the most that one node
    //can be moved back is length - 1.
    if(spaces < this.length()){
      LLNode<T> nodeptr = getFirstNode();
      for(int i = 0; i < spaces; i++){
        nodeptr = nodeptr.getNext();
      }
      nodeptr.setNext(new LLNode<T>(this.getFirstNode().getElement(), nodeptr.getNext()));
      this.removeFromFront();
    }
    //else if(spaces == this.length()){
    //  this.moveFirstToLast();
    //}
  } 
}