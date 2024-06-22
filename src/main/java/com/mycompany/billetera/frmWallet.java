package com.mycompany.billetera;

import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialPalenightIJTheme;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class frmWallet extends javax.swing.JFrame {

    //local variables
    String[] headboard = {"ID", "TYPE", "DATE", "AMOUNT"};

    //this is as a model for the table
    DefaultTableModel model = new DefaultTableModel(headboard, 0);

    //variable for the initial amount
    double startingAmount = 100;

    public frmWallet() {
        initComponents();
        FlatMaterialPalenightIJTheme.setup();
        this.setTitle("WELCOME TO THE SYSTEM");

        //we set the model to the table
        tblData.setModel(model);
        txtAccumulated.setText("$/." + startingAmount + "");
        txtFixedAmount.setText("$/." + 100 + "");
        hideColumns();
    }

    public boolean validateAmount() {
        return txtAmount.getText().trim().isEmpty() || Integer.parseInt(txtAmount.getText()) <= 0;
    }

    public void registerExpense(String type) {
        double amount;
        if (validateAmount()) {
            JOptionPane.showMessageDialog(rootPane, "Please enter the amount");
        } else {
            amount = Integer.parseInt(txtAmount.getText());
            if (type.equalsIgnoreCase("Buys")) {
                if (amount > startingAmount) {
                    JOptionPane.showMessageDialog(rootPane, "The amount must be less than $/." + startingAmount);
                    return;
                } else {
                    startingAmount -= amount;
                    int id = randomid();
                    String buys = type;
                    String date = getDate();

                    //We create an object of the expense class
                    Expense myExpense = new Expense(id, buys, date, amount);

                    //We create an array with the attributes of the gasro class
                    String[] attributes = {"ID", "TYPE", "DATE", "AMOUNT"};
                    Object[] row = new Object[attributes.length];

                    for (int i = 0; i < attributes.length; i++) {
                        //a break statement for each attribute
                        switch (attributes[i]) {
                            case "ID":
                                row[i] = myExpense.getId();
                                break;
                            case "TYPE":
                                row[i] = myExpense.getType();
                                break;
                            case "DATE":
                                row[i] = myExpense.getDate();
                                break;
                            case "AMOUNT":
                                row[i] = myExpense.getAmount();
                                break;
                        }
                    }

                    //we add the row to the model
                    model.addRow(row);
                    //we clear the text field of the amount entry  txtMonto.setText("");
                    txtAmount.requestFocus();
                }
            } else {
                startingAmount += amount;
                int id = randomid();
                String buys = type;
                String date = getDate();

                //We create an object of the expense class
                Expense myExpense = new Expense(id, buys, date, amount);

                //We create an array with the attributes of the expense class
                String[] attributes = {"ID", "TYPE", "DATE", "AMOUNT"};
                Object[] row = new Object[attributes.length];

                for (int i = 0; i < attributes.length; i++) {
                    //a break statement for each attribute
                    switch (attributes[i]) {
                        case "ID":
                            row[i] = myExpense.getId();
                            break;
                        case "TYPE":
                            row[i] = myExpense.getType();
                            break;
                        case "DATE":
                            row[i] = myExpense.getDate();
                            break;
                        case "AMOUNT":
                            row[i] = myExpense.getAmount();
                            break;
                    }
                }
                //we add the row to the model
                model.addRow(row);

                //we clear the text field
                txtAmount.setText("");
                txtAmount.requestFocus();
            }
        }
        txtAccumulated.setText("$/." + startingAmount + "");
    }

    //method to generate the random id
    public int randomid() {
        int valarGiven = (int) Math.floor(Math.random() * 1000 + 1);
        return valarGiven;
    }

    //method to obtain the date
    public String getDate() {
        Date date = new Date();

        //let's format the date
        SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS a");

        return formatDate.format(date);
    }

    //The column to hide is the one that contains the Id
    private void hideColumns() {
        tblData.getColumnModel().getColumn(0).setMaxWidth(40);
        tblData.getColumnModel().getColumn(0).setMinWidth(40);
        tblData.getColumnModel().getColumn(0).setPreferredWidth(40);
    }

   @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblData = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnBuy = new javax.swing.JButton();
        btnSale = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtAccumulated = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtAmount = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtFixedAmount = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel2.setFont(new java.awt.Font("SimHei", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("My wallet");

        tblData.setFont(new java.awt.Font("Simplified Arabic Fixed", 0, 13)); // NOI18N
        tblData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "TIPO", "FECHA", "MONTO"
            }
        ));
        jScrollPane1.setViewportView(tblData);

        jLabel1.setText("Type:");

        btnBuy.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnBuy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imgs/3507741_add_cart_ecommerce_iconoteka_shop_icon.png"))); // NOI18N
        btnBuy.setText("Buys");
        btnBuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuyActionPerformed(evt);
            }
        });

        btnSale.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnSale.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imgs/3702393_discount_flash_sale_shopping_icon.png"))); // NOI18N
        btnSale.setText("Sale");
        btnSale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaleActionPerformed(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imgs/7851311_financial_investment_calculation_calculator_amount_icon.png"))); // NOI18N
        jLabel3.setText("Monto Total:");

        txtAccumulated.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txtAccumulated.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAccumulatedActionPerformed(evt);
            }
        });

        jLabel4.setText("Amount:");

        txtAmount.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imgs/134157_money_cashier_dollar_currency_icon.png"))); // NOI18N
        jLabel5.setText("Starting amount:");

        txtFixedAmount.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(558, 558, 558)
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(txtAccumulated, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                .addGap(16, 16, 16))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtAmount, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                        .addGap(350, 350, 350))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtFixedAmount, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                        .addGap(264, 264, 264)))
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSale, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                    .addComponent(btnBuy, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(txtFixedAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnSale)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBuy)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtAccumulated)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuyActionPerformed
        registerExpense("Buys");
    }//GEN-LAST:event_btnBuyActionPerformed

    private void btnSaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaleActionPerformed
        registerExpense("Sale");
    }//GEN-LAST:event_btnSaleActionPerformed

    private void txtAccumulatedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAccumulatedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAccumulatedActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmWallet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmWallet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmWallet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmWallet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmWallet().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuy;
    private javax.swing.JButton btnSale;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblData;
    private javax.swing.JTextField txtAccumulated;
    private javax.swing.JTextField txtAmount;
    private javax.swing.JTextField txtFixedAmount;
    // End of variables declaration//GEN-END:variables
}
