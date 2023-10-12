package com.example.project1.entiities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "Product_table")

public class Product {
	 @Id
	 @GeneratedValue( strategy = GenerationType.IDENTITY)
	 @Column(name = "codeproduit_id")
	    private Integer id;
	 @Column(length = 100, nullable = false)
	    private String libelle;
	 @Column(length = 100, nullable = false)
	    private String colisage;
		private int poids;
	 @Column(length = 100, nullable = false)
	    private String famille;
	 
	 @JsonIgnore
	 @OneToMany (cascade = CascadeType.ALL, mappedBy = "product" , fetch = FetchType.LAZY)
		private List<Tirage>  tirage;
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(Integer id, String libelle, String colisage, String famille, int poids) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.colisage = colisage;
		this.famille = famille;
		this.poids = poids;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public String getColisage() {
		return colisage;
	}
	public void setColisage(String colisage) {
		this.colisage = colisage;
	}
	
	public String getFamille() {
		return famille;
	}
	public void setFamille(String famille) {
		this.famille = famille;
	}
	public int getPoids() {
		return poids;
	}
	public void setPoids(int poids) {
		this.poids = poids;
	}
	public List<Tirage> getTirage() {
		return tirage;
	}
	public void setTirage(List<Tirage> tirage) {
		this.tirage = tirage;
	}
	
	

}
