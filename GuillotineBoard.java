import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.Button;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.control.ColorPicker;
import javafx.geometry.Orientation;
import javafx.scene.layout.HBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.layout.Pane;
import javafx.scene.Parent;
import javafx.scene.layout.Region;
  

/**
* The Guillotine Board is the GUI for the GuillotineLinkedList
* which stores the GuillotinePersons which the GuillotinePlayers
* can manipulate using buttons that active methods.
*
* @author  Adam Kerkemeyer
* @version 1.0
* @since   2022-04-12
*/


public class GuillotineBoard extends Application{
  GuillotinePlayer p1 = new GuillotinePlayer("Player 1");
  GuillotinePlayer p2 = new GuillotinePlayer("Player 2");
  
  GuillotineLinkedList<GuillotinePerson> persons = GuillotinePerson.makeArray(20);
  GuillotineLinkedList<Button> personsButtons = GuillotinePerson.makeButtonArray(persons);//array of persons but as buttons
  //turns persons into buttons

  private Button moveBack4p1;
  private Button moveBack3p1;
  private Button moveBack2p1;
  private Button moveBack1p1;
  private Button moveFrontToBackp1;
  private Button moveBackToFrontp1;
  private Button reverseAllp1;
  private Button reverse5p1;
  private Button skipTurnp1;
  private Button takeCardp1;
  
  private Button moveBack4p2;
  private Button moveBack3p2;
  private Button moveBack2p2;
  private Button moveBack1p2;
  private Button moveFrontToBackp2;
  private Button moveBackToFrontp2;
  private Button reverseAllp2;
  private Button reverse5p2;
  private Button skipTurnp2;
  private Button takeCardp2; 
    
  private Label p1Score;
  private Label p2Score;
  private VBox personsList;
  private VBox p1Display;
  private VBox p2Display;
  
  private GuillotinePerson tempPerson;
  
