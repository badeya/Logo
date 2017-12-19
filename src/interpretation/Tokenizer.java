package interpretation;

public class Tokenizer {

	private String[] programme;
	private int line;
	
	public Tokenizer(String programme) {
		if(programme.charAt(programme.length()-1)==' ') programme += "EOF";
		else programme += " EOF";
		
		this.programme = programme.toLowerCase().split(" |\n");
		line = 0;
	}
	
	String nextLine(){
		line++;
		while(programme[line-1].equals("")) line++;
		return getLine();
	}
	
	public String getLine() {
		return programme[line-1];
	}

	
	
	
	
	
}
