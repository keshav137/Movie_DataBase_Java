
public class testing {

	public static void main(String[] args) {
		String actor = "srk,kajol,rani";
		actor.replaceAll("\\s+","");
		String[] actorStringArray = actor.split(",");

		ArrayMod actors = new ArrayMod();

		actors.copyFromArray(actorStringArray);
//		actors.print();

		String actor2 = "rani,leo";
		actor2.replaceAll("\\s+","");
		String[] actorStringArray2 = actor2.split(",");

		ArrayMod actors2 = new ArrayMod();
		
		actors2.copyFromArray(actorStringArray2);
//		actors2.print();
	
//		System.out.print(actors.ArrayModString());
		Movie firstMovie = new Movie("", 4, "good movie" , "drama", true, 3, actors,null);
		firstMovie = new Movie("Zkhh", 2, "good movie" , "drama", false, 3, actors,null);
		
		firstMovie = firstMovie.insert("A3G", 4, "bad movie" , "action", false, 3, actors2);
		firstMovie = firstMovie.insert("CCC", 4, "nice shit!", "comedy", false, 3, actors2);
//		int input = firstMovie.maxRatingNotSeen(0);
//		System.out.println(firstMovie.getSentence());
//		System.out.println("We recommend watching: " + "\n" + firstMovie.notSeenMaxRatedTitle(input));
//		System.out.println(input);
//		System.out.println(firstMovie.nextMovie.nextMovie.contains("srk"));
//		firstMovie = firstMovie.remove("ccc");
		String output = firstMovie.displayMinRating(5);
		if(output == null || output.equals(" \n")) System.out.println("There were no movies entered with a minimum rating of " + 5);
		else System.out.println(output);
	}
	

}
