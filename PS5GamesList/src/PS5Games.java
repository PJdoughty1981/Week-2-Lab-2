public class PS5Games {
   private String gameName;
   private int numberOfPlayers;
   private String rating;
   private String developer;
   private boolean isMultiplayer;

   //---Constructor Methods
   public PS5Games(String gameName, int numberOfPlayers, String rating,
                   String developer, boolean isMultiplayer) {
      this.gameName = gameName;
      this.numberOfPlayers = numberOfPlayers;
      this.rating = rating;
      this.developer = developer;
      this.isMultiplayer = isMultiplayer;
   }

   //---Getter Methods
   public String getGameName() {
      return gameName;
   }

   public int getNumberOfPlayers() {
      return numberOfPlayers;
   }

   public String getRating() {
      return rating;
   }

   public String getDeveloper() {
      return developer;
   }

   public boolean getIsMultiplayer() {
      return isMultiplayer;
   }



   //---Method to return toString representation
   public String toString() {
      return "Game Name: " + gameName + "\n" +
             "MAX Number of Party Players: " + numberOfPlayers + "\n" +
             "Rating: " + rating + "\n" +
             "Developer: " + developer + "\n" +
             "Multiplayer?: " + (isMultiplayer ? "Yes" : "No") + "\n" +
             "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ \n";
   }

}

