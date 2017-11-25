package interpretation;

public class Tokenizer {

	private String[] programme;
	private int line;
	
	
	public Tokenizer(String programme) {
		if(programme.charAt(programme.length()-1)=='\n') programme += "EOF";
		else programme += "\nEOF";
		this.programme = programme.toLowerCase().split("\n");
		line = 0;
	}
	
	String nextLine(){
		line++;
		return programme[line-1];
	}
	
	
	
	
	
}
