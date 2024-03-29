import java.util.ArrayList;

public class Poll {

	private int id;
	private String description;
	private ArrayList<Option> options;
	private boolean allowMultipleAnswer;
	private ArrayList<String> votedIps;
	private int totalVote;

	
	
	public Poll(int id, String description, int totalVote) {
		this.id = id;
		this.description = description;
		this.totalVote = totalVote;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	

	public boolean getAllowMultipleAnswer() {
		return allowMultipleAnswer;
	}

	public void setAllowMultipleAnswer(boolean allowMultipleAnswer) {
		this.allowMultipleAnswer = allowMultipleAnswer;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ArrayList<String> getVotedIps() {
		return votedIps;
	}

	public void setVotedIps(ArrayList<String> votedIps) {
		this.votedIps = votedIps;
	}

	public ArrayList<Option> getOptions() {
		return options;
	}

	public void setOptions(ArrayList<Option> options) {
		this.options = options;
	}

	public int getTotalVote() {
		return totalVote;
	}

	public void setTotalVote(int totalVote) {
		this.totalVote = totalVote;
	}

}
