class SharedResource {
    private int count = 0;

    // Synchronized method to increment the count
    public synchronized void increment() {
        count++;
        System.out.println(Thread.currentThread().getName() + " incremented count to: " + count);
    }
}

class CountIncrementer extends Thread {
    private SharedResource sharedResource;

    public CountIncrementer(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            sharedResource.increment();
            try {
                Thread.sleep(100); // Simulating some work being done
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class ThreadSynchronizationDemo {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();

        CountIncrementer thread1 = new CountIncrementer(sharedResource);
        CountIncrementer thread2 = new CountIncrementer(sharedResource);

        thread1.start();
        thread2.start();
    }
}
