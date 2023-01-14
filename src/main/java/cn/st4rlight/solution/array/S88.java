package cn.st4rlight.solution.array;

/**
 * <p>本题如果逆向思维，从后面往前面插入最大的，就简单很多，要注意两点</p>
 * <ol>
 *     <li>从后往前，比较时要取最大</li>
 *     <li>第二个条件只要判断n即可</li>
 * </ol>
 *
 * @author st4rlight <st4rlight@163.com>
 * Created on 2023-01-02
 */
public class S88 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int work = m + n;
        while (m > 0 && n > 0) {
            if (nums1[m - 1] >= nums2[n - 1]) {
                nums1[--work] = nums1[m - 1];
                m--;
            } else {
                nums1[--work] = nums2[n - 1];
                n--;
            }
        }

        while (n > 0) {
            nums1[--work] = nums2[n - 1];
            n--;
        }
    }
}
