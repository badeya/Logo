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
		return deleteSpace(programme[line-1]);
	}
	
	private String deleteSpace(String s){
		int i = 0;
		while(s.charAt(i)==' '){
			i++;
		}
		
		return s.substring(i);
	}
	
	
	
	
	
}
