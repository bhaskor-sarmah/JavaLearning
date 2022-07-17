package com.bhaskor.arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * You can return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 * Example 2:
 *
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 * Example 3:
 *
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 *
 *
 * Constraints:
 *
 * 2 <= nums.length <= 104
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 * Only one valid answer exists.
 *
 * best solution O(n)
 */

public class TwoSum {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);

    System.out.println("Enter the no of elements: ");
    int size = scanner.nextInt();
    int arr[] = new int[size];

    System.out.println("Enter the elements of the array seperated by spaces: ");

    for(int i=0;i<size;i++){
      arr[i] = scanner.nextInt();
    }

    System.out.println("Enter the target sum to find: ");
    int sum = scanner.nextInt();

    int[] result = twoSum(arr, sum);

    System.out.println("["+result[0]+","+result[1]+"]");
  }

  public static int[] twoSum(int[] nums, int target) {

    Map<Integer, Integer> testMap = new HashMap<>();

    int[] result = new int[2];

    /**
     * We check the value first in the Map before
     * adding to map. This handles cases lik [3,3]
     * where sum to find is 6. It should return [0,1]
     * without considering the same index twice
     */
    for(int i=0;i<nums.length;i++){
      int diff = target-nums[i];
      if(testMap.containsKey(diff)){
        result[0] = testMap.get(diff);
        result[1] = i;
        return result;
      }
      testMap.put(nums[i], i);
    }

    return result;
  }
}
