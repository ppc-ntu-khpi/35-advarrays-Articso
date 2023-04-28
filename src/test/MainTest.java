package test;
import java.util.Arrays;
import domain.Main;
public class MainTest {
    /**
     * Точка входу до програми. Генерує матрицю випадковими цифрами від 0 до 9 заданого розміру,
     * виводить матрицю в консоль і знаходить число, що повторюється найбільше разів.
     *
     * @param args аргументи командного рядка (не використовуються)
     */
    public static void main(String[] args) {
        int n = 4; // число рядків матриці
        int m = 3; // число стовпців матриці
        int[][] matrix = Main.generateMatrix(n, m);
        System.out.println("Матриця:");
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
        int mostFrequent = Main.findMostFrequentNumber(matrix);
        System.out.println("Число, що повторюється найбільше разів: " + mostFrequent);
    }
}
