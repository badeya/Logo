package interpretation;

/**
 * 
 * permer de parser les élémenents sous la forme de token
 *
 */

public class Tokenizer {

	private String[] programme;
	private int line;
	
	/**
	 * 
	 * @param programme
	 */
	public Tokenizer(String programme) {
		if(programme.charAt(programme.length()-1)==' ') programme += "EOF";
		else programme += " EOF";
		
		this.programme = programme.toLowerCase().split(" |\n|\t");
		line = 0;
	}
	/**
	 * 
	 * @return la prochaine ligne
	 */
	public String nextLine(){
		line++;
		while(programme[line-1].equals("")) line++;
		return getLine();
	}
	
	/**
	 * 
	 * @return La dernière ligne
	 */
	public String getLine() {
		return programme[line-1];
	}

	
	
	
	
	
}
