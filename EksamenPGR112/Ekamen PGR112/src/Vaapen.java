public class Vaapen extends Funn {
    private String type;
    private String materiale;
    private int vekt;

    public Vaapen(int id, String sted, int finnerId, String funnSted, int antattÅrstall, int MuseumId, String Type, String Materiale, int Vekt) {
        super(id, sted, finnerId, funnSted, antattÅrstall, MuseumId);
        this.type = type;
        this.materiale = materiale;
        this.vekt = vekt;
    }

    public String getType() {
        return type;
    }

    public String getMateriale() {
        return materiale;
    }

    public int getVekt() {
        return vekt;
    }
}
