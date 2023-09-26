package projects;
 import java.util.Scanner;
 import java.util.*;
 class EmptyOceanMap
 {
	  int i,j,x,y,k;
	  String arr[][]=new String[10][10];
	  public static int pscore=5,cscore=5;
	  Scanner sc=new Scanner(System.in);
	  //create empty ocean
	 
	 public  void printEmpty()
	 {
		 System.out.print("   0123456789");
		 System.out.println();
		 for(int i=0;i<arr.length;i++)
	     {
	        	System.out.print(i+" |");
	            for(int j=0;j<arr[i].length;j++)
	            {
	            	if(arr[i][j]==null)
	            	{
	            		arr[i][j]=" ";
	            		System.out.print(arr[i][j]);
	            	}
	            	else
	            	{
	            		System.out.print(arr[i][j]);
	            	}
	            }
	            System.out.println("| "+i);
	      }
		 System.out.print("   0123456789");
		 System.out.println();
		
	 }
 
//deploy players ship 
	 
	 public  void playerShips()
	 {

		 int k;
		 
		 for(k=0;k<5;k++)
		 {
			 System.out.println("enter x co-ordinate");
			 x=sc.nextInt();
			 System.out.println("enter y co-ordinate");
			 y=sc.nextInt();
			 arr[x][y]="@";
		 }
		 printEmpty();
		
	 }	 
//deploy computers ship
	 public void computersShip()
	 {
		 System.out.println(" Computer is deploying ships");
		 int k;
		 for(k=0;k<5;k++)
		 {
			x=(int)(Math.random()*10);
			y=(int)(Math.random()*10);
			
			if((x>=0&&x<10) && (y>=0&&y<10) &&arr[x][y]==" ")
			{
				arr[x][y]="x";
			}
			else if((x>=0&&x<10) && (y>=0&&y<10) && arr[x][y]=="@")
			{
				System.out.println("You cannot place two or more ships on the same location");
			}
			System.out.println("ship deployed");
		 }
		 printEmpty();
		 
	 }
	 //players turn
	 public void playersTurn()
	 {
		 
		 System.out.println("players turn");
		 System.out.println("enter x co-ordinate");
		 x=sc.nextInt();
		 System.out.println("enter y co-ordinate");
		 y=sc.nextInt();
		 if((x<0&&x>10)&&(y<0&&y<10))
		 {
			 System.out.println("You can't place outside the ocean");
		 }
		 else if(arr[x][y]=="x")
		 {
			 System.out.println( "Boom! You sunk the ship!");
			 arr[x][y]="!";
			 pscore++;
			 cscore--;
		 }
		 else if(arr[x][y]=="@")
		 {
			 System.out.println("Oh no, you sunk your own ship :(");
			 arr[x][y]="x";
			 pscore--;
		 }
		 else if(arr[x][y]==" ")
		 {
			 System.out.println("Sorry, you missed");
			 arr[x][y]="-";
		 }
		 printEmpty();
		 System.out.println("players score:"+pscore);
		 System.out.println("computers score:"+cscore);
	 }
	 public void computersTurn()
	 {
		 System.out.println("computers turn");
		 x=(int)(Math.random()*10);
		 System.out.println(x);
		 y=(int)(Math.random()*10);
		 System.out.println(y);
		 if((x<0&&x>10)&&(y<0&&y<10))
		 {
			 System.out.println("You can't place outside the ocean");
		 }
		 else if(arr[x][y]=="@")
		 {
			 System.out.println("The Computer sunk one of your ships!");
			 arr[x][y]="x";
			 pscore--;
			 cscore++;
		 }
		 else if(arr[x][y]=="x")
		 {
			 System.out.println("The Computer sunk one of its own ships");
			 arr[x][y]="!";
			 cscore--;
		 }
		 else if(arr[x][y]==" ")
		 {
			 System.out.println("computer missed");
			 
		 }
		 printEmpty();
		 System.out.println("players score:"+pscore);
		 System.out.println("computers score:"+cscore);
		 
		 
		 
	 }
	 public void playGame()
	 {
		 do
		 {
			 playersTurn();
			 computersTurn();
		 }while(pscore!=0 && cscore!=0);
	 }
	 public void gameOver()
	 {
		 System.out.println("players score:"+pscore);
		 System.out.println("computers score:"+cscore);
		 if(pscore==0)
		 {
			 System.out.println("computer won");
		 }
		 else
		 {
			 System.out.println("Hurray! you won");
		 }
	 }
	 
	 
 }
	 
 
	 
 
 

public class BattleShips {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Welcome to the world of Battle Ships game **");
		System.out.println("Right now the ship is empty.");
		EmptyOceanMap eom=new EmptyOceanMap();
		
		eom.printEmpty();
		eom.playerShips();	
		eom.computersShip();
		eom.playersTurn();
		eom.computersTurn();
		eom.playGame();
		eom.gameOver();

	}

}
