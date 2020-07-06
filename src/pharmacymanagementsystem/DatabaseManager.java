/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pharmacymanagementsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DatabaseManager {

    String query = null;
    Connection conn = null;
    Statement statement = null;
    ResultSet rs = null;

    private Connection getConnection() throws SQLException {
        Connection con = null;
        con = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\Jawad Hussain\\Documents\\NetBeansProjects\\PharmacyManagementSystem\\Pharmacy.accdb");
        return con;
    }

    public void insertMedicine(Medicine medicine) {
        try {
            conn = getConnection();
            statement = conn.createStatement();
            query = "INSERT INTO Medicines (MedicineName, Price, Company, Quantity, MedicineType, Description) VALUES ('" + medicine.getName() + "','" + medicine.getPrice() + "','" + medicine.getCompany() + "','" + medicine.getQuantity() + "','" + medicine.getType() + "','" + medicine.getDescription() + "')";
            statement.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                statement.close();
                conn.close();
            } catch (SQLException ex) {/*IGNORE EXCEPTION*/
            }
        }
    }
    
    public void insertUser(User user) {
        try {
            conn = getConnection();
            statement = conn.createStatement();
            query = "INSERT INTO Users (Username, Password, UserType) VALUES ('" + user.getName() + "','" + user.getPassword() + "','" + user.getType() + "')";
            statement.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                statement.close();
                conn.close();
            } catch (SQLException ex) {/*IGNORE EXCEPTION*/
            }
        }
    }
    
    public void updateUser(User user) {
        try {
            conn = getConnection();
            statement = conn.createStatement();
            query="UPDATE Users set Password='" + user.getPassword() + "' where Username = '" + user.getName() + "'";
            statement.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                statement.close();
                conn.close();
            } catch (SQLException ex) {/*IGNORE EXCEPTION*/
            }
        }
    }
    
    public void updateMedicinePrice(String name, int price)
    {
        try {
            conn = getConnection();
            statement = conn.createStatement();
            query="UPDATE Medicines set Price='" + price + "' where MedicineName = '" + name + "'";
            statement.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                statement.close();
                conn.close();
            } catch (SQLException ex) {/*IGNORE EXCEPTION*/
            }
        }
    }
    
    public void updateMedicineQuantity(String name, int quantity)
    {
        try {
            conn = getConnection();
            statement = conn.createStatement();
            query="UPDATE Medicines set Quantity='" + quantity + "' where MedicineName = '" + name + "'";
            statement.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                statement.close();
                conn.close();
            } catch (SQLException ex) {/*IGNORE EXCEPTION*/
            }
        }
    }
    
    public ArrayList getAllMedicines() {
        ArrayList<Medicine> list = new ArrayList<>();
        try {
            conn = getConnection();
            statement = conn.createStatement();
            query = "SELECT * FROM Medicines";
            rs = statement.executeQuery(query);
            while (rs.next()) 
            {
                list.add(new Medicine(rs.getInt("ID"), rs.getString("MedicineName"), rs.getInt("Price"), rs.getString("Company"), rs.getInt("Quantity"), rs.getString("MedicineType"), rs.getString("Description")));
            }

        } catch (SQLException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                statement.close();
                conn.close();
            } catch (SQLException ex) {/*IGNORE EXCEPTION*/
            };
        }
        return list;
    }
    
    public ArrayList<User> getAllUsers()
    {
        ArrayList<User> list = new ArrayList<>();
        try {
            conn = getConnection();
            statement = conn.createStatement();
            query = "SELECT * FROM Users";
            rs = statement.executeQuery(query);
            while (rs.next()) 
            {
                list.add(new User(rs.getString("Username"), rs.getString("Password"), rs.getString("UserType")));
            }

        } catch (SQLException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                statement.close();
                conn.close();
            } catch (SQLException ex) {/*IGNORE EXCEPTION*/
            }
        }
        return list;
    }

    public void deleteMedicine(int id) throws SQLException {
        conn = getConnection();
        statement = conn.createStatement();
        query = "DELETE FROM medicine WHERE ID=" + id;
        int c = statement.executeUpdate(query);
        System.out.println(c);
        statement.close();
        conn.close();
    }

}
