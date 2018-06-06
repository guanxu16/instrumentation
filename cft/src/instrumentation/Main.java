package instrumentation;

public class Main {

    public static void main(String[] args) {
        System.out.println("now main");
        System.out.println(new TransClass().getNum());
    }
}
