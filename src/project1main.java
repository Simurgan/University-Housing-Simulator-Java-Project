import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

public class project1main {
	public static void main(String args[]) throws FileNotFoundException {
		//create scanner and printstream for input and output files
		Scanner input = new Scanner(new File(args[0]));
		PrintStream output = new PrintStream(new File(args[1]));
		
		//arraylists to record houses and students
		ArrayList<House> houses = new ArrayList<House>();
		ArrayList<Student> students = new ArrayList<Student>();
		
		//take data to the arraylists from the input file
		int maxDuration = 0;
		while(input.hasNextLine()) {
			if(input.next().equals("h")) {
				int id = input.nextInt();
				int duration = input.nextInt();
				String r = input.next();
				double rating = Double.parseDouble(r);
				input.nextLine();
				House a = new House(id, duration, rating);
				houses.add(a);
			} else {
				int id = input.nextInt();
				String name = input.next();
				int duration = input.nextInt();
				maxDuration = duration > maxDuration ? duration : maxDuration;
				String r = input.next();
				double rating = Double.parseDouble(r);
				input.nextLine();
				Student a = new Student(id, name, duration, rating);
				students.add(a);
			}
		}
		
		input.close();
		//sort the arraylists
		Collections.sort(houses);
		Collections.sort(students);
		
		//allocate the students throughout semesters
		for(int i = 0; i < maxDuration; i++) {
			
			Iterator<House> hIterator = houses.iterator();
			while(hIterator.hasNext()) {
				
				House h = hIterator.next();
				if(h.getDuration() <= 0) {
					
					Iterator<Student> sIterator = students.iterator();
					while(sIterator.hasNext()) {
						
						Student s = sIterator.next();
						
						if(s.getDuration() > 0 && s.getRating() <= h.getRating()) {
							h.setDuration(s.getDuration());
							sIterator.remove();
							break;
						}
					}
				}
				h.lowerDuration();
			}
			
			Iterator<Student> sIterator = students.iterator();
			while(sIterator.hasNext()) {
				sIterator.next().lowerDuration();
			}
			
		}
		
		//print the output

		Iterator<Student> sIterator = students.iterator();
		while(sIterator.hasNext()) {
			output.println(sIterator.next().getName());
		}

	}
}
