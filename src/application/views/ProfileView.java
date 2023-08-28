package application.views;

import javax.swing.ImageIcon;

public class ProfileView extends javax.swing.JPanel {

    public ProfileView() {
        initComponents();

        jPanel2.putClientProperty("FlatLaf.style",
                "arc: 20;"
        );

        tbtEditPersonal.putClientProperty("FlatLaf.style",
                "foreground: #FFF;"
                + "background: #1D90F5;"
                + "hoverBackground: darken(#1D90F5,5%);"
        );

        btnSavePersonal.setDisabledIcon(new ImageIcon(getClass().getResource("/main/assets/images/save-fff.png")));

        lblErrorFirstName.setVisible(false);

        lblErrorLastName.setVisible(false);

        lblErrorEmail.setVisible(false);

        lblErrorPhone.setVisible(false);

        jPanel3.putClientProperty("FlatLaf.style",
                "arc: 20;"
        );

        tbtEditAddress.putClientProperty("FlatLaf.style",
                "foreground: #FFF;"
                + "background: #1D90F5;"
                + "hoverBackground: darken(#1D90F5,5%);"
        );

        btnSaveAddress.setDisabledIcon(new ImageIcon(getClass().getResource("/main/assets/images/save-fff.png")));

        lblErrorDepartment.setVisible(false);

        lblErrorCity.setVisible(false);

        lblErrorAddress.setVisible(false);

        jPanel4.putClientProperty("FlatLaf.style",
                "arc: 20;"
        );

        pwdNewPass.putClientProperty("JTextField.placeholderText", "Introduce la nueva contraseña");

        pwdConfirmPass.putClientProperty("JTextField.placeholderText", "Confirmar la nueva contraseña");
        pwdConfirmPass.putClientProperty("FlatLaf.style",
                "showRevealButton: false;"
        );

        lblNewPassErrorMessage.setVisible(false);
        lblConfirmPassErrorMenssage.setVisible(false);

        btnRestore.setDisabledIcon(new ImageIcon(getClass().getResource("/main/assets/images/save-fff.png")));

        btnLogout.putClientProperty("FlatLaf.style",
                "foreground: #FFF;"
                + "background: #F51D24;"
                + "hoverBackground: darken(#F51D24,5%);"
        );
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tbtEditPersonal = new javax.swing.JToggleButton();
        btnSavePersonal = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtFirstName = new javax.swing.JTextField();
        lblErrorFirstName = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtLastName = new javax.swing.JTextField();
        lblErrorLastName = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        lblErrorEmail = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtPhone = new javax.swing.JTextField();
        lblErrorPhone = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        tbtEditAddress = new javax.swing.JToggleButton();
        btnSaveAddress = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        cmbDepartment = new javax.swing.JComboBox<>();
        lblErrorDepartment = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        cmbCity = new javax.swing.JComboBox<>();
        lblErrorCity = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtAddress = new javax.swing.JTextField();
        lblErrorAddress = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        pwdNewPass = new javax.swing.JPasswordField();
        lblNewPassErrorMessage = new javax.swing.JLabel();
        pwdConfirmPass = new javax.swing.JPasswordField();
        lblConfirmPassErrorMenssage = new javax.swing.JLabel();
        btnRestore = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();

        setBackground(new java.awt.Color(246, 246, 248));

        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jPanel1.setBackground(new java.awt.Color(246, 246, 248));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel1.setText("Información personal");

        tbtEditPersonal.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        tbtEditPersonal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/assets/images/edit-fff.png"))); // NOI18N
        tbtEditPersonal.setText("Editar");
        tbtEditPersonal.setIconTextGap(10);

        btnSavePersonal.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        btnSavePersonal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/assets/images/save-fff.png"))); // NOI18N
        btnSavePersonal.setText("Guardar");
        btnSavePersonal.setEnabled(false);
        btnSavePersonal.setIconTextGap(10);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(126, 126, 146));
        jLabel2.setText("Nombre");

        txtFirstName.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        txtFirstName.setEnabled(false);

