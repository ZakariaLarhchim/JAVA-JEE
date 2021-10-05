package DAO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="COMMANDE")
public class Commandes implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="ID_COMMANDE")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	
	@ManyToOne
	@JoinColumn(name="ID_CLIENT")
	private Clients clients;
	
	
	
	@Column(name="DATE_COMMANDE")
	private Date DateCommande;
	
	
	
	@Column(name="ETAT_COMMANDE")
	private boolean etat;

	
	
	@OneToMany(mappedBy = "commande")
	private List<Composante> cmp = new ArrayList<>();


	
	public Commandes() {
		
	}
	

	public Commandes(Clients clients, Date dateCommande, List<Composante> cmp ,boolean et) {
		super();
		this.clients = clients;
		DateCommande = dateCommande;
		this.cmp = cmp;
		this.etat=et;
	}


	public Clients getClients() {
		return clients;
	}

	public void setClients(Clients clients) {
		this.clients = clients;
	}


	

	public boolean isEtat() {
		return etat;
	}


	public void setEtat(boolean etat) {
		this.etat = etat;
	}



	public List<Composante> getCmp() {
		return cmp;
	}


	public void setCmp(List<Composante> cmp) {
		this.cmp = cmp;
	}


	


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Date getDateCommande() {
		return DateCommande;
	}


	public void setDateCommande(Date dateCommande) {
		DateCommande = dateCommande;
	}


	@Override
	public String toString() {
		return "Commandes [DateCommande=" + DateCommande + ", etat=" + etat + "]";
	}

	
	

}
