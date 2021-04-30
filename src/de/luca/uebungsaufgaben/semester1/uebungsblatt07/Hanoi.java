package de.luca.uebungsaufgaben.semester1.uebungsblatt07;

public class Hanoi {

    public static void main(String[] args) {
        moveTower(7, 1, 2, 3);
    }

    private static void moveTower(int disks, int fromRod, int helpingRod, int toRod) {
        if (disks > 0) {
            moveTower(disks - 1, fromRod, toRod, helpingRod);
            System.out.println("Move disk " + disks + " from rod " + fromRod + " to rod " + toRod + ".");
            moveTower(disks - 1, helpingRod, fromRod, toRod);
        }
    }
}
