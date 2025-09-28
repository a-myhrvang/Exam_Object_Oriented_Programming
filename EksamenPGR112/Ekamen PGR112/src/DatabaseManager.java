import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseManager {

    private static final String URL = "jdbc:mysql://localhost:3306/Funn";
    private static final String USER = "root";
    private static final String PASSWORD = "yourpasswd";

    private Connection connect() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public boolean personExists(int personId) {
        String sql = "SELECT * FROM person WHERE Id = ?";
        try (PreparedStatement statement = connect().prepareStatement(sql)) {
            statement.setInt(1, personId);
            ResultSet resultSet = statement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            System.out.println("Error checking if person exists: " + e.getMessage());
            return false;
        }
    }

    public void insertPerson(Person person) {
        String sql = "INSERT INTO Person (Id, Navn, Tlf, E_post) VALUES (?, ?, ?, ?)";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, person.getId());
            pstmt.setString(2, person.getNavn());
            pstmt.setString(3, person.getTlf());
            pstmt.setString(4, person.getEpost());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertMuseum(Museum museum) {
        String sql = "INSERT INTO Museum (Id, Navn, Sted) VALUES (?, ?, ?)";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, museum.getId());
            pstmt.setString(2, museum.getNavn());
            pstmt.setString(3, museum.getSted());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertCoin(Mynt mynt) {
        String sql = "INSERT INTO Mynt (Id, Funnsted, Finner_id, Funntidspunkt, Antatt_årstall, Museum_id, Diameter, Metall) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, mynt.getId());
            pstmt.setString(2, mynt.getSted());
            pstmt.setInt(3, mynt.getFinnerId());
            pstmt.setString(4, mynt.getFunnTidspunkt());
            pstmt.setInt(5, mynt.getAntattÅrstall());
            pstmt.setInt(6, mynt.getMuseumId());
            pstmt.setInt(7, mynt.getDiameter());
            pstmt.setString(8, mynt.getMetall());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertWeapon(Vaapen vaapen) {
        String sql = "INSERT INTO Vaapen (Id, Funnsted, Finner_id, Funntidspunkt, Antatt_årstall, Museum_id, Type, Materiale, Vekt) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, vaapen.getId());
            pstmt.setString(2, vaapen.getSted());
            pstmt.setInt(3, vaapen.getFinnerId());
            pstmt.setString(4, vaapen.getFunnTidspunkt());
            pstmt.setInt(5, vaapen.getAntattÅrstall());
            pstmt.setInt(6, vaapen.getMuseumId());
            pstmt.setString(7, vaapen.getType());
            pstmt.setString(8, vaapen.getMateriale());
            pstmt.setInt(9, vaapen.getVekt());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertSmykke(Smykke smykke) {
        String sql = "INSERT INTO Smykke (Id, Funnsted, Finner_id, Funntidspunkt, Antatt_årstall, Museum_id, Type, Verdiestimat, filnavn) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, smykke.getId());
            pstmt.setString(2, smykke.getSted());
            pstmt.setInt(3, smykke.getFinnerId());
            pstmt.setString(4, smykke.getFunnTidspunkt());
            pstmt.setInt(5, smykke.getAntattÅrstall());
            pstmt.setInt(6, smykke.getMuseumId());
            pstmt.setString(7, smykke.getType());
            pstmt.setInt(8, smykke.getVerdiestimat());
            pstmt.setString(9, smykke.getFilnavn());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
