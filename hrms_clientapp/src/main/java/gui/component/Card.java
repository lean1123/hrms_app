package gui.component;

import gui.model.ModelCard;
import gui.model.ModelCardEmpl;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.text.DecimalFormat;

import javax.swing.GroupLayout;
import javax.swing.JLabel;

public class Card extends javax.swing.JPanel {

    public Color getColorGradient() {
        return colorGradient;
    }

    public void setColorGradient(Color colorGradient) {
        this.colorGradient = colorGradient;
    }

    private Color colorGradient;

    public Card() {
        initComponents();
        setOpaque(false);
        setBackground(new Color(112, 69, 246));
        colorGradient = new Color(255, 255, 255);
        pro.setBackground(new Color(255, 255, 255, 100));
        pro.setForeground(Color.WHITE);
    }

    public void setData(ModelCard data) {
        //DecimalFormat df = new DecimalFormat("#,##0.##");
        lbTitle.setText(data.getTitle());
        lbIcon.setIcon(data.getIcon());
        lbSubTitle1.setText(data.getSubTitle1());
        lbValue1.setText(data.getValue1()+"");
        lbSubTitle2.setText(data.getSubTitle2());
        lbValue2.setText(data.getValue2()+"");
    }
    
    public void setData1(ModelCardEmpl data) {
        //DecimalFormat df = new DecimalFormat("#,##0.##");
        lbTitle.setText(data.getTitle());
        lbIcon.setIcon(data.getIcon());
        lbSubTitle1.setText(data.getSubTitle1());
        lbValue1.setText(data.getValue1()+"");
        lbSubTitle2.setText(data.getSubTitle2());
        lbValue2.setText(data.getValue2()+"");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbTitle = new javax.swing.JLabel();
        lbValues = new javax.swing.JLabel();
        lbIcon = new javax.swing.JLabel();
        pro = new gui.swing.ProgressBarCustom();
        lbPer = new javax.swing.JLabel();
        lbSubTitle1 = new JLabel();
        lbSubTitle2 = new JLabel();
        lbValue1 = new JLabel();
        lbValue2 = new JLabel();

        setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));

        lbTitle.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        lbTitle.setForeground(new java.awt.Color(225, 225, 225));
        lbTitle.setText("Title");
        
        lbSubTitle1.setFont(new java.awt.Font("sansserif", 0, 20)); // NOI18N
        lbSubTitle1.setForeground(new java.awt.Color(225, 225, 225));
        lbSubTitle1.setText("Regular");
        
        lbSubTitle2.setFont(new java.awt.Font("sansserif", 0, 20)); // NOI18N
        lbSubTitle2.setForeground(new java.awt.Color(225, 225, 225));
        lbSubTitle2.setText("Regular");

        lbValue1.setFont(new java.awt.Font("sansserif", 0, 20)); // NOI18N
        lbValue1.setForeground(new java.awt.Color(225, 225, 225));
        lbValue1.setText("9");
        
        lbValue2.setFont(new java.awt.Font("sansserif", 0, 20)); // NOI18N
        lbValue2.setForeground(new java.awt.Color(225, 225, 225));
        lbValue2.setText("0");
        
        lbValues.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        lbValues.setForeground(new java.awt.Color(225, 225, 225));
        lbValues.setText("Values");

        lbIcon.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        lbPer.setForeground(new java.awt.Color(255, 255, 255));
        lbPer.setText("0%");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                        		//
                            .addComponent(lbSubTitle1, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lbValue1))
                        .addGroup(layout.createSequentialGroup()
                        		//
                            .addComponent(lbSubTitle2, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lbValue2))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lbTitle)
                                //.addComponent(lbValues)
                                )
                            .addGap(18, 18, 18)
                            .addComponent(lbIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lbTitle)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            //.addComponent(lbValues)
                            )
                        .addComponent(lbIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lbValue1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(lbSubTitle1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap()))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbValue2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lbSubTitle2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                    	))
            );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint gra = new GradientPaint(0, getHeight(), getBackground(), getWidth(), 0, colorGradient);
        g2.setPaint(gra);
        g2.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(grphcs);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lbIcon;
    private javax.swing.JLabel lbPer;
    private javax.swing.JLabel lbTitle;
    private JLabel lbSubTitle1;
    private JLabel lbSubTitle2;
    private JLabel lbValue1;
    private JLabel lbValue2;
    private javax.swing.JLabel lbValues;
    private gui.swing.ProgressBarCustom pro;
    // End of variables declaration//GEN-END:variables
}
