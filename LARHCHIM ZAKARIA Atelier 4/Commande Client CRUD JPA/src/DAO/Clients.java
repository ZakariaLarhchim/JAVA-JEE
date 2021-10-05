package DAO;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Client")
public class Clients implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_CLIENT")
	private int idC;
	
	
	@Column(name="NOM")
	private String nom;
	
	
	@Column(name="PRENOM")
	private String prenom;
	
	
	@Column(name="EMAIL")
	private String email;
	
	
	@Column(name="PASSWORD")
	private String password;
	
	
	
	@OneToMany(mappedBy = "clients")
	private List<Commandes> prod = new ArrayList<>() ;
	
	
	public Clients(String nom, String prenom, String email, String password) {
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.password = password;
	}
	
	public Clients() {
		
	}

	public int getId() {
		return idC;
	}

	public void setId(int id) {
		this.idC = id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Commandes> getProd() {
		return prod;
	}

	public void setProd(List<Commandes> prod) {
		this.prod = prod;
	}

	@Override
	public String toString() {
		return "Clients [nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", password=" + password + "]";
	}

	

	
	

}
