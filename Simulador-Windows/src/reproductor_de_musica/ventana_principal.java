
package reproductor_de_musica;

import static com.sun.java.accessibility.util.AWTEventMonitor.addWindowListener;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javazoom.jlgui.basicplayer.BasicPlayerException;

/**
 *
 * @author Angelina Santana
 */

public class ventana_principal extends javax.swing.JInternalFrame {

     private lista list = new lista();
    private nodo actual = null;
    private Zplayer player;
    private Short x = 0;
    private DefaultListModel lista_modelo = new DefaultListModel();
    private String ultimaLista = "vacio";
    private boolean cambios = false;
    protected boolean detenido = false;
    
    public ventana_principal() {
        setTitle("Reproductor de musica mp3");
        setResizable(false);
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/iconos/icono.png"));
//        setIconImage(icon);
        
        initComponents();
        
//        setLocationRelativeTo(null);
        nombre_can.setEditable(false);
        jSlider1.setEnabled(false);
        jSlider2.setEnabled(false);

        lista_can.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                JList lista = (JList) evt.getSource();
                if (evt.getClickCount() == 2) {
                    int index = lista.locationToIndex(evt.getPoint());
                    if (index != -1) {
                        actual = list.get_cancion(index);
                        x = 0;
                        playActionPerformed(null);
                    }
                }
            }
        });

        try {
            BufferedReader tec = new BufferedReader(new FileReader(System.getProperty("user.dir") + "\\config"));
            String aux = tec.readLine();
            if (aux.equals("Si")) {
                aux = tec.readLine();
                if (!aux.equals("vacio")) {
                    cargarLista(aux);
                }
            } else {
                cargarListaInicio.setSelected(false);
            }
        } catch (Exception e) {
        }

        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent evt) {
                if (!list.IsEmpety() && cambios) {
                    int opcion = JOptionPane.showConfirmDialog(null, "¿Guardar cambios?");
                    if (opcion == JOptionPane.YES_OPTION) {
                        if (ultimaLista.equals("vacio")) {
                            ultimaLista = crearArchivoLista();
                        }
                        if (ultimaLista == null) {
                            ultimaLista = "vacio";
                        } else {
                            guardarLista(ultimaLista);
                        }
                    }
                }
                try {
                    BufferedWriter bw = new BufferedWriter(
                            new FileWriter(System.getProperty("user.dir") + "\\config"));
                    if (cargarListaInicio.isSelected()) {
                        bw.write("Si\r\n");
                        bw.write(ultimaLista + "\r\n");
                    } else {
                        bw.write("No\r\n");
                    }
                    bw.close();
                } catch (Exception e) {
                }
                System.exit(0);
            }
        });
        player = new Zplayer(this);
    }

    
    public void cargarLista(String ruta) {
        try {
            FileInputStream fis = new FileInputStream(new File(ruta));
            BufferedReader tec = new BufferedReader(new InputStreamReader(fis, "UTF-8"));
            String input[];
            tec.readLine();

            while (tec.ready()) {
                input = tec.readLine().split("<");
                System.out.println(input[0] + " , " + input[1]);
                list.insertar(input[0], input[1]);
                lista_modelo.addElement(input[0]);
            }
            ultimaLista = ruta;
            cambios = false;
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error\nal cargar la lista!!!", "alerta", 1);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error!!!", "alerta", 1);
        }
        lista_can.setModel(lista_modelo);
    }

    public void guardarLista(String dir) {
        try {
            BufferedWriter tec = new BufferedWriter(new FileWriter(dir));
            tec.write("\r\n");

            nodo aux = list.first;
            while (aux != null) {
                tec.append(aux.nombre + "<" + aux.direccion + "\r\n");
                aux = aux.siguiente;
            }

            tec.close();
            cambios = false;
        } catch (Exception e) {
        }
    }

    public String crearArchivoLista() {
        String n = JOptionPane.showInputDialog("digite el nombre de la lista");
        if (n == null || n.isEmpty()) {
            return null;
        }
        
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int seleccion = chooser.showOpenDialog(this);
        File ruta;

        if (seleccion == JFileChooser.APPROVE_OPTION) {
            ruta = chooser.getSelectedFile();
        } else {
            return null;
        }
        File save = new File(ruta.getAbsolutePath() + "\\" + n + ".lis");
        if (save.exists()) {
            save.delete();
        }
        return save.getAbsolutePath();
    }
   
    protected void eventoSiguiente(){
        siguienteActionPerformed(null);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        slidereq = new javax.swing.JSlider();
        slidereq1 = new javax.swing.JSlider();
        slidereq2 = new javax.swing.JSlider();
        slidereq3 = new javax.swing.JSlider();
        slidereq4 = new javax.swing.JSlider();
        slidereq5 = new javax.swing.JSlider();
        slidereq6 = new javax.swing.JSlider();
        slidereq7 = new javax.swing.JSlider();
        slidereq8 = new javax.swing.JSlider();
        slidereq9 = new javax.swing.JSlider();
        jSlider2 = new javax.swing.JSlider();
        nombre_can = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        lista_can = new javax.swing.JList();
        tipo_reproduccion = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        eliminar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        agregar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        anterior = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        play = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        siguiente = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        detener = new javax.swing.JButton();
        jSlider1 = new javax.swing.JSlider();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        cargarListaInicio = new javax.swing.JCheckBoxMenuItem();
        guardar_lista = new javax.swing.JMenuItem();
        cargar_lista = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();

        setClosable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/musica2.gif"))); // NOI18N
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 80, -1, -1));

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        slidereq.setMinimum(-100);
        slidereq.setOrientation(javax.swing.JSlider.VERTICAL);
        slidereq.setValue(0);
        slidereq.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        slidereq.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                slidereqStateChanged(evt);
            }
        });
        jPanel1.add(slidereq, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 13, 40, 150));

        slidereq1.setMinimum(-100);
        slidereq1.setOrientation(javax.swing.JSlider.VERTICAL);
        slidereq1.setValue(0);
        slidereq1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                slidereq1StateChanged(evt);
            }
        });
        jPanel1.add(slidereq1, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 13, 40, 150));

        slidereq2.setMinimum(-100);
        slidereq2.setOrientation(javax.swing.JSlider.VERTICAL);
        slidereq2.setValue(0);
        slidereq2.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                slidereq2StateChanged(evt);
            }
        });
        jPanel1.add(slidereq2, new org.netbeans.lib.awtextra.AbsoluteConstraints(106, 13, 40, 150));

        slidereq3.setMinimum(-100);
        slidereq3.setOrientation(javax.swing.JSlider.VERTICAL);
        slidereq3.setValue(0);
        slidereq3.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                slidereq3StateChanged(evt);
            }
        });
        jPanel1.add(slidereq3, new org.netbeans.lib.awtextra.AbsoluteConstraints(153, 13, 40, 150));

        slidereq4.setMinimum(-100);
        slidereq4.setOrientation(javax.swing.JSlider.VERTICAL);
        slidereq4.setValue(0);
        slidereq4.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                slidereq4StateChanged(evt);
            }
        });
        jPanel1.add(slidereq4, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 13, 40, 150));

        slidereq5.setMinimum(-100);
        slidereq5.setOrientation(javax.swing.JSlider.VERTICAL);
        slidereq5.setValue(0);
        slidereq5.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                slidereq5StateChanged(evt);
            }
        });
        jPanel1.add(slidereq5, new org.netbeans.lib.awtextra.AbsoluteConstraints(247, 13, 40, 150));

        slidereq6.setMinimum(-100);
        slidereq6.setOrientation(javax.swing.JSlider.VERTICAL);
        slidereq6.setValue(0);
        slidereq6.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                slidereq6StateChanged(evt);
            }
        });
        jPanel1.add(slidereq6, new org.netbeans.lib.awtextra.AbsoluteConstraints(294, 13, 40, 150));

        slidereq7.setMinimum(-100);
        slidereq7.setOrientation(javax.swing.JSlider.VERTICAL);
        slidereq7.setValue(0);
        slidereq7.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                slidereq7StateChanged(evt);
            }
        });
        jPanel1.add(slidereq7, new org.netbeans.lib.awtextra.AbsoluteConstraints(341, 13, 40, 150));

        slidereq8.setMinimum(-100);
        slidereq8.setOrientation(javax.swing.JSlider.VERTICAL);
        slidereq8.setValue(0);
        slidereq8.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                slidereq8StateChanged(evt);
            }
        });
        jPanel1.add(slidereq8, new org.netbeans.lib.awtextra.AbsoluteConstraints(388, 13, 40, 150));

        slidereq9.setMinimum(-100);
        slidereq9.setOrientation(javax.swing.JSlider.VERTICAL);
        slidereq9.setValue(0);
        slidereq9.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                slidereq9StateChanged(evt);
            }
        });
        jPanel1.add(slidereq9, new org.netbeans.lib.awtextra.AbsoluteConstraints(435, 13, 40, 150));

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 350, 480, 170));

        jSlider2.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSlider2StateChanged(evt);
            }
        });
        jPanel2.add(jSlider2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 280, 150, -1));

        nombre_can.setText("...");
        nombre_can.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel2.add(nombre_can, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, 443, -1));

        jScrollPane1.setViewportView(lista_can);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 150, 270));

        tipo_reproduccion.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "normal", "inversa", "aleatoria" }));
        jPanel2.add(tipo_reproduccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 70, -1, -1));

        jLabel1.setText("tipo de reproduccion");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 40, -1, -1));

        eliminar.setText("Quitar canción actual");
        eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarActionPerformed(evt);
            }
        });
        jPanel2.add(eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/configuracion.png"))); // NOI18N
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 350, -1, -1));

        agregar.setText("Agregar canción");
        agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarActionPerformed(evt);
            }
        });
        jPanel2.add(agregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, -1, -1));
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 320, 578, 10));

        anterior.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/anterior.png"))); // NOI18N
        anterior.setBorderPainted(false);
        anterior.setContentAreaFilled(false);
        anterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anteriorActionPerformed(evt);
            }
        });
        jPanel2.add(anterior, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 150, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/sonido.png"))); // NOI18N
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 270, -1, -1));

        play.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/play.png"))); // NOI18N
        play.setBorderPainted(false);
        play.setContentAreaFilled(false);
        play.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playActionPerformed(evt);
            }
        });
        jPanel2.add(play, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 150, -1, -1));

        jLabel4.setText("Balance");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 280, -1, -1));

        siguiente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/siguiente.png"))); // NOI18N
        siguiente.setToolTipText("");
        siguiente.setBorderPainted(false);
        siguiente.setContentAreaFilled(false);
        siguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                siguienteActionPerformed(evt);
            }
        });
        jPanel2.add(siguiente, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 150, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/musica2.gif"))); // NOI18N
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 80, -1, -1));

        detener.setText("Detener reproducción");
        detener.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detenerActionPerformed(evt);
            }
        });
        jPanel2.add(detener, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 410, -1, -1));

        jSlider1.setValue(100);
        jSlider1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSlider1StateChanged(evt);
            }
        });
        jPanel2.add(jSlider1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 280, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 780, 540));

        jMenu1.setText("Archivo");

        cargarListaInicio.setSelected(true);
        cargarListaInicio.setText("Cargar ultima lista al abrir");
        jMenu1.add(cargarListaInicio);

        guardar_lista.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.CTRL_MASK));
        guardar_lista.setText("Guardar lista");
        guardar_lista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardar_listaActionPerformed(evt);
            }
        });
        jMenu1.add(guardar_lista);

        cargar_lista.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_MASK));
        cargar_lista.setText("Cargar lista");
        cargar_lista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cargar_listaActionPerformed(evt);
            }
        });
        jMenu1.add(cargar_lista);

        jMenuItem7.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, 0));
        jMenuItem7.setText("Acerca de");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem7);

        jMenuItem1.setText("Salir");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Editar");

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem4.setText("agregar cancion");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem5.setText("eliminar cancion");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem5);

        jMenuItem6.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        jMenuItem6.setText("ayuda");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem6);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void slidereqStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_slidereqStateChanged
        player.eq[0] = (float) slidereq.getValue() / 100;
    }//GEN-LAST:event_slidereqStateChanged

    private void slidereq1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_slidereq1StateChanged
        player.eq[1] = (float) slidereq1.getValue() / 100;
    }//GEN-LAST:event_slidereq1StateChanged

    private void slidereq2StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_slidereq2StateChanged
        player.eq[2] = (float) slidereq2.getValue() / 100;
    }//GEN-LAST:event_slidereq2StateChanged

    private void slidereq3StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_slidereq3StateChanged
        player.eq[3] = (float) slidereq3.getValue() / 100;
    }//GEN-LAST:event_slidereq3StateChanged

    private void slidereq4StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_slidereq4StateChanged
        player.eq[4] = (float) slidereq4.getValue() / 100;
    }//GEN-LAST:event_slidereq4StateChanged

    private void slidereq5StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_slidereq5StateChanged
        player.eq[5] = (float) slidereq5.getValue() / 100;
    }//GEN-LAST:event_slidereq5StateChanged

    private void slidereq6StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_slidereq6StateChanged
        player.eq[6] = (float) slidereq6.getValue() / 100;
    }//GEN-LAST:event_slidereq6StateChanged

    private void slidereq7StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_slidereq7StateChanged
        player.eq[7] = (float) slidereq7.getValue() / 100;
    }//GEN-LAST:event_slidereq7StateChanged

    private void slidereq8StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_slidereq8StateChanged
        player.eq[8] = (float) slidereq8.getValue() / 100;
    }//GEN-LAST:event_slidereq8StateChanged

    private void slidereq9StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_slidereq9StateChanged
        player.eq[9] = (float) slidereq9.getValue() / 100;
    }//GEN-LAST:event_slidereq9StateChanged

    private void jSlider2StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSlider2StateChanged
        try {
            player.control.setPan((float) jSlider2.getValue() / 100);
        } catch (BasicPlayerException ex) {
            Logger.getLogger(ventana_principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jSlider2StateChanged

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed
        if (list.IsEmpety()) {
            return;
        }
        int q = list.index(actual);
        if (q == -1) {
            JOptionPane.showMessageDialog(null, "ha ocurrido un\nerror inesperado!!!", "alerta", 1);
        } else {
            lista_modelo.remove(q);
            list.borrar(actual);
            detenerActionPerformed(evt);
            if (list.IsEmpety()) {
                actual = null;
                nombre_can.setText("...");
            } else {
                if (list.tam == 1) {
                    actual = list.first;
                } else {
                    if (actual.siguiente == null) {
                        actual = actual.anterior;
                    } else {
                        actual = actual.siguiente;
                    }
                }
                nombre_can.setText(actual.nombre);
            }
        }
        cambios = true;
    }//GEN-LAST:event_eliminarActionPerformed

    private void agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileNameExtensionFilter("Archivo MP3", "mp3", "mp3"));
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setMultiSelectionEnabled(true);
        int seleccion = fileChooser.showOpenDialog(this);

        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File files[] = fileChooser.getSelectedFiles();
            boolean noMp3 = false, repetidos = false;
            cambios = true;

            for (File file : files) {
                String name = file.getName();
                if (name.length() < 4 || !name.substring(name.length() - 4, name.length()).equalsIgnoreCase(".mp3")) {
                    noMp3 = true;
                    continue;
                }
                if (list.buscar(file.getName(), file.getPath())) {
                    repetidos = true;
                    continue;
                }
                list.insertar(file.getName(), file.getPath());
                System.out.println(file.getName());
                System.out.println(file.getPath());
                lista_modelo.addElement(file.getName());
                lista_can.setModel(lista_modelo);
            }
            if (noMp3) {
                JOptionPane.showMessageDialog(null, "Se encontro archivo(s) no mp3", "alerta", 0);
            }
            if (repetidos) {
                JOptionPane.showMessageDialog(null, "Se encontraron repetidos", "alerta", 0);
            }
        }
    }//GEN-LAST:event_agregarActionPerformed

    private void anteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anteriorActionPerformed
        if (actual == null) {
            return;
        }

        switch (tipo_reproduccion.getSelectedIndex()) {
            case 0:
            if (actual.anterior == null) {
                return;
            }
            actual = actual.anterior;
            break;

            case 1:
            if (actual.siguiente == null) {
                return;
            }
            actual = actual.siguiente;
            break;

            default:
            int index = (int) (Math.random() * list.tam);
            actual = list.get_cancion(index);
            break;
        }

        x = 0;
        playActionPerformed(evt);
    }//GEN-LAST:event_anteriorActionPerformed

    private void playActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playActionPerformed
        detenido = true;
        if (list.IsEmpety()) {
            JOptionPane.showMessageDialog(null, "no hay canciones", "alerta", 1);
        } else {
            if (actual == null) {
                actual = list.first;
            }
            try {
                if (x == 0) {
                    player.control.open(new URL("file:///" + actual.direccion));
                    player.control.play();
                    System.out.println("se inicia");
                    nombre_can.setText(actual.nombre);
                    jSlider1.setEnabled(true);
                    jSlider2.setEnabled(true);
                    x = 1;
                    play.setIcon(new ImageIcon(getClass().getResource("/iconos/pausa.png")));
                } else {
                    if (x == 1) {
                        player.control.pause();
                        System.out.println("se pausa!!!");
                        x = 2;
                        play.setIcon(new ImageIcon(getClass().getResource("/iconos/play.png")));
                    } else {
                        player.control.resume();
                        System.out.println("se continua!!!");
                        x = 1;
                        play.setIcon(new ImageIcon(getClass().getResource("/iconos/pausa.png")));
                    }
                }
            } catch (BasicPlayerException ex) {
                JOptionPane.showMessageDialog(null, "error al abrir\nla cancion!!!", "alerta", 1);
                x = 0;
            } catch (MalformedURLException ex) {
                Logger.getLogger(ventana_principal.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "error al abrir la direccion\nde la cancion!!!", "alerta", 1);
                x = 0;
            }
        }
        detenido = false;
    }//GEN-LAST:event_playActionPerformed

    private void siguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_siguienteActionPerformed
        if (actual == null) {
            return;
        }

        switch (tipo_reproduccion.getSelectedIndex()) {
            case 0:
            if (actual.siguiente == null) {
                return;
            }
            actual = actual.siguiente;
            break;

            case 1:
            if (actual.anterior == null) {
                return;
            }
            actual = actual.anterior;
            break;

            default:
            int index = (int) (Math.random() * list.tam);
            actual = list.get_cancion(index);
            break;
        }

        x = 0;
        playActionPerformed(evt);
    }//GEN-LAST:event_siguienteActionPerformed

    private void detenerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detenerActionPerformed
        detenido = true;
        play.setIcon(new ImageIcon(getClass().getResource("/iconos/play.png")));
        try {
            player.control.stop();
            x = 0;
            jSlider1.setEnabled(false);
            jSlider2.setEnabled(false);
        } catch (BasicPlayerException ex) {
            Logger.getLogger(ventana_principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        detenido = false;
    }//GEN-LAST:event_detenerActionPerformed

    private void jSlider1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSlider1StateChanged
        try {
            player.control.setGain((double) jSlider1.getValue() / 100);
        } catch (BasicPlayerException ex) {
            Logger.getLogger(ventana_principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jSlider1StateChanged

    private void guardar_listaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardar_listaActionPerformed
        if (list.IsEmpety()) {
            JOptionPane.showMessageDialog(null, "no hay canciones!!!", "alerta", 1);
            return;
        }
        guardarLista(crearArchivoLista());
    }//GEN-LAST:event_guardar_listaActionPerformed

    private void cargar_listaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cargar_listaActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.setFileFilter(new FileNameExtensionFilter("archivo lis", "lis"));
        int seleccion = chooser.showOpenDialog(this);

        if (seleccion == JFileChooser.APPROVE_OPTION) {
            detenerActionPerformed(evt);
            list.clear();
            lista_modelo.clear();
            actual = list.first;

            String name = chooser.getSelectedFile().getName();
            if (name.length() < 4 || !name.substring(name.length() - 4, name.length()).equalsIgnoreCase(".lis")) {
                JOptionPane.showMessageDialog(null, "no es una lista", "alerta", 0);
                return;
            }
            cargarLista(chooser.getSelectedFile().getPath());
        }
    }//GEN-LAST:event_cargar_listaActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        JOptionPane.showMessageDialog(null, "Proyecto final, programacion I\n(estructuras de datos)");
        JOptionPane.showMessageDialog(null, "Con ajustes posteriores");
        JOptionPane.showMessageDialog(null, "por: Wilmer Castrillon,\nprimera aplicacion grafica\nversion 1.7");
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        agregarActionPerformed(evt);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        eliminarActionPerformed(evt);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        JOptionPane.showMessageDialog(null, "verifique que el nombre de las canciones no tengan\ncaracteres especiales como tildes o apostrofos", "alerta", 1);
    }//GEN-LAST:event_jMenuItem6ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregar;
    private javax.swing.JButton anterior;
    private javax.swing.JCheckBoxMenuItem cargarListaInicio;
    private javax.swing.JMenuItem cargar_lista;
    private javax.swing.JButton detener;
    private javax.swing.JButton eliminar;
    private javax.swing.JMenuItem guardar_lista;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JSlider jSlider2;
    private javax.swing.JList lista_can;
    private javax.swing.JTextField nombre_can;
    private javax.swing.JButton play;
    private javax.swing.JButton siguiente;
    private javax.swing.JSlider slidereq;
    private javax.swing.JSlider slidereq1;
    private javax.swing.JSlider slidereq2;
    private javax.swing.JSlider slidereq3;
    private javax.swing.JSlider slidereq4;
    private javax.swing.JSlider slidereq5;
    private javax.swing.JSlider slidereq6;
    private javax.swing.JSlider slidereq7;
    private javax.swing.JSlider slidereq8;
    private javax.swing.JSlider slidereq9;
    private javax.swing.JComboBox tipo_reproduccion;
    // End of variables declaration//GEN-END:variables
}
