import java.io.File;
import java.util.Scanner;

public class Day04 {
	
	private static final int[] DIR_X = {0, 0, 1, -1, 1, -1, 1, -1};
    private static final int[] DIR_Y = {1, -1, 0, 0, 1, 1, -1, -1};
	private static final int SIZE = 140;

	public static void main(String[] args) {
		File file = new File(System.getProperty("user.dir") + "\\src\\input04.txt");
		
		try {
			Scanner sc = new Scanner(file);
			int lineCounter = 0;
			char[][] input = new char[SIZE][SIZE];
		
			while (sc.hasNextLine())
				input[lineCounter++] = sc.nextLine().toCharArray();
			
			//part1(input);
			part2(input);
			
			sc.close();
		} catch (Exception e) {
			System.out.println("EXCEPTION!");
			e.printStackTrace();
		}
	}
	
	private static void part1(char[][] input) {
		int result = 0;
		final String TARGET = "XMAS";
		
		for (int i = 0; i < SIZE; i++) 
            for (int j = 0; j < SIZE; j++)
            	for (int dir = 0; dir < 8; dir++) 
            		if (checkForXmas(input, i, j, dir, TARGET)) 
            			result++;
		
		System.out.println("result: " + result);
	}
	
	private static boolean checkForXmas(char[][] grid, int x, int y, int dir, String TARGET) {
		for (int k = 0; k < TARGET.length(); k++) {
            if (x < 0 || x >= SIZE || y < 0 || y >= SIZE || grid[x][y] != TARGET.charAt(k))
                return false;
            
            x += DIR_X[dir]; 
            y += DIR_Y[dir]; 
        }
        
        return true;
	}
	
	private static void part2(char[][] input) {
		int result = 0;
		
		for (int i = 1; i < SIZE - 1; i++) 
            for (int j = 1; j < SIZE - 1; j++)
            	if (input[i][j] == 'A' && checkForMasmas(input, i, j)) 
            		result++;
		
		System.out.println("result: " + result);
	}
	
	private static boolean checkForMasmas(char[][] grid, int x, int y) {
		char topLeft = grid[x-1][y-1];
		char bottomLeft = grid[x-1][y+1];
		char topRight = grid[x+1][y-1];
		char bottomRight = grid[x+1][y+1];
		
		return (!((topLeft != 'M' && topLeft != 'S') ||
				(bottomLeft != 'M' && bottomLeft != 'S') ||
				(topRight != 'M' && topRight != 'S') ||
				(bottomRight != 'M' && bottomRight != 'S')) 
				&& (topLeft != bottomRight && topRight != bottomLeft));
	}
	
}
