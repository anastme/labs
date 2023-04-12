public class Main {
    // главная процедура
    public static void main(String[] args) {
        // тестовый кейс
        int[] arr = {170, 45, 75, 90, 802, 24, 2, 66};

        // сортировка
        Radix.radixSort(arr);

        // вывод
        System.out.println("Sorted array:");
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}