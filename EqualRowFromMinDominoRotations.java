// TC: O(N)
// SC: O(1)

class Solution {
    public int minDominoRotations(int[] A, int[] B) {

        int majorityA = majorityElement(A);
        int majorityB = majorityElement(B);

        int countA = count(majorityA , A , B , true);
        int countB = count(majorityB , A , B , false);
        if(countA == -1)return countB;
        if(countB == -1)return countA;

        return Math.min(countA , countB);
    }


    private int majorityElement(int [] nums){

        int ans = nums[0];
        int freq = 1;

        for(int i = 0 ; i < nums.length ; i++){
            int candidate = nums[i];
            if(candidate == ans){
                freq++;
            }else if(freq > 0){
                freq--;
            }else{
                ans = candidate;
                freq = 1;
            }
        }
        return ans;
    }


    private int count(int majority , int [] A , int [] B , boolean flag){
        int pairs = 0;
        int count = 0;

        for(int i = 0 ; i < A.length ; i++){

            if(A[i] != majority && B[i] != majority){
                return -1;
            }else if(A[i] == majority && B[i] == majority){
                pairs++;
            }else if(flag && B[i] == majority){
                count++;
            }else if(!flag && A[i] == majority){
                count++;
            }

        }
        return Math.min(count , (A.length - pairs) - count );
    }

}