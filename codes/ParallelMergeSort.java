//question 6

import java.util.Arrays;
public class ParallelMergeSort {
    private static final int MAX_THREADS = Runtime.getRuntime().availableProcessors();

    // Entry point for parallel merge sort.
    public static void parallelMergeSort(int[] arr) {
        parallelMergeSort(arr, 0, arr.length - 1, MAX_THREADS);
    }
    // Recursive function for parallel merge sort.
    private static void parallelMergeSort(int[] arr, int low, int high, int availableThreads) {
        if (low < high) {
            // If there's only one thread available or the array size is small, use sequential merge sort.
            if (availableThreads <= 1) {
                mergeSort(arr, low, high);
            } else {
                int mid = (low + high) / 2;

                // Create threads for the left and right halves of the array.
                Thread leftThread = new Thread(() -> parallelMergeSort(arr, low, mid, availableThreads / 2));
                Thread rightThread = new Thread(() -> parallelMergeSort(arr, mid + 1, high, availableThreads / 2));

                // Start the threads.
                leftThread.start();
                rightThread.start();

                try {
                    // Wait for both threads to finish.
                    leftThread.join();
                    rightThread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // Merge the sorted left and right halves.
                merge(arr, low, mid, high);
            }
        }
    }
    // Sequential merge sort.
    private static void mergeSort(int[] arr, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
    }

    // Merge two sorted subarrays.
    private static void merge(int[] arr, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int left = low;
        int right = mid + 1;
        int k = 0;

        // Merge the elements from the left and right subarrays into the temporary array.
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp[k++] = arr[left++];
            } else {
                temp[k++] = arr[right++];
            }
        }

        // Copy the remaining elements from the left subarray.
        while (left <= mid) {
            temp[k++] = arr[left++];
        }

        // Copy the remaining elements from the right subarray.
        while (right <= high) {
            temp[k++] = arr[right++];
        }
        // Copy the sorted elements back to the original array.
        System.arraycopy(temp, 0, arr, low, temp.length);
    }

    public static void main(String[] args) {
        int[] arr = {9, 3, 7, 1, 5, 8, 2, 6, 4};
        System.out.println("Original Array: " + Arrays.toString(arr));
        // Sort the array using parallel merge sort.
        parallelMergeSort(arr);
        System.out.println("Sorted Array: " + Arrays.toString(arr));
    }
}
