/* _   _       _       _             _   _                   _   _   ___     _                   ______                        ____________ _____ 
| | | |     (_)     | |           | | (_)                 | | | | / (_)   | |                  |  _  \                       | ___ \ ___ \  __ \
| | | |_ __  _ _ __ | |_ ___ _ __ | |_ _  ___  _ __   __ _| | | |/ / _  __| |_ __   ___ _   _  | | | |___  _ __   ___  _ __  | |_/ / |_/ / |  \/
| | | | '_ \| | '_ \| __/ _ \ '_ \| __| |/ _ \| '_ \ / _` | | |    \| |/ _` | '_ \ / _ \ | | | | | | / _ \| '_ \ / _ \| '__| |    /|  __/| | __ 
| |_| | | | | | | | | ||  __/ | | | |_| | (_) | | | | (_| | | | |\  \ | (_| | | | |  __/ |_| | | |/ / (_) | | | | (_) | |    | |\ \| |   | |_\ \
 \___/|_| |_|_|_| |_|\__\___|_| |_|\__|_|\___/|_| |_|\__,_|_| \_| \_/_|\__,_|_| |_|\___|\__, | |___/ \___/|_| |_|\___/|_|    \_| \_\_|    \____/
                                                                                         __/ |                                                  
                                                                                        |___/ */ 






import java.util.Scanner;
public class escapeTheRoomMain 
{
	static Scanner input = new Scanner (System.in);
	public static void main (String args [])
	{
		String [][] roomArray = new String[7][7];
		
		Character player = new Character();
		player.setLocationX(2);
		player.setLocationY(4);
		char choice;
		
		setCharacterName(player);
		gameStorySetup(player);
		
		boolean gameComplete = false;
		
		while (gameComplete == false)
		{
			System.out.println("What would you like to do? H for Help: ");
			choice = input.next().toUpperCase().charAt(0);
			
			if (choice == 'I')
			{
				player.viewInventory();
			}
			else if (choice =='M')
			{
				createBoard(roomArray, player);
				moveCharacter(roomArray, player);
			}
			else if (choice == 'H')
			{
				System.out.println( "M to move\n"
						+ "I to view Inventory\n"
						+ "S to view Stats\n"
						+ "X to Investigate\n"
						+ "M to view Map");
			}
			else if (choice == 'S')
			{
				System.out.println("Stamina: " + player.getStamina() +
						"\nKnowlegde: " + player.getKnowledge() );
			}
			else if (choice == 'X')
			{
				investigateArea(player, roomArray);				
			}
			else if (choice == 'M')
			{
				drawRoom();
			}
			System.out.println("");
		}
			
	}
	
	public static void investigateArea (Character player, String [][] roomArray)
	{
		int y = player.getLocationY();
		int x = player.getLocationX();
		char investigate;
		int investigateAgain = 1;
		char direction;
		
		
		while (investigateAgain == 1)
		{
			createBoard(roomArray, player);
			System.out.println("Which direction do you want to investigate? U, D, L, R: ");
			direction = input.next().toUpperCase().charAt(0);
			//Investigate Up
			if (direction == 'U')
			{
				if (roomArray[y-1][x] != " ")
				{
					System.out.println("You see something. Investigate? Y/N: ");
					investigate = input.next().toUpperCase().charAt(0);
					
					if (investigate == 'Y')
					{
						char item = roomArray[y-1][x].charAt(0);
						investigateItem(player, item);
						investigateAgain = 2;
						
					}
					else
					{
						investigateAgain = 2;
					}
					
				}
				else
				{
					System.out.println("There is nothing there to investigate. Pick another direction.");
					investigateAgain = 1;
				}
			}
			
			//Investigate Down
			if (direction == 'D')
			{
				if (roomArray[y+1][x] != " ")
				{
					System.out.println("You see a something. Investigate? Y/N: ");
					investigate = input.next().toUpperCase().charAt(0);
					
					if (investigate == 'Y')
					{
						char item = roomArray[y+1][x].charAt(0);
						investigateItem(player, item);
						investigateAgain = 2;
						
					}
					else
					{
						investigateAgain = 2;
					}
					
				}
				else
				{
					System.out.println("There is nothing there to investigate. Pick another direction.");
					investigateAgain = 1;
				}
			}
			
			//Investigate to Right
			if (direction == 'R')
			{
				if (roomArray[y][x+1] != " ")
				{
					System.out.println("You see a something. Investigate? Y/N: ");
					investigate = input.next().toUpperCase().charAt(0);
					
					if (investigate == 'Y')
					{
						char item = roomArray[y][x+1].charAt(0);
						investigateItem(player, item);
						investigateAgain = 2;
						
					}
					else
					{
						investigateAgain = 2;
					}
					
				}
				else
				{
					System.out.println("There is nothing there to investigate. Pick another direction.");
					investigateAgain = 1;
				}
			}
			
			//Investigate to Left
			if (direction == 'L')
			{
				if (roomArray[y][x-1] != " ")
				{
					System.out.println("You see a something. Investigate? Y/N: ");
					investigate = input.next().toUpperCase().charAt(0);
					
					if (investigate == 'Y')
					{
						char item = roomArray[y][x-1].charAt(0);
						investigateItem(player, item);
						investigateAgain = 2;
						
					}
					else
					{
						investigateAgain = 2;
					}
					
				}
				else
				{
					System.out.println("There is nothing there to investigate. Pick another direction.");
					investigateAgain = 1;
				}
			}
		}
		
	}
	
