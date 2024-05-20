package Projekt_Implementierung;

import java.util.ArrayList;
import java.util.Comparator;

public class Sorter {

    public static void mergeSort(ArrayList<AggregatedRow> rows, Comparator<AggregatedRow> comparator) {
        if (rows.size() <= 1) {
            return;
        }
        int middleIndex = rows.size() / 2;
        ArrayList<AggregatedRow> left = new ArrayList<>();
        ArrayList<AggregatedRow> right = new ArrayList<>();
        for (int i = 0; i < middleIndex; i++) {
            left.add(rows.get(i));
        }
        for (int i = middleIndex; i < rows.size(); i++) {
            right.add(rows.get(i));
        }
        mergeSort(left, comparator);
        mergeSort(right, comparator);
        merge(rows, left, right, comparator);
    }

    private static void merge(ArrayList<AggregatedRow> rows, ArrayList<AggregatedRow> left, ArrayList<AggregatedRow> right, Comparator<AggregatedRow> comparator) {
        int leftIndex = 0;
        int rightIndex = 0;
        for (int i = 0; i < rows.size(); i++) {
            if (leftIndex >= left.size()) { // only right side left
                rows.set(i, right.get(rightIndex));
                rightIndex = rightIndex + 1;
                continue;
            } else if (rightIndex >= right.size()) { // only left side left
                rows.set(i, left.get(leftIndex));
                leftIndex = leftIndex + 1;
                continue;
            } else if (comparator.compare(left.get(leftIndex), right.get(rightIndex)) < 0) {
                rows.set(i, left.get(leftIndex));
                leftIndex = leftIndex + 1;
                continue;
            } else {
                rows.set(i, right.get(rightIndex));
                rightIndex = rightIndex + 1;
                continue;
            }
        }
    }
}

class AggregatedRowComparator implements Comparator<AggregatedRow> {
    public int compare(AggregatedRow a, AggregatedRow b) {
        return Integer.compare(b.mining, a.mining);
    }
}