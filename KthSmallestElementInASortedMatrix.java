/*Given an n x n matrix where each of the rows and columns are sorted in ascending order, return the kth smallest element in the matrix.

Note that it is the kth smallest element in the sorted order, not the kth distinct element.

 

Example 1:

Input: matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8
Output: 13
Explanation: The elements in the matrix are [1,5,9,10,11,12,13,13,15], and the 8th smallest number is 13
Example 2:

Input: matrix = [[-5]], k = 1
Output: -5
 

Constraints:

n == matrix.length
n == matrix[i].length
1 <= n <= 300
-109 <= matrix[i][j] <= 109
All the rows and columns of matrix are guaranteed to be sorted in non-decreasing order.
1 <= k <= n2
*/

class KthSmallestElementInASortedMatrix {
    private int check(int matrix[][],int ele){
        int n=matrix.length;
        int row=0;
        int col=n-1;
        int count=0;
        while(row<n && col>=0){
            if(matrix[row][col]<=ele){
                count+=col+1;
                row++;
            }
            else{
                col--;
            }
        }
        return count;
    }
    public int kthSmallest(int[][] matrix, int k) {
        int n=matrix.length;
        int min=matrix[0][0];
        int max=matrix[n-1][n-1];
        while(min<max){
            int mid=min+(max-min)/2;
            if(check(matrix,mid)<k)
            {
                min=mid+1;
            }
            else{
                max=mid;
            }
        }
        return max;
    }
}