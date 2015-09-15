import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by margarita on 09.09.15.
 */
public class Main {

    public static void main(String[] args) {
        final Bank bank = new Bank();
        final Random random = new Random();


        final List<Account> accounts = new ArrayList<Account>();

        for (int i = 0; i < 100; ++i) {
            accounts.add(new Account(1000 + random.nextInt(10000)));
        }

        double sum = 0.0;
        for (Account acc: accounts) {

            sum += acc.getSum();
//            System.out.println(acc);
        }

        System.out.println("Total Bank sum : " + sum);

        for (int i  = 0; i < 10000; ++i) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 10; ++j) {
                        bank.transfer(accounts.get(random.nextInt(100)),accounts.get(random.nextInt(100)), random.nextInt(1000));
                    }

                }
            }).start();
        }

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        sum = 0.0;
        for (Account acc: accounts) {
            sum += acc.getSum();
//            System.out.println(acc);
        }

        System.out.println("Total Bank sum : " + sum);

    }
}
