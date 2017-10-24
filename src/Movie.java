
public class Movie {
// use arraylist instead of array and to traverse, you can convert to array and chill bruhh, arrays are immutable so you gotta
	// be careful and chill the fuck out bruh its chill no one cares bruh zyzz
	private String title = "";
	private int rating = 1;
	private String description = "";
	private String genre = "";
	private boolean haveSeen = false;
	private int numberOfActors = 0;
	private ArrayMod actorArray;
	private Movie nextMovie;
	 
	 
	 public Movie(){
	 }
	 public Movie(String title, int rating, String description, String genre, boolean haveSeen, int number, ArrayMod actorArray,Movie nextMovie){
		 this.title = title;
		 this.rating = rating;
		 this.description = description;
		 this.genre = genre;
		 this.haveSeen = haveSeen;
		 this.numberOfActors = number;
		 this.actorArray = actorArray;
		 this.nextMovie = nextMovie;
	 }
	 public String toString(){
		 return this.title;
	 }
	 public String displayActors(){
		 return actorArray.ArrayModString();
	 }
	 public String getSentence(){
		 if(nextMovie == null) return this.printMovieInfo() ;
		 else return this.printMovieInfo()  +  this.nextMovie.getSentence();
	 }
	 public Movie insert(String title, int rating, String description, String genre, boolean haveSeen, int number, ArrayMod actorArray){
		 if(this.title.compareTo(title) >= 0) return new Movie(title,rating,description,genre,haveSeen,number,actorArray,this);
		 if(this.nextMovie != null) this.nextMovie = nextMovie.insert(title, rating, description, genre, haveSeen, number, actorArray);
		 else nextMovie = new Movie(title,rating,description,genre,haveSeen,number,actorArray,null);
		 return this;
	 }
	 public String displayMinRating(int minRating){
		 String partialResult = "";
		 if(this.rating >= minRating) partialResult += this.printMovieInfo();
		 if(this.nextMovie != null) return partialResult + nextMovie.displayMinRating(minRating);
		 return partialResult;
	 }
	 
	 public String printMovieInfo(){
		 return this.title.toUpperCase() + "\nDescription: " + this.description + "\nRating: " + this.rating + "\nGenre: "+ this.genre + "\nActors and Actresses: "
			 		+ this.displayActors() + "\nHave you seen this movie? " + this.yesOrNo() + "\n\n";
	 }
	 private String yesOrNo() {
		 if (this.haveSeen ==  true) return "Yes";
		 else return "Nope";
		 
	}
	public String displayGenre(String inputGenre){
		 String partialResult = ""; 
		 if(this.genre.equals(inputGenre) && this.haveSeen == false) partialResult += this.title.toUpperCase() + "\n";
		 if(this.nextMovie != null) return partialResult + this.nextMovie.displayGenre(inputGenre);
		 return partialResult;
	 }
	 public String haventSeen(){
		 String partialResult = "";
		 if (this.haveSeen == false) partialResult += this.title + "\n";
		 if(this.nextMovie != null) return partialResult + this.nextMovie.haventSeen();
		 return partialResult;
	 }
	 public String notSeenMaxRatedTitle(int maxRating){
		 String result = "";
		 if(this.haveSeen == false && this.rating >= maxRating) result = this.title;
		 if(this.nextMovie != null) return result + "\n" + this.nextMovie.notSeenMaxRatedTitle(maxRating);
		 return result;
	 }
	 //minRating and genre only displaying first movie.
	 public int maxRatingNotSeen(int acc){
		 if(nextMovie == null){
			 if(this.rating >= acc && this.haveSeen == false) return this.rating;
			 else return acc; 
		 }
		 if (this.rating >= acc && this.haveSeen == false) return nextMovie.maxRatingNotSeen(this.rating);
		 else return nextMovie.maxRatingNotSeen(acc);
		 
	 }
	public boolean contains(String input){
		for(int i = 0; i < this.actorArray.arrayAct.length ; i++){
			if(this.actorArray.arrayAct[i].toLowerCase().equals(input.toLowerCase())){
				return true;
			}
		}
		return false;
	}
	public String displayWithActor(String input) {
		String partialResult = "";
		if (this.contains(input) == true) partialResult += this.title.toUpperCase() + "\n";
		if(this.nextMovie != null) return partialResult + this.nextMovie.displayWithActor(input);
		return partialResult;
		
	}
	public Movie findLast(){
		if (this.nextMovie == null) return this;
		else return this.nextMovie.findLast();
	}



    public Movie remove(String input) {
        if (this.title.toLowerCase().equals(input.toLowerCase())) return this.nextMovie;
        return new Movie(this.title,this.rating,this.description,this.genre,this.haveSeen,this.numberOfActors,this.actorArray,this.nextMovie.remove(input));
    }  


}
