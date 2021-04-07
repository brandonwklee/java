package gp_surgery;

public class doctor extends person {
    private int id, age, contact;
    private String address;

    public doctor(int id, String title, String forename, String surname, int age, String address, int contact) {
        super(title, forename, surname);
        this.id = id;
        this.age = age;
        this.contact = contact;
        this.address = address;
    }

    @Override
    public String toString() {
        return super.toString() + id + " " + age + " " + contact + " " + address;
    }
}