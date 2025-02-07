public class Penguin implements Runnable {

    private String name;
    private Table table;

    public Penguin(String name, Table table) {
        this.name =  name;
        this.table = table;
    }

    public void eat() {
        for(int i = 1; i <= 2; i++) {
            int requiredForks = (i == 1) ? 2 : 1;
            while(requiredForks > table.forks) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    System.out.println("Something went wrong.");
                    return;
                }
            }
            table.takeFork();
            System.out.println(name + " takes fork #" + i);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Something went wrong.");
                return;
            }
        }

        System.out.println(name + " ate.");
        table.returnFork();
        table.returnFork();
    }

    @Override
    public void run() {
        eat();
    }
}