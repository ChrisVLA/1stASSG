import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.NoSuchElementException;

public class Reader {
	public Reader(String args[]) {
		

		{

			File file = new File(args[0]);
			String check="";
			int k = 0;//variable for array mazechecker
			int Es = 0;//number of Es found
			int permL = 0;
			int permP = 0;
			String[][] mazeR = null;
			int line = 0;
			int pos = 0;
			int Eline = 0;
			int Epos = 0;
			try {//entering file
				Scanner in = new Scanner(file);

				System.out.println("File open successful");

				while (in.hasNextLine()) {//reading the variables given in text
					try {
						line = in.nextInt();
						pos = in.nextInt();
						System.out.println(line + " " + pos);
						Eline = in.nextInt();
						Epos = in.nextInt();
						System.out.println(Eline + " " + Epos);
						mazeR = new String[line][pos];

						String[] mazeChecker = new String[line * pos];//helpful array to check the  array given
						/////////////////////////////// inserting items
						try {
							for (int i = 0; i < line; i++) {//reading numbers
								for (int j = 0; j < pos; j++) {
									mazeR[i][j] = in.next();
									mazeChecker[k] = mazeR[i][j];
									k++;

								}
							}

							for (int i = 0; i < line; i++) {
								for (int j = 0; j < pos; j++) {
									try {
										System.out.print(mazeR[i][j]);
									} // end of try4(insert elements in array)
									catch (java.lang.ArrayIndexOutOfBoundsException e) {
										System.out.println("Input Error. Error in array.");
										System.exit(0);
									} // catch4
								}
								System.out.println();
							}
							////////////////////////////////////// Checking numbers of E
							for (int i = 0; i < line * pos; i++) {
								if (mazeChecker[i].equals("E")) {
									Es++;

								}
							}

							if (Es != 1) {
								System.out.println("Input Error. Error in entrance.");
								System.exit(0);
							}
							////////////////////////////////// checking E position and input
							for (int i = 0; i < line; i++) {
								for (int j = 0; j < pos; j++) {
									if (mazeR[i][j].equals("E")) {
										permL = i;
										permP = j;
									}
									if (!mazeR[i][j].equals("1") && !mazeR[i][j].equals("0")&& !mazeR[i][j].equals("E")) {
										System.out.println("Input Error. Error in elements.");
										System.exit(0);
									}
								}

							}
							if (permL != Eline || permP != Epos) {
								System.out.println("Input Error. Error in entrance.");
								System.exit(0);
							}

							////////////////////////////////////////////

						} // end of try2(reading elements)
						catch (java.util.NoSuchElementException e) {
							System.out.println("Input Error.");
							System.exit(0);
						} // catch2
					} // end of try3(first inputs
					catch (java.util.InputMismatchException e) {
						System.out.println("Input Error.Invalid expresion");
						System.exit(0);
					} // end catch3
					break;
				} // end of lines in txt
				try{
				if(in.next()!=null){
					System.out.println("Input Error.Error in elements.");
					System.err.println("Adjustments in array will be made");
					
				}}
				catch(java.util.NoSuchElementException e){
					
				}
				
				
				System.out.println("read successfull");

				ThiseasMain main = new ThiseasMain(mazeR, line, pos);//call the rest of the program

				in.close();

			} // end of try1(reading file)
			catch (IOException e) {
				System.out.println("Error opening file");
			} // catch1

		}
	}
}
