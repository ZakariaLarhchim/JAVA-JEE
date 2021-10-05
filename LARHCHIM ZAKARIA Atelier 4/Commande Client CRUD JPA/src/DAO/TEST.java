package DAO;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Blob;
import java.util.Date;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.hibernate.engine.jdbc.BlobProxy;


public class TEST {

	private static  EntityManager entity;
	public static void main(String[] args) {
		
		EntityManagerFactory fact=Persistence.createEntityManagerFactory("is");
		
		entity=fact.createEntityManager();
		
		EntityTransaction trans =entity.getTransaction();
		trans.begin();
		
		
		try {
			/*Produits a2 = new Produits();
			a2.setDes("IPHONE 11 PRO MAX");
			a2.setPrix(15000);
			a2.setQuantite(120);
			a2.setImageProduit(BlobProxy.generateProxy(Produits.getImage()));
			entity.persist(a2);*/
			
			/*entity.persist(new Clients("toto","machin","sds","1223"));
			entity.persist(new Clients("toDFDto","machDFFDin","sDFDFds","1223"));
			entity.persist(new Clients("toDFto","macDFDFhin","sdDFDs","12FDDF23"));
			entity.persist(new Clients("toto","macDFDFhin","sds","1223"));
			entity.persist(new Clients("toDFto","macFDDhin","sds","1223"));
			entity.persist(new Clients("toDFto","machin","sdDFs","1223"));
			entity.persist(new Clients("DF","mDFachin","sDFds","1223"));*/
			
           Query r=entity.createQuery("SELECT u from Clients u ");
			
			List<Clients> rt = r.getResultList();
			
			for (int i = 0; i <rt.size(); i++) {
				
				System.out.println(rt.get(i).toString());
				
			}

			
			/*Clients c =entity.find(Clients.class, 1);
			Commandes cmd = new Commandes();
			cmd.setDate(new Date());
			cmd.setEtat(true);
			cmd.setClients(c);
			entity.persist(cmd);*/
			
			/*Produits pr = entity.find(Produits.class, 1);
			Commandes cd =entity.find(Commandes.class, 1);
			Composante cp = new Composante();
			cp.setQuantite(10);
			cp.setProduit(pr);
			cp.setCommande(cd);
			entity.persist(cp);*/
			
			//Commandes cd =entity.find(Commandes.class, 1);
			//Composante  ct = entity.find(Composante.class, 1);
			//entity.remove(cd);
			
			/*Produits ptest = entity.find(Produits.class, 1);
			Blob image = ptest.getImageProduit();
		    InputStream inputStream = image.getBinaryStream();
		    Files.copy(inputStream, Paths.get("./WebContent/img/ancien/"+ptest.getDes()+".JPG"),StandardCopyOption.REPLACE_EXISTING);*/
		
			/*Clients a1 = new Clients();
			a1.setEmail("ismaillarhchim864@gmail.com");
			a1.setPassword(MD5Hash.getMd5("LARHCHIM123"));
			a1.setNom("LARHCHIM");
			a1.setPrenom("ISMAIL");
			entity.persist(a1);
			
			Commandes a4 = new Commandes();
			a4.setDate(new Date());
			a4.setEtat(false);
			a4.setClients(a1);
			entity.persist(a4);
			
		
			
		
			Composante a3 = new Composante();
			a3.setQuantite(10);
		    a3.setProduit(a2);
		    a3.setCommande(a4);
			entity.persist(a3);*/
			
			
			/*Produits a2 = entity.find(Produits.class, 1);
			a2.setDisponibilite(true);
			entity.persist(a2);*/
		
			
			trans.commit();
			
			/*Clients a = new Clients("QODIA","BADER-EDDINE","QODIA-EDDINE@gmail.com","123456789");
			Produits p = new Produits("IPHONE",10523);
			
			Commandes c = new Commandes();
			c.setQuantite("100");
			c.setProduits(p);
			c.setClients(a);
			c.setPrix(5555);
			c.setDate(new Date());
		
			entity.persist(a);
			entity.persist(p);
			entity.persist(c);
			trans.commit();*/
			
			/*a.setEmail("johnDoe@gmail.com");
			entity.persist(a);
			
			Clients o = new Clients("LARHCHIM","ISMAIL","L-MALL@gmail.com","123SDS456789");
			entity.persist(o);*/
			//entity.persist(c);
			
			
			/*Clients c =entity.find(Clients.class, 1);
			List<Commandes> z = c.getProd();
			for(int i =0;i<z.size();i++) {
				System.out.println(z.get(i).getProduits().getId());
				entity.remove(z.get(i));
			}*/
		
			
			//entity.remove(z);
			/*d.setClients(c);
				Produits p = entity.find(Produits.class, 4);
				d.setProduits(p);
				d.setQuantite("20");*/
				//entity.remove(d);

		

			
			//Clients f = entity.find(Clients.class, 1);
			//f.setPassword("1234QODIA");
			//entity.merge(f);
		/*Commandes e =entity.find(Commandes.class, 1);
			entity.remove(e);*/
			
			//entity.persist(a);
			
			/*Customer customer = em.find(id, Customer.class); //Consider em as JPA EntityManager
			customer.setName(customerDto.getName);
			em.merge(customer);*/
			/*c.setQuantite("50");
			c.setClients(a);
			c.setProduits(p);
			
			entity.persist(c);*/
			
			
			
			/*Produits p = new Produits("Samsung",4500.0);
			entity.persist(p);
			entity.persist(new Produits("HuaweiGT",9400.0));
			entity.persist(new Produits("imac",11000.0));
			entity.persist(new Produits("TABLET",1500.0));
			entity.persist(new Produits("SMARTTV",23000.0));*/

			//entity.persist( new Clients("QODIA","BADER-EDDINE","QODIA-EDDINE@gmail.com","123456789"));
			
			/*Clients r = entity.find(Clients.class, 1);
			Produits t =entity.find(Produits.class, 4);
			Commandes cd = new Commandes();
			
			cd.setClients(r);
			cd.setProduits(t);
			cd.setDate(new Date());
			cd.setPrix(569);
			cd.setQuantite("16");
			entity.persist(cd);*/
			
			/*Commandes t=entity.find(Commandes.class,1) ;
			entity.remove(t);*/
			
		/*	Query r=entity.createQuery("SELECT u from Produits u ");*/
			
			//List<Produits> rt = r.getResultList();
			/*Commandes y = entity.find(Commandes.class, 6);
			
			entity.remove(y);
			Clients r =entity.find(Clients.class,1) ;
			List<Commandes> rt =r.getProd();
			for (Commandes produits : rt) {
				System.out.println(produits.toString()+"**\n\n");
			}
			trans.commit();*/
			
		}catch(Exception e) {
			e.printStackTrace();
			trans.rollback();
		}

	}

}
