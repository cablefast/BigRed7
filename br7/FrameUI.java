package br7;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class FrameUI extends JFrame{

	private static final String TITLE = "Big Red Seven";
	private SearchTab search = new SearchTab();
	private AdvancedSearchTab adv = new AdvancedSearchTab();
	private ChangeTab change = new ChangeTab();
	
	static final long serialVersionUID = 1L;
	
	public FrameUI() {
		super(TITLE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JTabbedPane jtp = new JTabbedPane();
		jtp.setPreferredSize(new Dimension(800, 800));
        getContentPane().add(jtp);
        jtp.addTab("Search", search);
        jtp.addTab("Adv. Search", adv);
        jtp.addTab("Change", change);
        pack();
	}
}