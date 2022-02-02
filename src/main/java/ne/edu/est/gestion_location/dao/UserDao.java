package ne.edu.est.gestion_location.dao;

import ne.edu.est.gestion_location.entities.Bailleur;
import ne.edu.est.gestion_location.entities.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao extends UniqueConnection{
    public  boolean createUser(User user){
        String QUERY="insert into user(login, password) values (?,?)";
        try(PreparedStatement ps=getConnection().prepareStatement(QUERY)){
            ps.setString(1,user.getLogin());
            ps.setString(2, user.getPassword());
            return ps.executeUpdate()>0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean updateUser(User user){
        String QUERY="update bailleur set login=?, password=? where id_user=?";
        try(PreparedStatement ps=getConnection().prepareStatement(QUERY)){
            ps.setString(1,user.getLogin());
            ps.setString(2, user.getPassword());
            ps.setInt(3, user.getIdUser());
            return ps.executeUpdate()>0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean deleteUser(User user){
        String QUERY="delete from user where id_user=?";
        try(PreparedStatement ps=getConnection().prepareStatement(QUERY)){
            ps.setInt(1, user.getIdUser());
            return ps.executeUpdate()>0;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }
    public User getUserById(int i){
        String QUERY ="select * from user where id_user=?";
        User  user=null;
        try(PreparedStatement ps=getConnection().prepareStatement(QUERY)){
            ps.setInt(1, i);
            try(ResultSet rs=ps.executeQuery()){
                while (rs.next()){
                    user=new User();
                    user.setIdUser(rs.getInt("id_user"));
                    user.setLogin(rs.getString("login"));
                    user.setPassword(rs.getString("password"));
                }


            }
        }catch(Exception e){e.printStackTrace();}
        return user;
    }

    public User getUser(User user1){
        String QUERY ="select * from user where password=? and login=?";
        User  user=null;
        try(PreparedStatement ps=getConnection().prepareStatement(QUERY)){
            ps.setString(1, user1.getPassword());
            ps.setString(2, user1.getLogin());
            try(ResultSet rs=ps.executeQuery()){
                while (rs.next()){
                    user=new User();
                    user.setIdUser(rs.getInt("id_user"));
                    user.setLogin(rs.getString("login"));
                    user.setPassword(rs.getString("password"));
                }


            }
        }catch(Exception e){e.printStackTrace();}
        return user;
    }

    public List<User> getAllUser(){
        String QUERY ="select * from user";
        List<User> users=new ArrayList<>();
        try(PreparedStatement ps=getConnection().prepareStatement(QUERY)){
            try(ResultSet rs=ps.executeQuery()){
                while (rs.next()){
                    User user=new User();
                    user.setIdUser(rs.getInt("id_user"));
                    user.setLogin(rs.getString("login"));
                    user.setPassword(rs.getString("password"));
                    users.add(user);                }


            }
        }catch(Exception e){e.printStackTrace();}
        return users;
    }
    public static void main(String argv[]){
        User user=new User();
        user.setLogin("abdoulrazak");
        user.setPassword("abdoulrazak");
        UserDao userDao=new UserDao();
        boolean a = userDao.createUser(user);
        System.out.println(a);
    }
}
