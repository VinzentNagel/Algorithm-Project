import java.util.ArrayList;

public class Sorter {

    private static void mergeSort(ArrayList<AggregatedRow> aggregatedRows) {
        int length = aggregatedRows.size();
        if (length < 2) {
            return;
        }
        int middleIndex = length / 2;
        ArrayList<AggregatedRow> leftSide = new ArrayList<>(middleIndex);
        ArrayList<AggregatedRow> rightSide = new ArrayList<>(length - middleIndex);
        for (int i = 0; i < length; i++) {
            if (i < middleIndex) {
                leftSide.add(aggregatedRows.get(i));
            } else {
                rightSide.add(aggregatedRows.get(i));
            }
        }
        mergeSort(leftSide);
        mergeSort(rightSide);
        merge(aggregatedRows, leftSide, rightSide);
    }

    private static void merge(ArrayList<AggregatedRow> aggregatedRows, ArrayList<AggregatedRow> leftSide, ArrayList<AggregatedRow> rightSide) {
        int leftIndex = 0;
        int rightIndex = 0;
        for (int i = 0; i < aggregatedRows.size(); i++) {
            if (leftIndex >= leftSide.size()) { // only right side left
                aggregatedRows.set(i, rightSide.get(rightIndex));
                rightIndex = rightIndex + 1;
                continue;
            } else if (rightIndex >= rightSide.size()) { // only left side left
                aggregatedRows.set(i, leftSide.get(leftIndex));
                leftIndex = leftIndex + 1;
                continue;
            } else if (leftSide.get(leftIndex).mining >= rightSide.get(rightIndex).mining) {
                aggregatedRows.set(i, leftSide.get(leftIndex));
                leftIndex = leftIndex + 1;
                continue;
            } else if (leftSide.get(leftIndex).mining < rightSide.get(rightIndex).mining) {
                aggregatedRows.set(i, rightSide.get(rightIndex));
                rightIndex = rightIndex + 1;
                continue;
            }
        }
    }

    public static ArrayList<AggregatedRow> sort(ArrayList<AggregatedRow> aggregatedRows) {
        mergeSort(aggregatedRows);
        return aggregatedRows;
    }
}