/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author HT3rico
*/
public class ScreenBack extends JFrame{
    final int WID = 1200;
    final int HEI = 800;
    private JLabel AnhNen = new JLabel("Hình nền");
    private final JButton Add = new JButton("Add");
    private final JButton Delete = new JButton("Delete");
    private final JTextField Search = new JTextField();
    public ScreenBack() {
        setSize(WID,HEI);
        setVisible(true);
        //Vi tri xuat hien
        setLocation(300,150);
        //Re_Size
        setResizable(false);
        //Tat het = X
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Set Hinh Nen;
        AnhNen.setSize(WID,HEI);
        add(AnhNen);
        add(Add,"East",1);
        add(Delete,"South",1);
        add(Search,"North",1);
//        label.setText("Đoán lại nào giáo sư");
//        label.setToolTipText("Đéo đoán");
//        label.setForeground(Color.BLUE);

//        try {
//           BufferedImage image  = ImageIO.read(new File("img/Back.jpg"));
//           ImageIcon hinhnen = new ImageIcon(image.getScaledInstance(1200,770,BufferedImage.SCALE_SMOOTH));
//           AnhNen.setIcon(hinhnen);
//        } catch (IOException ex) {
//            Logger.getLogger(ScreenBack.class.getName()).log(Level.SEVERE, null, ex);
//        }    
        
//        Add.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                //JOptionPane.showMessageDialog(null,"That's cú lừa","Vì tôi buôn",JOptionPane.YES_OPTION);
//                //AnhNen.setText("Làm lại");
//                JOptionPane.showMessageDialog(null,Search.getText());
//            }
//        });
//        Delete.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                int click = JOptionPane.showConfirmDialog(null,"Yên tâm, đổi nhé !!","Title",JOptionPane.YES_NO_OPTION);
//                if (click ==JOptionPane.YES_OPTION) JOptionPane.showMessageDialog(null,"Chọn có");
//                if (click ==JOptionPane.NO_OPTION) JOptionPane.showMessageDialog(null,"Chọn đéo");
//                if (click ==JOptionPane.CANCEL_OPTION) JOptionPane.showMessageDialog(null,"Chọn hủy");
//                if (click ==JOptionPane.CLOSED_OPTION);
//            }
//        });
    }
}