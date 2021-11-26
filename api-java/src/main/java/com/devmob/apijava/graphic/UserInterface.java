package com.devmob.apijava.graphic;

import com.devmob.apijava.ApiJavaApplication;
import com.devmob.apijava.entities.Equipment;
import com.devmob.apijava.gateway.database.DataSource;
import com.devmob.apijava.gateway.repository.EquipmentRowMapper;
import com.github.britooo.looca.api.group.discos.DiscosGroup;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.group.processador.Processador;
import com.github.britooo.looca.api.group.sistema.Sistema;
import com.github.britooo.looca.api.util.Conversor;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.awt.image.ImageObserver.WIDTH;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class UserInterface extends javax.swing.JFrame implements ActionListener {

    DataSource devmobDataSource = new DataSource();
    JdbcTemplate configDB = new JdbcTemplate(devmobDataSource.getDevmobDataSource());
    EquipmentRowMapper equipmentRow = new EquipmentRowMapper();

    private int id;
    private String name;
    private volatile Thread runner;

    public UserInterface(int id, String name) {
        Processador cpu = new Processador();
        Memoria ram = new Memoria();
        Sistema os = new Sistema();
        DiscosGroup disk = new DiscosGroup();

        initComponents();
        this.id = id;
        this.name = name;
        labelBV.setText("Welcome to DevMob, " + name);
        labelDeviceName.setText(getDeviceName());
        labelCPU.setText(cpu.getNome());
        labelRAM.setText(Conversor.formatarBytes(ram.getTotal()));
        labelHD.setText(Conversor.formatarBytes(disk.getTamanhoTotal()));
        labelOS.setText(os.getSistemaOperacional());
        
        btnIniciar.setForeground(new Color(247, 247, 247));
        btnParar.setForeground(new Color(247, 247, 247));
        btnClose.setForeground(new Color(247, 247, 247));
    }
    
    private String getDeviceName(){
      String str;
        
      try {
            return str = InetAddress.getLocalHost().getHostName();
      } catch (UnknownHostException e) {
            e.printStackTrace();
      }
      
      return "";
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Background = new javax.swing.JPanel();
        btnParar = new javax.swing.JButton();
        labelDevice = new javax.swing.JLabel();
        btnIniciar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        labelOS = new javax.swing.JLabel();
        labelBV = new javax.swing.JLabel();
        btnClose = new javax.swing.JButton();
        labelDeviceName = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        labelHD = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        labelRAM = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        labelCPU = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        Background.setBackground(new java.awt.Color(203, 192, 212));
        Background.setPreferredSize(new java.awt.Dimension(467, 340));

        btnParar.setBackground(new java.awt.Color(90, 1, 90));
        btnParar.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        btnParar.setText("Stop process");
        btnParar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnPararMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnPararMouseExited(evt);
            }
        });
        btnParar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPararActionPerformed(evt);
            }
        });

        labelDevice.setFont(new java.awt.Font("Menlo", 1, 14)); // NOI18N
        labelDevice.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelDevice.setText("Device specification");
        labelDevice.setToolTipText("");

        btnIniciar.setBackground(new java.awt.Color(122, 76, 122));
        btnIniciar.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        btnIniciar.setText("Start process");
        btnIniciar.setMaximumSize(new java.awt.Dimension(106, 29));
        btnIniciar.setMinimumSize(new java.awt.Dimension(106, 29));
        btnIniciar.setPreferredSize(new java.awt.Dimension(77, 29));
        btnIniciar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnIniciarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnIniciarMouseExited(evt);
            }
        });
        btnIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("OS");

        labelOS.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        labelOS.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelOS.setText("jLabel2");

        labelBV.setFont(new java.awt.Font("Menlo", 1, 24)); // NOI18N
        labelBV.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelBV.setText("Welcome to Devmob");
        labelBV.setToolTipText("");

        btnClose.setBackground(new java.awt.Color(90, 1, 90));
        btnClose.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        btnClose.setText("Close app");
        btnClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCloseMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCloseMouseExited(evt);
            }
        });
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        labelDeviceName.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        labelDeviceName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelDeviceName.setText("jLabel2");

        jLabel13.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Device name");

        jLabel14.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("HD Memory");

        labelHD.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        labelHD.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelHD.setText("jLabel2");

        jLabel16.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("RAM Memory");

        labelRAM.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        labelRAM.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelRAM.setText("jLabel2");

        jLabel18.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Processor (CPU)");

        labelCPU.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        labelCPU.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelCPU.setText("jLabel2");

        javax.swing.GroupLayout BackgroundLayout = new javax.swing.GroupLayout(Background);
        Background.setLayout(BackgroundLayout);
        BackgroundLayout.setHorizontalGroup(
            BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelDevice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(labelBV, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(BackgroundLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BackgroundLayout.createSequentialGroup()
                        .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE))
                        .addGap(6, 6, 6))
                    .addGroup(BackgroundLayout.createSequentialGroup()
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(labelRAM, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                    .addComponent(labelOS, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelCPU, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelHD, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelDeviceName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(60, 60, 60))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BackgroundLayout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(BackgroundLayout.createSequentialGroup()
                        .addComponent(btnParar, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnClose, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(btnIniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(76, 76, 76))
        );
        BackgroundLayout.setVerticalGroup(
            BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BackgroundLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(labelBV, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(labelDevice, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(labelDeviceName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(labelRAM))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(labelHD))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(labelCPU))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(labelOS))
                .addGap(18, 18, 18)
                .addComponent(btnIniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnParar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Background, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Background, javax.swing.GroupLayout.DEFAULT_SIZE, 369, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarActionPerformed
        List<Equipment> equipmentQuery = equipmentRow.equipmentQuery();
        //ApiJavaApplication apiJavaApplication = new ApiJavaApplication();
        Processador processor = new Processador();

        boolean isRegistered = false;

        for (Equipment equipmentLogin : equipmentQuery) {
            if (equipmentLogin.getIdEquipment().equals(processor.getId()) && equipmentLogin.getFkUser().equals(id)) {
                isRegistered = true;
            }
        }
        if (!(isRegistered)) {
            equipmentRow.includeEquipment(id);
        }

        if (runner != null) {
            return;
        }
        runner = new Thread(this::loop);
        runner.start();

        //apiJavaApplication.runLooca(processor.getId(), true);
    }//GEN-LAST:event_btnIniciarActionPerformed

    private void btnIniciarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIniciarMouseExited
        btnIniciar.setBackground(new Color(122, 76, 122));
        btnIniciar.setForeground(new Color(247, 247, 247));
    }//GEN-LAST:event_btnIniciarMouseExited

    private void btnIniciarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIniciarMouseEntered
        btnIniciar.setBackground(new Color(200, 200, 200));
        btnIniciar.setForeground(new Color(25,25,25));
    }//GEN-LAST:event_btnIniciarMouseEntered

    private void btnPararActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPararActionPerformed
        runner = null;
        //System.exit(0);
    }//GEN-LAST:event_btnPararActionPerformed

    private void btnPararMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPararMouseExited
        btnParar.setBackground(new Color(90, 1, 90));
        btnParar.setForeground(new Color(247, 247, 247));
    }//GEN-LAST:event_btnPararMouseExited

    private void btnPararMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPararMouseEntered
        btnParar.setBackground(new Color(200, 200, 200));
        btnParar.setForeground(new Color(25,25,25));
    }//GEN-LAST:event_btnPararMouseEntered

    private void btnCloseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCloseMouseEntered
        btnClose.setBackground(new Color(200, 200, 200));
        btnClose.setForeground(new Color(25,25,25));
    }//GEN-LAST:event_btnCloseMouseEntered

    private void btnCloseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCloseMouseExited
        btnClose.setBackground(new Color(90, 1, 90));
        btnClose.setForeground(new Color(247, 247, 247));
    }//GEN-LAST:event_btnCloseMouseExited

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnCloseActionPerformed

    private void loop() {
        while (runner == Thread.currentThread()) {
            ApiJavaApplication apiJavaApplication = new ApiJavaApplication();
            Processador processor = new Processador();

            apiJavaApplication.runLooca(processor.getId());
        }
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Background;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnIniciar;
    private javax.swing.JButton btnParar;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel labelBV;
    private javax.swing.JLabel labelCPU;
    private javax.swing.JLabel labelDevice;
    private javax.swing.JLabel labelDeviceName;
    private javax.swing.JLabel labelHD;
    private javax.swing.JLabel labelOS;
    private javax.swing.JLabel labelRAM;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
