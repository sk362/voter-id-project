package com.tka.voterId;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class VotingCard {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int v_id;

	@Column(unique = true, length = 191, nullable = false)
	private String voter_id;
	private String Constituency;

	public VotingCard() {
		super();
	}

	public VotingCard(String voter_id, String constituency) {
		super();
		this.voter_id = voter_id;
		Constituency = constituency;
	}

	public String getVoter_id() {
		return voter_id;
	}

	public void setVoter_id(String voter_id) {
		this.voter_id = voter_id;
	}

	public String getConstituency() {
		return Constituency;
	}

	public void setConstituency(String constituency) {
		Constituency = constituency;
	}

	@Override
	public String toString() {
		return "VotingCard [voter_id=" + voter_id + ", Constituency=" + Constituency + "]";
	}

}
