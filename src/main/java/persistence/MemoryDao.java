package persistence;

import model.Coach;
import model.Player;

public interface MemoryDao {
	
	public Player findById(int id);
	
	public void create(Player player);
	public void createCoach(Coach coach);
	
//	public void update(int id, String name);

	public void delete(Player p);
	public void deleteCoach(Coach c);
}
