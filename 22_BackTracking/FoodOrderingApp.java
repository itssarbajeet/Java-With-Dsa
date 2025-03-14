import java.util.*;
import java.util.LinkedList;

class FoodOrderingSystem {
    private final Queue<String> orderQueue = new LinkedList<>();
    private final Object lock = new Object();

    public void placeOrder(String customerName, String order) {
        synchronized (lock) {
            orderQueue.add(customerName + " ordered " + order);
            System.out.println(customerName + " placed an order for " + order);
            lock.notify();
        }
    }

    public void prepareOrder() {
        while (true) {
            synchronized (lock) {
                while (orderQueue.isEmpty()) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                }
                String order = orderQueue.poll();
                System.out.println("Preparing: " + order);
                try {
                    Thread.sleep(2000); // Simulate preparation time
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                System.out.println("Completed: " + order);
            }
        }
    }
}

class Customer extends Thread {
    private final FoodOrderingSystem orderingSystem;
    private final String customerName;
    private final String order;

    public Customer(FoodOrderingSystem orderingSystem, String customerName, String order) {
        this.orderingSystem = orderingSystem;
        this.customerName = customerName;
        this.order = order;
    }

    @Override
    public void run() {
        orderingSystem.placeOrder(customerName, order);
    }
}

public class FoodOrderingApp {
    public static void main(String[] args) {
        FoodOrderingSystem system = new FoodOrderingSystem();
        Thread kitchen = new Thread(system::prepareOrder);
        kitchen.start();
        
        Thread[] customers = new Thread[5];
        String[] orders = {"Pizza", "Burger", "Pasta", "Sushi", "Salad"};
        
        for (int i = 0; i < 5; i++) {
            customers[i] = new Customer(system, "Customer " + (i + 1), orders[i]);
            customers[i].start();
        }
    }

    public static int findSecondLargest(int[] arr) {
        if (arr == null || arr.length < 2) {
            throw new IllegalArgumentException("Array must contain at least two elements");
        }
        int first = Integer.MIN_VALUE, second = Integer.MIN_VALUE;
        for (int num : arr) {
            if (num > first) {
                second = first;
                first = num;
            } else if (num > second && num < first) {
                second = num;
            }
        }
        if (second == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("No second largest element found");
        }
        return second;
    }
    
    public static Set<Integer> findIntersection(int[] arr1, int[] arr2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> intersection = new HashSet<>();
        
        for (int num : arr1) {
            set1.add(num);
        }
        
        for (int num : arr2) {
            if (set1.contains(num)) {
                intersection.add(num);
            }
        }
        
        return intersection;
    }
}