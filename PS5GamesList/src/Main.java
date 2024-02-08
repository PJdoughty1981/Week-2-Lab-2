import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

   public static void main(String[] args) {
      //---Empty Arraylist
      ArrayList<PS5Games> games = new ArrayList<>();

      try
      {
         //---Create scanner object
         Scanner scanGames = new Scanner(new File("PS5GamesList.txt"));
         //---Loop until end of txt file
         while (scanGames.hasNextLine())
         {
            String line = scanGames.nextLine();

            //---Split by commas
            String[] tokens = line.split(",");

            //---Extract attributes
            String gameName = tokens[0].trim();
            int numberOfPlayers = Integer.parseInt(tokens[1].trim());
            String rating = tokens[2].trim();
            String developer = tokens[3].trim();
            boolean isMultiplayer = tokens[4].trim().
               equalsIgnoreCase("Yes");

            //---Create new game object
            PS5Games game = new PS5Games(gameName, numberOfPlayers, rating,
               developer, isMultiplayer);

            games.add(game);
         }
         scanGames.close();

      } catch (FileNotFoundException e)
      {
         System.out.println("ERROR! PS5GamesList.txt not found");
         System.err.println("ERROR! PS5GamesList.txt not found");
      }
      System.out.println("\nThe ArrayList Games has been created and contains: "
         + games.size() + " Game records. \n");
      System.out.println(games);
      //---------------End of Read In-------------------------------------------


      //--- Manual add option
      Scanner userInput = new Scanner(System.in);
      System.out.println("Would you like to enter additional game information "+
                         "manually? (y/n) ");
      String option = userInput.nextLine();
      while (option.equalsIgnoreCase("y")){
         System.out.println("Enter Game Name: ");
         String gameName = userInput.nextLine();
         System.out.println("Enter MAX number of players: ");
         int numberOfPlayers = Integer.parseInt(userInput.nextLine());
         System.out.println("Enter Game PEGI rating: ");
         String rating = userInput.nextLine();
         System.out.println("Enter Game Developer Name: ");
         String developer = userInput.nextLine();
         System.out.println("Is it Multiplayer? (yes/no): ");
         boolean isMultiplayer = Boolean.parseBoolean(userInput.nextLine());
         PS5Games game = new PS5Games(gameName, numberOfPlayers, rating,
            developer, isMultiplayer);
         games.add(game);
         System.out.println("Would you like to enter additional game information "+
            "manually? (y/n) ");
         option = userInput.nextLine();

      }if (option.equalsIgnoreCase("n")){
         //--- Sort the games Arraylist prior to writing to new file.
         userInput.close();

         System.out.println("################################################");
         System.out.println("\nUser has Entered NO.  Starting next phase\n");
         System.out.println("################################################");
         System.out.println("The NEW ArrayList Games " +
                            "will now be sorted Alphabetically \n");
         //--- Simple collections sort
         games.sort(Comparator.comparing
            (PS5Games::getGameName).thenComparing(PS5Games::getGameName));
         //--- Print new size
         System.out.println("\nThe New Games List is "+games.size()+ " Records.\n");
         System.out.println("Sorted List by Name \n " + games + "\n");

         //---Create a file Writer
         try (FileWriter gameWriter = new FileWriter("Game Summary.txt"))
         {
            gameWriter.write("\nThis summary contains " + games.size()+ " games for PS5.\n");
            for (PS5Games game : games)
            {
               gameWriter.write("\n" + game.toString() + "\n");
            }
            System.out.println("Sorted Game Summary.txt creation.. SUCCESSFUL!");

         } catch (IOException e)
         {
            System.out.println("ERROR writing to Game Summary.txt");
            System.err.println("ERROR writing to Game Summary.txt");
         }
      } else {
         System.out.println("Invalid option. Please enter y or n");
      }

   }
}

