package model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Player {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	@ManyToOne(cascade = { CascadeType.PERSIST })
	@JoinColumn(name = "coach_id")
	private Coach coach;

	@ManyToMany
	@JoinTable(name = "player_sponsor", joinColumns = { @JoinColumn(name = "player_id")

	}, inverseJoinColumns = { @JoinColumn(name = "sponsor_id") })

	Set<Sponsor> sponsors = new HashSet<>();

	// Getters & setters
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

	public Coach getCoach() {
		return coach;
	}

	public void setCoach(Coach coach) {
		this.coach = coach;
	}

	// Constructeurs
	public Player() {
		super();
	}

	public Player(String name) {
		super();

		this.name = name;
	}

	@Override
	public String toString() {
		return "Player [ name=" + name + "]";
	}
	
	
	public Set<Sponsor> getSponsors() {
		return sponsors;
	}

	public void setSponsors(Set<Sponsor> sponsors) {
		this.sponsors = sponsors;
	}

	public void addSponsor( Sponsor s) {
		sponsors.add(s);
		s.getPlayers().add(this);
	}

}
