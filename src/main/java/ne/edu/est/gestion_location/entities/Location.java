package ne.edu.est.gestion_location.entities;

import ne.edu.est.gestion_location.dao.LocationDao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Location {
    private int idLocation;
     private String duree;
     private int montant;
     private Bien bien=new Bien();
     private Locataire locataire=new Locataire();
     private User user= new User();
     private String date;

    public List<Charge> getCharges() {
        return charges;
    }
    public void setAllCharge(List<Charge> charges){
        this.charges=charges;
    }
    public void setCharges(Charge charges) {
        this.charges.add(charges);
    }

    List<Charge> charges=new ArrayList<Charge>();
    public int getIdLocation() {
        return idLocation;
    }

    public void setIdLocation(int idLocation) {
        this.idLocation = idLocation;
    }

    public String getDuree() {
        return duree;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }

    public int getMontant() {
        return montant;
    }

    public void setMontant(int montant) {
        this.montant = montant;
    }

    public Bien getBien() {
        return bien;
    }

    public void setBien(Bien bien) {

        this.bien = bien;
    }

    public Locataire getLocataire() {
        return locataire;
    }

    public void setLocataire(Locataire locataire) {
        this.locataire = locataire;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


}
