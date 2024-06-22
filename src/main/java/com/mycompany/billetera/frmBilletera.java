package com.mycompany.billetera;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialPalenightIJTheme;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class frmBilletera extends javax.swing.JFrame {

    //variables locales
    String[] cabezera = {"ID", "TIPO", "FECHA", "MONTO"};

    //es como modelo para la tabla
    DefaultTableModel modelo = new DefaultTableModel(cabezera, 0);

    //variable para el monto
    double montoInicial = 100;

    public frmBilletera() {
        initComponents();
        FlatMaterialPalenightIJTheme.setup();
        this.setTitle("BIENVENIDO AL SISTEMA");

        //stablecemos el modelo a la tabla
        tblDatos.setModel(modelo);
        txtAcumulado.setText("$/." + montoInicial + "");
        txtMontoFijo.setText("$/." + 100 + "");
        ocultarColumnas();
    }

    public boolean validarMonto() {
        return txtMonto.getText().trim().isEmpty() || Integer.parseInt(txtMonto.getText()) <= 0;
    }

    public void registrarGasto(String tipo) {
        double monto;
        monto = Integer.parseInt(txtMonto.getText());
        if (validarMonto()) {
            JOptionPane.showMessageDialog(rootPane, "Por favor ingresar el monto");
        } else {

            if (tipo.equalsIgnoreCase("Compra")) {
                if (monto > montoInicial) {
                    JOptionPane.showMessageDialog(rootPane, "El monto debe ser menor a 100");
                    return;
                } else {
                    montoInicial -= monto;
                    int id = idAleatorio();
                    String compra = tipo;
                    String fecha = obtenerFecha();

                    //creamos un objeto de la clase gasto
                    Gasto miGasto = new Gasto(id, compra, fecha, monto);

                    // Creamos un arreglo con los atributos de la clase gasro
                    String[] atributos = {"ID", "TIPO", "FECHA", "MONTO"};
                    Object[] fila = new Object[atributos.length];

                    for (int i = 0; i < atributos.length; i++) {
                        // una sentencia break para cada atributo
                        switch (atributos[i]) {
                            case "ID":
                                fila[i] = miGasto.getId();
                                break;
                            case "TIPO":
                                fila[i] = miGasto.getTipo();
                                break;
                            case "FECHA":
                                fila[i] = miGasto.getFecha();
                                break;
                            case "MONTO":
                                fila[i] = miGasto.getMonto();
                                break;
                        }
                    }
                    
                    //agregamos la fila al modelo
                    modelo.addRow(fila);
                    //limpiamos el campo de 
                    txtMonto.setText("");
                    txtMonto.requestFocus();
                }
            } else {
                montoInicial += monto;
                int id = idAleatorio();
                String compra = tipo;
                String fecha = obtenerFecha();

                //creamos un objeto de la clase gasto
                Gasto miGasto = new Gasto(id, compra, fecha, monto);

                // Creamos un arreglo con los atributos de la clase gasro
                String[] atributos = {"ID", "TIPO", "FECHA", "MONTO"};
                Object[] fila = new Object[atributos.length];

                for (int i = 0; i < atributos.length; i++) {
                    // una sentencia break para cada atributo
                    switch (atributos[i]) {
                        case "ID":
                            fila[i] = miGasto.getId();
                            break;
                        case "TIPO":
                            fila[i] = miGasto.getTipo();
                            break;
                        case "FECHA":
                            fila[i] = miGasto.getFecha();
                            break;
                        case "MONTO":
                            fila[i] = miGasto.getMonto();
                            break;
                    }
                }
                //funcion para generar el id
                modelo.addRow(fila);

                //limpiamos el campo de texto
                txtMonto.setText("");
                txtMonto.requestFocus();
            }
        }
        txtAcumulado.setText("$/." + montoInicial + "");
    }

    //metodop para generar el id aleatorio
    public int idAleatorio() {
        int valarDado = (int) Math.floor(Math.random() * 1000 + 1);
        return valarDado;
    }

    //metodo para obtener la fecha
    public String obtenerFecha() {
        Date fecha = new Date();

        //vamos a darle formato a la fecha
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS a");

        return formatoFecha.format(fecha);
    }

    //la columa a ocultar es la que contiene el Id habitacion
    private void ocultarColumnas() {
        tblDatos.getColumnModel().getColumn(0).setMaxWidth(40);
        tblDatos.getColumnModel().getColumn(0).setMinWidth(40);
        tblDatos.getColumnModel().getColumn(0).setPreferredWidth(40);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDatos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnCompra = new javax.swing.JButton();
        btnVenta = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtAcumulado = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtMonto = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtMontoFijo = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel2.setFont(new java.awt.Font("SimHei", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Mi Billetera");

        tblDatos.setFont(new java.awt.Font("Simplified Arabic Fixed", 0, 13)); // NOI18N
        tblDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "TIPO", "FECHA", "MONTO"
            }
        ));
        jScrollPane1.setViewportView(tblDatos);

        jLabel1.setText("Tipo:");

        btnCompra.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnCompra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imgs/3507741_add_cart_ecommerce_iconoteka_shop_icon.png"))); // NOI18N
        btnCompra.setText("Compra");
        btnCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompraActionPerformed(evt);
            }
        });

        btnVenta.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imgs/3702393_discount_flash_sale_shopping_icon.png"))); // NOI18N
        btnVenta.setText("Venta");
        btnVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVentaActionPerformed(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imgs/7851311_financial_investment_calculation_calculator_amount_icon.png"))); // NOI18N
        jLabel3.setText("Monto Total:");

        txtAcumulado.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txtAcumulado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAcumuladoActionPerformed(evt);
            }
        });

        jLabel4.setText("Monto:");

        txtMonto.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imgs/134157_money_cashier_dollar_currency_icon.png"))); // NOI18N
        jLabel5.setText("Monto Inicial:");

        txtMontoFijo.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N

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
                .addComponent(txtAcumulado, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                .addGap(16, 16, 16))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMonto, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                        .addGap(350, 350, 350))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtMontoFijo, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                        .addGap(264, 264, 264)))
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnVenta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                    .addComponent(btnCompra, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE))
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
                            .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(txtMontoFijo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                                .addComponent(btnVenta)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCompra)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtAcumulado)
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

    private void btnCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompraActionPerformed
        registrarGasto("Compra");
    }//GEN-LAST:event_btnCompraActionPerformed

    private void btnVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVentaActionPerformed
        registrarGasto("Venta");
    }//GEN-LAST:event_btnVentaActionPerformed

    private void txtAcumuladoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAcumuladoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAcumuladoActionPerformed

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
            java.util.logging.Logger.getLogger(frmBilletera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmBilletera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmBilletera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmBilletera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmBilletera().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCompra;
    private javax.swing.JButton btnVenta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblDatos;
    private javax.swing.JTextField txtAcumulado;
    private javax.swing.JTextField txtMonto;
    private javax.swing.JTextField txtMontoFijo;
    // End of variables declaration//GEN-END:variables
}
