import Entry.Order;
import manager.managerOrder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Scanner sc=new Scanner(System.in);
        managerOrder kholac= managerOrder.getKho();

        int choice;

        do{
            System.out.println("\n===== MENU =====");
            System.out.println("1. Thêm đơn");
            System.out.println("2. Hiển thị");
            System.out.println("3. Tìm > tiền");
            System.out.println("4. Tìm theo tên");
            System.out.println("5. Update status");
            System.out.println("6. Xóa Cancelled");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice){
                case 1:
                    System.out.println("nhap vao id");
                   String id= sc.nextLine();

                   System.out.println("nhap vao namee: ");
                   String name= sc.nextLine();

                   System.out.println("nhap vao totalAmount");
                   int totalAmount= sc.nextInt();
                   sc.nextLine();

                   System.out.println("nhap vao status");
                   String status=sc.nextLine();

                   System.out.println("nhap vao ngay thang: ");
                   String date=sc.nextLine();

                    Order o = new Order(id, name, totalAmount, status, date);
                    kholac.add(o);
                    break;
                case 2:
                    kholac.displayOrder();
break;

                case 3:
                    System.out.println("nhap vao x");
                    int x =sc.nextInt();
                    sc.nextLine();
                    kholac.searchTotalAmount(x);

                    break;
                case 4:
                    System.out.println("nhap vao ten khach hang can tiem");
                    String sheachName= sc.nextLine();

                 kholac.findbyname(sheachName);
                 break;

                case 5:
                    System.out.println("nhap vao id can xoa");
                    String idToDele= sc.nextLine();
                    kholac.delete(idToDele);
                    break;
            }
        }while(choice!=5);
    }
}