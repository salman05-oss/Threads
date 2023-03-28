import java.util.Scanner;

class Counter implements Runnable{
    public static int cnt=0;
    public synchronized void run(){
        for(int i=0;i<1000;i++) {
            cnt++;
        }
    }
    public void show(){
        System.out.println(cnt);
    }
}
class Part1 extends Thread{
    public void run(){
        for(int i=0; i<5; ++i) {
            System.out.println("Class - 1");
            try {
                Thread.sleep(1000);
            }
            catch (Exception e){}
        }
    }
}

class Part2 extends Thread{
    public void run(){
        for(int i=0; i<5; ++i) {
            System.out.println("Class - 2");
            try {
                Thread.sleep(1000);
            }
            catch (Exception e){}
        }
    }
}


public class Main {
    public static void main(String[] args) throws Exception{
        Counter count = new Counter();
        Thread obj = new Thread(count);

        Part1 p1 = new Part1();
        Part2 p2 = new Part2();

        p1.start();
        p2.start();
        System.out.println(p1.getPriority());

        obj.setName("First Thread");
        obj.setPriority(1);

        Thread obj1 = new Thread(count,"Second Thread");
        obj1.setPriority(10);

        System.out.println(obj.getName());
        System.out.println(obj1.getName());

        obj.start();
        System.out.println(obj.isAlive());
        obj1.start();

        obj.join();
        obj1.join();

        count.show();

    }

void main(){
        Scanner sc = new Scanner(System.in);//Thread - 1
        int num1 = sc.nextInt();//Thread - 1
        int num2 = sc.nextInt();//Thread -
        int addition = add(num1,num2);
        int multi = mul(num1,num2);
        System.out.println(addition);
        System.out.println(multi);
}

}






























