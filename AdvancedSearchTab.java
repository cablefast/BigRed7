import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class AdvancedSearchTab extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtfldUserSearchParam;

	public AdvancedSearchTab() {
		setLayout(new MigLayout("", "[100,grow,left][grow][grow][100,grow,right]", "[grow][][][]"));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		add(scrollPane, "cell 0 0 4 1,grow");
		
		JTextArea txtaraSearchResults = new JTextArea();
		txtaraSearchResults.setEditable(false);
		scrollPane.setViewportView(txtaraSearchResults);
		
		JButton btnTables = new JButton("Tables Searched");
		add(btnTables, "cell 0 1,grow");
		
		JButton btnColumns = new JButton("Columns Searched");
		add(btnColumns, "cell 1 1 2 1,grow");
		
		JButton btnColumnsDisplayed = new JButton("Columns Displayed");
		add(btnColumnsDisplayed, "cell 3 1,grow");
		
		txtfldUserSearchParam = new JTextField();
		txtfldUserSearchParam.setText("Search");
		add(txtfldUserSearchParam, "cell 1 2 2 1,grow");
		txtfldUserSearchParam.setColumns(10);
		
		JButton btnClear = new JButton("Clear");
		add(btnClear, "cell 1 3,grow");
		
		JButton btnExport = new JButton("Export");
		add(btnExport, "cell 2 3,grow");

	}

}