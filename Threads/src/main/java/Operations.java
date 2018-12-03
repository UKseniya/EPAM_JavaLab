import java.util.concurrent.TimeUnit;

public class Operations {
    public final static int WAIT_SEC = 1000;
    public static void main(String[] args) {
        final Account a = new Account(1000 );
        final Account b = new Account(2000 );

        new Thread(new Runnable() {
            public void run() {
                try {
                    transfer( a, b, 500);
                } catch (InsufficientFundException e) {
                    e.printStackTrace();
                };
                System.out.println("Transfer completed sucessfully. " +
                        "Account 1 Balance: " + a.getBalance() + ".");
            }
        }).start();

        new Thread(new Runnable() {
            public void run() {
                try {
                    transfer( b, a, 300);
                } catch (InsufficientFundException e) {
                    e.printStackTrace();
                }
                ;
                System.out.println("Transfer completed sucessfully. " +
                        "Account 2 Balance: " + b.getBalance());
            }
        }).start();
    }

    static void transfer( Account acc1, Account acc2, int amount ) throws InsufficientFundException{

        if ( acc1.getBalance() < amount ){
            throw  new InsufficientFundException();
        }
        try {
            if ( acc1.getLock().tryLock(WAIT_SEC, TimeUnit.SECONDS) ){
                try {
                    if ( acc2.getLock().tryLock(WAIT_SEC, TimeUnit.SECONDS) ){
                        try {
                            System.out.println("Account 1 locked.");
                            System.out.println("Account 2 locked.");
                            acc1.withdraw(amount);
                            System.out.println("Acc1: " + acc1.getBalance());
                            acc2.deposit(amount);
                            System.out.println("Acc2: " + acc2.getBalance());
                        }
                        finally {
                            acc2.getLock().unlock();
                        }
                    }
                    else {
                        acc2.isFailTransferCount();
                        System.out.println("Error waiting Lock");
                    }
                }
                finally {
                    acc1.getLock().unlock();
                }
            }
            else {
                acc1.isFailTransferCount();
                System.out.println("Error waiting Lock");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
