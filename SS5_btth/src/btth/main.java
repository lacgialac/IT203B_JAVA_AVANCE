package btth;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

public class main {
   static ArrayList<Product>products = new ArrayList<>();
   static Scanner sc= new Scanner(System.in);



    static void addProduct()throws InvalidProductException{
        System.out.print("ID: ");
        int id=Integer.parseInt(sc.nextLine());

        boolean exits = products.stream().anyMatch(p-> p.getId()==id);

        if (exits){
            throw new InvalidProductException("trung id roi ");
        }

        System.out.print("Name: ");
        String name=sc.nextLine();

        System.out.print("Price: ");
        double price=Double.parseDouble(sc.nextLine());

        System.out.print("Quantity: ");
        int quantity=Integer.parseInt(sc.nextLine());

        System.out.print("Category: ");
        String category=sc.nextLine();

        products.add(new Product(id,name,price,quantity,category));
        System.out.print("them thanh cong");
    }

   static void displayProducts(){
        System.out.printf("%-10s %-10s %-10s %-10s %-10s\n",
                    "id", "name", "price", " qty", "category"
                );
        products.forEach(p->System.out.printf("%-10d %-10s %-10.2f %-10d %15s\n", p.getId(), p.getName(),p.getPrice(),p.getQuantity(),p.getCategory()));
   }


   static void updateQuantityProduct()throws InvalidProductException{
        System.out.print("nhap vao id can thay doi");
        int id = Integer.parseInt(sc.nextLine());

        Optional<Product> productop= products.stream().filter(p-> p.getId()==id).findFirst();
        if(productop.isEmpty()){
            throw new InvalidProductException("id khong ton tai ");
        }
        System.out.println("da tim thay nguoi dung đó có tồn tại, vui lòng nhập số lượng quantity muốn thay đổi");
        int newQuantity = Integer.parseInt(sc.nextLine());

        productop.get().setQuantity(newQuantity);
        System.out.println("cập nhật thành ccoong");

   }

   static void deleteProduct(){
        products.removeIf(p->p.getQuantity()==0);
        System.out.println("đã xóa các QUantity = 0 ");
   }



    public static void main(String[] args) {
        while(true){
            int choice = Menu.menu();
            System.out.println(choice);

            try{
                switch (choice){
                    case 1:
                        addProduct();
                        break;

                    case 2:
                        displayProducts();
                        break;

                    case 3:
                        updateQuantityProduct();
                        break;

                    case 5:
                        System.out.println("thoat");
                        return ;

                    default:{
                        System.out.println("nhap sai lua chon");
                    }
                }
            }catch (InvalidProductException e){
                System.out.println("Lỗi: " + e.getMessage());

            }

        }
    }



}
