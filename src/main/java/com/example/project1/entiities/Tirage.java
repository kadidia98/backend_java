package com.example.project1.entiities;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;





@Entity
public class Tirage {
	 @Id
	 @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name = "tirage_id")
	private Integer id;
	 @Column(nullable = false)
	private String nmbr_tirage;
	 @Column(nullable = false)
	private LocalDate dateTirage;
	 @Column(nullable = false)
    private LocalTime heureDebutTirage;
	 @Column(nullable = false)
    private LocalTime heureFinTirage;
	
    @ManyToOne
    @JoinColumn(name = "codeproduit_id", referencedColumnName = "codeproduit_id")
    private Product product;
   
    @ManyToOne
    @JoinColumn(name = "operateur_id", referencedColumnName = "operator_id")
    private Operator  operator;
    
	public Tirage() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Tirage(Integer id, String nmbr_tirage, LocalDate dateTirage, LocalTime heureDebutTirage,
			LocalTime heureFinTirage, Product product, Operator operator) {
		super();
		this.id = id;
		this.nmbr_tirage = nmbr_tirage;
		this.dateTirage = dateTirage;
		this.heureDebutTirage = heureDebutTirage;
		this.heureFinTirage = heureFinTirage;
		this.product = product;
		this.operator = operator;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNmbr_tirage() {
		return nmbr_tirage;
	}

	public void setNmbr_tirage(String nmbr_tirage) {
		this.nmbr_tirage = nmbr_tirage;
	}

	public LocalDate getDateTirage() {
		return dateTirage;
	}

	public void setDateTirage(LocalDate dateTirage) {
		this.dateTirage = dateTirage;
	}

	public LocalTime getHeureDebutTirage() {
		return heureDebutTirage;
	}

	public void setHeureDebutTirage(LocalTime heureDebutTirage) {
		this.heureDebutTirage = heureDebutTirage;
	}

	public LocalTime getHeureFinTirage() {
		return heureFinTirage;
	}

	public void setHeureFinTirage(LocalTime heureFinTirage) {
		this.heureFinTirage = heureFinTirage;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Operator getOperator() {
		return operator;
	}

	public void setOperator(Operator operator) {
		this.operator = operator;
	}

}
