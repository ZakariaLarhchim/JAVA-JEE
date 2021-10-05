package web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.Produits;
import DAO.Traitements;


@WebServlet("/AjouterProduit")
public class AjouterProduit extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public AjouterProduit() {
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
			request.getRequestDispatcher("index.jsp").forward(request, response);



	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session =request.getSession();
		int Id = (int) session.getAttribute("numeroCommande");
		Integer numero =Integer.valueOf(request.getParameter("produit"));
		Integer quantite = Integer.valueOf(request.getParameter("quantite"));
		
		Traitements tr = new Traitements();
		
		try {
			tr.AjouterComposante(Id, numero, quantite);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}

}
