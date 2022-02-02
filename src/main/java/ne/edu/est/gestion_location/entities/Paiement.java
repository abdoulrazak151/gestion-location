package ne.edu.est.gestion_location.entities;

import java.util.Date;

public class Paiement {
    private int idPaiement;
    private int montantPaiement;
    private String datePaiement;
    private Location location =new Location();

    public int getIdPaiement() {
        return idPaiement;
    }

    public void setIdPaiement(int idPaiement) {
        this.idPaiement = idPaiement;
    }

    public int getMontantPaiement() {
        return montantPaiement;
    }

    public void setMontantPaiement(int montantPaiement) {
        this.montantPaiement = montantPaiement;
    }

    public String getDatePaiement() {
        return datePaiement;
    }

    public void setDatePaiement(String datePaiement) {
        this.datePaiement = datePaiement;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
