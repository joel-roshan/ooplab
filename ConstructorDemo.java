
public class ConstructorDemo {
    private String message;
    int age;

    // Constructor
    public ConstructorDemo(String message,int age) {
        this.message = message;
        age=age;
    }

    public void displayMessage() {
        System.out.println(message);
        System.out.println(age);
    }

    public static void main(String[] args) {
        ConstructorDemo obj = new ConstructorDemo("anna is cute",19);
        ConstructorDemo obj2 = new ConstructorDemo("anna is looking a cow",20);
        obj2.displayMessage();
        obj.displayMessage();
    }
}
