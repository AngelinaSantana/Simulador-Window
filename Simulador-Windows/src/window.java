
import chrriis.dj.nativeswing.NativeSwing;
//import chrriis.dj.nativeswing.swtimpl.components.JWebBrowser;
//import java.awt.BorderLayout;


/**
 *
 * @author Angelina Santana
 */
public class window extends javax.swing.JFrame {

 
//    JWebBrowser navegador = new JWebBrowser();
    public window() {
        initComponents();
//        this.setExtendedState(MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);
        
//        
//        this.web_panel.setLayout(new BorderLayout());
//        navegador.navigate("https://www.google.com");
//        this.web_panel.add(navegador);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktop_panel = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel();
        btn_navegador = new javax.swing.JButton();
        btn_admin_tarea = new javax.swing.JButton();
        btn_reproductor = new javax.swing.JButton();
        btn_editor_texto = new javax.swing.JButton();
        web_panel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setPreferredSize(new java.awt.Dimension(1920, 1080));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout desktop_panelLayout = new javax.swing.GroupLayout(desktop_panel);
        desktop_panel.setLayout(desktop_panelLayout);
        desktop_panelLayout.setHorizontalGroup(
            desktop_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1920, Short.MAX_VALUE)
        );
        desktop_panelLayout.setVerticalGroup(
            desktop_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 940, Short.MAX_VALUE)
        );

        getContentPane().add(desktop_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1920, 940));

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_navegador.setText("Navegador");
        btn_navegador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_navegadorActionPerformed(evt);
            }
        });
        jPanel1.add(btn_navegador, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 160, 50));

        btn_admin_tarea.setText("Administrador de Tarea");
        btn_admin_tarea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_admin_tareaActionPerformed(evt);
            }
        });
        jPanel1.add(btn_admin_tarea, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, 188, 50));

        btn_reproductor.setText("Reproductor");
        btn_reproductor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_reproductorActionPerformed(evt);
            }
        });
        jPanel1.add(btn_reproductor, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 10, 188, 50));

        btn_editor_texto.setText("Editor Texto");
        btn_editor_texto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editor_textoActionPerformed(evt);
            }
        });
        jPanel1.add(btn_editor_texto, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 10, 188, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 940, 1920, 60));

        javax.swing.GroupLayout web_panelLayout = new javax.swing.GroupLayout(web_panel);
        web_panel.setLayout(web_panelLayout);
        web_panelLayout.setHorizontalGroup(
            web_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 630, Short.MAX_VALUE)
        );
        web_panelLayout.setVerticalGroup(
            web_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 480, Short.MAX_VALUE)
        );

        getContentPane().add(web_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 90, 630, 480));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_navegadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_navegadorActionPerformed
        navegador nav = new navegador();
        desktop_panel.add(nav);
        nav.setVisible(true);
    }//GEN-LAST:event_btn_navegadorActionPerformed

    private void btn_admin_tareaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_admin_tareaActionPerformed
        administrador_tareas admin_tarea = new administrador_tareas();
        desktop_panel.add(admin_tarea);
        admin_tarea.setVisible(true);
    }//GEN-LAST:event_btn_admin_tareaActionPerformed

    private void btn_reproductorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_reproductorActionPerformed
        reproductor_de_musica.ventana_principal vp = new reproductor_de_musica.ventana_principal();
        desktop_panel.add(vp);
        vp.setVisible(true);
    }//GEN-LAST:event_btn_reproductorActionPerformed

    private void btn_editor_textoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editor_textoActionPerformed
        editor_texto editor = new editor_texto();
        desktop_panel.add(editor);
        editor.setVisible(true);
    }//GEN-LAST:event_btn_editor_textoActionPerformed

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
            java.util.logging.Logger.getLogger(window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
         // Initialize the Native Swing framework
        NativeSwing.initialize();

        // Now you can create your JFrame or other components that use Native Swing
        javax.swing.SwingUtilities.invokeLater(() -> {
            navegador navegador = new navegador(); // Assuming YourWindowClass extends JFrame or similar
        });
        java.awt.EventQueue.invokeLater(() -> {
            new window().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_admin_tarea;
    private javax.swing.JButton btn_editor_texto;
    private javax.swing.JButton btn_navegador;
    private javax.swing.JButton btn_reproductor;
    private javax.swing.JDesktopPane desktop_panel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel web_panel;
    // End of variables declaration//GEN-END:variables
}
