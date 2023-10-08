import javafx.application.Application;
import javafx.scene.control.Button;

/**
* The Player class stores information about the player.
*
* @author  Adam Kerkemeyer
* @version 1.0
* @since   2022-04-12
*/

public class GuillotinePlayer{
  /** String containing the score */
  private int score = 0;
  
  /** boolean containing T if it is this players turn */
  private boolean turn;
  
  /** String containing the name */
  private String name;
  
  /** Array containing all persons the player collects */
  private GuillotineLinkedList<GuillotinePerson> beheaded;
  
  private GuillotinePerson[] behead = new GuillotinePerson[10];
    
  /** Int containing how many people have been beheaded so far by this player */
  private int numberBeheaded = 0;
  
  /**
    * Constructor for the GuillotinePlayer class
    * @param name String containing the name
    */ 
  public GuillotinePlayer(String name){
    this.name = name;
    this.score = 0;
    this.turn = false; //The first turn will be designated in the GuillotineBoard
  }
  
  /**
   * Returns if it is this players turn
   * @return boolean True for is this players turn
   */
  public boolean isTurn(){
    return turn;
  }
  
  /**
   * Sets the turn of the player
   * @param boolean True for is this players turn
   */
  public void isTurn(boolean turn){
    this.turn = turn;
  }
  
  /**
   * Returns the score of the player
   * @return int score of the player
   */
  public int getScore(){
    return score;
  }
  
  /**
   * Returns the beheaded of the player
   * @return <GuillotineLinkedList> score of the player
   */
  public GuillotineLinkedList<GuillotinePerson> getBeheaded(){
    return beheaded;
  }
  
  /**
   * Sets the score of the player
   * @param int set score of the player
   */
  public void setScore(int score){
     this.score = score;
  }
  
  /**
   * Returns the name of the player
   * @return String returns the name of the player
   */
  public String getName(){
    return name;
  }
  
  //A bunch of variables to keep track of what is an is not in the
  //players list without actually having to check the list
  private boolean containsCountOrCountess = false;
  private boolean containsLordOrLady = false;
  private boolean containsHeretic = false;
  private boolean containsTaxCollector = false;
  private boolean containsTragicFigure = false;
  
  private int numPalaceGuards = 0;
  private int numChurch = 0;
  private int numCivic = 0;
  private int numCommoner = 0;
  
  /**
   * adds a beheaded person to the players list
   * @param Person person beheaded
   */
  public void behead(GuillotinePerson p){
    //beheaded.addToFront(p);
    behead[numberBeheaded] = p;
    numberBeheaded++;
    this.setScore(p.getPoints() + this.getScore());
    
    if(p.getGroup().equals("Church")){
      //Heretic.setPoints(Heretic.getPoints() + 1);
      numChurch++;
      if(containsHeretic){
        this.setScore(this.getScore()+1);
      }
      else if(p.getName().equals("Heretic")){
        this.setScore(this.getScore() + numChurch);
        containsHeretic = true;
      }
    }
    else if(p.getGroup().equals("Civic")){
      //TaxCollector.setPoints(TaxCollector.getPoints() + 1);
      numCivic++;
      if(containsTaxCollector){
        this.setScore(this.getScore()+1);
      }
      else if(p.getName().equals("Tax Collector")){
        this.setScore(this.getScore() + numCivic);
        containsTaxCollector = true;
      }
    }
    else if(p.getGroup().equals("Commoner")){
      //TragicFigure.setPoints(TragicFigure.getPoints() - 1);
      numCommoner++;
      if(containsTragicFigure){
        this.setScore(this.getScore() - 1);
      }
      else if(p.getName().equals("Tragic Figure")){
        this.setScore(this.getScore() - numCommoner);
        containsTragicFigure = true;
      }
    }
    else if(p.getName().equals("Palace Guard")){
      //PalaceGuard1.setPoints(PalaceGuard1.getPoints() + 1);
      //PalaceGuard2.setPoints(PalaceGuard2.getPoints() + 1);
      //PalaceGuard3.setPoints(PalaceGuard3.getPoints() + 1);
      //PalaceGuard4.setPoints(PalaceGuard4.getPoints() + 1);
      //PalaceGuard5.setPoints(PalaceGuard5.getPoints() + 1);
      numPalaceGuards++;
      this.setScore(this.getScore()+numPalaceGuards*numPalaceGuards - (numPalaceGuards - 1)*(numPalaceGuards - 1));
    }
    
    else if(p.getName().equals("Count") || p.getName().equals("Countess")){
      if(containsCountOrCountess){
        this.setScore(this.getScore()+4);
      }
      else{
        containsCountOrCountess = true;
      }
        
    }
    if(p.getName().equals("Lord") || p.getName().equals("Lady")){
      if(containsLordOrLady){
        this.setScore(this.getScore()+4);
      }
      else{
        containsLordOrLady = true;
      }
    }
  }  
     