	public static void investigateItem (Character player, char item)
	{
		switch(item)
		{
			case 'S': System.out.println("You see a bookshelf in front of you. It is a basic bookshelf, it looks like something\n"
					+ "You could buy at an Ikea. There are a few books strewn among the shelves. Upon closer investigation, you\n"
					+ "see an instructional pamphlet on how to set up and disarm a mousetrap, a book called 'Java for Dummies'"
					+ ", and a cookbook. The pages of the cookbook are so faded that you cannot read them, and you're not sure\n"
					+ "why anyone would want a book called 'Java for Dummies'" ); 
					System.out.println("Would you like to investigate the pamphlet (enter P) or the Java book (J)?");
					item = input.next().toUpperCase().charAt(0);
					investigateItem(player, item);
					System.out.println("Would you like to investigate the pamphlet (enter P) or the Java book (J)?");
					item = input.next().toUpperCase().charAt(0);
					investigateItem(player, item);
					System.out.println("After you investiage the books, you notice that the bookshelf is slightly askew. \n"
							+ "Do you want to try and move the bookshelf? Y/N: ");
					char moveBS = input.next().toUpperCase().charAt(0);
					if (moveBS == 'Y')
					{
						if (player.getStamina() < 7)
						{
							System.out.println("You do not have enough stamina to move the bookshelf. Try to find something\n"
									+ "to eat in order to increase your stamina.");
						}
						else
						{
							investigateItem(player, 'C');
						}
				
					}
					break;
			case 'B': System.out.println("The bed in front of you appears to be a normal bed. It has a scratchy old wool blanket \n"
					+ "and sheets that look like something your Grandma would have bought from a thrift store. There is a lumpy \n"
					+ "excuse for a pillow at the top of the bed. Would you like to look under the bed? Y/N: " );
					char underBed = input.next().toUpperCase().charAt(0);
					investigateItem(player, 'M');
					break;
			case 'N': System.out.println("The nightstand is simple, and surprisingly solid. There is a single drawer and an \n"
					+ "old blue lamp with a large crack in it on top of the desk. You open the drawer and you see a piece of paper\n"
					+ "with the number '0800' on it. The code has been added to your inventory." );
					Items code0800 = new Items();
					code0800.setName("0800");
					player.addItem(2, code0800);
					break;
			case 'D': System.out.println("The desk in front of you is little more than a shabby table with an ancient computer \n"
					+ "sitting on top of it. The computer is one you haven't seen since you were a kid - it takes up nearly\n"
					+ "the entire desk. Would you like to look at the computer (Q), or look under the desk (U)");
					char compOrDesk = input.next().toUpperCase().charAt(0);
					investigateItem(player, compOrDesk);
					break;
			case 'E': System.out.println("There is a solid oak door in front of you. You jiggle the handle, but it is locked\n"
					+ "The door itself is quite solid, and after you bump your shoulder against it a few times, you realize\n"
					+ "you will not be able to break it down." );break;
			case 'T': System.out.println("The trashcan in front of you is nearly empty except for a couple sheets of blank paper.\n"
					+ "You move the sheets of paper out of the way, you see a half-eaten chocolate bar. You eat the candy bar,"
					+ "and your stamina increases by 1!." );
					player.setStamina(player.getStamina()+1);
					break;
			case 'J': System.out.println("You are holding a book about how to program in Java. It seems very complicated \n"
					+ "and you're not sure why anyone would subject themselves to studying it."); break;
			case 'P': System.out.println("The pamphlet is an informational pamphlet on how to disarm a mousetrap. After studying it\n"
					+ "you are confident you could disarm any mousetrap you come across. Your knowledge has increased by 1!"); 
					player.setKnowledge(player.getKnowledge()+1);  break;
			case 'C': System.out.println("There is a code behind the bookshelf. It says 7000. This code has been added to your\n"
					+ "inventory.");
					Items code7000 = new Items();
					code7000.setName("7000");
					player.addItem(3, code7000);
					break;
			case 'Q': System.out.println("The computer is ancient. A thick covering of dust mostly obscures the screen, but you can\n"
					+ "read that it is asking for a 4 letter unlock code. Do you want to enter a code? Y/N: ");
					char enterCode = input.next().toUpperCase().charAt(0);
					if (enterCode == 'Y')
					{
						enterCodeComputer();
					}
					break;
			case 'U': System.out.println("You look under the desk, and scratched into the old wood is a another 4 letter code, 0009\n"
					+ "This code has been added to your inventory");
					Items code0009 = new Items();
					code0009.setName("0009");
					player.addItem(4, code0009);
					break;
		case 'M':
			if (player.getKnowledge() < 1) 
			{
				System.out.println(
						"You look under the bed, and you see a sophisticated mousetrap. You don't think you'll\n"
								+ "be able to disarm it without knowing more about it. There is a large piece of cheese in the moustrap.\n"
								+ "It looks tasty.");
			} 
			else 
			{
				System.out.println("Since you read the book to disarm the moustrap, you successfully disarm it and get the cheese.\n"
						+ "Your stamina increases by 1!");
				player.setStamina(player.getStamina()+1);
			}
			break;

			case '|': System.out.println("It's definitely a wall." );break;
			case'_': System.out.println("It's absolutely, for sure, a wall." );break;
			default: break;
		}
	}
	
