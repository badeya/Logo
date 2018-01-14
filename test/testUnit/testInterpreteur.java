package testUnit;

import static org.junit.Assert.*;

import org.junit.Test;

import commandes.Avant;
import commandes.Droite;
import commandes.Epaisseur;
import commandes.Gauche;
import commandes.Lever;
import commandes.Poser;
import commandes.Script;
import interpretation.Interpreteur;
import interpretation.Parser;
import interpretation.Tokenizer;

public class testInterpreteur {

	@Test
	public void test() {
	 assertTrue(true);
	}
	@Test
	public void testParserAnalyser(){
		Tokenizer t = new Tokenizer("SCRIPT AVANT 20 FIN");
		Parser p  = new Parser(t);
		Script s = new Script();
		s.add(new Avant(20));
		assertEquals(p.analyser(), s);
	}
	@Test
	public void testParserScript(){
		Tokenizer t = new Tokenizer("SCRIPT AVANT 20 FIN ");
		Parser p  = new Parser(t);
		p.setTeteLect(t.nextLine());
		Script s = new Script();
		s.add(new Avant(20));
		assertEquals(p.Script(), s);
	}
	
	@Test
	public void testDroite(){
		Tokenizer t = new Tokenizer("SCRIPT DROITE 20 FIN ");
		Parser p  = new Parser(t);
		p.setTeteLect(t.nextLine());
		Script s = new Script();
		s.add(new Droite(20));
		assertEquals(p.Script(), s);
	}
	
	@Test
	public void testGauche(){
		Tokenizer t = new Tokenizer("SCRIPT GAUCHE 20 FIN ");
		Parser p  = new Parser(t);
		p.setTeteLect(t.nextLine());
		Script s = new Script();
		s.add(new Gauche(20));
		assertEquals(p.Script(), s);
	}

	
	@Test
	public void testEpaisseur(){
		Tokenizer t = new Tokenizer("SCRIPT EPAISSEUR 20 FIN ");
		Parser p  = new Parser(t);
		p.setTeteLect(t.nextLine());
		Script s = new Script();
		s.add(new Epaisseur(20));
		assertEquals(p.Script(), s);
	}
	
}
