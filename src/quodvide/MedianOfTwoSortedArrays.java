package quodvide;

public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1,2,4}, new int[]{2,5,7})); // 3
    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] mergedArr = mergeArray(nums1, nums2);
        if (mergedArr.length % 2 == 0) { // return median
            return (double)(mergedArr[mergedArr.length/2] + mergedArr[mergedArr.length/2 - 1]) / 2.0;
        } else {
            return mergedArr[mergedArr.length/2];
        }
    }

    private static int[] mergeArray(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length + arr2.length];
        int indexForArr1 = 0;
        int indexForArr2 = 0;
        for (int i = 0; i < result.length; i++) {
            if(indexForArr1 == arr1.length) { // case of arr1 end
                result[i] = arr2[indexForArr2];
                indexForArr2++;
                continue;
            } else if(indexForArr2 == arr2.length) { // case of arr2 end
                result[i] = arr1[indexForArr1];
                indexForArr1++;
                continue;
            }

            if(arr1[indexForArr1] > arr2[indexForArr2]) { // merge with sort
                result[i] = arr2[indexForArr2];
                indexForArr2++;
            } else {
                result[i] = arr1[indexForArr1];
                indexForArr1++;
            }
        }

        return result;
    }
}