	public static void enterCodeComputer ()
	{
		int code;
		System.out.println("Enter the code: ");
		code = input.nextInt();
		int enterCode = 1;
		do
		{
			
			if (code == 7819 )
			{
				System.out.println("The computer beeps quietly, and you hear a soft 'click' coming from the direction of the door."
						+ "You walk over to the door and try to open it. The handle turns beneath your hand and the door swings open."
						+ "You made it out. Good job!");
				enterCode = 2;
			}
			else
			{
				System.out.println("The code is incorrect, would you like to try again? 1 for Yes, 2 for No.");
				enterCode = input.nextInt();
				
			}
		}while (enterCode == 1);
		
	}
	
	public static void moveCharacter(String[][]roomArray, Character player)
	{
		int moveAgain =1;
		char move;
		while (moveAgain ==1)
		{
			System.out.println("Where do you want to move? Type U, D, L, R (2 to stop moving)");
			move = input.next().toUpperCase().charAt(0);
			
			if (move == 'U' && roomArray[player.getLocationY()-1][player.getLocationX()]== " ") 
			{
				player.setLocationY(player.getLocationY()-1);
			}
			else if (move == 'L' && roomArray[player.getLocationY()][player.getLocationX()-1] == " ")
			{
				player.setLocationX(player.getLocationX()-1);
			}
			else if (move == 'D' && roomArray[player.getLocationY()+1][player.getLocationX()] == " ")
			{
				player.setLocationY(player.getLocationY()+1);
			}
			else if (move == 'R' && roomArray[player.getLocationY()][player.getLocationX()+1]== " ")
			{
				player.setLocationX(player.getLocationX()+1);
			}
			else if (move=='2')
			{
				moveAgain=2;
			}
			else
			{
				System.out.println("You cannot move there.\n");
			}
			createBoard(roomArray, player);	
		}
		
	}
	

