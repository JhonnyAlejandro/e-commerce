package application.views;

public class LoginView extends javax.swing.JFrame {

    public LoginView() {
        initComponents();

        txtEmail.putClientProperty("JTextField.placeholderText", "Dirección de correo electrónico");

        lblEmailErrorMessage.setVisible(false);

        pwdPassword.putClientProperty("JTextField.placeholderText", "Contraseña");

        lblPasswordErrorMessage.setVisible(false);

        btnAccess.putClientProperty("FlatLaf.style",
                "foreground: #FFF;"
                + "background: #1D90F5;"
                + "hoverBackground: darken(#1D90F5,5%);"
        );

        btnHelp.putClientProperty("JButton.buttonType", "help");

        jPanel1.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblCredentialsErrorMessage = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        lblEmailErrorMessage = new javax.swing.JLabel();
        pwdPassword = new javax.swing.JPasswordField();
        lblPasswordErrorMessage = new javax.swing.JLabel();
        chkAutofill = new javax.swing.JCheckBox();
        btnAccess = new javax.swing.JButton();
        btnHelp = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(245, 29, 36));

        lblCredentialsErrorMessage.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        lblCredentialsErrorMessage.setForeground(new java.awt.Color(255, 255, 255));
        lblCredentialsErrorMessage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCredentialsErrorMessage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/assets/images/warning.png"))); // NOI18N
        lblCredentialsErrorMessage.setText("Error message");
        lblCredentialsErrorMessage.setIconTextGap(10);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lblCredentialsErrorMessage, javax.swing.GroupLayout.DEFAULT_SIZE, 670, Short.MAX_VALUE)
                .addGap(15, 15, 15))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblCredentialsErrorMessage, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel2.setText("Iniciar sesión");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(126, 126, 146));
        jLabel3.setText("<html>Bienvenido, a continuación ingrese sus<br>credenciales de inicio de sesión.</html>");

        txtEmail.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N

        lblEmailErrorMessage.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        lblEmailErrorMessage.setForeground(new java.awt.Color(245, 29, 36));
        lblEmailErrorMessage.setText("Error message");

        pwdPassword.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N

        lblPasswordErrorMessage.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        lblPasswordErrorMessage.setForeground(new java.awt.Color(245, 29, 36));
        lblPasswordErrorMessage.setText("Error message");

        chkAutofill.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        chkAutofill.setForeground(new java.awt.Color(126, 126, 146));
        chkAutofill.setText("Ingresar automáticamente.");

        btnAccess.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        btnAccess.setText("Iniciar sesión");

        btnHelp.setText("?");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(126, 126, 146));
        jLabel6.setText("¿Has olvidado tu contraseña?");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(126, 126, 146));
        jLabel7.setText("©2023 Estación Arcoíris Kids.");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnHelp)
                        .addGap(5, 5, 5)
                        .addComponent(jLabel6))
                    .addComponent(btnAccess, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chkAutofill)
                    .addComponent(pwdPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblEmailErrorMessage)
                            .addComponent(lblPasswordErrorMessage))))
                .addGap(50, 50, 50))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel2)
                .addGap(10, 10, 10)
                .addComponent(jLabel3)
                .addGap(25, 25, 25)
                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(lblEmailErrorMessage)
                .addGap(10, 10, 10)
                .addComponent(pwdPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(lblPasswordErrorMessage)
                .addGap(10, 10, 10)
                .addComponent(chkAutofill)
                .addGap(15, 15, 15)
                .addComponent(btnAccess, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnHelp, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(25, 25, 25))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 350, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAccess;
    public javax.swing.JButton btnHelp;
    public javax.swing.JCheckBox chkAutofill;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    public javax.swing.JPanel jPanel1;
    public javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    public javax.swing.JLabel lblCredentialsErrorMessage;
    public javax.swing.JLabel lblEmailErrorMessage;
    public javax.swing.JLabel lblPasswordErrorMessage;
    public javax.swing.JPasswordField pwdPassword;
    public javax.swing.JTextField txtEmail;
    // End of variables declaration//GEN-END:variables
}
