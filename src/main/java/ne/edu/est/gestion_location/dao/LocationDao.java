package ne.edu.est.gestion_location.dao;

import ne.edu.est.gestion_location.entities.*;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LocationDao extends UniqueConnection{
    public  boolean createLocation(Location location){
        String QUERY="insert into location(duree, montant, id_bien, id_locataire, id_user, created_at) values (?,?,?,?,?,?)";
        try(PreparedStatement ps=getConnection().prepareStatement(QUERY)){
            ps.setString(1, location.getDuree());
            ps.setInt(2, location.getMontant());
            ps.setInt(3, location.getBien().getIdBien());
            ps.setInt(4, location.getLocataire().getIdLocataire());
//            ps.setInt(5,location.getUser().getIdUser());
            ps.setInt(5,1);
            ps.setString(6, String.valueOf(location.getDate()));
            int a=ps.executeUpdate();
            ChargeDao ch=new ChargeDao();
            for(Charge c: location.getCharges()){
                ch.createCharge(c,location);
            }
            return a>0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean updateLocation(Location location){
        String QUERY="update location set duree=?, montant=?, id_bien=?, id_locataire=?, id_user=?, created_at=? where id_location=?";
        try(PreparedStatement ps=getConnection().prepareStatement(QUERY)){
            ps.setString(1, location.getDuree());
            ps.setInt(2, location.getMontant());
            ps.setInt(3,location.getBien().getIdBien());
            ps.setInt(4,location.getLocataire().getIdLocataire());
            ps.setInt(5,location.getUser().getIdUser());
            ps.setString(6, location.getDate());
            ps.setInt(7, location.getIdLocation());
            return ps.executeUpdate()>0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean deleteLocation(Location location){
        String QUERY="delete from location where id_location=?";
        try(PreparedStatement ps=getConnection().prepareStatement(QUERY)){
            ps.setInt(1,location.getIdLocation());
            return ps.executeUpdate()>0;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }
    public List<Location> getAllLocationsByBien(Bien bien){
        String QUERY ="select * from location where id_bien=?";
        List<Location> locations= new ArrayList<>();
        try(PreparedStatement ps=getConnection().prepareStatement(QUERY)){
            ps.setInt(1, bien.getIdBien());
            try(ResultSet rs=ps.executeQuery()){
                while (rs.next()){
                    Location location=new Location();
                    location.setDuree(rs.getString("duree"));
                    location.setMontant(rs.getInt("montant"));
                    location.getBien().setIdBien(rs.getInt("id_bien"));
                    location.getLocataire().setIdLocataire(rs.getInt("id_locataire"));
                    location.getUser().setIdUser(rs.getInt("id_user"));
                    locations.add(location);
                    }


            }
        }catch(Exception e){e.printStackTrace();}
        return locations;
    }

    public Location getAllLocationsById(int id){
        String QUERY ="select * from location where id_bien=?";
        Location location= null;
        try(PreparedStatement ps=getConnection().prepareStatement(QUERY)){
            ps.setInt(1, id);
            try(ResultSet rs=ps.executeQuery()){
                while (rs.next()){
                    location=new Location();
                    location.setDuree(rs.getString("duree"));
                    location.setMontant(rs.getInt("montant"));
                    location.getBien().setIdBien(rs.getInt("id_bien"));
                    location.getLocataire().setIdLocataire(rs.getInt("id_locataire"));
                    location.getUser().setIdUser(rs.getInt("id_user"));

                }


            }
        }catch(Exception e){e.printStackTrace();}
        return location;
    }
    public Location getLocation(Location l){
        String QUERY ="select * from location where id_bien=? and id_locataire=? and montant=?";
        Location location= null;
        try(PreparedStatement ps=getConnection().prepareStatement(QUERY)){
            ps.setInt(1, l.getBien().getIdBien());
            ps.setInt(2, l.getLocataire().getIdLocataire());
            ps.setInt(3, l.getMontant());
            try(ResultSet rs=ps.executeQuery()){
                while (rs.next()){
                    location=new Location();
                    location.setIdLocation(rs.getInt("id_location"));
                    location.setDuree(rs.getString("duree"));
                    location.setMontant(rs.getInt("montant"));
                    location.getBien().setIdBien(rs.getInt("id_bien"));
                    location.getLocataire().setIdLocataire(rs.getInt("id_locataire"));
                    location.getUser().setIdUser(rs.getInt("id_user"));

                }


            }
        }catch(Exception e){e.printStackTrace();}
        return location;
    }
    public Location getLocationId(Location l){
        String QUERY ="select * from location where id_location=?";
        Location location= null;
        try(PreparedStatement ps=getConnection().prepareStatement(QUERY)){
            ps.setInt(1, l.getIdLocation());

            try(ResultSet rs=ps.executeQuery()){
                while (rs.next()){
                    location=new Location();
                    location.setIdLocation(rs.getInt("id_location"));
                    location.setDuree(rs.getString("duree"));
                    location.setMontant(rs.getInt("montant"));
//                    location.getBien().setIdBien(rs.getInt("id_bien"));
                    BienDao bienDao=new BienDao();
                    Bien bien=new Bien();

                    bien=  bienDao.getBienById(rs.getInt("id_bien"));
                    location.setBien(bien);
//                    location.getBien().setIdBien(rs.getInt("id_bien"));
                    LocataireDao locataireDao=new LocataireDao();
                    Locataire loc=new Locataire();
                    loc=locataireDao.getLocataireById(rs.getInt("id_locataire"));
                    location.setLocataire(loc);
//                    location.getLocataire().setIdLocataire(rs.getInt("id_locataire"));
                    location.getUser().setIdUser(rs.getInt("id_user"));

                }


            }
        }catch(Exception e){e.printStackTrace();}
        return location;
    }

    public Location getAllLocations(){
        String QUERY ="select * from location where max(id_location)";
        Location location= null;
        try(PreparedStatement ps=getConnection().prepareStatement(QUERY)){

            try(ResultSet rs=ps.executeQuery()){
                while (rs.next()){
                    location=new Location();
                    location.setIdLocation(rs.getInt("id_location"));
                    location.setDuree(rs.getString("duree"));
                    location.setMontant(rs.getInt("montant"));
                    location.getBien().setIdBien(rs.getInt("id_bien"));
                    location.getLocataire().setIdLocataire(rs.getInt("id_locataire"));
                    location.getUser().setIdUser(rs.getInt("id_user"));

                }


            }
        }catch(Exception e){e.printStackTrace();}
        return location;
    }
    public List<Location> getAllLocation(){
        String QUERY ="select * from location";
        List<Location> locations =new ArrayList<>();
        try(PreparedStatement ps=getConnection().prepareStatement(QUERY)){
            try(ResultSet rs=ps.executeQuery()){
                while (rs.next()){
                    Location location=new Location();
                    location.setIdLocation(rs.getInt("id_location"));
                    location.setDuree(rs.getString("duree"));
                    location.setMontant(rs.getInt("montant"));
                    BienDao bienDao=new BienDao();
                    Bien bien=new Bien();

                    bien=  bienDao.getBienById(rs.getInt("id_bien"));
                    location.setBien(bien);
//                    location.getBien().setIdBien(rs.getInt("id_bien"));
                    LocataireDao locataireDao=new LocataireDao();
                    Locataire loc=new Locataire();
                    loc=locataireDao.getLocataireById(rs.getInt("id_locataire"));
                    location.setLocataire(loc);
//                    location.getLocataire().setIdLocataire(rs.getInt("id_locataire"));
                    location.getUser().setIdUser(rs.getInt("id_user"));
                    location.setDate(rs.getString("created_at"));
                    ChargeDao charge = new ChargeDao();
                    location.setAllCharge(charge.getAllChargeByLocation(location));
                    locations.add(location);
                }


            }
        }catch(Exception e){e.printStackTrace();}
        return locations;
    }
    public  static void main(String[] args){
        List<Location> lo=new ArrayList<>();
        LocationDao d=new LocationDao();
        lo=d.getAllLocation();
        for(Location l:lo){
            System.out.println(l.getUser().getIdUser()+" bien "+l.getBien().getIdBien()+' '+l.getMontant());
        }

    }
}
