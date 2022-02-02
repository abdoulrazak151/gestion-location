package ne.edu.est.gestion_location.entities;

import java.util.ArrayList;
import java.util.List;

public class Bien {
    private int idBien;
    private String addresseBien;
    private int surfaceBien;

    public List<Equipement> getEquipements() {
        return equipements;
    }
    public void setListEquipement(List<Equipement> equipement){
        this.equipements=equipement;
    }
    public void setEquipements(Equipement equipements) {
        this.equipements.add(equipements);
    }

    List<Equipement> equipements=new ArrayList<Equipement>();

    public int getIdBien() {
        return idBien;
    }

    public void setIdBien(int idBien) {
        this.idBien = idBien;
    }

    public String getAddresseBien() {
        return addresseBien;
    }

    public void setAddresseBien(String addresseBien) {
        this.addresseBien = addresseBien;
    }

    public int getSurfaceBien() {
        return surfaceBien;
    }

    public void setSurfaceBien(int surfaceBien) {
        this.surfaceBien = surfaceBien;
    }
}
