package web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.Clients;
import DAO.Commandes;
import DAO.Produits;
import DAO.Traitements;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
@Override
	public void init() throws ServletException {
	

	}
  
    public Controller() {
    	
     
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("Date", new Date());
		request.setAttribute("Client", new Clients());
		request.setAttribute("Produits", new ArrayList<Produits>());
		request.setAttribute("Commande", new Commandes());
		request.setAttribute("Allproducts", new ArrayList<Produits>());


		request.getRequestDispatcher("index.jsp").forward(request, response);

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		try {
			
			Traitements tr = new Traitements();
			
			Integer Id = Integer.valueOf(request.getParameter("cmd"));
			HttpSession session =request.getSession();
			session.setAttribute("numeroCommande", Id);

			System.out.println("*******************ID*********************");

			System.out.println(Id);
			
			System.out.println("****************************************");

			java.util.Date Dt =tr.functionCommandes(Id).getDateCommande();
		
			System.out.println("*****************DATE***********************");

			System.out.println(Dt);
			
			System.out.println("****************************************");

			request.setAttribute("Date", Dt);
			
			Clients cli =tr.functionClients(Id);
			System.out.println("******************CLIENT**********************");

			System.out.println(cli.toString());

			System.out.println("****************************************");

			request.setAttribute("Client", cli);
			
			List<Produits> Products=(List<Produits>) tr.functionProduitsDeCommande(Id);
			System.out.println("*******************PRODUITS*********************");

			System.out.println(Products.toString());
			
			System.out.println("****************************************");

			
			request.setAttribute("Produits", Products);
						
			Commandes cmd = tr.functionCommandes(Id);
			
			System.out.println("***************COMMANDE*************************");

			System.out.println(cmd);
			
			System.out.println("****************************************");
			
			request.setAttribute("Commande", cmd);
			
			System.out.println("******************ALL PRODUCTS**********************");

			List<Produits> po = tr.AllProducts();
			
			System.out.println(po.toString());
			
			request.setAttribute("Allproducts", po);
			
			System.out.println("****************************************");
			
			request.getRequestDispatcher("index.jsp").forward(request, response);
			
			

		}catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "yes");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		
		
	}

}
