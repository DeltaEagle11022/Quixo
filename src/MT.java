import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;

/*Mrugank Upadhyay
  Quixo
  GUI Game
  FOR CLEARER INSTRUCTIONS VISIT: http://www.foxmind.co.il/uploads/70213732698722edfaf.pdf
  Additional Guidance can be found through Youtube videos that have tutorials about this game. 
  Remember, some of the physical world aspects of the game may not actually work or are unnecessary. For example, calling the winner (the game does that for you).
  Quick Tip (To make life easy): When playing, Enter X or O in the Text box when game starts or is reset. Click one of the Direction buttons: U, D, R, or L, then click a piece.
  *** READ INSTRUCTIONS THOROUGHLY AND VIEW FIGURE IN UPCOMING SCREEN
  Note: There is a picture called Fig.PNG that is handed in with this program. It needs to be placed in the same source code folder.*/

public class MT extends Applet implements ActionListener

{
	
	
	//Game Array
	JButton a1[][] = new JButton [5][5];
	//Title Array
	JButton Q1[] = new JButton[5];
	//Direction Buttons
	JButton up = new JButton ("U");
	JButton dw = new JButton ("D");
	JButton rt = new JButton ("R");
	JButton lt = new JButton ("L");
	JButton reset;
	JButton temp = new JButton();
	
	int x;
	int y;
	int turn = -1;
	int begin = 0;
	//ActionCommand Variable that has been Interger.parseInt
	int NACOM;
	int r = 0;
	
	//ActionCommand Variable
	String ACOM= "";
	
	//JPanels for Screens and CardLayout
	JPanel Main = new JPanel(new BorderLayout());
	JPanel Word = new JPanel (new BorderLayout());
	JPanel Buttons = new JPanel (new FlowLayout());
	JPanel Game = new JPanel (new GridLayout(5,5));
	JPanel cards, card1, card2, card3, card4, NXT;
	CardLayout CD = new CardLayout();
	
	//Win Checker and Password
	boolean Win = false;
	boolean Q,U,I,X,O = false;
	
	//If it is Players turn but they choose opponents piece, this variable will not allow them to move it.
	boolean cheater = false;
	
	public void init()
	{
		cards = new JPanel();
		cards.setLayout(CD);
		cards.setPreferredSize(new Dimension(500,580));
		Screen1();
		Screen2();
		Screen3();
		Screen4();
		add(cards);
	}
	
	//Title Screen. To Unlock: click on Quixo.
	public void Screen1()
	{
		 card1 = new JPanel();
		 card1.setLayout(new BorderLayout());
		 card1.setBackground(new Color (235, 172, 92));
		 
		 //Panels used to Center the Text/Buttons
		 NXT = new JPanel();
		 NXT.setPreferredSize(new Dimension(400,400));
		 NXT.setOpaque(false);
		 JPanel NXT1 = new JPanel();
		 NXT1.setPreferredSize(new Dimension(400,250));
		 NXT1.setOpaque(false);
		 JPanel NXT2 = new JPanel();
		 NXT2.setPreferredSize(new Dimension(400,100));
		 NXT2.setOpaque(false);
		 
		 //Title Buttons
		 Q1[0] = new JButton ("Q");
		 Q1[0].setActionCommand("Q");
		 Q1[1] = new JButton ("U");
		 Q1[1].setActionCommand("U");
		 Q1[2] = new JButton ("I");
		 Q1[2].setActionCommand("I");
		 Q1[3] = new JButton ("X");
		 Q1[3].setActionCommand("X");
		 Q1[4] = new JButton ("O");
		 Q1[4].setActionCommand("O");
		 
		 //Next Button for Screen 1
		 JButton Next = new JButton ("Next");
		 Next.setActionCommand("NextButton");
		 Next.addActionListener(this);
		 Next.setForeground(new Color(235, 172, 92));
		 Next.setBackground(Color.black);
		 Next.setPreferredSize(new Dimension(80,60));
		 Next.setFont(new Font(("Harlow Solid Italic"), Font.PLAIN, 50));
		 
		 for (int i = 0; i < 5; i++)
		 {
			Q1[i].addActionListener(this);
			Q1[i].setFont( new Font (("Harlow Solid Italic"), Font.PLAIN, 60));
			
			//Make Button Invisible (Transparent)
			Q1[i].setOpaque(false);
			Q1[i].setContentAreaFilled(false);
			Q1[i].setBorderPainted(false);
			
			Q1[i].setPreferredSize(new Dimension(95,95));
			NXT.add(Q1[i]);
		 }
		 
		 card1.add(NXT, BorderLayout.CENTER);
		 card1.add(NXT1, BorderLayout.PAGE_START);
		 card1.add(NXT2, BorderLayout.PAGE_END);
		 card1.add(Next, BorderLayout.PAGE_END);
		 cards.add (card1, "1");
		
	}
	
