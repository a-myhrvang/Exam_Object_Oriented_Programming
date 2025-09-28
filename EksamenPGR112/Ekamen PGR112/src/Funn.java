public abstract class Funn {
    private int id;
    private String Sted;
    private int finnerId;
    private String funnTidspunkt;
    private int antattÅrstall;
    private int museumId;

    public Funn(int id, String sted, int finnerId, String funnTidspunkt, int antattÅrstall, int museumId) {
        this.id = id;
        this.Sted = sted;
        this.finnerId = finnerId;
        this.funnTidspunkt = funnTidspunkt;
        this.antattÅrstall = antattÅrstall;
        this.museumId = museumId;
    }

    public int getId() {
        return id;
    }

    public String getSted() {
        return Sted;
    }

    public int getFinnerId() {
        return finnerId;
    }

    public String getFunnTidspunkt() {
        return funnTidspunkt;
    }

    public int getAntattÅrstall() {
        return antattÅrstall;
    }

    public int getMuseumId() {
        return museumId;
    }
}
