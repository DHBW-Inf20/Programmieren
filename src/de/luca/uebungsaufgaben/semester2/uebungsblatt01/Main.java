package de.luca.uebungsaufgaben.semester2.uebungsblatt01;

import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        final var acc = new SavingsAccount();
        acc.printBalance();

        for (Thread thread : startThreads(
                () -> acc.withdraw(100),
                () -> acc.deposit(50),
                () -> acc.deposit(1),
                () -> acc.deposit(1),
                () -> acc.withdraw(10),
                () -> acc.deposit(100),
                () -> acc.withdraw(10)
        )) { thread.join(); }
    }

    private static List<Thread> startThreads(Runnable... actions) {
        final var threads = new LinkedList<Thread>();
        for (Runnable action : actions) {
            var thread = new Thread(action);
            threads.add(thread);
            thread.start();
        }
        return threads;
    }
}
