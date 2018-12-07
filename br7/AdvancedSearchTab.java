package br7;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;

/**
 * @author      Matthew Flautt <mf56@students.uwf.edu>
 * @version     1.0
 * @since       1.0
 */
public class AdvancedSearchTab extends JPanel implements ActionListener {

	/**
	 * a default serial version ID to the selected type.
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Represents the user selected search by option:
	 * Passed to outside classes
	 * Serial Number=0
	 * Make=1
	 * Model=2
	 * Windows Name=3
	 * Classification=4
	 * Purchase Date=5
	 * Warranty Date=6
	 * Building=7
	 * Room=8
	 * EDIPI=9
	 * Last Name=10
	 * First Name=11
	 * PARA=12
	 * LN=13
	 * Support Level=14
	 * Support Description=15
	 */
	private int selectedButton;
	
	/**
	 * Text field where users enter their search text
	 */
	private JTextField txtfldUserSearchParam;
	
	/**
	 * Tells the user how to use the text field
	 */
	private TextPrompt txtfldPrompt;
	
	/**
	 * Lets the user scroll through the results area
	 */
	private JScrollPane scrollPane;
	
	/**
	 * Displays the search results
	 */
	private JTextArea txtaraSearchResults;
	
	/**
	 * Lets the user select a column to search by in the database
	 */
	private JComboBox<String> cmbUserSearchFieldSelection;
	
	/**
	 * A file chooser for the export function
	 */
	private JFileChooser fc;
	
	/**
	 * Button to clear the search results area.
	 */
	private JButton btnClear;
	
	/**
	 * Button to start the export of search results
	 */
	private JButton btnExport;
	
	/**
	 * Prompt displayed over the search area
	 */
	private final String SEARCHFIELDPROMPTTEXT = "Press ENTER to Search";
	
	/**
	 * Array list that receives the search results
	 */
	private static ArrayList<String> result=new ArrayList<String>();
	
	/**
	 * Array that holds the options for cmbUserSearchFieldSelection
	 */
	private static final String[] COMBOOPT = new String[] {"Serial Number","Make","Model","Windows Name","Classification",
			"Purchase Date","Warranty Date","Building","Room","EDIPI","Last Name","First Name","PARA","LN","Support Level",
			"Support Description"};
	
	/**
	 * Button sets visible the column selection frame
	 */
	private JButton btnColumnsDisplayed;
	
	/**
	 * Frame that lets users specify which columns they would like displayed in the results
	 */
	private ColumnSelection select;
	
	/**
	 * Label next to the cmbUserSearchFieldSelection
	 */
	private JLabel lblSearchBy;

