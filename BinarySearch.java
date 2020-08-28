public class BinarySearch {
    // Returns index of key if it is present in arr
    //, else return -1
    public static int binarySearch(int[] arr, int left, int right, int key){
        if(right >= 1){
            int mid = (left + right)/2;
            if(key == arr[mid]){
                return mid;
            }
            if(key > arr[mid]){
                binarySearch(arr, mid+1, right, key);
            }
            return binarySearch(arr, mid-1, left, key);
        }
        return -1;
    }

    public static void main (String[] args){

        
    }
}
