package database;

import Entity.Product;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

public class database {
    private static database lac;
    private List<Product> products;

    public database(){
        products= new ArrayList<>();
    }

    public static database getLac(){
        if(lac==null){
            lac=new database();
        }
        return lac;
    }

    public void addProduct(Product p){
        products.add(p);
    }

    public List<Product> getAll() {
        return products;
    }

    public Product findId(String id){
        for(Product p : products){
            if(p.getId().equals(id)) return p;
        }
        return null;
    }

    public boolean delete(String id){
        Product p=findId(id);
        if(p!=null){
            products.remove(p);
            return true;
        }else{
            return false;
        }
    }
}
