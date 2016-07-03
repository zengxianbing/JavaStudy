package leetcode;

/**
 * Title: <br>
 * <p/>
 * Description: <br>
 * <p/>
 * Created by zengxianbing on 2016/1/11.
 *
 * @author <a href=mailto:zengxianbing163@163.com>曾宪兵</a>
 */
public class Count_of_Range_Sum {
    public static int countRangeSum(int[] nums,int lower,int upper) {

        if(nums.length==0) return 0;
        long[] sum = new long[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {

            sum[i+1]=sum[i]+nums[i];
            System.out.println("sum[i+1]:"+sum[i+1]+"sum[i]:"+sum[i]+"nums[i]:"+nums[i]);
        }

        int ans=0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j <= nums.length; j++) {
                if (lower <= sum[j] - sum[i] && sum[j] - sum[i] <= upper) {
                    ans++;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        countRangeSum(new int[]{-2, 5, -1},-2,2);
    }
}
