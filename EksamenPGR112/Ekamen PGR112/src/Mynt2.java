public class Mynt2 extends HistoricalObject {
    private int diameter;
    private String metall;

    public Mynt2(int id, String funnsted, int finnerid, String funntidspunkt, int antattårstall, int museumId, int diameter, String metall) {
        super(id, funnsted, finnerid, funntidspunkt, antattårstall, museumId);
        this.diameter = diameter;
        this.metall = metall;
    }

    public int getDiameter() {
        return diameter;
    }
}
