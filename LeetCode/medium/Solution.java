package medium;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.util.*;

public class Solution {

//    Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist.
//    Assume that there is only one duplicate number, find the duplicate one.
//
//            Example 1:
//
//    Input: [1,3,4,2,2]
//    Output: 2
//    Example 2:
//
//    Input: [3,1,3,4,2]
//    Output: 3

    //O(n^2)
    public static int findDuplicate_n2(int[] nums) {
        int len = nums.length;
        int count;
        int result;
        for(int i=0; i<len; i++){
            count = 0;
            result=nums[i];
            for(int j=0; j<len; j++){
                if(result==nums[j]){
                    count++;
                }
                if(count>=2){
                    return result;
                }
            }
        }
        return 0;
    }

    //O(n)
    //    You must not modify the array (assume the array is read only).
    //    You must use only constant, O(1) extra space.
    //    Your runtime complexity should be less than O(n2).
    //    There is only one duplicate number in the array, but it could be repeated more than once.
    public static int findDuplicate_n(int[] nums) {
            Set<Integer> set = new HashSet<Integer>();
            for(int i=0; i<nums.length; i++){
                if(set.contains(nums[i])){
                    return nums[i];
                }
                set.add(nums[i]);
            }
            return 0;
    }


    //##################################################################################################################################################################
//    Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
//
//    Example:
//
//    Input:  [1,2,3,4]
//    Output: [24,12,8,6]
//#################################################################################################################################################################

    //O(n^2)
    public static int[] productExceptSelfn2(int[] nums) {
        int len = nums.length;
        int[] resultArray = new int[len];
        for (int i = 0; i < len; i++) {
            resultArray[i] = 1;
        }
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (i == j) {
                    continue;
                }
                resultArray[i] = resultArray[i] * nums[j];
            }
        }
        return resultArray;
    }


    //O(n)
    public static int[] productExceptSelfn1(int[] nums) {
        int len = nums.length;
        int[] resultArray = new int[len];
        int temp = 1;
        int countcheckZero = 0;
        int specialCase = 2;
        if(len==specialCase){
            for(int i=0, j=1; i<len; i++, j--){
                resultArray[i]=nums[j];
            }
            return resultArray;
        }
        for (int i = 0; i < len; i++) {
            resultArray[i] = 1;
            if(nums[i]==0){
                countcheckZero++;
            }
        }

        for(int i=0; i<len; i++){
            if(nums[i]==0){
                continue;
            }
            temp= temp * nums[i];
        }

        for(int i = 0; i<len; i++){
            resultArray[i]=temp;
        }

        if(countcheckZero==1){
            for(int i=0; i<len; i++){
                if(nums[i]==0){
                    continue;
                }
                resultArray[i]=0;
            }
            return resultArray;
        }
        if(countcheckZero>1){
            for(int i=0; i<len; i++){
                resultArray[i]=0;
            }
            return resultArray;
        }

        for(int i=0; i<len; i++){
            if(nums[i]==0){
                continue;
            }
            resultArray[i]=resultArray[i]/nums[i];
        }

        return resultArray;
    }
//###########################################################################################
//    Given a set of distinct integers, nums, return all possible subsets (the power set).
//
//    Note: The solution set must not contain duplicate subsets.
//
//    Example:
//
//    Input: nums = [1,2,3]
//    Output:
//            [
//            [3],
//            [1],
//            [2],
//            [1,2,3],
//            [1,3],
//            [2,3],
//            [1,2],
//            []
//            ]
//###########################################################################################
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int n = nums.length;
        if ( n == 0 || nums == null) {
            return result;
        }

        for(int i=0; i<n; i++){
            List<List<Integer>> tempResult = new ArrayList<List<Integer>>();

            for (List<Integer> subset : result) {
                tempResult.add(new ArrayList<Integer>(subset));
            }

            for(List<Integer> list : tempResult){
                list.add(nums[i]);
            }

            List<Integer> single = new ArrayList<Integer>();
            single.add(nums[i]);
            tempResult.add(single);

            result.addAll(tempResult);
        }
        result.add(new ArrayList<Integer>());
        return result;
    }

    //###########################################################################################