	//Instructions Screen
	public void Screen2()
	{
		card2 = new JPanel();
		card2.setLayout(new BorderLayout());
		JLabel Title = new JLabel ("Instructions", SwingConstants.CENTER);
		
		//RULES OF THE GAME. Use of html tags to have multiple lines in 1 JLabel. Used <br> to add line breaks. <center> is used to center text. <i> is to italicize. Figures are shown in next Screen.
		JLabel Instructions = new JLabel("<html><center>RULES FOR TWO PLAYERS</center><br><br><center><i>HOW TO PLAY</i></center><br><br> "
				+"<center> In turns, each player chooses a cube and moves "
				+"it according to the following rules.<br> In no event can a player miss his/her turn. Choosing and taking a cube:<br> The player "
				+"chooses and takes a blank cube, or one with his/her symbol on it, from the board’s periphery (<i>fig. 3</i>).<br> In the first round, "
				+ "the players have no choice but to take a blank cube. You are not allowed to take a cube bearing your opponent’s symbol.<br><br> "
				+ "Changing the cube symbol: <br>Whether the cube taken is blank or already bears the player’s symbol, it must always be replaced by a cube <br>"
				+ "with the player’s symbol on the top face. Replacing the cube: <br>The player can choose at which end of the incomplete rows made when a cube is taken, "
				+ "the cube is to be replaced; he/she pushes this end to replace the cube. <br>You can never replace the cube just played back in the position from "
				+ "which it was taken. <i>Fig. 4:</i> cube can be replaced on the board by pushing <i>A, B or C</i>. <br><br><i>END OF GAME:</i> "
				+"The winner is the player to make and announce that he/she has made a horizontal, vertical or diagonal line with 5 cubes bearing his/her symbol.<br> "
				+"The player to make a line with his/her opponent’s symbol loses the game, even if he/she makes a line with his/her own symbol at the same time.</center></html>");
		
		JButton next = new JButton ("Next");
		next.setActionCommand ("CTHREE");
		next.addActionListener (this);
		next.setForeground(new Color(235, 172, 92));
		next.setBackground(Color.black);
		next.setPreferredSize(new Dimension(80,60));
		next.setFont(new Font(("Harlow Solid Italic"), Font.PLAIN, 50));
		card2.add (Title, BorderLayout.PAGE_START);
		card2.add (Instructions, BorderLayout.CENTER);
		card2.add (next, BorderLayout.PAGE_END);
		card2.setBackground(new Color(235, 172, 92));
		cards.add (card2, "2");
		 
	}
	
	public void Screen3()
	{
		card3 = new JPanel();
		
		//Sets the images as a button. BE CAREFUL WHEN VIEWING, IF YOU ACCIDENTLY CLICK, YOU MAY NEED TO RESTART IF YOU DID NOT FINISH LOOKING OVER THE IMAGE.
		JButton next = new JButton(Image("Fig.PNG"));
		next.addActionListener(this);
		next.setActionCommand("CFOUR");
		next.setContentAreaFilled(false);
		next.setBorderPainted(false);
		card3.add(next);
		cards.add(card3, "3");
	}
	
	protected static ImageIcon Image (String path)
	{
		//Searches for image
		java.net.URL imgURL = MT.class.getResource(path);
		if (imgURL != null)
		{
			return new ImageIcon (imgURL);
		}
		else
		{
			//If there is no file found, send error message
			System.err.println("File Missing: "+path);
			return null;
		}
	}
	
