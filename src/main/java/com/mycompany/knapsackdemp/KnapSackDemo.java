/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.knapsackdemp;

import java.awt.Color;
import java.awt.Dimension;
import java.io.File;
import java.net.URL;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author i329810
 */
public class KnapSackDemo extends javax.swing.JFrame {

    
    public int currentWeight = 0;
    public int currentValue = 0; 
    public static String imagesFolder = "/Users/i329810/NetBeansProjects1/KnapSackDemp/src/main/java/resources";

    public int solvedcurrentWeight = 0;
    public int solvedcurrentValue = 0; 

    public JPanel weightPanels[]; 
    public JPanel solvedweightPanels[]; 
    public JPanel emptyPanel;
    public JPanel solvedemptyPanel;
    public int[] colorX = {255,255,124,100,65,147,216,218,255,244};
    public int colorY[] = {0,255,252,149,105,112,191,112,105,164};
    public int colorZ[] = {0,0,0,237,225,219,216,214,180,96};

    public Color BEIGE = new Color(245,245,220);
    public Color PURPLE = new Color(128,0,128);
    public Color BROWN = new Color(165,42,42);

    public Color lightGreen = new Color(153,255,153);
    public Color lightBlue = new Color(153,204,255);
    public Color lightPink = new Color(229,255,204);

    public java.awt.Color[] backgrounds = {Color.RED, Color.YELLOW, Color.BLUE,   Color.ORANGE,Color.GREEN,PURPLE,Color.PINK,BROWN,Color.GRAY,BEIGE};
    public java.awt.Color[] foregrounds = {Color.WHITE, Color.BLACK, Color.WHITE, Color.BLACK,Color.BLACK, Color.BLACK , Color.BLACK , Color.WHITE, Color.BLACK, Color.BLACK};

    public int maxWeight = 20;

    public int[] weights;
    public int[] values; 

    public int[] heights;
    public static int instructionCount = 0;
    public int container_width = 500;
    public int container_length = 800;
    public Dimension currentValuesPanelDimension; 
    public Dimension buttonsPanelDimension; 
    public java.awt.Color transparent  = new java.awt.Color(255,255,255,0);
    public Dimension containerDimension = new Dimension(container_width, container_length);
    public Dimension clickButtonDimension = new Dimension(250, 70);
    public Dimension weightedButtonsDimension = new Dimension(600, 500);
    public int emptyPanelLength = container_length;
    public int solvedemptyPanelLength = container_length;
    public Dimension headerDimension = new Dimension(1600,50);
   
    public Dimension actionButtonDimension = new Dimension(200, 50);

    public java.awt.Font buttonFont = new java.awt.Font("Calibri",java.awt.Font.BOLD,16);
    public java.awt.Font textLabelFont = new java.awt.Font("Cambria",java.awt.Font.PLAIN,12);
    public java.awt.Font headerLabelFont = new java.awt.Font("Calibri",java.awt.Font.BOLD,14);
    public java.awt.Font instructionButtonsFont = new java.awt.Font("Apple Chancery",java.awt.Font.PLAIN,19);


    /**
     * Creates new form KnapSackDemo
     */
    public KnapSackDemo() {
        
        currentValuesPanelDimension = new Dimension(400,100);
        buttonsPanelDimension = new Dimension(400,100);


        final GenerateKnapSack problem = new GenerateKnapSack(container_length,1);
        System.out.println("Max wieght : " + problem.getMaxWeight());
        System.out.println("Generated Weights");
        for (final int weight : problem.getWeights()) {
            System.out.println(weight);
        }

        System.out.println("Generated Values");
        for (final int value : problem.getValues()) {
            System.out.println(value);
        }

        this.maxWeight = problem.getMaxWeight();
        this.weights = problem.getWeights();
        this.values = problem.getValues();
        this.heights = problem.getHeights();

        // System.out.println(getClass().getResource("deseimage.png"));
        initComponents();
        baseInitializeBucket();
        baseInitializeSolvedBucket();

    }

    public void setCurrentValuesText() {
        this.maxWeightLabel.setText("Maximum Volume: " + this.maxWeight);
        this.currentWeightLabel.setText("Current Volume: " + this.currentWeight);
        this.currentValueLabel.setText("Current Value: " + this.currentValue);

        // currentValueLabel.setOpaque(false);
        // maxWeightLabel.setOpaque(false);
        // currentWeightLabel.setOpaque(false);
        currentValueLabel.setBackground(transparent);
        maxWeightLabel.setBackground(transparent);
        currentWeightLabel.setBackground(transparent);
   
        currentValueLabel.setFont(textLabelFont);
        currentWeightLabel.setFont(textLabelFont);
        maxWeightLabel.setFont(textLabelFont);
        

    }
    
