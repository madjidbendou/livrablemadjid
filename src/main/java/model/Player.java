package model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Player {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.REMOVE})
	@JoinColumn(name="coach_id")
	private Coach coach;

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

}
