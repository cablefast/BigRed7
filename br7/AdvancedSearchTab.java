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

public class AdvancedSearchTab extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JTextField txtfldUserSearchParam;
	private TextPrompt txtfldPrompt;
	private JScrollPane scrollPane;
	private JTextArea txtaraSearchResults;
	private JComboBox<String> cmbUserSearchFieldSelection;
	private JFileChooser fc;
	private JButton btnClear, btnExport;
	private String searchFieldPromptText = "Press ENTER to Search";
	private static ArrayList<String> result=new ArrayList<String>();
	
	private static final String[] COMBOOPT = new String[] {"Serial Number","Make","Model","Windows Name","Classification",
			"Purchase Date","Warranty Date","Building","Room","EDIPI","Last Name","First Name","PARA","LN","Support Level",
			"Support Description"};
	private JButton btnColumnsDisplayed;
	
	private columnSelection select;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public AdvancedSearchTab() {
		setLayout(new MigLayout("", "[grow][grow][grow][grow]", "[grow][][][]"));
		
		scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		add(scrollPane, "cell 0 0 4 1,grow");
		
		txtaraSearchResults = new JTextArea();
		txtaraSearchResults.setEditable(false);
		scrollPane.setViewportView(txtaraSearchResults);
		
		cmbUserSearchFieldSelection = new JComboBox(COMBOOPT);
		add(cmbUserSearchFieldSelection, "cell 0 1 2 1,grow");		
		
		btnColumnsDisplayed = new JButton("Columns Displayed");
		btnColumnsDisplayed.addActionListener(this);	
		add(btnColumnsDisplayed, "cell 2 1 2 1,grow");
		
		txtfldUserSearchParam = new JTextField();
		txtfldUserSearchParam.addActionListener(this);		
		add(txtfldUserSearchParam, "cell 1 2 2 1,grow");
		
		txtfldPrompt = new TextPrompt(searchFieldPromptText, txtfldUserSearchParam, TextPrompt.Show.FOCUS_LOST);
		txtfldPrompt.changeStyle(Font.ITALIC);
		
		btnClear = new JButton("Clear");
		btnClear.addActionListener(this);
		add(btnClear, "cell 1 3,grow");
		
		btnExport = new JButton("Export");
		btnExport.addActionListener(this);
		add(btnExport, "cell 2 3,grow");
		
		select = new columnSelection();
		select.setVisible(false);

	}
	
	public void actionPerformed(ActionEvent e) {
		String userhome = System.getProperty("user.home");
		fc = new JFileChooser(userhome +"\\Documents");		
		
		if (e.getSource() == btnExport) {
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
		
		else if (e.getSource() == txtfldUserSearchParam) {
			String userTextToPass = "%" + txtfldUserSearchParam.getText() + "%";
			String userAdvSelectToPass = (String) cmbUserSearchFieldSelection.getSelectedItem();
			result = connectSQL.advSearchSQL(userAdvSelectToPass,userTextToPass);
			for (int i = 0; i < result.size(); i++) txtaraSearchResults.append(result.get(i) + "\n");
			result.clear();
		}
	}

}