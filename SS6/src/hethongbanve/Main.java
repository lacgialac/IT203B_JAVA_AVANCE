package hethongbanve;

public class Main {
    public static void main(String[] args) {
        TicketPool khomoi= new TicketPool(10);

        BookingCounter quay1= new BookingCounter("quầy 1", khomoi);
        BookingCounter quay2= new BookingCounter("quầy 2", khomoi);

        TicketSupplier nhacungcap= new TicketSupplier(khomoi);
    }
}
