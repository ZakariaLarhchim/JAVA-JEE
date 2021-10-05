package web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.Clients;
import DAO.Commandes;
import DAO.Produits;
import DAO.Traitements;


@WebServlet("/SuppressionComposante")
public class SuppressionComposante extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public SuppressionComposante() {
       
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
		Integer a = Integer.valueOf(request.getParameter("composantesupp"));
		Traitements tr = new Traitements();
		System.out.println(a);
		try {
			tr.SupprimerComposante(a);
			response.sendRedirect("Controller");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
