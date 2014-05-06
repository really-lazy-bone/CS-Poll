import java.util.ArrayList;
import java.util.HashMap;

public class Poll {

	private int id;
	private String description;
	private ArrayList<Option> options;
	private boolean allowMultipleAnswer;

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

}
