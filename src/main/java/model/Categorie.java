package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the categorie database table.
 * 
 */
@Entity
@Table(name="categorie")
@NamedQuery(name="Categorie.findAll", query="SELECT c FROM Categorie c")
public class Categorie implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
//	private int id;
	private int idCategorie;

	private String Description;

	private String NomCategorie;

	//bi-directional many-to-one association to Produit
	@OneToMany(mappedBy="categorie")
	private List<Produit> produits;

	public Categorie() {
	}

//	public int getId() {
//		return this.id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}

	public int getIdCategorie() {
		return idCategorie;
	}

	public void setIdCategorie(int idCategorie) {
		this.idCategorie = idCategorie;
	}

	public String getNomCategorie() {
		return NomCategorie;
	}

	public void setNomCategorie(String NomCategorie) {
		this.NomCategorie = NomCategorie;
	}

	public String getDescription() {
		return this.Description;
	}

	public void setDescription(String Description) {
		this.Description = Description;
	}

//	public String getNom() {
//		return this.NomCategorie;
//	}
//
//	public void setNom(String nom) {
//		this.NomCategorie = nom;
//	}

	public List<Produit> getProduits() {
		return this.produits;
	}

	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}

	public Produit addProduit(Produit produit) {
		getProduits().add(produit);
		produit.setCategorie(this);

		return produit;
	}

	public Produit removeProduit(Produit produit) {
		getProduits().remove(produit);
		produit.setCategorie(null);

		return produit;
	}
	
	@Override
	public String toString() {
		return idCategorie + " => " + NomCategorie + " : "+Description;
	}

}