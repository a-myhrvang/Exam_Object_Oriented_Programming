public class Vaapen2 extends HistoricalObject {
    private String type;
    private String materiale;
    private int vekt;

    public Vaapen2(int id, String funnsted, int finnerid, String funntidspunkt, int antattårsmodell, int museumId, String type, String materiale, int vekt) {
        super(id, funnsted, finnerid, funntidspunkt, antattårsmodell, museumId);
        this.type = type;
        this.materiale = materiale;
        this.vekt = vekt;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMateriale() {
        return materiale;
    }

    public void setMateriale(String materiale) {
        this.materiale = materiale;
    }

    public int getVekt() {
        return vekt;
    }

    public void setVekt(int vekt) {
        this.vekt = vekt;
    }

    @Override
    public String toString() {
        return "Vaapen - " + super.toString() +
                ", Type: " + type +
                ", Materiale: " + materiale +
                ", Vekt: " + vekt;
    }
}
