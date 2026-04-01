package manager;

import Entry.Order;

import java.util.ArrayList;
import java.util.List;

public class managerOrder {
    private List<Order> lists=new ArrayList<>();
    private static managerOrder kho;

    public static managerOrder getKho(){
        if(kho==null){
            kho=new managerOrder();
        }
        return kho;
    }

    public void add(Order o){
        lists.add(o);
        System.out.println("da them thanh cong");
    }

    public void displayOrder(){
        if(lists.isEmpty()){
            System.out.println("danh sach rong");
            return;
        }
        lists.forEach(Order:: displayData);

    }

    public void findbyname(String name){
        boolean lac=false;
        for(Order o : lists){
            if(o.getCustomerName().toLowerCase().contains(name.toLowerCase())){
                o.displayData();
                lac=true;
            }

            if(!lac){
                System.out.println("khong tiem thay name");
            }
        }
    }

    public void searchTotalAmount(int x){
        boolean nn= false;
        for(Order o : lists){
            if(o.getTotalAmount()>x){
                o.displayData();
                nn=true;
            }
        }

        if(!nn){
            System.out.println("ko tiem thay cai nao lon hơn X");
            return;
        }
    }

    public void delete(String id){
        boolean laccc= lists.removeIf(o->o.getOrderId().equals(id));

        if (laccc) {
            System.out.println("Xóa thành công!");
        } else {
            System.out.println("Không tìm thấy id");
        }
    }

}
