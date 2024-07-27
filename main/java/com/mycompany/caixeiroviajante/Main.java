package com.mycompany.caixeiroviajante;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import javax.swing.table.DefaultTableModel;

public class Main extends javax.swing.JFrame {

    DecimalFormat scientificFormat = new DecimalFormat("0. ##E0");

    public Main() {
        initComponents();
        esvaziarTabela();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrolTable = new javax.swing.JScrollPane();
        tableCarteiro = new javax.swing.JTable();
        comboCidades = new javax.swing.JComboBox<>();
        labelCidades = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Caixeiro Viajante");
        setName("frameMain"); // NOI18N
        setResizable(false);

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
        scrolTable.setViewportView(tableCarteiro);

        comboCidades.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "50", "100", "150", "200", "250", "300", "400", "500" }));
        comboCidades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboCidadesActionPerformed(evt);
            }
        });

        labelCidades.setText("Quantidade de cidades");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(scrolTable, javax.swing.GroupLayout.PREFERRED_SIZE, 527, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelCidades, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(comboCidades, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelCidades)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboCidades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(scrolTable, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void comboCidadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboCidadesActionPerformed
        if (comboCidades.getSelectedIndex() == 0) {
            esvaziarTabela();
        } else {
            preencherTabela(Integer.parseInt((String) comboCidades.getSelectedItem()));
        }
    }//GEN-LAST:event_comboCidadesActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> {
            new Main().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboCidades;
    private javax.swing.JLabel labelCidades;
    private javax.swing.JScrollPane scrolTable;
    private javax.swing.JTable tableCarteiro;
    // End of variables declaration//GEN-END:variables

    private void preencherTabela(int quantidadeCidades) {
        DefaultTableModel dtmExercicio = (DefaultTableModel) tableCarteiro.getModel();
        dtmExercicio.setNumRows(0);

        for (int i = 10; i <= quantidadeCidades; i += 10) {
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

    private void esvaziarTabela() {
        DefaultTableModel dtmExercicio = (DefaultTableModel) tableCarteiro.getModel();
        dtmExercicio.setNumRows(0);
    }
    
}