//    Implement pow(x, n), which calculates x raised to the power n (xn).
//
//    Example 1:
//
//    Input: 2.00000, 10
//    Output: 1024.00000
//    Example 2:
//
//    Input: 2.10000, 3
//    Output: 9.26100
//    Example 3:
//
//    Input: 2.00000, -2
//    Output: 0.25000
//    Explanation: 2-2 = 1/22 = 1/4 = 0.25
    //###########################################################################################
    public static double myPow(double x, int n) {
        double result=1;
        if(n>0) {
            for (int i = 0; i < n; i++) {
                result = result * x;
            }
            return result;
        }
        else if(n<0){
            n=n*(-1);
            x=1/x;
            for(int i=0; i<n; i++){
                result = result * x;
            }
            return result;
        }
        else if(n==1){
            return x;
        }
        return 1;
    }

    //##############################################################################################################################################################
    //    You are given an n x n 2D matrix representing an image.
    //
    //    Rotate the image by 90 degrees (clockwise).
    //
    //    Note:
    //
    //    You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
    //
    //    Example 1:
    //
    //    Given input matrix =
    //            [
    //            [1,2,3],
    //            [4,5,6],
    //            [7,8,9]
    //            ],
    //
    //    rotate the input matrix in-place such that it becomes:
    //            [
    //            [7,4,1],
    //            [8,5,2],
    //            [9,6,3]
    //            ]
    //    Example 2:
    //
    //    Given input matrix =
    //            [
    //            [ 5, 1, 9,11],
    //            [ 2, 4, 8,10],
    //            [13, 3, 6, 7],
    //            [15,14,12,16]
    //            ],
    //
    //    rotate the input matrix in-place such that it becomes:
    //            [
    //            [15,13, 2, 5],
    //            [14, 3, 4, 1],
    //            [12, 6, 8, 9],
    //            [16, 7,10,11]
    //            ]
    //##############################################################################################################################################################
    public static void rotate(int[][] matrix) {//Dokończyć
        int n = matrix.length;
//        int[] tempRow = new int[n];
//        int[] tempColumn = new int[n];
        int temp;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
//                tempRow[j]=matrix[i][j];
//                tempColumn[j]=matrix[j][n-i];
            }
        }
    }
//#############################################################################
//    Given a non-empty array of integers, return the k most frequent elements.
//
//            Example 1:
//
//    Input: nums = [1,1,1,2,2,3], k = 2
//    Output: [1,2]
//    Example 2:
//
//    Input: nums = [1], k = 1
//    Output: [1]
// #############################################################################
    public static List<Integer> topKFrequent(int[] nums, int k) {
        int len = nums.length;
        int count = 0;
        int tempNumber;
        int key;
        List<Integer> result = new ArrayList<Integer>();
        List<Integer> temp = new ArrayList<Integer>();
        List<Integer> sortListValue = new ArrayList<Integer>();
        Map<Integer, Integer> tempHash = new HashMap<>();
        for(Integer i: nums){
            temp.add(i);
        }
        for(int i=0; i<len; i++){
            count = 0;
            tempNumber = temp.get(i);
            for(int j=0; j<len; j++){
                if(tempNumber==temp.get(j)){
                    count++;
                }
            };
            tempHash.put(temp.get(i), count);
        }
        for(Map.Entry<Integer, Integer> entry : tempHash.entrySet()) {
            sortListValue.add(entry.getValue());
        }
        Collections.sort(sortListValue);
        Collections.reverse(sortListValue);

        for(int j=0; j<k; j++) {
            key = (Integer) getKeyFromValue(tempHash, sortListValue.get(j));
            result.add(key);
        }
        return result;
    }

    public static Object getKeyFromValue(Map map, Object value) {
        for (Object o : map.keySet()) {
            if (map.get(o).equals(value)) {
                return o;
            }
        }
        return null;
    }
