import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Transfer implements Callable<Boolean> {
    private static final AtomicInteger idGenerator = new AtomicInteger(1);
    private int id;
    public final static int WAIT_SEC = 5;
    private final Account acc1;
    private final Account acc2;
    private final int amount;

    private static final int MAX_TRANSFER_SEC = 7;

    private final Random waitRandom = new Random();

    private CountDownLatch startLatch;

    public Transfer(Account accountTo, Account accountFrom, int amount) {
        this.id = idGenerator.getAndIncrement();
        this.acc1 = accountFrom;
        this.acc2 = accountTo;
        this.amount = amount;
    }

    public Transfer(Account accountTo, Account accountFrom, int amount, CountDownLatch startLatch) {
        this.id = idGenerator.getAndIncrement();
        this.acc1 = accountFrom;
        this.acc2 = accountTo;
        this.amount = amount;
        this.startLatch = startLatch;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Boolean call() throws Exception {
            System.out.println("[" + id + "] " + "Waiting to start...");
            startLatch.await();

        if (acc1.getLock().tryLock(WAIT_SEC, TimeUnit.SECONDS)) {
            try {
                if (acc1.getBalance() < amount) {
                    acc1.isFailTransferCount();
                    throw new IllegalStateException("Insufficient funds in Account " + acc1);
                }
                if (acc2.getLock().tryLock(WAIT_SEC, TimeUnit.SECONDS)) {
                    try {
                        System.out.println("Account 1 and 2 locked.");
                        acc1.withdraw(amount);
                        acc2.deposit(amount);
                        System.out.println("Transfer " + id + " Completed. Acc1: " + acc1.getBalance() +
                                ". Acc2: " + acc2.getBalance());

                        Thread.sleep(waitRandom.nextInt(MAX_TRANSFER_SEC*1000));
                        return true;

                    } finally {
                        acc2.getLock().unlock();
                    }
                } else {
                    acc2.isFailTransferCount();
                    return false;
                }
            } finally {
                acc1.getLock().unlock();
            }
        } else {
            acc1.isFailTransferCount();
            System.out.println("Transfer " + id + " failed");
            return false;

        }
    }
}
