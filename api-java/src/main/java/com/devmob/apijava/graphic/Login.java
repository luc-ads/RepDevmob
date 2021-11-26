package com.devmob.apijava.graphic;

import com.devmob.apijava.ApiJavaApplication;
import com.devmob.apijava.entities.Equipment;
import com.devmob.apijava.entities.User;
import com.github.britooo.looca.api.group.processador.Processador;
import com.devmob.apijava.gateway.database.DataSource;
import com.devmob.apijava.entities.User;
import com.devmob.apijava.gateway.repository.UserRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Login extends javax.swing.JFrame implements ActionListener {

    DataSource devmobDataSource = new DataSource();
    JdbcTemplate configDB = new JdbcTemplate(devmobDataSource.getDevmobDataSource());
    UserRowMapper userRow = new UserRowMapper();
    

    public Login() {
        initComponents();
        pack();
        setLocationRelativeTo(null);
        
        closeApp.setForeground(new Color(247, 247, 247));
        signIn.setForeground(new Color(247, 247, 247));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        emailField = new javax.swing.JTextField();
        signIn = new javax.swing.JButton();
        closeApp = new javax.swing.JButton();
        emailLabel = new javax.swing.JLabel();
        passwordLabel = new javax.swing.JLabel();
        showPassword = new javax.swing.JCheckBox();
        passwordField = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel4.setBackground(new java.awt.Color(203, 192, 212));

        emailField.setForeground(new java.awt.Color(153, 153, 153));
        emailField.setText("Email");
        emailField.setToolTipText("");
        emailField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        emailField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                emailFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                emailFieldFocusLost(evt);
            }
        });

        signIn.setBackground(new java.awt.Color(122, 76, 122));
        signIn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        signIn.setText("Sign In");
        signIn.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        signIn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                signInMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                signInMouseExited(evt);
            }
        });
        signIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signIn(evt);
            }
        });

        closeApp.setBackground(new java.awt.Color(90, 1, 90));
        closeApp.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        closeApp.setText("Close app");
        closeApp.setToolTipText("");
        closeApp.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        closeApp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                closeAppMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                closeAppMouseExited(evt);
            }
        });
        closeApp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeApp(evt);
            }
        });

        emailLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        emailLabel.setText("Email");

        passwordLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        passwordLabel.setText("Password");

        showPassword.setBackground(new java.awt.Color(203, 192, 212));
        showPassword.setText("Show Password");
        showPassword.setToolTipText("");
        showPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showPassword(evt);
            }
        });

        passwordField.setForeground(new java.awt.Color(153, 153, 153));
        passwordField.setText("Password");
        passwordField.setToolTipText("");
        passwordField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        passwordField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                passwordFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                passwordFieldFocusLost(evt);
            }
        });
        passwordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordFieldActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Menlo", 1, 24)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/devmob-logo.png"))); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(passwordLabel)
                    .addComponent(closeApp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(signIn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(emailLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(showPassword)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(130, 130, 130))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(emailLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(passwordLabel)
                .addGap(2, 2, 2)
                .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(showPassword)
                .addGap(22, 22, 22)
                .addComponent(signIn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(closeApp, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void passwordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordFieldActionPerformed

    private void passwordFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwordFieldFocusLost
        String pass = String.valueOf(passwordField.getPassword());

        if (pass.trim().equals("") || pass.trim().toLowerCase().equals("password")) {
            passwordField.setText("Password");
            passwordField.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_passwordFieldFocusLost

    private void passwordFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwordFieldFocusGained
        String pass = String.valueOf(passwordField.getPassword());

        if (pass.trim().toLowerCase().equals("password")) {
            passwordField.setText("");
            passwordField.setForeground(Color.black);
        }
    }//GEN-LAST:event_passwordFieldFocusGained

    private void showPassword(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showPassword
        if (evt.getSource() == showPassword) {
            if (showPassword.isSelected()) {
                passwordField.getPassword();
                passwordField.setEchoChar((char) 0);
            } else {
                passwordField.getPassword();
                passwordField.setEchoChar('*');
            }
        }
    }//GEN-LAST:event_showPassword

    private void closeApp(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeApp
        System.exit(0);
    }//GEN-LAST:event_closeApp

    private void closeAppMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeAppMouseExited
        closeApp.setBackground(new Color(90,1,90));
        closeApp.setForeground(new Color(247,247,247));
    }//GEN-LAST:event_closeAppMouseExited

    private void closeAppMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeAppMouseEntered
        closeApp.setBackground(new Color(200,200,200));
        closeApp.setForeground(new Color(25,25,25));
    }//GEN-LAST:event_closeAppMouseEntered

    private void signIn(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signIn
        String email = emailField.getText();
        String password = String.valueOf(passwordField.getPassword());

        List<User> userQuery = userRow.userQuery(email, password);

        Integer id = 0;
        Boolean login = Boolean.FALSE;

        for (User userLogin : userQuery) {
            if (userLogin.getUserEmail().equals(email) && userLogin.getUserPassword().equals(password)) {
                UserInterface obj = new UserInterface(userLogin.getIdUser(), userLogin.getUserName());
                JOptionPane.showMessageDialog(null, "Login successful");

                id = userLogin.getIdUser();
                login = Boolean.TRUE;

                this.dispose();
                obj.setVisible(true);
                obj.pack();
                obj.setLocationRelativeTo(null);
            }
        }
        if (login == Boolean.FALSE) {
            JOptionPane.showMessageDialog(null, "Login failed.\nInvalid Email or Password.");
        }
    }//GEN-LAST:event_signIn

    private void signInMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signInMouseExited
        signIn.setBackground(new Color(122,76,122));
        signIn.setForeground(new Color(247,247,247));
    }//GEN-LAST:event_signInMouseExited

    private void signInMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signInMouseEntered
        signIn.setBackground(new Color(200,200,200));
        signIn.setForeground(new Color(25,25,25));
    }//GEN-LAST:event_signInMouseEntered

    private void emailFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_emailFieldFocusLost
        if (emailField.getText().trim().equals("") || emailField.getText().trim().toLowerCase().equals("email")) {
            emailField.setText("Email");
            emailField.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_emailFieldFocusLost

    private void emailFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_emailFieldFocusGained
        if (emailField.getText().trim().toLowerCase().equals("email")) {
            emailField.setText("");
            emailField.setForeground(Color.black);
        }
    }//GEN-LAST:event_emailFieldFocusGained

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton closeApp;
    private javax.swing.JTextField emailField;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JCheckBox showPassword;
    private javax.swing.JButton signIn;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
