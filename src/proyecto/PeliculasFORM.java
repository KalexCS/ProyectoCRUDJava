
package proyecto;


import java.awt.Color;
import java.awt.event.KeyEvent;
import java.sql.DriverManager;
import javax.swing.border.LineBorder;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;


public class PeliculasFORM extends javax.swing.JFrame {  

    public static final String URL = "jdbc:sqlite:peliculas.db";
    
    PreparedStatement ps;
    ResultSet rs;
    
     public static Connection getConection() {
        Connection con = null;

        try {
            Class.forName("org.sqlite.JDBC");
            con = (Connection) DriverManager.getConnection(URL);

        } catch (Exception e) {
            System.out.println(e);
        }
        return con;
    }
    
    private void limpiarCajas(){
     
    tfTitulo.setText(null);
    cbGenero.setSelectedIndex(0);
    tfDuracion.setText(null);
    taDescripcion.setText(null);
    cbVista.setText("Vista");       
 }
    private void llenarLista(){

    Connection con = null;    
    
        DefaultListModel m = new DefaultListModel();
        try {        
            con = getConection();
            ps = con.prepareStatement("SELECT * FROM peliculas");
            rs = ps.executeQuery();
            
            while (rs.next()){
                String title = rs.getString("titulo");
                m.addElement(title);
            }
            lLista.setModel(m);
            
        } catch (Exception e){
          JOptionPane.showMessageDialog (null, e);
        }
    }
    private void buscarLista(){
    
    Connection con = null;    
    
        DefaultListModel m = new DefaultListModel();
        String sel = tfBuscar.getText();
        
        try {        
            con = getConection();
            ps = con.prepareStatement("SELECT * FROM peliculas");
            rs = ps.executeQuery();
                     
            m.addElement(sel);
            
            lLista.setModel(m);
            con.close();
            
        } catch (Exception e){
          JOptionPane.showMessageDialog (null, e);
        }
    }
        
    public ArrayList<String> arrayLista() {
        Connection con = null;
        
        ArrayList<String> arrayLista = new ArrayList<>();
        try {
            con = getConection();
            ps = con.prepareStatement("SELECT * FROM peliculas");
            rs = ps.executeQuery();
            
            while (rs.next()){
                String title = rs.getString("titulo");
                arrayLista.add(title);
            }
        }catch (SQLException e){
                 System.out.println(e.getMessage());
             }
        
        return arrayLista;
    }   
    
