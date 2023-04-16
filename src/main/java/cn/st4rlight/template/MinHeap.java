package cn.st4rlight.template;

import java.util.Arrays;

/**
 * 小堆实现
 *
 * @author st4rlight <st4rlight@163.com>
 * Created on 2023-04-16
 */
public class MinHeap {

    private int[] heap;
    private int size;

    public MinHeap(int capacity) {
        this.heap = new int[capacity + 1];
        Arrays.fill(this.heap, -1);
        this.size = 0;
    }

    public void insert(int num) {
        if (size >= heap.length - 1) {
            throw new UnsupportedOperationException();
        }

        heap[++size] = num;
        shiftUp(size);
    }

    public void shiftUp(int index) {
        while (index > 1) {
            if (heap[index] < heap[index / 2]) {
                swap(index, index / 2);
                index /= 2;
            } else {
                break;
            }
        }
    }

    public void shiftDown(int index) {
        while (index * 2 <= size) {
            int minIndex = -1;
            if (index * 2 + 1 <= size) {
                if (heap[index * 2] <= heap[index * 2 + 1]) {
                    minIndex = index * 2;
                } else {
                    minIndex = index * 2 + 1;
                }
            } else {
                minIndex = index * 2;
            }

            if (heap[index] > heap[minIndex]) {
                swap(index, index * 2);
                index = index * 2;
            } else {
                break;
            }
        }
    }

    public int getTop() {
        if (size <= 0) {
            return -1;
        } else {
            return heap[1];
        }
    }

    public int delTop() {
        if (size <= 0) {
            return -1;
        }

        int top = heap[1];
        heap[1] = heap[size--];
        shiftDown(1);
        return top;
    }


    public void swap(int a, int b) {
        int temp = heap[a];
        heap[a] = heap[b];
        heap[b] = temp;
    }
}
