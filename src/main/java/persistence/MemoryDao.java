package persistence;

import model.Player;

public interface MemoryDao {
	
	public Player findById(int id);
	public void create(Player player);
	public void update(int id, String name);
	public void delete(int id);

}
