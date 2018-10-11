package model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Sponsor {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;

	@ManyToMany(mappedBy = "sponsors", cascade = { CascadeType.PERSIST })
	Set<Player> players = new HashSet<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public Sponsor() {
		super();
	}

	public Sponsor(String name, Set<Player> players) {
		super();
		this.name = name;
		this.players = players;
	}

	public Sponsor(String name) {
		super();
		this.name = name;
	}

	public void addPlayer(Player p) {
		players.add(p);
		p.addSponsor(this);
	}

	@Override
	public String toString() {
		return "Sponsor [name=" + name + "]";
	}

}
