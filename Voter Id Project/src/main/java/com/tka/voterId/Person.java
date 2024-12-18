package com.tka.voterId;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Person {

    @Id
    private int aadhar_id;
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "v_id")
    private VotingCard voter_id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "a_id")
    private Address address;  // Changed from List<Address> to Address

    public Person() {
        super();
    }

    public Person(int aadhar_id, String name) {
        super();
        this.aadhar_id = aadhar_id;
        this.name = name;
    }

    public int getAadhar_id() {
        return aadhar_id;
    }

    public void setAadhar_id(int aadhar_id) {
        this.aadhar_id = aadhar_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public VotingCard getVoter_id() {
        return voter_id;
    }

    public void setVoter_id(VotingCard voter_id) {
        this.voter_id = voter_id;
    }

    // Changed getter and setter methods for Address
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person [aadhar_id=" + aadhar_id + ", name=" + name + ", voter_id=" + voter_id + ", address=" + address + "]";
    }
}
