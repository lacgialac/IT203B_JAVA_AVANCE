package hethongbanve;

public class BookingCounter implements Runnable {
    private String name;
    private TicketPool pool;

    public BookingCounter(String name,TicketPool pool){
        this.name=name;
        this.pool=pool;
    }
    @Override
    public void run(){
        ticket t= pool.sellTicket();

        while(true){

            if(t==null){
                System.out.println(name+"hết vé ");
                break;
            }
        }
    }
}
