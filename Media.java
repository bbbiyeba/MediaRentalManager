package mediaRentalManager;

public class Media implements Comparable <Media> {
	private String title;
	private int copiesAvailable;

	public Media(String title, int copiesAvailable) {
		this.title = title;
		this.copiesAvailable = copiesAvailable;
	}
	
	public Media(Album album) {
		this("Null", 0);
	}
	
	/* copyConstructor */
	public Media(Media media) {
		this(media.title, media.copiesAvailable);
	}
	
	/* Decreasing copy */
	public void decreaseCopy() {
		if (copiesAvailable > 0) 
			copiesAvailable--;
	}

	/* Increasing copy */
	public void increaseCopy() {
		copiesAvailable++;
	}
	
	/* Getters */
	public String getTitle() {
		return title;
	}
	
	public int getCopiesAvailable() {
		return copiesAvailable;
	}
	
	/* Setters */
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setCopiesAvailable(int copiesAvailable) {
		this.copiesAvailable = copiesAvailable;
	}
	
	/* toString */
	public String toString() {
		return "Title: " + title + "," + " Copies Available: " + copiesAvailable + ",";
	}
	
	@Override
	/* compareTo */
	public int compareTo(Media obj) {
		return title.compareTo(obj.title);
	}
}
