package test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import org.jdatepicker.DatePicker;

import answerDTO.AnswerMDTO;

/**
 * This Swing program demonstrates how to scroll a table row to visible area
 * programmatically.
 * @author www.codejava.net
 *
 */
public class JTableRowScrollingExample extends JFrame implements ActionListener {

    private JTable table = new JTable();
    private JLabel label = new JLabel("Row number: ");
    private JTextField fieldRowNumber = new JTextField(5);
    private JButton buttonScroll = new JButton("Scroll to");
	Container containerPane;
	JPanel boardPanel,menuPanel,bodyPanel,footPanel,subBoardPanel,subTopPanel,bodySubPanel1,bodySubPanel2;
	JLabel jLabel,totalJLabel;
	JScrollPane jScrollPane;
	DatePicker picker;
	String topName = "객관식답안설정";
	Font font = new Font("Serif",Font.BOLD,16);
	int align = (int) JFrame.CENTER_ALIGNMENT;
	Border border = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
	Dimension dimension;
	GridBagLayout gb;
	GridBagConstraints gbc;
	public static JTextField jLabelTitle,jLableExam,jLableDate;
	JTextField answerM,answerS,answerN;
	JButton checkButton,backButton;
	int objectWidth;
	int objectHeight;
	boolean modifyFlag;
	Calendar c = Calendar.getInstance();

    public JTableRowScrollingExample() {
        super("JTable Row Scrolling Example");
        
		gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
		gb = new GridBagLayout();

        bodyPanel = new JPanel(new BorderLayout(0, 2));
		bodySubPanel1 = new JPanel();
		bodySubPanel1.setLayout(gb);
		
		bodySubPanel2 = new JPanel();
		bodySubPanel2.setLayout(gb);
		bodySubPanel2.setSize(100,100);
		bodySubPanel2.setBackground(Color.red);
	
		
		gbAdd(new JLabel("답안설정"),0,0,3,1,new Insets(0, 0, 20, 0),align,border,bodySubPanel1);
		gbAdd(new JLabel("번호"),0,1,1,1,new Insets(0, 0, 0, 0),align,border,bodySubPanel1);
		gbAdd(new JLabel("답안"),1,1,1,1,new Insets(0, 0, 0, 0),align,border,bodySubPanel1);
		gbAdd(new JLabel("배점"),2,1,1,1,new Insets(0, 0, 0, 0),align,border,bodySubPanel1);

		Integer[] temp = new Integer[5];
		for (int i = 1; i <= temp.length; i++) {
			temp[i-1] = i;
		}
		ArrayList<AnswerMDTO> mdto = new ArrayList<AnswerMDTO>(); 
		
		for (int i = 1; i <= 10; i++) {
			JComboBox<Integer> jComboBox = new JComboBox<Integer>(temp);
			JTextField jTextField = new JTextField();
			new AnswerMDTO(jComboBox, i, jTextField);
			gbAdd(new JLabel(String.valueOf(i)),0,i-1,1,1,new Insets(0, 0, 0, 0),align,border,bodySubPanel2);
			gbAdd(jComboBox,1,i-1,1,1,new Insets(0, 0, 0, 0),align,border,bodySubPanel2);
			gbAdd(jTextField,2,i-1,1,1,new Insets(0, 0, 0, 0),align,border,bodySubPanel2);
			/*
			if(i == 10) 
			{
				gbAdd(new JLabel("총점(40)"),0,i,2,1,new Insets(0, 0, 0, 0),align,border,bodySubPanel2);
				gbAdd(totalJLabel,2,i,1,1,new Insets(0, 0, 0, 0),align,border,bodySubPanel2);
			}
			*/
		}

        JScrollPane scrollpane = new JScrollPane(bodySubPanel2);
        scrollpane.setPreferredSize(new Dimension(300, 150));

        add(scrollpane, BorderLayout.CENTER);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.add(label);
        panel.add(fieldRowNumber);
        panel.add(buttonScroll);

        add(panel, BorderLayout.NORTH);

        buttonScroll.addActionListener(this);

        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
    
	void gbAdd(JComponent object, int x, int y, int w, int h,Insets insets,int align, Border border,JPanel jPanel) {
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = w;
        gbc.gridheight = h;
        gbc.insets = insets;

		if (object instanceof JButton) {
			((AbstractButton) object).setHorizontalAlignment(align);
			object.setFont(font);
		} else if ((object instanceof JLabel)) {
			((JLabel) object).setHorizontalAlignment(align);
			object.setFont(font);
		} else if ((object instanceof JTextField)) {
			((JTextField) object).setHorizontalAlignment(align);
			object.setFont(new Font("Serif", Font.BOLD, 16));
		}
		
		object.setBorder(border);
		object.setPreferredSize(dimension);
		jPanel.add(object, gbc);
	}
    
    

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new JTableRowScrollingExample().setVisible(true);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        int rowNumber = Integer.parseInt(fieldRowNumber.getText());
        Rectangle cellRect = table.getCellRect(rowNumber, 0, false);
        System.out.println(cellRect);
        table.scrollRectToVisible(cellRect);
    }
}