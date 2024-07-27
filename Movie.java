package mediaRentalManager;

public class Movie extends Media {

	private String rating;

	/* Constructors */
	public Movie(String title, int copiesAvailable, String rating) {
		super(title, copiesAvailable);
		this.rating = rating;
	}
	
	public Movie() {
		this("Null", 0, "Null");
	}
	
	/* copyConstructor */
	public Movie(Movie movie) {
		super(movie);
		rating = movie.rating;
	}

	
	/* Getter */
	public String getRating() {
        return rating;
    }
	
	/* Setter */
	public void setRating(String rating) {
		this.rating = rating;
	}
	
	/* toString */
	@Override
	public String toString() {
		return super.toString() + " Rating: " + rating;
	}

	/* equals */
	@Override
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;

		Movie movie = (Movie) obj;
		return rating.equals(movie.rating);
	}


}
