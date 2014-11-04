
public class JsonMessage{
	private int type;
	private String message;
	private Player player;

	public JsonMessage()
	{
		player = new Player();
	}

	public void setType(int command)
	{
		this.type = command;
	}

	public void setMessage(String message)
	{
		this.message = message;
	}

	public int getType()
	{
		return this.type;
	}

	public String getMessage()
	{
		return this.message;
	}

	private static class Player{
		private String username;
		private int score;
		private int played_games;

		public Player()
		{
			
		}

		public void setUsername(String username)
		{
			this.username = username;
		}

		public void setScore(int score)
		{
			this.score = score;
		}

		public void setPlayedGames(int pg)
		{
			this.played_games = pg;	
		}

		public String getUsername()
		{
			return this.username;
		}

		public int getScore()
		{
			return this.score;
		}

		public int getPlayedGames()
		{
			return this.played_games;
		}
	}

	private static class Game{
		//TODO: What should this class contain?
	}
}
