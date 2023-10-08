import javafx.scene.control.Button;
/**
* The person class stores the name, group, and points value of 
* a person in the Guillotine game
*
* @author  Adam Kerkemeyer
* @version 1.0
* @since   2022-04-12
*/
public class GuillotinePerson{
  /** String containing the name */
  private String name;
  
  /** String containing the group */
  private String group;
  
  /** Int containing points value */
  private int value;
  
  /**
   * Constructor for the GuillotinePerson class
   * @param name String containing the name
   * @param group String containing the group
   * @param value Int containing points value
   */
  public GuillotinePerson(String name, String group, int value){
    this.name = name;
    this.group = group;
    this.value = value;
  }
  
  /**
   * Returns the name of the person
   * @return String returns the name of the person
   */
  public String getName(){
    return name;
  }
  
  /**
   * Returns the group of the person
   * @return String group of the person
   */
  public String getGroup(){
    return group;
  }
  
  /**
   * Returns the Points of the person
   * @return String group of the person
   */
  public int getPoints(){
    return value;
  }
  
  /**
   * Sets the Points of the person
   * @param newPointValue of the person
   */
  public void setPoints(int value){
    this.value = value;
  }
  
  /**
   * This method overrides the .toString() method
   * @return String This returns the string of person
   */
  public String toString(){
    if(getName().equals("Heretic") || getName().equals("Tax Collector") ||
       getName().equals("Palace Guard") || getName().equals("Tragic Figure")){
      return getName() + ", " + getGroup() + ": *";
    }
    return getName() + ", " + getGroup() + ": " + getPoints();
  }
  
   /**
   * This method overrides the .equals() method
   * @return boolean This returns T if two groups are equal
   */  
  public boolean equals(Object o){
    if(o instanceof GuillotinePerson){
      GuillotinePerson p = (GuillotinePerson)o;
    if(this.getGroup().equals(p.getGroup()) && this.getName().equals(p.getName()))
      return true;
    else
      return false;
    }
    else
      return false;
  }
  
