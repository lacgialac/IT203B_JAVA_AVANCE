import java.util.function.Predicate;

public class bt1 {
    // kiem tra xem 1 user co phai admin hay khong ta dung Predicate vi nhan vao 1 doi tuong tra ve true hoac false
   // Predicate<User> isAdmin = user -> user.getRole().equals("ADMIN");

    // chuyen doi tu 1 objetc lay ra uéname chuyen thanh string ta dung function vi no co the lay vao kieu du lieu nay cho ra kieu du lieu khac
    //Function<User, String> toUsername = user -> user.getUsername();

    // in ra tt cua 1 usser thi ta dùng Consumer vì nó nhận vào T và sẽ không trả về bất kỳ gì
    //Consumer<User> printUser = user -> System.out.println(user);

    //khởi tạo 1 giá trị user mới với giá trị mac dinh ta dung Supplier vif cơ bản Supplier không nhận bất kì gì nó chỉ khởi tạo mà thôi
    //Supplier<User> createUser = () -> new User("default", 18);
}
