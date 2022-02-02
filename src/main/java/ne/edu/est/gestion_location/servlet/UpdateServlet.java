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
import java.util.Arrays;
import java.util.List;

@WebServlet(urlPatterns={"/updateBien", "/updateLocataire", "/updateLocation", "/updatePaiement"})
public class UpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();
            if (path.equals("/updateUser")){
                String id=request.getParameter("id");
                User user = new User();
                user.setIdUser(Integer.parseInt(id));
                UserDao userDao=new UserDao();
                user=userDao.getUserById(Integer.parseInt(id));
                request.setAttribute("updateUser", user);
                RequestDispatcher dispatcher=getServletContext().getRequestDispatcher("/WEB-INF/views/user/updateUser");
                dispatcher.forward(request, response);


            }
            if(path.equals("/updateBien")){
                int id=Integer.parseInt(request.getParameter("id"));
                BienDao bienDao=new BienDao();
                Bien bien =bienDao.getBienById(id);
                request.setAttribute("updateBien", bien);
                RequestDispatcher dispatcher=getServletContext().getRequestDispatcher("/WEB-INF/views/bien/updateBien.jsp");
                dispatcher.forward(request, response);
            }
            if(path.equals("/updateLocation")){
                int id=Integer.parseInt(request.getParameter("id"));
                LocationDao lo=new LocationDao();
                Location l=lo.getAllLocationsById(id);
                request.setAttribute("updateLocation", l);
                RequestDispatcher dispatcher=getServletContext().getRequestDispatcher("/WEB-INF/views/location/updateLocation");
                dispatcher.forward(request,response);
            }
            if(path.equals("/updateLocataire")){
                int id =Integer.parseInt(request.getParameter("id"));
                LocataireDao locataireDao=new LocataireDao();
                Locataire locataire=locataireDao.getLocataireById(id);
                request.setAttribute("updateLocataire",locataire);
                RequestDispatcher dispatcher=getServletContext().getRequestDispatcher(("/WEB-INF/views/locataire/updateLocataire.jsp"));
                dispatcher.forward(request, response);
            }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String path = request.getServletPath();
            String errorMessage="";
        if (path.equals("/updateBien")) {
            String id=request.getParameter("id");
            String addresse = request.getParameter("addresse_bien");
            String surface = request.getParameter("surface_bien");
            String equipment = request.getParameter("equipement_bien");
            List<String> list ;
            list = Arrays.asList(equipment.split(","));
            if (addresse.isEmpty() && surface.isEmpty() && list.isEmpty()) {
                errorMessage = "veuiellez renseigner tous les champs";
                request.setAttribute("errorMessage", errorMessage);
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/bien/updateBien.jsp");
                dispatcher.forward(request, response);
            } else {
                try {
                    List<Equipement> equipement = new ArrayList<Equipement>();

                    for (String a:list){
                        Equipement e= new Equipement();
                        e.setDesignation(a);
                        equipement.add(e);
                    }

                    Bien bien = new Bien();
                    bien.setIdBien(Integer.parseInt(id));
                    bien.setSurfaceBien(Integer.parseInt(surface));
                    bien.setAddresseBien(addresse);
                    bien.setListEquipement(equipement);
                    BienDao bienDao=new BienDao();

                    boolean a=bienDao.updateBien(bien);

                    if(a==true){
                        errorMessage = "Enregistrement effectue avec succes";
                        request.setAttribute("errorMessage", errorMessage);
                        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/bien/updateBien.jsp");
                        dispatcher.forward(request, response);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }

//        update locataire

        if(path.equals("/updateLocataire")){
            String id=request.getParameter("id");
            String nom=request.getParameter("nom_locataire");
            String prenom1=request.getParameter("prenom1");
            String prenom2=request.getParameter("prenom2");
            String addresse=request.getParameter("addresse");
            String telephone=request.getParameter("telephone");
            if(prenom2.isEmpty()) prenom2="a";
            String email=request.getParameter("email");
            String garant=request.getParameter("garant");
            List<String> listGarant=Arrays.asList(garant.split(","));
            if(nom.isEmpty() || prenom1.isEmpty() || addresse.isEmpty() || telephone.isEmpty() || email.isEmpty() || garant.isEmpty()){
                errorMessage="ces champs ne doivent pas etre vide";
                request.setAttribute("errorMessage", errorMessage);
                RequestDispatcher dispatcher= getServletContext().getRequestDispatcher("/WEB-INF/views/locataire/updateLocataire.jsp");
                dispatcher.forward(request, response);
            }
            else{
                try{
                    List<Garant> garants= new ArrayList<>();
                    for (String a:listGarant){
                        Garant g= new Garant();
                        g.setDesignationGarant(a);
                        garants.add(g);
                    }
                    Locataire loc=new Locataire();
                    loc.setIdLocataire(Integer.parseInt(id));
                    loc.setNomLocataire(nom);
                    loc.setPrenom1Locataire(prenom1);
                    loc.setPrenom2Locataire(prenom2);
                    loc.setEmailLocataire(email);
                    loc.setGarantsList(garants);
                    loc.setAddresseLocataire(addresse);
                    loc.setTelephoneLocataire(telephone);
                    LocataireDao dao=new LocataireDao();
                    boolean a =dao.createLocataire(loc);
                    if(a==true){
                        errorMessage="enregistrement effectue avec succes ";
                        request.setAttribute("errorMessage", errorMessage);
                        RequestDispatcher dispatcher= getServletContext().getRequestDispatcher("/WEB-INF/views/locataire/updateLocataire.jsp");
                        dispatcher.forward(request, response);
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
        if(path.equals("/updateLocation")){
            String id=request.getParameter("id");
            String duree=request.getParameter("duree");
            String locataire=request.getParameter("locataire");
            String bien=request.getParameter("bien");
//            HttpSession session=request.getSession();
//            Date date = new Date();
            String delai=request.getParameter("date");
            String montant=request.getParameter("montant");

            String charge=request.getParameter("charge");
            List<String> listGarant=Arrays.asList(charge.split(","));
            if(duree.isEmpty() && locataire.isEmpty() && bien.isEmpty() && delai.isEmpty() && montant.isEmpty()){
                errorMessage="ces champs ne doivent pas etre vide";
                request.setAttribute("errorMessage", errorMessage);
                RequestDispatcher dispatcher= getServletContext().getRequestDispatcher("/WEB-INF/views/location/createLocation.jsp");
                dispatcher.forward(request, response);
            }
            else{
                try{
                    List<Charge> charges= new ArrayList<>();
                    for (String a:listGarant){
                        Charge g= new Charge();
                        g.setDesignation(a);
                        charges.add(g);
                    }
                    Location loc = new Location();
                    loc.setDate(delai);
                    loc.setDuree(duree);
                    loc.setIdLocation(Integer.parseInt(id));
                    loc.setMontant(Integer.parseInt(montant));
//                    User user=(User)session.getAttribute("user");
//                    loc.setUser(user);

                    Bien b=new Bien();
                    b.setIdBien(Integer.parseInt(bien));
                    loc.setBien(b);
                    Locataire l=new Locataire();
                    l.setIdLocataire(Integer.parseInt(locataire));
                    loc.setLocataire(l);
                    loc.setDate(delai);
                    LocationDao dao=new LocationDao();


                    boolean a =dao.updateLocation(loc);
                    if(a==true){
                        errorMessage="enregistrement effectue avec succes ";
                        request.setAttribute("errorMessage", errorMessage);
                        RequestDispatcher dispatcher= getServletContext().getRequestDispatcher("/WEB-INF/views/location/createLocation.jsp");
                        dispatcher.forward(request, response);

                    }
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
//        paiement
        if(path.equals("/updatePaiement")){
            String id=request.getParameter("id");
            String mont=request.getParameter("montant");
            String date=request.getParameter("date");
            String location=request.getParameter("location");
            if(mont.isEmpty() &&  date.isEmpty() && location.isEmpty()){
                errorMessage="ces champs ne doivent pas etre vide";
                request.setAttribute("errorMessage", errorMessage);
                RequestDispatcher dispatcher= getServletContext().getRequestDispatcher("/WEB-INF/views/paiement/updatePaiement.jsp");
                dispatcher.forward(request, response);
            }else {
                try{
                    Paiement paie=new Paiement();
                    paie.setIdPaiement(Integer.parseInt(id));
                    paie.setDatePaiement(date);
                    paie.setMontantPaiement(Integer.parseInt(mont));
                    paie.getLocation().setIdLocation(Integer.parseInt(location));
                    PaiementDao paiementDao=new PaiementDao();
                    boolean b=paiementDao.createPaiement(paie);
                    if(b){
                        errorMessage="enregistrement effectue avec succes ";
                        request.setAttribute("errorMessage", errorMessage);
                        RequestDispatcher dispatcher= getServletContext().getRequestDispatcher("/WEB-INF/views/paiement/updatePaiemnt.jsp");
                        dispatcher.forward(request, response);
                    }
                }catch(Exception e){e.printStackTrace();}
            }

        }

        if(path.equals("/updateUser")){
            String id=request.getParameter("id");
            String nomBailleur = request.getParameter("nom_bailleur");
            String telephoneBailleur = request.getParameter("telephone_bailleur");
            String emailBailleur = request.getParameter("email_bailleur");
            String prenom1Bailleur = request.getParameter("prenom1");
            String prenom2Bailleur = request.getParameter("prenom2");
            String password1 = request.getParameter("password");
            String password2 = request.getParameter("password_confirmation");

            if (nomBailleur.isEmpty() || emailBailleur.isEmpty() || telephoneBailleur.isEmpty() || password1.isEmpty() || password2.isEmpty()) {
                errorMessage = "ces champs sont requis";
                request.setAttribute("errorMessage", errorMessage);
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/inscription.jsp");
                dispatcher.forward(request, response);
            } else {
                if (!password1.equals(password2)) {
                    errorMessage = "password et password confirmation doivent etre egales";
                    request.setAttribute("errorMessage", errorMessage);
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/inscription.jsp");
                    dispatcher.forward(request, response);

                } else {
                    Bailleur bailleur = new Bailleur();
                    User user = new User();
                    bailleur.setIdBailleur(Integer.parseInt(id));
                    bailleur.setNomBailleur(nomBailleur);
                    bailleur.setPrenom1Bailleur(prenom1Bailleur);
                    bailleur.setPrenom2Bailleur(prenom2Bailleur);
                    bailleur.setEmailBailleur(emailBailleur);
                    bailleur.setTelephoneBailleur(telephoneBailleur);
                    user.setIdUser(Integer.parseInt(id));
                    user.setLogin(emailBailleur);
                    user.setPassword(password1);
                    try {
                        BailleurDao bailleurDao = new BailleurDao();
                        bailleurDao.updateBailleur(bailleur);
                        UserDao userDao = new UserDao();
                        userDao.updateUser(user);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    request.setAttribute("errorMessage", errorMessage);
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/user/userView");
                    dispatcher.forward(request, response);

                }

            }

        }
        if(path.equals("/updateLocataire")){
            String id = request.getParameter("id");
            String nom=request.getParameter("nom_locataire");
            String prenom1=request.getParameter("prenom1");
            String prenom2=request.getParameter("prenom2");
            String addresse=request.getParameter("addresse");
            String telephone=request.getParameter("telephone");
            if(prenom2.isEmpty()) prenom2="a";
            String email=request.getParameter("email");
            String garant=request.getParameter("garant");
            List<String> listGarant=Arrays.asList(garant.split(","));
            if(nom.isEmpty() || prenom1.isEmpty() || addresse.isEmpty() || telephone.isEmpty() || email.isEmpty() || garant.isEmpty()){
                errorMessage="ces champs ne doivent pas etre vide";
                request.setAttribute("errorMessage", errorMessage);
                RequestDispatcher dispatcher= getServletContext().getRequestDispatcher("/WEB-INF/views/locataire/createLocataire.jsp");
                dispatcher.forward(request, response);
            }
            else{
                try{
                    List<Garant> garants= new ArrayList<>();

                    for (String a:listGarant){
                        Garant g= new Garant();
                        g.setDesignationGarant(a);
                        garants.add(g);
                    }
                    Locataire loc=new Locataire();
                    loc.setNomLocataire(nom);
                    loc.setIdLocataire(Integer.parseInt(id));
                    loc.setPrenom1Locataire(prenom1);
                    loc.setPrenom2Locataire(prenom2);
                    loc.setEmailLocataire(email);
                    loc.setGarantsList(garants);
                    loc.setAddresseLocataire(addresse);
                    loc.setTelephoneLocataire(telephone);
                    LocataireDao dao=new LocataireDao();
                    boolean a =dao.updateLocataire(loc);
                    if(a==true){
                        errorMessage="enregistrement effectue avec succes ";
                        request.setAttribute("errorMessage", errorMessage);
                        RequestDispatcher dispatcher= getServletContext().getRequestDispatcher("/WEB-INF/views/locataire/createLocataire.jsp");
                        dispatcher.forward(request, response);
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
    }

}
