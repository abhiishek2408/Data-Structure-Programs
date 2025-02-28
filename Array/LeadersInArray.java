class LeadersInArray{
	
	void printLeadersNaive(int arr[], int size){
        boolean IsLeader = false;
		for (int i = 0; i < size; i++){
		for (int j = i + 1; j < size; j++){
			if (arr[i] <=arr[j]){
                IsLeader = false;
                break;
            }
		}
			if(IsLeader == false){ 
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
		LeadersInArray lead = new LeadersInArray();
		int arr[] = new int[]{16, 17, 4, 3, 5, 2}; //Output: 17, 5, 2
		int n = arr.length;
		lead.printLeadersEfficient(arr, n);
        
		lead.printLeadersNaive(arr, n);
	}
}