    public void setSolvedCurrentValuesText() {
        this.solvedmaxWeightLabel.setText("Maximum Volume: " + this.maxWeight);
        this.solvedcurrentWeightLabel.setText("Current Volume: " + this.solvedcurrentWeight);
        this.solvedcurrentValueLabel.setText("Current Value: " + this.solvedcurrentValue);

        // currentValueLabel.setOpaque(false);
        // maxWeightLabel.setOpaque(false);
        // currentWeightLabel.setOpaque(false);
        solvedcurrentValueLabel.setBackground(transparent);
        solvedmaxWeightLabel.setBackground(transparent);
        solvedcurrentWeightLabel.setBackground(transparent);
        
        solvedcurrentValueLabel.setFont(textLabelFont);
        solvedcurrentWeightLabel.setFont(textLabelFont);
        solvedmaxWeightLabel.setFont(textLabelFont);

    }
    public void generateProblem(final int format) {
        final GenerateKnapSack problem = new GenerateKnapSack(container_length,format);
        System.out.println("Max wieght : " + problem.getMaxWeight());
        System.out.println("Generated Weights");
        for (final int weight : problem.getWeights()) {
            System.out.println(weight);
        }

        System.out.println("Generated Values");
        for (final int value : problem.getValues()) {
            System.out.println(value);
        }

        this.maxWeight = problem.getMaxWeight();
        this.weights = problem.getWeights();
        this.values = problem.getValues();
        this.heights = problem.getHeights();
        baseInitializeBucket();
        setButtonLabels();
        setCurrentValuesText(); 
        setSolvedCurrentValuesText();

    }

    public void cleanup() {
        emptyPanelLength = container_length;
        this.currentValue = 0;
        this.currentWeight = 0;
        closeAllWeightPanels();
        setCurrentValuesText();
    }

    public void solutioncleanup() {
        solvedemptyPanelLength = container_length;
        this.solvedcurrentValue = 0;
        this.solvedcurrentWeight = 0;
        closeAllSolvedWeightPanels();
        setSolvedCurrentValuesText();
    }

    // public void newProblem() {
    // cleanup();
    // generateProblem();

    // }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        setContentPane(new JLabel(new ImageIcon(imagesFolder+"/background.jpg")));
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        weightButton1 = new javax.swing.JButton();
        weightButton2 = new javax.swing.JButton();
        weightButton3 = new javax.swing.JButton();
        weightButton4 = new javax.swing.JButton();
        weightButton5 = new javax.swing.JButton();
        weightButton6 = new javax.swing.JButton();
        weightButton7 = new javax.swing.JButton();
        weightButton8 = new javax.swing.JButton();
        weightButton9 = new javax.swing.JButton();
        weightButton10 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        newProblemButton = new javax.swing.JButton();
        newProblemButton2 = new javax.swing.JButton();
        solveButton = new javax.swing.JButton();
        currentWeightLabel = new javax.swing.JLabel();
        currentValueLabel = new javax.swing.JLabel();
        maxWeightLabel = new javax.swing.JLabel();

        solvedcurrentWeightLabel = new javax.swing.JLabel();
        solvedcurrentValueLabel = new javax.swing.JLabel();
        solvedmaxWeightLabel = new javax.swing.JLabel();

        jPanel6 = new javax.swing.JPanel();
        solution = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new JLabel(new ImageIcon("/Users/i329810/NetBeansProjects1/KnapSackDemp/src/main/java/resources/deseimage.png"));
        jLabel2 = new JLabel(new ImageIcon("/Users/i329810/NetBeansProjects1/KnapSackDemp/src/main/java/resources/iisclogo.png"));
        jLabel3 = new javax.swing.JLabel();



        initPanels();
        initSolvedPanels();

        solveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(final java.awt.event.ActionEvent evt) {
                disableAllButtons();
                //cleanup();
                solutioncleanup();
                solveKnapSack();
            }
          
        });

        newProblemButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(final java.awt.event.ActionEvent evt) {
                cleanup();
                solutioncleanup();
                generateProblem(1);
                enableAllButtons();
            }
        });
        
        newProblemButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(final java.awt.event.ActionEvent evt) {
                cleanup();
                solutioncleanup();
                generateProblem(2);
                enableAllButtons();
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setButtonLabels();
        setButtonSizes();
        weightButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(final java.awt.event.ActionEvent evt) {
                weightButtonActionPerformed(0);
            }
        });
        weightButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(final java.awt.event.ActionEvent evt) {
                weightButtonActionPerformed(1);
            }
        });
        weightButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(final java.awt.event.ActionEvent evt) {
                weightButtonActionPerformed(2);
            }
        });
        weightButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(final java.awt.event.ActionEvent evt) {
                weightButtonActionPerformed(3);
            }
        });
        weightButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(final java.awt.event.ActionEvent evt) {
                weightButtonActionPerformed(4);
            }
        });
        weightButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(final java.awt.event.ActionEvent evt) {
                weightButtonActionPerformed(5);
            }
        });
        weightButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(final java.awt.event.ActionEvent evt) {
                weightButtonActionPerformed(6);
            }
        });
        weightButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(final java.awt.event.ActionEvent evt) {
                weightButtonActionPerformed(7);
            }
        });
        weightButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(final java.awt.event.ActionEvent evt) {
                weightButtonActionPerformed(8);
            }
        });
        weightButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(final java.awt.event.ActionEvent evt) {
                weightButtonActionPerformed(9);
            }
        });



        weightButton1.setSize(clickButtonDimension);
        weightButton1.setMaximumSize(clickButtonDimension);
        weightButton1.setPreferredSize(clickButtonDimension);

        weightButton2.setSize(clickButtonDimension);
        weightButton2.setMaximumSize(clickButtonDimension);
        weightButton2.setPreferredSize(clickButtonDimension);

        weightButton3.setSize(clickButtonDimension);
        weightButton3.setMaximumSize(clickButtonDimension);
        weightButton3.setPreferredSize(clickButtonDimension);

        weightButton4.setSize(clickButtonDimension);
        weightButton4.setMaximumSize(clickButtonDimension);
        weightButton4.setPreferredSize(clickButtonDimension);

        weightButton5.setSize(clickButtonDimension);
        weightButton5.setMaximumSize(clickButtonDimension);
        weightButton5.setPreferredSize(clickButtonDimension);

        weightButton6.setSize(clickButtonDimension);
        weightButton6.setMaximumSize(clickButtonDimension);
        weightButton6.setPreferredSize(clickButtonDimension);

        weightButton7.setSize(clickButtonDimension);
        weightButton7.setMaximumSize(clickButtonDimension);
        weightButton7.setPreferredSize(clickButtonDimension);

        weightButton8.setSize(clickButtonDimension);
        weightButton8.setMaximumSize(clickButtonDimension);
        weightButton8.setPreferredSize(clickButtonDimension);


        weightButton9.setSize(clickButtonDimension);
        weightButton9.setMaximumSize(clickButtonDimension);
        weightButton9.setPreferredSize(clickButtonDimension);

        weightButton10.setSize(clickButtonDimension);
        weightButton10.setMaximumSize(clickButtonDimension);
        weightButton10.setPreferredSize(clickButtonDimension);

        //final javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(new java.awt.FlowLayout());
        jPanel4.add(weightButton1);
        jPanel4.add(weightButton2);
        jPanel4.add(weightButton3);
        jPanel4.add(weightButton4);
        jPanel4.add(weightButton5);
        jPanel4.add(weightButton6);
        jPanel4.add(weightButton7);
        jPanel4.add(weightButton8);
        jPanel4.add(weightButton9);
        jPanel4.add(weightButton10);

        jPanel4.setMaximumSize(weightedButtonsDimension);
        jPanel4.setMinimumSize(weightedButtonsDimension);

        weightButton1.setFont(buttonFont);
        weightButton2.setFont(buttonFont);
        weightButton3.setFont(buttonFont);
        weightButton4.setFont(buttonFont);
        weightButton5.setFont(buttonFont);
        weightButton6.setFont(buttonFont);
        weightButton7.setFont(buttonFont);
        weightButton8.setFont(buttonFont);
        weightButton9.setFont(buttonFont);
        weightButton10.setFont(buttonFont);




        // jPanel4Layout.setHorizontalGroup(
        //     jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        //     .addGroup(jPanel4Layout.createSequentialGroup()
        //         .addGap(16, 16, 16)
        //         .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
        //             .addComponent(weightButton1)
        //             .addComponent(weightButton2)
        //             .addComponent(weightButton3)
        //             .addComponent(weightButton4)
        //             .addComponent(weightButton5))
        //         .addGap(79, 79, 79)
        //         .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        //             .addComponent(weightButton6)
        //             .addComponent(weightButton10)
        //             .addComponent(weightButton9)
        //             .addComponent(weightButton8)
        //             .addComponent(weightButton7))
        //         .addContainerGap(49, Short.MAX_VALUE))
        // );

        // //jPanel4Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {weightButton1, weightButton10, weightButton2, weightButton3, weightButton4, weightButton5, weightButton6, weightButton7, weightButton8, weightButton9});

        // jPanel4Layout.setVerticalGroup(
        //     jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        //     .addGroup(jPanel4Layout.createSequentialGroup()
        //         .addGap(14, 14, 14)
        //         .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
        //             .addComponent(weightButton1)
        //             .addComponent(weightButton6))
        //         .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        //         .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
        //             .addComponent(weightButton2)
        //             .addComponent(weightButton7))
        //         .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        //         .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
        //             .addComponent(weightButton3)
        //             .addComponent(weightButton8))
        //         .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        //         .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
        //             .addComponent(weightButton4)
        //             .addComponent(weightButton9))
        //         .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        //         .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
        //             .addComponent(weightButton5)
        //             .addComponent(weightButton10))
        //         .addContainerGap(65, Short.MAX_VALUE))
        // );

        newProblemButton.setText("New Level 1 Problem");
        newProblemButton2.setText("New Level 2 Problem");
        solveButton.setText("Solve");


        // solveButton.setOpaque(false);
        // newProblemButton.setOpaque(false);
        // newProblemButton2.setOpaque(false);
        // jLabel1.setOpaque(false);
        // jLabel2.setOpaque(false);
        // jLabel3.setOpaque(false);


        // currentValueLabel.setOpaque(false);
        // maxWeightLabel.setOpaque(false);
        // currentWeightLabel.setOpaque(false);
        currentValueLabel.setBackground(transparent);
        maxWeightLabel.setBackground(transparent);
        currentWeightLabel.setBackground(transparent);

        setCurrentValuesText();   
        setSolvedCurrentValuesText();      
        // maxWeightLabel.setText("Maximum Weight: ");
        // currentWeightLabel.setText("Current Weight: ");

        // currentValueLabel.setText("Current Value:");

        final javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);

        jPanel2.setLayout(new BoxLayout(jPanel2, BoxLayout.X_AXIS));
        final javax.swing.JPanel labelsPanel = new javax.swing.JPanel();
        labelsPanel.setLayout(new BoxLayout(labelsPanel,BoxLayout.Y_AXIS));
        JLabel yourSolutionHeader = new JLabel("Your Solution");
        yourSolutionHeader.setFont(headerLabelFont);
        labelsPanel.add(yourSolutionHeader);
        labelsPanel.add(maxWeightLabel);
        labelsPanel.add(currentWeightLabel);
        labelsPanel.setMinimumSize(currentValuesPanelDimension);
        labelsPanel.setMaximumSize(currentValuesPanelDimension);
        labelsPanel.add(currentValueLabel);
        labelsPanel.setBackground(transparent);
        labelsPanel.setOpaque(false);
        labelsPanel.setBorder(new EmptyBorder(10,10,10,10));
        
        final javax.swing.JPanel solvedlabelsPanel = new javax.swing.JPanel();
        
        solvedlabelsPanel.setLayout(new BoxLayout(solvedlabelsPanel,BoxLayout.Y_AXIS));
        JLabel computerSolutionHeader = new JLabel("Computer's Solution");
        computerSolutionHeader.setFont(headerLabelFont);
        solvedlabelsPanel.add(computerSolutionHeader);
        //solvedlabelsPanel.add(new JLabel("Computer Solution"));
        solvedlabelsPanel.add(solvedmaxWeightLabel);
        solvedlabelsPanel.add(solvedcurrentWeightLabel);
        solvedlabelsPanel.setMinimumSize(currentValuesPanelDimension);
        solvedlabelsPanel.setMaximumSize(currentValuesPanelDimension);
        solvedlabelsPanel.add(solvedcurrentValueLabel);
        solvedlabelsPanel.setBackground(transparent);
        solvedlabelsPanel.setOpaque(false);
        solvedlabelsPanel.setBorder(new EmptyBorder(10,50,100,10));

        final javax.swing.JPanel buttonsPanel = new javax.swing.JPanel();
        buttonsPanel.setLayout(new BoxLayout(buttonsPanel,BoxLayout.X_AXIS));
        JButton instruuctionsButton = new JButton();
        instruuctionsButton.setText("Instructions");


        instruuctionsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(final java.awt.event.ActionEvent evt) {
                showInstructionsFrame();
            }

        });

        instruuctionsButton.setBackground(lightPink);
        newProblemButton.setBackground(lightBlue);
        newProblemButton2.setBackground(lightBlue);
        solveButton.setBackground(lightGreen);

        instruuctionsButton.setFont(instructionButtonsFont);
        newProblemButton.setFont(instructionButtonsFont);
        newProblemButton2.setFont(instructionButtonsFont);
        solveButton.setFont(instructionButtonsFont);

        buttonsPanel.add(instruuctionsButton);
        buttonsPanel.add(newProblemButton);
        buttonsPanel.add(newProblemButton2);
        //buttonsPanel.setMaximumSize(buttonsPanelDimension);
        //buttonsPanel.setMinimumSize(buttonsPanelDimension);
        buttonsPanel.add(solveButton);


        newProblemButton.setMaximumSize(actionButtonDimension);
        newProblemButton2.setMaximumSize(actionButtonDimension);
        solveButton.setMaximumSize(actionButtonDimension);
        instruuctionsButton.setMaximumSize(actionButtonDimension);


        newProblemButton.setPreferredSize(actionButtonDimension);
        newProblemButton2.setPreferredSize(actionButtonDimension);
        solveButton.setPreferredSize(actionButtonDimension);
        instruuctionsButton.setPreferredSize(actionButtonDimension);


        buttonsPanel.setBackground(transparent);
        buttonsPanel.setOpaque(false);
        jPanel2.add(labelsPanel);
        jPanel2.add(buttonsPanel);
        jPanel2.add(solvedlabelsPanel);
        jPanel2.setBackground(transparent);
        jPanel2.setOpaque(false);


        // jPanel2.setLayout(jPanel2Layout);
        // jPanel2Layout.setHorizontalGroup(
        //     jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        //     .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
        //         .addGap(25, 25, 25)
        //         .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        //             .addComponent(maxWeightLabel)
        //             .addComponent(currentWeightLabel)
        //             .addComponent(currentValueLabel))
        //         .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 273, Short.MAX_VALUE)
        //         .addComponent(newProblemButton)
        //         .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        //         .addComponent(newProblemButton2)
        //         .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        //         .addComponent(solveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
        //         .addContainerGap())
        // );
        // jPanel2Layout.setVerticalGroup(
        //     jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        //     .addGroup(jPanel2Layout.createSequentialGroup()
        //         .addContainerGap()
        //         .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        //             .addGroup(jPanel2Layout.createSequentialGroup()
        //                 .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
        //                     .addComponent(newProblemButton)
        //                     .addComponent(newProblemButton2)
        //                     .addComponent(solveButton))
        //                 .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        //             .addGroup(jPanel2Layout.createSequentialGroup()
        //                 .addComponent(maxWeightLabel)
        //                 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        //                 .addComponent(currentWeightLabel)
        //                 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        //                 .addComponent(currentValueLabel))))
        // );

        jPanel6.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 3, 3, 3, new java.awt.Color(0, 0, 0)));
        jPanel6.setAlignmentX(0.0F);
        jPanel6.setPreferredSize(new java.awt.Dimension(130, 406));
        jPanel6.setMaximumSize(containerDimension);
        jPanel6.setMinimumSize(containerDimension);
        //jPanel6.setPreferredSize(new java.awt.Dimension(120,406));
        jPanel6.setOpaque(false);
        jPanel6.setLayout(new javax.swing.BoxLayout(jPanel6, javax.swing.BoxLayout.Y_AXIS));


        solution.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 3, 3, 3, new java.awt.Color(0, 0, 0)));
        solution.setAlignmentX(0.0F);
        solution.setPreferredSize(new java.awt.Dimension(130, 406));
        solution.setMaximumSize(containerDimension);
        solution.setMinimumSize(containerDimension);

        //jPanel6.setPreferredSize(new java.awt.Dimension(120,406));
        solution.setOpaque(false);
        solution.setLayout(new javax.swing.BoxLayout(solution, javax.swing.BoxLayout.Y_AXIS));



        final javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        // jPanel1.setLayout(jPanel1Layout);
        // jPanel1Layout.setHorizontalGroup(
        //     jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        //     .addGroup(jPanel1Layout.createSequentialGroup()
        //         .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
        //             .addGroup(jPanel1Layout.createSequentialGroup()
        //                 .addContainerGap()
        //                 .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
        //                 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        //                 .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        //             .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        //         .addGap(0, 38, Short.MAX_VALUE))
        // );
        // jPanel1Layout.setVerticalGroup(
        //     jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        //     .addGroup(jPanel1Layout.createSequentialGroup()
        //         .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        //         .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        //             .addGroup(jPanel1Layout.createSequentialGroup()
        //                 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
        //                 .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
        //                 .addGap(23, 23, 23))
        //             .addGroup(jPanel1Layout.createSequentialGroup()
        //                 .addGap(62, 62, 62)
        //                 .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        //                 .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        // );

        jLabel3.setFont(new java.awt.Font("Lucida Bright", 0, 36)); // NOI18N
        jLabel3.setText("Help Harry Potter");

       // javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
       // jPanel5.setLayout(jPanel5Layout);
        jPanel5.setLayout(new java.awt.BorderLayout());

        jPanel5.setMinimumSize(headerDimension);
        jPanel5.setMaximumSize(headerDimension);
        jPanel5.setBorder(new EmptyBorder(150, 10, 10, 10));

        //jPanel5.add(jLabel2,"West");
        //jPanel5.add(jLabel3,"Center");
        //jPanel5.add(jLabel3);
        //jLabel3.setText("");
        
        
        // jPanel5Layout.setHorizontalGroup(
        //     jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        //     .addGroup(jPanel5Layout.createSequentialGroup()
        //         .addGap(16, 16, 16)
        //         .addComponent(jLabel2)
        //         .addGap(18, 18, 18)
        //         .addComponent(jLabel3)
        //         .addGap(27, 27, 27)
        //         .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
        //         .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        // );
        // jPanel5Layout.setVerticalGroup(
        //     jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        //     .addGroup(jPanel5Layout.createSequentialGroup()
        //         .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        //             .addGroup(jPanel5Layout.createSequentialGroup()
        //                 .addContainerGap()
        //                 .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
        //             .addGroup(jPanel5Layout.createSequentialGroup()
        //                 .addGap(15, 15, 15)
        //                 .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
        //             .addGroup(jPanel5Layout.createSequentialGroup()
        //                 .addGap(25, 25, 25)
        //                 .addComponent(jLabel3)))
        //         .addContainerGap(20, Short.MAX_VALUE))
        // );

        final java.awt.BorderLayout layout = new java.awt.BorderLayout();//new javax.swing.GroupLayout(getContentPane());
        
        getContentPane().setLayout(layout);
        // layout.setHorizontalGroup(
        //     layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        //     .addGroup(layout.createSequentialGroup()
        //         .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
        //             .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        //             .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        //         .addGap(0, 48, Short.MAX_VALUE))
        // );
        // layout.setVerticalGroup(
        //     layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        //     .addGroup(layout.createSequentialGroup()
        //         .addContainerGap()
        //         .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        //         .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        //         .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        //         .addGap(9, 9, 9))
        // );
        
        setMaximumSize(new Dimension(1600,846));
        setMinimumSize(new Dimension(1600,846));
        setBackground(new java.awt.Color(255,255,255));
        //setOpacity(0.1f);
        //

        // this.setBackground(new java.awt.Color(255,255,255));
        this.jPanel1.setOpaque(false);
        this.jPanel2.setOpaque(false);
        this.jPanel4.setOpaque(false);
        this.jPanel5.setOpaque(false);
        this.jPanel6.setOpaque(false);
        

        //new java.awt.Color()
        this.jPanel1.setBackground(transparent);
        this.jPanel4.setBackground(transparent);
        this.jPanel5.setBackground(transparent);
        this.jPanel2.setBackground(transparent);
        this.jPanel6.setBackground(transparent);
        

        final javax.swing.JPanel centerPanel  = new javax.swing.JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, javax.swing.BoxLayout.Y_AXIS));

        centerPanel.add(jPanel2);
        centerPanel.add(jPanel4);
        centerPanel.setBackground(transparent);
        centerPanel.setOpaque(false);

        getContentPane().add(this.jPanel5,"North");
        //getContentPane().add(this.jPanel2,"South");
        



        javax.swing.JPanel jPanel6Parent = new JPanel();
        jPanel6Parent.setLayout(new BoxLayout(jPanel6Parent, BoxLayout.Y_AXIS));
        jPanel6Parent.setOpaque(false);
        jPanel6Parent.setBorder(new EmptyBorder(10, 10, 10, 10));
        jPanel6Parent.add(jPanel6);
        getContentPane().add(jPanel6Parent,"West");


        javax.swing.JPanel solutionParent = new JPanel();
        solutionParent.setLayout(new BoxLayout(solutionParent, BoxLayout.Y_AXIS));
        solutionParent.setOpaque(false);
        solutionParent.setBorder(new EmptyBorder(10, 10, 10, 10));
        solutionParent.add(solution);
        getContentPane().add(solutionParent,"East");

        getContentPane().add(centerPanel,"Center");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void solveKnapSack() {

        final SolveKnapSack sol = new SolveKnapSack(this.maxWeight, this.weights, this.values, 10);

        int counter = 0;
        for (final int wght : sol.getSolvedWeights()) {

            if (wght == -1) {
                if (counter == 0) {
                    System.out.println("No Solution");
                }
                break;
            }
            counter++;

            for (int i = 0; i < 10; i++) {
                if (this.weights[i] == wght) {
                    solveActionButtonPerformed(i);
                    
                    break;
                }
            }
        }

    }

    public void setButtonSizes() {
        final int width = 200;
        final int length = 40;
        final Dimension d = new Dimension(width, length);
        weightButton1.setSize(width, length);
        weightButton1.setPreferredSize(d);
        weightButton1.setMaximumSize(d);

        weightButton2.setSize(width, length);
        weightButton2.setPreferredSize(d);
        weightButton2.setMaximumSize(d);

        weightButton3.setSize(width, length);
        weightButton3.setPreferredSize(d);
        weightButton3.setMaximumSize(d);

        weightButton4.setSize(width, length);
        weightButton4.setPreferredSize(d);
        weightButton4.setMaximumSize(d);

        weightButton5.setSize(width, length);
        weightButton5.setPreferredSize(d);
        weightButton5.setMaximumSize(d);

        weightButton6.setSize(width, length);
        weightButton6.setPreferredSize(d);
        weightButton6.setMaximumSize(d);

        weightButton7.setSize(width, length);
        weightButton7.setPreferredSize(d);
        weightButton7.setMaximumSize(d);

        weightButton8.setSize(width, length);
        weightButton8.setPreferredSize(d);
        weightButton8.setMaximumSize(d);

        weightButton9.setSize(width, length);
        weightButton9.setPreferredSize(d);
        weightButton9.setMaximumSize(d);

        weightButton10.setSize(width, length);
        weightButton10.setPreferredSize(d);
        weightButton10.setMaximumSize(d);

    }

    public void setButtonLabels() {
        weightButton1.setText("Volume: " + weights[0] + " Value : " + values[0]);
        weightButton2.setText("Volume: " + weights[1] + " Value : " + values[1]);
        weightButton3.setText("Volume: " + weights[2] + " Value : " + values[2]);
        weightButton4.setText("Volume: " + weights[3] + " Value : " + values[3]);
        weightButton5.setText("Volume: " + weights[4] + " Value : " + values[4]);
        weightButton6.setText("Volume: " + weights[5] + " Value : " + values[5]);
        weightButton7.setText("Volume: " + weights[6] + " Value : " + values[6]);
        weightButton8.setText("Volume: " + weights[7] + " Value : " + values[7]);
        weightButton9.setText("Volume: " + weights[8] + " Value : " + values[8]);
        weightButton10.setText("Volume: " + weights[9] + " Value : " + values[9]);

        // weightButton1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1,
        //         new java.awt.Color(colorX[0], colorY[0], colorZ[0])));
        // weightButton2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1,
        //         new java.awt.Color(colorX[1], colorY[1], colorZ[1])));
        // weightButton3.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1,
        //         new java.awt.Color(colorX[2], colorY[2], colorZ[2])));
        // weightButton4.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1,
        //         new java.awt.Color(colorX[3], colorY[3], colorZ[3])));
        // weightButton5.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1,
        //         new java.awt.Color(colorX[4], colorY[4], colorZ[4])));
        // weightButton6.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1,
        //         new java.awt.Color(colorX[5], colorY[5], colorZ[5])));
        // weightButton7.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1,
        //         new java.awt.Color(colorX[6], colorY[6], colorZ[6])));
        // weightButton8.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1,
        //         new java.awt.Color(colorX[7], colorY[7], colorZ[7])));
        // weightButton9.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1,
        //         new java.awt.Color(colorX[8], colorY[8], colorZ[8])));
        // weightButton10.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1,
        //         new java.awt.Color(colorX[9], colorY[9], colorZ[9])));


        weightButton1.setBackground(backgrounds[0]);
        weightButton2.setBackground(backgrounds[1]);
        weightButton3.setBackground(backgrounds[2]);
        weightButton4.setBackground(backgrounds[3]);
        weightButton5.setBackground(backgrounds[4]);
        weightButton6.setBackground(backgrounds[5]);
        weightButton7.setBackground(backgrounds[6]);
        weightButton8.setBackground(backgrounds[7]);
        weightButton9.setBackground(backgrounds[8]);
        weightButton10.setBackground(backgrounds[9]);



        weightButton1.setForeground(foregrounds[0]);
        weightButton2.setForeground(foregrounds[1]);
        weightButton3.setForeground(foregrounds[2]);
        weightButton4.setForeground(foregrounds[3]);
        weightButton5.setForeground(foregrounds[4]);
        weightButton6.setForeground(foregrounds[5]);
        weightButton7.setForeground(foregrounds[6]);
        weightButton8.setForeground(foregrounds[7]);
        weightButton9.setForeground(foregrounds[8]);
        weightButton10.setForeground(foregrounds[9]);
    }

    private void weightButtonActionPerformed(final int buttonNumer) {

        if (weightPanels[buttonNumer].isVisible()) {
            weightPanels[buttonNumer].setVisible(false);
            currentWeight = currentWeight - weights[buttonNumer];
            currentValue = currentValue - values[buttonNumer];
            setCurrentValuesText();
            emptyPanelLength = emptyPanelLength + heights[buttonNumer];
            emptyPanel.setSize(container_width, emptyPanelLength);
            emptyPanel.setMaximumSize(new Dimension(container_width, emptyPanelLength));

        } else {

            if (currentWeightCheck(currentWeight + weights[buttonNumer])) {
                JOptionPane.showMessageDialog(this,
                        "You can only add upto  " + (maxWeight - currentWeight) + " weight");
            } else {
                weightPanels[buttonNumer].setVisible(true);
                weightPanels[buttonNumer].setSize(container_width, heights[buttonNumer]);
                weightPanels[buttonNumer].setMaximumSize(new Dimension(container_width, heights[buttonNumer]));
                emptyPanelLength = emptyPanelLength - heights[buttonNumer];
                emptyPanel.setSize(container_width, emptyPanelLength);
                emptyPanel.setMaximumSize(new Dimension(container_width, emptyPanelLength));
                currentWeight = currentWeight + weights[buttonNumer];
                currentValue = currentValue + values[buttonNumer];
                setCurrentValuesText();

            }
        }
    }


    private void solveActionButtonPerformed(final int buttonNumer) {

        if (solvedweightPanels[buttonNumer].isVisible()) {
            solvedweightPanels[buttonNumer].setVisible(false);
            solvedcurrentWeight = solvedcurrentWeight - weights[buttonNumer];
            solvedcurrentValue = solvedcurrentValue - values[buttonNumer];
            setSolvedCurrentValuesText();
            solvedemptyPanelLength = solvedemptyPanelLength + heights[buttonNumer];
            solvedemptyPanel.setSize(container_width, solvedemptyPanelLength);
            solvedemptyPanel.setMaximumSize(new Dimension(container_width, solvedemptyPanelLength));

        } else {

            // if (currentWeightCheck(solvedcurrentWeight + weights[buttonNumer])) {
            //     JOptionPane.showMessageDialog(this,
            //             "You can only add upto  " + (maxWeight - currentWeight) + " weight");
            // } else {
                solvedweightPanels[buttonNumer].setVisible(true);
                solvedweightPanels[buttonNumer].setSize(container_width, heights[buttonNumer]);
                solvedweightPanels[buttonNumer].setMaximumSize(new Dimension(container_width, heights[buttonNumer]));
                solvedemptyPanelLength = solvedemptyPanelLength - heights[buttonNumer];
                solvedemptyPanel.setSize(container_width, solvedemptyPanelLength);
                solvedemptyPanel.setMaximumSize(new Dimension(container_width, solvedemptyPanelLength));
                solvedcurrentWeight = solvedcurrentWeight + weights[buttonNumer];
                solvedcurrentValue = solvedcurrentValue + values[buttonNumer];
                setSolvedCurrentValuesText();

            // }
        }
    }





    /**
     * @param args the command line arguments
     */
    public static void main(final String args[]) {

        if(args.length>0 && args[0]!=null) {
            imagesFolder = args[0];
        }else {
            imagesFolder = "/Users/i329810/NetBeansProjects1/KnapSackDemp/src/main/java/resources";
        }


        try {
            for (final javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (final ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(KnapSackDemo.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (final InstantiationException ex) {
            java.util.logging.Logger.getLogger(KnapSackDemo.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (final IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KnapSackDemo.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (final javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KnapSackDemo.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new KnapSackDemo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel currentValueLabel;
    private javax.swing.JLabel currentWeightLabel;
    private javax.swing.JLabel maxWeightLabel;

    private javax.swing.JLabel solvedcurrentValueLabel;
    private javax.swing.JLabel solvedcurrentWeightLabel;
    private javax.swing.JLabel solvedmaxWeightLabel;

    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel solution;
    private javax.swing.JButton newProblemButton;
    private javax.swing.JButton newProblemButton2;
    private javax.swing.JButton solveButton;
    private javax.swing.JButton weightButton1;
    private javax.swing.JButton weightButton10;
    private javax.swing.JButton weightButton2;
    private javax.swing.JButton weightButton3;
    private javax.swing.JButton weightButton4;
    private javax.swing.JButton weightButton5;
    private javax.swing.JButton weightButton6;
    private javax.swing.JButton weightButton7;
    private javax.swing.JButton weightButton8;
    private javax.swing.JButton weightButton9;
    // End of variables declaration//GEN-END:variables

    private void initPanels() {
        emptyPanel = new JPanel();
        emptyPanel.setBackground(transparent);
        emptyPanel.setVisible(true);
        emptyPanel.setSize(container_width, emptyPanelLength);
        emptyPanel.setMaximumSize(new Dimension(container_width, emptyPanelLength));
        jPanel6.add(emptyPanel);
        weightPanels = new JPanel[10];
        for (int i = 0; i < 10; i++) {
            weightPanels[i] = new javax.swing.JPanel();
            jPanel6.add(weightPanels[i]);
        }

    }

    private void baseInitializeBucket() {

        emptyPanel.setVisible(true);
        emptyPanel.setSize(container_width, emptyPanelLength);
        emptyPanel.setMaximumSize(new Dimension(container_width, emptyPanelLength));
        // jPanel6.add(emptyPanel);
        for (int i = 0; i < 10; i++) {
            weightPanels[i].setVisible(false);
            weightPanels[i].setBackground(backgrounds[i]);

        }

    }



    public void disableAllButtons() {
        weightButton1.setEnabled(false);
        weightButton2.setEnabled(false);
        weightButton3.setEnabled(false);
        weightButton4.setEnabled(false);
        weightButton5.setEnabled(false);
        weightButton6.setEnabled(false);
        weightButton7.setEnabled(false);
        weightButton8.setEnabled(false);
        weightButton9.setEnabled(false);
        weightButton10.setEnabled(false);
    }


    public void enableAllButtons() {
        weightButton1.setEnabled(true);
        weightButton2.setEnabled(true);
        weightButton3.setEnabled(true);
        weightButton4.setEnabled(true);
        weightButton5.setEnabled(true);
        weightButton6.setEnabled(true);
        weightButton7.setEnabled(true);
        weightButton8.setEnabled(true);
        weightButton9.setEnabled(true);
        weightButton10.setEnabled(true);
    }


    private void initSolvedPanels() {
        solvedemptyPanel = new JPanel();
        solvedemptyPanel.setBackground(transparent);
        solvedemptyPanel.setVisible(true);
        solvedemptyPanel.setSize(container_width, emptyPanelLength);
        solvedemptyPanel.setMaximumSize(new Dimension(container_width, emptyPanelLength));
        solution.add(solvedemptyPanel);
        solvedweightPanels = new JPanel[10];
        for (int i = 0; i < 10; i++) {
            solvedweightPanels[i] = new javax.swing.JPanel();
            solution.add(solvedweightPanels[i]);
        }

    }

    private void baseInitializeSolvedBucket() {

        solvedemptyPanel.setVisible(true);
        solvedemptyPanel.setSize(container_width, emptyPanelLength);
        solvedemptyPanel.setMaximumSize(new Dimension(container_width, emptyPanelLength));
        // jPanel6.add(emptyPanel);
        for (int i = 0; i < 10; i++) {
            solvedweightPanels[i].setVisible(false);
            //solvedweightPanels[i].setBackground(new java.awt.Color(colorX[i], colorY[i], colorZ[i]));
            solvedweightPanels[i].setBackground(backgrounds[i]);
        }

    }

    public void closeAllWeightPanels() {
        for (int i = 0; i < 10; i++) {
            weightPanels[i].setVisible(false);
        }
    }
    public void closeAllSolvedWeightPanels() {
        for (int i = 0; i < 10; i++) {
            solvedweightPanels[i].setVisible(false);
        }
    }
    private boolean currentWeightCheck(final int weight) {
        if (weight > maxWeight) {
            return true;
        } else {
            return false;
        }
    }


    private void showInstructionsFrame() {

        JFrame instructionsFrame = new JFrame();
        instructionsFrame.setUndecorated(true);

        //int instructionCount = 0; 
        //instructionsFrame.setContentPane();
        JLabel baseImage = new JLabel(new ImageIcon(imagesFolder+"/instructions-1.jpg"));
        instructionsFrame.getContentPane().setLayout(new java.awt.BorderLayout());
        instructionsFrame.setBackground(transparent);
        baseImage.setBorder(new EmptyBorder(10,10,10,10));
        instructionsFrame.show();
        instructionsFrame.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        instructionsFrame.setSize(520,415);
        instructionsFrame.setLocationRelativeTo(this);
        instructionsFrame.setLocation(100, 100);
        instructionsFrame.setVisible(true);
        instructionsFrame.add(baseImage,"Center");
        JButton button = new JButton(); 
        button.setText("Next");
        instructionsFrame.add(button,"South");
        button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(final java.awt.event.ActionEvent evt) {
                if(instructionCount == 0) {
                    instructionCount++;
                    baseImage.setIcon(new ImageIcon(imagesFolder+"/instructions-2.jpg"));

                }else if(instructionCount == 1) {
                    instructionCount++;
                    baseImage.setIcon(new ImageIcon(imagesFolder+"/instructions-3.jpg"));
                }else if(instructionCount == 2) {
                    instructionCount++;
                    baseImage.setIcon(new ImageIcon(imagesFolder+"/instructions-4.jpg"));
                    ((JButton)evt.getSource()).setText("Done");
                }else if(instructionCount == 3) {
                    instructionCount= 0;
                    
                    instructionsFrame.dispose();
                }
            }
          
        });        

        // JPanel instructionsPane = new JPanel(); 
        // instructionsPane.add(new JLabel(new ImageIcon(imagesFolder+"/instructions-1.jpg")));
        // instructionsFrame.add(instructionsPane);

    }
}
