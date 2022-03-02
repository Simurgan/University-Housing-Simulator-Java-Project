
public class Student implements Comparable<Student>{
	//fields
	private int id;
	private String name;
	private int duration;
	private double rating;
	//constructor
	public Student(int id, String name, int duration, double rating) {
		this.id = id;
		this.name = name;
		this.duration = duration;
		this.rating = rating;
	}
	
	public String getName() {
		return this.name;
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
	//compareto method to sort students according to their ids
	@Override
	public int compareTo(Student o) {
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
