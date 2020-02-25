package com.mycompany.knapsackdemp;

import java.awt.Dimension;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.Graphics;

public class FullpageKnapSack {
    private javax.swing.JFrame baseframe;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JPanel footerPanel;
    private javax.swing.JPanel leftSolutionPanel;
    private javax.swing.JPanel leftSolutionEmptyPanel;
    private javax.swing.JPanel leftSolutionsContainerPanel;
    private javax.swing.JPanel rightSolutionEmptyPanel;
    private javax.swing.JPanel rightSolutionContainerPanel;
    private javax.swing.JPanel rightSolutionPanel;
    private javax.swing.JPanel centerButtonsPanel;
    private javax.swing.JButton weightButtons[];
    private javax.swing.JPanel userSolutions[];
    private javax.swing.JPanel computerSolutions[];
    private static String imagesFolder;

    public static void main(String ar[]) {

        new FullpageKnapSack().start();
        imagesFolder = "/Users/i329810/NetBeansProjects1/KnapSackDemp/src/main/java/resources";
    }

    public void start() {

        buildFrame();
        createHeaderPanel();
        createFooterPanel();
        createLeftSolutionPanel();
        createRightSolutionPanel();
        createCenterButtonsPanel();

    }

    private void createCenterButtonsPanel() {
        this.centerButtonsPanel = new JPanel();
        this.centerButtonsPanel.add(new JLabel("centerButtonsPanel"));
        this.baseframe.add(this.centerButtonsPanel, "Center");
        this.centerButtonsPanel.setLayout(new BoxLayout(this.centerButtonsPanel, javax.swing.BoxLayout.Y_AXIS));
        weightButtons = new JButton[10];

        for (int button = 0; button < 10; button++) {
            weightButtons[button] = new JButton("Volume: " + button + "; value :" + button * 10);
            weightButtons[button].setMaximumSize(new Dimension(500, 70));
            this.centerButtonsPanel.add(weightButtons[button]);
        }

    }

    private void createRightSolutionPanel() {
        this.rightSolutionPanel = new JPanel();
        this.rightSolutionPanel.add(new JLabel("rightSolutionPanel"));
        this.baseframe.add(this.rightSolutionPanel, "West");
        this.rightSolutionPanel.setLayout(new BoxLayout(this.rightSolutionPanel, javax.swing.BoxLayout.Y_AXIS));
        this.rightSolutionContainerPanel = new JPanel();
        this.rightSolutionContainerPanel
                .setBorder(javax.swing.BorderFactory.createMatteBorder(0, 3, 3, 3, new java.awt.Color(0, 0, 0)));
        this.rightSolutionPanel.add(this.rightSolutionContainerPanel);
        this.rightSolutionContainerPanel.setMaximumSize(new Dimension(500, 1000));
        this.rightSolutionContainerPanel.setSize(new Dimension(120, 1000));

    }

    private void createLeftSolutionPanel() {
        this.leftSolutionPanel = new JPanel();
        this.leftSolutionPanel.add(new JLabel("leftSolutionPanel"));

        this.leftSolutionPanel.setLayout(new BoxLayout(this.leftSolutionPanel, javax.swing.BoxLayout.Y_AXIS));
        this.baseframe.add(this.leftSolutionPanel, "East");

        this.leftSolutionsContainerPanel = new JPanel();
        this.leftSolutionsContainerPanel
                .setBorder(javax.swing.BorderFactory.createMatteBorder(0, 3, 3, 3, new java.awt.Color(0, 0, 0)));
        this.leftSolutionPanel.add(this.leftSolutionsContainerPanel);
        this.leftSolutionsContainerPanel.setMaximumSize(new Dimension(500, 1000));
        this.leftSolutionsContainerPanel.setSize(new Dimension(120, 1000));

    }

    private void createFooterPanel() {
        this.footerPanel = new JPanel();
        this.footerPanel.add(new JLabel("Footer"));
        this.baseframe.add(this.footerPanel, "South");

    }

    private void createHeaderPanel() {

        this.headerPanel = new JPanel(){
            /**
			 *
			 */
			private static final long serialVersionUID = 1L;
			public void paintComponent(Graphics g) {
               ImageIcon img = new ImageIcon("/Users/i329810/NetBeansProjects1/KnapSackDemp/src/main/java/resources/background.png");
               System.out.println(g.drawImage(img.getImage(), 0, 0, 697, 187, null, null));//g.drawImage(img.getImage(), 0, 0, null));
               
               super.paintComponent(g);
            }};
        // this.headerPanel.add(new JLabel("Header"));
        this.headerPanel.setOpaque(false);
        this.headerPanel.setSize(697,400);
        this.headerPanel.setMaximumSize(new Dimension(697,400));
        this.headerPanel.setVisible(true);
        this.baseframe.add(this.headerPanel, "North");
        // try {
        //     ImagePanel img = new ImagePanel(ImageIO.read(new File("/Users/i329810/NetBeansProjects1/KnapSackDemp/src/main/java/resources/background.png")));
        //     //this.headerPanel.add(img);
        //     img.setSize(697,187);
        //     img.setMaximumSize(new Dimension(697,187));
        //     this.baseframe.add(img, "North");
        // } catch (IOException e) {
        //     // TODO Auto-generated catch block
        //     e.printStackTrace();
        // }


    }

    private void buildFrame() {

        baseframe = new JFrame();
        baseframe.setVisible(true);
        baseframe.setLayout(new BorderLayout());
        baseframe.setSize(500,500);
        baseframe.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    }


}