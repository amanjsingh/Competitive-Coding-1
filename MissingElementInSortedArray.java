public class MissingElementInSortedArray {
    public int searchMissingElement(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (mid - 1 >= 0 && arr[mid - 1] != arr[mid] - 1) {
                return arr[mid] - 1;
            }
            if (mid + 1 < arr.length && arr[mid + 1] != arr[mid] + 1) {
                return arr[mid] + 1;
            }
            int leftIndexDiff = mid - low;
            int leftValueDiff = arr[mid] - arr[low];
            if (leftIndexDiff != leftValueDiff) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 3, 4, 5, 6, 7, 8 };
        // int[] arr = { 1, 3 };
        MissingElementInSortedArray obj = new MissingElementInSortedArray();
        System.out.println(obj.searchMissingElement(arr));
    }
}
