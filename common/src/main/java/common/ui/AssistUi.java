package common.ui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.ScrollPane;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

import org.apache.xmlbeans.impl.jam.JConstructor;

public class AssistUi {
	private int align = (int) JFrame.CENTER_ALIGNMENT;
	private Border border = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
	private Font font = new Font("Serif",Font.BOLD,16);
	private Dimension dimension;
	
	public AssistUi(Dimension dimension) {
		super();
		this.dimension = dimension;
	}

	public AssistUi(Border border, int align, Font font, Dimension dimension) {
		super();
		this.border = border;
		this.align = align;
		this.font = font;
		this.dimension = dimension;
	}
	
	public void decorateObject(JComponent object) {
		object.setBorder(border);
		if(object instanceof JLabel) 
		{
			((JLabel)object).setHorizontalAlignment(align);
		}else 
		{
			((JRadioButton)object).setHorizontalAlignment(align);
		}
		
		object.setFont(font);
		object.setPreferredSize(dimension);
	}
	
	public void decorateGridBagObject(GridBagConstraints gbc,JComponent object, int x, int y, int w, int h) {
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = w;
        gbc.gridheight = h;
        object.setBorder(border);
		if(object instanceof JLabel) 
		{
			((JLabel)object).setHorizontalAlignment(align);
		}else if(object instanceof JTextField) {
			((JTextField)object).setHorizontalAlignment(align);
		}
		
		object.setFont(font);
		object.setPreferredSize(new Dimension((int)dimension.getWidth()*w, (int)dimension.getHeight()*h));
	}
	
	public static JScrollPane scrollSetting(boolean horizontal,boolean vertical, int width, int height,Container container) {
		JScrollPane scrollPane = new JScrollPane();
		if(!horizontal)
		{
			scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER );
		}
		if(!vertical)
		{
			scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER );
		}
		scrollPane.setViewportView(container);
		scrollPane.setPreferredSize(new Dimension(width, height));
		
		return scrollPane;
	}
}
