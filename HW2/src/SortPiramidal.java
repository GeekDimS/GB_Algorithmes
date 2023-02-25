import java.util.Arrays;

/**
 *
 */
public class SortPiramidal {
    public static void main(String[] args) {
        int[] arr = new int[]{14, 5, 8, 13, 7, 9, 2, 4, 7, 3, 18, 6};
        int k;
        boolean tail;   // Признак отсутствия второго потомка в узле предпоследнего ряда пирамиды
        k = arr.length / 2; // Максимальный узел предпоследнего ряда пирамиды
        tail = (arr.length % 2 == 0);
        BalancingTree(arr, k, tail);    // Балансировка пирамиды
        System.out.println(Arrays.toString(arr));
        Sorting(arr);   // Сортировка
        System.out.println(Arrays.toString(arr));
    }

    /**
     * сортировка сбалансированной пирамиды
     * @param arr Сортируемый массив
     */
    private static void Sorting(int[] arr) {    //
        for (int i = 1; i < arr.length ; i++) {
            int swap;
            swap = arr[0];
            arr[0] = arr[arr.length - i];
            arr[arr.length - i] = swap;
            ReBalance(arr, 1, arr.length - i);
        }
    }

    /**
     * Первоначальная балансировка пирамиды
     * @param arr Сортируемый массив
     * @param k Индекс текущего узла
     * @param tail Признак отсутствия второго потомка в узле предпоследнего ряда пирамиды
     */
    private static void BalancingTree(int[] arr, int k, boolean tail) { //
        int res;
        if (k == 0) {
            return;
        }
        int inode = k - 1;    // Для навигации по массиву индекс узла в координатах массива
        int index = k << 1;   // Индекс второго (правого) потомка текущего узла в массиве
        //int swap;
        if (tail) {
            Swap(arr, inode, -1, index - 1);
        } else {
            res = Swap(arr, inode, index, index - 1);
            if (res != -1) {
                ReBalance(arr, res + 1, arr.length);
            }
        }
        BalancingTree(arr, k - 1, false);
    }

    /**
     * Функция установки максимального значения из указанных в указанный узел
     * @param arr Сортируемый массив
     * @param inode Индекс узла в массиве
     * @param indexRight Индекс правого потомка
     * @param indexLeft Индекс левого потомка
     * @return Номер ячейки, из которой помещено это значение, если перемещение состоялось (если значение узла было меньше его потомков)
     */
    private static int Swap(int[] arr, int inode, int indexRight, int indexLeft) { //Swap(inode, indexRight, indexLeft)
        int swap;
        swap = arr[inode];
        if (indexRight == -1) {
            if (swap < arr[indexLeft]) {
                arr[inode] = arr[indexLeft];
                arr[indexLeft] = swap;
                return indexLeft;
            } else {
                return -1;
            }
        } else {
            if (arr[indexLeft] > arr[indexRight]) {
                if (swap < arr[indexLeft]) {
                    arr[inode] = arr[indexLeft];
                    arr[indexLeft] = swap;
                    //ReSort(arr, index, arr.length);
                    return indexLeft;
                }
            } else {
                if (swap < arr[indexRight]) {
                    arr[inode] = arr[indexRight];
                    arr[indexRight] = swap;
                    //ReSort(arr, index + 1, arr.length);
                    return indexRight;
                }
            }
        }
        return -1;
    }

    /**
     * Метод поддержания балансировки пирамиды
     * @param arr Сортируемый массив
     * @param k Порядковый индекс узла в массиве
     * @param size Размер массива
     */
    private static void ReBalance(int[] arr, int k, int size) { //
        int inode;  //
        int index;
        int res;
        inode = k - 1;   // Для навигации по массиву индекс узла в координатах массива
        index = k << 1;   // Индекс второго (правого) потомка текущего узла в массиве
        if (index >= size) {
            if (index - 1 < size) {
                Swap(arr, inode, -1, index - 1);
            }
        } else {
            res = Swap(arr, inode, index, index - 1);
            if (res != -1) {
                ReBalance(arr, res + 1, size);
            }
        }
    }
}
