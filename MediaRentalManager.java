package mediaRentalManager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MediaRentalManager implements MediaRentalManagerInt {

	// Two private ArrayList instances
	private ArrayList<Customer> customerInfo = new ArrayList<>();
	private ArrayList<Media> mediaInfo = new ArrayList<>();

	// restricts the media to a default value of 2 and can only be changed via a
	// manager method
	// private int limitedPlan = 2;

	public void addCustomer(String name, String address, String plan) {
		Customer customer = new Customer(name, address, plan);
		customerInfo.add(customer);
	}

	public void addMovie(String title, int copiesAvailable, String rating) {
		Movie movie = new Movie(title, copiesAvailable, rating);
		mediaInfo.add(movie);
	}

	public void addAlbum(String title, int copiesAvailable, String artist, String songs) {
		Album newAlbum = new Album(title, copiesAvailable, songs, artist);
		mediaInfo.add(newAlbum);
	}

	public void setLimitedPlanLimit(int value) {
		for (int idx = 0; idx < customerInfo.size(); idx++) {
			customerInfo.get(idx).setNewPlan(value);
		}
	}

	public String getAllCustomersInfo() {
		String answer = "***** Customers' Information *****\n";

		Collections.sort(customerInfo);

		for (Customer customer : customerInfo) {
			answer += "Name: " + customer.getName() + ", Address: " + customer.getAddress() + ", Plan: "
					+ customer.getPlan() + "\nRented: " + customer.rentedQueue + "\nQueue: " + customer.interestedQueue
					+ "\n";
		}
		return answer;

	}

	public String getAllMediaInfo() {
		String answer = "***** Media Information *****\n";
		Collections.sort(mediaInfo);

		for (int idx = 0; idx < mediaInfo.size(); idx++) {
			answer += mediaInfo.get(idx).toString() + "\n";
		}
		return answer;
	}

	public boolean addToQueue(String customerName, String mediaTitle) {
		for (int idx = 0; idx < customerInfo.size(); idx++) {
			if (customerInfo.get(idx).getName().equals(customerName)) {
				customerInfo.get(idx).getInterestedQueue().add(mediaTitle);
				return true;
			}
		}
		return false;
	}

	public boolean removeFromQueue(String customerName, String mediaTitle) {
		for (int idx = 0; idx < customerInfo.size(); idx++) {
			if (customerInfo.get(idx).getName().equals(customerName)) {
				customerInfo.get(idx).getInterestedQueue().remove(mediaTitle);
				return true;
			}
		}
		return false;
	}

	public String processRequests() {
		String result = "";
		String unlimited = "UNLIMITED";
		Collections.sort(customerInfo);
		for (int i = 0; i < customerInfo.size(); i++) {
			if (customerInfo.get(i).getPlan().equals(unlimited)) {
				for (int j = 0; j < customerInfo.get(i).getInterestedQueue().size(); j++) {
					boolean wrong = false;
					for (Media copy1 : mediaInfo) {
						if (customerInfo.get(i).getInterestedQueue().get(j).equals(copy1.getTitle())) {
							if (copy1.getCopiesAvailable() > 0) {
								wrong = true;
							}
						}
					}
					if (wrong) {
						customerInfo.get(i).getRentedQueue().add(customerInfo.get(i).getInterestedQueue().get(j));
						result += "Sending " + customerInfo.get(i).getInterestedQueue().get(j) + " to "
								+ customerInfo.get(i).getName() + "\n";
						for (Media copy2 : mediaInfo) {
							if (customerInfo.get(i).getInterestedQueue().get(j).equals(copy2.getTitle())) {
								copy2.decreaseCopy();
							}
						}
						customerInfo.get(i).getInterestedQueue().remove(j);
						j--;
					}
				}
			} else {
				int num = customerInfo.get(i).getNewPlan();
				int size = customerInfo.get(i).getRentedQueue().size();
				int space = num - size;
				for (int idx = 0; idx < customerInfo.get(i).getInterestedQueue().size(); idx++) {
					if (space == 0) {
						break;
					}

					if (space > 0) {
						boolean wrong2 = false;
						for (Media copy1 : mediaInfo) {
							if (customerInfo.get(i).getInterestedQueue().get(idx).equals(copy1.getTitle())) {
								if (copy1.getCopiesAvailable() > 0) {
									wrong2 = true;
								}
							}
						}
						if (wrong2) {
							customerInfo.get(i).getRentedQueue().add(customerInfo.get(i).getInterestedQueue().get(idx));
							result += "Sending " + customerInfo.get(i).getInterestedQueue().get(idx) + " to "
									+ customerInfo.get(i).getName() + "\n";
							for (Media copy2 : mediaInfo) {
								if (customerInfo.get(i).getInterestedQueue().get(idx).equals(copy2.getTitle())) {
									copy2.decreaseCopy();
								}
							}
							customerInfo.get(i).getInterestedQueue().remove(idx);
							space--;
							idx--;
						}
					}
				}
			}
		}
		return result;
	}

	public boolean returnMedia(String customerName, String mediaTitle) {
		for (int idx = 0; idx < customerInfo.size(); idx++) {
			if (customerInfo.get(idx).getName().equals(customerName)
					&& customerInfo.get(idx).getRentedQueue().contains(mediaTitle)) {
				customerInfo.get(idx).getRentedQueue().remove(mediaTitle);
				for (Media media : mediaInfo) {
					if (mediaTitle.equals(media.getTitle())) {
						media.increaseCopy();
					}
				}
				return true;
			}
		}
		return false;
	}

	@Override
	public ArrayList<String> searchMedia(String title, String rating, String artist, String songs) {

		ArrayList<String> newType = new ArrayList<String>();


		for (Media media : mediaInfo) {
			boolean Title = title == null || title.equals(media.getTitle());
			boolean Rating = rating == null
					|| (media instanceof Movie && ((Movie) media).getRating().equals(rating));
			boolean Artist = artist == null
					|| (media instanceof Album && ((Album) media).getArtist().equals(artist));
			boolean Songs = songs == null
					|| (media instanceof Album && ((Album) media).getArtist().toString().contains(songs));

			if (Title && Rating && Artist && Songs) {
				newType.add(media.getTitle());
			}

		}
		Collections.sort(newType);
		return newType;
	}

}
