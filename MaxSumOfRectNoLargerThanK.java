/*Given an m x n matrix matrix and an integer k, return the max sum of a rectangle in the matrix such that its sum is no larger than k.

It is guaranteed that there will be a rectangle with a sum no larger than k.

 

Example 1:


Input: matrix = [[1,0,1],[0,-2,3]], k = 2
Output: 2
Explanation: Because the sum of the blue rectangle [[0, 1], [-2, 3]] is 2, and 2 is the max number no larger than k (k = 2).
Example 2:

Input: matrix = [[2,2,-1]], k = 3
Output: 3
*/
class MaxSumOfRectNoLargerThanK {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int n=matrix.length;
        int m=matrix[0].length;
        for(int i=0;i<n;i++){
            for(int j=1;j<m;j++){
               matrix[i][j]+=matrix[i][j-1];
            }
        }
        int result=Integer.MIN_VALUE;
        for(int start=0;start<m;start++){
            for(int end=start;end<m;end++){
                TreeSet<Integer> tree=new TreeSet<>();
                tree.add(0);
                int prefix=0;
                for(int i=0;i<n;i++){
                    prefix+=matrix[i][end];
                    if(start>0)prefix-=matrix[i][start-1];
                    
                    Integer target=tree.ceiling(prefix-k);
                    if(target!=null){
                        result=Math.max(result,prefix-target);
                    }
                    tree.add(prefix);
                }
                
                
            }
        }
        return result;
    }
}