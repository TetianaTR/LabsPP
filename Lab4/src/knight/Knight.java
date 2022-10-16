package knight;

public class Knight {
    private String name;
    private int age ;
    private int century ;
    private String nationality;

    public Knight(String name, int age, int century, String nationality) {
        this.name = name;
        this.age = age;
        this.century = century;
        this.nationality = nationality;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getCentury() {
        return century;
    }

    public void setCentury(int century) {
        this.century = century;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }


}