	/**
	 * Constructor of this class
	 * 
	 * MIG layout manager used. Visible items added to panel
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public AdvancedSearchTab() {
		setLayout(new MigLayout("", "[55][grow][grow][55]", "[grow][][][]"));
		
		scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		add(scrollPane, "cell 0 0 4 1,grow");
		
		txtaraSearchResults = new JTextArea();
		txtaraSearchResults.setEditable(false);
		scrollPane.setViewportView(txtaraSearchResults);
		
		lblSearchBy = new JLabel("Search By:");
		add(lblSearchBy, "cell 0 1");
		
		cmbUserSearchFieldSelection = new JComboBox(COMBOOPT);
		add(cmbUserSearchFieldSelection, "cell 1 1,grow");		
		
		btnColumnsDisplayed = new JButton("Columns Displayed");
		btnColumnsDisplayed.addActionListener(this);	
		add(btnColumnsDisplayed, "cell 2 1 2 1,grow");
		
		txtfldUserSearchParam = new JTextField();
		txtfldUserSearchParam.addActionListener(this);		
		add(txtfldUserSearchParam, "cell 1 2 2 1,grow");
		
		txtfldPrompt = new TextPrompt(SEARCHFIELDPROMPTTEXT, txtfldUserSearchParam, TextPrompt.Show.FOCUS_LOST);
		txtfldPrompt.changeStyle(Font.ITALIC);
		
		btnClear = new JButton("Clear");
		btnClear.addActionListener(this);
		add(btnClear, "cell 1 3,grow");
		
		btnExport = new JButton("Export");
		btnExport.addActionListener(this);
		add(btnExport, "cell 2 3,grow");
		
		select = new ColumnSelection();
		select.setVisible(false);
	}
	
	/**
	 * Get the state of cmbUserSearchFieldSelection and make it an int
	 *
	 * @return an int 0-15 representing the different columns that can be selected
	 */
	private int getButtonState() {
		if (cmbUserSearchFieldSelection.getSelectedItem() == COMBOOPT[0]) selectedButton = 0;
		if (cmbUserSearchFieldSelection.getSelectedItem() == COMBOOPT[1]) selectedButton = 1;
		if (cmbUserSearchFieldSelection.getSelectedItem() == COMBOOPT[2]) selectedButton = 2;
		if (cmbUserSearchFieldSelection.getSelectedItem() == COMBOOPT[3]) selectedButton = 3;
		if (cmbUserSearchFieldSelection.getSelectedItem() == COMBOOPT[4]) selectedButton = 4;
		if (cmbUserSearchFieldSelection.getSelectedItem() == COMBOOPT[5]) selectedButton = 5;
		if (cmbUserSearchFieldSelection.getSelectedItem() == COMBOOPT[6]) selectedButton = 6;
		if (cmbUserSearchFieldSelection.getSelectedItem() == COMBOOPT[7]) selectedButton = 7;
		if (cmbUserSearchFieldSelection.getSelectedItem() == COMBOOPT[8]) selectedButton = 8;
		if (cmbUserSearchFieldSelection.getSelectedItem() == COMBOOPT[9]) selectedButton = 9;
		if (cmbUserSearchFieldSelection.getSelectedItem() == COMBOOPT[10]) selectedButton = 10;
		if (cmbUserSearchFieldSelection.getSelectedItem() == COMBOOPT[11]) selectedButton = 11;
		if (cmbUserSearchFieldSelection.getSelectedItem() == COMBOOPT[12]) selectedButton = 12;
		if (cmbUserSearchFieldSelection.getSelectedItem() == COMBOOPT[13]) selectedButton = 13;
		if (cmbUserSearchFieldSelection.getSelectedItem() == COMBOOPT[14]) selectedButton = 14;
		if (cmbUserSearchFieldSelection.getSelectedItem() == COMBOOPT[15]) selectedButton = 15;
		return selectedButton;
	}
	
	/**
	 * Decides what to do when a user selects an action
	 * 
	 * Different actions defined for btnExport, btnColumnsDisplayed, btnClear, or txtfldUserSearchParam
	 *
	 * @param user started action event
	 */
	public void actionPerformed(ActionEvent e) {
				
		if (e.getSource() == btnExport) {
			String userhome = System.getProperty("user.home");
			fc = new JFileChooser(userhome +"\\Documents");	
			int returnVal = fc.showSaveDialog(AdvancedSearchTab.this);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				String filepath = file.getAbsolutePath();
				if (filepath.endsWith(".csv")) {
					file = new File(filepath);
					txtaraSearchResults.append("Saving: " + filepath + "\n");
				}
				else {
					file = new File(filepath + ".csv");
					txtaraSearchResults.append("Saving: " + filepath + ".csv" + "\n");
				}
				BufferedWriter outFile = null;
				try {
					outFile = new BufferedWriter(new FileWriter(file));
					txtaraSearchResults.write(outFile);
					outFile.close();
				} 
				catch (Exception ex) {
					StringWriter sw = new StringWriter();
					PrintWriter pw = new PrintWriter(sw);
					ex.printStackTrace(pw);
					result.add(sw.toString());
					for (int i = 0; i < result.size(); i++) txtaraSearchResults.append(result.get(i) + "\n");
					result.clear();
				} 
				finally {
					if (outFile != null) {
						try {
							outFile.close();
						} catch (Exception ex) {
							StringWriter sw = new StringWriter();
							PrintWriter pw = new PrintWriter(sw);
							ex.printStackTrace(pw);
							result.add(sw.toString());
							for (int i = 0; i < result.size(); i++) txtaraSearchResults.append(result.get(i) + "\n");
							result.clear();
						}
					}
				}
			}
			else txtaraSearchResults.append("Save command cancelled by user." + "\n");
		}
		
		else if (e.getSource() == btnColumnsDisplayed) {
			select.setVisible(true);
		}
		
		else if (e.getSource() == btnClear)	txtaraSearchResults.setText(null);
		
		else if (e.getSource() == txtfldUserSearchParam) {
			String userTextToPass = txtfldUserSearchParam.getText();
			result = ConnectSQL.advSearchSQL(getButtonState(),userTextToPass);
			for (int i = 0; i < result.size(); i++) txtaraSearchResults.append(result.get(i) + "\n");
			result.clear();
		}
	}

}