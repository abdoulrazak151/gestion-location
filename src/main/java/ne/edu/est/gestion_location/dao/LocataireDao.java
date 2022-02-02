package ne.edu.est.gestion_location.dao;

import ne.edu.est.gestion_location.entities.Bailleur;
import ne.edu.est.gestion_location.entities.Garant;
import ne.edu.est.gestion_location.entities.Locataire;
import ne.edu.est.gestion_location.entities.Location;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LocataireDao extends UniqueConnection{
    public  boolean createLocataire(Locataire locataire){
        String QUERY="insert into locataire(nom, prenom1,prenom2, telephone, email, addresse) values (?,?,?,?,?,?)";
        try(PreparedStatement ps=getConnection().prepareStatement(QUERY)){
            ps.setString(1,locataire.getNomLocataire());
            ps.setString(2,locataire.getPrenom1Locataire());
            ps.setString(3, locataire.getPrenom2Locataire());
            ps.setString(4,locataire.getTelephoneLocataire());
            ps.setString(5, locataire.getEmailLocataire());
            ps.setString(6, locataire.getAddresseLocataire());
            int a=ps.executeUpdate();
            GarantDao d= new GarantDao();
            for(Garant g : locataire.getGarants()){
                d.createGarant(g, locataire);
            }
            return a>0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean updateLocataire(Locataire locataire){
        String QUERY="update locataire set nom=?, prenom1=?,prenom2=?, telephone=?, email=?, addresse=? where id_locataire=?";
        try(PreparedStatement ps=getConnection().prepareStatement(QUERY)){
            ps.setString(1, locataire.getNomLocataire());
            ps.setString(2, locataire.getPrenom1Locataire());
            ps.setString(3, locataire.getPrenom2Locataire());
            ps.setString(4, locataire.getTelephoneLocataire());
            ps.setString(5, locataire.getEmailLocataire());
            ps.setString(6, locataire.getAddresseLocataire());
            ps.setInt(7, locataire.getIdLocataire());
            return ps.executeUpdate()>0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean deleteLocataire(Locataire locataire){
        String QUERY="delete from locataire where id_locataire=?";
        try(PreparedStatement ps=getConnection().prepareStatement(QUERY)){
            ps.setInt(1, locataire.getIdLocataire());
            return ps.executeUpdate()>0;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }
    public Locataire getLocataireById(int i){
        String QUERY ="select * from locataire where id_locataire=?";
        Locataire locataire=null;
        try(PreparedStatement ps=getConnection().prepareStatement(QUERY)){
            ps.setInt(1, i);
            try(ResultSet rs=ps.executeQuery()){
                while (rs.next()){
                    locataire=new Locataire();
                    locataire.setNomLocataire(rs.getString("nom"));
                    locataire.setPrenom1Locataire(rs.getString("prenom1"));
                    locataire.setPrenom2Locataire(rs.getString("prenom2"));
                    locataire.setTelephoneLocataire(rs.getString("telephone"));
                    locataire.setEmailLocataire(rs.getString("email"));
                    locataire.setAddresseLocataire(rs.getString("addresse"));
                    return locataire;
                }


            }
        }catch(Exception e){e.printStackTrace();}
        return locataire;
    }

    public Locataire getLocataire(Locataire loc){
        String QUERY ="select * from locataire where nom=? and prenom1=?";
        Locataire locataire=null;
        try(PreparedStatement ps=getConnection().prepareStatement(QUERY)){
            ps.setString(1, loc.getNomLocataire());
            ps.setString(2,loc.getPrenom1Locataire());
            try(ResultSet rs=ps.executeQuery()){
                while (rs.next()){
                    locataire=new Locataire();
                    locataire.setIdLocataire(rs.getInt("id_locataire"));
                    locataire.setNomLocataire(rs.getString("nom"));
                    locataire.setPrenom1Locataire(rs.getString("prenom1"));
                    locataire.setPrenom2Locataire(rs.getString("prenom2"));
                    locataire.setTelephoneLocataire(rs.getString("telephone"));
                    locataire.setEmailLocataire(rs.getString("email"));
                    locataire.setAddresseLocataire(rs.getString("addresse"));
                    return locataire;
                }


            }
        }catch(Exception e){e.printStackTrace();}
        return locataire;
    }

    public List<Locataire> getAllLocataire(){
        String QUERY ="select * from locataire";
        List<Locataire> locatiares=new ArrayList<>();
        try(PreparedStatement ps=getConnection().prepareStatement(QUERY)){
            try(ResultSet rs=ps.executeQuery()){
                while (rs.next()){
                    Locataire locataire=new Locataire();
                    locataire.setIdLocataire(rs.getInt("id_locataire"));
                    locataire.setNomLocataire(rs.getString("nom"));
                    locataire.setPrenom2Locataire(rs.getString("prenom1"));
                    locataire.setPrenom2Locataire(rs.getString("prenom2"));
                    locataire.setTelephoneLocataire(rs.getString("telephone"));
                    locataire.setEmailLocataire(rs.getString("email"));
                    locataire.setAddresseLocataire(rs.getString("addresse"));
                    GarantDao garantDao=new GarantDao();
                    locataire.setGarantsList(garantDao.getGarantByLocataire(locataire));
                   locatiares.add(locataire);
                }

            }
        }catch(Exception e){e.printStackTrace();}
        return locatiares;
    }
}
