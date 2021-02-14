package addressbook.common;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class GbSupport {
	
	private GridBagConstraints gbc;
	private JPanel jPanel;
	private Border border;
	private int align;
	private Font font;
	private final int XSize;
	private final int YSize;
	
	
	public GbSupport(GridBagConstraints gbc,JPanel jPanel,Border border,int align,Font font,Dimension dimension) {
		this.gbc = gbc;
		this.jPanel = jPanel;
		this.border = border;
		this.align = align;
		this.font = font;
		this.XSize = (int)dimension.getWidth();
		this.YSize = (int)dimension.getHeight();
	}

	public void gbAdd(JComponent object, int x, int y, int w, int h,Insets insets) {
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = w;
        gbc.gridheight = h;
        gbc.insets = insets;

		if (object instanceof JButton) {
			((AbstractButton) object).setHorizontalAlignment(align);
		} else if ((object instanceof JLabel)) {
			((JLabel) object).setHorizontalAlignment(align);
		} else if ((object instanceof JTextField)) {
			((JTextField) object).setHorizontalAlignment(align);
		}
		
		object.setFont(font);
		
		object.setBorder(border);
		Dimension dimension = new Dimension(XSize*w, YSize*h);
		object.setPreferredSize(dimension);
		jPanel.add(object,gbc);
	}
}
