package com.geekbang.algorithm._28;

import com.sun.org.apache.bcel.internal.generic.SWAP;
import org.junit.Test;

/**
 * @author lichenxu
 * @version V1.0
 * @Package com.geekbang.algorithm._28
 * @date 2020/11/17 20:33
 * @example:
 * @Description:数组中下标为
 * i 的节点的左子节点，就是下标为 i∗2 的节点，
 * 右子节点就是下标为 i∗2+1 的节点，
 * 父节点就是下标为 i/2​ 的节点。
 */
public class Heap {
    private int[] a;//存储结构
    private int n;//最大容量
    private int count;//当前存储元素个数

    public Heap(int capacity){
        //数组的第0位不存数据，因为要满足堆的特性
        a = new int[capacity+1];
        n =  capacity;
        count = 0;
    }

    public void swap(int[] a, int current, int father){
        int tmp = a[current];
        a[current] = a[father];
        a[father] = tmp;
    }
    // 插入数据到数组最后，从下到上堆化
    public void insert(int data){
        //判断是否堆满
        if (count>=n)return;
        //count+1
        count++;
        //获取数组最后位置+1 的下标，并添加元素
        int i = count;
        a[i] = data;
        //不满足特性会进行堆化，就是和父节点比较大小并替换位置
        while (i/2 > 0 && a[i] > a[i/2]) { //不要忽略极值，i/2=0时说明i等于1到达堆顶了
            swap(a, i, i/2);//交换位置
            i = i/2;//当前位置与父节点去比较
        }
    }

    // 删除堆顶，从上到下堆化
    public void removeHead(){
        if (count==0)return;
        a[1] = a[count];
        count--;
        heapify(a, count, 1);
    }

    private void heapify(int[] a, int count, int current){
        while (true){
            int maxPos = current;
            // 选出当前节点的两个子节点中最大的那个与当前节点元素互换, 注意极值，到了count的话就没有下一个节点了，也就不用再取了
            if (current*2<=count && a[current] < a[current*2])maxPos = current*2;
            if (current*2+1<=count && a[maxPos] < a[current*2+1])maxPos = current*2+1;
            if (maxPos == current)break;
            swap(a, current, maxPos);
            // 当前节点与最大节点互换之后，当前节点元素下移到原来最大节点处，继续往下堆化
            current = maxPos;
        }
    }
}
