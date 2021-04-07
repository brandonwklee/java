package gp_surgery;
import java.util.Date;

public class patient extends person {
    private int age;
    private String address;
    private int contact;
    private Date date;

    public patient(String title, String forename, String surname, int age, String address, int contact, Date date) {
        super(title, forename, surname);
        this.age = age;
        this.address = address;
        this.contact = contact;
        date = new Date();
    }
}