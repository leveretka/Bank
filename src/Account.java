/**
 * Created by margarita on 08.09.15.
 */
public class Account {

    private int id;
    private double sum;

    private static int count = 0;

    public Account(double sum) {
        this.id = count++;
        this.sum = sum;
    }

    public boolean withdraw(double s) {
        if (s > sum) {
            return false;
        }
        this.sum -= s;
        return true;
    }

    public void deposit(double s) {
        this.sum += s;
    }

    public int getId() {
        return id;
    }

    public double getSum() {
        return sum;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", sum=" + sum +
                '}';
    }
}
