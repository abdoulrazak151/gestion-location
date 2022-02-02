package ne.edu.est.gestion_location.dao;

import ne.edu.est.gestion_location.entities.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ChargeDao extends UniqueConnection{
    public  boolean createCharge(Charge charge, Location location){
        LocationDao locationDao = new LocationDao();
        location=locationDao.getLocation(location);
        String QUERY="insert into charge(designation, id_location) values (?,?)";
        try(PreparedStatement ps=getConnection().prepareStatement(QUERY)){
            ps.setString(1, charge.getDesignation());
            ps.setInt(2, location.getIdLocation());
            return ps.executeUpdate()>0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean updateCharge(Charge charge){
        String QUERY="update charge set designation=? where id_Charge=?";
        try(PreparedStatement ps=getConnection().prepareStatement(QUERY)){
            ps.setString(1, charge.getDesignation());
            ps.setInt(2,charge.getIdCharge());
            return ps.executeUpdate()>0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean deleteCharge(Charge charge){
        String QUERY="delete from charge where id_charge=?";
        try(PreparedStatement ps=getConnection().prepareStatement(QUERY)){
            ps.setInt(1,charge.getIdCharge());
            return ps.executeUpdate()>0;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }
    public List<Charge> getAllChargeByLocation(Location location){
        String QUERY ="select * from charge where id_location=?";
        LocationDao loc=new LocationDao();
        location=loc.getLocation(location);
        List<Charge> charges= new ArrayList<>();
        try(PreparedStatement ps=getConnection().prepareStatement(QUERY)){
            ps.setInt(1, location.getIdLocation());
            try(ResultSet rs=ps.executeQuery()){
                while (rs.next()){
                    Charge charge = new Charge();
                    charge.setDesignation(rs.getString("designation"));
                    charge.setIdCharge(rs.getInt("id_charge"));

                    charges.add(charge);
                }


            }
        }catch(Exception e){e.printStackTrace();}
        return charges;
    }


    public List<Charge> getAllCharge(){
        String QUERY ="select * from charge()";
        List<Charge> charges=new ArrayList<>();
        try(PreparedStatement ps=getConnection().prepareStatement(QUERY)){
            try(ResultSet rs=ps.executeQuery()){
                while (rs.next()){

                    Charge charge = new Charge();
                    charge.setDesignation(rs.getString("designation"));
                    charge.setIdCharge(rs.getInt("id_charge"));

                    charges.add(charge);
                }


            }
        }catch(Exception e){e.printStackTrace();}
        return charges;
    }
}
