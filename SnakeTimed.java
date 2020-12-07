import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.concurrent.TimeUnit;

/*This class will give the Snake class a timer, and allow the game to run at a
constant rate, instead of having to wait for user input!*/
public class SnakeTimed{
  Snake currSnake;
  char currInput;
  long startTime; /*The system time when the snake game begins*/
  long waitTime; /*The amount of time we want between frames, in milliseconds*/
  /*This is limited at around 20-40 milliseconds at the fastest*/

  public SnakeTimed(){ /*Default constructor*/
    currSnake = new Snake();
    currInput = 'd'; /*User starts by traveling right*/
    startTime = System.currentTimeMillis();
    waitTime = (long)((1.0/3.0)*1000.0); /*Default has 3 frames a second*/
  }

/*This constructor allows for variable framerate and board size!*/
  public SnakeTimed(int boardHeight, int boardWidth, int waitTime){
    currSnake = new Snake(boardHeight,boardWidth);
    currInput = 'd';
    startTime = System.currentTimeMillis();
    this.waitTime = (long)waitTime;
  }

/*Main to run our program!*/
  public static void main(String[] args) throws IOException, InterruptedException{
    SnakeTimed snek = new SnakeTimed(20,20,70); /*New game with 20x20 board size
    and a 70 millisecond wait time between game board print outs*/
    snek.currSnake.initializeBoard();
    /*Set up the game board*/
    String s;
    char charInput; /*Initialize these here so they don't have to be
    re-initialized on every iteration of the while loop*/
    try (BufferedReader in  = new BufferedReader(new InputStreamReader(System.in))){
      /*This BufferedReader will allow for the code to run regardless of what
      happens on the user side, so if a user types a character and presses enter,
      the character will be input in the game on the next turn, but the game
      won't actually wait for input if the user doesn't give any!*/
      while(snek.currSnake.gameState){
        /*Repeat the game turns as long as the game isn't over*/
        System.out.println(snek.currSnake);
        /*Print game board*/
        try{
          Thread.sleep(snek.waitTime);
        }
        catch(InterruptedException e){
        }
        /*Between each board print out and game operations, wait a certain amount
        of time. This function can throw an exception, so we catch this in case
        and throw it to the top of the main function*/
        s = null; /*the user input is null by default*/
        while(in.ready()){
          s = in.readLine(); /*This while statement will check whether an input
          has been made, but only record the most recent input, protecting us
          from multiple inputs*/
        }
        if(s!=null && s.length()!=0){
          charInput = s.charAt(0); /*Our move input is the first character of
          what was input by the user*/
          if(charInput == 'w' || charInput == 'a' || charInput == 's'
          || charInput == 'd' || charInput == 'q'){
            snek.currInput = charInput; /*The new input is stored to direct the
            game snake in future turns if no new input is given*/
            snek.currSnake.move(snek.currInput);
            /*Move the snake in the new direction*/
            continue;
            /*Go back to the beginning of the loop, next turn*/
          }
        }
        /*If no new input was given, move in the last given input direction*/
        snek.currSnake.move(snek.currInput);
      }
    }
  }
}
