package leetcode;

/**
 * @author lijintao
 * @title
 * @Package leetcode
 * @date 2021-01-27 10:28
 */

/**
 * 寻找字母矩阵中的路径
 * https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof/
 */
public class DfsFindStrInMatrix {

    public static void main(String[] args) {
        char[][] matrix = {{'a', 'b', 'c'}, {'d', 'e', 'f'}, {'c', 'f', 'r'}};
        String s = "bdf";
        System.out.println(findStrInMatrix(matrix, s));
    }

    private static boolean findStrInMatrix(char[][] matrix, String str) {
        char[] charArray = str.toCharArray();
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[0].length; j++) {
                if (dfs(matrix, i, j, charArray, 0)) {
                    return true;
                }
            }
        return false;
    }

    private static boolean dfs(char[][] matrix, int i, int j, char[] charArray, int k) {
        if (i >= matrix.length || i < 0 || j >= matrix[0].length || j < 0 || matrix[i][j] != charArray[k]) {
            return false;
        }
        if (k == charArray.length - 1) {
            return true;
        }
        matrix[i][j] = '\0';
        boolean res =
                dfs(matrix, i + 1, j, charArray, k + 1) || dfs(matrix, i, j + 1, charArray, k + 1) || dfs(matrix, i - 1, j, charArray, k + 1) || dfs(matrix, i, j - 1,
                        charArray, k + 1);
        matrix[i][j] = charArray[k];
        return res;
    }

}
