package Entity;

public class PhysicalProduct extends Product{
    private double weight;

    public PhysicalProduct(String id, String name, double price, double weight){
        super(id, name, price);
        this.weight=weight;
    }

    @Override
    public void displayInfo(){
        System.out.println("PhysicalProduct: id: "+ id+" name:"+ name+"price: "+price+"weight: "+ weight);
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
