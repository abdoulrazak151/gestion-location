package ne.edu.est.gestion_location.entities;

import java.util.ArrayList;
import java.util.List;

public class Locataire {
    private int idLocataire;
    private String nomLocataire;
    private String prenom1Locataire;
    private String prenom2Locataire;
    private String addresseLocataire;
    private String telephoneLocataire;
    private String emailLocataire;
    private List<Garant> garants=new ArrayList<Garant>();

    public int getIdLocataire() {
        return idLocataire;
    }

    public void setIdLocataire(int idLocataire) {
        this.idLocataire = idLocataire;
    }

    public String getNomLocataire() {
        return nomLocataire;
    }

    public void setNomLocataire(String nomLocataire) {
        this.nomLocataire = nomLocataire;
    }

    public String getPrenom1Locataire() {
        return prenom1Locataire;
    }

    public void setPrenom1Locataire(String prenom1Locataire) {
        this.prenom1Locataire = prenom1Locataire;
    }

    public String getPrenom2Locataire() {
        return prenom2Locataire;
    }

    public void setPrenom2Locataire(String prenom2Locataire) {
        this.prenom2Locataire = prenom2Locataire;
    }

    public String getAddresseLocataire() {
        return addresseLocataire;
    }

    public void setAddresseLocataire(String addresseLocataire) {
        this.addresseLocataire = addresseLocataire;
    }

    public String getTelephoneLocataire() {
        return telephoneLocataire;
    }

    public void setTelephoneLocataire(String telephoneLocataire) {
        this.telephoneLocataire = telephoneLocataire;
    }

    public String getEmailLocataire() {
        return emailLocataire;
    }

    public void setEmailLocataire(String emailLocataire) {
        this.emailLocataire = emailLocataire;
    }

    public List<Garant> getGarants() {
        return garants;
    }

    public void setGarants(Garant garants) {
        this.garants.add(garants);
    }
    public void setGarantsList(List<Garant> garants) {
        this.garants=garants;
    }
}
