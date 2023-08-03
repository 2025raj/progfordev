//question 3b

import java.util.Arrays;

// Class representing a Priority Queue using Max Heap data structure.
public class MaxHeapPriorityQueue {
    private int[] heap;         // Array to store the elements of the priority queue (max heap)
    private int size;           // Current size of the priority queue
    private int capacity;       // Maximum capacity of the priority queue

    // Constructor to create a MaxHeapPriorityQueue with the given capacity.
    public MaxHeapPriorityQueue(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.heap = new int[capacity];
    }

    // Get the index of the parent node of the element at index 'i'.
    private int getParentIndex(int i) {
        return (i - 1) / 2;
    }

    // Get the index of the left child node of the element at index 'i'.
    private int getLeftChildIndex(int i) {
        return 2 * i + 1;
    }

    // Get the index of the right child node of the element at index 'i'.
    private int getRightChildIndex(int i) {
        return 2 * i + 2;
    }

    // Swap the elements at indices 'i' and 'j' in the heap.
    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    // Move the element at index 'i' up the heap to maintain the max heap property.
    private void siftUp(int i) {
        int parent = getParentIndex(i);
        while (i > 0 && heap[i] > heap[parent]) {
            swap(i, parent);
            i = parent;
            parent = getParentIndex(i);
        }
    }

    // Move the element at index 'i' down the heap to maintain the max heap property.
    private void siftDown(int i) {
        int largest = i;
        int left = getLeftChildIndex(i);
        int right = getRightChildIndex(i);

        if (left < size && heap[left] > heap[largest]) {
            largest = left;
        }

        if (right < size && heap[right] > heap[largest]) {
            largest = right;
        }

        if (largest != i) {
            swap(i, largest);
            siftDown(largest);
        }
    }

    // Insert an element into the priority queue.
    public void insert(int value) {
        if (size == capacity) {
            throw new IllegalStateException("Priority Queue is full.");
        }
        heap[size] = value;
        size++;
        siftUp(size - 1);
    }

    // Extract the maximum element (root) from the priority queue and rearrange the heap.
    public int extractMax() {
        if (size == 0) {
            throw new IllegalStateException("Priority Queue is empty.");
        }
        int max = heap[0];
        heap[0] = heap[size - 1];
        size--;
        siftDown(0);
        return max;
    }

    // Get the maximum element (root) of the priority queue without removing it.
    public int peekMax() {
        if (size == 0) {
            throw new IllegalStateException("Priority Queue is empty.");
        }
        return heap[0];
    }

    // Get the current size of the priority queue.
    public int size() {
        return size;
    }

    // Check if the priority queue is empty.
    public boolean isEmpty() {
        return size == 0;
    }

    // Main method to demonstrate the usage of the MaxHeapPriorityQueue class.
    public static void main(String[] args) {
        MaxHeapPriorityQueue pq = new MaxHeapPriorityQueue(10);
        pq.insert(5);
        pq.insert(3);
        pq.insert(10);
        pq.insert(7);

        System.out.println("Extracted Max: " + pq.extractMax()); // Output: 10
        System.out.println("Peek Max: " + pq.peekMax()); // Output: 7
    }
}
