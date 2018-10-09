package application;

import model.Player;
import persistence.MemoryDao;
import persistence.MemoryDaoImpl;

public class Main {

	public static void main(String[] args) {
		Player p1 = new Player("Neymar");
		MemoryDao dao = new MemoryDaoImpl();

		dao.create(p1);
		
		dao.delete(p1.getId());
	}

}
