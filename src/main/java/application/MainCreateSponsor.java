package application;

import model.Coach;
import model.Player;
import model.Sponsor;
import persistence.MemoryDao;
import persistence.MemoryDaoImpl;

public class MainCreateSponsor {

	public static void main(String[] args) {
		Player p1 = new Player("Neymar");
		Player p2 = new Player("DiMaria");
		Player p3 = new Player("M.Salah");
		Player p4 = new Player("Firminho");
		Player p5 = new Player("Pogba");
		Player p6 = new Player("S.Mane");
		Player p7 = new Player("MBappe");
		Player p8 = new Player("Sanchez");

		Coach c1 = new Coach("Tuchel");
		Coach c2 = new Coach("Klopp");
		Coach c3 = new Coach("Mourinho");

		c1.addPlayer(p1);
		c1.addPlayer(p2);
		c1.addPlayer(p7);
		c2.addPlayer(p3);
		c2.addPlayer(p4);
		c2.addPlayer(p6);
		c3.addPlayer(p5);
		c3.addPlayer(p8);

		MemoryDao dao = new MemoryDaoImpl();
		dao.createCoach(c1);
		dao.createCoach(c2);
		dao.createCoach(c3);
		dao.delete(p1);

		System.out.println("***********************************************************");
		System.out.println(" Les joueurs entraînés par "+c1.getName()+" sont : "+c1.getPlayers());
		System.out.println("***********************************************************");
		System.out.println("Les joueurs entraînés par "+c2.getName()+" sont : "+c2.getPlayers());
		System.out.println("***********************************************************");
		System.out.println("Les joueurs entraînés par "+c3.getName()+" sont : "+c3.getPlayers());
		System.out.println("***********************************************************");
		
		dao.findById(1);
		
		Player pp = dao.findById(1);
		Sponsor s1 = new Sponsor("Nike");
		Sponsor s2 = new Sponsor("Adidas");
		Player ppp2 = dao.findById(2);
		pp.addSponsor(s1);
		ppp2.addSponsor(s1);
		Player pp3 = dao.findById(3);
		pp3.addSponsor(s2);
		
		
		dao.createSponsor(s1);
		dao.createSponsor(s2);
		
		
		System.out.println(pp+" a pour sponsor "+ s1);
		
	}

}
