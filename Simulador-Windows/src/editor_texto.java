
import java.awt.Color;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

/**
 *
 * @author Angelina Santana
 */
public class editor_texto extends javax.swing.JInternalFrame {

    public editor_texto() {
        initComponents();
        doc = txt_panel.getStyledDocument();
        estilo = txt_panel.addStyle("miEstilo", null);

//        Copiando al combox los tipos de letras
        DefaultComboBoxModel modelo=(DefaultComboBoxModel) cb_font.getModel();
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        String fontNames[] = ge.getAvailableFontFamilyNames();
        for (int i = 0; i < fontNames.length; i++) {
            modelo.addElement(fontNames[i]);
        }
        cb_font.setModel(modelo);

    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txt_panel = new javax.swing.JTextPane();
        cb_size = new javax.swing.JComboBox<>();
        cb_font = new javax.swing.JComboBox<>();
        btn_color_fondo = new javax.swing.JButton();
        btn_negrita = new javax.swing.JButton();
        btn_cursiva = new javax.swing.JButton();
        btn_subrayado = new javax.swing.JButton();
        btn_color_letra = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        file = new javax.swing.JMenu();
        item_guardar = new javax.swing.JMenuItem();
        item_abrir = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setClosable(true);
        setIconifiable(true);
        setPreferredSize(new java.awt.Dimension(720, 480));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setViewportView(txt_panel);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 710, 340));

        cb_size.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "12", "18", "24", "32", "48", "72" }));
        cb_size.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_sizeActionPerformed(evt);
            }
        });
        getContentPane().add(cb_size, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 120, 30));

        cb_font.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_fontActionPerformed(evt);
            }
        });
        getContentPane().add(cb_font, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 130, 30));

        btn_color_fondo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_color_fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/img/fondo.png"))); // NOI18N
        btn_color_fondo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_color_fondoActionPerformed(evt);
            }
        });
        getContentPane().add(btn_color_fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 20, 50, 30));

        btn_negrita.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_negrita.setText("N");
        btn_negrita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_negritaActionPerformed(evt);
            }
        });
        getContentPane().add(btn_negrita, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 20, 50, 30));

        btn_cursiva.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        btn_cursiva.setText("K");
        btn_cursiva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cursivaActionPerformed(evt);
            }
        });
        getContentPane().add(btn_cursiva, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 20, 50, 30));

        btn_subrayado.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_subrayado.setText("S");
        btn_subrayado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_subrayadoActionPerformed(evt);
            }
        });
        getContentPane().add(btn_subrayado, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 20, 50, 30));

        btn_color_letra.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_color_letra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/img/letra.png"))); // NOI18N
        btn_color_letra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_color_letraActionPerformed(evt);
            }
        });
        getContentPane().add(btn_color_letra, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 20, 50, 30));

        file.setText("ARchivo");

        item_guardar.setText("Guardar");
        item_guardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                item_guardarMouseClicked(evt);
            }
        });
        file.add(item_guardar);

        item_abrir.setText("Abrir");
        item_abrir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                item_abrirMouseClicked(evt);
            }
        });
        file.add(item_abrir);

        jMenuBar1.add(file);

        jMenu2.setText("Helps");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cb_sizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_sizeActionPerformed
        StyleConstants.setFontSize(estilo, Integer.parseInt(cb_size.getSelectedItem().toString()));
        doc.setCharacterAttributes(txt_panel.getSelectionStart(),
                txt_panel.getSelectionEnd() - txt_panel.getSelectionStart(),
                txt_panel.getStyle("miEstilo"),
                true);
    }//GEN-LAST:event_cb_sizeActionPerformed

    private void btn_negritaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_negritaActionPerformed
        try {
            StyleConstants.setBold(estilo, true);

            doc.setCharacterAttributes(txt_panel.getSelectionStart(),
                    txt_panel.getSelectionEnd() - txt_panel.getSelectionStart(),
                    txt_panel.getStyle("miEstilo"),
                    true);
        } catch (Exception ex) {
        }
    }//GEN-LAST:event_btn_negritaActionPerformed

    private void cb_fontActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_fontActionPerformed
        StyleConstants.setFontFamily(estilo, cb_font.getSelectedItem().toString());
        //StyleConstants.setFontSize(estilo, Integer.parseInt(cb_size.getSelectedItem().toString()));
        doc.setCharacterAttributes(txt_panel.getSelectionStart(),
                txt_panel.getSelectionEnd() - txt_panel.getSelectionStart(),
                txt_panel.getStyle("miEstilo"),
                true);
    }//GEN-LAST:event_cb_fontActionPerformed

    private void btn_cursivaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cursivaActionPerformed
        try {
            StyleConstants.setItalic(estilo, true);

            doc.setCharacterAttributes(txt_panel.getSelectionStart(),
                    txt_panel.getSelectionEnd() - txt_panel.getSelectionStart(),
                    txt_panel.getStyle("miEstilo"),
                    true);
        } catch (Exception ex) {
        }
    }//GEN-LAST:event_btn_cursivaActionPerformed

    private void btn_subrayadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_subrayadoActionPerformed
        try {
            StyleConstants.setUnderline(estilo, true);

            doc.setCharacterAttributes(txt_panel.getSelectionStart(),
                    txt_panel.getSelectionEnd() - txt_panel.getSelectionStart(),
                    txt_panel.getStyle("miEstilo"),
                    true);
        } catch (Exception ex) {
        }
    }//GEN-LAST:event_btn_subrayadoActionPerformed

    private void btn_color_letraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_color_letraActionPerformed
        try {

            StyleConstants.setForeground(estilo,
                    JColorChooser.showDialog(this,
                            "Seleccione Color", Color.red)
            );

            doc.setCharacterAttributes(txt_panel.getSelectionStart(),
                    txt_panel.getSelectionEnd() - txt_panel.getSelectionStart(),
                    txt_panel.getStyle("miEstilo"),
                    true);
        } catch (Exception ex) {
        }
    }//GEN-LAST:event_btn_color_letraActionPerformed

    private void btn_color_fondoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_color_fondoActionPerformed
        try {

            StyleConstants.setBackground(estilo,
                    JColorChooser.showDialog(this,
                            "Seleccione Color", Color.yellow)
            );

            doc.setCharacterAttributes(txt_panel.getSelectionStart(),
                    txt_panel.getSelectionEnd() - txt_panel.getSelectionStart(),
                    txt_panel.getStyle("miEstilo"),
                    true);
        } catch (Exception ex) {
        }
    }//GEN-LAST:event_btn_color_fondoActionPerformed