	public void Screen4()
	{
		card4 = new JPanel();
		card4.setLayout(new BorderLayout());
		
		JLabel character = new JLabel("Player 1 = X  & Player 2 = O", SwingConstants.CENTER);
		character.setFont(new Font(("Harlow Solid Italic"), Font.PLAIN, 20));
		//Reset Button wipes the board.
		reset = new JButton ("Reset");
		reset.setBackground(new Color(252,168,14));
		reset.setContentAreaFilled(false);
		reset.setBorderPainted(false);
		reset.addActionListener(this);
		reset.setActionCommand("Reset");
		reset.setFont(new Font(("Harlow Solid Italic"), Font.PLAIN, 20));
		reset.setPreferredSize(new Dimension(50,50));
		Word.add(character, BorderLayout.PAGE_START);
		Word.add(reset, BorderLayout.PAGE_END);
		
		up.addActionListener(this);
		up.setActionCommand("100");
		up.setPreferredSize(new Dimension(80,50));
		up.setFont(new Font(("Harlow Solid Italic"), Font.PLAIN, 24));
		up.setContentAreaFilled(false);
		up.setOpaque(false);
		
		up.setBorderPainted(false);
		dw.addActionListener(this);
		dw.setActionCommand("200");
		dw.setPreferredSize(new Dimension(80,50));
		dw.setFont(new Font(("Harlow Solid Italic"), Font.PLAIN, 20));
		dw.setContentAreaFilled(false);
		dw.setOpaque(false);
		dw.setBorderPainted(false);
		
		rt.addActionListener(this);
		rt.setActionCommand("300");
		rt.setPreferredSize(new Dimension(80,50));
		rt.setFont(new Font(("Harlow Solid Italic"), Font.PLAIN, 20));
		rt.setContentAreaFilled(false);
		rt.setOpaque(false);
		rt.setBorderPainted(false);
		
		lt.addActionListener(this);
		lt.setActionCommand("400");
		lt.setPreferredSize(new Dimension(80,50));
		lt.setFont(new Font(("Harlow Solid Italic"), Font.PLAIN, 20));
		lt.setContentAreaFilled(false);
		lt.setOpaque(false);
		lt.setBorderPainted(false);
		
		Buttons.add(up);
		Buttons.add(dw);
		Buttons.add(rt);
		Buttons.add(lt);
		
		//Creates the entire game array.
		for ( x = 0; x < 5; x++)
		{
			for ( y = 0; y < 5; y++)
			{
				a1[x][y] = new JButton("");
				a1[x][y].addActionListener(this);
				a1[x][y].setActionCommand(x+""+y+"");
				a1[x][y].setFont(new Font(("Harlow Solid Italic"), Font.PLAIN, 20));
				a1[x][y].setBackground(new Color(252,168,14));
				Game.add(a1[x][y]);
			}
		}
		
		//Sets interior 9 squares to be disabled.
		for (int z = 1; z < 4; z++)
		{
			for (int q = 1; q < 4; q++)
			{
				a1[z][q].setEnabled(false);
			}
		}
		Word.setBackground(new Color(252,168,14));
		Buttons.setBackground(new Color(252,168,14));
		Game.setBackground(new Color(252,168,14));
		Word.setPreferredSize(new Dimension (100, 100));
		Buttons.setPreferredSize(new Dimension (100, 70));
		Game.setPreferredSize(new Dimension (400, 400));
		Main.add(Word, BorderLayout.PAGE_START);
		Main.add(Buttons, BorderLayout.CENTER);
		Main.add(Game, BorderLayout.PAGE_END);
		card4.add(Main);
		resize(800, 600);
		cards.add(card4, "4");
	}
	
