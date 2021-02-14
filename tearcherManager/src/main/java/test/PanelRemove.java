package test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import common.Seting;

public class PanelRemove extends JFrame implements ActionListener {
	
	JButton jButton,jButton2;
	JPanel jPanel,jPanel2;
	
	public PanelRemove() {
		
		jPanel = new JPanel();
		jPanel.setLayout(new BorderLayout());
		jPanel2 = new JPanel();
		jPanel2.setLayout(new FlowLayout());
		jPanel2.setBackground(Color.GREEN);
		jButton = new JButton("안녕");
		jButton.addActionListener(this);
		jButton.setPreferredSize(new Dimension(50, 40));
		jPanel2.add(jButton);
		jPanel.add(jPanel2,"North");
		add(jPanel);
		setSize(500, 300);
		Seting.getInstance(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("요기");
		jPanel2.remove(jButton);
		JButton jb = new JButton("추가");
		jPanel2.add(jb);
		//jPanel.invalidate();
		//jPanel.validate();
		jPanel2.revalidate();
		jPanel2.repaint();
	}
	
	public static void main(String[] args) {
		PanelRemove panelRemove = new PanelRemove();
	}
}
