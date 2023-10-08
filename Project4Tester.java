import org.junit.*;
import static org.junit.Assert.*;

/**
 * Test classes GuillotineLinkedList, GuillotineBoard,
 * GuillotinePerson, and GuillotinePlayer
 */
public class Project4Tester {
  /**
   * Test the contains method
   */
  @Test
  public void testContains() {
    GuillotineLinkedList<Integer> list = new GuillotineLinkedList<Integer>();
    list.addToFront(4);
    list.addToFront(3);
    list.addToFront(2);
    list.addToFront(1);
    assertEquals("1 2 3 4 ", GuillotineLinkedList.printList2(list));
    assertEquals(true, list.contains(1));
    assertEquals(false, list.contains(5));    
  }
  
  /**
   * Test the removeFromFront method
   */
  @Test
  public void testRemoveFromFront() {
    GuillotineLinkedList<Integer> list = new GuillotineLinkedList<Integer>();
    list.addToFront(4);
    list.addToFront(3);
    list.addToFront(2);
    list.addToFront(1);
    assertEquals("1 2 3 4 ", GuillotineLinkedList.printList2(list));
    list.removeFromFront();
    assertEquals( "2 3 4 ", GuillotineLinkedList.printList2(list));
    list.removeFromFront();
    assertEquals("3 4 ", GuillotineLinkedList.printList2(list));
    list.removeFromFront();
    assertEquals("4 ", GuillotineLinkedList.printList2(list));
    list.removeFromFront();
    assertEquals("", GuillotineLinkedList.printList2(list));
  }
  
  /**
   * Test the moveBack method
   */
  @Test
  public void testMoveBack() {
    GuillotineLinkedList<Integer> list = new GuillotineLinkedList<Integer>();
    list.addToFront(4);
    list.addToFront(3);
    list.addToFront(2);
    list.addToFront(1);
    assertEquals("1 2 3 4 ", GuillotineLinkedList.printList2(list));
    list.moveBack(1);
    assertEquals( "2 1 3 4 ", GuillotineLinkedList.printList2(list));
    list.moveBack(2);
    assertEquals("1 3 2 4 ", GuillotineLinkedList.printList2(list));
    list.moveBack(3);
    assertEquals("3 2 4 1 ", GuillotineLinkedList.printList2(list));
  }
  
  /**
   * Test the moveFront to back and back to front methods
   */
  @Test
  public void testMoveFrontAndBack() {
    GuillotineLinkedList<Integer> list = new GuillotineLinkedList<Integer>();
    list.addToFront(4);
    list.addToFront(3);
    list.addToFront(2);
    list.addToFront(1);
    assertEquals("1 2 3 4 ", GuillotineLinkedList.printList2(list));
    list.moveFirstToLast();
    assertEquals( "2 3 4 1 ", GuillotineLinkedList.printList2(list));
    list.moveLastToFirst();
    assertEquals("1 2 3 4 ", GuillotineLinkedList.printList2(list));
  }
  
  /**
   * Test the reverse List method
   */
  @Test
  public void testReverse() {
    GuillotineLinkedList<Integer> list = new GuillotineLinkedList<Integer>();
    list.addToFront(4);
    list.addToFront(3);
    list.addToFront(2);
    list.addToFront(1);
    assertEquals("1 2 3 4 ", GuillotineLinkedList.printList2(list));
    list.reverseList();
    assertEquals( "4 3 2 1 ", GuillotineLinkedList.printList2(list));
    list.reverseList();
    assertEquals("1 2 3 4 ", GuillotineLinkedList.printList2(list));
  }
  
  /**
   * Test the player class
   */
  @Test
  public void testPlayer() {
    GuillotinePlayer test = new GuillotinePlayer("testPlayer");
    assertEquals(0, test.getScore());
    GuillotinePerson KingLouisXIV = new GuillotinePerson("King Louis XIV", "Royal", 5);
    test.behead(KingLouisXIV);
    assertEquals(5, test.getScore());
    assertEquals(false, test.isTurn());
    GuillotinePerson PalaceGuard5 = new GuillotinePerson("Palace Guard", "Military", 0);//equal to the number of Palace Guards the player collects
    GuillotinePerson PalaceGuard4 = new GuillotinePerson("Palace Guard", "Military", 0);//equal to the number of Palace Guards the player collects
    test.behead(PalaceGuard5);
    assertEquals(6, test.getScore());
    test.behead(PalaceGuard4);
    assertEquals(9, test.getScore());
    GuillotinePerson TragicFigure = new GuillotinePerson("Tragic Figure", "Commoner", 0);//worth -1 point for each Commoner the player collects
    GuillotinePerson Student4 = new GuillotinePerson("Student", "Commoner", -1); 
    GuillotinePerson Student3 = new GuillotinePerson("Student", "Commoner", -1); 
    test.behead(Student4);
    assertEquals(8, test.getScore());
    test.behead(TragicFigure);
    assertEquals(6, test.getScore());
    test.behead(Student3);
    assertEquals(4, test.getScore());
  }
  
}