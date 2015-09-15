/**
 * Created by margarita on 08.09.15.
 */
public class Bank {

    public void transfer(Account from, Account to,  double amount){
        if (from.getId() == to.getId()) {
            return;
        }
        if (from.getId() < to.getId()) {
            synchronized (from) {
                synchronized (to) {
                    if (from.withdraw(amount)) {
                        to.deposit(amount);
                    }
                }
            }
        } else {
            synchronized (to) {
                synchronized (from) {
                    if (from.withdraw(amount)) {
                        to.deposit(amount);
                    }
                }
            }

        }

//        System.out.println("Transferred from account " + from.getId() + " to account " + to.getId() + ": " + amount + " dollars.");
    }

}
