package easy;

import java.util.*;

//###########################################################################################################################################
//Given an array A of non-negative integers, return an array consisting of all the even elements of A, followed by all the odd elements of A.
//
//        You may return any answer array that satisfies this condition.
//
//
//
//        Example 1:
//
//        Input: [3,1,2,4]
//        Output: [2,4,3,1]
//        The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
//###########################################################################################################################################
public class Solution {
    public static int arrayPairSum(int[] nums) {
        int n2 = nums.length;
        int n = n2 / 2;
        int sum = 0;
        int k;
        for (int i = 0; i < n; i++) {
            k = 1;
            if (n2 == 2) {
                k = 0;
            }
            if (nums[i] <= nums[n - i + k]) {
                sum = sum + nums[i];
            } else {
                sum = sum + nums[n - i + k];
            }
        }
        return sum;
    }

    public static void reverseString(char[] s) {
        int len = s.length;
        char[] output = new char[len];

        for (int i = 0; i < len; i++) {
            output[i] = s[len - i - 1];
        }
        System.out.println(output);
    }
    //#######################################################################################################################################
//        A self-dividing number is a number that is divisible by every digit it contains.
//
//        For example, 128 is a self-dividing number because 128 % 1 == 0, 128 % 2 == 0, and 128 % 8 == 0.
//
//        Also, a self-dividing number is not allowed to contain the digit zero.
//
//        Given a lower and upper number bound, output a list of every possible self dividing number, including the bounds if possible.
//
//Example 1:
//        Input:
//        left = 1, right = 22
//        Output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
//
//        Note:
//        The boundaries of each input argument are 1 <= left <= right <= 10000.
//#######################################################################################################################################

    public static List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new ArrayList();
        String temp;
        int intTemp;
        int count;
        for (int i = left; i <= right; i++) {
            count = 0;
            temp = "" + i;
            ;
            for (int j = 0; j < temp.length(); j++) {
                intTemp = Character.getNumericValue(temp.charAt(j));
                if (intTemp == 0) {
                    continue;
                }
                if (i % intTemp == 0) {
                    count++;
                }
                if (count == temp.length()) {
                    result.add(i);
                }
            }
        }
        return result;
    }

//######################################################################################################################
//    Given a non-empty array of integers, every element appears twice except for one. Find that single one.
//
//    Note:
//
//    Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
//
//    Example 1:
//
//    Input: [2,2,1]
//    Output: 1
//    Example 2:
//
//    Input: [4,1,2,1,2]
//    Output: 4
//######################################################################################################################
    public static int singleNumber(int[] nums) {
        int len = nums.length;
        int count = 0;
        int temp;
        for (int i = 0; i < len; i++) {
            count = 0;
            temp = nums[i];
            for (int j = 0; j < len; j++) {
                if (temp == nums[j]) {
                    count++;
                }
            }
            if (count == 1) {
                return temp;
            }
        }
        return 0;
    }

    //####################################################################################################################################
//Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
//
//    Example:
//
//    Input: [0,1,0,3,12]
//    Output: [1,3,12,0,0]
//    Note:
//
//    You must do this in-place without making a copy of the array.
//    Minimize the total number of operations.
//####################################################################################################################################
    public void moveZeroes(int[] nums) {
        int i = 0;
        int j = 0;

        while (j < nums.length) {
            if (nums[j] != 0) {
                nums[i++] = nums[j];
            }
            j++;
        }

        while (i < nums.length) {
            nums[i++] = 0;
        }
    }
//###########################################################################################################################
//    Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
//
//            Example 1:
//
//    Input: [3,0,1]
//    Output: 2
//    Example 2:
//
//    Input: [9,6,4,2,3,5,7,0,1]
//    Output: 8
//###########################################################################################################################
    public static int missingNumber(int[] nums) {
        int a1=1;
        int n=nums.length;
        int an=nums.length;
        //Suma wyrazów ciągu geometrycznego
        int expectedSum = n*(an + a1)/2;
        int sum = 0;
        for(int i=0; i<n; i++){
            sum=sum+nums[i];
        }
        return expectedSum - sum;
    }