	public void actionPerformed(ActionEvent e)
		{
			//Security Checker. Only if all Q,U,I,X,O equal true will Screen 2 show.
			if (e.getActionCommand ().equals ("Q")){Q = true;} else if (e.getActionCommand ().equals ("U")){U = true;} else if (e.getActionCommand ().equals ("I")){I = true;} else if (e.getActionCommand ().equals ("X")){X = true;} else if (e.getActionCommand ().equals ("O")){O = true;}
		
			if ((Q && U && I && X && O == true) || (e.getActionCommand().equals("NextButton")))
				{
					CD.show (cards, "2");
					//To make sure that Screen 2 does not appear if a button in screen three is pressed. 
					Q = false;
					U = false;
					I = false;
					X = false;
					O = false;
				}
			
			//Screen 3 display
			if (e.getActionCommand ().equals ("CTHREE"))
				{ 
					CD.show (cards, "3");
				}
			//Screen 4 display
			if (e.getActionCommand ().equals ("CFOUR"))
			{ 
				CD.show (cards, "4");
			}
		
			ACOM = e.getActionCommand();
		
			//Checks if the string contains only numbers. If so, it moves on to converting it to Integer form.
			if (ACOM.matches(".*\\d+.*"))
				{
					NACOM = (Integer.parseInt(ACOM));	
				}
		
			if (ACOM.equals("Reset"))
				{
					for ( x = 0; x < 5; x++)
						{
							for ( y = 0; y < 5; y++)
								{
									a1[x][y].setText("");
									a1[x][y].setEnabled(true);
								}
						}
					begin = 0;
					Win = false;
					for (x = 1; x < 4; x++)
						{
							for (y = 1; y < 4; y++)
								{
									a1[x][y].setEnabled(false);
								}
						}
				}
			
			else
				{
				
				//Checks which direction button is clicked. Up = 100, Down = 200, Right = 300, and Left = 400. Accordingly, r is set.
					if (NACOM == 400)
						{
							r = 4;
						}
					if (r == 4)
						{
						/*These "if" statements check which row or column the movement should occur in, and acts as a restriction setting. For example, if movement is right in
						row 2, then it should go only to the end of row 2. It should not go into another row.*/
							if (NACOM < 10)
								{
									showStatus("Applet Started.");	
									/*If they click the direction's column or row, the piece cannot move. E.g. If Player clicks DOWN, 
									the bottom most row is off limits, since there is nothing below it, so it cannot move down.*/
									if (ACOM.equals("00"))
										{
											showStatus("False Move, Cannot Choose This Column");
											return;
										}
									else
										{
										//If not, then it checks whose turn it is and set the text of the button accordingly, then it moves it to the direction chosen.
											XorO();
											//The parameter sets which row or column it should move in.
											MoveRowLeft(0);
										}
								}	
							
							else if (NACOM > 04 && NACOM < 20)
								{
									showStatus("Applet Started.");
									if (ACOM.equals("10"))
										{
											showStatus("False Move, Cannot Choose This Column");
											return;
										}
									else
										{
											XorO();
											MoveRowLeft(1);
										}
								}
							
							else if (NACOM > 14 && NACOM < 30)
								{
									showStatus("Applet Started.");
										if (ACOM.equals("20"))
											{
												showStatus("False Move, Cannot Choose This Column");
												return;
											}
										else
											{
												XorO();
												MoveRowLeft(2);
											}
								}
							
							else if (NACOM > 24 && NACOM < 40)
								{
									showStatus("Applet Started.");
									if (ACOM.equals("30"))
										{
											showStatus("False Move, Cannot Choose This Column");
											return;
										}
									else
										{
											XorO();
											MoveRowLeft(3);
										}
								}
							
							else 
								{
									showStatus("Applet Started.");
									if (ACOM.equals("40"))
										{
											showStatus("False Move, Cannot Choose This Column");
											return;
										}
									else
										{
											XorO();
											MoveRowLeft(4);
										}
								}
						}
				
				if (r == 3)
					{
						if (NACOM < 10)
							{
								showStatus("Applet Started.");
								
								if (ACOM.equals("04"))
									{
										showStatus("False Move, Cannot Choose This Column");
										return;
									}
								else
									{
										XorO();
										MoveRowRight(0);
									}
							}
						
						else if (NACOM < 20)
							{
								showStatus("Applet Started.");
								
								if (ACOM.equals("14"))
									{
										showStatus("False Move, Cannot Choose This Column");
										return;
									}
								else
									{
										XorO();
										MoveRowRight(1);
									}
							}
					
						else if (NACOM > 14 && NACOM < 30)
							{
								showStatus("Applet Started.");
								
								if (ACOM.equals("24"))
									{
										showStatus("False Move, Cannot Choose This Column");
										return;
									}
								else
									{
										XorO();
										MoveRowRight(2);
									}
							}
						
						else if (NACOM > 24 && NACOM < 40)
							{
								showStatus("Applet Started.");
								
								if (ACOM.equals("34"))
									{
										showStatus("False Move, Cannot Choose This Column");
										return;
									}
								else
									{
										XorO();
										MoveRowRight(3);
									}
							}	
						
						else if (NACOM > 34 && NACOM < 50)
							{
								showStatus("Applet Started.");
									
								if (ACOM.equals("44"))
										{
											showStatus("False Move, Cannot Choose This Column");
											return;
										}
									else
										{
											XorO();
											MoveRowRight(4);
										}
							}	
					}
				
				if (NACOM == 300)
					{
						r = 3;
					}
		
				if (NACOM == 200)
					{
						r = 2;
					}
				
				if (r == 2)
					{
						for (int z = 0; z < 5; z++)
						{
							if (NACOM%10 == z)
							{
								showStatus("Applet Started.");
								
								if (ACOM.equals("4"+z+""))
									{
										showStatus("False Move, Cannot Choose This Row");
										return;
									}
								else
									{
										XorO();
										MoveColumnDown(z);
									}
							}	
						}
					}	
				
				if (NACOM == 100)
					{
						r = 1;
					}
				
				if (r == 1)
					{
					
						for (int z = 0; z < 5; z++)
						{
							if (NACOM%10 == z)
							{
								showStatus("Applet Started.");
								
								if (ACOM.equals("0"+z+""))
									{
										showStatus("False Move, Cannot Choose This Row");
										return;
									}
								else
									{	
										XorO();
										MoveColumnUp(z);
									}
							}
						}
				}
				}
			
			//Checks if there is a winner after every turn.
			Winner();
		}
	
