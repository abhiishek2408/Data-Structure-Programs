package Collection.Stack;
class TwoStacks {
    int arr[]; 
    int cap;   
    int top1, top2; 

    
    TwoStacks(int n) {
        cap = n;
        top1 = -1; 
        top2 = n;  
        arr = new int[n]; 
    }

    
    boolean push1(int x) {
        
        if (top1 < top2 - 1) {
            top1++; 
            arr[top1] = x; 
            return true;
        }
        return false; 
    }

    
    boolean push2(int x) {
        
        if (top1 < top2 - 1) {
            top2--; 
            arr[top2] = x; 
            return true;
        }
        return false; 
    }

    
    Integer pop1() {
        if (top1 >= 0) { 
            int x = arr[top1]; 
            top1--; 
            return x;
        }
        return null; 
    }

    
    Integer pop2() {
        if (top2 < cap) { 
            int x = arr[top2]; 
            top2++; 
            return x;
        }
        return null; 
    }

    
    int size1() {
        return top1 + 1; 
    }

    
    int size2() {
        return cap - top2; 
    }

    
    public static void main(String[] args) {
        
        TwoStacks stacks = new TwoStacks(10);

        
        stacks.push1(1);
        stacks.push1(2);
        stacks.push1(3);

        
        stacks.push2(10);
        stacks.push2(9);
        stacks.push2(8);

        
        System.out.println("Size of Stack 1: " + stacks.size1());
        System.out.println("Size of Stack 2: " + stacks.size2());

        
        System.out.println("Popped from Stack 1: " + stacks.pop1());
        System.out.println("Popped from Stack 1: " + stacks.pop1());

        
        System.out.println("Popped from Stack 2: " + stacks.pop2());
        System.out.println("Popped from Stack 2: " + stacks.pop2());

        
        System.out.println("Size of Stack 1 after popping: " + stacks.size1());
        System.out.println("Size of Stack 2 after popping: " + stacks.size2());
    }
}