//############################################################################################################################################################
//Write an algorithm to determine if a number is "happy".
//
//    A happy number is a number defined by the following process: Starting with any positive integer,
//    replace the number by the sum of the squares of its digits, and repeat the process until the number equals
//    1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.
//
//            Example:
//
//    Input: 19
//    Output: true
//    Explanation:
//            1^2 + 9^2 = 82
//            8^2 + 2^2 = 68
//            6^2 + 8^2 = 100
//            1^2 + 0^2 + 0^2 = 1
//############################################################################################################################################################
    public static boolean isHappy(int n) {
        boolean result = false;
        String temp = String.valueOf(n);
        int len = temp.length();
        int sum;
        for(int i=0; i<len; i++){
            sum=0;
            int[] tempArray = new int[len];
            tempArray[i]=Integer.valueOf(temp.charAt(i));
            for(int j=0; j<len; j++){
                sum=sum+tempArray[j]^2;
            }
            if(sum==1){
                return true;
            }
            temp = String.valueOf(sum);
        }
    return result;
    }
    //########################################################################################################
//Given an array A of positive lengths, return the largest perimeter of a triangle with non-zero area, formed from 3 of these lengths.
//
//    If it is impossible to form any triangle of non-zero area, return 0.
//
//
//
//    Example 1:
//
//    Input: [2,1,2]
//    Output: 5
//    Example 2:
//
//    Input: [1,2,1]
//    Output: 0
//    Example 3:
//
//    Input: [3,2,3,4]
//    Output: 10
//    Example 4:
//
//    Input: [3,6,2,3]
//    Output: 8
//########################################################################################################
    public static int largestPerimeter(int[] A) {
        int n = A.length;
        Arrays.sort(A);
        for (int k = n - 3; k >= 0; --k)
            if (A[k] + A[k+1] > A[k+2])
                return A[k] + A[k+1] + A[k+2];
        return 0;
    }
//########################################################################################################################
//    Write a program that outputs the string representation of numbers from 1 to n.
//
//    But for multiples of three it should output “Fizz” instead of the number and for the multiples of five output “Buzz”.
//    For numbers which are multiples of both three and five output “FizzBuzz”.
//
//    Example:
//
//    n = 15,
//
//    Return:
//            [
//            "1",
//            "2",
//            "Fizz",
//            "4",
//            "Buzz",
//            "Fizz",
//            "7",
//            "8",
//            "Fizz",
//            "Buzz",
//            "11",
//            "Fizz",
//            "13",
//            "14",
//            "FizzBuzz"
//            ]
//########################################################################################################################
public static List<String> fizzBuzz(int n) {
    List<String> result = new ArrayList<String>();
    for(int i=1; i<=n; i++){
        if(i%5==0 && i%3==0){
            result.add("FizzBuzz");
            continue;
        }
        else if(i%3==0){
            result.add("Fizz");
            continue;
        }
        else if(i%5==0){
            result.add("Buzz");
            continue;
        }
        else{
            result.add(Integer.toString(i));
        }
    }
    return result;
}
//########################################
//    Reverse a singly linked list.
//
//            Example:
//
//    Input: 1->2->3->4->5->NULL
//    Output: 5->4->3->2->1->NULL
//########################################
     public class ListNode {
         int val;
         ListNode next;
         ListNode(int x) {
             val = x;
         }
     }
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode result = head;
        while (head.next != null) {
            ListNode active = head.next;
            head.next = head.next.next;
            active.next = result;
            result = active;
        }
        return result;
    }


    //###################################################################################################################################################################################
//    There is a robot starting at position (0, 0), the origin, on a 2D plane. Given a sequence of its moves, judge if this robot ends up at (0, 0) after it completes its moves.
//
//    The move sequence is represented by a string, and the character moves[i] represents its ith move. Valid moves are R (right), L (left), U (up), and D (down).
//    If the robot returns to the origin after it finishes all of its moves, return true. Otherwise, return false.
//
//    Note: The way that the robot is "facing" is irrelevant. "R" will always make the robot move to the right once, "L" will always make it move left, etc.
//    Also, assume that the magnitude of the robot's movement is the same for each move.
//
//    Example 1:
//
//    Input: "UD"
//    Output: true
//    Explanation: The robot moves up once, and then down once. All moves have the same magnitude, so it ended up at the origin where it started. Therefore, we return true.
//
//
//    Example 2:
//
//    Input: "LL"
//    Output: false
//    Explanation: The robot moves left twice. It ends up two "moves" to the left of the origin. We return false because it is not at the origin at the end of its moves.
//##################################################################################################################################################################################
    public boolean judgeCircle(String moves) {
        int x=0;
        int y=0;
        boolean result;
        for (char movement: moves.toCharArray()) {
            if (movement == 'U') y++;
            else if (movement == 'D') y--;
            else if (movement == 'L') x--;
            else if (movement == 'R') x++;
        }
        if(x == 0 && y == 0){
            return true;
        }
        else{
            return false;
        }
    }

}
