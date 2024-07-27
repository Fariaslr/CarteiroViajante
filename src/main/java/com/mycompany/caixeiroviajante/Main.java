package com.mycompany.caixeiroviajante;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import javax.swing.table.DefaultTableModel;

public class Main extends javax.swing.JFrame {

    DecimalFormat scientificFormat = new DecimalFormat("0.##E0");

    public Main() {
        initComponents();
        preencherTabela();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableCarteiro = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        tableCarteiro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Cidades", "Fatorial", "Tempo (segundos)", "Tempo (dias)", "Tempo (anos)"
            }
        ));
        jScrollPane1.setViewportView(tableCarteiro);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 527, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> {
            new Main().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableCarteiro;
    // End of variables declaration//GEN-END:variables

    private void preencherTabela() {
        DefaultTableModel dtmExercicio = (DefaultTableModel) tableCarteiro.getModel();
        dtmExercicio.setNumRows(0);

        for (int i = 10; i <= 150; i += 10) {
            BigDecimal fatorial = fatorial(i);
            BigDecimal tempoSegundos = fatorial.divide(new BigDecimal(10_000_000_000L), BigDecimal.ROUND_UP);
            BigDecimal tempoDias = tempoSegundos.divide(new BigDecimal(86400), BigDecimal.ROUND_UP);
            BigDecimal tempoAnos = tempoDias.divide(new BigDecimal(365), BigDecimal.ROUND_UP);
            
            dtmExercicio.addRow(new Object[]{
                i,
                scientificFormat.format(fatorial),
                scientificFormat.format(tempoSegundos),
                scientificFormat.format(tempoDias),
                scientificFormat.format(tempoAnos)
            });
        }

    }
    
    public static BigDecimal fatorial(int num) {
        if (num <= 1) {
            return BigDecimal.ONE;
        } else {
            return fatorial(num - 1).multiply(new BigDecimal(num));
        }
    }
}
