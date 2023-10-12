package com.example.project1.entiities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "Operator_table")

public class Operator {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name = "operator_id")
	private Integer id;
	@Column(length = 100, nullable = false)
	private String nom;
	@Column(length = 100, nullable = false)
	private String prenom;
	@Column(length = 100, nullable = false)
	 @JsonIgnore
	 @OneToMany  (cascade = CascadeType.ALL, mappedBy = "operator" )
	private List<Tirage>  tirage;
	private String telephone;
	public Operator() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Operator(Integer id, String nom, String prenom, String telephone) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.telephone = telephone;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public List<Tirage> getTirage() {
		return tirage;
	}
	public void setTirage(List<Tirage> tirage) {
		this.tirage = tirage;
	}
	
}
