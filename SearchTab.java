import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JFileChooser.*;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.ButtonGroup;
import javax.swing.JToggleButton;
import net.miginfocom.swing.MigLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.util.ArrayList;




public class SearchTab extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JTextField txtfldUserSearchParam;
	private JTextArea txtaraSearchResults;
	private JButton btnClear, btnExport;
	private JFileChooser fc;
	private final ButtonGroup buttonGroupSearchTypes = new ButtonGroup();
	private static ArrayList<String> result=new ArrayList<String>();

	public SearchTab() {
		setLayout(new MigLayout("", "[100,grow][100,grow][100,grow][100,grow]", "[grow][][][]"));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		add(scrollPane, "cell 0 0 4 1,grow");
		
		txtaraSearchResults = new JTextArea();
		txtaraSearchResults.setEditable(false);
		scrollPane.setViewportView(txtaraSearchResults);
		
		JToggleButton tglbtnByAssetTag = new JToggleButton("Asset Tag");
		tglbtnByAssetTag.setSelected(true);
		buttonGroupSearchTypes.add(tglbtnByAssetTag);
		add(tglbtnByAssetTag, "cell 0 1,grow");
		
		JToggleButton tglbtnByUserName = new JToggleButton("User Name");
		buttonGroupSearchTypes.add(tglbtnByUserName);
		add(tglbtnByUserName, "cell 1 1,grow");
		
		JToggleButton tglbtnByBldg = new JToggleButton("Bldg Nbr");
		buttonGroupSearchTypes.add(tglbtnByBldg);
		add(tglbtnByBldg, "cell 2 1,grow");
		
		JToggleButton tglbtnAllAssets = new JToggleButton("All Assets");
		buttonGroupSearchTypes.add(tglbtnAllAssets);
		add(tglbtnAllAssets, "cell 3 1,grow");			
		
		txtfldUserSearchParam = new JTextField();
		txtfldUserSearchParam.setToolTipText("Search");
		txtfldUserSearchParam.addActionListener(this);
		add(txtfldUserSearchParam, "cell 1 2 2 1,grow");
		txtfldUserSearchParam.setColumns(10);
		
		btnClear = new JButton("Clear");
		btnClear.addActionListener(this);
		add(btnClear, "cell 1 3,grow");
		
		btnExport = new JButton("Export");
		btnExport.addActionListener(this);
		add(btnExport, "cell 2 3,grow");
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnExport) {
			int returnVal = 1;//fc.showSaveDialog(SearchTab.this);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				txtaraSearchResults.append("Saving: " + file.getName() + "." + "\n");
			} else {
				txtaraSearchResults.append("Save command cancelled by user." + "\n");
            }
			txtaraSearchResults.setCaretPosition(txtaraSearchResults.getDocument().getLength());
		
		}
		
		
		
		else if (e.getSource() == btnClear) {
			txtaraSearchResults.setText(null);
		}
		else if (e.getSource() == txtfldUserSearchParam) {
			result = connectSQL.searchForAsset(txtfldUserSearchParam.getText());
			for (int i = 0; i < result.size(); i++) {
				txtaraSearchResults.append(result.get(i) + "\n");
			}
			result.clear();
		}
	}
}
