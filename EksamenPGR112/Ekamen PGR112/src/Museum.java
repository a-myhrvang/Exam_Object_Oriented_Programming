public class Museum {
    private int id;
    private String navn;
    private String sted;

    public Museum(int id, String navn, String sted) {
        this.id = id;
        this.navn = navn;
        this.sted = sted;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getNavn() {
        return navn;
    }

    public String getSted() {
        return sted;
    }
}
