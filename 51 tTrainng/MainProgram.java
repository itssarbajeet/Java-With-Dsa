import java.util.HashMap;
import java.util.Scanner;

public class MainProgram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Choose a problem (1-5):");
        System.out.println("1. Find the Longest Subarray with Sum K");
        System.out.println("2. Count Pairs with Given Sum");
        System.out.println("3. Find Subarrays with Zero Sum");
        System.out.println("4. Find the Largest Substring Without Repeating Characters");
        System.out.println("5. Check if Array is a Subset of Another");

        int choice = sc.nextInt();

        switch (choice) {
            case 1:
            // 1. Find the Longest Subarray with Sum K
                System.out.println("Enter array size for Q1:");
                int n = sc.nextInt();
                int[] a = new int[n];
                System.out.println("Enter array elements:");
                for (int i = 0; i < n; i++) {
                    a[i] = sc.nextInt();
                }
                System.out.println("Enter K for Q1:");
                int k = sc.nextInt();

                int maxLength = findLongestSubarrayWithSumK(a, k);
                System.out.println("Longest subarray with sum K: " + maxLength);
                break;

            case 2:
            // 2. Count Pairs with Given Sum"
                System.out.println("Enter array size for Q2:");
                int m = sc.nextInt();
                int[] b = new int[m];
                System.out.println("Enter array elements:");
                for (int i = 0; i < m; i++) {
                    b[i] = sc.nextInt();
                }
                System.out.println("Enter target sum for Q2:");
                int target = sc.nextInt();

                int pairCount = countPairsWithSum(b, target);
                System.out.println("Pairs with given sum: " + pairCount);
                break;

            case 3:
            // 3. Find Subarrays with Zero Sum
                System.out.println("Enter array size for Q3:");
                int p = sc.nextInt();
                int[] c = new int[p];
                System.out.println("Enter array elements:");
                for (int i = 0; i < p; i++) {
                    c[i] = sc.nextInt();
                }

                int zeroSumCount = findSubarraysWithZeroSum(c);
                System.out.println("Subarrays with zero sum: " + zeroSumCount);
                break;

            case 4:
            // 4. Find the Largest Substring Without Repeating Characters
                System.out.println("Enter string for Q4:");
                String d = sc.next();

                int longestSubstring = findLongestSubstringWithoutRepeatingCharacters(d);
                System.out.println("Longest substring without repeating: " + longestSubstring);
                break;

            case 5:
            // 5. Check if Array is a Subset of Another
                System.out.println("Enter size of A for Q5:");
                int q = sc.nextInt();
                int[] e = new int[q];
                System.out.println("Enter elements of A:");
                for (int i = 0; i < q; i++) {
                    e[i] = sc.nextInt();
                }

                System.out.println("Enter size of B for Q5:");
                int r = sc.nextInt();
                int[] f = new int[r];
                System.out.println("Enter elements of B:");
                for (int i = 0; i < r; i++) {
                    f[i] = sc.nextInt();
                }

                boolean isSubset = checkIfArrayIsSubset(e, f);
                System.out.println("Is B a subset of A? " + isSubset);
                break;

            default:
                System.out.println("Invalid choice.");
                break;
        }

    }

    public static int findLongestSubarrayWithSumK(int[] a, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0, maxLength = 0;
        
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
            
            if (sum == k) {
                maxLength = i + 1;
            }
            
            if (map.containsKey(sum - k)) {
                maxLength = Math.max(maxLength, i - map.get(sum - k));
            }
            
            map.putIfAbsent(sum, i);
        }
        
        return maxLength;
    }

    public static int countPairsWithSum(int[] b, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;

        for (int num : b) {
            int complement = target - num;
            if (map.containsKey(complement)) {
                count += map.get(complement);
            }
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        return count;
    }

    public static int findSubarraysWithZeroSum(int[] c) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0, count = 0;

        for (int num : c) {
            sum += num;
            
            if (sum == 0) {
                count++;
            }
            
            if (map.containsKey(sum)) {
                count += map.get(sum);
            }
            
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }

    public static int findLongestSubstringWithoutRepeatingCharacters(String d) {
        HashMap<Character, Integer> map = new HashMap<>();
        int start = 0, maxLength = 0;

        for (int end = 0; end < d.length(); end++) {
            char c = d.charAt(end);
            if (map.containsKey(c)) {
                start = Math.max(start, map.get(c) + 1);
            }
            map.put(c, end);
            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;
    }

    public static boolean checkIfArrayIsSubset(int[] e, int[] f) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int num : e) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int num : f) {
            if (!map.containsKey(num)) {
                return false;
            }
            map.put(num, map.get(num) - 1);
            if (map.get(num) == 0) {
                map.remove(num);
            }
        }

        return true;
    }
}
