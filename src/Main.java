public class Main implements Runnable {

    //static int i = 0;
    public static void main(String[] args) {

        for(int i = 0; i<30; i++){
            Thread temp = new Thread(new Main());
            temp.start();
        }
    }

    public void run() {
        Item item = null;
        try {
            item = Item.getInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Started "+Thread.currentThread().getName() +"\tRunning: "+ item.getName());
        System.out.flush();
    }
}
