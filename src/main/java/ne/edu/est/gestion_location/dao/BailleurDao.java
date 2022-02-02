package ne.edu.est.gestion_location.dao;

import ne.edu.est.gestion_location.entities.Bailleur;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BailleurDao extends UniqueConnection{
    public  boolean createBailleur(Bailleur bailleur){
        String QUERY="insert into bailleur(nom_bailleur, prenom1,prenom2, telephone_bailleur, email_bailleur) values (?,?,?,?,?)";
                try(PreparedStatement ps=getConnection().prepareStatement(QUERY)){
                    ps.setString(1,bailleur.getNomBailleur());
                    ps.setString(2, bailleur.getPrenom1Bailleur());
                    ps.setString(3, bailleur.getPrenom2Bailleur());
                    ps.setString(4, bailleur.getTelephoneBailleur());
                    ps.setString(5, bailleur.getEmailBailleur());
                    return ps.executeUpdate()>0;

                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return false;
    }
    public boolean updateBailleur(Bailleur bailleur){
         String QUERY="update bailleur set nom_bailleur=?, prenom1=?,prenom2=?, telephone_bailleur=?, email_bailleur=? where id_bailleur=?";
        try(PreparedStatement ps=getConnection().prepareStatement(QUERY)){
            ps.setString(1,bailleur.getNomBailleur());
            ps.setString(2, bailleur.getPrenom1Bailleur());
            ps.setString(3, bailleur.getPrenom2Bailleur());
            ps.setString(4, bailleur.getTelephoneBailleur());
            ps.setString(5, bailleur.getEmailBailleur());
            ps.setInt(6, bailleur.getIdBailleur());
            return ps.executeUpdate()>0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean deleteBailleur(Bailleur bailleur){
        String QUERY="delete from bailleur where id_bailleur=?";
        try(PreparedStatement ps=getConnection().prepareStatement(QUERY)){
            ps.setInt(1, bailleur.getIdBailleur());
            return ps.executeUpdate()>0;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }
    public Bailleur getBailleurById(int i){
        String QUERY ="select * from bailleur where id_bailleur=?";
        Bailleur bailleur=null;
        try(PreparedStatement ps=getConnection().prepareStatement(QUERY)){
            ps.setInt(1, i);
            try(ResultSet rs=ps.executeQuery()){
                while (rs.next()){
                    bailleur=new Bailleur();
                    bailleur.setIdBailleur(rs.getInt("id_bailleur"));
                    bailleur.setNomBailleur(rs.getString("nom_bailleur"));
                    bailleur.setPrenom1Bailleur(rs.getString("prenom1"));
                    bailleur.setPrenom2Bailleur(rs.getString("prenom2"));
                    bailleur.setTelephoneBailleur(rs.getString("telephone_bailleur"));
                    bailleur.setEmailBailleur(rs.getString("email_bailleur"));
                    return bailleur;
                }

            }
        }catch(Exception e){e.printStackTrace();}
        return bailleur;
    }

    public List<Bailleur> getAllBailleur(){
        String QUERY ="select * from bailleur";
        List<Bailleur> bailleurs=new ArrayList<>();
        try(PreparedStatement ps=getConnection().prepareStatement(QUERY)){
            try(ResultSet rs=ps.executeQuery()){
                while (rs.next()){
                    Bailleur bailleur=new Bailleur();
                    bailleur.setIdBailleur(rs.getInt("id_bailleur"));
                    bailleur.setNomBailleur(rs.getString("nom_bailleur"));
                    bailleur.setPrenom1Bailleur(rs.getString("prenom1"));
                    bailleur.setPrenom2Bailleur(rs.getString("prenom2"));
                    bailleur.setTelephoneBailleur(rs.getString("telephone_bailleur"));
                    bailleur.setEmailBailleur(rs.getString("email_bailleur"));
                    bailleurs.add(bailleur);
                }


            }
        }catch(Exception e){e.printStackTrace();}
        return bailleurs;
    }
}
