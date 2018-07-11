
package com.movies.business;

import com.movies.dbconnection.DBConnection;
import com.movies.pojos.Movie;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class ProcessOperations {

    public  boolean postMovie(Movie movie) {
        System.out.println("in process ");
        /* DATABASE CONNECTION START */
        Connection con = DBConnection.getConnection();
        try{
            System.out.println("connected to database");
            PreparedStatement ps = con
                    .prepareStatement("insert into Movies(name,director,genre,budget) values(?,?,?,?)");
            ps.setString(1, movie.getMovieName());
            ps.setString(2, movie.getDirectorName());
            ps.setString(3, movie.getGenre());
            ps.setString(4, movie.getBudget());
            boolean isInserted = ps.execute();
            DBConnection.closeConnection(con);
            if (true) {
                return true;
            } else {
                return false;
            }
        } catch (Exception ex) {
            DBConnection.closeConnection(con);
            ex.printStackTrace();
        }
        /* DATABASE CONNECTION END */
        return false;
    }
    
    
    public  List getMovies(){
        List<Movie> movies = new ArrayList<Movie>();
        System.out.println("in process ");
        /* DATABASE CONNECTION START */
        Connection con = DBConnection.getConnection();
        try{
            System.out.println("connected to database");
            Statement createStatement = con.createStatement();
            ResultSet executeQuery = createStatement.executeQuery("select * from Movies");
            while(executeQuery.next()){
                Movie movie = new Movie();
                movie.setId(executeQuery.getInt(1));
                movie.setMovieName(executeQuery.getString(2));
                movie.setDirectorName(executeQuery.getString(3));
                movie.setGenre(executeQuery.getString(4));
                movie.setBudget(executeQuery.getString(5));
                System.out.println("movies " + movie.toString());
                movies.add(movie);
            }
            DBConnection.closeConnection(con);
            return movies;
        } catch (Exception ex) {
            DBConnection.closeConnection(con);
            ex.printStackTrace();
        }
        /* DATABASE CONNECTION END */
        return null;
    }
    
    public  boolean deleteMovie(String id){
        System.out.println("in process ");
        /* DATABASE CONNECTION START */
        Connection con = DBConnection.getConnection();
         try{
            System.out.println("connected to database");
            PreparedStatement prepareStatement = con.prepareStatement("delete from Movies where id=?");
            prepareStatement.setInt(1, Integer.parseInt(id));
            int isDeleted = prepareStatement.executeUpdate();
            DBConnection.closeConnection(con);
            if(isDeleted == 1){
                return true;
            }else{
                return false;
            }
        } catch (Exception ex) {
            DBConnection.closeConnection(con);
            ex.printStackTrace();
        }
        /* DATABASE CONNECTION END */
        return false;
    }
    
    public  boolean putMovie(Movie movie) {
        System.out.println("in process ");
        /* DATABASE CONNECTION START */
        Connection con = DBConnection.getConnection();
        try{
            System.out.println("connected to database");
            PreparedStatement prepareStatement = con.prepareStatement("update Movies set name=?,director=?,genre=?,budget=? where id = ?");
            prepareStatement.setString(1,movie.getMovieName());
            prepareStatement.setString(2,movie.getDirectorName());
            prepareStatement.setString(3,movie.getGenre());
            prepareStatement.setString(4,movie.getBudget());
            prepareStatement.setString(5,String.valueOf(movie.getId()));
            int isUpdated = prepareStatement.executeUpdate();
            DBConnection.closeConnection(con);
            if(isUpdated == 1){
                return true;
            }else{
                return false;
            }
        }catch(Exception ex){
            DBConnection.closeConnection(con);
            ex.printStackTrace();
        }
        /* DATABASE CONNECTION END */
        return false;
    }
}
