import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Test {
    public static void main(String[] arr){
        BlockingQueue<String[]> queue = new LinkedBlockingQueue<>(100);
        String[] str = {"abc","23d","1a"};
        Producer p1 = new Producer(queue,str);
        Consumer c1 = new Consumer(queue,str);
        p1.start();
        c1.start();

    }
}

class Producer extends Thread{
    private BlockingQueue<String[]> queue;  //产品资源存在BlockQueue中
    private String[] str;
    public Producer(BlockingQueue<String[]> queue,String[] str){
        this.queue=queue;
        this.str = str;
    }

    public void run(){
        int i = 1;
        while(true){
            try {
                queue.put(str);
                System.out.println("第"+i+"个产品生产完毕");
                Thread.sleep(90);
                i++;
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}

class Consumer extends Thread{
    private BlockingQueue<String[]> queue;
    private String[] str;
    public Consumer(BlockingQueue<String[]> queue,String[] str){
        this.queue=queue;
        this.str = str;
    }

    public void run(){
        int i = 1;

        String[] newstr = new String[str.length];
        for(int j = 0;j<str.length;j++){
            newstr[j] = new StringBuffer(str[str.length-j-1]).reverse().toString();
        }
        while (true){
            try {
                queue.take();
                System.out.println("第"+i+"个消费者拿到产品");
                System.out.println(Arrays.toString(newstr));
                Thread.sleep(100);
                i++;
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
