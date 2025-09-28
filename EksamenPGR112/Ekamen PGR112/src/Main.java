import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DatabaseManager dbManager = new DatabaseManager();
        String filePath = "/Users/andersmyhrvang/Desktop/Funn.txt";

        try (Scanner scanner = new Scanner(new File(filePath))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();

                if (line.equalsIgnoreCase("Person")) {
                    int numPersons = Integer.parseInt(scanner.nextLine().trim());
                    for (int i = 0; i < numPersons; i++) {
                        int id = Integer.parseInt(scanner.nextLine().trim());
                        String navn = scanner.nextLine().trim();
                        String tlf = scanner.nextLine().trim();
                        String epost = scanner.nextLine().trim();
                        Person person = new Person(id, navn, tlf, epost);
                        dbManager.insertPerson(person);
                    }
                } else if (line.equalsIgnoreCase("Museer:")) {
                    int numMuseums = Integer.parseInt(scanner.nextLine().trim());
                    for (int i = 0; i < numMuseums; i++) {
                        int id = Integer.parseInt(scanner.nextLine().trim());
                        String navn = scanner.nextLine().trim();
                        String sted = scanner.nextLine().trim();
                        Museum museum = new Museum(id, navn, sted);
                        dbManager.insertMuseum(museum);
                    }
                } else if (line.equalsIgnoreCase("Funn:")) {
                    while (scanner.hasNextLine()) {
                        line = scanner.nextLine().trim();
                        if (line.isEmpty() || line.equals("-------")) continue;

                        try {
                            int id = Integer.parseInt(line);
                            String funnsted = scanner.nextLine().trim();
                            int finnerid = Integer.parseInt(scanner.nextLine().trim());
                            String funntidspunkt = scanner.nextLine().trim();
                            int antattårstall = Integer.parseInt(scanner.nextLine().trim());
                            String museumIdStr = scanner.nextLine().trim();
                            int museumId = museumIdStr.isEmpty() ? 0 : Integer.parseInt(museumIdStr);
                            String type = scanner.nextLine().trim();

                            if (type.equalsIgnoreCase("Mynt")) {
                                int diameter = Integer.parseInt(scanner.nextLine().trim());
                                String metall = scanner.nextLine().trim();
                                Mynt mynt = new Mynt(id, funnsted, finnerid, funntidspunkt, antattårstall, museumId, diameter, metall);


                                if (dbManager.personExists(finnerid)) {
                                    dbManager.insertCoin(mynt);
                                } else {
                                    System.out.println("Person with ID " + finnerid + " does not exist. Skipping coin insertion.");
                                }

                            } else if (type.equalsIgnoreCase("Smykke")) {
                                int verdiestimat = Integer.parseInt(scanner.nextLine().trim());
                                String filnavn = scanner.nextLine().trim();
                                Smykke smykke = new Smykke(id, funnsted, finnerid, funntidspunkt, antattårstall, museumId, type, verdiestimat, filnavn);


                                if (dbManager.personExists(finnerid)) {
                                    dbManager.insertSmykke(smykke);
                                } else {
                                    System.out.println("Person with ID " + finnerid + " does not exist. Skipping smykke insertion.");
                                }

                            } else if (type.equalsIgnoreCase("Vaapen")) {
                                String materiale = scanner.nextLine().trim();
                                int vekt = Integer.parseInt(scanner.nextLine().trim());
                                Vaapen vaapen = new Vaapen(id, funnsted, finnerid, funntidspunkt, antattårstall, museumId, type, materiale, vekt);


                                if (dbManager.personExists(finnerid)) {
                                    dbManager.insertWeapon(vaapen);
                                } else {
                                    System.out.println("Person with ID " + finnerid + " does not exist. Skipping weapon insertion.");
                                }
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Error parsing number: " + e.getMessage());
                        }
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}
