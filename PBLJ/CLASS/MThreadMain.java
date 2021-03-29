package PBLJ.CLASS;

class MThread extends Thread{
    public void run(){
        try{
            System.out.println("Thread ID: "+Thread.currentThread().getId());
        }catch(Exception e){
            System.out.println(e.getLocalizedMessage());
        }
    }
}

class Sender extends Thread{

    public void send(String msg){
        System.out.println("[sending]\t"+msg);

        try{
            Thread.sleep(1000);
        }catch(Exception e){
            System.out.println(e.getLocalizedMessage());
        }
        System.out.println(msg+" [sent]\n");

    }
}

class ThreadSend extends Thread{
    private final String msg;

    final Sender sender;

    ThreadSend(String msg,Sender sender){
        this.msg = msg;
        this.sender = sender;
    }

     public void run(){
        synchronized (sender){
            sender.send(msg);
        }
    }
}

class Table{
    synchronized public void printTable(int n){
        for(int i=1;i<=5;i++){
            System.out.println(n*i);
        }
        try {
            Thread.sleep(1000);
        }catch (Exception e){
            System.out.println(e.getLocalizedMessage());
        }finally {
            System.out.println("Table ended");
        }
    }
}

class TableThread extends Thread{
    private final int table ;

    final Table t;

    TableThread(Table t, int table) {
        this.t = t;
        this.table = table;
    }

    synchronized public void run(){
//        synchronized (t){
            t.printTable(table);
//        }
    }
}


public class MThreadMain{
    public static void main(String[] args) {

        Table t = new Table();

        TableThread t1 = new TableThread(t,12);
        TableThread t2 = new TableThread(t,13);

        t1.start();
        t2.start();

        try{
            t1.join();
            t2.join();
        }catch(Exception e){
            System.out.println(e.getLocalizedMessage());
        }

    }
}

//    Sender s = new Sender();
//    ThreadSend t1 = new ThreadSend("Hi",s);
//    ThreadSend t2 = new ThreadSend("Hello",s);
//
//        t1.start();
//        t2.start();
//
//                try{
//                t1.join();
//                t2.join();
//                }catch (Exception e){
//                System.out.println(e.getLocalizedMessage());
//                }


//        Thread t1 = new Thread("T1");
//        Thread t2 = new Thread("T2");
//        t1.start();
//        t2.start();
//        System.out.println(t1.getName()+" "+t1.getId());
//        System.out.println(t2.getName()+" "+t2.getId());
//
//        for(int i=0;i<12;i++){
//            MThread thread = new MThread();
//            thread.start();
//        }