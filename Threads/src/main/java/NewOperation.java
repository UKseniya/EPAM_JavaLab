import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class NewOperation {
    public static void main(String[] args) throws InterruptedException {

        final Account acc1 = new Account(1000);
        final Account acc2 = new Account(2000);

        Random random = new Random();

        //ScheduledExecutorService amountMonitoring = createSuccessMonitoringThread(acc1);

        CountDownLatch startLatch = new CountDownLatch(1);

        List<Transfer> transfers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            transfers.add(new Transfer(acc1, acc2, random.nextInt(400), startLatch));
        }

        ExecutorService executorService = Executors.newCachedThreadPool();;
        List<Future<Boolean>> results = executorService.invokeAll(transfers);

        executorService.shutdown();

        startLatch.countDown();

        for (int i=0; i < results.size(); i++) {
            Future<Boolean> future = results.get(i);
            Transfer transfer = transfers.get(i);
            try {
                System.out.println("[" + transfer.getId() + "] Transfer: " + future.get());
            } catch (ExecutionException e) {
                System.out.println("[" + transfer.getId() + "] Transfer: " + e.getMessage());
            }
        }
        //amountMonitoring.shutdown();

    }

    private static ScheduledExecutorService createSuccessMonitoringThread(
            final Account acc1) {
        ScheduledExecutorService amountMonitoring = Executors
                .newScheduledThreadPool(1);
        amountMonitoring.scheduleAtFixedRate(new Runnable() {
            public void run() {
                System.out.println("Failed transfers in Account 1: "
                        + acc1.getFailCounter());
            }
        }, 2, 3, TimeUnit.SECONDS);
        return amountMonitoring;
    }
}
