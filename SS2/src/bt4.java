import java.util.*;
import java.util.function.Supplier;
import java.util.stream.*;
public class bt4 {


   static class User {
        private String username;

        public User() {
            this.username = "default";
        }

        public User(String username) {
            this.username = username;
        }

        public String getUsername() {
            return username;
        }
    }

        public static void main(String[] args) {

            // Tạo danh sách users
            List<User> users = Arrays.asList(
                    new User("An"),
                    new User("Binh"),
                    new User("Cuong")
            );

            // 1. Lấy username (Method Reference)
            List<String> names = users.stream()
                    .map(User::getUsername)
                    .collect(Collectors.toList());

            // 2. In ra
            names.forEach(System.out::println);

            // 3. Tạo object bằng constructor reference
            Supplier<User> supplier = User::new;

            User u = supplier.get();
            System.out.println(u.getUsername());
        }

}
