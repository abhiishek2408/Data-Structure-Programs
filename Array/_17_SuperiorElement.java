package Array;

public class _17_SuperiorElement {
	
	void printLeadersNaive(int arr[], int size){
        boolean IsLeader = true;
		for (int i = 0; i < size; i++){
            IsLeader = true;
		for (int j = i + 1; j < size; j++){
			if (arr[i] <=arr[j]){
                 IsLeader = false;
                 break;
            }
		}
			if(IsLeader == true){ 
			System.out.print(arr[i] + " ");
			System.out.println();}
		}
        
	}

    void printLeadersEfficient(int arr[], int size){
        int RightLeader = arr[size-1];

    System.out.print(RightLeader + " ");/* Rightmost element is always leader */

    for(int i = size-2; i >= 0; i--){  // 16, 17, 4, 3, 5, 2 iterate from last 2nd element
        if (RightLeader < arr[i]){		
            RightLeader = arr[i];
        System.out.print(RightLeader + " ");
        }
    }
}

	/* Driver program to test above functions */
	public static void main(String[] args){
        _17_SuperiorElement solution = new _17_SuperiorElement();
		int arr[] = new int[]{16, 17, 4, 3, 5, 2}; //Output: 17, 5, 2
		int n = arr.length;
		solution.printLeadersEfficient(arr, n);
        
		solution.printLeadersNaive(arr, n);
	}
}

