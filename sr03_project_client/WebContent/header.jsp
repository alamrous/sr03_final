
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
          <a class="navbar-brand" href="Accueil">SR03</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
<% if(request.getSession().getAttribute("client") == null){ %>
            <li><a href="SignUp.jsp"><button class="btn btn-info">Cr�ation de compte</button> </a></li>
            <li><a href="SignIn.jsp"><button class="btn btn-success">Connexion</button></a></li>
<%} else  {%>  
            <li><a href="Profile.jsp"><button class="btn btn-info">
             Mon compte
             </button>
             </a>
             </li>
            <li><a href="ShowPanier">
            <button class="btn btn-success">
            Mon panier
            </button></a></li>
            <% Client client = (Client)request.getSession().getAttribute("client"); %>
            			<li><img src="http://www.slate.com/content/dam/slate/blogs/moneybox/2014/12/15/the_russian_ruble_is_in_freefall_thanks_north_dakota/145536434-russian-president-vladimir-putin-speaks-during-a-press.jpg.CROP.promo-mediumlarge.jpg" style="width: 50px;height: 50px;margin-left: 10%;border-radius: 50%;"></li>          
            
            <li><a>Bonjour, <%= client.getName()+" "+client.getFirstname() %></a></li>
          <li><a href=Disconnect><button class="btn btn-danger"> Deconnexion</button></a></li>
          
<%} %>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>
