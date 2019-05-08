package com.lambdaschool.zoos.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "telephone")
public class Telephone {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long phoneid;

    String phonetype;
    String phonenumber;

    @ManyToOne
    @JoinColumn(name = "zooid")
    @JsonIgnoreProperties("telephones")
    private Zoo zoo;

    public Telephone() {
    }

    public Telephone(String phonetype, String phonenumber) {
        this.phonetype = phonetype;
        this.phonenumber = phonenumber;
    }

    public long getPhoneid() {
        return phoneid;
    }

    public void setPhoneid(long phoneid) {
        this.phoneid = phoneid;
    }

    public long getTelephoneid() {
        return phoneid;
    }

    public void setTelephoneid(long telephoneid) {
        this.phoneid = telephoneid;
    }

    public String getPhonetype() {
        return phonetype;
    }

    public void setPhonetype(String phonetype) {
        this.phonetype = phonetype;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public Zoo getZoo() {
        return zoo;
    }

    public void setZoo(Zoo zoo) {
        this.zoo = zoo;
    }
}
