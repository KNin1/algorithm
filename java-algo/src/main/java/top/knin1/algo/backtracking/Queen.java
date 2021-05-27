package top.knin1.algo.backtracking;

/**
 * 八皇后问题
 * @author KNin1
 * @date 2021-05-27
 */
public class Queen {
    private static final int COUNT = 8;
    private int[] result = new int[COUNT];

    public void solution() {
        calc8Queens(0);
    }

    private void calc8Queens(int row) {
        if (row == COUNT) {
            print();
            return;
        }
        for (int column = 0; column < COUNT; ++column) {
            if (isOk(row, column)) {
                result[row] = column;
                calc8Queens(row + 1);
            }
        }
    }

    private boolean isOk(int row, int column) {
        int left = column - 1;
        int right = column + 1;
        for (int i = row - 1; i >= 0; --i) {
            if (result[i] == column) {
                return false;
            }
            if (left >= 0 && result[i] == left) {
                return false;
            }
            if (right < 8 && result[i] == right) {
                return false;
            }
            --left;
            ++right;
        }
        return true;
    }

    private void print() {
        for (int row = 0; row < COUNT; ++row) {
            for (int column = 0; column < COUNT; ++column) {
                if (result[row] == column) {
                    System.out.print("Q");
                } else {
                    System.out.print("*");
                }
                if (column != 7) {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
