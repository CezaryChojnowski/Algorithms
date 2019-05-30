//Problem Statement
//        A colony of eight houses, represented as cells, are arranged in a straight line.
//        Each day evry cell competes with its adjacent cells (neighbours).
//        An integer value of 1 represents an active cell and value of 0 represents as inactive cell.
//        If both the neighbours are either active or inactive, the cell becomes inactive the next day, otherwise it becomes active on the next day.
//
//        The two cells on the ends have a single adjacent cell, so the other adjacent cell can be assumed to be always inactive.
//        Even after updating the cell state, its previous state is considered for updating the state of other cells.
//        The cell information of all cells should be updated simultatiously.
//
//        Write an algorithm to output the state of the cells after the given number of days.
//
//        Input
//        The input to the function consists of two arguments:
//          states, a list of integers representing the current state of cells.
//          days, an integer representing the number of days.
//
//        Output
//          Return a list of integers representing the state of the cells after the given number of days.
//
//        Note:
//          The elements of the list states contains 0s and 1st only.

public class eigth_house_problem {
    public static int[] cellCompete(int[] states, int days){

        int len = states.length;
        int[] result = new int[len];
        for (int k = 0; k < days; k++) {
            for (int i = 0; i < len; i++) {
                int next;
                int previous;
                int current;
                if (i == 0) {
                    next = states[1];
                    previous = 0;
                } else if (i == len - 1) {
                    previous = states[len - 2];
                    next = 0;
                } else {
                    next = states[i + 1];
                    previous = states[i - 1];
                }
                if (next == previous) {
                    current = 0;
                } else {
                    current = 1;
                }
                result[i] = current;
            }
            for (int i = 0; i < 8; i++) {
                states[i] = result[i];
            }
        }
        return result;
    }
//    public static void main(String[] args) {
//        int[] array = {1,1,1,0,1,1,1,1};
//        int days = 2;
//        array = eigth_house_problem.cellCompete(array, days);
//        for (int i = 0; i < array.length; i++) {
//            System.out.print(array[i]);
//        }
//    }


}