//#####################################################################################################################################
//    Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
//
//            Symbol       Value
//    I             1
//    V             5
//    X             10
//    L             50
//    C             100
//    D             500
//    M             1000
//    For example, two is written as II in Roman numeral, just two one's added together. Twelve is written as, XII,
//    which is simply X + II. The number twenty seven is written as XXVII, which is XX + V + II.
//
//    Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII.
//    Instead, the number four is written as IV. Because the one is before the five we subtract it making four.
//    The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
//
//    I can be placed before V (5) and X (10) to make 4 and 9.
//    X can be placed before L (50) and C (100) to make 40 and 90.
//    C can be placed before D (500) and M (1000) to make 400 and 900.
//    Given an integer, convert it to a roman numeral. Input is guaranteed to be within the range from 1 to 3999.
//
//    Example 1:
//
//    Input: 3
//    Output: "III"
//    Example 2:
//
//    Input: 4
//    Output: "IV"
//    Example 3:
//
//    Input: 9
//    Output: "IX"
//    Example 4:
//
//    Input: 58
//    Output: "LVIII"
//    Explanation: L = 50, V = 5, III = 3.
//    Example 5:
//
//    Input: 1994
//    Output: "MCMXCIV"
//    Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
//#####################################################################################################################################
    public String intToRoman(int num) {
        int[] Arabicnumbers = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String [] RomanNumbers = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int len = Arabicnumbers.length;
        StringBuilder result = new StringBuilder();

        for(int i = 0; i < len; i++){
            while (num >= Arabicnumbers[i]) {
                num = num - Arabicnumbers[i];
                result.append(RomanNumbers[i]);
            }
        }
        return result.toString();
    }

//############################################################################################################################################
//    Given an input string, reverse the string word by word.
//
//
//
//            Example 1:
//
//    Input: "the sky is blue"
//    Output: "blue is sky the"
//    Example 2:
//
//    Input: "  hello world!  "
//    Output: "world! hello"
//    Explanation: Your reversed string should not contain leading or trailing spaces.
//    Example 3:
//
//    Input: "a good   example"
//    Output: "example good a"
//    Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
//
//
//            Note:
//
//    A word is defined as a sequence of non-space characters.
//    Input string may contain leading or trailing spaces. However, your reversed string should not contain leading or trailing spaces.
//    You need to reduce multiple spaces between two words to a single space in the reversed string.
//############################################################################################################################################

    public static String reverseWords(String s) {
        String oneWord ="";
        String result="";
        char tempChar;
        int ascii;
        int len = s.length();
        List<String> stringList = new ArrayList<>();
        for(int i=0; i<len; i++){
            tempChar = s.charAt(i);
            ascii = (int) tempChar;
            if(ascii != 32){
                oneWord = oneWord + tempChar;
            }
            if(ascii==32 || i==len-1) {
                if(oneWord!=""){
                    stringList.add(oneWord);
                }
                oneWord = "";
            }
        }
        Collections.reverse(stringList);

        for(String word : stringList){
            result = result + word;
            result = result + " ";
        }
        len = result.length();
        if(len>0){
            return result.substring(0, len-1) + result.substring(len-1 + 1);
        }
        else{
            return "";
        }

    }

//################################################################################################
//    Given an unsorted array of integers, find the length of longest increasing subsequence.
//
//    Example:
//
//    Input: [10,9,2,5,3,7,101,18]
//    Output: 4
//    Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
// ################################################################################################

    public static int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        int[] temp = new int[len];
        temp[0] = 1;
        int max = 1;
        for (int i = 1; i < len; i++) {
            int maxvalue = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    maxvalue = Math.max(maxvalue, temp[j]);
                }
            }
            temp[i] = maxvalue + 1;
            max = Math.max(max, temp[i]);
        }
        return max;
    }
}
