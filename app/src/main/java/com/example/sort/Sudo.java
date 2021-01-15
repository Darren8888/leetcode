package com.example.sort;

public class Sudo {
    private final static char EMPTY = '.';
    private boolean isValid(char[][] nums, int row, int col, char value) {
        for (int i=0; i<9; ++i) {
            if (nums[row][i] == value) return false;
            if (nums[i][col] == value) return false;
            if (nums[row/3*3+i/3][col/3*3+i/3] == value) return false; //小九空格
        }

        return true;
    }

    private boolean backTrack(char[][] nums, int row, int col) {
        if (9 == col) {
            return backTrack(nums, row+1, 0);
        }

        if (9 == row) {
            return true;
        }

        for (int i=row; i<9; ++i) {
            for (int j=col; j<9; ++j) {
                if (EMPTY != nums[i][j]) {
                    return backTrack(nums, i, j+1);
                }

                for (char value='1'; value<='9'; ++value) {
                    if (!isValid(nums, i, j, value)) {
                        continue;
                    }

                    nums[i][j] = value;
                    if (backTrack(nums, row, j+1)) {
                        return true;
                    }

                    nums[i][j] = EMPTY;
                }

                return false;
            }
        }

        return false;
    }

    public void sudo(char[][] nums) {
        backTrack(nums, 0, 0);
    }
}
