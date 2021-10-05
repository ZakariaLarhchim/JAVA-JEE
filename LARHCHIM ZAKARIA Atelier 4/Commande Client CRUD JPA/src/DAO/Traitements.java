package DAO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Traitements {
	
	private static EntityManager entity;
	
	EntityManagerFactory fact =Persistence.createEntityManagerFactory("is");

	
	public void functionInsertion() {
		
		entity=fact.createEntityManager();
		
		EntityTransaction trans =entity.getTransaction();
		trans.begin();
		
		try {
			
			/*entity.persist(new Clients("LARHCHIM", "ISMAIL", "ismaillarhchim864@gmail.com", MD5Hash.getMd5("LARHCHIM123")));
			entity.persist(new Clients("BALOUKI", "YOUSSEF", "balouki.y.fst@uhp.ac.ma", MD5Hash.getMd5("BALOUKI123")));
			entity.persist(new Clients("LIONEL", "MESSI", "lionel.y.fst@uhp.ac.ma", MD5Hash.getMd5("LIONEL123")));
			entity.persist(new Clients("HERNANDEZ", "XAVI", "xavi.y.fst@uhp.ac.ma", MD5Hash.getMd5("HERNANDEZ123")));
			entity.persist(new Clients("ANDRES", "INIESTA", "andres.y.fst@uhp.ac.ma", MD5Hash.getMd5("ANDRES123")));


			entity.persist(new Produits("HuaweiGT",9400.0,true,500));
			entity.persist(new Produits("imac",11000.0,true,400));
			entity.persist(new Produits("TABLET",1500.0,true,600));
			entity.persist(new Produits("SMARTTV",23000.0,true,900));*/
			
			
			/*Commandes cmd = new Commandes();
			cmd.setClients(entity.find(Clients.class, 1));
			cmd.setEtat(true);
			cmd.setDateCommande(new Date());
			entity.persist(cmd);
		
			
			Commandes cmd2 = new Commandes();
			cmd2.setClients(entity.find(Clients.class, 2));
			cmd2.setEtat(true);
			cmd2.setDateCommande(new Date());
			entity.persist(cmd2);
			
			Commandes cmd3 = new Commandes();
			cmd3.setClients(entity.find(Clients.class, 3));
			cmd3.setEtat(true);
			cmd3.setDateCommande(new Date());
			entity.persist(cmd3);
			
			Commandes cmd4 = new Commandes();
			cmd4.setClients(entity.find(Clients.class, 4));
			cmd4.setEtat(true);
			cmd4.setDateCommande(new Date());
			entity.persist(cmd4);*/
			
			
			
			/*Composante cmp1 = new Composante();
			cmp1.setQuantite(10);
			Commandes cmd1 = entity.find(Commandes.class, 5);
			Produits prd1 =entity.find(Produits.class, 1);
			cmp1.setCommande(cmd1);
			cmp1.setProduit(prd1);
			entity.persist(cmp1);
			
			
			Composante cmp2 = new Composante();
			cmp2.setQuantite(10);
			Commandes cmd2 = entity.find(Commandes.class, 6);
			Produits prd2 =entity.find(Produits.class, 2);
			cmp2.setCommande(cmd2);
			cmp2.setProduit(prd2);
			entity.persist(cmp2);

			Composante cmp3 = new Composante();
			cmp3.setQuantite(10);
			Commandes cmd3 = entity.find(Commandes.class, 7);
			Produits prd3 =entity.find(Produits.class, 3);
			cmp3.setCommande(cmd3);
			cmp3.setProduit(prd3);
			entity.persist(cmp3);

			Composante cmp4 = new Composante();
			cmp4.setQuantite(10);
			Commandes cmd4 = entity.find(Commandes.class, 8);
			Produits prd4 =entity.find(Produits.class, 4);
			cmp4.setCommande(cmd4);
			cmp4.setProduit(prd4);
			entity.persist(cmp4);

			
			Composante cmp5 = new Composante();
			cmp5.setQuantite(10);
			Commandes cmd5 = entity.find(Commandes.class, 9);
			Produits prd5 =entity.find(Produits.class, 1);
			cmp5.setCommande(cmd5);
			cmp5.setProduit(prd5);
			entity.persist(cmp5);

			
			Composante cmp6 = new Composante();
			cmp6.setQuantite(10);
			Commandes cmd6 = entity.find(Commandes.class, 10);
			Produits prd6 =entity.find(Produits.class, 1);
			cmp6.setCommande(cmd6);
			cmp6.setProduit(prd6);
			entity.persist(cmp6);

			
			Composante cmp7 = new Composante();
			cmp7.setQuantite(10);
			Commandes cmd7 = entity.find(Commandes.class, 11);
			Produits prd7 =entity.find(Produits.class, 1);
			cmp7.setCommande(cmd7);
			cmp7.setProduit(prd7);
			entity.persist(cmp7);

			
			Composante cmp8 = new Composante();
			cmp8.setQuantite(10);
			Commandes cmd8 = entity.find(Commandes.class, 12);
			Produits prd8 =entity.find(Produits.class, 3);
			cmp8.setCommande(cmd8);
			cmp8.setProduit(prd8);
			entity.persist(cmp8);

			
			Composante cmp9 = new Composante();
			cmp9.setQuantite(10);
			Commandes cmd9 = entity.find(Commandes.class, 13);
			Produits prd9 =entity.find(Produits.class, 3);
			cmp9.setCommande(cmd9);
			cmp9.setProduit(prd9);
			entity.persist(cmp9);

			
			Composante cmp10 = new Composante();
			cmp10.setQuantite(10);
			Commandes cmd10 = entity.find(Commandes.class, 14);
			Produits prd10 =entity.find(Produits.class, 2);
			cmp10.setCommande(cmd10);
			cmp10.setProduit(prd10);
			entity.persist(cmp10);

			
			Composante cmp11 = new Composante();
			cmp11.setQuantite(10);
			Commandes cmd11 = entity.find(Commandes.class, 15);
			Produits prd11 =entity.find(Produits.class, 2);
			cmp11.setCommande(cmd11);
			cmp11.setProduit(prd11);
			entity.persist(cmp11);

			Composante cmp12 = new Composante();
			cmp12.setQuantite(10);
			Commandes cmd12 = entity.find(Commandes.class, 16);
			Produits prd12 =entity.find(Produits.class, 4);
			cmp12.setCommande(cmd12);
			cmp12.setProduit(prd12);
			entity.persist(cmp12);*/

			
			
			
			
			trans.commit();

		}catch(Exception e) {
			trans.rollback();
		}

		
	}
	
	
	public Commandes functionCommandes( int identifiant ) throws Exception{
		
		entity =fact.createEntityManager();
		EntityTransaction trans =entity.getTransaction();
		trans.begin();
		

			Commandes cmd = entity.find(Commandes.class, identifiant);

	
			trans.commit();
			
			return cmd;
		
	}
	
	public Clients functionClients( int identifiant )throws Exception {
		
		entity = fact.createEntityManager();
		EntityTransaction trans = entity.getTransaction();
		trans.begin();
		
		Commandes cmd =entity.find(Commandes.class, identifiant);
		Clients cl = cmd.getClients();
		
		trans.commit();
		
		return cl;
	}
	
	
	public List<Produits> functionProduitsDeCommande( int identifiant )throws Exception {
		
		entity = fact.createEntityManager();
		EntityTransaction trans =entity.getTransaction();
		trans.begin();
		
		Commandes cmd = entity.find(Commandes.class, identifiant);
		
		List<Composante> composant = cmd.getCmp();
		
		List<Produits> prd = new ArrayList<>();
		
        for (int i = 0; i < composant.size(); i++) {
        	
        	
			prd.add(composant.get(i).getProduit());
			
		}
        
		
		trans.commit();
		return prd;
		
	}
	
	public void AjouterCommande( Date dtC ,boolean etatC,int idC,int idP,int quantite) {
		entity = fact.createEntityManager();
		EntityTransaction trans =entity.getTransaction();
		trans.begin();
		
		Commandes cmd = new Commandes();
		cmd.setClients(entity.find(Clients.class, idC));
		cmd.setDateCommande(dtC);
		cmd.setEtat(etatC);
		entity.persist(cmd);
		
		Composante cmp = new Composante();	
		cmp.setCommande(cmd);
		cmp.setProduit(entity.find(Produits.class, idP));
		cmp.setQuantite(quantite);
		entity.persist(cmp);
		
		trans.commit();
	}
	
	public void SupprimerCommande(int id) {
		
		entity = fact.createEntityManager();
		EntityTransaction trans =entity.getTransaction();
		trans.begin();
		

		Commandes cmd = entity.find(Commandes.class, id);
	
		List<Composante> t =cmd.getCmp();
		
		for (int i = 0; i < t.size(); i++) {
			entity.remove(t.get(i));
		}
		entity.remove(cmd);
		
		trans.commit();
		
		
	}
	
	public void ModifierCommande( Date dtC ,boolean etatC,int idC,int idP,int quantite) throws Exception{
		
		entity = fact.createEntityManager();
		EntityTransaction trans =entity.getTransaction();
		trans.begin();
		
		Commandes cmd = entity.find(Commandes.class, idC);
		cmd.setDateCommande(dtC);
		cmd.setEtat(etatC);
		entity.persist(cmd);
		
		Produits prd = entity.find(Produits.class, idP);
		
		List<Composante> compo = cmd.getCmp();
		
		for (int i = 0; i < compo.size(); i++) {
			
			compo.get(i).setProduit(prd);
			compo.get(i).setQuantite(quantite);
			
			entity.persist(compo.get(i));
			
		}
		
	
		trans.commit();
		
	}
	
	
	public void ModifierComposante(int idCompos ,int quantite , int idP) throws Exception {
		
		entity = fact.createEntityManager();
		EntityTransaction trans = entity.getTransaction();
		trans.begin();
		Composante cmp = entity.find(Composante.class, idCompos);
		cmp.setQuantite(quantite);
		cmp.setProduit(entity.find(Produits.class, idP));
		entity.persist(cmp);
		trans.commit();
		
	}
	
	public void SupprimerComposante(int idcompos) throws Exception {
		
		entity = fact.createEntityManager();
		EntityTransaction trans = entity.getTransaction();
		trans.begin();
		entity.remove(entity.find(Composante.class, idcompos));
		trans.commit();
		
	}
	
	
	public  List<Produits> AllProducts() throws Exception{
		
		entity = fact.createEntityManager();
		EntityTransaction trans = entity.getTransaction();
		trans.begin();
		 Query r=entity.createQuery("SELECT u from Produits u ");
			
			List<Produits> rt = r.getResultList();
			trans.commit();
			
			return rt;
	}
	
	
	public void AjouterComposante(int idCom , int idProd , int quantite) throws Exception {
		
		entity = fact.createEntityManager();
		EntityTransaction trans = entity.getTransaction();
		trans.begin();
		Composante compos = new Composante();
		compos.setCommande(entity.find(Commandes.class, idCom));
		compos.setProduit(entity.find(Produits.class, idProd));
		compos.setQuantite(quantite);
		entity.persist(compos);
		trans.commit();

	}
	
	
	
	public static void main(String args []) throws Exception{
		
		Traitements y = new Traitements();
		//y.functionInsertion();
		/*try {
			
			for (int i = 5; i < 17; i++) {
				Commandes cmd =y.functionCommandes(i);
				
				System.out.println(cmd.toString());
				
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			entity.getTransaction().rollback();
		}*/
		
		
			/*try {
			
			for (int i = 1; i < 6; i++) {
				Clients cmd =y.functionClients(i);
				
				System.out.println(cmd.toString());
				
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			entity.getTransaction().rollback();
		}*/
		
	/*	
		try {
			List<Produits> prd = y.functionProduitsDeCommande(10);
			
			for (int i = 0; i <prd.size(); i++) {
				
				
				System.out.println(prd.get(i).toString()+" COMPOSANT: "+prd.get(i).getLsCmp().get(i).toString()+"\n\n");
				
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			entity.getTransaction().rollback();
		}
		*/
		
	/*	y.AjouterCommande(new Date(), true, 1, 1, 33);
		y.AjouterCommande(new Date(), true, 1, 1, 33);
		y.AjouterCommande(new Date(), true, 1, 1, 33);
		y.AjouterCommande(new Date(), true, 1, 1, 33);
		y.AjouterCommande(new Date(), true, 1, 1, 33);
		y.AjouterCommande(new Date(), true, 1, 1, 33);
		y.AjouterCommande(new Date(), true, 1, 1, 33);
		y.AjouterCommande(new Date(), true, 1, 1, 33);
		y.AjouterCommande(new Date(), true, 1, 1, 33);
		y.AjouterCommande(new Date(), true, 1, 1, 33);
		y.AjouterCommande(new Date(), true, 1, 1, 33);
*/
		//y.SupprimerCommande(18);

		//y.ModifierCommande(new Date(), false, 21, 1, 2000);
		//y.AjouterCommande(new Date(), false, 1, 1, 3300);
		
		/*int Id=5;
		Traitements tr = new Traitements();
		
		System.out.println("*******************ID*********************");

		System.out.println(Id);
		
		System.out.println("****************************************");

		java.util.Date Dt =tr.functionCommandes(Id).getDateCommande();
	
		System.out.println("*****************DATE***********************");

		System.out.println(Dt);
		
		System.out.println("****************************************");

		
		Clients cli =tr.functionClients(Id);
		System.out.println("******************CLIENT**********************");

		System.out.println(cli.toString());

		System.out.println("****************************************");

		
		List<Produits> Products=(List<Produits>) tr.functionProduitsDeCommande(Id);
		System.out.println("*******************PRODUITS*********************");

		System.out.println(Products.toString());
		
		System.out.println("****************************************");

		
					
		Commandes cmd = tr.functionCommandes(Id);
		
		System.out.println("***************COMMANDE*************************");

		System.out.println(cmd);
		
		System.out.println("****************************************");
		
		*/
		
	    try {
	    	
	    	//y.SupprimerComposante(30);
	    	
	    	/*for (int i = 0; i < y.AllProducts().size(); i++) {
	    		
	    		System.out.println(y.AllProducts().get(i).toString());
				
			}*/
	    	
	    	//y.AjouterComposante(5, 3, 121);
	    	
	    	//y.ModifierCommande(new Date(), false, 5, 1, 1999);
	    	
	    }catch(Exception e) {
	    	
	    	e.printStackTrace();
	    }
		
	}

}
