public abstract class HistoricalObject {
    protected int id;
    protected String funnsted;
    protected int finnerid;
    protected String funntidspunkt;
    protected int antattårstall;
    protected int museumId;

    public HistoricalObject(int id, String funnsted, int finnerid, String funntidspunkt, int antattårstall, int museumId) {
        this.id = id;
        this.funnsted = funnsted;
        this.finnerid = finnerid;
        this.funntidspunkt = funntidspunkt;
        this.antattårstall = antattårstall;
        this.museumId = museumId;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFunnsted() {
        return funnsted;
    }

    public void setFunnsted(String funnsted) {
        this.funnsted = funnsted;
    }

    public int getFinnerid() {
        return finnerid;
    }

    public void setFinnerid(int finnerid) {
        this.finnerid = finnerid;
    }

    public String getFunntidspunkt() {
        return funntidspunkt;
    }

    public void setFunntidspunkt(String funntidspunkt) {
        this.funntidspunkt = funntidspunkt;
    }

    public int getAntattårstall() {
        return antattårstall;
    }

    public void setAntattårstall(int antattårstall) {
        this.antattårstall = antattårstall;
    }

    public int getMuseumId() {
        return museumId;
    }

    public void setMuseumId(int museumId) {
        this.museumId = museumId;
    }

    @Override
    public String toString() {
        return "Id: " + id +
                ", Funnsted: " + funnsted +
                ", Finner I: " + finnerid +
                ", Funn tidspunkt: " + funntidspunkt +
                ", Antatt årstall: " + antattårstall +
                ", Museum Id: " + museumId;
    }
}
