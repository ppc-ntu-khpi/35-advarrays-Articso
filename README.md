# Практична робота "Поглиблене використання масивів"

## Завдання 3.  
>Знайти в матриці розміром N x M число, яке повторюється найбільшу кількість разів.

**Код файлу** ```Main.java```**:**  

```java
package domain;
import java.util.Arrays;
/**
 * Клас містить методи для роботи з матрицями.
 */
public class Main {
    /**
     * Метод генерації матриці випадковими цифрами від 0 до 9.
     * @param n число рядків матриці
     * @param m число стовпців матриці
     * @return згенерована матриця
     */
    public static int[][] generateMatrix(int n, int m) {
        int[][] matrix = new int[n][m];
        java.util.Random random = new java.util.Random();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = random.nextInt(10);
            }
        }
        return matrix;
    }
    /**
     * Метод знаходження числа, повторюваного найбільше разів у матриці.
     * @param matrix матриця, в якій шукаємо число
     * @return число, що повторюється найбільше разів
     */
    public static int findMostFrequentNumber(int[][] matrix) {
        int[] flattened = Arrays.stream(matrix) // перетворимо матрицю на одномірний масив
                .flatMapToInt(Arrays::stream)
                .toArray();
        Arrays.sort(flattened); // сортуємо масив
        int currentNumber = flattened[0]; // поточне число
        int currentCount = 1; // кількість повторень поточного числа
        int maxNumber = flattened[0]; // число, що повторюється найбільше разів
        int maxCount = 1; // максимальна кількість повторень числа
        for (int i = 1; i < flattened.length; i++) {
            if (flattened[i] == currentNumber) {
                currentCount++;
            } else {
                if (currentCount > maxCount) { // перевіряємо, чи поточне число найбільш часто повторюється
                    maxCount = currentCount;
                    maxNumber = currentNumber;
                }
                currentNumber = flattened[i];
                currentCount = 1;
            }
        }
        if (currentCount > maxCount) { // перевіряємо останнє число
            maxCount = currentCount;
            maxNumber = currentNumber;
        }
        return maxNumber;
    }
}
```

**Код файлу** ```MainTest.java```**:**  
```java
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
```

***Резльтат виконання програми:***  
![](https://github.com/ppc-ntu-khpi/35-advarrays-Articso/blob/master/result.png)
