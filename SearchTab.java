import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import net.miginfocom.swing.MigLayout;
import javax.swing.JToggleButton;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.ButtonGroup;


public class SearchTab extends JPanel{

	private static final long serialVersionUID = 1L;
	private JTextField txtfldUserSearchParam;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	
	public SearchTab() {
		setLayout(new MigLayout("", "[100][100][grow][100][100]", "[grow][][][]"));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		add(scrollPane, "cell 0 0 5 1,grow");
		
		JTextArea txtaraSearchResults = new JTextArea();
		txtaraSearchResults.setEditable(false);
		scrollPane.setViewportView(txtaraSearchResults);
		
		JToggleButton tglbtnByAssetTag = new JToggleButton("Asset Tag");
		buttonGroup.add(tglbtnByAssetTag);
		add(tglbtnByAssetTag, "cell 0 1,grow");
		
		JToggleButton tglbtnByUserName = new JToggleButton("User Name");
		buttonGroup.add(tglbtnByUserName);
		add(tglbtnByUserName, "cell 1 1,grow");
		
		JToggleButton tglbtnByBldg = new JToggleButton("Bldg Nbr");
		buttonGroup.add(tglbtnByBldg);
		add(tglbtnByBldg, "cell 3 1,grow");
		
		JToggleButton tglbtnAllAssets = new JToggleButton("All Assets");
		buttonGroup.add(tglbtnAllAssets);
		add(tglbtnAllAssets, "cell 4 1,grow");			
		
		txtfldUserSearchParam = new JTextField();
		txtfldUserSearchParam.setText("Search");
		add(txtfldUserSearchParam, "cell 1 2 3 1,grow");
		txtfldUserSearchParam.setColumns(10);
		
		JButton btnClear = new JButton("Clear");
		add(btnClear, "cell 1 3,grow");
		
		JButton btnExport = new JButton("Export");
		add(btnExport, "cell 3 3,grow");

		
	}
	


}
