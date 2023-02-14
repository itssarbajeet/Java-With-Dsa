import java.util.*;
public class lastoccurence {
public static int firstOccurrence(int[] arr, int key, int i) {
if (arr[i] == key) {
return i;
}
if (i == arr.length - 1) {
return -1;
}
    return firstOccurrence(arr, key, i + 1);
}

public static int lastOccurrence(int[] arr, int key, int i) {
    int lastIndex = -1;
    if (arr[i] == key) {
        lastIndex = i;
    }
    if (i == arr.length - 1) {
        return lastIndex;
    }

    int foundIndex = lastOccurrence(arr, key, i + 1);
    return Math.max(lastIndex, foundIndex);
}

public static void main(String[] args) {
    int[] arr = {1, 2, 3, 4, 5, 7, 2, 9, 10};
    int key = 2;
    int i = 0;
    int firstFound = firstOccurrence(arr, key, i);
    if (firstFound == -1) {
        System.out.println("The key is not found");
    } else {
        int lastFound = lastOccurrence(arr, key, firstFound + 1);
        if (lastFound == -1) {
            System.out.println("The last occurrence of the key is at " + firstFound + " index");
        } else {
            System.out.println("The last occurrence of the key is at " + lastFound + " index");
        }
    }
}
}