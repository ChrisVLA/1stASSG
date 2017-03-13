
import java.util.NoSuchElementException;

public class ThiseasMain {
	int line = 0;
	int pos = 0;

	public ThiseasMain(String[][] mazeR, int lines, int poss) {//the data read in text are passed to this class

		{

			String[][] maze = new String[lines][poss];

			for (int i = 0; i < lines; i++) {
				for (int j = 0; j < poss; j++) {
					if (mazeR[i][j].equals("E")) {
						maze[i][j] = "E";
						pos = j;
						line = i;
					} else if (mazeR[i][j].equals("1")) {
						maze[i][j] = "1";
					} else
						maze[i][j] = "0";
				}
			}
			//copying the array
			
			check checkMaze = new check();
			int back = 0;

			checkMaze.l = lines;
			checkMaze.p = poss;
			checkMaze.Eline = line;
			checkMaze.Epos = pos;//passing number of lines and columns and the position of E
			String topStr = "";//String on top of the stack
			int Strline = 0;
			int Strpos = 0;//items on top of the stack
			String peekStr = "";
			String BigE = checkMaze.Eline + "," + checkMaze.Epos;
			int timesOfE = 0;

			while (true) {

				back = 0;
				if (checkMaze.checkMaze(line, pos, maze)) {//check if backtrack is needed
					
					back++;
				} else {//end of the program
					
					printMaze(maze, lines, poss);
					checkMaze.mazenode.printStack(System.out);
					try {
						if (checkMaze.mazenode.peek().equals(checkMaze.Eline + "," + checkMaze.Epos)) {
							System.out.println("No solution");
						}

						else {
							System.out.println("final position : " + checkMaze.mazenode.peek());
						}
					} catch (NoSuchElementException e) {
						System.out.println("No solution");
					}
					break;
				}

				
				if (back != 0) {//in case of backtrack
					
					if (checkMaze.mazenode.isEmpty()) {
						System.out.println("No solution");
					
						break;
					} else {
						

						if (!checkMaze.mazenode.peek().equals(BigE)) {//marking the path 

							topStr = checkMaze.mazenode.pop();
							peekStr = checkMaze.mazenode.peek();

							Strline = Integer.parseInt(topStr.substring(0, 1));
							Strpos = Integer.parseInt(topStr.substring(2, 3));
							line = Integer.parseInt(topStr.substring(0, 1));
							pos = Integer.parseInt(topStr.substring(2, 3));
							maze[Strline][Strpos] = "2";
						} else {//if path returns to E a new stack is created


							line = checkMaze.Eline;
							pos = checkMaze.Epos;
						}

					}

				}
				if (checkMaze.mazenode.peek().equals(checkMaze.Eline + "," + checkMaze.Epos)) {//number of returns to start

					timesOfE++;
				}
				if (timesOfE > 10) {
					System.out.println("No Solution");
					break;
				}

			}

		}

	}

	public static void printMaze(String[][] maze, int lines, int poss) {//print the array
		for (int i = 0; i < lines; i++) {
			for (int j = 0; j < poss; j++) {
				System.out.print(maze[i][j]);
			}
			System.out.println();
		}
	}

}
