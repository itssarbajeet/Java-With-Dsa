public class Quick_sort {

    public static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            // Choose a pivot element
            int pivotIndex = partition(array, low, high);
            
            // Recursively sort the two subarrays
            quickSort(array, low, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, high);
        }
    }

    private static int partition(int[] array, int low, int high) {
        // Choose the last element as the pivot
        int pivot = array[high];
        
        // Index of the smaller element
        int i = low - 1;
        
        // Partition the array
        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;
                // Swap array[i] and array[j]
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        
        // Swap array[i+1] and array[high] (pivot)
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        
        // Return the pivot index
        return i + 1;
    }
    
    public static void main(String[] args) {
        int[] array = {10, 7, 8, 9, 1, 5};
        int n = array.length;
        
        quickSort(array, 0, n - 1);
        
        System.out.println("Sorted array:");
        for (int i = 0; i < n; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
