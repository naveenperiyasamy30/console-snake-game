package snakegame.org;

import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class ConsoleSnakeGame {
	
	int h;
	int w;
	LinkedList<int[]> snake = new LinkedList<int[]>(); //
	int[] food;	
	Random rand = new Random();
	boolean win=false;
	
	ConsoleSnakeGame(int height,int width){
		h=height;
		w=width;
		snake.add(new int[] {0,0});
		generateFood();
	}
	
	
	public void generateFood() {
		if(snake.size()==h*w) {
			food = null;
			win=true;
		}else {
		food = new int[] {rand.nextInt(h),rand.nextInt(w)};
		}
	}

	public boolean move(char dir) {
		
		int[] head = snake.getFirst();
		int x = head[0];
		int y = head[1];
		
		
		if(dir == 'W') x--;
		else if(dir == 'S') x++;
		else if(dir == 'D') y++;
		else if (dir == 'A') y--;
		
		//check wall collision
		if(x < 0 || y < 0 || x >= h || y >= w) return false;
		
		//check own collision
		for(int[] temp : snake) {
			if(temp[0] == x && temp[1] == y) return false;
		}
		
		snake.addFirst(new int[] {x,y});
		
		
			if(food!= null && x==food[0] && y==food[1]) {
				boolean ok= false;
				while(!ok) {
					generateFood();
					if(food==null) break;
					ok=true;
					for(int[] temp : snake) {
						if(food[0]==temp[0] && food[1]==temp[1]) {
							ok=false;
							}
						}
					}			
			}else{
				snake.removeLast();
			}
		
		return true;	
	}
	
	
	
	
	
	
	
	//print board
	public void gameBoard() {
	
    
		for(int i=0;i<h;i++) {
			for(int j=0;j<w;j++) {
			
			boolean print=false;
				for(int[] x: snake) {
					if(i==x[0] && j==x[1])
						{
						System.out.print("S ");
						print=true;
						break;
						}
				}
				
				if(!print) {
					if(i==food[0] && j==food[1]) System.out.print("F ");
					else System.out.print(". ");
				}
			}
			System.out.println();
		}
		
	}
	
	
	
	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		System.out.println("|| CONSOLE SNAKE GAME ||");
		System.out.println("Enter the board height: ");
		int x=sc.nextInt();
		System.out.println("Enter the board width: ");
		int y=sc.nextInt();
		System.out.println(" \n");
		
		ConsoleSnakeGame game = new ConsoleSnakeGame(x,y);
		
		
		while(true) {	
			game.gameBoard();	
			System.out.println("Move (W/A/S/D)");
			char dir = sc.next().toUpperCase().charAt(0);
			boolean running = game.move(dir);
			
			if(game.win) {
				System.out.println(" Y O U   W O N   !");
				break;
			}
			
			
			if(!running) {
				System.out.println(" G A M E  ");
				System.out.println(" O V E R ! ");
				break;
			}
		}
		
		sc.close();
	}

}
