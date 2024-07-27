package mediaRentalManager;

public class Album extends Media {
	private String artist, songs;

	/* Constructors */
	public Album(String title, int copiesAvailable, String artist, String songs) {
		// Calls superclass constructor
		super(title, copiesAvailable);

		this.artist = artist;
		this.songs = songs;
	}

	public Album() {
		this("Null", 0, "Null", "Null");
	}

	/* copyConstructor */
	public Album(Album album) {
		super(album);
		artist = album.artist;
		songs = album.songs;
	}

	/* Getters */
	public String getArtist() {
		return artist;
	}

	public String getSongs() {
		return songs;
	}

	/* Setters */
	public void setArtist(String artist) {
		this.artist = artist;
	}

	public void setSongs(String songs) {
		this.songs = songs;
	}

	/* toString */
	@Override
	public String toString() {
		return super.toString() + " Artist: " + songs + "," + " Songs: " + artist;
	}

	/* equals */
	@Override
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;

		Album album = (Album) obj;
		// checks if it's the same movie
		return songs.equals(album.songs);
	}

}
