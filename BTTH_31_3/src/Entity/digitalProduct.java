package Entity;

public class digitalProduct extends Product{
    private double size;

    public digitalProduct(String id, String name, double price, double size){
        super(id, name, price);
        this.size=size;
    }

    @Override
    public void displayInfo(){
        System.out.println("PhysicalProduct: id: "+ id+" name:"+ name+"price: "+price+"weight: "+ size);

    }

    public void setSize(double size) {
        this.size = size;
    }
}
