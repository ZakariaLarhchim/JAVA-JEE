<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="DAO.Clients"%>
<%@page import="DAO.Produits"%>
<%@page import="DAO.Commandes"%>
<%@page import="java.util.*"%>





<!DOCTYPE html>
<html lang="en">
<head>
<script src='https://kit.fontawesome.com/a076d05399.js'></script>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
      <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" ></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" ></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" ></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="path/to/font-awesome/css/font-awesome.min.css">

    <style>

	*{
	margin:auto;
	text-align:center;
	}
	
	#my_id1>table tr,td,th, #my_id2>table tr,td,th{
	
	border:1px solid navy;
	
	
	}
	
	#my_id1>table td,#my_id2>table td {border: none !important; border-right: solid 1px navy !important;}

#feedback-page{
	text-align:center;
}

#form-main{
	width:100%;
	float:left;
	padding-top:0px;
}

#form-div {
	background-color:rgba(72,72,72,0.4);
	padding-left:35px;
	padding-right:35px;
	padding-top:35px;
	padding-bottom:50px;
	width: 450px;
	float: left;
	left: 50%;
	position: absolute;
  margin-top:30px;
	margin-left: -260px;
  -moz-border-radius: 7px;
  -webkit-border-radius: 7px;
}

.feedback-input {
	color:#3c3c3c;
	font-family: Helvetica, Arial, sans-serif;
  font-weight:500;
	font-size: 18px;
	border-radius: 0;
	line-height: 22px;
	background-color: #fbfbfb;
	padding: 13px 13px 13px 54px;
	margin-bottom: 10px;
	width:100%;
	-webkit-box-sizing: border-box;
	-moz-box-sizing: border-box;
	-ms-box-sizing: border-box;
	box-sizing: border-box;
  border: 3px solid rgba(0,0,0,0);
}

.feedback-input:focus{
	background: #fff;
	box-shadow: 0;
	border: 3px solid #3498db;
	color: #3498db;
	outline: none;
  padding: 13px 13px 13px 54px;
}

.focused{
	color:#30aed6;
	border:#30aed6 solid 3px;
}

/* Icons ---------------------------------- */
#name{
	background-image: url(http://rexkirby.com/kirbyandson/images/name.svg);
	background-size: 30px 30px;
	background-position: 11px 8px;
	background-repeat: no-repeat;
}

#name:focus{
	background-image: url(http://rexkirby.com/kirbyandson/images/name.svg);
	background-size: 30px 30px;
	background-position: 8px 5px;
  background-position: 11px 8px;
	background-repeat: no-repeat;
}

#email{
	background-image: url(http://rexkirby.com/kirbyandson/images/email.svg);
	background-size: 30px 30px;
	background-position: 11px 8px;
	background-repeat: no-repeat;
}

#email:focus{
	background-image: url(http://rexkirby.com/kirbyandson/images/email.svg);
	background-size: 30px 30px;
  background-position: 11px 8px;
	background-repeat: no-repeat;
}

#comment{
	background-image: url(http://rexkirby.com/kirbyandson/images/comment.svg);
	background-size: 30px 30px;
	background-position: 11px 8px;
	background-repeat: no-repeat;
}

textarea {
    width: 100%;
    height: 150px;
    line-height: 150%;
    resize:vertical;
}

input:hover, textarea:hover,
input:focus, textarea:focus {
	background-color:white;
}

#button-blue{
	font-family:  Arial, Helvetica, sans-serif;
	float:left;
	width: 100%;
	border: #fbfbfb solid 4px radius;
	cursor:pointer;
	background-color: #3498db;
	color:green;
	font-size:24px;
	padding-top:22px;
	padding-bottom:22px;
	-webkit-transition: all 0.3s;
	-moz-transition: all 0.3s;
	transition: all 0.3s;
  margin-top:-4px;
  font-weight:700;
}

#button-blue:hover{
	background-color: rgba(0,0,0,0);
	color: blue;
}
	
.submit:hover {
	color: #3498db;
}
	
.ease {
	width: 0px;
	height: 74px;
	background-color: #fbfbfb;
	-webkit-transition: .3s ease;
	-moz-transition: .3s ease;
	-o-transition: .3s ease;
	-ms-transition: .3s ease;
	transition: .3s ease;
}

