import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Day01 {

	public static void main(String[] args) {
		File file = new File(System.getProperty("user.dir") + "\\src\\input01.txt");
		
		try {
			Scanner sc = new Scanner(file);
			
			List<Integer> left = new ArrayList<>();
			List<Integer> right = new ArrayList<>();
		
			while (sc.hasNext()) {
				left.add(sc.nextInt());
				right.add(sc.nextInt());
			}
		
			sc.close();
			
			//part1(left, right);
			part2(left, right);
			
		} catch (Exception e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}
	
	private static void part1(List<Integer> left, List<Integer> right) {
		Collections.sort(left, (a, b) -> a.compareTo(b));
		Collections.sort(right, (a, b) -> a.compareTo(b));
		
		int result = 0;
		
		for (int i = 0; i < left.size(); i++) 
			result += Math.abs(left.get(i) - right.get(i));
		
		System.out.println(result);
	}
	
	private static void part2(List<Integer> left, List<Integer> right) {
		int num, numFreq, result = 0;
		
		for (int i = 0; i < left.size(); i++) {
			numFreq = 0;
			num = left.get(i);
			
			for (int rightNum : right)
				if (num == rightNum)
					numFreq++;
			
			result += num * numFreq;
		}
		
		System.out.println(result);
	}
}
