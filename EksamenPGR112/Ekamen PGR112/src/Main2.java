import java.util.List;
import java.util.Scanner;

public class Main2 {

    private static DatabaseManager databaseManager = new DatabaseManager();
    private static Scanner scanner = new Scanner(System.in);

    public static void main2(String[] args) {
        displayMenu();
    }

    private static void displayMenu() {
        while (true) {
            System.out.println("\n=== Database om funn av historiske gjenstander ===");
            System.out.println("1. Se informasjon om alle funngjenstander.");
            System.out.println("2. Se informasjon om alle funngjenstander eldre enn <årstall>");
            System.out.println("3. Få informasjon om antall funngjenstander registrert.");
            System.out.println("4. Avslutte programmet.");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    displayAllObjects();
                    break;
                case 2:
                    displayObjectsOlderThanYear();
                    break;
                case 3:
                    displayCountOfObjects();
                    break;
                case 4:
                    System.out.println("Avslutter programmet...");
                    DatabaseManager2.close();
                    scanner.close();
                    return;
                default:
                    System.out.println("Ugyldig valg. Vennligst tast et tall mellom 1 og 4.");
                    break;
            }
        }
    }

    private static void displayAllObjects() {
        List<Object> objects = DatabaseManager2.getAllObjects();
        System.out.println("\n=== Alle gjenstander ===");
        for (Object obj : objects) {
            System.out.println(obj);
        }
    }

    private static void displayObjectsOlderThanYear() {
        System.out.print("Skriv inn årstallet: ");
        int year = scanner.nextInt();
        scanner.nextLine();
        List<Object> objects = DatabaseManager2.getObjectsOlderThanYear(year);
        System.out.println("\n=== Gjenstander eldre enn " + year + " ===");
        for (Object obj : objects) {
            System.out.println(obj);
        }
    }

    private static void displayCountOfObjects() {
        int count = DatabaseManager2.getCountOfObjects();
        System.out.println("\nAntall gjenstander funnet: " + count);
    }
}
