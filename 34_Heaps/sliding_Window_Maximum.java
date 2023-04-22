import java.util.*;

public class sliding_Window_Maximum {
    static class Pair implements Comparable<Pair> {
        int val;
        int index;

        public Pair(int val, int index) {
            this.val = val;
            this.index = index;
        }

        @Override
        public int compareTo(Pair other) {
            return Integer.compare(other.val, this.val);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int k = 3;
        int[] result = findSlidingWindowMaximum(arr, k);
        System.out.println(Arrays.toString(result)); // Output: [3, 4, 5, 6, 7, 8, 9, 10]
    }

    public static int[] findSlidingWindowMaximum(int[] arr, int k) {
        int n = arr.length;
        int[] result = new int[n - k + 1];
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            Pair curr = new Pair(arr[i], i);

            while (!maxHeap.isEmpty() && maxHeap.peek().index <= i - k) {
                maxHeap.poll();
            }

            maxHeap.offer(curr);

            if (i >= k - 1) {
                result[i - k + 1] = maxHeap.peek().val;
            }
        }

        return result;
    }
}
