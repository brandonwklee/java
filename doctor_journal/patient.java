package doctor_journal;

public class patient {
    private String title;
    private String forename;
    private String surname;
    private int age;
    private String address;
    private int phoneNumber;
    private int regDate;
    private String doctor;

    public patient(String titleName, String name, String lastName, int Age, String address, int contact, int registration, String doctorName) {
        this.title = titleName;
        this.forename = name;
        this.surname = lastName;
        this.age = Age;
        this.address = address;
        this.phoneNumber = contact;
        this.regDate = registration;
        this.doctor = doctorName;
    }
}