        lblErrorFirstName.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        lblErrorFirstName.setForeground(new java.awt.Color(245, 29, 36));
        lblErrorFirstName.setText("Error message");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(126, 126, 146));
        jLabel4.setText("Apellido");

        txtLastName.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        txtLastName.setEnabled(false);

        lblErrorLastName.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        lblErrorLastName.setForeground(new java.awt.Color(245, 29, 36));
        lblErrorLastName.setText("Error message");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(126, 126, 146));
        jLabel6.setText("Dirección de correo electrónico");

        txtEmail.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        txtEmail.setEnabled(false);

        lblErrorEmail.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        lblErrorEmail.setForeground(new java.awt.Color(245, 29, 36));
        lblErrorEmail.setText("Error message");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(126, 126, 146));
        jLabel8.setText("Número de celular/teléfono");

        txtPhone.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        txtPhone.setEnabled(false);

        lblErrorPhone.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        lblErrorPhone.setForeground(new java.awt.Color(245, 29, 36));
        lblErrorPhone.setText("Error message");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tbtEditPersonal, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(btnSavePersonal, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 730, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(5, 5, 5)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(lblErrorFirstName)
                                            .addComponent(jLabel6))))
                                .addGap(16, 16, 16)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(5, 5, 5)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblErrorLastName)
                                            .addComponent(jLabel4)))))
                            .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblErrorPhone)
                                    .addComponent(jLabel8)
                                    .addComponent(lblErrorEmail))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(15, 15, 15))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnSavePersonal, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tbtEditPersonal, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addGap(5, 5, 5)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblErrorFirstName)
                    .addComponent(lblErrorLastName))
                .addGap(10, 10, 10)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(lblErrorEmail)
                .addGap(10, 10, 10)
                .addComponent(jLabel8)
                .addGap(5, 5, 5)
                .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(lblErrorPhone)
                .addGap(20, 20, 20))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel11.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel11.setText("Dirección");

        tbtEditAddress.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        tbtEditAddress.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/assets/images/edit-fff.png"))); // NOI18N
        tbtEditAddress.setText("Editar");
        tbtEditAddress.setIconTextGap(10);
        tbtEditAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbtEditAddressActionPerformed(evt);
            }
        });

        btnSaveAddress.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        btnSaveAddress.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/assets/images/save-fff.png"))); // NOI18N
        btnSaveAddress.setText("Guardar");
        btnSaveAddress.setEnabled(false);
        btnSaveAddress.setIconTextGap(10);
        btnSaveAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveAddressActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(126, 126, 146));
        jLabel12.setText("Departamento");

        cmbDepartment.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        cmbDepartment.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione un departamento" }));
        cmbDepartment.setEnabled(false);
        cmbDepartment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbDepartmentActionPerformed(evt);
            }
        });

        lblErrorDepartment.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        lblErrorDepartment.setForeground(new java.awt.Color(245, 29, 36));
        lblErrorDepartment.setText("Error message");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(126, 126, 146));
        jLabel14.setText("Ciudad");

        cmbCity.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        cmbCity.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una ciudad" }));
        cmbCity.setEnabled(false);

        lblErrorCity.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        lblErrorCity.setForeground(new java.awt.Color(245, 29, 36));
        lblErrorCity.setText("Error message");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(126, 126, 146));
        jLabel16.setText("Dirección de residencia");

        txtAddress.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        txtAddress.setEnabled(false);

        lblErrorAddress.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        lblErrorAddress.setForeground(new java.awt.Color(245, 29, 36));
        lblErrorAddress.setText("Error message");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addComponent(lblErrorDepartment)
                                    .addComponent(jLabel16)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(cmbDepartment, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14)
                                    .addComponent(lblErrorCity)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(cmbCity, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tbtEditAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(btnSaveAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(lblErrorAddress))
                            .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 730, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(15, 15, 15))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSaveAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(tbtEditAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel14))
                .addGap(5, 5, 5)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbDepartment, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbCity, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblErrorDepartment)
                    .addComponent(lblErrorCity))
                .addGap(10, 10, 10)
                .addComponent(jLabel16)
                .addGap(5, 5, 5)
                .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(lblErrorAddress)
                .addGap(20, 20, 20))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel18.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel18.setText("Cambiar contraseña");

        pwdNewPass.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N

        lblNewPassErrorMessage.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        lblNewPassErrorMessage.setForeground(new java.awt.Color(245, 29, 36));
        lblNewPassErrorMessage.setText("Error message");

        pwdConfirmPass.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N

        lblConfirmPassErrorMenssage.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        lblConfirmPassErrorMenssage.setForeground(new java.awt.Color(245, 29, 36));
        lblConfirmPassErrorMenssage.setText("Error message");

        btnRestore.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        btnRestore.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/assets/images/save-fff.png"))); // NOI18N
        btnRestore.setText("Guardar cambios");
        btnRestore.setEnabled(false);
        btnRestore.setIconTextGap(10);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(lblNewPassErrorMessage))
                            .addComponent(pwdNewPass, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(lblConfirmPassErrorMenssage))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(pwdConfirmPass, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(16, 16, 16)
                                .addComponent(btnRestore, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel18))
                .addGap(15, 15, 15))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel18)
                .addGap(26, 26, 26)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(pwdNewPass, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(lblNewPassErrorMessage))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pwdConfirmPass, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRestore, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addComponent(lblConfirmPassErrorMenssage)))
                .addGap(20, 20, 20))
        );

        btnLogout.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        btnLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/assets/images/sign out-fff.png"))); // NOI18N
        btnLogout.setText("Cerrar sesión");
        btnLogout.setIconTextGap(10);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveAddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSaveAddressActionPerformed

    private void tbtEditAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbtEditAddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbtEditAddressActionPerformed

    private void cmbDepartmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbDepartmentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbDepartmentActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnLogout;
    public javax.swing.JButton btnRestore;
    public javax.swing.JButton btnSaveAddress;
    public javax.swing.JButton btnSavePersonal;
    public javax.swing.JComboBox<String> cmbCity;
    public javax.swing.JComboBox<String> cmbDepartment;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JLabel lblConfirmPassErrorMenssage;
    public javax.swing.JLabel lblErrorAddress;
    public javax.swing.JLabel lblErrorCity;
    public javax.swing.JLabel lblErrorDepartment;
    public javax.swing.JLabel lblErrorEmail;
    public javax.swing.JLabel lblErrorFirstName;
    public javax.swing.JLabel lblErrorLastName;
    public javax.swing.JLabel lblErrorPhone;
    public javax.swing.JLabel lblNewPassErrorMessage;
    public javax.swing.JPasswordField pwdConfirmPass;
    public javax.swing.JPasswordField pwdNewPass;
    public javax.swing.JToggleButton tbtEditAddress;
    public javax.swing.JToggleButton tbtEditPersonal;
    public javax.swing.JTextField txtAddress;
    public javax.swing.JTextField txtEmail;
    public javax.swing.JTextField txtFirstName;
    public javax.swing.JTextField txtLastName;
    public javax.swing.JTextField txtPhone;
    // End of variables declaration//GEN-END:variables
}