  private static GuillotinePerson KingLouisXIV = new GuillotinePerson("King Louis XIV", "Royal", 5);
  private static GuillotinePerson MarieAntoinette = new GuillotinePerson("Marie Antoinette", "Royal", 5);
  private static GuillotinePerson Regent = new GuillotinePerson("Regent", "Royal", 4);
  private static GuillotinePerson Duke = new GuillotinePerson("Duke", "Royal", 3);
  private static GuillotinePerson Baron = new GuillotinePerson("Baron", "Royal", 3);
  private static GuillotinePerson Count = new GuillotinePerson("Count", "Royal", 2);// (4 if the player also collects the Countess)
  private static GuillotinePerson Countess = new GuillotinePerson("Countess", "Royal", 2); // (4 if the player also collects the Count)
  private static GuillotinePerson Lord = new GuillotinePerson("Lord", "Royal", 2);// (4 if the player also collects the Lady)
  private static GuillotinePerson Lady = new GuillotinePerson("Lady", "Royal", 2);// (4 if the player also collects the Lord)
  private static GuillotinePerson Cardinal = new GuillotinePerson("Cardinal", "Church", 5);
  private static GuillotinePerson Archbishop = new GuillotinePerson("Archbishop", "Church", 4);
  private static GuillotinePerson Nun = new GuillotinePerson("Nun", "Church", 3);
  private static GuillotinePerson Bishop = new GuillotinePerson("Bishop", "Church", 2);
  private static GuillotinePerson Priest1 = new GuillotinePerson("Priest", "Church", 1);
  private static GuillotinePerson Priest2 = new GuillotinePerson("Priest", "Church", 1);
  private static GuillotinePerson Heretic = new GuillotinePerson("Heretic", "Church", 0);//equal to the number of Church members the player collects
  private static GuillotinePerson Governor = new GuillotinePerson("Governor", "Civic", 4);
  private static GuillotinePerson Mayor = new GuillotinePerson("Mayor", "Civic", 3);
  private static GuillotinePerson Councilman = new GuillotinePerson("Councilman", "Civic", 3);
  private static GuillotinePerson Judge1 = new GuillotinePerson("Judge", "Civic", 2);
  private static GuillotinePerson Judge2 = new GuillotinePerson("Judge", "Civic", 2);
  private static GuillotinePerson TaxCollector = new GuillotinePerson("Tax Collector", "Civic", 0);//equal to the number of Civic persons the player collects
  private static GuillotinePerson Sheriff1 = new GuillotinePerson("Sheriff", "Civic", 1);
  private static GuillotinePerson Sheriff2 = new GuillotinePerson("Sheriff", "Civic", 1);
  private static GuillotinePerson PalaceGuard1 = new GuillotinePerson("Palace Guard", "Military", 0);//equal to the number of Palace Guards the player collects
  private static GuillotinePerson PalaceGuard2 = new GuillotinePerson("Palace Guard", "Military", 0);//equal to the number of Palace Guards the player collects
  private static GuillotinePerson PalaceGuard3 = new GuillotinePerson("Palace Guard", "Military", 0);//equal to the number of Palace Guards the player collects
  private static GuillotinePerson PalaceGuard4 = new GuillotinePerson("Palace Guard", "Military", 0);//equal to the number of Palace Guards the player collects
  private static GuillotinePerson PalaceGuard5 = new GuillotinePerson("Palace Guard", "Military", 0);//equal to the number of Palace Guards the player collects
  private static GuillotinePerson General = new GuillotinePerson("General", "Military", 4);
  private static GuillotinePerson Colonel = new GuillotinePerson("Colonel", "Military", 3);
  private static GuillotinePerson Captain = new GuillotinePerson("Captain", "Military", 2);
  private static GuillotinePerson Lieutenant1 = new GuillotinePerson("Lieutenant", "Military", 1);
  private static GuillotinePerson Lieutenant2 = new GuillotinePerson("Lieutenant", "Military", 1);
  private static GuillotinePerson TragicFigure = new GuillotinePerson("Tragic Figure", "Commoner", 0);//worth -1 point for each Commoner the player collects
  private static GuillotinePerson HeroicFigure = new GuillotinePerson("Heroic Figure", "Commoner", -3);
  private static GuillotinePerson Student1 = new GuillotinePerson("Student", "Commoner", -1);
  private static GuillotinePerson Student2 = new GuillotinePerson("Student", "Commoner", -1);
  private static GuillotinePerson Student3 = new GuillotinePerson("Student", "Commoner", -1);
  private static GuillotinePerson Student4 = new GuillotinePerson("Student", "Commoner", -1); 
  private static GuillotinePerson[] fullList = {KingLouisXIV, MarieAntoinette, Regent, Duke, Baron, Count,  Countess, 
      Lord, Lady, Cardinal, Archbishop, Nun, Bishop, Priest1, Priest2, Heretic, Governor, Mayor, Councilman, 
      Judge1, Judge2, TaxCollector, Sheriff1, Sheriff2, PalaceGuard1, PalaceGuard2, PalaceGuard3, 
      PalaceGuard4, PalaceGuard5, General, Colonel, Captain, Lieutenant1, Lieutenant2, TragicFigure, 
      HeroicFigure, Student1, Student2, Student3, Student4};
   /**
   * Creates an array of people
   * @param size of the list of people
   */
  public static GuillotineLinkedList<GuillotinePerson> makeArray(int size){
    
    GuillotineLinkedList<GuillotinePerson> gameList = new GuillotineLinkedList<GuillotinePerson>();
    
    if(size < fullList.length){
      for(int i = 0; i <size+1; i++){
        int b = (int)(Math.random()*(fullList.length-1));
        if(fullList[b] == null){
          i--;
        }
        else{
          gameList.addToFront(fullList[b]);
          fullList[b] = null;
        } 
      }
    }
    else{
      size = 40; //cannot have more than 40 cards
      for(int i = 0; i <fullList.length; i++){
        int b = (int)(Math.random()*(fullList.length-1));
        if(fullList[b].equals(null)){
          i--;
        }
        else{
          gameList.addToFront(fullList[b]);
          fullList[b] = null;
        } 
      }
    }
    return gameList;
  }
  
