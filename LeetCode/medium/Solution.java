package medium;

import java.lang.reflect.Array;
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
        System.out.println(countcheckZero);

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
}
