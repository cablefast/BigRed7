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
		setLayout(new MigLayout("", "[grow]", "[grow][][][]"));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		add(scrollPane, "cell 0 0,grow");
		
		JTextArea txtaraSearchResults = new JTextArea();
		txtaraSearchResults.setEditable(false);
		scrollPane.setViewportView(txtaraSearchResults);
		
		JToggleButton tglbtnByAssetTag = new JToggleButton("By Asset Tag");
		buttonGroup.add(tglbtnByAssetTag);
		add(tglbtnByAssetTag, "flowx,cell 0 1,alignx center,aligny center");
		
		JToggleButton tglbtnByUserName = new JToggleButton("By User Name");
		buttonGroup.add(tglbtnByUserName);
		add(tglbtnByUserName, "cell 0 1,alignx center,aligny center");
		
		JToggleButton tglbtnByBldg = new JToggleButton("By Bldg");
		buttonGroup.add(tglbtnByBldg);
		add(tglbtnByBldg, "cell 0 1,alignx center,aligny center");
		
		JToggleButton tglbtnAllAssets = new JToggleButton("All Assets");
		buttonGroup.add(tglbtnAllAssets);
		add(tglbtnAllAssets, "cell 0 1,alignx center,aligny center");			
		
		txtfldUserSearchParam = new JTextField();
		txtfldUserSearchParam.setText("Search");
		add(txtfldUserSearchParam, "cell 0 2,alignx center");
		txtfldUserSearchParam.setColumns(10);
		
		JButton btnClear = new JButton("Clear");
		add(btnClear, "flowx,cell 0 3,alignx center");
		
		JButton btnExport = new JButton("Export");
		add(btnExport, "cell 0 3,alignx center");

		
	}
	


}
