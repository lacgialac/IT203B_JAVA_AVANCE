import Entity.PhysicalProduct;
import Entity.Product;
import Entity.digitalProduct;
import Factory.ProductFactory;
import database.database;

import java.util.Scanner;

public class MENU {
    public static void displayMenu(){
        Scanner sc= new Scanner(System.in);
        int choice;
        database mot= database.getLac();

        do{
            System.out.println("\n------ QUAN LY SAN PHAM ------");
            System.out.println("1. Them");
            System.out.println("2. Xem");
            System.out.println("3. Cap nhat");
            System.out.println("4. Xoa");
            System.out.println("5. Thoat");
            System.out.print("Chon: ");
            choice=sc.nextInt();

            switch (choice){
                case 1:
                    System.out.println("chon loai sang pham muon them: (1: digitalProduct /  2: physicalProduct)");
                    int type =sc.nextInt();
                    sc.nextLine();


                    System.out.print("ID: ");
                    String id = sc.nextLine();

                    System.out.print("Name: ");
                    String name = sc.nextLine();

                    System.out.print("Price: ");
                    double price = sc.nextDouble();

                    System.out.print("Extra (weight/size): ");
                    double extra = sc.nextDouble();
                    sc.nextLine();

                    Product p= ProductFactory.createProduct(type, id, name, price, extra);
                    mot.addProduct(p);
                    break;

                case 2:
                    for(Product de : mot.getAll()){
                        de.displayInfo();
                    }
                    break;

                case 3:
                    System.out.println("nhap vao id can chinh sua: ");
                    sc.nextLine();
                    String idSearch=sc.nextLine();
                    Product Pfound= mot.findId(idSearch);

                    if (Pfound!=null){
                        System.out.print("ID: ");
                        String newid = sc.nextLine();

                        System.out.print("Name: ");
                        String newname = sc.nextLine();

                        System.out.print("Price: ");
                        double newprice = sc.nextDouble();

                        System.out.print("Extra (weight/size): ");
                        double newextra = sc.nextDouble();
                        sc.nextLine();

                        Pfound.setId(newid);
                        Pfound.setName(newname);
                        Pfound.setPrice(newprice);

                        if(Pfound instanceof PhysicalProduct){
                            ((PhysicalProduct )Pfound).setWeight(newextra);
                        }
                        else if(Pfound instanceof digitalProduct){
                            ((digitalProduct)Pfound).setSize(newextra);
                        }

                        System.out.println("cap nhat thanh cong");
                    }else{
                        System.out.println("id ko ton tai");
                    }

                break;

                case 4:
                    System.out.println("nhap vao id can delete");
                    sc.nextLine();
                    String idToDelete= sc.nextLine();

                    if(mot.delete(idToDelete)){
                        System.out.println("da xoa thanh cong");
                    }else{
                        System.out.println("ko tiem thay");
                    }
                    break;



                default:
                    System.out.println("nhap sai lua chon ");
            }

        }while(choice !=5);
    }
}
