import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account {
    public final static int WAIT_SEC = 1000;
    private int balance;
    Lock lock = new ReentrantLock();

    public Account(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public Lock getLock() {
        return lock;
    }

    public void setLock(Lock lock) {
        this.lock = lock;
    }

    public void withdraw(int amount){
        balance -= amount;
    }

    public void deposit(int amount){
        balance += amount;
    }
}