    public PeliculasFORM() {
        initComponents(); 
    }
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titulo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cbVista = new javax.swing.JCheckBox();
        bGuardar = new javax.swing.JButton();
        bModificar = new javax.swing.JButton();
        bEliminar = new javax.swing.JButton();
        tfTitulo = new javax.swing.JTextField();
        tfDuracion = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cbGenero = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lLista = new javax.swing.JList<>();
        tfBuscar = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        bCargarLista = new javax.swing.JButton();
        jSP = new javax.swing.JScrollPane();
        taDescripcion = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Lista de películas");
        setBackground(new java.awt.Color(51, 153, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        setForeground(new java.awt.Color(153, 204, 255));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        titulo.setIcon(new javax.swing.ImageIcon("D:\\Curso Analista Java\\Proyecto\\film-roll-side-view_icon-icons.com_56303.png")); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Título (obligatorio):");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Género:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Duración (minutos):");

        cbVista.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbVista.setText("Vista");
        cbVista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbVistaActionPerformed(evt);
            }
        });

        bGuardar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        bGuardar.setText("Guardar");
        bGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bGuardarMouseClicked(evt);
            }
        });
        bGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bGuardarActionPerformed(evt);
            }
        });

        bModificar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        bModificar.setText("Modificar");
        bModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bModificarActionPerformed(evt);
            }
        });

        bEliminar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        bEliminar.setText("Eliminar");
        bEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEliminarActionPerformed(evt);
            }
        });

        tfTitulo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tfTitulo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfTituloFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfTituloFocusLost(evt);
            }
        });

        tfDuracion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Descripción:");

        cbGenero.setEditable(true);
        cbGenero.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbGenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona género", "Acción", "Ciencia ficción", "Comedia", "Drama", "Fantástico", "Miedo" }));
        cbGenero.setToolTipText("");
        cbGenero.setName(""); // NOI18N
        cbGenero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbGeneroActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Listado de películas:");

        lLista.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lLista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lListaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(lLista);

        tfBuscar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tfBuscar.setForeground(new java.awt.Color(102, 102, 102));
        tfBuscar.setText("Busca por título y pulsa ENTER...");
        tfBuscar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfBuscarFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfBuscarFocusLost(evt);
            }
        });
        tfBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfBuscarKeyPressed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("min.");

        bCargarLista.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        bCargarLista.setText("Cargar lista completa");
        bCargarLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCargarListaActionPerformed(evt);
            }
        });

        taDescripcion.setColumns(20);
        taDescripcion.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        taDescripcion.setLineWrap(true);
        taDescripcion.setRows(5);
        taDescripcion.setWrapStyleWord(true);
        jSP.setViewportView(taDescripcion);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(bGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSP, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel1)
                                .addComponent(jLabel5)
                                .addComponent(tfTitulo)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addComponent(cbGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(tfDuracion, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel6))))
                                .addComponent(cbVista, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel4)
                        .addComponent(jScrollPane1)
                        .addComponent(tfBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(bEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(bCargarLista, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(38, 38, 38))
            .addGroup(layout.createSequentialGroup()
                .addGap(176, 176, 176)
                .addComponent(titulo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titulo)
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tfTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(tfDuracion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSP, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbVista, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(bCargarLista, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 40, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbGeneroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbGeneroActionPerformed
        
    }//GEN-LAST:event_cbGeneroActionPerformed

    private void tfBuscarFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfBuscarFocusGained
        tfBuscar.setText("");
        tfBuscar.setForeground(Color.BLACK);
    }//GEN-LAST:event_tfBuscarFocusGained

    private void tfBuscarFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfBuscarFocusLost
        if("".equals(tfBuscar.getText())){
            tfBuscar.setText("Busca por título y pulsa ENTER...");
            tfBuscar.setForeground(Color.GRAY);
        }    
        if("Busca por título y pulsa ENTER...".equals(tfBuscar.getText())){
            tfBuscar.setText("Busca por título y pulsa ENTER...");
            tfBuscar.setForeground(Color.GRAY);
        } 
    }//GEN-LAST:event_tfBuscarFocusLost

    private void cbVistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbVistaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbVistaActionPerformed

    private void tfTituloFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfTituloFocusLost
        if (tfTitulo.getText().equals("")){
            tfTitulo.setText("Este campo es obligatorio.");
            tfTitulo.setForeground(Color.RED);
            tfTitulo.setBorder(new LineBorder(Color.RED));
        
        } else if (!"".equals(tfTitulo.getText())){
           tfTitulo.setForeground(Color.BLACK);
           tfTitulo.setBorder(new LineBorder (Color.GRAY)); 
        }
        
    }//GEN-LAST:event_tfTituloFocusLost

    private void tfTituloFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfTituloFocusGained
        if("Este campo es obligatorio.".equals(tfTitulo.getText())){
        tfTitulo.setText(null);
        }
        if (tfTitulo.getText().equals("")){
            tfTitulo.setText("");
            tfTitulo.setForeground(Color.BLACK);
            tfTitulo.setBorder(new LineBorder (Color.GRAY));
        }
    }//GEN-LAST:event_tfTituloFocusGained

    private void bGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bGuardarMouseClicked
        String nombre = tfTitulo.getText();
        if (nombre.equals("")) {
            JOptionPane.showMessageDialog(null, "El nombre es obligatorio.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (tfDuracion.getText().equals("")) {
            tfDuracion.setText("null");
        }
    }//GEN-LAST:event_bGuardarMouseClicked

    private void bEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEliminarActionPerformed
               
        Connection con = null;
        
        try{              
            con = getConection();
            ps = con.prepareStatement("DELETE FROM peliculas WHERE titulo=?");
            ps.setString(1, tfTitulo.getText());
            
            if (JOptionPane.showConfirmDialog(null, "Se eliminará " + "'" + tfTitulo.getText() + "'" + " de la lista."
                    + " ¿Estás seguro?", "AVISO",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                int res = ps.executeUpdate(); 
                JOptionPane.showMessageDialog(null, "Pelicula Eliminada.");
                limpiarCajas();
            } else {
                limpiarCajas();
            }
            llenarLista();
            con.close();
    
        } catch(Exception e){
            System.err.println(e);
            JOptionPane.showMessageDialog(null, "No se ha encontrado la película.");
        }
    }//GEN-LAST:event_bEliminarActionPerformed

    private void bModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bModificarActionPerformed
         
        Connection con = null;
        
        try{
            
            con = getConection();
            ps = con.prepareStatement("UPDATE peliculas SET genero=?, duracion=?, descripcion=?, vista=? WHERE titulo=?");
            
            ps.setString(1, cbGenero.getSelectedItem().toString());
            ps.setString(2, tfDuracion.getText());
            ps.setString(3, taDescripcion.getText());    
            if (cbVista.isSelected()){
                ps.setString(4, String.valueOf(1));
            } else {
                ps.setString(4, String.valueOf(0));
            }
            ps.setString(5, tfTitulo.getText());
            
            int res = ps.executeUpdate();
            
            if(res > 0){
                JOptionPane.showMessageDialog(null, "Película modificada.");
                limpiarCajas();
            } else {
                 JOptionPane.showMessageDialog(null, "Error al modificar película.");
                 limpiarCajas();
            }
            
            llenarLista();
            con.close();
            
        } catch(Exception e){
            System.err.println(e);
        }
    }//GEN-LAST:event_bModificarActionPerformed

    private void bGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bGuardarActionPerformed
               
        Connection con = null;       
        arrayLista();
        
        for(int i = 0; i < arrayLista().size(); i++){
                String value = arrayLista().get(i);
                if (tfTitulo.getText().equals (value)){
            
                    JOptionPane.showMessageDialog(null, "Esa película ya está registrada");
                    return;
                }
            } 
        
        if(!"Este campo es obligatorio.".equals(tfTitulo.getText())){              
            try {            
           
           con = getConection();
           
            ps = con.prepareStatement("INSERT INTO peliculas (titulo, genero, duracion, descripcion, vista) VALUES(?,?,?,?,?) ");
            ps.setString(1, tfTitulo.getText());
            ps.setString(2, cbGenero.getSelectedItem().toString());
            ps.setString(3, tfDuracion.getText());
            ps.setString(4, taDescripcion.getText());
            if (cbVista.isSelected()){
                ps.setString(5, String.valueOf(1));
            } else {
                ps.setString(5, String.valueOf(0));
            }
            
            ps.executeUpdate();
                         
            llenarLista();
       
        } catch(Exception e){
            System.err.println(e);
        }
                
            JOptionPane.showMessageDialog(null, "Película guardada.");

        } else if("Este campo es obligatorio.".equals(tfTitulo.getText())) {
            JOptionPane.showMessageDialog(null, "Error al guardar película.");
            
        } else {
            JOptionPane.showMessageDialog(null, "Error al guardar película.");
        }   
        
        
    }//GEN-LAST:event_bGuardarActionPerformed

    private void tfBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfBuscarKeyPressed
         
        switch (evt.getKeyCode()) {
            case KeyEvent.VK_ENTER: {
                 String sel = tfBuscar.getText();
                
                try {
                    if (arrayLista().contains(sel)){

                    buscarLista();       
                
                    } else {
                        JOptionPane.showMessageDialog(null, "No existe una película con ese parámetro.");
                    }
 
                } catch(Exception e){
                    System.err.println(e);
                }
    
            break;  
            }        
    }
    }//GEN-LAST:event_tfBuscarKeyPressed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        llenarLista();
    }//GEN-LAST:event_formWindowOpened

    private void lListaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lListaMouseClicked

        String sel = (String)lLista.getSelectedValue();
        
        try {            
            Connection con = (Connection) DriverManager.getConnection(URL);
            
            ps = con.prepareStatement("SELECT * FROM peliculas WHERE titulo = ?");
            ps.setString (1, sel);
            rs = ps.executeQuery();
            if (rs.next()){
                String addTitulo = rs.getString("titulo");
                tfTitulo.setText(addTitulo);
                String addGenero = rs.getString("genero");
                cbGenero.setSelectedItem(addGenero);
                String addDuracion = rs.getString("duracion");
                tfDuracion.setText(addDuracion);
                String addDescripcion = rs.getString("descripcion");
                taDescripcion.setText(addDescripcion);
                int addVista = rs.getInt("vista");

                if (addVista == 1) {  
                   cbVista.setSelected(true);
                } else {
                   cbVista.setSelected(false);
                }                 
            tfTitulo.setForeground(Color.BLACK);
            tfTitulo.setBorder(new LineBorder (Color.GRAY)); 
            }con.close();
        } catch (Exception e){
            System.err.println(e);           
        }
        
    }//GEN-LAST:event_lListaMouseClicked

    private void bCargarListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCargarListaActionPerformed
        llenarLista();
    }//GEN-LAST:event_bCargarListaActionPerformed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PeliculasFORM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PeliculasFORM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PeliculasFORM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PeliculasFORM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PeliculasFORM().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bCargarLista;
    private javax.swing.JButton bEliminar;
    private javax.swing.JButton bGuardar;
    private javax.swing.JButton bModificar;
    private javax.swing.JComboBox<String> cbGenero;
    private javax.swing.JCheckBox cbVista;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jSP;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> lLista;
    private javax.swing.JTextArea taDescripcion;
    private javax.swing.JTextField tfBuscar;
    private javax.swing.JTextField tfDuracion;
    private javax.swing.JTextField tfTitulo;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
