package ne.edu.est.gestion_location.dao;

import ne.edu.est.gestion_location.entities.Bailleur;
import ne.edu.est.gestion_location.entities.Bien;
import ne.edu.est.gestion_location.entities.Equipement;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BienDao extends UniqueConnection{
    public  boolean createBien(Bien bien){
        String QUERY="insert into bien(addresse, surface) values (?,?)";
        try(PreparedStatement ps=getConnection().prepareStatement(QUERY)){
            ps.setString(1, bien.getAddresseBien());
            ps.setInt(2, bien.getSurfaceBien());
            int a =ps.executeUpdate();
            EquipementDao dao=new EquipementDao();
            for(Equipement e: bien.getEquipements()){
                dao.createEquipement(e, bien);
            }
            return a>0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean updateBien(Bien bien){
        String QUERY="update bien set addresse=?, surface=? where id_bien=?";
        try(PreparedStatement ps=getConnection().prepareStatement(QUERY)){
            ps.setString(1, bien.getAddresseBien());
            ps.setInt(2, bien.getSurfaceBien());
            ps.setInt(3, bien.getIdBien());

            return ps.executeUpdate()>0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean deleteBien(Bien bien){
        String QUERY="delete from bien where id_bien=?";
        try(PreparedStatement ps=getConnection().prepareStatement(QUERY)){
            ps.setInt(1, bien.getIdBien());
            return ps.executeUpdate()>0;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    public Bien getBienById(int i){
        String QUERY ="select * from bien where id_bien=?";
        Bien bien =null;
        try(PreparedStatement ps=getConnection().prepareStatement(QUERY)){
            ps.setInt(1, i);
            try(ResultSet rs=ps.executeQuery()){
                while (rs.next()){
                    bien=new Bien();
                    bien.setIdBien(rs.getInt("id_bien"));
                    bien.setAddresseBien(rs.getString("addresse"));
                    bien.setSurfaceBien(rs.getInt("surface"));
                    EquipementDao equiDao=new EquipementDao();
                    bien.setListEquipement(equiDao.getAllEquipementById(bien));
                    return bien;
                }


            }
        }catch(Exception e){e.printStackTrace();}
        return bien;
    }

    public Bien getBien(Bien i){
        String QUERY ="select * from bien where surface=? and addresse=?";
        Bien bien =null;
        try(PreparedStatement ps=getConnection().prepareStatement(QUERY)){
            ps.setInt(1, i.getSurfaceBien());
            ps.setString(2, i.getAddresseBien());
            try(ResultSet rs=ps.executeQuery()){
                while (rs.next()){
                    bien=new Bien();
                    bien.setIdBien(rs.getInt("id_bien"));
                    bien.setAddresseBien(rs.getString("addresse"));
                    bien.setSurfaceBien(rs.getInt("surface"));
                    return bien;
                }


            }
        }catch(Exception e){e.printStackTrace();}
        return bien;
    }

    public List<Bien> getAllBien(){
        String QUERY ="select * from bien";
        List<Bien> biens=new ArrayList<Bien>();
        try(PreparedStatement ps=getConnection().prepareStatement(QUERY)){
            try(ResultSet rs=ps.executeQuery()){
                while (rs.next()){
                    Bien bien=new Bien();
                    bien.setIdBien(rs.getInt("id_bien"));
                    bien.setAddresseBien(rs.getString("addresse"));
                    bien.setSurfaceBien(rs.getInt("surface"));
                    EquipementDao equiDao=new EquipementDao();
                    bien.setListEquipement(equiDao.getAllEquipementById(bien));
                    biens.add(bien);
                }


            }
        }catch(Exception e){e.printStackTrace();}
        return biens;
    }
}
