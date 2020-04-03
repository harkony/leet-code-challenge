package harkony.weekly.week3;

public class MedianOfTwoSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] merged =mergeSort(nums1,nums2);
        int total=merged.length;
        return ((double) merged[total/2]+(double) merged[(total-1)/2])/2;


    }
    public static int[] mergeSort(int[] one, int[] other){
        int total=one.length+other.length;
        int[] merged =new int[total];
        int oneIdx=0;
        int otherIdx=0;
        int mergedIdx=0;
        for(;mergedIdx<total;mergedIdx++){
            if(oneIdx==one.length || otherIdx==other.length)
                break;
            if(one[oneIdx]<=other[otherIdx]){
                merged[mergedIdx]=one[oneIdx++];
            } else{
                merged[mergedIdx]=other[otherIdx++];
            }
        }
        for(;oneIdx<one.length;oneIdx++){
            merged[mergedIdx++]=one[oneIdx];
        }
        for(;otherIdx<other.length;otherIdx++){
            merged[mergedIdx++]=other[otherIdx];
        }
        return merged;
    }

    public static void main(String[] args) {
        int s[]={1,2};
        int s2[]={3,4};
        System.out.println(findMedianSortedArrays(s,s2));
    }
}
