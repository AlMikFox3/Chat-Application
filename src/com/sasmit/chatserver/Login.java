package com.sasmit.chatserver;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textName;
	private JTextField textIP;
	private JTextField textPort;
	public Login() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		setTitle("Login");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 250, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textName = new JTextField();
		textName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textName.setBounds(32, 49, 177, 32);
		contentPane.add(textName);
		textName.setColumns(10);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		lblName.setBounds(102, 24, 46, 14);
		contentPane.add(lblName);
		
		textIP = new JTextField();
		textIP.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textIP.setColumns(10);
		textIP.setBounds(32, 111, 177, 32);
		contentPane.add(textIP);
		
		JLabel lblIpAddress = new JLabel("IP Address");
		lblIpAddress.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		lblIpAddress.setBounds(87, 92, 61, 16);
		contentPane.add(lblIpAddress);
		
		JLabel lbleg = new JLabel("(eg: 192.168.10.1)");
		lbleg.setBounds(76, 144, 106, 14);
		contentPane.add(lbleg);
		
		JLabel lblPort = new JLabel("Port");
		lblPort.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		lblPort.setBounds(106, 174, 30, 16);
		contentPane.add(lblPort);
		
		textPort = new JTextField();
		textPort.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textPort.setColumns(10);
		textPort.setBounds(32, 190, 177, 32);
		contentPane.add(textPort);
		
		JLabel lbleg_1 = new JLabel("(eg: 8745)");
		lbleg_1.setBounds(88, 222, 60, 14);
		contentPane.add(lbleg_1);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//System.out.println("Button Pressed.");
				String name = textName.getText();
				String address = textIP.getText();
				int port = Integer.parseInt(textPort.getText());
				login(name, address, port);
							}
		});
		btnLogin.setBounds(76, 264, 93, 32);
		contentPane.add(btnLogin);
	}
	private void login(String name, String address, int port)
	{
		//System.out.println("Button Pressed.");
		dispose();
		System.out.println("Name = "+name+" Address = "+address+" port= "+port);
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
