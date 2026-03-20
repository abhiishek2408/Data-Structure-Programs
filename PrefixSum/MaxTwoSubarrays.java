 

public class MaxTwoSubarrays {

    public int[] rangeAddition(int length, int[][] updates) {

    int[] diff = new int[length];

    for(int[] u : updates){
        int l = u[0];
        int r = u[1];
        int val = u[2];

        diff[l] += val;

        if(r + 1 < length)
            diff[r+1] -= val;
    }

    int[] result = new int[length];

    result[0] = diff[0];

    for(int i = 1; i < length; i++){
        result[i] = result[i-1] + diff[i];
    }

    return result;
}

    public static void main(String[] args) {

        int length = 5;
        int[][] updates = {{1,3,2},{2,4,3},{0,2,-2}};

        MaxTwoSubarrays obj = new MaxTwoSubarrays();

        int[] result = obj.rangeAddition(length, updates);

        for(int num : result)
            System.out.print(num + " ");
    }
}