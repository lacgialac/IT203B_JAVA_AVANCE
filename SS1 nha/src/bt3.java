import java.util.IllformedLocaleException;

public class bt3 {
   static class User{
        private int age;

        public  void setage(int age){
            if(age<0){
                throw new IllegalArgumentException("tupi ko the am");
            }
            this.age=age;
        }
    }

    public static void main(String[] args) {
        User user1= new User();

        try{
            user1.setage(-5);
        }catch (IllegalArgumentException e){
            System.out.print("loi"+ e.getMessage());
        }
    }
}
