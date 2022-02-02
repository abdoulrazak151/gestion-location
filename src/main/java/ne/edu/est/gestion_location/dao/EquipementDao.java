package ne.edu.est.gestion_location.dao;

import ne.edu.est.gestion_location.entities.Bien;
import ne.edu.est.gestion_location.entities.Equipement;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EquipementDao  extends  UniqueConnection{
    public  boolean createEquipement(Equipement equipement, Bien bien){
        BienDao b= new BienDao();
        bien=b.getBien(bien);
        String QUERY="insert into equipement(designation, id_bien) values (?,?)";
        try(PreparedStatement ps=getConnection().prepareStatement(QUERY)){
            ps.setString(1, equipement.getDesignation());
            ps.setInt(2, bien.getIdBien());
            return ps.executeUpdate()>0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean updateEquipement(Equipement equipement){
        String QUERY="update bien set designation=? where id_equipement=?";
        try(PreparedStatement ps=getConnection().prepareStatement(QUERY)){
            ps.setString(1, equipement.getDesignation());
            ps.setInt(2,equipement.getIdEquipement());
            return ps.executeUpdate()>0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean deleteEquipement(Equipement equipement){
        String QUERY="delete from equipement where id_equipement=?";
        try(PreparedStatement ps=getConnection().prepareStatement(QUERY)){
            ps.setInt(1,equipement.getIdEquipement());
            return ps.executeUpdate()>0;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }
    public List<Equipement> getAllEquipementById(Bien bien){
        String QUERY ="select * from equipement where id_bien=?";
        List<Equipement> equipements= new ArrayList<>();
        try(PreparedStatement ps=getConnection().prepareStatement(QUERY)){
            ps.setInt(1, bien.getIdBien());
            try(ResultSet rs=ps.executeQuery()){
                while (rs.next()){
                     Equipement equipement=new Equipement();
                    equipement.setDesignation(rs.getString("designation"));
                    equipement.setIdEquipement(rs.getInt("id_equipement"));

                    equipements.add(equipement);
                }


            }
        }catch(Exception e){e.printStackTrace();}
        return equipements;
    }

    public List<Equipement> getAllEquipement(){
        String QUERY ="select * from equipement";
        List<Equipement> equipements=new ArrayList<>();
        try(PreparedStatement ps=getConnection().prepareStatement(QUERY)){
            try(ResultSet rs=ps.executeQuery()){
                while (rs.next()){
                    Equipement equipement=new Equipement();
                    equipement.setIdEquipement(rs.getInt("id_equipement"));
                    equipement.setDesignation(rs.getString("designation"));
                    equipements.add(equipement);
                }


            }
        }catch(Exception e){e.printStackTrace();}
        return equipements;
    }
}
