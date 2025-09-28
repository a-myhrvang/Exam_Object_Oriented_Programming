public class Mynt extends Funn {
    private int diameter;
    private String metall;

    public Mynt(int id, String sted, int finnerId, String funnSted, int antattÅrstall, int museumId, int diameter, String metall) {
        super(id, sted, finnerId, funnSted, antattÅrstall, museumId);
        this.diameter = diameter;
        this.metall = metall;
    }

    public int getDiameter() {
        return diameter;
    }

    public String getMetall() {
        return metall;
    }
}
