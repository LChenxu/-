package com.geekbang.search;

/**
 * @author lichenxu
 * @version V1.0
 * @Package com.geekbang.search
 * @date 2021/1/16 20:17
 * @example:
 * @Description:
 * 二分查找的局限性：
 * 1.必须是基于数组的，基于链表就没有O(logn)的完美时间复杂度了
 * 2.必须是有序数据，最次也是一次排序之后就能有序的数据才行
 * 3.数据量太小不行
 * 4.因为基于数组，所以数据量太大也不行，没有几个G的数组
 */
public class BinarySearch {

    /**
     * 有序不重复数组中，递归实现二分查找
     * @param a
     * @param n
     * @param value
     * @return
     */
    private static int searchRecursion(int[] a, int n, int value) {
        return recursion(a, 0, n - 1, value);
    }

    private static int recursion(int[] a, int low, int high, int value) {
        if (low > high) {
            return -1;
        }
        int mid = ((high - low) >> 1) + low;
        if (a[mid] < value) {
            return recursion(a, mid + 1, high, value);
        } else if (a[mid] > value) {
            return recursion(a, low, mid - 1, value);
        } else {
            return mid;
        }
    }

    /**
     * 有序不重复数据中，用循环方式实现二分查找
     * @param a
     * @param n
     * @param value
     * @return
     */
    private static int search(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        //1、注意是 low<=high，而不是 low<high,否则可能少算一个
        while (low <= high) {
            //2、防止high+low溢出，/2没有>>1效率高
            int mid = ((high - low) >> 1) + low;
            if (a[mid] < value) {
                //3、不要写成low=mid，可能造成死循环
                low = mid + 1;
            } else if (a[mid] > value) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * 二分查找变种1：在有序但是有重复数据的数组中，查找第一个等于value的值（代码简洁，但难理解）
     * @param a
     * @param n
     * @param value
     * @return
     */
    private static int search1(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = ((high - low) >> 1) + low;
            if (a[mid] >= value) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        //low<0,防止a只有一个值而且小于value，此时low=0+1=1，a[low]数据越界了
        if (low < n && a[low] == value) {
            return low;
        } else {
            return -1;
        }
    }
    /**
     * 二分查找变种1：在有序但是有重复数据的数组中，查找第一个等于value的值（这种理解起来简单）
     * @param a
     * @param n
     * @param value
     * @return
     */
    private static int search2(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = ((high - low) >> 1) + low;
            if (a[mid] > value) {
                high = mid - 1;
            } else if (a[mid] < value) {
                low = mid + 1;
            } else {
                // 就是看看a[mid]==value的时候，mid的前一个值是不是和mid重复的，
                // 不重复返回结果，
                // 重复就在low到mid-1中继续查找
                if (mid == 0 || a[mid - 1] != value) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    /**
     * 二分查找变种2：在有序但是有重复数据的数组中，查找最后一个等于value的值
     * @param a
     * @param n
     * @param value
     * @return
     */
    private static int search3(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] > value) {
                high = mid - 1;
            } else if (a[mid] < value) {
                low = mid + 1;
            } else {
                if ((mid == n - 1) || (a[mid + 1] != value)) return mid;
                else low = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 二分查找变种3：在有序但是有重复数据的数组中，查找第一个大于等于value的值
     * 比如，数组中存储的这样一个序列：3，4，6，7，10。如果查找第一个大于等于 5 的元素，那就是 6。
     * @param a
     * @param n
     * @param value
     * @return
     */
    private static int search4(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] >= value) {
                if (mid == 0 || a[mid - 1] < value) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 二分查找变种4：在有序但是有重复数据的数组中，查找最后一个小于等于value的值
     * 比如，数组中存储了这样一组数据：3，5，6，8，9，10。最后一个小于等于 7 的元素就是 6。
     * @param a
     * @param n
     * @param value
     * @return
     */
    private static int search5(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] > value) {
                high = mid - 1;
            } else {
                if (mid == n - 1 || a[mid + 1] > value) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(2>>1+2);
        System.out.println((2>>1)+2);
        System.out.println(2+2>>1);
    }
}
