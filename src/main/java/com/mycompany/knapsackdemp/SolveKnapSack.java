// Java code for Dynamic Programming based 
// solution for 0-1 Knapsack problem 
package com.mycompany.knapsackdemp;

public class SolveKnapSack { 
	
    private int[] solvedWeights = {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};

	static int max(int a, int b) 
	{ 
		return (a > b) ? a : b; 
	} 

	// Prints the items which are put 
	// in a knapsack of capacity W 
	void printknapSack(int W, int wt[], 
							int val[], int n) 
	{ 
		int i, w; 
		int K[][] = new int[n + 1][W + 1]; 

		// Build table K[][] in bottom up manner 
		for (i = 0; i <= n; i++) { 
			for (w = 0; w <= W; w++) { 
				if (i == 0 || w == 0) 
					K[i][w] = 0; 
				else if (wt[i - 1] <= w) 
					K[i][w] = Math.max(val[i - 1] + 
							K[i - 1][w - wt[i - 1]], K[i - 1][w]); 
				else
					K[i][w] = K[i - 1][w]; 
			} 
		} 

		// stores the result of Knapsack 
		int res = K[n][W]; 
		System.out.println(res); 

        w = W; 
        int weightIndex = 0; 
		for (i = n; i > 0 && res > 0; i--) { 

			// either the result comes from the top 
			// (K[i-1][w]) or from (val[i-1] + K[i-1] 
			// [w-wt[i-1]]) as in Knapsack table. If 
			// it comes from the latter one/ it means 
			// the item is included. 
			if (res == K[i - 1][w]) 
				continue; 
			else { 

				// This item is included. 
				System.out.print(wt[i - 1] + " "); 
                solvedWeights[weightIndex] = wt[i - 1];
                weightIndex++;
				// Since this weight is included its 
				// value is deducted 
				res = res - val[i - 1]; 
				w = w - wt[i - 1]; 
			} 
		} 
    } 
    
    public int[] getSolvedWeights() {
        return this.solvedWeights;
    }


    public SolveKnapSack(int maxWeight,int[] weights, int[] values, int numberofValues) {
        printknapSack(maxWeight, weights, values, numberofValues); 

    }
	// Driver code 
	public static void main(String arg[]) 
	{ 
		int val[] = { 60, 100, 120 }; 
		int wt[] = { 10, 20, 30 }; 
		int W = 50; 
		int n = val.length; 
        SolveKnapSack sol = new SolveKnapSack(W, wt, val, n);
        //printknapSack(W, wt, val, n); 
        
        GenerateKnapSack problem =  new GenerateKnapSack(406,1);
        // System.out.println("Max wieght : "+ problem.getMaxWeight());
        // System.out.println("Generated Weights");
        // for(int weight : problem.getWeights()) {
        //     System.out.println(weight);
        // }

        // System.out.println("Generated Values"); 
        // for(int value: problem.getValues()) {
        //     System.out.println(value);
        // }
        System.out.println("--------------------------------------------------------------");
        sol = new SolveKnapSack(problem.getMaxWeight(), problem.getWeights(), problem.getValues(), 10);
        System.out.println("--------------------------------------------------------------");


        for(int va : sol.getSolvedWeights()) {
            System.out.println(va);
        }
	} 
} 

// This code is contributed by Anant Agarwal. 
