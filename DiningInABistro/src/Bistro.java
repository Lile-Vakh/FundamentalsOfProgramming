public class Bistro {
    private int seats;
    private Thread order, meal, waiter;

    public Bistro(int n) {
        this.seats = n;
        waiter = new Thread(this::serve);
        waiter.start();
    }

    public void shutdown() {
        waiter.interrupt();
    }

    public synchronized void dine(int price) {
        while (seats <= 0) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        seats--;

        while (order != null) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        order = Thread.currentThread();
        System.out.println("Guest " + Thread.currentThread().getId()
                + " orders for " + price + " Lari");
        notifyAll();

        while (meal != Thread.currentThread()) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException("Waiting for meal has been interrupted..");
            }
        }
        meal = null;
        System.out.println("Guest " + Thread.currentThread().getId() + " eats ...");
        seats++;
        notifyAll();
    }


    public synchronized void serve() {
        while (!waiter.isInterrupted()) {
            while (order == null) {
                try {
                    wait();
                } catch (InterruptedException e) {
                }
            }
            Thread recorded = order;
            order = null;
            notifyAll();

            while (meal != null) {
                try {
                    wait();
                } catch (InterruptedException e) {
                }

            }
            meal = recorded;
            System.out.println("Enjoy!");
            notifyAll();
        }
    }
}