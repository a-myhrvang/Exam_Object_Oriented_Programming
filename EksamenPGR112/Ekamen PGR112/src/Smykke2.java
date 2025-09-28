public class Smykke2 extends HistoricalObject {
    private String type;
    private int verdiestimat;
    private String filnavn;

    public Smykke2(int id, String funnsted, int finnerid, String funntidspunkt, int antattårstall, int museumId, String type, int verdiestimat, String filnavn) {
        super(id, funnsted, finnerid, funntidspunkt, antattårstall, museumId);
        this.type = type;
        this.verdiestimat = verdiestimat;
        this.filnavn = filnavn;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getVerdiestimat() {
        return verdiestimat;
    }

    public void setVerdiestimat(int verdiestimat) {
        this.verdiestimat = verdiestimat;
    }

    public String getFilnavn() {
        return filnavn;
    }

    public void setFilnavn(String filnavn) {
        this.filnavn = filnavn;
    }

    @Override
    public String toString() {
        return "Smykke - " + super.toString() +
                ", Type: " + type +
                ", Verdiestimering: " + verdiestimat +
                ", Fil Navn: " + filnavn;
    }
}
