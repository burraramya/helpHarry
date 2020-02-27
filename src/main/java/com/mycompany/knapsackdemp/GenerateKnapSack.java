package com.mycompany.knapsackdemp;
import java.lang.Math;
import java.util.Random;
public class GenerateKnapSack {
    
    private int maxWeight;// = 5000; 
    private int[] weights;//=  {10,220,330,450,500,660,70,80,90,20};
    private int[] values;//=  {10,220,330,450,500,660,770,80,9,20};  
    private int[] heights; 
    private int maxHeight;
    private int generatingMode;

    private int[] mode1MaxWeights = {100};
    private int[][] mode1Weights = {{5,17,90,111,23,59,71,43,21,1}};
    private int[][] mode1Values = {{1,15,59,90,20,47,65,35,11,1}};

    private int[] mode2MaxWeights = {100,110,110,100,100,1000,1000,15,47,10};
    private int[][] mode2Weights = {{5,17,90,111,23,59,71,43,21,1},
                                    {10,39,100,113,21,57,71,43,20,1},
                                    {25,11,35,30,69,55,95,35,20,1},
                                    {27,11,20,35,41,13,66,82,29,51},
                                    {3,15,7,21,33,10,59,23,18,93},
                                    {150,310,444,517,624,739,825,225,11,552},
                                    {125,212,333,75,275,451,260,900,359,13},
                                    {14,10,2,3,5,7,1,4,6,13},
                                    {30,21,2,5,19,35,45,15,12,10},
                                    {6,7,2,3,5,1,4,8,9,10}};
    private int[][] mode2Values = {{1,15,59,90,20,47,65,35,11,1},
    {10,34,59,90,20,49,35,42,5,1},
    {25,5,35,30,70,55,99,35,5,1},
    {1,10,18,23,20,12,62,35,26,45},
    {3,14,6,19,30,2,50,18,10,72},
    {125,14,6,19,600,2,680,200,10,72},
    {111,200,287,72,200,350,200,450,212,1},
    {36,5,10,5,15,7,6,18,3,2},
    {18,11,2,2,11,15,20,2,1,2},
    {3,29,10,17,10,3,24,32,17,35}};


    public static void main(String args[]) {
        GenerateKnapSack problem =  new GenerateKnapSack(406,1);
        System.out.println("Max wieght : "+ problem.getMaxWeight());
        System.out.println("Generated Weights");
        for(int weight : problem.getWeights()) {
            System.out.println(weight);
        }

        System.out.println("Generated Values"); 
        for(int value: problem.getValues()) {
            System.out.println(value);
        }
    }

    public GenerateKnapSack(int maxHeight, int generateMode) {
        this.generatingMode = generateMode;
        generate();
        this.maxHeight = maxHeight;

        generateHeights();

    }

    private void generateHeights() {

        System.out.println("Generating Heights");

        float heightWeightRatio = (float)(this.maxWeight) / (float)(this.maxHeight);
        System.out.println("Height Weigh Ratio: "+ heightWeightRatio);
        this.heights = new int[10];
        for(int i = 0 ; i < 10; i++) {
            this.heights[i] = Math.round(weights[i]/heightWeightRatio);
            System.out.println(this.heights[i]);
        }
        


    }

    private void generate() {

     
        Random ran = new Random();
        int index = 0; 
        if(generatingMode == 1 ) {
            index = ran.nextInt(mode1MaxWeights.length);
            weights = mode1Weights[index];
            values = mode1Values[index];
            maxWeight = mode1MaxWeights[index];
        }else {
            index = ran.nextInt(mode2MaxWeights.length);
            weights = mode2Weights[index];
            values = mode2Values[index];
            maxWeight = mode2MaxWeights[index];
        }






        // this.maxWeight = ran.nextInt(1000);
        // weights = new int[10];
        // values = new int[10];
        // for(int i = 0; i <10; i++) {
        //     weights[i] = ran.nextInt(1000);
        // }
        // for(int i = 0; i <10; i++) {
        //     values[i] = ran.nextInt(1000);
        // }

       
    }


    public int getMaxWeight() {
        return this.maxWeight;
    }
    public int[] getWeights() {
        return this.weights;
    }
    public int[] getValues() {
        return this.values;
    }

    public int[] getHeights() {
        return this.heights;
    }
}