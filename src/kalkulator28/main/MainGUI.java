package main;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import lib.MyGUI;
import lib.FontConstants;

public class MainGUI implements MyGUI {

	private JComponent background;
	private JFrame gUIframe;

	public MainGUI() {
		gUIframe = new JFrame("Kalkulator DAS28");
		background = new JPanel();
		background.add(createWelcomePanel());
	}

	@Override
	public JFrame getGUIframe() {

		gUIframe.getContentPane().add(background);
		gUIframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gUIframe.setLocationRelativeTo(null);
		gUIframe.setResizable(false);
		//gUIframe.getRootPane().setDefaultButton(patternControls.getPlayOrStopButton());
		gUIframe.pack();

		return gUIframe;
	}

	private JPanel createWelcomePanel() {
		JPanel welcomePanel = new JPanel(new BorderLayout());

		JPanel panel = new JPanel();
		JLabel welcomeLabel = new JLabel("Kalkulator licz?cy wska?nik DAS 28");
		welcomeLabel.setFont(FontConstants.MEDIUM_FONT_BOLD);
		panel.add(welcomeLabel);
		panel.setBorder(BorderFactory.createEmptyBorder(0, 0, 15, 10));

		JButton inputDataButton = new JButton("Wprowad? dane");
		inputDataButton.setFont(FontConstants.SMALL_FONT_BOLD);
		inputDataButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				fetchDataBox();
			}
		});
		Box buttonBox = Box.createHorizontalBox();
		buttonBox.add(Box.createHorizontalGlue());
		buttonBox.add(inputDataButton);
		buttonBox.add(Box.createHorizontalGlue());

		welcomePanel.add(panel, BorderLayout.CENTER);
		welcomePanel.add(buttonBox, BorderLayout.SOUTH);

		return welcomePanel;
	}

	private void fetchDataBox() {
		background.removeAll();
		background.add(new DataBox());
		background.revalidate();
		background.repaint();
		gUIframe.pack();
	}
}
