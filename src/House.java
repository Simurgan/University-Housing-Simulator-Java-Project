
public class House implements Comparable<House>{
	//fields
	private int id;
	private int duration;
	private double rating;
	//constructor
	public House(int id, int duration, double rating) {
		this.id = id;
		this.duration = duration;
		this.rating = rating;
	}
	
	public void setDuration(int a) {
		this.duration = a;
	}
	
	public int getDuration() {
		return this.duration;
	}
	
	public double getRating() {
		return this.rating;
	}
	//this method lowers the duration 1. will be used after semesters
	public void lowerDuration() {
		this.duration--;
	}
	//compareto method to sort houses according to their ids
	@Override
	public int compareTo(House o) {
		// TODO Auto-generated method stub
		if(this.id < o.id) {
			return -1;
		} else if (this.id > o.id){
			return 1;
		} else {
			return 0;
		}
	}
}
