package lesson7;

import kotlin.NotImplementedError;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class JavaDynamicTasks {
    /**
     * Наибольшая общая подпоследовательность.
     * Средняя
     *
     * Дано две строки, например "nematode knowledge" и "empty bottle".
     * Найти их самую длинную общую подпоследовательность -- в примере это "emt ole".
     * Подпоследовательность отличается от подстроки тем, что её символы не обязаны идти подряд
     * (но по-прежнему должны быть расположены в исходной строке в том же порядке).
     * Если общей подпоследовательности нет, вернуть пустую строку.
     * Если есть несколько самых длинных общих подпоследовательностей, вернуть любую из них.
     * При сравнении подстрок, регистр символов *имеет* значение.
     */
    /*
     * время:  O(n * m);
     * память: O(n * m);
     */
    public static String longestCommonSubSequence(String first, String second) {
        if (first.equals("") || second.equals(""))
            return "";
        else if (first.equals(second))
            return first;

        var matrix = new int[first.length() + 1][second.length() + 1];

        for (var i = 1; i < first.length(); i++)
            for (var j = 1; j < second.length(); j++)
                if (first.charAt(i - 1) == second.charAt(j - 1))
                    matrix[i][j] = matrix[i - 1][j - 1] + 1;
                else
                    matrix[i][j] = Math.max(matrix[i - 1][j], matrix[i][j - 1]);

        var substring = new StringBuilder();
        var i = first.length();
        var j = second.length();
        while (i > 0 && j > 0)
            if (first.charAt(i - 1) == second.charAt(j - 1)) {
                substring.insert(0, first.charAt(i - 1));
                i -= 1;
                j -= 1;
            } else if (matrix[i - 1][j] > matrix[i][j - 1])
                i -= 1;
            else
                j -= 1;

        return substring.toString();
    }
    /*
     * время:  O(n * n);
     * память: O(n);
     */
    /**
     * Наибольшая возрастающая подпоследовательность
     * Сложная
     *
     * Дан список целых чисел, например, [2 8 5 9 12 6].
     * Найти в нём самую длинную возрастающую подпоследовательность.
     * Элементы подпоследовательности не обязаны идти подряд,
     * но должны быть расположены в исходном списке в том же порядке.
     * Если самых длинных возрастающих подпоследовательностей несколько (как в примере),
     * то вернуть ту, в которой числа расположены раньше (приоритет имеют первые числа).
     * В примере ответами являются 2, 8, 9, 12 или 2, 5, 9, 12 -- выбираем первую из них.
     */
    /*
     * время:  O(n * n);
     * память: O(n);
     */
    public static List<Integer> longestIncreasingSubSequence(List<Integer> list) {
        var result = new ArrayList<Integer>();
        if (list.isEmpty())
            return result;
        var value = new ArrayList<Integer>();
        var predecessor = new ArrayList<Integer>();
        for (var i = 0; i < list.size(); i++) {
            value.add(i, 1);
            predecessor.add(i, -1);
            for (var j = 0; j < i; j++)
                if (value.get(j) + 1 > value.get(i) && list.get(j) < list.get(i)) {
                    value.add(i, (value.get(j) + 1));
                    predecessor.set(i, j);
                }
        }

        var pos = 0;
        var length = 0;
        for (var i = 0; i < list.size(); i++)
            if (value.get(i) > length) {
                length = value.get(i);
                pos = i;
            }

        while (pos >= 0) {
            result.add(0, list.get(pos));
            pos = predecessor.get(pos);
        }
        return result;

    }

    /**
     * Самый короткий маршрут на прямоугольном поле.
     * Средняя
     *
     * В файле с именем inputName задано прямоугольное поле:
     *
     * 0 2 3 2 4 1
     * 1 5 3 4 6 2
     * 2 6 2 5 1 3
     * 1 4 3 2 6 2
     * 4 2 3 1 5 0
     *
     * Можно совершать шаги длиной в одну клетку вправо, вниз или по диагонали вправо-вниз.
     * В каждой клетке записано некоторое натуральное число или нуль.
     * Необходимо попасть из верхней левой клетки в правую нижнюю.
     * Вес маршрута вычисляется как сумма чисел со всех посещенных клеток.
     * Необходимо найти маршрут с минимальным весом и вернуть этот минимальный вес.
     *
     * Здесь ответ 2 + 3 + 4 + 1 + 2 = 12
     */
    public static int shortestPathOnField(String inputName) {
        throw new NotImplementedError();
    }

    // Задачу "Максимальное независимое множество вершин в графе без циклов"
    // смотрите в уроке 5
}
