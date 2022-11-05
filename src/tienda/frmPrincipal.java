package tienda;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class frmPrincipal extends javax.swing.JFrame {
    
    public Connection con;//Variable para conectar con la base de datos
    public ArrayList<Proveedor> lstProveedores;//Almacena todos los proveedores de la db para posteriormente rellenar el combobox con esa información
    
    public frmPrincipal() {
        initComponents();
        Conectar();//Conecta el formulario a la base de datos
        CargarDatos();//Carga los datos de la db en la tabla
        lstProveedores = new ArrayList<>();
        RellenarCombo();//Rellena el combobox con la información de la lista "lstProveedores"
        txtId.setEditable(false);//No permite que se pueda editar el valor del ID para evitar errores
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTablaDatos = new javax.swing.JTable();
        lblTitulo = new javax.swing.JLabel();
        btnEditar = new javax.swing.JButton();
        txtId = new javax.swing.JTextField();
        btnEliminar = new javax.swing.JButton();
        txtNombre = new javax.swing.JTextField();
        txtPrecio = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        cmbProveedores = new javax.swing.JComboBox<>();
        btnNuevoProveedor = new javax.swing.JButton();
        btnRecargar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        jTablaDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Precio $", "Proveedor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTablaDatos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablaDatosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTablaDatos);
        if (jTablaDatos.getColumnModel().getColumnCount() > 0) {
            jTablaDatos.getColumnModel().getColumn(0).setResizable(false);
            jTablaDatos.getColumnModel().getColumn(1).setResizable(false);
            jTablaDatos.getColumnModel().getColumn(2).setResizable(false);
            jTablaDatos.getColumnModel().getColumn(3).setResizable(false);
        }

        lblTitulo.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lblTitulo.setText("LISTADO DE PRODUCTOS");

        btnEditar.setBackground(new java.awt.Color(23, 173, 235));
        btnEditar.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btnEditar.setForeground(new java.awt.Color(255, 255, 255));
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit.png"))); // NOI18N
        btnEditar.setText("EDITAR NOMBRE");
        btnEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        txtId.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ID PRODUCTO:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 1, 12))); // NOI18N

        btnEliminar.setBackground(new java.awt.Color(76, 8, 8));
        btnEliminar.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bin.png"))); // NOI18N
        btnEliminar.setText("ELIMINAR");
        btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        txtNombre.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "NOMBRE PRODUCTO:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 1, 12))); // NOI18N

        txtPrecio.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "PRECIO DEL PRODUCTO:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 1, 12))); // NOI18N

        btnGuardar.setBackground(new java.awt.Color(28, 109, 66));
        btnGuardar.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bookmark.png"))); // NOI18N
        btnGuardar.setText("AGREGAR");
        btnGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        cmbProveedores.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione..." }));
        cmbProveedores.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "PROVEEDOR:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 1, 12))); // NOI18N

        btnNuevoProveedor.setBackground(new java.awt.Color(0, 102, 51));
        btnNuevoProveedor.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btnNuevoProveedor.setForeground(new java.awt.Color(255, 255, 255));
        btnNuevoProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/global.png"))); // NOI18N
        btnNuevoProveedor.setText("NUEVO PROVEEDOR");
        btnNuevoProveedor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNuevoProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoProveedorActionPerformed(evt);
            }
        });

        btnRecargar.setBackground(new java.awt.Color(23, 173, 235));
        btnRecargar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/recargar.png"))); // NOI18N
        btnRecargar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRecargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRecargarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblTitulo)
                        .addGap(180, 180, 180))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombre, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtId, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtPrecio)
                            .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbProveedores, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnNuevoProveedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 548, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRecargar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo)
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnNuevoProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(115, 115, 115))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRecargar))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    //************************ EVENTO DE SELECCION DENTRO DE LA TABLA ****************
    private void jTablaDatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablaDatosMouseClicked
        // TODO add your handling code here:
        //Cuando el usuario seleccione un registro de la tabla, todos esos datos serán llevados a las cajas de texto
        //y al combobox del formulario para que se pueda editar o eliminar
        String id = jTablaDatos.getValueAt(jTablaDatos.getSelectedRow(), 0).toString();
        String nombre = jTablaDatos.getValueAt(jTablaDatos.getSelectedRow(), 1).toString();
        String precio = jTablaDatos.getValueAt(jTablaDatos.getSelectedRow(), 2).toString();
        String proveedor = jTablaDatos.getValueAt(jTablaDatos.getSelectedRow(), 3).toString();
        txtId.setText(id);
        txtNombre.setText(nombre);
        txtPrecio.setText(precio);
        //Verifica si el nombre de proveedor del registro seleeccionado está como item seleecionado del combobox, sino es así, entonces 
        //lo seleeciona
        if (!(proveedor.equals(cmbProveedores.getSelectedItem()))) {
            cmbProveedores.setSelectedItem(proveedor);
        }
    }//GEN-LAST:event_jTablaDatosMouseClicked
    
    //*********************** EVENTO DE CLICK AL BOTON EDITAR **************************
    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        /**
         * Verifica que las cajas de texto que almacenan el "ID" y "Nombre" no estén vacíos, ya que serán utilizados para
         *poder actualizar el registro
        */
        if (!(("".equals(txtNombre.getText()) || ("".equals(txtId.getText()))))) {
            //Permite verificar si el usuario está seguro que desea modificar el registro
            int verificar = JOptionPane.showConfirmDialog(null, "¿ESTA SEGURO QUE DESEA MODIFICAR EL REGISTRO?", "CONFIRME.", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (verificar == JOptionPane.YES_OPTION) {
                try {
                    // TODO add your handling code here:
                    String nombre = txtNombre.getText();//Almacena el nombre ya será el campo que se modificará
                    int id = Integer.parseInt(txtId.getText());//Almacena el id ya que pormedio de el se hará la actualización
                    PreparedStatement ptmEdit = con.prepareStatement("UPDATE tbl_producto SET nombreproducto = ? WHERE idproducto = ?");//Consulta
                    //Se insertan los campos necesarios para hacer la actualización
                    ptmEdit.setString(1, nombre);
                    ptmEdit.setInt(2, id);

                    int respuesta = ptmEdit.executeUpdate();//Retorna la cantidad de registros afectados con la ejecución de la consulta

                    if (respuesta > 0) {
                        //Si "respuesta" contiene un número mayor a 0 significa que sí se pudo hacer el UPDATE ya que hay registros afectados
                        //entonces se lo hacemos saber al usuario
                        JOptionPane.showMessageDialog(null, "EL REGISTRO FUE ACTUALIZADO EXITOSAMENTE.","EXITO.", JOptionPane.INFORMATION_MESSAGE);
                        CargarDatos();//Recarga los datos en la tabla
                        //Limpia las cajas de texto y el combobox
                        LimpiarTodo();
                    }
                    else{
                        //Si "respuesta" contiene un valor menor o igual que 0 significa que no se pudo actualizar el registro
                        //entonces se lo hacemos saber al usuario
                        JOptionPane.showMessageDialog(null, "PARECE QUE OCURRIO UN ERROR AL ACTUALIZAR EL REGISTRO, POR FAVOR INTENTELO DE NUEVO.","ERROR.", JOptionPane.ERROR);
                    }
                } catch (SQLException ex) {
                    //Si ocurre cualquier error al momento de actualizar el registro, se lo indicamos al usuario
                    JOptionPane.showMessageDialog(null, "PARECE QUE OCURRIO UN ERROR AL ACTUALIZAR EL REGISTRO, POR FAVOR INTENTELO DE NUEVO.","ERROR.", JOptionPane.ERROR);
                    System.out.println("Error: " + ex);
                }
            }
        }
        else{
            //Si las cajas de texto necesarias están vacías, le indicamos al usuario que tiene que llenarlas
            JOptionPane.showMessageDialog(null, "POR FAVOR, ASEGURESE DE HABER SELECCIONADO EL REGISTRO QUE DESEA ACTUALIZAR...","ERROR.", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEditarActionPerformed
    
    //*********************** EVENTO DE CLICK AL BOTON ELIMINAR **************************
    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        /**
         * Verifica que la caja de texto que almacena el "ID" no esté vacía, ya que será utilizada para
         *poder eliminar el registro
        */
        if (!("".equals(txtId.getText()))) {
            //Permite verificar si el usuario está seguro que desea eliminar el registro
            int verificar = JOptionPane.showConfirmDialog(null, "¿ESTA SEGURO QUE DESEA ELIMINAR EL REGISTRO?", "CONFIRME.", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (verificar == JOptionPane.YES_OPTION) {
                try {
                    int id = Integer.parseInt(txtId.getText());
                    PreparedStatement ptmElim = con.prepareStatement("DELETE FROM tbl_producto WHERE idproducto = ?");
                    ptmElim.setInt(1, id);

                    int respuesta = ptmElim.executeUpdate();//Retorna la cantidad de registros afectados 

                    if (respuesta > 0) {
                        JOptionPane.showMessageDialog(null, "EL REGISTRO FUE ELIMINADO EXITOSAMENTE.","EXITO.", JOptionPane.INFORMATION_MESSAGE);
                        CargarDatos();
                        LimpiarTodo();//Limpia las cajas de texto y el combobox
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "PARECE QUE OCURRIO UN ERROR AL ELIMINAR EL REGISTRO, POR FAVOR INTENTELO DE NUEVO.","ERROR.", JOptionPane.ERROR);
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "PARECE QUE OCURRIO UN ERROR AL ELIMINAR EL REGISTRO, POR FAVOR INTENTELO DE NUEVO.","ERROR.", JOptionPane.ERROR);
                    System.out.println("Excepcion -> " + ex);
                }
                txtId.setText("");
                txtNombre.setText("");
                txtPrecio.setText("");
                cmbProveedores.setSelectedItem("Seleccione...");
            }
        } else {
            JOptionPane.showMessageDialog(null, "POR FAVOR, ASEGURESE DE HABER SELECCIONADO EL REGISTRO QUE DESEA ELIMINAR...","ERROR.", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    //*********************** EVENTO DE CLICK AL BOTON GUARDAR **************************
    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        if (!(("".equals(txtNombre.getText())) || ("".equals(txtPrecio.getText())) || ("Seleccione...".equals(cmbProveedores.getSelectedItem())))) {
            try {
                String producto = txtNombre.getText();
                double precio = Double.parseDouble(txtPrecio.getText());
                String proveedor = cmbProveedores.getSelectedItem().toString();
                int id=0;
                for(Proveedor item: lstProveedores){
                    if (item.nombreProveedor.equals(proveedor)) {
                        id = item.idProveedor;
                        break;
                    }
                }
                
                PreparedStatement ptmInsert = con.prepareStatement("INSERT INTO tbl_producto(nombreproducto, precio, idproveedor) VALUES(?, ?, ?)");
                ptmInsert.setString(1, producto);
                ptmInsert.setDouble(2, precio);
                ptmInsert.setInt(3, id);
                
                int respuesta = ptmInsert.executeUpdate();
                
                if (respuesta > 0) {
                    JOptionPane.showMessageDialog(null, "EL REGISTRO FUE AGREGADO EXITOSAMENTE.","EXITO.", JOptionPane.INFORMATION_MESSAGE);
                    CargarDatos();
                    LimpiarTodo();//Limpia las cajas de texto y el combobox
                } else {
                    JOptionPane.showMessageDialog(null, "PARECE QUE OCURRIO UN ERROR AL AGREGAR EL REGISTRO, POR FAVOR INTENTELO DE NUEVO.","ERROR.", JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException ex) {
                //Logger.getLogger(frmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "PARECE QUE OCURRIO UN ERROR AL AGREGAR EL REGISTRO, POR FAVOR INTENTELO DE NUEVO.","ERROR.", JOptionPane.ERROR_MESSAGE);
                System.out.println("Error: " + ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "ASEGURESE DE HABER LLENADO COMPLETMENTE EL FORMULARIO.","ERROR.", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnGuardarActionPerformed
    
    //********************** EVENTO DE CLICK AL FORMULARIO *******************
    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        // TODO add your handling code here:
        //Limpia todas las cajas de texto y selecciona el item "Seleccione..." del combobox
        LimpiarTodo();
    }//GEN-LAST:event_formMouseClicked

    //********************** EVENTO DE CLICK AL BOTON NUEVO PROVEEDOR ****************
    private void btnNuevoProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoProveedorActionPerformed
        // TODO add your handling code here:
        NuevoProveedor formProveedor = new NuevoProveedor();
        formProveedor.show();
    }//GEN-LAST:event_btnNuevoProveedorActionPerformed

    private void btnRecargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRecargarActionPerformed
        // TODO add your handling code here:
        CargarDatos();
        RellenarCombo();
    }//GEN-LAST:event_btnRecargarActionPerformed

    
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
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmPrincipal().setVisible(true);
            }
        });
    }
    
    public void Conectar(){
        String url = "jdbc:postgresql://localhost:5432/db_tienda";//La base de datos se maneja de manera local en el puerto 5432 de PostgreSQL
        try {
            //*************************************************************************************************************************************************
                                            //"url", "user", "password"
            con= DriverManager.getConnection(url,"user", "password");//<- **************** AQUI VA SU CONTRASEÑA **************************************
            //*************************************************************************************************************************************************
            System.out.println("EL FORMULARIO PRINCIPAL SE HA CONECATADO A LA BASE DE DATOS");
        } catch (SQLException ex) {
            //Logger.getLogger(ConexioDB_CLASE.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ERROR AL REALIZAR LA CONEXION -> "+ex);
        }  
    }
    
    public void CargarDatos(){
        DefaultTableModel modelo = new DefaultTableModel();
        modelo = (DefaultTableModel)jTablaDatos.getModel();
        modelo.setRowCount(0);//Limpia todas los registros de la tabla (Basicamente le indica que no quiere ninguna fila)
        
        try {
            Statement smt = con.createStatement();
            String consulta = "SELECT idproducto, nombreproducto, precio, nombreproveedor FROM tbl_producto INNER JOIN tbl_proveedor\n" +
                              "ON tbl_producto.idproveedor = tbl_proveedor.idproveedor";
            ResultSet resultado = smt.executeQuery(consulta);
            while(resultado.next()){
                modelo.addRow(new Object[]{resultado.getInt("idproducto"),resultado.getString("nombreproducto"), resultado.getDouble("precio"), 
                    resultado.getString("nombreproveedor")});
            }
            jTablaDatos.setModel(modelo);
        } catch (SQLException ex) {
            //Logger.getLogger(ConexioDB_CLASE.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ERROR AL EJECUTAR LA CONSULTA ->"+ex);
        }
    }
    
    public void RellenarCombo(){
        
        cmbProveedores.removeAllItems();
        lstProveedores.removeAll(lstProveedores);
        cmbProveedores.addItem("Seleccione...");
        
        try {
            
            Statement stm = con.createStatement();
            String consulta = "SELECT idproveedor, nombreproveedor FROM tbl_proveedor";
                
            ResultSet respuesta = stm.executeQuery(consulta);
                
            while(respuesta.next()){
                Proveedor proveedorObjeto = new Proveedor();
                proveedorObjeto.idProveedor = respuesta.getInt("idproveedor");
                proveedorObjeto.nombreProveedor = respuesta.getString("nombreproveedor");
                    
                lstProveedores.add(proveedorObjeto);
            }
                
            for (Proveedor item: lstProveedores){
                cmbProveedores.addItem(item.toString());
            }
        } catch (SQLException ex) {
            Logger.getLogger(frmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void LimpiarTodo() {
        txtId.setText("");
        txtNombre.setText("");
        txtPrecio.setText("");
        cmbProveedores.setSelectedItem("Seleccione...");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevoProveedor;
    private javax.swing.JButton btnRecargar;
    private javax.swing.JComboBox<String> cmbProveedores;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTablaDatos;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecio;
    // End of variables declaration//GEN-END:variables
}
