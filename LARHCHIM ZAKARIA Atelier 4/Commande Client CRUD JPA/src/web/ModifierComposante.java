package web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

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


@WebServlet("/ModifierComposante")
public class ModifierComposante extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public ModifierComposante() {
        
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
	
		HttpSession session =request.getSession();
		int Id = (int) session.getAttribute("numeroCommande");
		
		Traitements tr = new Traitements();
		System.out.println("IdComposante"+request.getParameter("prodcomp")+"*Quantite* "+ request.getParameter("cquantite")+" *Description*"+request.getParameter("comp"));

	
		try {
			
			tr.ModifierComposante(Integer.valueOf(request.getParameter("prodcomp")),  Integer.valueOf(request.getParameter("cquantite")), Integer.valueOf(request.getParameter("comp")));
			response.sendRedirect("Controller");
			
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
