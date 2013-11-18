import java.io.Serializable;


public class Invitation implements Serializable 
{
	private static final long serialVersionUID = 7733052126556095098L;
	private String opponent;
	private String opponentIP;
	
	public Invitation(String opp, String ip)
	{
		opponent = opp;
		opponent= opponentIP;
	}
	
	public String getOpponentName()
	{
		return opponent;
	}
	
	public String getIP()
	{
		return opponentIP;
	}

}
