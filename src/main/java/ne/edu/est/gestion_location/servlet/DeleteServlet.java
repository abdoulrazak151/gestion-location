package ne.edu.est.gestion_location.servlet;

import ne.edu.est.gestion_location.dao.BienDao;
import ne.edu.est.gestion_location.dao.LocataireDao;
import ne.edu.est.gestion_location.dao.LocationDao;
import ne.edu.est.gestion_location.dao.PaiementDao;
import ne.edu.est.gestion_location.entities.Bien;
import ne.edu.est.gestion_location.entities.Locataire;
import ne.edu.est.gestion_location.entities.Location;
import ne.edu.est.gestion_location.entities.Paiement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns={"/deleteBien", "/deleteLocation", "/deleteLocataire", "/deletePaiement"})
public class DeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();
        if(path.equals("/deleteBien")){
            int id=Integer.parseInt(request.getParameter("id"));
            BienDao bienDao=new BienDao();

            Bien bien =new Bien();
            bien.setIdBien(id);
            boolean a=bienDao.deleteBien(bien);
            request.setAttribute("delete",a );
            RequestDispatcher dispatcher=getServletContext().getRequestDispatcher("/WEB-INF/views/bien/listBien.jsp");
            dispatcher.forward(request, response);
        }
        if(path.equals("/deleteLocation")){
            int id=Integer.parseInt(request.getParameter("id"));
            LocationDao locationDao=new LocationDao();

            Location location =new Location();
            location.setIdLocation(id);
           boolean b= locationDao.deleteLocation(location);
            request.setAttribute("delete",b );
            RequestDispatcher dispatcher=getServletContext().getRequestDispatcher("/WEB-INF/views/location/listLocation.jsp");
            dispatcher.forward(request, response);
        }
        if(path.equals("/deleteLocataire")){
            int id=Integer.parseInt(request.getParameter("id"));
            LocataireDao locationDao=new LocataireDao();
            Locataire locataire=new Locataire();
            locataire.setIdLocataire(id);
            boolean a=locationDao.deleteLocataire(locataire);
            request.setAttribute("delete",a );
            RequestDispatcher dispatcher=getServletContext().getRequestDispatcher("/WEB-INF/views/locataire/listLocataire.jsp");
            dispatcher.forward(request, response);
        }
        if(path.equals("/deletePaiement")){
            int id=Integer.parseInt(request.getParameter("id"));
            PaiementDao paidDao=new PaiementDao();
            Paiement paie=new Paiement();
            paie.setIdPaiement(id);
            boolean a= paidDao.deletePaiement(paie);
            request.setAttribute("delete",a );
            RequestDispatcher dispatcher=getServletContext().getRequestDispatcher("/WEB-INF/views/paiement/listPaiement.jsp");
            dispatcher.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
