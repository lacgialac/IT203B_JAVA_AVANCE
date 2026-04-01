package btth;

import java.util.Scanner;

public class Menu {
    static Scanner sc = new Scanner(System.in);

    static int menu(){
        System.out.println("MENU");
        System.out.println("1. thêm sản phâmr mới");
        System.out.println("2. hiển thị danh sách sản phẩm");
        System.out.println("3. cập nhật số lượng theo id ");
        System.out.println("4. xóa sảng phẩm đã hết hàng ");
        System.out.println("5. thoát chường trình");

        return Integer.parseInt(sc.nextLine());

    }

}
