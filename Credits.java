import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;

public class Credits extends JDialog {

	private final JPanel creditframe = new JPanel();
	private JButton okButton;
	private final Action ButtonClose = new ButtonClose();
		
	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		
		

			
		
	}

	/**
	 * Create the dialog.
	 */
	public Credits() {
		setTitle("Credits");
		setBounds(100, 100, 227, 199);
		getContentPane().setLayout(new BorderLayout());
		creditframe.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(creditframe, BorderLayout.CENTER);
		{
			okButton = new JButton("OK");
			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) 
				{
					setVisible(false); //make instance of window invisible
				}
			});
			okButton.setAction(ButtonClose);
			okButton.setActionCommand("OK");
			getRootPane().setDefaultButton(okButton);
		}
		
		JLabel Credit1 = new JLabel("SQL Building Framework");
		Credit1.setFont(new Font("Tunga", Font.PLAIN, 17));
		
		JLabel Credit2 = new JLabel("Developed by: Louis Smith");
		
		JLabel credit3 = new JLabel("Submission for Small Scale Apps");
		
		JLabel credit4 = new JLabel("BCS Applied Computing Year 1 ");
		GroupLayout gl_creditframe = new GroupLayout(creditframe);
		gl_creditframe.setHorizontalGroup(
			gl_creditframe.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_creditframe.createSequentialGroup()
					.addGroup(gl_creditframe.createParallelGroup(Alignment.LEADING)
						.addComponent(Credit1, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_creditframe.createSequentialGroup()
							.addContainerGap()
							.addComponent(Credit2))
						.addGroup(gl_creditframe.createSequentialGroup()
							.addContainerGap()
							.addComponent(credit3))
						.addGroup(gl_creditframe.createSequentialGroup()
							.addContainerGap()
							.addComponent(credit4))
						.addGroup(gl_creditframe.createSequentialGroup()
							.addGap(56)
							.addComponent(okButton)))
					.addContainerGap(62, Short.MAX_VALUE))
		);
		gl_creditframe.setVerticalGroup(
			gl_creditframe.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_creditframe.createSequentialGroup()
					.addComponent(Credit1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(Credit2)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(credit3)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(credit4)
					.addGap(18)
					.addComponent(okButton)
					.addContainerGap(104, Short.MAX_VALUE))
		);
		creditframe.setLayout(gl_creditframe);
	}
	private class ButtonClose extends AbstractAction {
		public ButtonClose() {
			putValue(NAME, "Ok");
			putValue(SHORT_DESCRIPTION, null);
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
