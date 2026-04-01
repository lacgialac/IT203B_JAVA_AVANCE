public class bt3 {
    public interface Authenticatable {

        String getPassword(); // abstract

        default boolean isAuthenticated() {
            return getPassword() != null && !getPassword().isEmpty();
        }

        static String encrypt(String rawPassword) {
            return "ENC_" + rawPassword;
        }
    }

   static class  User implements Authenticatable {
        private String password;

        public User(String password) {
            this.password = password;
        }

        @Override
        public String getPassword() {
            return password;
        }
    }

    public static void main(String[] args) {

        User u1= new User("");

        System.out.println(u1.isAuthenticated());

        System.out.print(Authenticatable.encrypt("lacc"));
    }


}
