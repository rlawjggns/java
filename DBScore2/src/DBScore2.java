
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.*;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author kjh
 */
public class DBScore2 extends javax.swing.JFrame {
    DBManager db;
    /**
     * Creates new form DBScore
     */
    public DBScore2() {
        initComponents();
        db = MySqlDBManager.getInstance();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jModPnl = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jNameTxt = new javax.swing.JTextField();
        jKorTxt = new javax.swing.JTextField();
        jEngTxt = new javax.swing.JTextField();
        jMathTxt = new javax.swing.JTextField();
        jAvgTxt = new javax.swing.JTextField();
        jNumTxt = new javax.swing.JTextField();
        jControlPnl = new javax.swing.JPanel();
        jInsertBtn = new javax.swing.JButton();
        jUpdateBtn = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jDeleteBtn = new javax.swing.JButton();
        jSearchBtn = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jResultPnl = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jModPnl.setLayout(new java.awt.GridLayout(2, 0));

        jLabel1.setText("이름");
        jModPnl.add(jLabel1);

        jLabel2.setText("국어");
        jModPnl.add(jLabel2);

        jLabel3.setText("영어");
        jModPnl.add(jLabel3);

        jLabel4.setText("수학");
        jModPnl.add(jLabel4);

        jLabel5.setText("평균");
        jModPnl.add(jLabel5);

        jLabel6.setText("학번");
        jModPnl.add(jLabel6);
        jModPnl.add(jNameTxt);
        jModPnl.add(jKorTxt);
        jModPnl.add(jEngTxt);
        jModPnl.add(jMathTxt);
        jModPnl.add(jAvgTxt);
        jModPnl.add(jNumTxt);

        jControlPnl.setLayout(new java.awt.GridLayout(2, 0));

        jInsertBtn.setText("추가하기");
        jInsertBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jInsertBtnActionPerformed(evt);
            }
        });
        jControlPnl.add(jInsertBtn);

        jUpdateBtn.setText("수정하기");
        jUpdateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jUpdateBtnActionPerformed(evt);
            }
        });
        jControlPnl.add(jUpdateBtn);
        jControlPnl.add(jButton4);

        jDeleteBtn.setText("삭제하기");
        jDeleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jDeleteBtnActionPerformed(evt);
            }
        });
        jControlPnl.add(jDeleteBtn);

        jSearchBtn.setText("조회하기");
        jSearchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSearchBtnActionPerformed(evt);
            }
        });
        jControlPnl.add(jSearchBtn);
        jControlPnl.add(jButton1);

        jResultPnl.setLayout(new java.awt.GridLayout(0, 5));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jModPnl, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
            .addComponent(jControlPnl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jResultPnl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jModPnl, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jControlPnl, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jResultPnl, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jInsertBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jInsertBtnActionPerformed
        String sql = "insert into student(name, kor, eng, math) values('"+jNameTxt.getText() + "','" +jKorTxt.getText()+"','"+jEngTxt.getText()+"','"+jMathTxt.getText() +"')";
        db.executeUpdate(sql);
        makeResult();
    }//GEN-LAST:event_jInsertBtnActionPerformed

    private void jUpdateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jUpdateBtnActionPerformed
        if (clickedObj == null) {
            return;
        }
        String number = jNumTxt.getText(); 
        String name = jNameTxt.getText();
        String kor = jKorTxt.getText();
        String eng = jEngTxt.getText();
        String math = jMathTxt.getText();
        
        String sql = "update student set name = '"+name+"', kor='"+kor+"', eng='"+eng+"', math='"+math+"' where no='"+number+"'";
        db.executeUpdate(sql);
        makeResult();
        clickedObj =null;
    }//GEN-LAST:event_jUpdateBtnActionPerformed

    private void jDeleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jDeleteBtnActionPerformed
        if (clickedObj == null) {
            return;
        }
        String selectedName = jNameTxt.getText();
        
        String sql = "delete from student where name='"+ selectedName + "'";
        db.executeUpdate(sql);
        makeResult();
    }//GEN-LAST:event_jDeleteBtnActionPerformed

    private void jSearchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSearchBtnActionPerformed
        makeResult();
    }//GEN-LAST:event_jSearchBtnActionPerformed
    String[] clickedObj;
    public void makeResult() {
        jResultPnl.removeAll();
        ArrayList<String[]> list = db.executeQuery("select * from student");
        for (String[] values : list) {
            JButton obj = new JButton(values[0] + "-" + values[1]);
            obj.addActionListener(new java.awt.event.ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    clickedObj = values;
                    jNumTxt.setText("" + values[0]);
                    jNameTxt.setText("" + values[1]);
                    jKorTxt.setText("" + values[2]);
                    jEngTxt.setText("" + values[3]);
                    jMathTxt.setText("" + values[4]);
                    jAvgTxt.setText("" + values[5]);
                }
            });
            jResultPnl.repaint();
            jResultPnl.add(obj);
        }
        this.pack(); 
    }
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        db.closeConnection();
    }//GEN-LAST:event_formWindowClosing

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
            java.util.logging.Logger.getLogger(DBScore2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DBScore2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DBScore2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DBScore2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DBScore2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField jAvgTxt;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JPanel jControlPnl;
    private javax.swing.JButton jDeleteBtn;
    private javax.swing.JTextField jEngTxt;
    private javax.swing.JButton jInsertBtn;
    private javax.swing.JTextField jKorTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField jMathTxt;
    private javax.swing.JPanel jModPnl;
    private javax.swing.JTextField jNameTxt;
    private javax.swing.JTextField jNumTxt;
    private javax.swing.JPanel jResultPnl;
    private javax.swing.JButton jSearchBtn;
    private javax.swing.JButton jUpdateBtn;
    // End of variables declaration//GEN-END:variables
}