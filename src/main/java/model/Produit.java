package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the produit database table.
 * 
 */
@Entity
@Table(name="produit")
@NamedQuery(name="Produit.findAll", query="SELECT p FROM Produit p")
public class Produit implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String designation;

	private float prix;

	private int quantite;

	private int sdr;

	//bi-directional many-to-one association to Categorie
	@ManyToOne
	@JoinColumn(name="idCateg")
	private Categorie categorie;

	public Produit() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDesignation() {
		return this.designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public float getPrix() {
		return this.prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

	public int getQuantite() {
		return this.quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public int getSdr() {
		return this.sdr;
	}

	public void setSdr(int sdr) {
		this.sdr = sdr;
	}

	public Categorie getCategorie() {
		return this.categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

}