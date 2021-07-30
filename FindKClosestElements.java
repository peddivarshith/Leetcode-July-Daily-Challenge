/*
Given a sorted integer array arr, two integers k and x, return the k closest integers to x in the array. The result should also be sorted in ascending order.

An integer a is closer to x than an integer b if:

|a - x| < |b - x|, or
|a - x| == |b - x| and a < b
 

Example 1:

Input: arr = [1,2,3,4,5], k = 4, x = 3
Output: [1,2,3,4]
Example 2:

Input: arr = [1,2,3,4,5], k = 4, x = -1
Output: [1,2,3,4]
 

Constraints:

1 <= k <= arr.length
1 <= arr.length <= 104
arr is sorted in ascending order.
-104 <= arr[i], x <= 104

*/

class FindKClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int low=0,high=arr.length-1;
        int index=-1;
        int diff=Integer.MAX_VALUE;
        List<Integer> output=new ArrayList<>();
        while(low<high){
            int mid=low+(high-low)/2;
            if(arr[mid]==x){
                index=mid;break;
            }
            else if(arr[mid]!=x){
                if(Math.abs(arr[mid]-x)<diff){
                    index=mid;diff=Math.abs(arr[mid]-x);
                }
                if(arr[mid]<x){
                    low=mid+1;
                }
                else{
                    high=mid-1;
                }
            }
        }
        int left=index,right=index;
        if(index==-1){
            output.add(arr[0]);
            return output;
        }
        else if(arr[index]<=x){
            while(index<arr.length && arr[index]<=x){
                index++;
            }
            left=index-1;
            right=index;
        }
        else{
              while(index>=0 && arr[index]>=x){
                  index--;
              }
            left=index;
            right=index+1;
            
        }
        while(k!=0){
            int diff1=Integer.MAX_VALUE,diff2=Integer.MAX_VALUE;
            if(left>=0 && left<arr.length){
                diff1=Math.abs(arr[left]-x);
            }
            if(right>=0 && right<arr.length){
                diff2=Math.abs(arr[right]-x);
            }
            if(diff1!=-1 && diff1<=diff2){
                output.add(0,arr[left]);
                left--;k--;
            }
            else if(diff1>diff2){
                output.add(arr[right]);
                right++;k--;
            }
        }
        return output;
        
    }
}
