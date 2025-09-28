import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseManager2 {
    private static Connection connection;

    public DatabaseManager2() {
        try {

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Funn", "root", "yourpasswd");
        } catch (SQLException e) {
            System.out.println("Error connecting to the database: " + e.getMessage());
        }
    }

    public static List<Object> getAllObjects() {
        List<Object> objects = new ArrayList<>();
        String query = "SELECT * FROM mynt UNION SELECT * FROM smykke UNION SELECT * FROM vaapen";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                int id = resultSet.getInt("Id");
                String funnsted = resultSet.getString("Funnsted");
                int finnerid = resultSet.getInt("Finner_id");
                String funntidspunkt = resultSet.getString("Funntidspunkt");
                int antattÅrstall = resultSet.getInt("Antatt_årstall");
                int museumId = resultSet.getInt("Museum_id");


                if (resultSet.getMetaData().getTableName(1).equalsIgnoreCase("mynt")) {
                    int diameter = resultSet.getInt("Diameter");
                    String metall = resultSet.getString("Metall");
                    Mynt mynt = new Mynt(id, funnsted, finnerid, funntidspunkt, antattÅrstall, museumId, diameter, metall);
                    objects.add(mynt);
                } else if (resultSet.getMetaData().getTableName(1).equalsIgnoreCase("smykke")) {
                    String type = resultSet.getString("Type");
                    int verdiestimat = resultSet.getInt("Verdiestimat");
                    String filnavn = resultSet.getString("filnavn");
                    Smykke smykke = new Smykke(id, funnsted, finnerid, funntidspunkt, antattÅrstall, museumId, type, verdiestimat, filnavn);
                    objects.add(smykke);
                } else if (resultSet.getMetaData().getTableName(1).equalsIgnoreCase("vaapen")) {
                    String type = resultSet.getString("Type");
                    String materiale = resultSet.getString("Materiale");
                    int vekt = resultSet.getInt("Vekt");
                    Vaapen vaapen = new Vaapen(id, funnsted, finnerid, funntidspunkt, antattÅrstall, museumId, type, materiale, vekt);
                    objects.add(vekt);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving objects from database: " + e.getMessage());
        }
        return objects;
    }

    public static List<Object> getObjectsOlderThanYear(int year) {
        List<Object> objects = new ArrayList<>();
        String query = "SELECT * FROM mynt WHERE Antatt_årstall < ? UNION " +
                "SELECT * FROM smykke WHERE Antatt_årstall < ? UNION " +
                "SELECT * FROM vaapen WHERE Antatt_årstall < ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, year);
            statement.setInt(2, year);
            statement.setInt(3, year);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("Id");
                String funnsted = resultSet.getString("Funnsted");
                int finnnerId = resultSet.getInt("Finner_id");
                String funntidspunkt = resultSet.getString("Funntidspunkt");
                int antattÅrstall = resultSet.getInt("Antatt_årstall");
                int museumId = resultSet.getInt("Museum_id");


                if (resultSet.getMetaData().getTableName(1).equalsIgnoreCase("mynt")) {
                    int diameter = resultSet.getInt("Diameter");
                    String metall = resultSet.getString("Metall");
                    Mynt mynt = new Mynt(id, funnsted, finnnerId, funntidspunkt, antattÅrstall, museumId, diameter, metall);
                    objects.add(mynt);
                } else if (resultSet.getMetaData().getTableName(1).equalsIgnoreCase("smykke")) {
                    String type = resultSet.getString("Type");
                    int verdiestimat = resultSet.getInt("Verdiestimat");
                    String filnavn = resultSet.getString("filnavn");
                    Smykke smykke = new Smykke(id, funnsted, finnnerId, funntidspunkt, antattÅrstall, museumId, type, verdiestimat, filnavn);
                    objects.add(smykke);
                } else if (resultSet.getMetaData().getTableName(1).equalsIgnoreCase("vaapen")) {
                    String type = resultSet.getString("Type");
                    String materiale = resultSet.getString("Materiale");
                    int vekt = resultSet.getInt("Vekt");
                    Vaapen vaapen = new Vaapen(id, funnsted, finnnerId, funntidspunkt, antattÅrstall, museumId, type, materiale, vekt);
                    objects.add(vaapen);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving objects older than " + year + " from database: " + e.getMessage());
        }
        return objects;
    }

    public static int getCountOfObjects() {
        int count = 0;
        String query = "SELECT COUNT(*) FROM mynt UNION SELECT COUNT(*) FROM smykke UNION SELECT COUNT(*) FROM vaapen";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                count += resultSet.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println("Error counting objects from database: " + e.getMessage());
        }
        return count;
    }

    public boolean personExists(int personId) {
        String sql = "SELECT * FROM person WHERE Id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, personId);
            ResultSet resultSet = statement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            System.out.println("Error checking if person exists: " + e.getMessage());
            return false;
        }
    }

    public static void close() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            System.out.println("Error closing database connection: " + e.getMessage());
        }
    }
}
