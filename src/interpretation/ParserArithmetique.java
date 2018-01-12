package interpretation;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ParserArithmetique {
	
	// Début singleton
	private static ParserArithmetique instance = new ParserArithmetique();
	public static ParserArithmetique getInstance(){return ParserArithmetique.instance;}
	// Fin singleton
	
	/**
	 * 
	 * @param expression
	 * @return
	 */
	public int parser(String expression){
		if(expression.charAt(0) == '$') {
			return getVariable(expression);
		}
		
		return calc(expression);
	}
	 /**
	  * 
	  * @param expression
	  * @return
	  */
	private int getVariable(String expression) {
		String variable = expression.substring(1,expression.length());
		Set<String> set = Interpreteur.getInstance().getVariables().keySet();
		for (String s : set) {
			if(s.equals(variable)){
				//System.out.println(Interpreteur.getInstance().getVariables().get(variable.toUpperCase()));
				return Interpreteur.getInstance().getVariables().get(variable);
			}
		}
		return 0;
	}
	
	/**
	 * 
	 * @param s
	 * @return
	 */
	private String[] nombre(String s) {
		 String s1 = "";
		 int cpt = 0;
		 if(s.charAt(0) == '[') {
			 cpt++;
			 while(s.charAt(cpt) != ']') {
				 s1+=s.charAt(cpt);
				 cpt++;
			 }
			 cpt++;
		 }else {
			 while(isDigit(s.charAt(cpt))) {
				 s1+=s.charAt(cpt);
				 cpt++;
			 }
		 }
		 String[] s2 = {s1,s.substring(cpt, s.length())};
		 return s2;
	 }

	/**
	 * 
	 * @param c
	 * @return
	 */
	private boolean isDigit(char c) {
		return c != ' ' && c != '+' && c != '-' && c != '*' && c != '/' && c != '%';
	}
	
	 private String rmspc(String s) {
		String s1 ="";
		String[] s2 = s.split(" ");
		for(String s3 : s2) {
			s1+=s3;
		}
		return s1;
	}
	 
	/**
	 * 
	 * @param s
	 * @return
	 */
	List<ArrayList<String>> miseEnListe(String s){
		 s = rmspc(s);
		ArrayList<String> op = new ArrayList<String>();
		ArrayList<String> nb = new ArrayList<String>();
		String[] s1 = nombre(s);
		while(stillGotAnOperand(s1[1])){
			nb.add(s1[0]);
			op.add(s1[1].charAt(0)+"");
			s1[1] = s1[1].substring(1, s1[1].length());
			s1 = nombre(s1[1]);
		}
		nb.add(s1[0]);
		op.add(s1[1].charAt(0)+"");
		s1[1] = s1[1].substring(1, s1[1].length());
		nb.add(s1[1]);
		List<ArrayList<String>> tab = new ArrayList<ArrayList<String>>();
		tab.add(op);
		tab.add(nb);
		return tab;
	}
	/**
	 * 
	 * @param s
	 * @return
	 */
	private boolean stillGotAnOperand(String s){
		int cpt  = 1;
		int cpt2 = 0;
		while(cpt < s.length() && cpt2 < 1) {
			if(!isDigit(s.charAt(cpt)) && s.charAt(cpt-1) != ']') {
				cpt2++;
			}
			cpt++;
		}
		
		return cpt2 == 1;
	}
	
	/**
	 * 
	 * @param op
	 * @return
	 */
	private static int firstOpToDo(ArrayList<String> op) {
		int cpt = 0;
		while(cpt < op.size() && !op.get(cpt).equals("*") && !op.get(cpt).equals("/") && !op.get(cpt).equals("%")) {
			cpt++;
		}
		if(cpt == op.size()) {
			cpt = 0;
		}
		return cpt;
	}
	
	/**
	 * 
	 * @param s
	 * @param s2
	 * @param op
	 * @return
	 */
	private String doMath(String s,String s2,String op) {
		if (s.charAt(0) == '[') {
			s = s.substring(1, s.length()-1);
		}
		if (s2.charAt(0) == '[') {
			s2 = s2.substring(1, s2.length()-1);
		}
		int a = Integer.parseInt(s);
		int b = Integer.parseInt(s2);
		if(op.equals("*")) {
			return a * b + "";
		}
		if(op.equals("/")) {
			return a / b + "";
		}
		if(op.equals("-")) {
			return a - b + "";
		}
		if(op.equals("+")) {
			return a + b + "";
		}
		if(op.equals("%")) {
			return a % b + "";
		}
		
		return "";
	}
	
	/**
	 * 
	 * @param nombre
	 */
	private static void remet(String[] nombre) {
		for (int i = 0; i < nombre.length-1; i++) {
			if(nombre[i].equals("")) {
				nombre[i] = nombre[i+1];
				nombre[i+1]="";
			}
		}
	}
	
	/**
	 * 
	 * @param calcul
	 * @return
	 */
	private String doCalcul(String calcul) {
		ArrayList<String> op = miseEnListe(calcul).get(0);
		ArrayList<String> nb = miseEnListe(calcul).get(1);
		String[] nombre = new String[nb.size()];
		int cpt = 0;
		for(String s : nb) {
			nombre[cpt] = s;
			cpt++;
		}
		while (!op.isEmpty()) {
			int toDo = firstOpToDo(op);
			nombre[toDo] = doMath(nombre[toDo],nombre[toDo+1], op.remove(toDo));
			nombre[toDo+1] = "";
			remet(nombre);
		}
		return nombre[0];
	}
	
	/**
	 * 
	 * @param s
	 * @return
	 */
	private static boolean morePar(String s) {
		int cpt = 0;
		while(cpt < s.length() && s.charAt(cpt) != '(') {
			cpt++;
		}
		return cpt != s.length();
	}
	
	/**
	 * 
	 * @param s
	 * @return
	 */
	private String getRidOfPar(String s) {
		int[] where = new int[2];
		while(morePar(s)) {
			int cpt = 0;
			while(s.charAt(cpt) != ')' && cpt < s.length()) {
				if(s.charAt(cpt) == '(') {
					where[0] =  cpt;
				}
				cpt++;
			}
			where[1] = cpt;
			String resTmp = "";
			if(s.substring(where[0]+1, where[1]).charAt(0) == '-') {
				resTmp = s.substring(where[0]+1, where[1]);
			}else {
				resTmp = doCalcul(s.substring(where[0]+1, where[1]));
			}
			if (resTmp.charAt(0) == '-') {
				resTmp = '['+resTmp+']';
			}
			String[] tmp = {s.substring(0, where[0]),s.substring(where[1]+1,s.length())};
			s="";
			for(int i = 0; i < tmp.length-1; i++) {
				s+=tmp[i]+resTmp;
			}
			s+=tmp[tmp.length-1];
		}
		return s;
	}
	
	/**
	 * 
	 * @param s
	 * @return
	 */
	public boolean isAlone(String s) {
		s = rmspc(s);
		int cpt = 0;
		int length = s.length();
		int r = 0;
		if(s.charAt(0) == '[') {
			r = -3;
		}
		while(cpt < s.length() && isDigit(s.charAt(cpt))){
				cpt++;
		}
		return (cpt  == (length + r));
	}
	
	/**
	 * 
	 * @param s
	 * @return
	 */
	public String notNegative(String s) {
		if(s.charAt(0) == '[') {
			s = s.substring(1, s.length()-1);
		}
		return s;
	}
	
	/**
	 * 
	 * @param s
	 * @return
	 */
	public int calc(String s) {
		s = getRidOfPar(s);
		if(isAlone(s)) {
			s = notNegative(s);
			return Integer.parseInt(s);
		}
		return Integer.parseInt(doCalcul(s));
	}
}
