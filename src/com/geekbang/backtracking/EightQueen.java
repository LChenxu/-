package com.geekbang.backtracking;

import javax.swing.text.StyledEditorKit;

/**
 * @author lichenxu
 * @version V1.0
 * @Package com.geekbang.backtracking
 * @date 2021/1/19 20:08
 * @example:
 * @Description:
 */
public class EightQueen {
    private static int[] result = new int[8];

    private final static int MAX_ROW = 8;
    private final static int MAX_COLUMN = 8;

    private static void cal8queens(int row) {
        if (row == MAX_ROW) {
            print(result);
            return;
        }
        for (int column = 0; column < MAX_COLUMN; column++) {
            if (isOk(row, column)) {
                result[row] = column;
                cal8queens(row + 1);
            }
        }
    }

    private static boolean isOk(int row, int column) {
        int left = column - 1, right = column + 1;
        for (int i = row - 1; i >= 0; i--) {
            if (result[i] == column) {
                return false;
            }
            if (left >= 0 && result[i] == left) {
                return false;
            }
            if (right < 8 && result[i] == right) {
                return false;
            }
            left--;
            right++;
        }
        return true;
    }

    private static void print(int[] result) {
        for (int row = 0; row < MAX_ROW; ++row) {
            for (int column = 0; column < MAX_COLUMN; ++column) {
                if (result[row] == column) {
                    System.out.print("Q ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        cal8queens(0);
    }
}
