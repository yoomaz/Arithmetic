package q03;

/**
 * 一个二维数组，每一行从左到右递增，每一列从上到下递增．
 * 输入一个二维数组和一个整数，判断数组中是否含有整数
 */
public class Find {

    public boolean find(int[][] array, int number) {
        if (array == null) {
            return false;
        }
        int width = array[0].length;
        int height = array.length;

        int column = width - 1;
        int row = 0;

        while (column >= 0 && row < height) {
            if (array[row][column] == number) {

                return true;
            }
            if (array[row][column] > number) {
                column--;

                continue;
            }
            if (array[row][column] < number) {
                row++;
            }
        }

        return false;
    }
}
