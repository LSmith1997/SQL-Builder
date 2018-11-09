
//Louis Smith
//Java Application, Submission for Small Scale Apps
//A program that simplifies the process of writing SQL code.
//Sequel Building Framework (SBF)

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.awt.Toolkit;
import java.awt.Font;

public class BodyMain 
{

	private JFrame frmSqlBuilder;
	private JTextField txtoutputField;
	private final Action SelectAction = new SelectAction(); // These are the
															// action handlers
															// for each button
	private final Action InsertAction = new InsertAction();
	private final Action UpdateAction = new UpdateAction();
	private final Action DistinctAction = new DistinctAction();
	private final Action LbracketAction = new LbracketAction();
	private final Action ExportAction = new ExportAction(); // handles exporting
	private final Action Deleteaction = new DeleteAction();
	private final Action AsAction = new AsAction();
	private final Action CaseAction = new CaseAction();
	private final Action Joinaction = new Joinaction();
	private final Action CreditAction = new CreditAction();
	private boolean textchange;

	/**
	 * Launch the application.
	 */
	// main
	public static void main(String[] args) //main 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					BodyMain window = new BodyMain();
					window.frmSqlBuilder.setVisible(true);
				} 
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		}
		);
	}// end of main

	/**
	 * Create the application.
	 * 
	 * @throws IOException
	 */

	public BodyMain() throws IOException // body main
	{

		initialize(); //starts the initialise
	}//end of body main

	/**
	 * Initialise the contents of the frame.
	 * 
	 * @throws IOException
	 */
	private void initialize() throws IOException 
	{
		frmSqlBuilder = new JFrame();
		frmSqlBuilder.setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\java\\Resources\\Icons\\key-1.png")); //sets icon for main frame body
		frmSqlBuilder.setTitle("SBF"); //adds title text
		frmSqlBuilder.setBounds(100, 100, 460, 381); //sets dimensions of frame
		frmSqlBuilder.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //sets close action

		txtoutputField = new JTextField(); // create Output Field
		txtoutputField.setColumns(10);

		txtoutputField.getDocument().addDocumentListener(new DocumentListener() //listens for any changes in txtoutputField
		{

			public void changedUpdate(DocumentEvent e) //detects if there has been a change in the textbox
			{ 

				textBoxChanged(); //when a change has been noticed call textboxChanged

			}

			@Override
			public void insertUpdate(DocumentEvent e) {

				textBoxChanged(); //when a change has been noticed call textboxChanged

			}

			@Override
			public void removeUpdate(DocumentEvent e)
			{

			}

		}
		);

		JButton btnSelect = new JButton("Select"); // Select button
		
		btnSelect.setToolTipText(" Adds Select * From ");//text for pop up box
		
		btnSelect.addActionListener(new ActionListener() // action listener for
															// select button
		{
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) 
			{
				txtoutputField.setText(txtoutputField.getText() + " Select * From" + " "); // prints
																							// select
																							// to
																							// output
																							// field
				txtoutputField.requestDefaultFocus();
			}
		}
		);
		btnSelect.setAction(SelectAction); // select action

		JButton btnInsert = new JButton("Insert"); // insert button
		btnInsert.setToolTipText("Adds Insert Statement"); //text for hover box
		btnInsert.addActionListener(new ActionListener() // action listener for
															// insert
		{

			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) 
			{
				txtoutputField.setText(txtoutputField.getText() + " Insert" + " "); // prints
																					// insert
																					// to
																					// output
																					// field
				txtoutputField.requestDefaultFocus(); // keeps text field active
			}

		});
		btnInsert.setAction(InsertAction); // insert action

		JButton btnUpdate = new JButton("Update"); //creates update button
		btnUpdate.setToolTipText("Adds Update Statement");
		btnUpdate.addActionListener(new ActionListener() // action Listener for
															// Update
		{
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) 
			{
				txtoutputField.setText(txtoutputField.getText() + " Update" + " ");// prints
																					// update
																					// text
				txtoutputField.requestDefaultFocus(); // keeps text field active
			}
		});
		btnUpdate.setAction(UpdateAction);

		JButton btnCreate = new JButton("Create"); // Create Jbutton for Create
		btnCreate.setToolTipText("Adds Create Statement");
		btnCreate.addActionListener(new ActionListener()
		{
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e)
			{
				txtoutputField.setText(txtoutputField.getText() + " Create" + " ");// prints
																					// create
																					// text
				txtoutputField.requestDefaultFocus(); // keeps text field active
			}
		});

		JButton btnAlter = new JButton("Alter"); // create Alter button
		btnAlter.setToolTipText("Adds Alter Statement");
		btnAlter.addActionListener(new ActionListener() 
		{ // code for alter
															// button
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) 
			{
				txtoutputField.setText(txtoutputField.getText() + " Alter" + " ");// prints
																					// alter
																					// text
				txtoutputField.requestDefaultFocus(); // keeps field active
			}
		});

		JButton btnDrop = new JButton("Drop"); // create Drop Button
		btnDrop.setToolTipText("Adds Drop Statement");
		btnDrop.addActionListener(new ActionListener() 
		{// code for Drop button
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) 
			{
				txtoutputField.setText(txtoutputField.getText() + " Drop" + " ");//adds text to box
				txtoutputField.requestDefaultFocus();
			}
		});

		JButton btnAsterisk = new JButton("*");
		btnAsterisk.setToolTipText("Adds Astericks");
		btnAsterisk.addActionListener(new ActionListener() { // code for
																// Asterisk
																// button
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) 
			{
				txtoutputField.setText(txtoutputField.getText() + " * " + " ");
				txtoutputField.requestDefaultFocus();
			}
		});

		JButton btnSemiC = new JButton(";");
		btnSemiC.setToolTipText("Adds Semi-Colon");
		btnSemiC.addActionListener(new ActionListener() {// code for semicolon
															// button
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) 
			{
				txtoutputField.setText(txtoutputField.getText() + " ; " + " ");
				txtoutputField.requestDefaultFocus();
			}
		}
		);

		JButton btnClear = new JButton("Clear"); // clears text box
		btnClear.setToolTipText("Clear Textbox");
		btnClear.addActionListener(new ActionListener() 
		{
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) 
			{
				txtoutputField.setText(" ");
				txtoutputField.requestDefaultFocus();
			}
		}
		
				);

		JButton btnJoin = new JButton("Join"); // adds "Join" statement
		btnJoin.setToolTipText("");
		btnJoin.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				txtoutputField.setText(txtoutputField.getText() + "Join");
			}
		}
		);
		btnJoin.setAction(Joinaction);

		JButton btnWhere = new JButton("Where"); // adds Where statement
		btnWhere.setToolTipText("Operators: = ,  != ,  > , < , >= , <= , 'Between' , 'Like' , 'IN'");
		btnWhere.addActionListener(new ActionListener()
		{
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) 
			{
				txtoutputField.setText(txtoutputField.getText() + " Where " + " ");
				txtoutputField.requestDefaultFocus();
			}
		}
		);

		JButton btnDistinct = new JButton("Distinct"); // adds "distinct"
														// statement
		
		btnDistinct.setAction(DistinctAction); 
		btnDistinct.setToolTipText("Adds Distinct Statement");
		btnDistinct.addActionListener(new ActionListener() 
		{
			
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) 
			{
				txtoutputField.setText(txtoutputField.getText() + " Distinct ");
				txtoutputField.requestDefaultFocus();
			}

		}
		);

		JButton btnleftBrackets = new JButton("("); // Jbutton for left Bracket
		btnleftBrackets.setToolTipText("Adds Left Bracket");
		btnleftBrackets.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				txtoutputField.setText(txtoutputField.getText() + " ( ");
			}
		});
		btnleftBrackets.setAction(LbracketAction);

		JButton btnrightBracket = new JButton(")"); // Jbutton for Right Bracket
		btnrightBracket.setToolTipText("Adds Right Bracket");
		btnrightBracket.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				txtoutputField.setText(txtoutputField.getText() + " ) ");
			}
		});

		JButton btnExportToText = new JButton("Export To Text File"); // code
																		// for
																		// export
																		// button
		btnExportToText.setToolTipText("Export Textbox contents to External text file.");
		btnExportToText.setAction(ExportAction);
	
		btnExportToText.addActionListener(new ActionListener() //action listener that exports query to file
		{

			public void actionPerformed(ActionEvent e)
			{
				// File Browser Snippet taken from:
				// http://www.codejava.net/java-se/swing/show-save-file-dialog-using-jfilechooser

				// parent component of the dialog
				JFrame parentFrame = new JFrame(); // make a new Jframe for the
													// save prompt.
				JFrame dialogue = new JFrame();
				String OutputData = txtoutputField.getText(); // sets current
																// written SQL
																// code to
																// OutputData
																// variable

				JFileChooser fileChooser = new JFileChooser(); // create a
																// JfileChooser

				int result = fileChooser.showSaveDialog(parentFrame); // create
																		// save
																		// dialogue
																		// onto
																		// parent
																		// prompt
				fileChooser.setDialogTitle("Select A Save Location"); // Instruct
																		// User
																		// to
																		// select
																		// save
																		// location

				if (result == JFileChooser.APPROVE_OPTION) // if file selection
															// result is valid
				{
					File userOutput = fileChooser.getSelectedFile(); // get the
																		// selected
																		// filepath

					String filepath = userOutput.toString(); // convert selected
																// filepath to
																// string

					System.out.println("Save as file: " + userOutput.getAbsolutePath()); // output
																							// console
																							// message

					try {
						outputfile(OutputData, filepath); // call output method
					} catch (FileNotFoundException e1)
					{
						e1.printStackTrace();
					}

				} else if (result == JFileChooser.ERROR) // if file saving
															// produces error
				{
					// custom title, error icon
					JOptionPane.showMessageDialog(dialogue, "Your File Selection / filename was not valid", "Error",
							JOptionPane.ERROR_MESSAGE);

				}

			}

			public void outputfile(String OutputData, String filepath) throws FileNotFoundException
			{

				PrintWriter writer = new PrintWriter(new File(filepath) + ".txt"); // adds
																					// .txt
																					// to
																					// filename
				System.out.println("File Write complete"); // console output
				writer.println(new File(OutputData)); // file contents

				writer.close();

			}
		});

		JButton btndelete = new JButton("Delete"); //code for the delete button
		btndelete.setAction(Deleteaction);
		btndelete.setToolTipText("Adds Delete Statement");
		btndelete.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				txtoutputField.setText(txtoutputField.getText() + " Delete ");
			}
		});

		JButton btnasButton = new JButton("As");
		btnasButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtoutputField.setText(txtoutputField.getText() + " As ");
			}
		});
		btnasButton.setAction(AsAction);

		btnasButton.setToolTipText("Adds As Statement");

		JButton btncaseButton = new JButton("Case");
		btncaseButton.setAction(CaseAction);
		btncaseButton.setToolTipText("Adds Case Statement");
		btncaseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtoutputField.setText(txtoutputField.getText() + " Case ");
			}
		});

		

		
		
			frmSqlBuilder.addWindowListener(new java.awt.event.WindowAdapter() 
			{

				JFrame dialogPrompt = new JFrame();

				public void windowClosing(java.awt.event.WindowEvent e) 
				{
					if (textchange == true)
					{
					if (JOptionPane.showOptionDialog(dialogPrompt, "Do you want to save this query?", "Really Closing?",
							JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null,
							e) == JOptionPane.YES_OPTION) 
					{

						// File Browser Snippet taken from:
						// http://www.codejava.net/java-se/swing/show-save-file-dialog-using-jfilechooser

						// parent component of the dialog
						JFrame parentFrame = new JFrame(); // make a new Jframe
															// for the save
															// prompt.
						JFrame dialogue = new JFrame();
						String OutputData = txtoutputField.getText(); // sets
																		// current
																		// written
																		// SQL
																		// code
																		// to
																		// OutputData
																		// variable

						JFileChooser fileChooser = new JFileChooser(); // create
																		// a
																		// JfileChooser

						int result = fileChooser.showSaveDialog(parentFrame); // create
																				// save
																				// dialogue
																				// onto
																				// parent
																				// prompt
						fileChooser.setDialogTitle("Select A Save Location"); // Instruct
																				// User
																				// to
																				// select
																				// save
																				// location

						if (result == JFileChooser.APPROVE_OPTION) // if file
																	// selection
																	// result is
																	// valid
						{
							File userOutput = fileChooser.getSelectedFile(); // get
																				// the
																				// selected
																				// filepath

							String filepath = userOutput.toString(); // convert
																		// selected
																		// filepath
																		// to
																		// string

							System.out.println("Save as file: " + userOutput.getAbsolutePath()); // output
																									// console
																									// message

							outputfile(OutputData, filepath); // call output
																// method
							
							

						} else if (result == JFileChooser.ERROR_OPTION) // if
																		// file
																		// saving
																		// produces
																		// error
						{
							// custom title, error icon
							JOptionPane.showMessageDialog(dialogue, "Your File Selection / filename was not valid",
									"Error", JOptionPane.ERROR_MESSAGE);

						}

					}
					
				}
					else 
					{
					System.exit(0); //if no change has been detected in the output box close without save prompt
					}



				}

				private void outputfile(String outputData, String filepath) 
				{
					
				}
				});// end of window closing event

			
			
			
			
			JButton btnCreditPrompt = new JButton(); //creates button for credit prompt
			btnCreditPrompt.setFont(new Font("Arial", Font.BOLD, 11));
			btnCreditPrompt.setText("Credits");
			
			
			btnCreditPrompt.addActionListener(new ActionListener() //if the credit button is clicked open a new window
			{
				public void actionPerformed(ActionEvent e) 
				{
					
					Credits CreditPrompt = new Credits();
					CreditPrompt.setVisible(true);
					

				}
			}
			);
			btnCreditPrompt.setAction(CreditAction);

			// end of buttons

			GroupLayout groupLayout = new GroupLayout(frmSqlBuilder.getContentPane());
			groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
					.addGroup(groupLayout.createSequentialGroup()
						.addContainerGap()
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(groupLayout.createSequentialGroup()
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addGroup(groupLayout.createSequentialGroup()
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
											.addGroup(groupLayout.createSequentialGroup()
												.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
													.addComponent(btnSelect, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
													.addComponent(btnInsert, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
													.addComponent(btnUpdate, GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE))
												.addPreferredGap(ComponentPlacement.UNRELATED)
												.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
													.addComponent(btndelete, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
													.addComponent(btnAlter, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
													.addComponent(btnCreate, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE))
												.addGap(6)
												.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
													.addComponent(btnWhere, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
													.addComponent(btnDistinct, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
													.addGroup(groupLayout.createSequentialGroup()
														.addGap(4)
														.addComponent(btnDrop, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)))
												.addPreferredGap(ComponentPlacement.UNRELATED)
												.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
													.addComponent(btnJoin, 0, 0, Short.MAX_VALUE)
													.addComponent(btnasButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
													.addComponent(btncaseButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
											.addGroup(groupLayout.createSequentialGroup()
												.addComponent(txtoutputField, GroupLayout.PREFERRED_SIZE, 275, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.UNRELATED)
												.addComponent(btnExportToText)))
										.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(btnClear)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(btnAsterisk)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(btnSemiC)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(btnleftBrackets)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(btnrightBracket)))
								.addGap(79))
							.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
								.addComponent(btnCreditPrompt)
								.addGap(45))))
			);
			groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
					.addGroup(groupLayout.createSequentialGroup()
						.addGap(26)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(txtoutputField, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnExportToText))
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
							.addGroup(groupLayout.createSequentialGroup()
								.addGap(45)
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
									.addComponent(btnSelect)
									.addComponent(btnCreate)
									.addComponent(btnWhere)
									.addComponent(btnasButton))
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
									.addComponent(btnInsert)
									.addComponent(btnAlter)
									.addComponent(btnDistinct, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
									.addComponent(btncaseButton))
								.addGap(18)
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
									.addComponent(btnUpdate)
									.addComponent(btndelete)
									.addComponent(btnDrop)
									.addComponent(btnJoin))
								.addGap(51)
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
									.addComponent(btnClear)
									.addComponent(btnAsterisk, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
									.addComponent(btnSemiC, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
									.addComponent(btnleftBrackets, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
									.addComponent(btnrightBracket, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
								.addContainerGap(32, Short.MAX_VALUE))
							.addGroup(groupLayout.createSequentialGroup()
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(btnCreditPrompt, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))))
			);
			frmSqlBuilder.getContentPane().setLayout(groupLayout);
		

		
		

	}// end of initalize

	public final void textBoxChanged() // detects if there has been a change in
										// the textbox
	{
		// boolean textchange;

		textchange = true;

		// return textchange;

	}

	private class SelectAction extends AbstractAction // action handlers
	{
		/**
		 * 
		 */
		private static final long serialVersionUID = 7525531798032239686L;

		public SelectAction()
		{
			putValue(NAME, "Select");
			putValue(SHORT_DESCRIPTION, " Adds Select * From ");
		}

		public void actionPerformed(ActionEvent e) 
		{

		}
	} // end of select action

	private class InsertAction extends AbstractAction
	{
		/**
		 * 
		 */
		private static final long serialVersionUID = 217358473358275617L;

		public InsertAction() {
			putValue(NAME, "Insert"); // assigns name to insert
			putValue(SHORT_DESCRIPTION, "Adds Insert ");
		}

		public void actionPerformed(ActionEvent e) 
		{

		}
	}// end of insert action

	private class UpdateAction extends AbstractAction
	{
		/**
		 * 
		 */
		private static final long serialVersionUID = 2318142160635068477L;

		public UpdateAction() {
			putValue(NAME, "Update"); // assigns name to update
			putValue(SHORT_DESCRIPTION, "Adds Update");
		}

		public void actionPerformed(ActionEvent e) 
		{

		}
	}// end of update action

	private class DistinctAction extends AbstractAction {//adds distinct 
		/**
		 * 
		 */
		private static final long serialVersionUID = 1162913718431598155L;

		public DistinctAction() { 
			putValue(NAME, "Distinct");
			putValue(SHORT_DESCRIPTION, null);
		}

		public void actionPerformed(ActionEvent e)
		{
		
		}
	}

	private class LbracketAction extends AbstractAction {//adds left bracket action
		/**
		 * 
		 */
		private static final long serialVersionUID = 3260331883263333402L;

		public LbracketAction() 
		{
			putValue(NAME, "(");
			putValue(SHORT_DESCRIPTION, null);
		}

		public void actionPerformed(ActionEvent e) 
		{
		}
	}

	private class ExportAction extends AbstractAction
	{
		/**
		 * 
		 */
		private static final long serialVersionUID = 8050898562759289146L;

		public ExportAction() {
			putValue(NAME, "Export to .txt file");
			putValue(SHORT_DESCRIPTION, null);
		}

		public void actionPerformed(ActionEvent e)
		{
		}
	}

	private class DeleteAction extends AbstractAction
	{
		/**
		 * 
		 */
		private static final long serialVersionUID = 6824684766063751882L;

		public DeleteAction() {
			putValue(NAME, "Delete");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}

		public void actionPerformed(ActionEvent e) 
		{
		}
	}

	private class AsAction extends AbstractAction 
	{
		/**
		 * 
		 */
		private static final long serialVersionUID = -8135781779323338148L;

		public AsAction() {
			putValue(NAME, "As");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}

		public void actionPerformed(ActionEvent e)
		{
		}
	}

	private class CaseAction extends AbstractAction 
	{
		/**
		 * 
		 */
		private static final long serialVersionUID = -8147819037153493132L;

		public CaseAction() 
		{
			putValue(NAME, "Case");
			putValue(SHORT_DESCRIPTION, null);
		}

		public void actionPerformed(ActionEvent e) 
		{
		}
	}

	private class Joinaction extends AbstractAction 
	{
		/**
		 * 
		 */
		private static final long serialVersionUID = 753041214240121153L;

		public Joinaction() {
			putValue(NAME, "Join");
			putValue(SHORT_DESCRIPTION, "Adds Join Statement");
		}

		public void actionPerformed(ActionEvent e) 
		{
		}
	}

	private class CreditAction extends AbstractAction 
	{
		/**
		 * 
		 */
		private static final long serialVersionUID = -164871817158899658L;

		public CreditAction() 
		{
			putValue(NAME, "Credits");
			putValue(SHORT_DESCRIPTION, null);
		}

		public void actionPerformed(ActionEvent e)
		{
		}
	}
}
