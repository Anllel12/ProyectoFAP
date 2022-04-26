/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/Application.java to edit this template
 */
package ventana;
import database.Query;
import database.creationDB;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author anlle
 */
public class menu extends javax.swing.JFrame {

    creationDB db = new creationDB();
    Query q = new Query();
    AddStock addStock = new AddStock(this);
    AddClient addClient = new AddClient(this);
    AddUser addUser = new AddUser(this);
    
    String id = ""; // Valor para guardar el id pinchado en la tabla
    int row = 0;
    int col = 0;
    
    public menu() {
        initComponents();
        db.conectar();
        q.tableStock(jTableStock); // Muestra la informacion en la tabla
        q.tableUser(jTableUser);
        q.tableClient(jTableClient); // Muestra la informacion en la tabla
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableStock = new javax.swing.JTable();
        jButtonAddStock = new javax.swing.JButton();
        jButtonDeleteStock = new javax.swing.JButton();
        jButtonEditStock = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableClient = new javax.swing.JTable();
        jButtonDeleteCient = new javax.swing.JButton();
        jButtonEditClient = new javax.swing.JButton();
        jButtonAddClient = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTableProvider = new javax.swing.JTable();
        jButtonDeleteProvider = new javax.swing.JButton();
        jButtonEditProvider = new javax.swing.JButton();
        jButtonAddProvider = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableUser = new javax.swing.JTable();
        jButtonDeleteUser = new javax.swing.JButton();
        jButtonEditUser = new javax.swing.JButton();
        jButtonAddUser = new javax.swing.JButton();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setPreferredSize(new java.awt.Dimension(747, 400));

        jTableStock.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Cantidad", "Unidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableStock.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableStockMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTableStock);

