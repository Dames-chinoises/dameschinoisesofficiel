import java.util.*;


public class Etoile  {
	
	private ArrayList<Sommet> a = new ArrayList<Sommet>();
	private ArrayList<Sommet> b = new ArrayList<Sommet>();
	private ArrayList<Sommet> c = new ArrayList<Sommet>();
	private ArrayList<Sommet> d = new ArrayList<Sommet>();
	private ArrayList<Sommet> e = new ArrayList<Sommet>();
	private ArrayList<Sommet> f = new ArrayList<Sommet>();
	private ArrayList<Sommet> n = new ArrayList<Sommet>();
	private ArrayList<Sommet> plateau = new ArrayList<Sommet>();
	private ArrayList<Arete> arete = new ArrayList<Arete>();
	
	public Etoile(){
		//Creation liste de sommets a,b,c,d,e,f
		for(int i=1;i<=6;i++){
			a.add(i,new Sommet("a"+i));
			b.add(i,new Sommet("b"+i));
			c.add(i,new Sommet("c"+i));
			d.add(i,new Sommet("d"+i));
			e.add(i,new Sommet("e"+i));
			f.add(i,new Sommet("f"+i));
		}
		//Creations liste de sommets n
		for(int i=1;i<=37;i++){
			n.add(i,new Sommet("n"+i)); 
		}
		
		//Creation aretes en a 
		arete.add(new Arete(a.get(1),a.get(2)));
		arete.add(new Arete(a.get(1),a.get(3)));
		arete.add(new Arete(a.get(2),a.get(3)));
		arete.add(new Arete(a.get(2),a.get(4)));
		arete.add(new Arete(a.get(2),a.get(5)));
		arete.add(new Arete(a.get(3),a.get(5)));
		arete.add(new Arete(a.get(3),a.get(6)));
		arete.add(new Arete(a.get(4),a.get(5)));
		arete.add(new Arete(a.get(5),a.get(6)));
		//Creation aretes en b 			
		arete.add(new Arete(b.get(1),b.get(2)));
		arete.add(new Arete(b.get(1),b.get(3)));
		arete.add(new Arete(b.get(2),b.get(3)));
		arete.add(new Arete(b.get(2),b.get(4)));
		arete.add(new Arete(b.get(2),b.get(5)));
		arete.add(new Arete(b.get(3),b.get(5)));
		arete.add(new Arete(b.get(3),b.get(6)));
		arete.add(new Arete(b.get(4),b.get(5)));
		arete.add(new Arete(b.get(5),b.get(6)));
		//Creation aretes en c
		arete.add(new Arete(c.get(1),c.get(2)));
		arete.add(new Arete(c.get(1),c.get(3)));
		arete.add(new Arete(c.get(2),c.get(3)));
		arete.add(new Arete(c.get(2),c.get(4)));
		arete.add(new Arete(c.get(2),c.get(5)));
		arete.add(new Arete(c.get(3),c.get(5)));
		arete.add(new Arete(c.get(3),c.get(6)));
		arete.add(new Arete(c.get(4),c.get(5)));
		arete.add(new Arete(c.get(5),c.get(6)));
		//Creation aretes en d
		arete.add(new Arete(d.get(1),d.get(2)));
		arete.add(new Arete(d.get(1),d.get(3)));
		arete.add(new Arete(d.get(2),d.get(3)));
		arete.add(new Arete(d.get(2),d.get(4)));
		arete.add(new Arete(d.get(2),d.get(5)));
		arete.add(new Arete(d.get(3),d.get(5)));
		arete.add(new Arete(d.get(3),d.get(6)));
		arete.add(new Arete(d.get(4),d.get(5)));
		arete.add(new Arete(d.get(5),d.get(6)));	
		//Creation aretes en e
		arete.add(new Arete(e.get(1),e.get(2)));
		arete.add(new Arete(e.get(1),e.get(3)));
		arete.add(new Arete(e.get(2),e.get(3)));
		arete.add(new Arete(e.get(2),e.get(4)));
		arete.add(new Arete(e.get(2),e.get(5)));
		arete.add(new Arete(e.get(3),e.get(5)));
		arete.add(new Arete(e.get(3),e.get(6)));
		arete.add(new Arete(e.get(4),e.get(5)));
		arete.add(new Arete(e.get(5),e.get(6)));	
		//Creation aretes en f
		arete.add(new Arete(f.get(1),f.get(2)));
		arete.add(new Arete(f.get(1),f.get(3)));
		arete.add(new Arete(f.get(2),f.get(3)));
		arete.add(new Arete(f.get(2),f.get(4)));
		arete.add(new Arete(f.get(2),f.get(5)));
		arete.add(new Arete(f.get(3),f.get(5)));
		arete.add(new Arete(f.get(3),f.get(6)));
		arete.add(new Arete(f.get(4),f.get(5)));
		arete.add(new Arete(f.get(5),f.get(6)));
		
		//Creation aretes en n premier ligne
		arete.add(new Arete(n.get(1),n.get(2)));
		arete.add(new Arete(n.get(1),n.get(5)));
		arete.add(new Arete(n.get(1),n.get(6)));
		arete.add(new Arete(n.get(2),n.get(3)));
		arete.add(new Arete(n.get(2),n.get(6)));
		arete.add(new Arete(n.get(2),n.get(7)));
		arete.add(new Arete(n.get(3),n.get(4)));
		arete.add(new Arete(n.get(3),n.get(7)));
		arete.add(new Arete(n.get(3),n.get(8)));	
		arete.add(new Arete(n.get(4),n.get(8)));
		arete.add(new Arete(n.get(4),n.get(9)));
		//Creation aretes en n deuxieme ligne
		arete.add(new Arete(n.get(5),n.get(6)));
		arete.add(new Arete(n.get(5),n.get(10)));
		arete.add(new Arete(n.get(5),n.get(11)));
		arete.add(new Arete(n.get(6),n.get(7)));
		arete.add(new Arete(n.get(6),n.get(11)));
		arete.add(new Arete(n.get(6),n.get(12)));
		arete.add(new Arete(n.get(7),n.get(8)));
		arete.add(new Arete(n.get(7),n.get(12)));
		arete.add(new Arete(n.get(7),n.get(13)));	
		arete.add(new Arete(n.get(8),n.get(9)));
		arete.add(new Arete(n.get(8),n.get(13)));
		arete.add(new Arete(n.get(8),n.get(14)));	
		arete.add(new Arete(n.get(9),n.get(14)));
		arete.add(new Arete(n.get(9),n.get(15)));
		//Creation aretes en n trosieme  ligne
		arete.add(new Arete(n.get(10),n.get(11)));
		arete.add(new Arete(n.get(10),n.get(16)));
		arete.add(new Arete(n.get(10),n.get(17)));
		arete.add(new Arete(n.get(11),n.get(12)));
		arete.add(new Arete(n.get(11),n.get(17)));
		arete.add(new Arete(n.get(11),n.get(18)));
		arete.add(new Arete(n.get(12),n.get(13)));
		arete.add(new Arete(n.get(12),n.get(18)));
		arete.add(new Arete(n.get(12),n.get(19)));	
		arete.add(new Arete(n.get(13),n.get(14)));
		arete.add(new Arete(n.get(13),n.get(19)));
		arete.add(new Arete(n.get(13),n.get(20)));	
		arete.add(new Arete(n.get(14),n.get(15)));
		arete.add(new Arete(n.get(14),n.get(20)));
		arete.add(new Arete(n.get(14),n.get(21)));
		arete.add(new Arete(n.get(15),n.get(21)));
		arete.add(new Arete(n.get(15),n.get(22)));
		//Creation aretes en n quatrieme  ligne
		arete.add(new Arete(n.get(16),n.get(17)));
		arete.add(new Arete(n.get(16),n.get(23)));
		arete.add(new Arete(n.get(17),n.get(18)));
		arete.add(new Arete(n.get(17),n.get(23)));
		arete.add(new Arete(n.get(17),n.get(24)));
		arete.add(new Arete(n.get(18),n.get(19)));
		arete.add(new Arete(n.get(18),n.get(24)));
		arete.add(new Arete(n.get(18),n.get(25)));
		arete.add(new Arete(n.get(19),n.get(20)));	
		arete.add(new Arete(n.get(19),n.get(25)));
		arete.add(new Arete(n.get(19),n.get(26)));
		arete.add(new Arete(n.get(20),n.get(21)));	
		arete.add(new Arete(n.get(20),n.get(26)));
		arete.add(new Arete(n.get(20),n.get(27)));
		arete.add(new Arete(n.get(21),n.get(22)));
		arete.add(new Arete(n.get(21),n.get(27)));
		arete.add(new Arete(n.get(21),n.get(28)));
		arete.add(new Arete(n.get(22),n.get(28)));
		//Creation aretes en n cinquieme ligne
		arete.add(new Arete(n.get(23),n.get(24)));
		arete.add(new Arete(n.get(23),n.get(29)));
		arete.add(new Arete(n.get(24),n.get(25)));
		arete.add(new Arete(n.get(24),n.get(29)));
		arete.add(new Arete(n.get(24),n.get(30)));
		arete.add(new Arete(n.get(25),n.get(26)));	
		arete.add(new Arete(n.get(25),n.get(30)));
		arete.add(new Arete(n.get(25),n.get(31)));
		arete.add(new Arete(n.get(26),n.get(27)));	
		arete.add(new Arete(n.get(26),n.get(31)));
		arete.add(new Arete(n.get(26),n.get(32)));
		arete.add(new Arete(n.get(27),n.get(28)));
		arete.add(new Arete(n.get(27),n.get(32)));
		arete.add(new Arete(n.get(27),n.get(33)));
		arete.add(new Arete(n.get(28),n.get(33)));
		//Creation aretes en n sixieme ligne
		arete.add(new Arete(n.get(29),n.get(30)));
		arete.add(new Arete(n.get(29),n.get(34)));
		arete.add(new Arete(n.get(30),n.get(31)));	
		arete.add(new Arete(n.get(30),n.get(34)));
		arete.add(new Arete(n.get(30),n.get(35)));
		arete.add(new Arete(n.get(31),n.get(32)));	
		arete.add(new Arete(n.get(31),n.get(35)));
		arete.add(new Arete(n.get(31),n.get(36)));
		arete.add(new Arete(n.get(32),n.get(33)));
		arete.add(new Arete(n.get(32),n.get(36)));
		arete.add(new Arete(n.get(32),n.get(37)));
		arete.add(new Arete(n.get(33),n.get(37)));
		//Creation aretes en n septieme ligne
		arete.add(new Arete(n.get(34),n.get(35)));
		arete.add(new Arete(n.get(35),n.get(36)));
		arete.add(new Arete(n.get(36),n.get(37)));
		
		//Creation aretes lien entr n et a 
		arete.add(new Arete(a.get(4),n.get(1)));
		arete.add(new Arete(a.get(4),n.get(2)));
		arete.add(new Arete(a.get(5),n.get(2)));	
		arete.add(new Arete(a.get(5),n.get(3)));
		arete.add(new Arete(a.get(6),n.get(3)));
		arete.add(new Arete(a.get(6),n.get(4)));
		//Creation aretes lien entr n et b 
		arete.add(new Arete(b.get(4),n.get(4)));
		arete.add(new Arete(b.get(4),n.get(9)));
		arete.add(new Arete(b.get(5),n.get(9)));	
		arete.add(new Arete(b.get(5),n.get(15)));
		arete.add(new Arete(b.get(6),n.get(15)));
		arete.add(new Arete(b.get(6),n.get(22)));
		//Creation aretes lien entr n et c
		arete.add(new Arete(c.get(4),n.get(22)));
		arete.add(new Arete(c.get(4),n.get(28)));
		arete.add(new Arete(c.get(5),n.get(28)));	
		arete.add(new Arete(c.get(5),n.get(33)));
		arete.add(new Arete(c.get(6),n.get(33)));
		arete.add(new Arete(c.get(6),n.get(37)));
		//Creation aretes lien entr n et d
		arete.add(new Arete(d.get(4),n.get(37)));
		arete.add(new Arete(d.get(4),n.get(36)));
		arete.add(new Arete(d.get(5),n.get(36)));	
		arete.add(new Arete(d.get(5),n.get(35)));
		arete.add(new Arete(d.get(6),n.get(35)));
		arete.add(new Arete(d.get(6),n.get(34)));
		//Creation aretes lien entr n et e
		arete.add(new Arete(e.get(4),n.get(34)));
		arete.add(new Arete(e.get(4),n.get(29)));
		arete.add(new Arete(e.get(5),n.get(29)));	
		arete.add(new Arete(e.get(5),n.get(23)));
		arete.add(new Arete(e.get(6),n.get(23)));
		arete.add(new Arete(e.get(6),n.get(16)));
		//Creation aretes lien entr n et f
		arete.add(new Arete(f.get(4),n.get(16)));
		arete.add(new Arete(f.get(4),n.get(10)));
		arete.add(new Arete(f.get(5),n.get(10)));	
		arete.add(new Arete(f.get(5),n.get(5)));
		arete.add(new Arete(f.get(6),n.get(5)));
		arete.add(new Arete(f.get(6),n.get(1)));
		
		
	}
		
		

}

	


