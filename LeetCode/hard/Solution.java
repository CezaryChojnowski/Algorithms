package hard;

public class Solution {

//####################################################################################################################
//    There are 1000 buckets, one and only one of them is poisonous, while the rest are filled with water.
//    They all look identical. If a pig drinks the poison it will die within 15 minutes. What is the minimum
//    amount of pigs you need to figure out which bucket is poisonous within one hour?
//
//    Answer this question, and write an algorithm for the general case.
//
//
//
//    General case:
//
//    If there are n buckets and a pig drinking poison will die within m minutes, how many pigs (x) you need to
//    figure out the poisonous bucket within p minutes? There is exactly one bucket with poison.
//####################################################################################################################
    public static int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int temp=minutesToTest/minutesToDie+1;
        int count=0;
        int bucketsCount = buckets - 1;
        if (bucketsCount==1){
            return 0;
        }
        for(int i=buckets; i>0; i/=temp){
            count++;
        }
        return count;
    }
}
