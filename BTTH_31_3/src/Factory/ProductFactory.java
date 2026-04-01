package Factory;

import Entity.PhysicalProduct;
import Entity.Product;
import Entity.digitalProduct;

public class ProductFactory {
    public static Product createProduct(int type, String id, String name, double price, double extra){
        if(type==1){
            return new digitalProduct(id, name, price, extra);
        }else{
            return new PhysicalProduct(id, name, price, extra);

        }
    }
}
