import java.io.IOException;

public class bt4 {
    public static void saveToFile() throws IOException {
        System.out.println("dang luu file");
        throw new IOException("loi khi dang ghi file");
    }

    public static void processUserData()throws IOException{
        System.out.println("dang xu ly nhe");
        saveToFile();
    }

    public static void main(String[] args) {
        try{
            processUserData();
        }catch(IOException e){
            System.out.println("loi la: "+e.getMessage());
        }

        System.out.print("chuong trinh dang chay tiep tuc");
    }
}
