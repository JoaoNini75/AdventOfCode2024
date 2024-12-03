import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day03 {

	public static void main(String[] args) {
		File file = new File(System.getProperty("user.dir") + "\\src\\input03.txt");
		
		try {
			Scanner sc = new Scanner(file);
			//part1(sc);
			part2(sc);
			sc.close();
		} catch (Exception e) {
			System.out.println("EXCEPTION!");
			e.printStackTrace();
		}
	}
	
	private static void part1(Scanner sc) {
		int result = 0;
	
		while (sc.hasNextLine()) {
			String line = sc.nextLine();
			Pattern pattern = Pattern.compile("mul\\([0-9]{1,3},[0-9]{1,3}\\)");
		    Matcher matcher = pattern.matcher(line);
		    
		    while (matcher.find()) {
		    	String match = matcher.group();
		    	String insideParentheses = match.substring(4, match.length() - 1);
		    	String[] split = insideParentheses.split(",");
		    	result += Integer.parseInt(split[0]) * Integer.parseInt(split[1]);
		    }
		}
		
		System.out.println(result);
	}
	
	private static void part2(Scanner sc) {
		int result = 0;
		boolean enabled = true;
		String[] lines = new String[6];
		int i = 0;
		
		while (sc.hasNextLine())
			lines[i++] = sc.nextLine();
		
		Pattern pattern = Pattern.compile("do\\(\\)|don't\\(\\)|mul\\([0-9]{1,3},[0-9]{1,3}\\)");
		
		for (String line : lines) {
			Matcher matcher = pattern.matcher(line);
			
			while (matcher.find()) {
				String match = matcher.group();
				
				if (match.equals("don't()"))
					enabled = false;
				else if (match.equals("do()"))
					enabled = true;
				else if (enabled) {
					String insideParentheses = match.substring(4, match.length() - 1);
			    	String[] split = insideParentheses.split(",");
			    	result += Integer.parseInt(split[0]) * Integer.parseInt(split[1]);
				}
			}
		}
		
		System.out.println(result);
	}
	
}
