package application;

import model.Coach;
import model.Player;
import persistence.MemoryDao;
import persistence.MemoryDaoImpl;

public class MainCreate {

	public static void main(String[] args) {
		Player p1 = new Player("Neymar");
//		Player p2 = new Player("DiMaria");
//		Player p3 = new Player("M.Salah");
//		Player p4 = new Player("Firminho");
//		Player p5 = new Player("Pogba");
//		Player p6 = new Player("S.Mane");
//		Player p7 = new Player("MBappe");
//		Player p8 = new Player("Sanchez");

		Coach c1 = new Coach("Tuchel");
//		Coach c2 = new Coach("Klopp");
//		Coach c3 = new Coach("Mourinho");

		c1.addPlayer(p1);
//		c1.addPlayer(p2);
//		c1.addPlayer(p7);
//		c2.addPlayer(p3);
//		c2.addPlayer(p4);
//		c2.addPlayer(p6);
//		c3.addPlayer(p5);
//		c3.addPlayer(p8);

		MemoryDao dao = new MemoryDaoImpl();
		dao.createCoach(c1);
//		dao.createCoach(c2);
//		dao.createCoach(c3);
//		dao.delete(p1);

		System.out.println("***********************************************************");
		System.out.println(" Les joueurs entraînés par "+c1.getName()+" sont : "+c1.getPlayers());
//		System.out.println("***********************************************************");
//		System.out.println("Les joueurs entraînés par "+c2.getName()+" sont : "+c2.getPlayers());
//		System.out.println("***********************************************************");
//		System.out.println("Les joueurs entraînés par "+c3.getName()+" sont : "+c3.getPlayers());
//		System.out.println("***********************************************************");
		
		dao.findById(1);
		
	}

}
