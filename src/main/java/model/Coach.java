package model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Coach {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	@OneToMany(mappedBy="coach", cascade= {CascadeType.PERSIST, CascadeType.REMOVE})
	Set<Player> players = new HashSet<>();
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<Player> getPlayers() {
		return players;
	}
	public void setPlayers(Set<Player> players) {
		this.players = players;
	}
	public Coach() {
		super();
	}
	
	
	public Coach(String name) {
		super();
		this.name = name;
	}
	public Coach(String name, Set<Player> players) {
		super();
		this.name = name;
		this.players = players;
	}
	
	public void addPlayer(Player player) {
		players.add(player);
		player.setCoach(this);
	}
	
	
}