	public void XorO()
		{
			for (x = 0; x < 5; x++)
				{
					for (y = 0; y < 5; y++)
						{
							if (ACOM.equals(x+""+y+""))
								{
									//If Player clicks on their own piece, it will move, but another "new" piece is not introduced. Then it is Opponents turn.
									if ((a1[x][y].getText().equals("X") &&turn%2==0)||(a1[x][y].getText().equals("O") && turn%2 == 1))
										{
											turn++;
											break;
										}
									//Checks if Player has clicked Opponent's piece. If so, cheater boolean is activated, and turn does not change.
									else if ((a1[x][y].getText().equals("X") && turn%2==1)||(a1[x][y].getText().equals("O") && turn%2 == 0))
									{
										cheater = true;
										break;
									}
									
									//If not any of that, Then it goes on to introducing a new piece.
									else
										{
										//If the game has just begun, or board has been reset, it takes the Symbol from the Text box as player 1.
											if (begin == 0)
												{
													turn = 0;
													begin++;
												}
											
											//Changes Turn
											if (turn%2 == 0)
												{
													a1[x][y].setText("X");
													turn++;
												}
						
											else if (turn%2 == 1)
												{
													a1[x][y].setText("O");
													turn++;
												}
										}
								}
						}
				}
		}
	
	//Moves Rows Left
	//The parameter n is to locate the row or column. This is set in the actionPerformed for the set parameters of maximum movement.
	public void MoveRowLeft (int n)
		{
		
		//When cheater activated, in the status bar, it informs the Player and then sets cheater to false. Ends the method.
		if (cheater == true)
		{
			showStatus("Not Your Symbol!");
			cheater = false;
			return;
		}
		/*If not, then it moves the button Left. i locks onto the ActionCommand of the button and mods by 5 so that it stays within the row. Then the loop moves every thing left.
		The left most button's value is transferred into a temporary variable, and the right most button gains temporary's value.*/
		else
		{
			for (int i = (Integer.parseInt(ACOM)%5); i > 0; i--)
				{
				temp.setText(a1[n][i].getText());
				a1[n][i].setText(a1[n][i-1].getText());
				a1[n][i-1].setText(temp.getText());
				}
		}
		}
	
