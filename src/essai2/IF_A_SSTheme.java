/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package essai2;

/**
 *
 * @author HP
 */
public class IF_A_SSTheme extends javax.swing.JInternalFrame {

    /**
     * Creates new form IF_A_SSTheme
     */
    public IF_A_SSTheme() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        panelTableSSTheme = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableSSTheme = new javax.swing.JTable();
        panelRechercheLangue = new javax.swing.JPanel();
        txtRecherche = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("SOUS-THEMES");

        panelTableSSTheme.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Sous-Thèmes", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N
        panelTableSSTheme.setLayout(new java.awt.GridBagLayout());

        jTableSSTheme.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Id", "SOUS-THEME", "ACTIF"
            }
        ));
        jTableSSTheme.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableSSThemeMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableSSTheme);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 770;
        gridBagConstraints.ipady = 356;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(17, 16, 18, 16);
        panelTableSSTheme.add(jScrollPane1, gridBagConstraints);

        panelRechercheLangue.setBorder(javax.swing.BorderFactory.createTitledBorder("Recherche"));
        panelRechercheLangue.setLayout(new java.awt.GridBagLayout());

        txtRecherche.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtRechercheMouseClicked(evt);
            }
        });
        txtRecherche.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtRechercheKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtRechercheKeyReleased(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 232;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(27, 16, 23, 16);
        panelRechercheLangue.add(txtRecherche, gridBagConstraints);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelRechercheLangue, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelTableSSTheme, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelRechercheLangue, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelTableSSTheme, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTableSSThemeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableSSThemeMouseClicked
        try {
            int row = jTableSSTheme.getSelectedRow();
            String Table_click = (jTableSSTheme.getModel().getValueAt(row, 0).toString());
            String req = "SELECT idLangue, nomLangue,actifLangue"
            + " from Langue WHERE IdLangue='" + Table_click + "' ";
            ResultSet rs = langue.selectionner(req);
            if (rs.next()) {
                String add1 = rs.getString("idLangue");
                fen.getIfLangue().getTxtId().setText(add1);
                String add2 = rs.getString("nomLangue");
                fen.getIfLangue().getTxtLangue().setText(add2);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }
    }//GEN-LAST:event_jTableSSThemeMouseClicked

    private void txtRechercheMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtRechercheMouseClicked

    }//GEN-LAST:event_txtRechercheMouseClicked

    private void txtRechercheKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRechercheKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRechercheKeyPressed

    private void txtRechercheKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRechercheKeyReleased
        // TODO add your handling code here:

        try{
            String req = "SELECT idLangue AS ID, nomLangue AS LANGUE,actifLangue AS ACTIF"
            + " from Langue"
            + " where nomLangue like ?";
            ResultSet rs = langue.rechercher(req,"%"+txtRecherche.getText()+"%");
            jTableSSTheme.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){

            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_txtRechercheKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableSSTheme;
    private javax.swing.JPanel panelRechercheLangue;
    private javax.swing.JPanel panelTableSSTheme;
    private javax.swing.JTextField txtRecherche;
    // End of variables declaration//GEN-END:variables
}
