package ne.edu.est.gestion_location.dao;

import ne.edu.est.gestion_location.entities.Bailleur;
import ne.edu.est.gestion_location.entities.Garant;
import ne.edu.est.gestion_location.entities.Locataire;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GarantDao extends UniqueConnection{
    public  boolean createGarant(Garant garant, Locataire locataire){
        String QUERY="insert into garant(designation,valeur,id_locataire) values (?,?,?)";
        LocataireDao ld= new LocataireDao();
        locataire=ld.getLocataire(locataire);
        try(PreparedStatement ps=getConnection().prepareStatement(QUERY)){
            ps.setString(1,garant.getDesignationGarant());
            ps.setString(2, garant.getValeurGarant());
            ps.setInt(3, locataire.getIdLocataire());
            return ps.executeUpdate()>0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean updateGarant(Garant garant){
        String QUERY="update bailleur set designation=?, valeur=? where id_garant=?";
        try(PreparedStatement ps=getConnection().prepareStatement(QUERY)){
            ps.setString(1, garant.getDesignationGarant());
            ps.setString(2, garant.getValeurGarant());
            ps.setInt(3,garant.getIdGarant());
            return ps.executeUpdate()>0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean deleteGarant(Garant garant){
        String QUERY="delete from garant where id_garant=?";
        try(PreparedStatement ps=getConnection().prepareStatement(QUERY)){
            ps.setInt(1, garant.getIdGarant());
            return ps.executeUpdate()>0;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }
    public List<Garant> getGarantByLocataire(Locataire locataire){
        String QUERY ="select * from garant where id_locataire=?";
        List<Garant> garants=new ArrayList<>();
        try(PreparedStatement ps=getConnection().prepareStatement(QUERY)){
            ps.setInt(1, locataire.getIdLocataire());
            try(ResultSet rs=ps.executeQuery()){
                while (rs.next()){
                    Garant garant=new Garant();
                    garant.setDesignationGarant(rs.getString("designation"));
                    garant.setValeurGarant(String.valueOf(rs.getInt("valeur")));
                    garants.add(garant);

                }


            }
        }catch(Exception e){e.printStackTrace();}
        return garants;
    }

    public List<Garant> getAllGarant(){
        String QUERY ="select * from garant";
        List<Garant> garants=new ArrayList<>();
        try(PreparedStatement ps=getConnection().prepareStatement(QUERY)){
            try(ResultSet rs=ps.executeQuery()){
                while (rs.next()){
                    Garant garant=new Garant();
                    garant.setDesignationGarant(rs.getString("designation"));
                    garant.setValeurGarant(String.valueOf(rs.getInt("valeur")));
                    garants.add(garant);

                }


            }
        }catch(Exception e){e.printStackTrace();}
        return garants;
    }
}
