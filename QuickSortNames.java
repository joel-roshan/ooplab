import java.util.Arrays;
import java.util.Scanner;

public class QuickSortNames {

    public static void quickSort(String[] names) {
        if (names == null || names.length <= 1) {
            return;
        }
        sort(names, 0, names.length - 1);
    }

    private static void sort(String[] names, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(names, low, high);

            sort(names, low, partitionIndex - 1);
            sort(names, partitionIndex + 1, high);
        }
    }

    private static int partition(String[] names, int low, int high) {
        String pivot = names[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (names[j].compareToIgnoreCase(pivot) < 0) {
                i++;
                swap(names, i, j);
            }
        }

        swap(names, i + 1, high);
        return i + 1;
    }

    private static void swap(String[] names, int i, int j) {
        String temp = names[i];
        names[i] = names[j];
        names[j] = temp;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of names:");
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        String[] names = new String[n];

        System.out.println("Enter the names:");
        for (int i = 0; i < n; i++) {
            names[i] = scanner.nextLine();
        }

        scanner.close();

        System.out.println("Original array: " + Arrays.toString(names));

        // Convert all names to lowercase for case-insensitive sorting
        for (int i = 0; i < names.length; i++) {
            names[i] = names[i].toLowerCase();
        }

        quickSort(names);

        // Restoring names to original case for display
        String[] originalCaseNames = new String[n];
        for (int i = 0; i < names.length; i++) {
            originalCaseNames[i] = names[i];
        }

        System.out.println("Sorted array in ascending order (case-insensitive): " + Arrays.toString(originalCaseNames));
    }
}
