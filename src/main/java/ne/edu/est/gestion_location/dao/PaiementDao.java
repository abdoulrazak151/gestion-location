package ne.edu.est.gestion_location.dao;

import ne.edu.est.gestion_location.entities.Bailleur;
import ne.edu.est.gestion_location.entities.Location;
import ne.edu.est.gestion_location.entities.Paiement;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PaiementDao extends UniqueConnection{
    public  boolean createPaiement(Paiement paiement){
        String QUERY="insert into paiement(montant_paye, date_paye, id_location) values (?,?,?)";
        try(PreparedStatement ps=getConnection().prepareStatement(QUERY)){

            ps.setInt(1,paiement.getMontantPaiement());
            ps.setString(2, paiement.getDatePaiement());
            ps.setInt(3, paiement.getLocation().getIdLocation());

            return ps.executeUpdate()>0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean updatePaiement(Paiement paiement){
        String QUERY="update paiment set montant_paye=?, date_paye=?,id_location=? where id_paiement=?";
        try(PreparedStatement ps=getConnection().prepareStatement(QUERY)){
            ps.setInt(1, paiement.getMontantPaiement());
            ps.setString(2, paiement.getDatePaiement());
            ps.setInt(3, paiement.getLocation().getIdLocation());
            ps.setInt(4, paiement.getIdPaiement());
            return ps.executeUpdate()>0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean deletePaiement(Paiement paiement){
        String QUERY="delete from paiement where id_paiement=?";
        try(PreparedStatement ps=getConnection().prepareStatement(QUERY)){
            ps.setInt(1, paiement.getIdPaiement());
            return ps.executeUpdate()>0;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }
    public List<Paiement> getPaiementByLocation(Location location){
        String QUERY ="select * from paiement where id_location=?";
        List<Paiement> paiements=new ArrayList<>();
        try(PreparedStatement ps=getConnection().prepareStatement(QUERY)){
            ps.setInt(1, location.getIdLocation());
            try(ResultSet rs=ps.executeQuery()){
                while (rs.next()){
                    Paiement paiement=new Paiement();
                  paiement.setMontantPaiement(rs.getInt("montant_paye"));
                  paiement.setDatePaiement((rs.getString("date_paye")));
                  paiements.add(paiement);
                }


            }
        }catch(Exception e){e.printStackTrace();}
        return paiements;
    }

    public List<Paiement> getAllPaiement(){
        String QUERY ="select * from paiement";
        List<Paiement> paiements=new ArrayList<>();
        try(PreparedStatement ps=getConnection().prepareStatement(QUERY)){
            try(ResultSet rs=ps.executeQuery()){
                while (rs.next()){
                    Paiement paiement=new Paiement();
                    paiement.setIdPaiement(rs.getInt("id_paiement"));
                    paiement.setMontantPaiement(rs.getInt("montant_paye"));
                    paiement.setDatePaiement((rs.getString("date_paye")));
                    LocationDao locationDao=new LocationDao();
                    Location location=new Location();
                    location.setIdLocation(rs.getInt("id_location"));
                    location=locationDao.getLocationId(location);
                    paiement.setLocation(location);
                    paiements.add(paiement);
                }


            }
        }catch(Exception e){e.printStackTrace();}
        return paiements;
    }
}
