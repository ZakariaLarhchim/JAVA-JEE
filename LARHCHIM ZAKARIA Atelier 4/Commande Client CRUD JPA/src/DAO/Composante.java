package DAO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="COMPOSANTE")
public class Composante {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_COMPOSANTE")
	private int ID_Composante;
	
	
	@ManyToOne
	@JoinColumn(name="ID_COMMANDE")
	Commandes commande;
	
	
	
	@Column(name="QUANTITE_COMMANDE")
	private int quantite;
	
	
	
	@ManyToOne
	@JoinColumn(name="ID_PRODUIT")
	Produits produit;
	
	

	public Composante(Commandes commande, int quantite, Produits produit) {
		
		this.commande = commande;
		this.quantite = quantite;
		this.produit = produit;
		
	}
	
	
	public Composante() {
		
	}

	

	public int getID_Composante() {
		return ID_Composante;
	}


	public void setID_Composante(int iD_Composante) {
		ID_Composante = iD_Composante;
	}


	public int getQuantite() {
		return quantite;
	}


	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	
	


	public Produits getProduit() {
		return produit;
	}


	public void setProduit(Produits produit) {
		this.produit = produit;
	}

	

	public Commandes getCommande() {
		return commande;
	}


	public void setCommande(Commandes commande) {
		this.commande = commande;
	}


	@Override
	public String toString() {
		return "Composante [quantite=" + quantite + "]";
	}

	
	
}
