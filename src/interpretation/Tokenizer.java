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
