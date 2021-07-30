/*
Given an integer array nums, return the length of the longest strictly increasing subsequence.

A subsequence is a sequence that can be derived from an array by deleting some or no elements without changing the order of the remaining elements. For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].

 

Example 1:

Input: nums = [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
Example 2:

Input: nums = [0,1,0,3,2,3]
Output: 4
Example 3:

Input: nums = [7,7,7,7,7,7,7]
Output: 1
 

Constraints:

1 <= nums.length <= 2500
-104 <= nums[i] <= 104


Required time complexity- O(nlogn)
*/


import java.util.*;
class LongestIncreasingSubsequence{
    private int upper_bound(int nums[],int ele){
        
        int l=-1,h=nums.length;
        while(l+1<h){
            int mid=l+(h-l)/2;
            if(nums[mid]>=ele)h=mid;
            else l=mid;
            
        }
        return l+1;
    }
    public int lengthOfLIS(int[] nums) {
        
        int n=nums.length;
        int dp[]=new int[n+1];
        dp[0]=Integer.MIN_VALUE;
        for(int i=1;i<n+1;i++)dp[i]=Integer.MAX_VALUE;
        
        for(int i=0;i<n;i++){
            int index=upper_bound(dp,nums[i]);
            if(dp[index-1]<=nums[i] && nums[i]<=dp[index]){
                dp[index]=nums[i];
            }
        }
        for(int i=n;i>=1;i--){
            if(dp[i]!=Integer.MAX_VALUE)return i;
        }
        return 0;
    }
}