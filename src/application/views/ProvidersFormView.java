package application.views;

public class ProvidersFormView extends javax.swing.JPanel {

    public ProvidersFormView() {
        initComponents();

        jPanel2.putClientProperty("FlatLaf.style",
                "arc: 20;"
        );

        txtFirstNameAdd.putClientProperty("JTextField.placeholderText", "Nombre");

        lblerrorName.setVisible(false);

        txtLastNameAdd.putClientProperty("JTextField.placeholderText", "Apellido");

        lblerrorLastName.setVisible(false);

        txtEmailAdd.putClientProperty("JTextField.placeholderText", "Dirección de correo electrónico");

        lblerrorEmail.setVisible(false);

        txtPhoneAdd.putClientProperty("JTextField.placeholderText", "Número de celular/teléfono");

        jPanel3.putClientProperty("FlatLaf.style",
                "arc: 20;"
        );

        lblerrorPhone.setVisible(false);

        txtDepartmentAdd.putClientProperty("JTextField.placeholderText", "Departamento");

        lblerrorDepartment.setVisible(false);

        txtCityAdd.putClientProperty("JTextField.placeholderText", "Ciudad");

        lblerrorCity.setVisible(false);

        txtAdressAdd.putClientProperty("JTextField.placeholderText", "Dirección de residencia");

        lblerrorAdress.setVisible(false);

        btnAdd.putClientProperty("FlatLaf.style",
                "foreground: #FFF;"
                + "background: #1D90F5;"
                + "hoverBackground: darken(#1D90F5,5%);"
        );

        btnSave.putClientProperty("FlatLaf.style",
                "foreground: #FFF;"
                + "background: #F5821D;"
                + "hoverBackground: darken(#F5821D,5%);"
        );

        btnDelete.putClientProperty("FlatLaf.style",
                "foreground: #FFF;"
                + "background: #F51D24;"
                + "hoverBackground: darken(#F51D24,5%);"
        );
        
        btnCancel.putClientProperty("FlatLaf.style",
                "foreground: #FFF;"
                + "background: #F51D24;"
                + "hoverBackground: darken(#F51D24,5%);"
        );
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        txtFirstNameAdd = new javax.swing.JTextField();
        lblerrorName = new javax.swing.JLabel();
        txtLastNameAdd = new javax.swing.JTextField();
        lblerrorLastName = new javax.swing.JLabel();
        txtEmailAdd = new javax.swing.JTextField();
        lblerrorEmail = new javax.swing.JLabel();
        txtPhoneAdd = new javax.swing.JTextField();
        lblerrorPhone = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        txtDepartmentAdd = new javax.swing.JTextField();
        lblerrorDepartment = new javax.swing.JLabel();
        txtCityAdd = new javax.swing.JTextField();
        lblerrorCity = new javax.swing.JLabel();
        txtAdressAdd = new javax.swing.JTextField();
        lblerrorAdress = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();

        setBackground(new java.awt.Color(246, 246, 248));

        jPanel1.setBackground(new java.awt.Color(246, 246, 248));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        lblTitle.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        lblTitle.setText("Agregar/Editar/Eliminar proveedores");

        txtFirstNameAdd.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        txtFirstNameAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFirstNameAddActionPerformed(evt);
            }
        });

        lblerrorName.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        lblerrorName.setForeground(new java.awt.Color(245, 29, 36));
        lblerrorName.setText("Error message");

        txtLastNameAdd.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N

        lblerrorLastName.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        lblerrorLastName.setForeground(new java.awt.Color(245, 29, 36));
        lblerrorLastName.setText("Error message");

        txtEmailAdd.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N

        lblerrorEmail.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        lblerrorEmail.setForeground(new java.awt.Color(245, 29, 36));
        lblerrorEmail.setText("Error message");

        txtPhoneAdd.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        txtPhoneAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPhoneAddActionPerformed(evt);
            }
        });

        lblerrorPhone.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        lblerrorPhone.setForeground(new java.awt.Color(245, 29, 36));
        lblerrorPhone.setText("Error message");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtEmailAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 730, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFirstNameAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(lblerrorName)))
                        .addGap(16, 16, 16)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtLastNameAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(lblerrorLastName))))
                    .addComponent(txtPhoneAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblerrorPhone)
                            .addComponent(lblerrorEmail)))
                    .addComponent(lblTitle))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(lblTitle)
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFirstNameAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLastNameAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblerrorName)
                    .addComponent(lblerrorLastName))
                .addGap(15, 15, 15)
                .addComponent(txtEmailAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(lblerrorEmail)
                .addGap(15, 15, 15)
                .addComponent(txtPhoneAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(lblerrorPhone)
                .addGap(20, 20, 20))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        txtDepartmentAdd.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        txtDepartmentAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDepartmentAddActionPerformed(evt);
            }
        });

        lblerrorDepartment.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        lblerrorDepartment.setForeground(new java.awt.Color(245, 29, 36));
        lblerrorDepartment.setText("Error message");

        txtCityAdd.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N

        lblerrorCity.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        lblerrorCity.setForeground(new java.awt.Color(245, 29, 36));
        lblerrorCity.setText("Error message");

        txtAdressAdd.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N

        lblerrorAdress.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        lblerrorAdress.setForeground(new java.awt.Color(245, 29, 36));
        lblerrorAdress.setText("Error message");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDepartmentAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(lblerrorDepartment)))
                        .addGap(16, 16, 16)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCityAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(lblerrorCity))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(lblerrorAdress))
                    .addComponent(txtAdressAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 730, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDepartmentAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCityAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblerrorDepartment)
                    .addComponent(lblerrorCity))
                .addGap(15, 15, 15)
                .addComponent(txtAdressAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(lblerrorAdress)
                .addGap(20, 20, 20))
        );

        btnAdd.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/assets/images/add-fff.png"))); // NOI18N
        btnAdd.setText("Agregar");
        btnAdd.setIconTextGap(10);

        btnSave.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/assets/images/save-fff.png"))); // NOI18N
        btnSave.setText("Guardar cambios");
        btnSave.setIconTextGap(10);

        btnDelete.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/assets/images/delete-fff.png"))); // NOI18N
        btnDelete.setText("Eliminar");
        btnDelete.setIconTextGap(10);

        btnCancel.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        btnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/assets/images/cancel-fff.png"))); // NOI18N
        btnCancel.setText("Cancelar");
        btnCancel.setIconTextGap(10);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtFirstNameAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFirstNameAddActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFirstNameAddActionPerformed

    private void txtPhoneAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPhoneAddActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPhoneAddActionPerformed

    private void txtDepartmentAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDepartmentAddActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDepartmentAddActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAdd;
    public javax.swing.JButton btnCancel;
    public javax.swing.JButton btnDelete;
    public javax.swing.JButton btnSave;
    public javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    public javax.swing.JLabel lblTitle;
    public javax.swing.JLabel lblerrorAdress;
    public javax.swing.JLabel lblerrorCity;
    public javax.swing.JLabel lblerrorDepartment;
    public javax.swing.JLabel lblerrorEmail;
    public javax.swing.JLabel lblerrorLastName;
    public javax.swing.JLabel lblerrorName;
    public javax.swing.JLabel lblerrorPhone;
    public javax.swing.JTextField txtAdressAdd;
    public javax.swing.JTextField txtCityAdd;
    public javax.swing.JTextField txtDepartmentAdd;
    public javax.swing.JTextField txtEmailAdd;
    public javax.swing.JTextField txtFirstNameAdd;
    public javax.swing.JTextField txtLastNameAdd;
    public javax.swing.JTextField txtPhoneAdd;
    // End of variables declaration//GEN-END:variables
}
