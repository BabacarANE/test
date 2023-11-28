package Repository;
import model.DB;
import model.animaux;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.List;
import java.util.Scanner;
public class AnimauxRepository {
    private Connection connection;
    public AnimauxRepository() {
        DB db= new DB();
        this.connection=db.getConnection();
    }
    public List<animaux> getAllAnimaux(){
        //Select all
        List<animaux> listanimaux= new ArrayList<>();
        try {
            String sql = "SELECT * FROM animaux";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet result = statement.executeQuery();

            while(result.next()){
                animaux e = new animaux();

                e.setId(result.getInt("id"));
                e.setNom(result.getString("nom"));
                e.setAge(result.getInt("age"));
                e.setMatricule(result.getString("matricule"));
                e.setSexe(result.getString("sexe"));
                listanimaux.add(e);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  listanimaux;
    }
    public void addAnimal(animaux an){
        try {
            String sql = "INSERT INTO animaux (nom, age, sexe, matricule) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, an.getNom());
            statement.setInt(2, an.getAge());
            statement.setString(3, an.getSexe());
            statement.setString(4, an.getMatricule());
            statement.executeUpdate();
            System.out.println("Record created.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteAnimal(int id){
        try {
            String sql = "DELETE FROM animaux WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();
            System.out.println("Record deleted.");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public List<animaux> getAnimauxByAge(int age1, int age2){
        //Select all
        List<animaux> listanimaux= new ArrayList<>();
        try {
            String sql = "SELECT FROM animaux WHERE id>=? and id<=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, age1);
            statement.setInt(2, age2);
            ResultSet result = statement.executeQuery();

            while(result.next()){
                animaux e = new animaux();

                e.setId(result.getInt("id"));
                e.setNom(result.getString("nom"));
                e.setAge(result.getInt("age"));
                e.setMatricule(result.getString("matricule"));
                e.setSexe(result.getString("sexe"));
                listanimaux.add(e);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  listanimaux;
    }
    public List<animaux> getAnimaux(String nom){
        //Select all
        List<animaux> listanimaux= new ArrayList<>();
        try {
            String sql = "SELECT FROM animaux WHERE nom=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, nom);
            ResultSet result = statement.executeQuery();

            while(result.next()){
                animaux e = new animaux();

                e.setId(result.getInt("id"));
                e.setNom(result.getString("nom"));
                e.setAge(result.getInt("age"));
                e.setMatricule(result.getString("matricule"));
                e.setSexe(result.getString("sexe"));
                listanimaux.add(e);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  listanimaux;
    }
}
