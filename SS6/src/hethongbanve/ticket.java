package hethongbanve;

public class ticket {
    private int id;
    private boolean sold;

    public ticket(int id){
        this.id=id;
        this.sold=false;
    }



    public int getId(){
        return id;
    }

    public boolean isSold(){
        return sold;
    }


}