	//Moves Rows Right. Similar to Left.
	public void MoveRowRight (int n)
		{
		if (cheater == true)
		{
			showStatus("Not Your Symbol!");
			cheater = false;
			return;
		}
		else
		{
			for (int i = Integer.parseInt(ACOM)%5; i < a1.length-1; i++)
				{
					temp.setText(a1[n][i].getText());
					a1[n][i].setText(a1[n][i+1].getText());
					a1[n][i+1].setText(temp.getText());
				}
		}
		}
	
	//Moves Columns Down
	public void MoveColumnDown (int n)
		{
		if (cheater == true)
		{
			showStatus("Not Your Symbol!");
			cheater = false;
			return;
		}
		else
		{
			//Unlike Left and Right, i is divided by 10 so that it only moves up or down
			for (int i = Integer.parseInt(ACOM)/10; i < 4; i++)
				{
					temp.setText(a1[i][n].getText());
					a1[i][n].setText(a1[i+1][n].getText());
					a1[i+1][n].setText(temp.getText());
				}
		}
		}
	
	//Moves Columns Up
	public void MoveColumnUp (int n)
		{
		if (cheater == true)
		{
			showStatus("Not Your Symbol!");
			cheater = false;
			return;
		}
		else
		{
			for (int i = Integer.parseInt(ACOM)/10; i > 0; i--)
				{
					temp.setText(a1[i][n].getText());
					a1[i][n].setText(a1[i-1][n].getText());
					a1[i-1][n].setText(temp.getText());
				}
		}
		}
		
	public void Winner()
		{
			for (int c = 0; c < 5; c++)
				{
				//Checks for Wins in rows
					if (((a1[c][0].getText()).equals("X") && (a1[c][1].getText()).equals("X") && (a1[c][2].getText()).equals("X")&& (a1[c][3].getText()).equals("X") && (a1[c][4].getText()).equals("X"))  || ((a1[c][0].getText()).equals("O") && (a1[c][1].getText()).equals("O") && (a1[c][2].getText()).equals("O")&& (a1[c][3].getText()).equals("O") && (a1[c][4].getText()).equals("O")))
						{
							showStatus(a1[c][0].getText()+" Won the Game");
							Win = true;
							break;
						}
					//Checks for Wins in Columns
					else if (((a1[0][c].getText()).equals("X") && (a1[1][c].getText()).equals("X") && (a1[2][c].getText()).equals("X")&& (a1[3][c].getText()).equals("X") && (a1[4][c].getText()).equals("X"))  || ((a1[0][c].getText()).equals("O") && (a1[1][c].getText()).equals("O") && (a1[2][c].getText()).equals("O")&& (a1[3][c].getText()).equals("O") && (a1[4][c].getText()).equals("O")))
						{
							showStatus(a1[0][c].getText()+" Won the Game");
							Win = true;
							break;
						}
					//Checks for Win in Diagonal
					else if (((a1[0][0].getText()).equals("X") && (a1[1][1].getText()).equals("X") && (a1[2][2].getText()).equals("X")&& (a1[3][3].getText()).equals("X") && (a1[4][4].getText()).equals("X"))  || ((a1[0][0].getText()).equals("O") && (a1[1][1].getText()).equals("O") && (a1[2][2].getText()).equals("O")&& (a1[3][3].getText()).equals("O") && (a1[4][4].getText()).equals("O")))
						{
							showStatus(a1[0][0].getText()+" Won the Game");
							Win = true;
							break;
						}
					//Checks for Win in Backward Diagonal
					else if (((a1[4][0].getText()).equals("X") && (a1[3][1].getText()).equals("X") && (a1[2][2].getText()).equals("X")&& (a1[1][3].getText()).equals("X") && (a1[0][4].getText()).equals("X"))  || ((a1[4][0].getText()).equals("O") && (a1[3][1].getText()).equals("O") && (a1[2][2].getText()).equals("O")&& (a1[1][3].getText()).equals("O") && (a1[0][4].getText()).equals("O")))
						{
							showStatus(a1[4][0].getText()+" Won the Game");
							Win = true;
							break;
						}
				}
			
			//When win is confirmed, the board is disabled until it is reset.
			if (Win == true)
				{
					for (x = 0; x < 5; x++)
						{
							for (y = 0; y < 5; y++)
								{
									a1[x][y].setEnabled(false);
								}
						}
				}
		}
}