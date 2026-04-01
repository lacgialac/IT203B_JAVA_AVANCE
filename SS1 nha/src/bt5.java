public class bt5 {
   static class InvailidAgeException extends Exception{
        public InvailidAgeException(String mg){
            super(mg);
        }
    }

    public static class User{
        private int age;

        public void  setAge(int age)throws InvailidAgeException{
            if(age<0){
                throw new InvailidAgeException("tui ko hop le nha bro");
            }
            this.age=age;
        }

    }

    public static void main(String[] args) {
        User user = new User();

        try {
            user.setAge(-5); // test lỗi
        } catch (InvailidAgeException e) {
            System.out.println(" Loi: " + e.getMessage());
            e.printStackTrace();
        }

        System.out.println("✅ Chay tiep ne!");
    }
}
