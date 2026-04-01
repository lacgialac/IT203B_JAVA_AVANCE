package hethongbanve;

import java.util.LinkedList;
import java.util.Queue;

public class TicketPool {
    private Queue<ticket> tickets= new LinkedList<>();
    private int nextId= 1;

    public  TicketPool(int soluongvebandau){
        for (int i=0;i<soluongvebandau;i++){
            tickets.add(new ticket(nextId++));
        }
    }

    public ticket sellTicket(){
        if (tickets.isEmpty()){
            return null;

        }
        return tickets.poll();
    }

//    public  addTickets(int count){
//
//    }

    public int getAvailableCount(){
        return tickets.size();
    }

}
