public class Smykke extends Funn {
    private String type;
    private int verdiestimat;
    private String filnavn;

    public Smykke(int id, String sted, int finnerId, String funnTidspunkt, int antattårstall, int museumId, String type, int verdiestimat, String filnavn) {
        super(id, sted, finnerId, funnTidspunkt, antattårstall, museumId);
        this.type = type;
        this.verdiestimat = verdiestimat;
        this.filnavn = filnavn;
    }

    public String getType() {
        return type;
    }

    public int getVerdiestimat() {
        return verdiestimat;
    }

    public String getFilnavn() {
        return filnavn;
    }
}

