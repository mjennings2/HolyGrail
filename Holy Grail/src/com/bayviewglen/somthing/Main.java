package com.bayviewglen.somthing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import java.awt.Button;
import javax.swing.JList;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.Choice;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JMenu;

public class Main extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1366, 760);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmOpen = new JMenuItem("Open");
		mnFile.add(mntmOpen);
		
		JMenuItem mntmRestart = new JMenuItem("Restart");
		mnFile.add(mntmRestart);
		
		JMenuItem mntmSave = new JMenuItem("Save");
		mnFile.add(mntmSave);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPic = new JLabel("Pic");
		lblPic.setIcon(new ImageIcon("C:\\Users\\mathe_000\\Desktop\\Holy Grail Hunting or Somthing.png"));
		lblPic.setBounds(15, 16, 1001, 534);
		contentPane.add(lblPic);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(15, 566, 1314, 122);
		contentPane.add(textArea);
		
		Button button = new Button("New button");
		button.setBounds(1105, 10, 91, 27);
		contentPane.add(button);
	}
}
