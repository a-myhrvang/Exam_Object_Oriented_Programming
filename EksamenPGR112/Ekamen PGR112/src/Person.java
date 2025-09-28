public class Person {
    private int id;
    private String navn;
    private String tlf;
    private String epost;

    public Person(int id, String navn, String tlf, String epost) {
        this.id = id;
        this.navn = navn;
        this.tlf = tlf;
        this.epost = epost;
    }

    public int getId() {
        return id;
    }

    public String getNavn() {
        return navn;
    }

    public String getTlf() {
        return tlf;
    }

    public String getEpost() {
        return epost;
    }
}