  public void start(Stage primaryStage){
    
    moveBack4p1 = new Button("Move Front Back 4");
    moveBack4p1.setOnAction(e -> {
      if(p1.isTurn() && !moveBack4p1.isDisable()){
        moveBack4p1.setDisable(true);
        persons.moveBack(4);
        personsButtons.moveBack(4);
        update();
      }
    });
    moveBack3p1 = new Button("Move Front Back 3");
    moveBack3p1.setOnAction(e -> {
      if(p1.isTurn() && !moveBack3p1.isDisable()){
        moveBack3p1.setDisable(true);
        persons.moveBack(3);
        personsButtons.moveBack(3);
        update();
      }
    });
    moveBack2p1 = new Button("Move Front Back 2");
    moveBack2p1.setOnAction(e -> {
      if(p1.isTurn() && !moveBack2p1.isDisable()){
        moveBack2p1.setDisable(true);
        persons.moveBack(2);
        personsButtons.moveBack(2);
        update();
      }
    });
    moveBack1p1 = new Button("Move Front Back 1");
    moveBack1p1.setOnAction(e -> {
      if(p1.isTurn() && !moveBack1p1.isDisable()){
        moveBack1p1.setDisable(true);
        persons.moveBack(1);
        personsButtons.moveBack(1);
        update();
      }
    });
    moveFrontToBackp1 = new Button("Move Front to End");
    moveFrontToBackp1.setOnAction(e -> {
    if(p1.isTurn() && !moveFrontToBackp1.isDisable()){
        moveFrontToBackp1.setDisable(true);
        persons.moveFirstToLast();
        personsButtons.moveFirstToLast();
        update();
      }
    });
    moveBackToFrontp1 = new Button("Move End to Front");
    moveBackToFrontp1.setOnAction(e -> {
    if(p1.isTurn() && !moveBackToFrontp1.isDisable()){
        moveBackToFrontp1.setDisable(true);
        persons.moveLastToFirst();
        personsButtons.moveFirstToLast();
        update();
      }
    });
    reverseAllp1 = new Button("Reverse List");
    reverseAllp1.setOnAction(e -> {
    if(p1.isTurn() && !reverseAllp1.isDisable()){
        reverseAllp1.setDisable(true);
        persons.reverseList();
        personsButtons.reverseList();
        update();
      }
    });
    reverse5p1 = new Button("Reverse First 5");
    //Need to write SetOnAction
    skipTurnp1 = new Button("Skip Turn");
    skipTurnp1.setOnAction(e -> {
    if(p1.isTurn() && !skipTurnp1.isDisable()){
        skipTurnp1.setDisable(true);
        p1.isTurn(false);
        p2.isTurn(true);
        update();
      }
    });
    takeCardp1 = new Button("Take Front Person");
    takeCardp1.setOnAction(e -> {
    if(p1.isTurn()){
      tempPerson = persons.getFirstNode().getElement();
        p1.behead(tempPerson);
        p1Display.getChildren().add(personsButtons.getFirstNode().getElement());
        persons.removeFromFront();
        personsButtons.removeFromFront();
        p1.isTurn(false);
        p2.isTurn(true);
        update();
      }
    });
   
    
    moveBack4p2 = new Button("Move Front Back 4");
    moveBack4p2.setOnAction(e -> {
      if(p2.isTurn() && !moveBack4p2.isDisable()){
        moveBack4p2.setDisable(true);
        persons.moveBack(4);
        personsButtons.moveBack(4);
        update();
      }
    });
    moveBack3p2 = new Button("Move Front Back 3");
    moveBack3p2.setOnAction(e -> {
      if(p2.isTurn() && !moveBack3p2.isDisable()){
        moveBack3p2.setDisable(true);
        persons.moveBack(3);
        personsButtons.moveBack(3);
        update();
      }
    });
    moveBack2p2 = new Button("Move Front Back 2");
    moveBack2p2.setOnAction(e -> {
      if(p2.isTurn() && !moveBack2p2.isDisable()){
        moveBack2p2.setDisable(true);
        persons.moveBack(2);
        personsButtons.moveBack(2);
        update();
      }
    });
    moveBack1p2 = new Button("Move Front Back 1");
    moveBack1p2.setOnAction(e -> {
      if(p2.isTurn() && !moveBack1p2.isDisable()){
        moveBack1p2.setDisable(true);
        persons.moveBack(1);
        personsButtons.moveBack(1);
        update();
      }
    });
    moveFrontToBackp2 = new Button("Move Front to End");
    moveFrontToBackp2.setOnAction(e -> {
    if(p2.isTurn() && !moveFrontToBackp2.isDisable()){
        moveFrontToBackp2.setDisable(true);
        persons.moveFirstToLast();
        personsButtons.moveFirstToLast();
        update();
      }
    });
    moveBackToFrontp2 = new Button("Move End to Front");
    moveBackToFrontp2.setOnAction(e -> {
    if(p2.isTurn() && !moveBackToFrontp2.isDisable()){
        moveBackToFrontp2.setDisable(true);
        persons.moveLastToFirst();
        personsButtons.moveLastToFirst();
        update();
      }
    });
    reverseAllp2 = new Button("Reverse List");
    reverseAllp2.setOnAction(e -> {
    if(p2.isTurn() && !reverseAllp2.isDisable()){
        reverseAllp2.setDisable(true);
        persons.reverseList();
        personsButtons.reverseList();
        update();
      }
    });
    reverse5p2 = new Button("Reverse First 5");
    //Need to write SetOnAction
    skipTurnp2 = new Button("Skip Turn");
    skipTurnp2.setOnAction(e -> {
    if(p2.isTurn() && !skipTurnp2.isDisable()){
        skipTurnp2.setDisable(true);
        p2.isTurn(false);
        p1.isTurn(true);
        update();
      }
    });
    takeCardp2 = new Button("Take Front Person");
    takeCardp2.setOnAction(e -> {
    if(p2.isTurn()){
        p2.behead((GuillotinePerson)(persons.getFirstNode().getElement()));
        p2Display.getChildren().add(personsButtons.getFirstNode().getElement());
        persons.removeFromFront();
        personsButtons.removeFromFront();
        p2.isTurn(false);
        p1.isTurn(true);
        update();
      }
    });
    
    BorderPane layout = new BorderPane();
    
    
    p1Score = new Label("Score: " + p1.getScore());
    p2Score = new Label("Score: " + p2.getScore());
    
    personsList = new VBox(2, toArray(personsButtons)); //fix this
    //personsList = new VBox(3);
   // Button[] buttonArray = toArray(persons);
    //for(int i = 0; i < buttonArray.length; i++){
    //  personsList.getChildren().add(buttonArray[i]);
    //}
    p1Display = new VBox(2, new Label("Player 1"), p1Score, moveBack4p1, moveBack3p1, moveBack2p1,
                         moveBack1p1, moveFrontToBackp1, moveBackToFrontp1, reverseAllp1, 
                         reverse5p1, skipTurnp1, takeCardp1);
    p2Display = new VBox(2, new Label("Player 2"), p2Score, moveBack4p2, moveBack3p2, moveBack2p2,
                         moveBack1p2, moveFrontToBackp2, moveBackToFrontp2, reverseAllp2, 
                         reverse5p2, skipTurnp2, takeCardp2);
    
    layout.setCenter(personsList);
    
    //personsList.setAlignment(Pos.CENTER);
    //p1Display.setAlignment(Pos.TOP_RIGHT);
    //p2Display.setAlignment(Pos.TOP_LEFT);
    layout.setRight(p1Display);
    layout.setLeft(p2Display);
    
    Scene scene = new Scene(layout);
    primaryStage.setScene(scene);
    primaryStage.setWidth(550);
    primaryStage.setHeight(750);
    primaryStage.setTitle("Guillotine");
    primaryStage.show();
    p1.isTurn(true);
  }
  
  /*
   * Launch the application
   */
  public static void main(String[] args){
    Application.launch(args);
  }
  
  /*
   * update the GUI
   */
  public void update(){
    //p1.calculateScore();
    //p2.calculateScore();
    p1Score.setText("Score: " + p1.getScore());
    p2Score.setText("Score: " + p2.getScore());
    
    personsList.getChildren().clear();
    //remake the entire list of buttons so that it can be updated.
    for(int i = 0; i < toArray(personsButtons).length; i++){
      personsList.getChildren().add(toArray(personsButtons)[i]);
    }
    if(toArray(personsButtons).length == 0){
      if(p1.getScore() > p2.getScore()){
        System.out.println("Player 1 Wins!");
      }
      else if(p1.getScore() < p2.getScore()){
        System.out.println("Player 2 Wins!");
      }
      else{
        System.out.println("Its a tie.");
      }
    }
  }
  
  /*
   * make array of person buttons:
   */
  public Button[] toArray(GuillotineLinkedList<Button> b){
    Button[] personButtons = new Button[b.length()];
    LLNode<Button> nodeptr = b.getFirstNode();
    for(int i = 0; i < b.length(); i++){
      if(nodeptr.getElement() instanceof Button) {
        //if statement to prevent the appendage of null sections
        Button tempButton = (Button)(nodeptr.getElement());
        personButtons[i] = tempButton;
        nodeptr = nodeptr.getNext();
      }
    }
    return personButtons;
  }
}
