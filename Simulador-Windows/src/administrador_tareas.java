import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author FEscobozaM
 */
public class administrador_tareas extends javax.swing.JInternalFrame {

    private DefaultTableModel modelo;
    
    public administrador_tareas() {
        initComponents();
        
        txt_cant_procesos.setFocusable(false);
        mostrar_procesos();
    }
    

    
//procedimiento de alineacionde columnas
    private void Alineacion_Columnas(){
        DefaultTableCellRenderer Alinear = new DefaultTableCellRenderer();
        Alinear.setHorizontalAlignment(SwingConstants.RIGHT); //establece de que forma se va a alinear las columnas
        tabla_procesos.getColumnModel().getColumn(1).setCellRenderer(Alinear);//alinea columna 1
        tabla_procesos.getColumnModel().getColumn(2).setCellRenderer(Alinear);//alinea columna 2
        tabla_procesos.getColumnModel().getColumn(3).setCellRenderer(Alinear);//alinea columna 3
        tabla_procesos.getColumnModel().getColumn(4).setCellRenderer(Alinear);//alinea columna 4
    }
    
     // procedimiento de limpiaeza de la tabla la restablece de a los parametros inisciales
    void LimpiarTabla(){
        tabla_procesos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "PID", "Tipo de sesión ", "Número de sesión", "Uso de memoria"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
    }
    
    //procedimiento de lectura y de insercion de procesos en tabla
    private void mostrar_procesos(){
    int ICol=0,ICont=0;
        modelo = (DefaultTableModel) tabla_procesos.getModel();
        Object[] Fila = new  Object[5];
        int i=0;
        String StrAuxi = "";
                try {
            String line;
            //se realiza la ejecucion de tasklist.exe para leer los procesos en ejecucion
            Process p = Runtime.getRuntime().exec(System.getenv("windir") +"\\system32\\"+"tasklist.exe");
            BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));//lectura de los datos de buffer obtenidos con tasklist
            //Guardado en la variable Fila cada dato para cada columna
            while ((line = input.readLine()) != null) {
                if(i>=4){
                    ICont=0;
                   while(ICont<=4){
                    String[] sep = line.split("\\s+");
                    if(ICont!=4){
                    Fila[ICont] = sep[ICont];
                    }else{
                       Fila[ICont] = sep[ICont]+" "+sep[ICont+1]; 
                    }
                    ICont++;
                   }
                //agregamos el arreglo de la cada fila a la tabla
                modelo.addRow(Fila);
                //Asignamos y/o aplicamos el modelo a nuestra tabla
                tabla_procesos.setModel(modelo);
                }
        i++;
            }
            input.close();
            Alineacion_Columnas();//llamada a la alineacion de las columnas
            txt_cant_procesos.setText(String.valueOf(i));// se imprimen el numero de procesos en ejecucion
        } catch (Exception err) {
        }
        
    }
    
        //procedimiento de matar o finalzar los procesos
    public void Matar_proceso(){
        modelo = (DefaultTableModel) tabla_procesos.getModel();
        //se realiza la lectura de los datos de la columna 0(nombre) de la fila selecionada para matar el proceso
        String StrCelda = String.valueOf(modelo.getValueAt(tabla_procesos.getSelectedRow(), 0));
        if(StrCelda==""){ //si no hay fila selecionada da un error
          JOptionPane.showMessageDialog(null, "ERROR, No se ha selecionado ningun proceso","Error", JOptionPane.INFORMATION_MESSAGE); 
        }else{//de lo contrario realizara el proceso de matar el proceso
        try {
          Process hijo;
          hijo = Runtime.getRuntime().exec("taskkill /F /IM "+StrCelda);//mata el proceso selecionado junto con sus hijos
          hijo.waitFor();// finaiza los procesos hijos
        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(administrador_tareas.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scroll_panel = new javax.swing.JScrollPane();
        tabla_procesos = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txt_cant_procesos = new javax.swing.JTextField();
        btn_act_procesos = new javax.swing.JButton();
        btn_fin_procesos = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabla_procesos.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        tabla_procesos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "PID", "Tipo de sesión ", "Número de sesión", "Uso de memoria"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla_procesos.setColumnSelectionAllowed(true);
        scroll_panel.setViewportView(tabla_procesos);
        tabla_procesos.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        getContentPane().add(scroll_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 960, 490));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("TOTAL DE PROCESOS: ");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        txt_cant_procesos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cant_procesosActionPerformed(evt);
            }
        });
        jPanel2.add(txt_cant_procesos, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, 130, -1));

        btn_act_procesos.setText("ACTULIZAR PROCESOS");
        btn_act_procesos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_act_procesosActionPerformed(evt);
            }
        });
        jPanel2.add(btn_act_procesos, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 20, -1, -1));

        btn_fin_procesos.setText("FINALIZAR PROCESO");
        btn_fin_procesos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_fin_procesosActionPerformed(evt);
            }
        });
        jPanel2.add(btn_fin_procesos, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 20, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 490, 960, 60));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_cant_procesosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cant_procesosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cant_procesosActionPerformed

    private void btn_act_procesosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_act_procesosActionPerformed

        LimpiarTabla();//limpia la tabla antes de insertr todos los procesos
        mostrar_procesos();//llama al procedimiento de mostrar procesos y los coloca en la tabla

    }//GEN-LAST:event_btn_act_procesosActionPerformed

    private void btn_fin_procesosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_fin_procesosActionPerformed

        Matar_proceso();//llama al procedimiento de terminar un proceso
        LimpiarTabla();//limpia la tabla antes de colocar los procesos despues de haber terminado uno
        mostrar_procesos();//coloca de nuevo los procesos que quedaron sin los que se acaban de terminar
    }//GEN-LAST:event_btn_fin_procesosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_act_procesos;
    private javax.swing.JButton btn_fin_procesos;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane scroll_panel;
    private javax.swing.JTable tabla_procesos;
    private javax.swing.JTextField txt_cant_procesos;
    // End of variables declaration//GEN-END:variables
}
