import java.util.Scanner;

public class bt1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try{
            System.out.print("nhap vao nam sinh cua ban");
            String input = sc.nextLine();

            int namsinh = Integer.parseInt(input);

            int recentlyyear = 2026;
            int tuoithuc= recentlyyear - namsinh;

            System.out.println("tuou cua ban la: "+ tuoithuc);


        }catch(NumberFormatException e){
            System.out.print("sai roi");
        }finally {
            sc.close();
            System.out.print("thuc hien don dep ");
        }
    }
}
