
import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lmoentje
 */
public class Main {
    
    private HashMap<Integer, Equipment> equipment;

	public Main() {
		equipment = new HashMap<Integer, Equipment>();
	}
    
    public static void main(String[] args) throws Exception {
		//TODO: hieronder wat code om de databank aan te maken en wat testdata toe te voegen (zet dit daarna weer in commentaar)
		//1. vul zelf de DBConnector-klasse aan met je databank en wachtwoord
		//2. maakt tables aan
		DBBuildIt.createTables();
		//3. voegt wat random studenten toe
		//       for(int i = 0; i < 53; i++) {
		Equipment s = new Equipment(5);
		//          for(int j = 0; j < i%4; j++)//voegt wat random majors toe
		//              s.addMajor("major"+j);
		DBBuildIt.save(s);//student naar db
		//      }
		//4. zet dit weer in commentaar en haal de onderstaande code uit commentaar

		//TODO: echte code van deze main
		//        MyFrame f = new MyFrame(new Main());
		//        f.setVisible(true);
	}
    
}