.submit:hover .ease{
  width:100%;
  background-color:white;
}

@media only screen and (max-width: 580px) {
	#form-div{
		left: 3%;
		margin-right: 3%;
		width: 88%;
		margin-left: 0;
		padding-left: 3%;
		padding-right: 3%;
	}
}


.btn {
  background-color: red;
  border: none;
  color: white;
  padding: 12px 16px;
  font-size: 16px;
  cursor: pointer;
}

/* Darker background on mouse-over */
.btn:hover {
  background-color: RoyalBlue;
}


    </style>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>
    <link href="style.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
</head>
<body>
    <% 
    
    
    Clients cli = new Clients();
    
    
    cli=(Clients)request.getAttribute("Client");
    
    if(cli==null){
    	cli = new Clients();
    }
    
 
    
    List<Produits> arr= ( List<Produits> )request.getAttribute("Produits");
    
    List<Produits> AllProducts= ( List<Produits> )request.getAttribute("Allproducts");

    
    if(AllProducts==null){
    	AllProducts=new ArrayList<Produits>();
    }
    
    if(arr==null){
    	arr=new ArrayList<Produits>();
    }
   

    java.util.Date dt =(Date)request.getAttribute("Date");
    

    
    Commandes cn= (Commandes)request.getAttribute("Commande");
    
    if(cn==null){
    	cn= new Commandes();
    }
    

    
    %>
    
    
    
	   
    <hr>
    <h1>Commandes:</h1>
    <hr>

    <form action="Controller" method="post">
       <table ><tr class='table borderless'><td  style="border-right:none!important"><input class="form-control" id="formGroupExampleInput" placeholder="Numéro Commande" type="text" name="cmd"></td> </tr><tr class='table borderless'><td style="border-right:none!important"><input type="submit" value="Chercher" class="btn btn-danger" ></td></tr></table>
    </form>
    <p style="color:red;margin:auto;text-align:center">
    
    <%
    
    if(request.getAttribute("error")!=null){
    
    	out.println("erreur de saisie et/ou numéro invalide");
    
    }
    
    else if(arr.size()==0){
    
    %>
  
    </p>
    
   
    <p style="color:blue;margin:auto;text-align:center">
    <% 
      out.println("Entrez un nombre");
    
    }else{
    %>
    </p>
    
    

 
<div id="my_id2" >
    <hr>

    <span  style="margin:0 auto; width: 300px; text-align: center;" >Date de Commande: <%=dt %></span>

    <hr>
<table>
  <h1>Client:</h1>
   <ul>
    
  <tr>
    <td><li>Nom du Client:<%= cli.getNom() %></li></td>
  </tr>
  <tr>
    <td><li>Email:<%= cli.getEmail() %></li></td>
  </tr>
     </ul>
 
</table>
    
   
      
       

    <hr>

    <h1>Liste des Composantes:</h1>
 <table>
    
        <tr>
            <th>Numero Composante</th>
            <th>Désignation</th>
            <th>Prix</th>
            <th>Quantité</th>
            <th>Montant</th>
            <th>Modifier</th>
            <th>Supprimer</th>
        </tr>

        
     <% for(int i=0;i<cn.getCmp().size();i++){
     
    	 int id =cn.getCmp().get(i).getID_Composante();
   
     %>
        <tr>
            <td>	<%=id %>	</td>
            <td>	<%=cn.getCmp().get(i).getProduit().getDes() %> 	</td>
            <td>	<%= cn.getCmp().get(i).getProduit().getPrix() %> DHS	</td>
            <td>	<%=cn.getCmp().get(i).getQuantite() %>	</td>
            <% double ts =cn.getCmp().get(i).getProduit().getPrix()*cn.getCmp().get(i).getQuantite(); %>
            <td>	<%= ts%> DHS	</td>
            <td><button  data-toggle="modal" data-target="#exampleModal<%=i %>" class="cart-button"><i class='far fa-edit' style='font-size:22px;color:blue'></i></button></td>
            <%// <td><i class='fas fa-cart-arrow-down' style='font-size:22px;color:blue'></i></td>%>
            <td> <form action="SuppressionComposante" method="POST"><button name="composantesupp" value="<%=id%>" type="submit" class="btn"><i  style='font-size:22px;color:red' class="fa fa-trash"></i></button></form></td>
        </tr>
        
             
 
        <% }%> 

<% 

double total=0;

for(int i=0;i<arr.size();i++) {
	
	total=total+(cn.getCmp().get(i).getProduit().getPrix()*cn.getCmp().get(i).getQuantite());
}


%>
        <tfoot>
            <tr>
                <td colspan="3"></td>
                <td>Total</td>
                <td><%=total %> DHS</td>
            </tr>
        </tfoot>


    </table>



</div>
<h1>Ajouter Composant</h1>
<form action="AjouterProduit" method="post">
       <table >
       
       <tr class='table borderless'>
       
	       <td  style="border-right:none!important">
	       <select class="form-control" id="formGroupExampleInput" name="produit" >
	       
			    <option value="">--Choisissez Produit--</option>
			    <% 
			    for(int i=0;i<AllProducts.size();i++){
			    	  %>
			    	<option value=<%=AllProducts.get(i).getId() %>><%= AllProducts.get(i).getDes() %></option>
			  <%} %>
			    
			  
			    
			   
		   </select>
	       </td>
	       
       </tr>
       
       <tr class='table borderless'>
             <td style="border-right:none!important">
                  <input class="form-control" id="formGroupExampleInput" type="number" name="quantite" placeholder="Quantité">
             </td>
       </tr>
       
       <tr class='table borderless'>
       
	       <td style="border-right:none!important">
	       <input type="submit" value="Ajouter" class="btn btn-danger" >
	       </td>
       
       </tr>
       
       </table>
</form>
  
  
<hr>
<div id="my_id1">


    <h1>La Commande:</h1>
 <table >
    
        <tr>
            <th>Id Commande</th>
            <th>Date Commande</th>
            <th>Etat Commande</th>
            <th>Id Client</th>
        </tr>

        


        <tr>
            <td>	<%=cn.getId() %>	</td>
            <td>	<%=cn.getDateCommande() %> 	</td>
            <td>	<% if(cn.isEtat()){ out.println("payé"); } else { out.println("commandé");}%>	</td>
            <td>	<%= cn.getClients().getId() %>	</td>
           
            
        </tr>

 
      






    </table>



</div>

<hr>

<%} %>



 <!-- Modal -->
 <%for(int i=0;i<cn.getCmp().size();i++){ %>
              <form action="ModifierComposante" method="post">
                   <div class="modal fade" id="exampleModal<%=i %>" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true" >
                    <div class="modal-dialog" role="document">
                      <div class="modal-content">
                        <div class="modal-header">
                          <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                          </button>
                        </div>
                        <div class="modal-body">
                          <p style="color:red;font-size:50px;font-weight:50px"><%= cn.getCmp().get(i).getProduit().getDes() %></p>
                                 <table >
       
       <tr class='table borderless'>
       
	       <td  style="border-right:none!important">
	       <select class="form-control" id="formGroupExampleInput" name="comp" >
	       
			    <option value="">--Choisissez Produit--</option>
			    <% 
			    for(int jj=0;jj<AllProducts.size();jj++){
			    	  %>
			    	<option value=<%=AllProducts.get(jj).getId() %> > <%= AllProducts.get(jj).getDes() %></option>
			    	
			  <%} %>
			    
			  
			    
			   
		   </select>
		   
		                     <input type="hidden" value="<%= cn.getCmp().get(i).getID_Composante() %>" name="prodcomp">
	       </td>
	       
       </tr>
       
       <tr class='table borderless'>
             <td style="border-right:none!important">
                  <input class="form-control" id="formGroupExampleInput" type="number" name="cquantite" placeholder="Quantité">
                 
             </td>
       </tr>
       
     
       </table>
                        </div>
                        
                        <div class="modal-footer">
                          <button type="submit" class="btn btn-danger">Modifier</button>
                        </div>
                      </div>
                    </div>
                  </div>
              </form>
            <!---->
<%} %>

             
</body>
</html>