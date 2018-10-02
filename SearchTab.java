package Interface;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class SearchTab extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private JTextField searchText = new JTextField();
	
	public SearchTab() {
		setLayout(new BorderLayout());
		add(buttonPanelClearExport(), BorderLayout.SOUTH);
		add(searchText, BorderLayout.NORTH);
	}
	
	private JPanel buttonPanelClearExport(){
      JPanel buttons = new JPanel();
      JButton clear = new JButton("Clear");
      JButton export = new JButton("Export");
      buttons.add(clear);
      buttons.add(export);
      return buttons;
   }

}
