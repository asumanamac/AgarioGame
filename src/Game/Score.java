package Game;

public class Score {
	
	public static int score;
	
	public int increaseScore()
	{
		score+=10;
		if(score<=0)
			score=0;

		return score;
	}
	
	public int decreaseScore()
	{
		
		score-=10;
		if(score<=0)
			score=0;

		return score;
	}
	
	public int increasedoubleScore()
	{
		score+=20;
		if(score<=0)
			score=0;

		return score;
	}
	
	
	


}
