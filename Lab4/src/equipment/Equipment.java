package equipment;

public class Equipment {

    protected double cost;
    protected String name;
    protected double weight;
    protected String material;
    protected double strength;

    private String typeofarmour;
    public Equipment(String name, String material, double cost, double weight, double strength,String typeofarmour){
        this.name=name;
        this.material=material;
        this.cost=cost;
        this.weight=weight;
        this.strength=strength;
        this.typeofarmour=typeofarmour;
    }
    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public double getStrength() {
        return strength;
    }

    public void setStrength(double strength) {
        this.strength = strength;
    }


    public String getTypeofarmour() { return typeofarmour; }

    public void setTypeofarmour(String typeofarmour) { this.typeofarmour = typeofarmour; }
}
