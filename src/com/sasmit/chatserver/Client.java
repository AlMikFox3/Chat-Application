package com.sasmit.chatserver;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import java.awt.FlowLayout;
import java.awt.GridBagLayout;

import javax.swing.JTextArea;

import java.awt.GridBagConstraints;

import javax.swing.JButton;

import java.awt.Insets;

import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Client extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private String name, address;
	private int port;
	private JTextField textMessage;
	private JTextArea txtrHistory;
	
	public Client(String name, String address, int port) {
		setTitle("Chat Client");
		this.name = name;
		this.address = address;
		this.port = port;
		createWindow();
		console("User "+name+" is attempting a connection to "+address+":"+port);
	}
	private void createWindow()
	{
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(880,550);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{30,820,25,5};
		gbl_contentPane.rowHeights = new int[]{45,450,55};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0};
		gbl_contentPane.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		txtrHistory = new JTextArea();
		JScrollPane scrollPane = new JScrollPane(txtrHistory);
		txtrHistory.setEditable(false);
		GridBagConstraints scrollConstraints = new GridBagConstraints();
		scrollConstraints.insets = new Insets(0, 0, 5, 5);
		scrollConstraints.fill = GridBagConstraints.BOTH;
		scrollConstraints.gridx = 1;
		scrollConstraints.gridy = 1;
		scrollConstraints.gridwidth = 2;
		scrollConstraints.insets = new Insets(0, 10, 5, 5);
		contentPane.add(scrollPane, scrollConstraints);
		
		textMessage = new JTextField();
		textMessage.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
					send(textMessage.getText());
				}
			}
		});
		GridBagConstraints gbc_textMessage = new GridBagConstraints();
		gbc_textMessage.insets = new Insets(0, 10, 0, 5);
		gbc_textMessage.fill = GridBagConstraints.HORIZONTAL;
		gbc_textMessage.gridx = 1;
		gbc_textMessage.gridy = 2;
		contentPane.add(textMessage, gbc_textMessage);
		textMessage.setColumns(10);
		
		JButton btnSend = new JButton("Send");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				send(textMessage.getText());
			}
		});
		GridBagConstraints gbc_btnSend = new GridBagConstraints();
		gbc_btnSend.insets = new Insets(0, 0, 0, 5);
		gbc_btnSend.gridx = 2;
		gbc_btnSend.gridy = 2;
		contentPane.add(btnSend, gbc_btnSend);
		setVisible(true);
		
		//requestFocus();
		textMessage.requestFocusInWindow();
	}
	private void send(String message)
	{
		if(message.equals(""))
			return;
		else
		{
			message = name + ": " + message;
			console(message);
			textMessage.setText("");
		}
	}
	public void console(String msg)
	{
		txtrHistory.append(msg + "\n");
		txtrHistory.setCaretPosition(txtrHistory.getDocument().getLength());
	}

}
