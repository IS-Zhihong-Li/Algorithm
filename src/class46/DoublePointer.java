package class46;

import java.util.Arrays;

/**
 * @author : lizh
 * @date: 2025/11/7 - 11 - 07 - 17:53
 * @Description: class46
 * @version: 1.0
 */
public class DoublePointer {

    // 按奇偶排序数组
    // https://leetcode.cn/problems/sort-array-by-parity-ii/
    class SortArrayByParityII {
        public int[] sortArrayByParityII(int[] nums) {
            int n = nums.length - 1;
            for (int odd = 1, even = 0; odd < n && even < n; ) {
                if (nums[n] % 2 == 1) {
                    swap(nums, odd, n);
                    odd += 2;
                } else {
                    swap(nums, even, n);
                    even += 2;
                }
            }
            return nums;
        }

        public void swap(int[] nums, int a, int b) {
            int temp = nums[a];
            nums[a] = nums[b];
            nums[b] = temp;
        }
    }


    // 寻找重复数
    // https://leetcode.cn/problems/find-the-duplicate-number/
    class FindDuplicate {
        public int findDuplicate(int[] nums) {
            int fast = 0; // fast和slow记录的是下标啊, 不应该 =nums[0]
            int slow = 0;

            fast = nums[nums[fast]];
            slow = nums[slow];
            while (fast != slow) {
                fast = nums[nums[fast]];
                slow = nums[slow];
            }
            fast = 0;
            while (fast != slow) {
                fast = nums[fast]; // 这里是一步一步走, 别写成跳步了
                slow = nums[slow];
            }
            return slow;
        }
    }


    // 接雨水(困难)
    // https://leetcode.cn/problems/trapping-rain-water/description/
    class Trap {
        // 数组解法
        public int trap(int[] height) {
            int n = height.length;
            int[] lmax = new int[n];
            int[] rmax = new int[n];

            int max = 0;
            for (int i = 0; i < lmax.length; i++) {
                lmax[i] = max;
                max = Math.max(max, height[i]);
            }
            System.out.println(Arrays.toString(lmax));
            max = 0;
            for (int i = rmax.length - 1; i >= 0; i--) {
                rmax[i] = max;
                max = Math.max(max, height[i]);
            }
            System.out.println(Arrays.toString(rmax));
            int ans = 0;
            for (int i = 1; i < height.length - 1; i++) {
                ans += Math.max((Math.min(lmax[i], rmax[i]) - height[i]), 0);
            }
            return ans;
        }

        // 双指针解


    }


    // 救生艇
    // https://leetcode.cn/problems/boats-to-save-people/
    class NumRescueBoats {
        public int numRescueBoats(int[] people, int limit) {
            Arrays.sort(people);
            int n = people.length;
            int ans = 0;
            int l = 0, r = n - 1;
            for (; l < r; r--, ans++) {
                if (people[l] + people[r] <= limit) {
                    l++;
                }
            }
            if (l == r) {
                ans++;
            }
            return ans;
        }
    }

    // 盛水最多的容器
    // 两个指针往中间移动,
    // https://leetcode.cn/problems/container-with-most-water/
    class MaxArea {
        public int maxArea(int[] height) {
            int n = height.length;
            int max = 0;
            int l = 0;
            int r = n - 1;
            while (l < r) {
                if (Math.min(height[l], height[r]) * (r - l) > max) {
                    max = Math.min(height[l], height[r]) * (r - l);
                }
                if (height[l] < height[r])
                    l++;
                else r--;
            }
            return max;
        }
    }

    // 供暖器
    // https://leetcode.cn/problems/heaters/
    class FindRadius {
        public int findRadius(int[] houses, int[] heaters) {
            Arrays.sort(houses);
            Arrays.sort(heaters);
            int houidx = 0,heaidx = 0,minr = 0;
            for (; houidx < houses.length; houidx++) {
                int min = Math.abs(houses[houidx] - heaters[heaidx]);
                // 如果房屋和供暖器之间的距离开始增长, 就换成下一个房屋
                while(heaidx != heaters.length - 1 && Math.abs(houses[houidx] - heaters[heaidx + 1]) <= min){
                    heaidx++;
                    min = Math.abs(houses[houidx] - heaters[heaidx]);
                }
                minr = Math.max(min, minr);
            }
            return minr;
        }
    }

    // 缺失的第一个正数(困难)
    // MEX问题
    // https://leetcode.cn/problems/first-missing-positive/
    class FirstMissingPositive {
        public int firstMissingPositive(int[] nums) {
            int l = 0;
            int r = nums.length;// 一开始是没有垃圾区的, 应该从边界外开始, 扩充垃圾区时先--r再放入
            while(l < r){
                if(nums[l] == l+1){ // 我希望下标0--l之间的的部分被填入1--l+1大小的数值
                    l++;
                }else if(nums[l] > r || nums[l] <= l || nums[nums[l] - 1] == nums[l]){
                    swap(nums, l, --r);
                }else{
                    swap(nums, l, nums[l] - 1);
                }
            }
            return l+1;
        }

        public void swap(int[] nums, int a, int b) {
            int temp = nums[a];
            nums[a] = nums[b];
            nums[b] = temp;
        }
    }


}