  /**
   * updates the score by counting every person the player has beheaded
   */
  public void calculateScore(){
    int totalScore = 0;
    for (GuillotinePerson p : beheaded) {
      totalScore += p.getPoints();
    }
    setScore(totalScore);
  }
  
}
  /**
   * updates the point values of every person the player has beheaded
   * @param Person person beheaded
   *//*
  public void updatePersons(){
    if(beheaded.contains(Count) && beheaded.contains(Countess)){
      Count.setPoints(4);
      Countess.setPoints(4);
    }
    if(beheaded.contains(Lord) && beheaded.contains(Lady)){
      Lord.setPoints(4);
      Lady.setPoints(4);
    }
    if(beheaded.contains(Cardinal))
      Heretic.setPoints(Heretic.getPoints() + 1);
    if(beheaded.contains(Cardinal))
      Heretic.setPoints(Heretic.getPoints() + 1);
    if(beheaded.contains(Archbishop))
      Heretic.setPoints(Heretic.getPoints() + 1);
    if(beheaded.contains(Nun))
      Heretic.setPoints(Heretic.getPoints() + 1);
    if(beheaded.contains(Bishop))
      Heretic.setPoints(Heretic.getPoints() + 1);
    if(beheaded.contains(Priest1))
      Heretic.setPoints(Heretic.getPoints() + 1);
    if(beheaded.contains(Priest2))
      Heretic.setPoints(Heretic.getPoints() + 1);
    if(beheaded.contains(Governor))
      TaxCollector.setPoints(TaxCollector.getPoints() + 1);
    if(beheaded.contains(Mayor))
      TaxCollector.setPoints(TaxCollector.getPoints() + 1);
    if(beheaded.contains(Councilman))
      TaxCollector.setPoints(TaxCollector.getPoints() + 1);
    if(beheaded.contains(Judge1))
      TaxCollector.setPoints(TaxCollector.getPoints() + 1);
    if(beheaded.contains(Judge2))
      TaxCollector.setPoints(TaxCollector.getPoints() + 1);
    if(beheaded.contains(Sheriff1))
      TaxCollector.setPoints(TaxCollector.getPoints() + 1);
    if(beheaded.contains(Sheriff2))
      TaxCollector.setPoints(TaxCollector.getPoints() + 1);
    if(beheaded.contains(Sheriff2))
      TaxCollector.setPoints(TaxCollector.getPoints() + 1);
    if(beheaded.contains(PalaceGuard1)){
      PalaceGuard1.setPoints(PalaceGuard1.getPoints() + 1);
      PalaceGuard2.setPoints(PalaceGuard2.getPoints() + 1);
      PalaceGuard3.setPoints(PalaceGuard3.getPoints() + 1);
      PalaceGuard4.setPoints(PalaceGuard4.getPoints() + 1);
      PalaceGuard5.setPoints(PalaceGuard5.getPoints() + 1);
    }
    if(beheaded.contains(PalaceGuard2)){
      PalaceGuard1.setPoints(PalaceGuard1.getPoints() + 1);
      PalaceGuard2.setPoints(PalaceGuard2.getPoints() + 1);
      PalaceGuard3.setPoints(PalaceGuard3.getPoints() + 1);
      PalaceGuard4.setPoints(PalaceGuard4.getPoints() + 1);
      PalaceGuard5.setPoints(PalaceGuard5.getPoints() + 1);
    }
    if(beheaded.contains(PalaceGuard3)){
      PalaceGuard1.setPoints(PalaceGuard1.getPoints() + 1);
      PalaceGuard2.setPoints(PalaceGuard2.getPoints() + 1);
      PalaceGuard3.setPoints(PalaceGuard3.getPoints() + 1);
      PalaceGuard4.setPoints(PalaceGuard4.getPoints() + 1);
      PalaceGuard5.setPoints(PalaceGuard5.getPoints() + 1);
    }
    if(beheaded.contains(PalaceGuard4)){
      PalaceGuard1.setPoints(PalaceGuard1.getPoints() + 1);
      PalaceGuard2.setPoints(PalaceGuard2.getPoints() + 1);
      PalaceGuard3.setPoints(PalaceGuard3.getPoints() + 1);
      PalaceGuard4.setPoints(PalaceGuard4.getPoints() + 1);
      PalaceGuard5.setPoints(PalaceGuard5.getPoints() + 1);
    }
    if(beheaded.contains(PalaceGuard5)){
      PalaceGuard1.setPoints(PalaceGuard1.getPoints() + 1);
      PalaceGuard2.setPoints(PalaceGuard2.getPoints() + 1);
      PalaceGuard3.setPoints(PalaceGuard3.getPoints() + 1);
      PalaceGuard4.setPoints(PalaceGuard4.getPoints() + 1);
      PalaceGuard5.setPoints(PalaceGuard5.getPoints() + 1);
    }
    if(beheaded.contains(HeroicFigure))
      TragicFigure.setPoints(TragicFigure.getPoints() - 1);
    if(beheaded.contains(Student1))
      TragicFigure.setPoints(TragicFigure.getPoints() - 1);
    if(beheaded.contains(Student2))
      TragicFigure.setPoints(TragicFigure.getPoints() - 1);
    if(beheaded.contains(Student3))
      TragicFigure.setPoints(TragicFigure.getPoints() - 1);
    if(beheaded.contains(Student4))
      TragicFigure.setPoints(TragicFigure.getPoints() - 1);
  }
  */