  public static GuillotineLinkedList<Button> makeButtonArray(GuillotineLinkedList<GuillotinePerson> persons){
    GuillotineLinkedList<Button> personsButtons = new GuillotineLinkedList<Button>();
    Button person1 = new Button(persons.getFirstNode().getElement().toString());
    Button person2 = new Button(persons.getFirstNode().getNext().getElement().toString());
    Button person3 = new Button(persons.getFirstNode().getNext().getNext().getElement().toString());
    Button person4 = new Button(persons.getFirstNode().getNext().getNext().getNext().getElement().toString());
    Button person5 = new Button(persons.getFirstNode().getNext().getNext().getNext().getNext().getElement().toString());
    Button person6 = new Button(persons.getFirstNode().getNext().getNext().getNext().getNext().getNext().getElement().toString());
    Button person7 = new Button(persons.getFirstNode().getNext().getNext().getNext().getNext().getNext().getNext().getElement().toString());
    Button person8 = new Button(persons.getFirstNode().getNext().getNext().getNext().getNext().getNext().getNext().getNext().getElement().toString());
    Button person9 = new Button(persons.getFirstNode().getNext().getNext().getNext().getNext().getNext().getNext().getNext().getNext().getElement().toString());
    Button person10 = new Button(persons.getFirstNode().getNext().getNext().getNext().getNext().getNext().getNext().getNext().getNext().getNext().getElement().toString());
    Button person11 = new Button(persons.getFirstNode().getNext().getNext().getNext().getNext().getNext().getNext().getNext().getNext().getNext().getNext().getElement().toString());
    Button person12 = new Button(persons.getFirstNode().getNext().getNext().getNext().getNext().getNext().getNext().getNext().getNext().getNext().getNext().getNext().getElement().toString());
    Button person13 = new Button(persons.getFirstNode().getNext().getNext().getNext().getNext().getNext().getNext().getNext().getNext().getNext().getNext().getNext().getNext().getElement().toString());
    Button person14 = new Button(persons.getFirstNode().getNext().getNext().getNext().getNext().getNext().getNext().getNext().getNext().getNext().getNext().getNext().getNext().getNext().getElement().toString());
    Button person15 = new Button(persons.getFirstNode().getNext().getNext().getNext().getNext().getNext().getNext().getNext().getNext().getNext().getNext().getNext().getNext().getNext().getNext().getElement().toString());
    Button person16 = new Button(persons.getFirstNode().getNext().getNext().getNext().getNext().getNext().getNext().getNext().getNext().getNext().getNext().getNext().getNext().getNext().getNext().getNext().getElement().toString());
    Button person17 = new Button(persons.getFirstNode().getNext().getNext().getNext().getNext().getNext().getNext().getNext().getNext().getNext().getNext().getNext().getNext().getNext().getNext().getNext().getNext().getElement().toString());
    Button person18 = new Button(persons.getFirstNode().getNext().getNext().getNext().getNext().getNext().getNext().getNext().getNext().getNext().getNext().getNext().getNext().getNext().getNext().getNext().getNext().getNext().getElement().toString());
    Button person19 = new Button(persons.getFirstNode().getNext().getNext().getNext().getNext().getNext().getNext().getNext().getNext().getNext().getNext().getNext().getNext().getNext().getNext().getNext().getNext().getNext().getNext().getElement().toString());
    Button person20 = new Button(persons.getFirstNode().getNext().getNext().getNext().getNext().getNext().getNext().getNext().getNext().getNext().getNext().getNext().getNext().getNext().getNext().getNext().getNext().getNext().getNext().getNext().getElement().toString());
    
    personsButtons.addToEnd(person1);
    personsButtons.addToEnd(person2);
    personsButtons.addToEnd(person3);
    personsButtons.addToEnd(person4);
    personsButtons.addToEnd(person5);
    personsButtons.addToEnd(person6);
    personsButtons.addToEnd(person7);
    personsButtons.addToEnd(person8);
    personsButtons.addToEnd(person9);
    personsButtons.addToEnd(person10);
    personsButtons.addToEnd(person11);
    personsButtons.addToEnd(person12);
    personsButtons.addToEnd(person13);
    personsButtons.addToEnd(person14);
    personsButtons.addToEnd(person15);
    personsButtons.addToEnd(person16);
    personsButtons.addToEnd(person17);
    personsButtons.addToEnd(person18);
    personsButtons.addToEnd(person19);
    personsButtons.addToEnd(person20);
    
    return personsButtons;
  }
}  