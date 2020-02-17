package com.mycompany.knapsackdemp;
import java.lang.Math;
import java.util.Random;
public class GenerateKnapSack {
    
    private int maxWeight;// = 5000; 
    private int[] weights;//=  {10,220,330,450,500,660,70,80,90,20};
    private int[] values;//=  {10,220,330,450,500,660,770,80,9,20};  
    private int[] heights; 
    private int maxHeight;
 

    public static void main(String args[]) {
        GenerateKnapSack problem =  new GenerateKnapSack(406);
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

    public GenerateKnapSack(int maxHeight) {
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
        this.maxWeight = ran.nextInt(1000);
        weights = new int[10];
        values = new int[10];
        for(int i = 0; i <10; i++) {
            weights[i] = ran.nextInt(1000);
        }
        for(int i = 0; i <10; i++) {
            values[i] = ran.nextInt(1000);
        }

       
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