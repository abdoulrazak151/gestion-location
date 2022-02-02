package ne.edu.est.gestion_location.servlet;

import ne.edu.est.gestion_location.dao.*;
import ne.edu.est.gestion_location.entities.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns={"/userView","/listBien", "/listLocataire", "/listLocation","/bien","/location", "/locataire","/paiement", "/listPaiement"})
public class ListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();
        if(path.equals("/listBien") || path.equals("/bien")){
            BienDao bienDao=new BienDao();
            List<Bien> biensList= bienDao.getAllBien();
            request.setAttribute("listBien",biensList);
            RequestDispatcher dispatcher=getServletContext().getRequestDispatcher("/WEB-INF/views/bien/listBien.jsp");
            dispatcher.forward(request, response);
        }
        if(path.equals("/listLocation") || path.equals("/location")){
            LocationDao locationDao=new LocationDao();
            List<Location> locations=locationDao.getAllLocation();
            request.setAttribute("listLocation",locations );
            RequestDispatcher dispatcher=getServletContext().getRequestDispatcher("/WEB-INF/views/location/listLocation.jsp");
            dispatcher.forward(request, response);
        }
        if(path.equals("/listLocataire") || path.equals("/locataire")){
            LocataireDao locataireDao=new LocataireDao();
            List<Locataire> locataires=locataireDao.getAllLocataire();
            request.setAttribute("listLocataire", locataires);
            RequestDispatcher dispatcher=getServletContext().getRequestDispatcher("/WEB-INF/views/locataire/listLocataire.jsp");
            dispatcher.forward(request, response);
        }
        if(path.equals("/listPaiement") || path.equals("/paiement")){
            PaiementDao paiementDao=new PaiementDao();
            List<Paiement> list=new ArrayList<>();
            list=paiementDao.getAllPaiement();
            request.setAttribute("list", list);
            RequestDispatcher dispatcher=getServletContext().getRequestDispatcher("/WEB-INF/views/paiement/listPaiement.jsp");
            dispatcher.forward(request, response);
        }
        if (path.equals("/userView")){
            String id=request.getParameter("id");
            User user = new User();
            user.setIdUser(Integer.parseInt(id));
            Bailleur bailleur=new Bailleur();
            bailleur.setIdBailleur(Integer.parseInt(id));
            BailleurDao bailleurDao=new BailleurDao();
           bailleur =bailleurDao.getBailleurById(Integer.parseInt(id));
            UserDao userDao=new UserDao();
            user=userDao.getUserById(Integer.parseInt(id));
            request.setAttribute("updateBailleur", bailleur);
            request.setAttribute("updateUser", user);
            RequestDispatcher dispatcher=getServletContext().getRequestDispatcher("/WEB-INF/views/user/userView.jsp");
            dispatcher.forward(request, response);


        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}