	public static void createBoard(String [][] roomArray, Character player)
	{
		int count = 1;
		for (int i =0; i < 7; i++)
		{
			for (int j = 0; j < 7; j++)
			{
	
					roomArray[i][j] = " ";
			}
		}
		
		for (int j = 0; j<7;j++)
		{
			roomArray[j][0] = "|";
		}
		for (int i = 0; i<7; i++)
		{
			roomArray[0][i] = "_";
		}
		
		
		roomArray[6][0] = "_";
		roomArray[6][1] = "_";
		roomArray[6][2] = "_";
		roomArray[6][3] = "_";
		roomArray[6][4] = "_";
		roomArray[6][5] = "_";
		roomArray[6][6] = "_";
		
		roomArray[1][6] = "|";
		roomArray[2][6] = "|";
		roomArray[3][6] = "|";
		roomArray[4][6] = "|";
		roomArray[5][6] = "|";
		
		roomArray[2][1] = "S";
		roomArray[4][1] = "N";
		roomArray[5][1] = "B";
		roomArray[5][2] = "B";
		roomArray[0][3] = "E";
		roomArray[2][5] = "D";
		roomArray[3][5] = "D";
		roomArray[4][5] = "T";
		roomArray[player.getLocationY()][player.getLocationX()] = "♥";
		
		
		count = 1;
		for (int i = 0; i < 7; i++)
		{
			for (int j = 0; j < 7; j++)
			{
				for (int k = 0; k <1; k++)
				{
					System.out.print( "[ "+roomArray[i][j] + " ]" );
				}
				if (j%6==0 && j!=0)
				{
					System.out.println("");
				}
			
			}
		}
	}
	
	public static void drawRoom ()
	{
		
		System.out.println("_________________________________________________________________________________");
		System.out.println("|                                    |__________|                                |");
		System.out.println("|                                        Door                                    |");
		System.out.println("|                                                                                |");
		System.out.println("|___                                                                             |");
		System.out.println("|   |                                                                            |");
		System.out.println("|   |                                                                            |");
		System.out.println("|BS |                                                                      ______|");
		System.out.println("|   |                                                                     | Desk |");
		System.out.println("|___|                                                                     |      |");
		System.out.println("|                                                                         |----  |");
		System.out.println("|                                                                         || C | |");
		System.out.println("|                                                                         |----  |");
		System.out.println("|                                                                         |______|");
		System.out.println("|                                                                      TC --->(_)|");
		System.out.println("|                                                                                |");
		System.out.println("|________                                                                        |");
		System.out.println("|       |                                                                        |");
		System.out.println("|  NS   |                                                                        |");
		System.out.println("|_______|________                                                                |");
		System.out.println("|               |                                                                |");
		System.out.println("|      Bed      |                                                                |");
		System.out.println("|_______________|________________________________________________________________|");
		System.out.println("C = Computer, NS = Night stand, BS = Bookshelf, TC = Trash Can");
		System.out.println(" ");
	}
	
	public static void setCharacterName(Character player)
	{
		
		String name;
		int chooseName = 2;
		
		while (chooseName == 2)
		{
			System.out.println("What is your name?");
			name = input.next();
			player.setName(name);
			
			System.out.println("You have chosen " + player.getName() + " as your name. Is this okay?");
			System.out.println("Enter 1 to accept the name, or 2 to choose a new name. ");
			chooseName = input.nextInt();
		}
		
	}//end setCharacterName
	
	public static void setCharacterStats(Character player)
	{
		player.setKnowledge(0);
		player.setStamina(5);
		
		System.out.println("You have " + player.getKnowledge() + " knowledge, and " + player.getStamina() + " stamina.");
	}//end setCharacterStats
	
	public static void gameStorySetup (Character player )
	{
		player.fillInventory();
		System.out.println("You wake up in a dark room. You don't recognize the room. You sit up, and\n"
				+ "find yourself sitting in a sparse bed covered with a scratchy brown blanket that looks like it \n"
				+ "belongs in a World War II museum. You try to remember how you got here, but the last thing\n"
				+ "you remember is walking out the door of your house to go to work. You are wearing the same clothes \n"
				+ "That you remember putting on that morning (if it is still the same day). You can't tell - there are\n"
				+ "no windows in the room. You look around, but you can't see a lot of details, only that you're sitting \n"
				+ "in a twin size bed. The only other thing in the room you can see is a small end table next to you, \n"
				+ "on which there is a note addressed to you. It says:  " + player.getName() + ", I'm sorry to leave you\n"
				+ "here with no explanation, but I didn't have any other choice. I know you'll find your way out. -H.\n"
				+ "You flip the note over to the other side, and see a number '0010. This code has been added to your inventory.'\n"
				+ "You wrack your brain, but you can't remember if you know anyone who's name starts with 'H'. Hell, \n"
				+ "with how your head feels right now, you're surprised you even managed to recall your own name. \n"
				+ "You realize you're starving, and decide to search the room to see if you can find any food. \n"
				+ "The note has been added to your inventory.\n");
		
		Items letter = new Items();
		letter.setName("Letter from H");
		
		Items code0010 = new Items();
		code0010.setName("0010");
		
		player.addItem(0,letter);
		player.addItem(1, code0010);
	
	}//gameStorySetup
	
}//end Main
