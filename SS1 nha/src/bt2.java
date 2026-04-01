import java.util.Scanner;

public class bt2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try{
          System.out.print("nhap vao so luong ng dung");
          int total = sc.nextInt();

          System.out.print("nhap vao so luong nhom");
          int sonhom= sc.nextInt();

          int tong= total/sonhom;

        System.out.println("so luong nhom la: "+ tong);

        }catch(ArithmeticException e){
            System.out.print("so phai lon hon 0");
        }finally {
            sc.close();
            System.out.print("thuc hien don dep ");
        }
    }
}
