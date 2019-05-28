package medium;

public class Solution {
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
}
