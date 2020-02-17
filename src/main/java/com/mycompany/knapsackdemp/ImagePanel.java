package com.mycompany.knapsackdemp;

import javax.swing.JPanel;
import java.awt.Image;
import java.awt.Graphics;
public class ImagePanel extends JPanel
{
private static final long serialVersionUID = 1L;
private Image image = null;
private int iWidth2;
private int iHeight2;

public ImagePanel(Image image)
{
    this.image = image;
    this.iWidth2 = image.getWidth(this)/2;
    this.iHeight2 = image.getHeight(this)/2;
}


public void paintComponent(Graphics g)
{
    super.paintComponent(g);
    if (image != null)
    {
        int x = this.getParent().getWidth()/2 - iWidth2;
        int y = this.getParent().getHeight()/2 - iHeight2;
        g.drawImage(image,x,y,this);
    }
}
}