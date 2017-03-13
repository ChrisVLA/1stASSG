
public class check {
	public check() {
	}

	StackNode mazenode = new StackNode();
	int Eline;
	int Epos;
	int l;
	int p;

	public boolean checkMaze(int line, int pos, String[][] maze) {
		

		if (line == Eline && Epos == pos) {

			StackNode mazenode = new StackNode();//creates a new stack every time the program returns to E
		}

		while (true) {
			maze[Eline][Epos] = "E";
			if (line - 1 >= 0 && maze[line - 1][pos] == "0") {//check up
				node(line + "," + pos);

				maze[line][pos] = "2";

				line--;

			} else if (pos + 1 != p && maze[line][pos + 1] == "0") {//check right
				node(line + "," + pos);
				maze[line][pos] = "2";

				pos++;

			} else if (line + 1 != l && maze[line + 1][pos] == "0") {//check down
				node(line + "," + pos);
				maze[line][pos] = "2";

				line++;

			}

			else if (pos - 1 >= 0 && maze[line][pos - 1] == "0") {//check left
				node(line + "," + pos);
				maze[line][pos] = "2";

				pos--;

			} else {//the path taken is now marked with 2 instead of 0
				if (maze[line][pos] == "0") {
					maze[line][pos] = "2";
					node(line + "," + pos);
				}

				break;
			}

		}
		if (line + 1 == l || pos + 1 == p || line == 0 || pos == 0) {//return true if the program is not finished yet
			return false;
		} else
			return true;

	}

	public void node(String str) {//insert in path Stack
		mazenode.push(str);
	}

}
