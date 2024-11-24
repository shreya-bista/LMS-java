public class Patron extends Person {
    public String type;

    public Patron(String name, int id, String type) {
        // constructor
       super(name, id);
       this.type = type;
    }

    public void getPatronDetails(){
        // Method for getting patron details
        System.out.println("Patron name: "+ name);
        System.out.println("Member Type: "+type);
        System.out.println();
    }

    @Override
    public String toString() {
        // Method for printing patron
        return "Patron{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", type='" + type + '\'' +
                '}';
    }
}
