/*
	If you're ever stuck somewhere with no games, but you do have at least one six-sided die, try playing Pig to pass the time.
	Players 2 to 6.

	Goal: Be the first player to reach 100 points.

	Gameplay: On a turn, a player rolls the die repeatedly until either:
		A 1 or 6 is rolled

		If a 1 is rolled, that player's turn ends and no points are earned.
		
		If a 6 is rolled, all of the points rolled during that turn are added to his or her score.

		Scoring Examples

		Example 1: Sherri rolls until 1 (5, 4, 5, 5, 1).
				   Because she rolled a 1, Sherri's turn ends and she earns 0 points.

		Example 2: Craig rolls until 6 (5, 3, 4, 2, 6) and decides to hold.
				   Craig earns 21 points for this turn (5+3+4+2+6=20).

	Game End: When a player reaches a total of 100 or more points, the game ends and that player is the winner.

*/

/*
	This class is responsible for the implementation of the Pig Dice game.
	It encapsulates the data structures for the game. 
	Its methods manipulate the data structures as the game progresses.
*/

class PigDiceGame
{
	Player[] pl=new Player[6];
	static int i=0;
	int x=0;
	int[] pt=new int[6];
	/*
		Adds a player to the board.
		The board can have a maximum of 6 players.
		The method throws an exception PlayerLimitReachedException if the number of players exceeds 6.
	*/
	public void addPlayer(Player p) throws PlayerLimitReachedException
	{	
		if(i>=6)
			throw new PlayerLimitReachedException();
		else
		{
			pl[i]=p;
			if(i==pl.length)
			{
				for(int j=0;j<pl.length;j++)
				{
					for(int k=0;k<pl.length;k++)
					{
						if((pl[j].name).compareTo(pl[k].name)<0)
						{
							Player temp=pl[j];
							pl[j]=pl[k];
							pl[k]=temp;
						}
					}
				}
			}
			i++;
		}
	}

	/*
		Returns the next player who is to take turn for play.
		Players take turns in the alphabetic order of their names.
	*/
	public Player nextPlayer()
	{
		if(x==i)
			x=0;
		return pl[x++];
	}

	/*
		Returns true if any one player reached the 100 points and false otherwise.
	*/
	public boolean hasWinner()
	{
		for(int k=0;k<i;k++)
		{
			if(pt[k]>=100){
				
				System.out.println("helooooo"+pt[k]);
				return true;}
		}
		return false;
	}

	/*
		Update the player p’s points by adding the new points to the current points.
	*/
	public void updatePoints(Player p, int points)
	{
		pt[x-1]=points+pt[x-1];
		//System.out.println(pt[x-1]);
	}

	/*
		Return the reference of the player object that is deemed winner or null if there is no winner yet.
	*/
	public Player getWinner()
	{
		for(int k=0;k<i;k++)
		{
			if(pt[k]>=100)
				return pl[k];
		}
		return null;
	}

	/*
		Return the current score of the player p.
	*/
	public int getCurrentScore(Player p)
	{
		return pt[x-1];
	}

	/*
		Start the game and return the winner
		This method throws an exception NotEnoughPlayersException if the count of players is less than 2.
	*/
	public Player startGame() throws NotEnoughPlayersException
	{
		/*
			Must use Dice.roll() for autograder to evaluate your code
		*/
		System.out.println(" i am doneeeeee");
		if(i<=1){
				System.out.println("haiiiiiiiiiiiii");
			throw new NotEnoughPlayersException();
		}
		else
		{
			while(!(hasWinner()))
			{  System.out.println("i am innnnn");
				Player p=nextPlayer();
				boolean flag=true;
				int sum=0;
				int value=Dice.roll();
				if(value==6 || value==1)
					flag=false;
				if(value==6)
					sum=sum+6;
				if(value==1)
					sum=0;
				while(flag)
				{
					sum=sum+value;
					value=Dice.roll();
					if(value==6)
					{
						sum=sum+6;
						flag=false;
					}
					if(value==1)
					{
						sum=0;
						flag=false;
					}
				}
				//System.out.println(sum);
				updatePoints(p,sum);
				//System.out.println(p.name + " " +getCurrentScore(p));
			}
			//return getWinner();
		}
		return getWinner();
	}

}

class Player
{
	String name;
	int age;
	public Player(String name,int age)
	{
		this.name=name;
		this.age=age;
	}
}

class Dice{
	public static int roll()
	{
		// implement the dice functionality here
		// should return a value between 1 and 6 inclusive
		int value=0;
		value=(int)(Math.random()*7);
		if(value==0)
			value=(int)(Math.random()*7);
		return value;
	}
}

public class PigDice{
	public static void main(String[] args){
		PigDiceGame game = new PigDiceGame();
		try
		{
			game.addPlayer(new Player("bob", 10));
			game.addPlayer(new Player("alice", 12));
			Player p=game.startGame();
			System.out.println(p.name + " won");
		}
		catch(PlayerLimitReachedException e)
		{
			System.out.println("");
		}
		catch(NotEnoughPlayersException e)
		{
			System.out.println("");
		}
	}
}
class PlayerLimitReachedException extends Exception
{
	private String s="PlayerLimitReachedException";
	public PlayerLimitReachedException()
	{
		System.out.println(this.s);
	}
}
class NotEnoughPlayersException extends Exception
{
	private String s="NotEnoughPlayersException";
	public NotEnoughPlayersException()
	{
		System.out.println(this.s);
	}
}