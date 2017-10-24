import java.util.Arrays;

public class Xilften {
	

	public static void main(String[] args) {
		Movie firstMovie = new Movie("",1,"","action",true,1,null,null);
		int userInput = 1;
		boolean first = true;
		String[] genres = {"ACTION", "ROMANCE", "COMEDY", "DRAMA", "DOCUMENTARY","ANIME"};
		
		System.out.println("Welcome to the Movie Rating App! Select an option below:\n"
				+ "1) add a movie\n"
				+ "2) remove a movie\n"
				+ "3) display movies alphabetically\n"
				+ "4) display movies >= a certain rating\n"
				+ "5) display movies in a specified genre\n"
				+ "6) list all movies with a specified actor/actress\n"
				+ "7) list all movies the user has yet to see\n"
				+ "8) quit\n");
		while(userInput >= 1 && userInput <= 8 || userInput == 1000){
			System.out.println("Enter your Option between 1 and 8(inclusive)");
			userInput = TextIO.getlnInt();
			if(userInput == 8){
				System.out.println("Are you sure you want to quit? All your data will be lost.");
				boolean input = TextIO.getBoolean();
				if(input == true) break;
			}
	
			if(userInput == 1 && first == true){
				System.out.print("Enter Movie Title: ");
				String title = TextIO.getlnString();
				
				System.out.print("Rating(1-5): ");
				int rating = TextIO.getlnInt();
				while(rating < 1 || rating > 5){
					System.out.print("Wrong input. Please enter a value between 1 and 5(inclusive)");
					rating = TextIO.getlnInt();
				}
				System.out.print("Movie Description: ");
				String description = TextIO.getlnString();
				
				System.out.print("Genre: ");
				String genre = TextIO.getlnString();
				while(!Arrays.asList(genres).contains(genre.toUpperCase())){
					System.out.println("Wrong input. Please enter a value that belongs to {'ACTION', 'ROMANCE', 'COMEDY', 'DRAMA', 'DOCUMENTARY','ANIME'}");
					genre = TextIO.getlnString();
				}
				
				
				System.out.print("Have you seen this movie?");
				boolean hasSeen = TextIO.getlnBoolean();
				
				System.out.print("Enter Number of Actors/Actresses: ");
				int numberOfActors = TextIO.getlnInt();
				
				System.out.print("Enter names of Actors and Actresses separated by commas: ");
				String actors = TextIO.getlnString();
				actors.replaceAll("\\s+","");	
				String[] actorStringArray = actors.split(",");
				ArrayMod actorArray = new ArrayMod();
				actorArray.copyFromArray(actorStringArray);				
	
				firstMovie = new Movie(title, rating, description, genre, hasSeen, numberOfActors,actorArray,null);
				first = false;
				userInput = 1000;
			}
			if(userInput == 1 && first == false){
				System.out.print("Enter Movie Title: ");
				String title = TextIO.getlnString();
				
				System.out.print("Rating(1-5): ");
				int rating = TextIO.getlnInt();
				while(rating < 1 || rating > 5){
					System.out.print("Wrong input. Please enter a value between 1 and 5(inclusive)");
					rating = TextIO.getlnInt();
				}
				System.out.print("Movie Description: ");
				String description = TextIO.getlnString();
				
				System.out.print("Genre: ");
				String genre = TextIO.getlnString();
				while(!Arrays.asList(genres).contains(genre.toUpperCase())){
					System.out.println("Wrong input. Please enter a value that belongs to {'ACTION', 'ROMANCE', 'COMEDY', 'DRAMA', 'DOCUMENTARY','ANIME'}");
					genre = TextIO.getlnString();
				}
				
				
				System.out.print("Have you seen this movie?");
				boolean hasSeen = TextIO.getlnBoolean();
				
				System.out.print("Enter Number of Actors/Actresses: ");
				int numberOfActors = TextIO.getlnInt();
				
				System.out.print("Enter names of Actors and Actresses separated by commas: ");
				String actors = TextIO.getlnString();
				actors.replaceAll("\\s+","");	
				String[] actorStringArray = actors.split(",");
				ArrayMod actorArray = new ArrayMod();
				actorArray.copyFromArray(actorStringArray);				
				
				firstMovie = firstMovie.insert(title, rating, description, genre, hasSeen, numberOfActors,actorArray);
			}
			if(userInput == 2){
				System.out.println("Enter the movie title you want to remove: ");
				String input = TextIO.getlnString();
				firstMovie = firstMovie.remove(input);
				System.out.println(input.toUpperCase() + " was succesfully removed.");
			}
			
			if (userInput == 3){
				System.out.println(firstMovie.getSentence());
			}
			if(userInput == 4){ // fix this
				System.out.println("Enter the minimum rating: ");
				int minRating = TextIO.getlnInt();
				String output = firstMovie.displayMinRating(minRating);
				if(output == null || output.equals("\n")) System.out.println("There were no movies entered with a minimum rating of " + userInput);
				else System.out.println(output);
			}
			if(userInput == 5){ 
				String inputGenre = "";
				System.out.print("Enter the Genre('ACTION', 'ROMANCE', 'COMEDY', 'DRAMA', 'DOCUMENTARY','ANIME'): ");
				inputGenre = TextIO.getlnString();
				while(!Arrays.asList(genres).contains(inputGenre.toUpperCase())){
					System.out.println("Wrong input. Please enter a value that belongs to {'ACTION', 'ROMANCE', 'COMEDY', 'DRAMA', 'DOCUMENTARY','ANIME'}");
					inputGenre = TextIO.getlnString();
				}
				System.out.println(firstMovie.displayGenre(inputGenre));
			}
			if(userInput == 6){
				System.out.println("Enter the name of the Actor/Actress: ");
				String input = TextIO.getlnString();
				System.out.println(firstMovie.displayWithActor(input));
			}
			if (userInput == 7){
				System.out.println("Movies you haven't seen yet:");
				System.out.println(firstMovie.haventSeen());
				int input = firstMovie.maxRatingNotSeen(0);
				System.out.println("We recommend watching: " + "\n" + firstMovie.notSeenMaxRatedTitle(input));
			}
		}
	
		
	}

}
