package test;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.filechooser.FileNameExtensionFilter;
 
public class Test {
        public static void main (String [] args) {
                test_Frame tf = new test_Frame();
        }
}
                       
class test_Frame extends JFrame implements ActionListener{
       
        private JFileChooser jfc = new JFileChooser();
        private JButton jbt_open = new JButton("����");
        private JButton jbt_save = new JButton("����");
        private JLabel jlb = new JLabel(" ");
        public test_Frame(){
                super("test");
                this.init();
                this.start();
                this.setSize(400,200);
                this.setVisible(true);
        }
        public void init(){
                getContentPane().setLayout(new FlowLayout());
                add(jbt_open);
                add(jbt_save);
                add(jlb);
        }
        public void start(){
                jbt_open.addActionListener(this);
                jbt_save.addActionListener(this);
 
                jfc.setFileFilter(new FileNameExtensionFilter("txt", "txt"));
                // ���� ����
                jfc.setMultiSelectionEnabled(false);//���� ���� �Ұ�
        }
 
        @Override
        public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub
                if(arg0.getSource() == jbt_open){
                        if(jfc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION){
                                // showopendialog ���� â�� ���� Ȯ�� ��ư�� �������� Ȯ��
                                jlb.setText("���� ��� : " + jfc.getSelectedFile().toString());
                        }
                }else if(arg0.getSource() == jbt_save){
                        if(jfc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION){
                                // showSaveDialog ���� â�� ���� Ȯ�� ��ư�� �������� Ȯ��
                                jlb.setText("���� ��� : " + jfc.getSelectedFile().toString() + "." + jfc.getFileFilter().getDescription());
                        }
                }
        }
}