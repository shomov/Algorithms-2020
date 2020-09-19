package lesson1;

import kotlin.NotImplementedError;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

@SuppressWarnings("unused")
public class JavaTasks {
    /**
     * Сортировка времён
     *
     * Простая
     * (Модифицированная задача с сайта acmp.ru)
     *
     * Во входном файле с именем inputName содержатся моменты времени в формате ЧЧ:ММ:СС AM/PM,
     * каждый на отдельной строке. См. статью википедии "12-часовой формат времени".
     *
     * Пример:
     *
     * 01:15:19 PM
     * 07:26:57 AM
     * 10:00:03 AM
     * 07:56:14 PM
     * 01:15:19 PM
     * 12:40:31 AM
     *
     * Отсортировать моменты времени по возрастанию и вывести их в выходной файл с именем outputName,
     * сохраняя формат ЧЧ:ММ:СС AM/PM. Одинаковые моменты времени выводить друг за другом. Пример:
     *
     * 12:40:31 AM
     * 07:26:57 AM
     * 10:00:03 AM
     * 01:15:19 PM
     * 01:15:19 PM
     * 07:56:14 PM
     *
     * В случае обнаружения неверного формата файла бросить любое исключение.
     */
    static public void sortTimes(String inputName, String outputName) {
        throw new NotImplementedError();
    }

    /**
     * Сортировка адресов
     *
     * Средняя
     *
     * Во входном файле с именем inputName содержатся фамилии и имена жителей города с указанием улицы и номера дома,
     * где они прописаны. Пример:
     *
     * Петров Иван - Железнодорожная 3
     * Сидоров Петр - Садовая 5
     * Иванов Алексей - Железнодорожная 7
     * Сидорова Мария - Садовая 5
     * Иванов Михаил - Железнодорожная 7
     *
     * Людей в городе может быть до миллиона.
     *
     * Вывести записи в выходной файл outputName,
     * упорядоченными по названию улицы (по алфавиту) и номеру дома (по возрастанию).
     * Людей, живущих в одном доме, выводить через запятую по алфавиту (вначале по фамилии, потом по имени). Пример:
     *
     * Железнодорожная 3 - Петров Иван
     * Железнодорожная 7 - Иванов Алексей, Иванов Михаил
     * Садовая 5 - Сидоров Петр, Сидорова Мария
     *
     * В случае обнаружения неверного формата файла бросить любое исключение.
     */
    static public void sortAddresses(String inputName, String outputName) {
        throw new NotImplementedError();
    }

    /**
     * Сортировка температур
     *
     * Средняя
     * (Модифицированная задача с сайта acmp.ru)
     *
     * Во входном файле заданы температуры различных участков абстрактной планеты с точностью до десятых градуса.
     * Температуры могут изменяться в диапазоне от -273.0 до +500.0.
     * Например:
     *
     * 24.7
     * -12.6
     * 121.3
     * -98.4
     * 99.5
     * -12.6
     * 11.0
     *
     * Количество строк в файле может достигать ста миллионов.
     * Вывести строки в выходной файл, отсортировав их по возрастанию температуры.
     * Повторяющиеся строки сохранить. Например:
     *
     * -98.4
     * -12.6
     * -12.6
     * 11.0
     * 24.7
     * 99.5
     * 121.3
     */
    static public void sortTemperatures(String inputName, String outputName) {
        var list = new ArrayList<Integer>();
        try (var fr = new FileReader(inputName)) {
            var reader = new BufferedReader(fr);
            var line = reader.readLine();
            while (line != null) {
                list.add(Integer.parseInt(String.format("%.1f", Float.parseFloat(line) + 273).replace(",", "")));
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        var array = list.stream().mapToInt(i->i).toArray();
        Sorts.mergeSort(array);
        try (var writer = new FileWriter(outputName)) {
            for (var element : array) {
                var a = String.valueOf(element - 2730);
                if (a.matches("-?\\d{2,}"))
                    writer.write(a.substring(0, a.length() - 1) + '.' + a.substring(a.length() - 1) + '\n');
                else if (a.matches("\\d"))
                    writer.write("0." + a.substring(a.length() - 1) + '\n');
                else
                    writer.write("-0." + a.substring(a.length() - 1) + '\n');
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Сортировка последовательности
     *
     * Средняя
     * (Задача взята с сайта acmp.ru)
     *
     * В файле задана последовательность из n целых положительных чисел, каждое в своей строке, например:
     *
     * 1
     * 2
     * 3
     * 2
     * 3
     * 1
     * 2
     *
     * Необходимо найти число, которое встречается в этой последовательности наибольшее количество раз,
     * а если таких чисел несколько, то найти минимальное из них,
     * и после этого переместить все такие числа в конец заданной последовательности.
     * Порядок расположения остальных чисел должен остаться без изменения.
     *
     * 1
     * 3
     * 3
     * 1
     * 2
     * 2
     * 2
     */
    static public void sortSequence(String inputName, String outputName) {
        var list = new ArrayList<Integer>();
        var data  = new Integer[] {Integer.MAX_VALUE, Integer.MIN_VALUE};
        try (var fr = new FileReader(inputName)) {
            var reader = new BufferedReader(fr);
            var line = reader.readLine();
            while (line != null) {
                list.add(Integer.parseInt(line));
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        var array = list.stream().mapToInt(i->i).toArray();
        Sorts.mergeSort(array);
        data[0] = array[0];
        var num = 0;
        var count = 1;
        for (var i = 0; i < array.length - 1; i++){
            if (array[i + 1] == array[i]) {
                num = array[i];
                count++;
            }
            else if (array[i+1] != array[i]) {
                if ((count > data[1]) || (count == data[1] && num < data[0])){
                    data[0] = num;
                    data[1] = count;
                }
                num = array[i+1];
                count = 1;
            }
            if (i+1 == array.length - 1 && array[i + 1] == array[i])
                if ((count > data[1]) || (count == data[1] && num < data[0])) {
                    data[0] = num;
                    data[1] = count;
                }
        }
        try (var writer = new FileWriter(outputName)) {
            for (var element : list)
                if (!element.equals(data[0]))
                    writer.write(element.toString() + '\n');
            for (var i = data[1]; i > 0; i--)
                writer.write(data[0].toString() + '\n');
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Соединить два отсортированных массива в один
     *
     * Простая
     *
     * Задан отсортированный массив first и второй массив second,
     * первые first.size ячеек которого содержат null, а остальные ячейки также отсортированы.
     * Соединить оба массива в массиве second так, чтобы он оказался отсортирован. Пример:
     *
     * first = [4 9 15 20 28]
     * second = [null null null null null 1 3 9 13 18 23]
     *
     * Результат: second = [1 3 4 9 9 13 15 20 23 28]
     */
    static <T extends Comparable<T>> void mergeArrays(T[] first, T[] second) {
        throw new NotImplementedError();
    }
}
