package com.study.LeetCode701_800;

/**
 * @author jianghui
 * @date 2022-08-22 20:41
 */
public class LeetCode782 {


    public static void main(String[] args) {
        //[[1,0,0],[0,1,1],[1,0,0]]
//        System.out.println(new LeetCode782().movesToChessboard(new int[][]{{0, 1, 1, 0}, {0, 1, 1, 0}, {1, 0, 0, 1}, {1, 0, 0, 1}}));
//        System.out.println(new LeetCode782().movesToChessboard(new int[][]{{0, 1}, {1, 0}}));
        System.out.println(new LeetCode782().movesToChessboard(new int[][]{{1, 0, 0}, {0, 1, 1}, {1, 0, 0}}));
    }

    public int movesToChessboard(int[][] board) {
        if (!check(board)) {
            return -1;
        }
        int[] col = new int[board.length];
        for (int i = 0; i < board.length; i++) {
            col[i] = board[i][0];
        }
        return getSwapCount(board[0]) + getSwapCount(col);
    }

    private int getSwapCount(int[] sentinel) {
        //假设都是10101010...
        int preNum = 1;
        int errorCnt = 0;
        for (int i : sentinel) {
            //统计有多少错位
            if (i != preNum) {
                errorCnt++;
            }
            preNum = preNum == 1 ? 0 : 1;
        }
        //数组是偶数个还是奇数个
        if (sentinel.length % 2 == 0) {
            //偶数个 可以是01010101 或者 10101010
            return Math.min(sentinel.length - errorCnt, errorCnt) / 2;
        } else {
            //奇数个 取决于1多还是0多 1多则是1 0 1 0 1 0 1 0 1 、0多则是0 1 0 1 0 1 0 1 0
            //并且错误的个数一定是偶数个
            if (errorCnt % 2 == 0) {
                return errorCnt / 2;
            } else {
                return (sentinel.length - errorCnt) >> 1;
            }
        }
    }

    /**
     * 检查合法性 分别检查行和列
     *
     * @param board 数组
     * @return
     */
    public boolean check(int[][] board) {
        return checkFirstRow(board) &&
                checkFirstCol(board) &&
                checkRow(board) &&
                checkCol(board);
    }

    public boolean checkFirstRow(int[][] board) {
        int rowOneCnt = 0;
        int rowZeroCnt = 0;
        int[] first = board[0];
        for (int num : first) {
            if (num == 0) {
                rowZeroCnt++;
            } else {
                rowOneCnt++;
            }
        }
        return rowOneCnt == rowZeroCnt || Math.abs(rowOneCnt - rowZeroCnt) == 1;
    }

    public boolean checkFirstCol(int[][] board) {
        int oneCnt = 0, zeroCnt = 0;
        for (int i = 0; i < board.length; i++) {
            if (board[0][i] == 0) {
                zeroCnt++;
            } else {
                oneCnt++;
            }
        }
        return oneCnt == zeroCnt || Math.abs(oneCnt - zeroCnt) == 1;
    }

    public boolean checkRow(int[][] board) {
        //第一行当做哨兵 其他的行要么和第一行相等 要么和第一行相反
        //如：第一行0110 后续的行只能是 0110、1001
        int[] sentinel = board[0];
        int sameCnt = 0, oppositeCnt = 0;
        for (int[] cur : board) {
            //相同
            if (sentinel[0] == cur[0]) {
                for (int i = 0; i < sentinel.length; i++) {
                    if (sentinel[i] != cur[i]) {
                        return false;
                    }
                }
                sameCnt++;
            } else {
                //相反
                for (int i = 0; i < sentinel.length; i++) {
                    if (sentinel[i] + cur[i] != 1) {
                        return false;
                    }
                }
                oppositeCnt++;
            }
        }
        return sameCnt == oppositeCnt || Math.abs(sameCnt - oppositeCnt) == 1;
    }

    public boolean checkCol(int[][] board) {
        //第一列当做哨兵 其他的列要么和第一列相等 要么和第一列相反
        //如：第一列0110 后续的列只能是 0110、1001
        int sameCnt = 0, oppositeCnt = 0;
        int[] sentinel = new int[board.length];
        for (int j = 0; j < board.length; j++) {
            sentinel[j] = board[j][0];
        }
        for (int j = 0; j < board.length; j++) {
            if (board[0][j] == sentinel[0]) {
                for (int i = 0; i < sentinel.length; i++) {
                    if (sentinel[i] != board[i][j]) {
                        return false;
                    }
                }
                sameCnt++;
            } else {
                for (int i = 0; i < sentinel.length; i++) {
                    if (sentinel[i] + board[i][j] != 1) {
                        return false;
                    }
                }
                oppositeCnt++;
            }
        }
        return sameCnt == oppositeCnt || Math.abs(sameCnt - oppositeCnt) == 1;
    }
}
