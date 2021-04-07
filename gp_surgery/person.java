package gp_surgery;

public abstract class person {
    private String title;
    private String forename;
    private String surname;

    public person(String title, String forename, String surname) {
        this.title = title;
        this.forename = forename;
        this.surname = surname;
    }
    @Override
    public String toString() {
        return title + " " + forename + " " + surname;
    };
}