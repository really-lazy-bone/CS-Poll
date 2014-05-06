
public class Option {
	
	private int id;
	private int pollId;
	private String optionString;
	private int optionCount;
	
	
	
	public Option(int id, String optionString) {
		this.id = id;
		this.optionString = optionString;
	}
	public Option(int id, String optionString, int optionCount) {
		this.id = id;
		this.optionString = optionString;
		this.optionCount=optionCount;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOptionString() {
		return optionString;
	}
	public void setOptionString(String optionString) {
		this.optionString = optionString;
	}
	public int getOptionCount() {
		return optionCount;
	}
	public void setOptionCount(int optionCount) {
		this.optionCount = optionCount;
	}
	public int getPollId() {
		return pollId;
	}
	public void setPollId(int pollId) {
		this.pollId = pollId;
	}
}
