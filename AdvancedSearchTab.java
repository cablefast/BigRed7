import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JEditorPane;

public class AdvancedSearchTab extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtfldUserSearchParam;

	public AdvancedSearchTab() {
		setLayout(new MigLayout("", "[100,grow,left][][100,grow,right]", "[grow][][][]"));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		add(scrollPane, "cell 0 0 3 1,grow");
		
		JTextArea txtaraSearchResults = new JTextArea();
		txtaraSearchResults.setEditable(false);
		scrollPane.setViewportView(txtaraSearchResults);
		
		JButton btnTables = new JButton("Tables Searched");
		add(btnTables, "cell 0 1,grow");
		
		JButton btnColumnsDisplayed = new JButton("Columns Displayed");
		add(btnColumnsDisplayed, "cell 2 1,grow");
		
		JButton btnColumns = new JButton("Columns Searched");
		add(btnColumns, "cell 0 2,grow");
		
		txtfldUserSearchParam = new JTextField();
		txtfldUserSearchParam.setText("Search");
		add(txtfldUserSearchParam, "cell 2 2,grow");
		txtfldUserSearchParam.setColumns(10);
		
		JButton btnClear = new JButton("Clear");
		add(btnClear, "cell 0 3,grow");
		
		JButton btnExport = new JButton("Export");
		add(btnExport, "cell 2 3,grow");

	}

}