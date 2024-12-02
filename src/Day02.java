import java.io.File;
import java.util.Scanner;

public class Day02 {

	public static void main(String[] args) {
		File file = new File(System.getProperty("user.dir") + "\\src\\input02.txt");
		
		try {
			Scanner sc = new Scanner(file);
			int result = 0;
		
			while (sc.hasNextLine()) {
				if (isReportSafe(sc.nextLine().split(" "), false))
					result++;
			}
			
			System.out.println(result);
			sc.close();
		} catch (Exception e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}
	
	private static boolean isReportSafe(String[] line, boolean inRecursion) {
		boolean increasing, isSafe = true;
		int dif = Integer.parseInt(line[0]) - Integer.parseInt(line[1]);
	
		if (dif == 0 || Math.abs(dif) > 3) {
			isSafe = false;
		} else {
			increasing = dif < 0;

			for (int i = 2; i < line.length; i++) {
				dif = Integer.parseInt(line[i-1]) - Integer.parseInt(line[i]);
				
				if ((increasing && dif > 0) || (!increasing && dif < 0) ||
						(Math.abs(dif) > 3) || (Math.abs(dif) == 0)) {
					isSafe = false;
					break;
				}
			}
		}
		
		// return isSafe; // part 1
		return (!isSafe && !inRecursion) ? tolerate1BadLevel(line) : isSafe; // part 2
	}
	
	private static boolean tolerate1BadLevel(String[] line) {
		int len = line.length;
		
		for (int i = 0; i < len; i++) {
			String[] shortLine = new String[len - 1];
			int shorterCounter = 0;
		
			for (int j = 0; j < len; j++)
				if (i != j)
					shortLine[shorterCounter++] = line[j];
			
			if (isReportSafe(shortLine, true))
				return true;
		}
		
		return false;
	}
}
