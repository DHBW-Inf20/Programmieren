package semester2.uebungsblatt01;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class SavingsAccount {

    private static final float BALANCE_MAX = 20_000;


    private float balance;
    private final ReentrantLock lock = new ReentrantLock(true);
    private final Condition canWithdraw = lock.newCondition();
    private final Condition canDeposit = lock.newCondition();

    public SavingsAccount() {
        balance = 0;
    }

    @SuppressWarnings("unused")
    public float getBalance() {
        return balance; // no synchronizing needed, only reading value
    }

    public void printBalance() {
        System.out.println("Balance: " + balance);
    }

    public void withdraw(float amount) {
        if (amount < 0 || amount > BALANCE_MAX) throw new IllegalArgumentException();

        lock.lock();
        try {
            while (balance < amount) canWithdraw.await();

            System.out.println("Withdrawing " + amount);
            balance -= amount;
            printBalance();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            canDeposit.signalAll();
            lock.unlock();
        }
    }

    public void deposit(float amount) {
        if (amount < 0 || amount > BALANCE_MAX) throw new IllegalArgumentException();

        lock.lock();
        try {
            float newBalance;
            while ((newBalance = balance + amount) > BALANCE_MAX || newBalance < 0) canDeposit.await();

            System.out.println("Depositing " + amount);
            balance = newBalance;
            printBalance();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            canWithdraw.signalAll();
            lock.unlock();
        }
    }
}
