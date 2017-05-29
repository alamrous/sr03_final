
<%@page import="beans.Client"%>
<nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="GameController">SR03</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
<% if(request.getSession().getAttribute("client") == null){ %>
            <li><a href="CreationCompte.jsp"><button class="btn btn-info">Création de compte</button> </a></li>
            <li><a href="ConnexionCompte.jsp"><button class="btn btn-success">Connexion</button></a></li>
<%} else  {%>            
            <li><a href="ClientCompte"><button class="btn btn-info">
             Mon compte
             </button>
             </a>
             </li>
            <li><a href="ClientPanierShow">
            <button class="btn btn-success">
            Mon panier
            </button></a></li>
            <% Client client = (Client)request.getSession().getAttribute("client"); %>
            <li><a>Bonjour, <%= client.getName()+" "+client.getFirstname() %></a></li>
          <li><a href="GameController"><button class="btn btn-danger"> Deconnexion</button></a></li>
          
<%} %>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>