//    Item para guardar un archivo
    private void item_guardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_item_guardarMouseClicked
//        JFileChooser jfc = new JFileChooser();
//        FileNameExtensionFilter filtro = 
//                    new FileNameExtensionFilter(
//                            "El Inge Docs", "omf");
//         jfc.setFileFilter(filtro); 
//        int seleccion = jfc.showSaveDialog(this); 
//       
//        FileOutputStream fw = null;
//        ObjectOutputStream bw = null;
//        if (seleccion == JFileChooser.APPROVE_OPTION) {
//             try {
//                 
//                  File fichero=null;
//                if (jfc.getFileFilter().getDescription().equals(
//                        "El Inge Docs")) {
//                    fichero = 
//                        new File(jfc.getSelectedFile().getPath()+".omf");
//                }else{
//                    fichero = jfc.getSelectedFile();
//                }   
//                
//                fw = new FileOutputStream(fichero);
//                bw = new ObjectOutputStream(fw);
//                Document d=new Document(txt_panel,doc,estilo);
//                bw.writeObject(d);
//                bw.flush();
//                
//                JOptionPane.showMessageDialog(this, 
//                        "Archivo guardado exitosamente");  
//                
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//                               
//        }//fin IF
//        try {
//                    bw.close();
//                    fw.close();
//                } catch (IOException ex) {
//           } 
    }//GEN-LAST:event_item_guardarMouseClicked

//    ITem iara abrir un archivo
    private void item_abrirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_item_abrirMouseClicked
//         File fichero = null;
//        FileInputStream entrada = null;
//        ObjectInputStream objeto = null;        
//        try {
//            JFileChooser jfc = new JFileChooser();
//            FileNameExtensionFilter filtro = 
//                    new FileNameExtensionFilter(
//                            "El Inge Docs", "omf");
//            jfc.setFileFilter(filtro);                   
//            int seleccion = jfc.showOpenDialog(this);
//            if (seleccion == JFileChooser.APPROVE_OPTION)
//            {
//               fichero = jfc.getSelectedFile();
//                entrada
//                    = new FileInputStream(fichero);
//                 objeto
//                    = new ObjectInputStream(entrada);              
//               txt_panel.setText("");  
//               Documento temp=(Documento)objeto.readObject();
//               txt_panel.setText( ((Documento)  temp  ).getPanel().getText() );
//               txt_panel.setDocument( ((Documento)temp  ).getDoc()   ) ;
//                
//               
//               
//            } //fin if
//            
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        try {
//            objeto.close();
//            entrada.close();
//        } catch (IOException ex) {
//        }
    }//GEN-LAST:event_item_abrirMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_color_fondo;
    private javax.swing.JButton btn_color_letra;
    private javax.swing.JButton btn_cursiva;
    private javax.swing.JButton btn_negrita;
    private javax.swing.JButton btn_subrayado;
    private javax.swing.JComboBox<String> cb_font;
    private javax.swing.JComboBox<String> cb_size;
    private javax.swing.JMenu file;
    private javax.swing.JMenuItem item_abrir;
    private javax.swing.JMenuItem item_guardar;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane txt_panel;
    // End of variables declaration//GEN-END:variables

    StyledDocument doc;
    Style estilo;

}