        jButtonAddStock.setText("A�adir");
        jButtonAddStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddStockActionPerformed(evt);
            }
        });

        jButtonDeleteStock.setText("Eliminar");
        jButtonDeleteStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteStockActionPerformed(evt);
            }
        });

        jButtonEditStock.setText("Editar");
        jButtonEditStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditStockActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 761, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonDeleteStock)
                .addGap(18, 18, 18)
                .addComponent(jButtonEditStock)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonAddStock)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAddStock)
                    .addComponent(jButtonDeleteStock)
                    .addComponent(jButtonEditStock))
                .addContainerGap(70, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Stock", jPanel1);

        jPanel2.setPreferredSize(new java.awt.Dimension(747, 440));

        jTableClient.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Apellido", "Correo electronico"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableClient.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableClientMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableClient);

        jButtonDeleteCient.setText("Eliminar");
        jButtonDeleteCient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteCientActionPerformed(evt);
            }
        });

        jButtonEditClient.setText("Editar");
        jButtonEditClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditClientActionPerformed(evt);
            }
        });

        jButtonAddClient.setText("A�adir");
        jButtonAddClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddClientActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 761, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonDeleteCient)
                .addGap(18, 18, 18)
                .addComponent(jButtonEditClient)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonAddClient)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAddClient)
                    .addComponent(jButtonDeleteCient)
                    .addComponent(jButtonEditClient))
                .addGap(0, 70, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Clientes", jPanel2);

        jTableProvider.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Correo", "Nombre", "Telefono"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableProvider.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableProviderMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTableProvider);

        jButtonDeleteProvider.setText("Eliminar");
        jButtonDeleteProvider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteProviderActionPerformed(evt);
            }
        });

        jButtonEditProvider.setText("Editar");
        jButtonEditProvider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditProviderActionPerformed(evt);
            }
        });

        jButtonAddProvider.setText("A�adir");
        jButtonAddProvider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddProviderActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 761, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonDeleteProvider)
                .addGap(18, 18, 18)
                .addComponent(jButtonEditProvider)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonAddProvider)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonDeleteProvider)
                    .addComponent(jButtonEditProvider)
                    .addComponent(jButtonAddProvider))
                .addGap(0, 67, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Proveedores", jPanel4);

        jTableUser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Correo", "Nombre", "Apellido", "Contrase�a"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableUserMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTableUser);
        if (jTableUser.getColumnModel().getColumnCount() > 0) {
            jTableUser.getColumnModel().getColumn(2).setHeaderValue("Apellido");
            jTableUser.getColumnModel().getColumn(3).setHeaderValue("Contrase�a");
        }

        jButtonDeleteUser.setText("Eliminar");
        jButtonDeleteUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteUserActionPerformed(evt);
            }
        });

        jButtonEditUser.setText("Editar");
        jButtonEditUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditUserActionPerformed(evt);
            }
        });

        jButtonAddUser.setText("A�adir");
        jButtonAddUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddUserActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 761, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonDeleteUser)
                .addGap(18, 18, 18)
                .addComponent(jButtonEditUser)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonAddUser)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonDeleteUser)
                    .addComponent(jButtonEditUser)
                    .addComponent(jButtonAddUser))
                .addGap(0, 67, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Usuarios", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAddStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddStockActionPerformed
        addStock.setVisible(true);
    }//GEN-LAST:event_jButtonAddStockActionPerformed

    private void jTableStockMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableStockMouseClicked
        JTable source = (JTable) evt.getSource();
        row = source.rowAtPoint(evt.getPoint()); // Guardamos la fila para saber el id pinchado
        col = source.columnAtPoint(evt.getPoint()); // Guardamos la columna
        id = source.getModel().getValueAt(row, 0).toString();
    }//GEN-LAST:event_jTableStockMouseClicked

    private void jButtonDeleteStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteStockActionPerformed
        q.delete("stock", id);
        updateTableStock();
    }//GEN-LAST:event_jButtonDeleteStockActionPerformed

    private void jButtonEditStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditStockActionPerformed
        if(jTableStock.isEditing()){ // comprueba si esta editando la tabla
            JOptionPane.showMessageDialog(null, "Deje de editar el campo (Pulse ENTER para dejar de editar).", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        else{
            q.updateStock(col,id, ((DefaultTableModel)jTableStock.getModel()).getValueAt(row, col));
        }
    }//GEN-LAST:event_jButtonEditStockActionPerformed
    
    //funciones tabla clientes, sacado del codigo ya ense�ado 
    private void jButtonDeleteCientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteCientActionPerformed
        q.delete("clientes", id);
        updateTableClient();
    }//GEN-LAST:event_jButtonDeleteCientActionPerformed

    private void jButtonEditClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditClientActionPerformed
        if(jTableClient.isEditing()){ // comprueba si esta editando la tabla
            JOptionPane.showMessageDialog(null, "Deje de editar el campo (Pulse ENTER para dejar de editar).", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        else{
            q.updateClient(col,id, ((DefaultTableModel)jTableClient.getModel()).getValueAt(row, col));
        }
    }//GEN-LAST:event_jButtonEditClientActionPerformed

    private void jButtonAddClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddClientActionPerformed
        addClient.setVisible(true);
    }//GEN-LAST:event_jButtonAddClientActionPerformed

    private void jTableClientMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableClientMouseClicked
        JTable source = (JTable) evt.getSource();
        row = source.rowAtPoint(evt.getPoint()); // Guardamos la fila para saber el id pinchado
        col = source.columnAtPoint(evt.getPoint()); // Guardamos la columna
        id = source.getModel().getValueAt(row, 0).toString();
    }//GEN-LAST:event_jTableClientMouseClicked

    private void jButtonDeleteUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteUserActionPerformed
        q.delete("usuarios", id);
        updateTableUser();
    }//GEN-LAST:event_jButtonDeleteUserActionPerformed

    private void jButtonEditUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditUserActionPerformed
        if(jTableUser.isEditing()){ // comprueba si esta editando la tabla
            JOptionPane.showMessageDialog(null, "Deje de editar el campo (Pulse ENTER para dejar de editar).", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        else{
            q.updateUser(col,id, ((DefaultTableModel)jTableUser.getModel()).getValueAt(row, col));
        }
    }//GEN-LAST:event_jButtonEditUserActionPerformed

    private void jButtonAddUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddUserActionPerformed
        addUser.setVisible(true);
    }//GEN-LAST:event_jButtonAddUserActionPerformed

    private void jTableUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableUserMouseClicked
        JTable source = (JTable) evt.getSource();
        row = source.rowAtPoint(evt.getPoint()); // Guardamos la fila para saber el id pinchado
        col = source.columnAtPoint(evt.getPoint()); // Guardamos la columna
        id = source.getModel().getValueAt(row, 0).toString();
    }//GEN-LAST:event_jTableUserMouseClicked

    private void jTableProviderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableProviderMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTableProviderMouseClicked

    private void jButtonDeleteProviderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteProviderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonDeleteProviderActionPerformed

    private void jButtonEditProviderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditProviderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonEditProviderActionPerformed

    private void jButtonAddProviderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddProviderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonAddProviderActionPerformed
    
    public void updateTableStock(){ // actualizo la tabla
        while(jTableStock.getRowCount() != 0) ((DefaultTableModel)jTableStock.getModel()).removeRow(0); // Eliminamos las columnas para que no se repitan los valores ya guardados
        
        q.tableStock(jTableStock);
    }
    
    //funciones tabla clientes, sacado del codigo ya ense�ado
    public void updateTableClient(){ // actualizo la tabla
        while(jTableClient.getRowCount() != 0) ((DefaultTableModel)jTableClient.getModel()).removeRow(0); // Eliminamos las columnas para que no se repitan los valores ya guardados
        
        q.tableClient(jTableClient);
    }
    
    public void updateTableUser(){ // actualizo la tabla
        while(jTableUser.getRowCount() != 0) ((DefaultTableModel)jTableUser.getModel()).removeRow(0); // Eliminamos las columnas para que no se repitan los valores ya guardados
        
        q.tableUser(jTableUser);
    }
    
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
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAddClient;
    private javax.swing.JButton jButtonAddProvider;
    private javax.swing.JButton jButtonAddStock;
    private javax.swing.JButton jButtonAddUser;
    private javax.swing.JButton jButtonDeleteCient;
    private javax.swing.JButton jButtonDeleteProvider;
    private javax.swing.JButton jButtonDeleteStock;
    private javax.swing.JButton jButtonDeleteUser;
    private javax.swing.JButton jButtonEditClient;
    private javax.swing.JButton jButtonEditProvider;
    private javax.swing.JButton jButtonEditStock;
    private javax.swing.JButton jButtonEditUser;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTableClient;
    private javax.swing.JTable jTableProvider;
    private javax.swing.JTable jTableStock;
    private javax.swing.JTable jTableUser;
    // End of variables declaration//GEN-END:variables
}
