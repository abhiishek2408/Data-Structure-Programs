import java.util.Arrays;

public class MeanMedianunsortedArray {
    public double mean(int[] arr){
    int sum = 0;
    for(int num : arr){
        sum += num;
    }
    return (double) sum / arr.length;
}

public double median(int[] arr){
    int n = arr.length;
    int[] copy = arr.clone();
    Arrays.sort(copy);

    if(n % 2 == 1){
        return copy[n / 2];
    } else {
        return (copy[n / 2 - 1] + copy[n / 2]) / 2.0;
    }
}

}