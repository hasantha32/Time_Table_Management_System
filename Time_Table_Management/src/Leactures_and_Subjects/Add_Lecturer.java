package Leactures_and_Subjects;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JScrollPane;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import DBC.DBConnection;
import Home.Dashboard;
import Home.StartUp;
import Location_and_Statistics.Add_Locations;
import Location_and_Statistics.Add_Locations_Sessions;
import Location_and_Statistics.Manage_Locations;
import Location_and_Statistics.Visualizing_static;
import Session_and_TimeAllocation.Add_Session;
import Session_and_TimeAllocation.Manage_Not_Available_Times;
import Session_and_TimeAllocation.Manage_Session_Rooms;
import Session_and_TimeAllocation.Manage_Sessions;
import Session_and_TimeAllocation.Not_Available_Time;

import Session_and_TimeAllocation.SessionsANDnotAvailableTimeAllocationConsecutive;
import Session_and_TimeAllocation.SessionsANDnotAvailableTimeAllocationNoneOverlaping;
import Session_and_TimeAllocation.SessionsANDnotAvailableTimeAllocationParallel;

import Students_and_Tags.Add_Student_Groups;
import Students_and_Tags.Add_Tag;
import Students_and_Tags.Manage_Student_Groups;
import Students_and_Tags.Manage_Tags;
import Working_Days_and_Hours.Add_Workingdays_Hours;
import Working_Days_and_Hours.Genarate_Lecturer_Time_Table;
import Working_Days_and_Hours.Genarate_Student_TimeTable;
import Working_Days_and_Hours.Genarate_TimeLocation;
import Working_Days_and_Hours.Manage_Workingdays_Hours;

import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JPanel;
import java.awt.Point;
import java.awt.Rectangle;
import javax.swing.JCheckBox;
import javax.swing.SpinnerNumberModel;
import javax.swing.SpinnerListModel;

public class Add_Lecturer {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JTextField txtTimeTableManagement;
	private JTextField txtAddLecturer;
	private JTextField textField_5;
	private JPanel panel_1;
	private JPanel panel_2;
	private JButton btnDelete;
	private JPanel panel_1_1;
	private JButton btnAddSession;
	private JButton btnUpdateSession;
	private JButton btnManageLsession;

	private JCheckBox chckbxNewCheckBox;
	
	
	
	PreparedStatement pst = null;
	PreparedStatement ptsID=null;
	ResultSet rs = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		DBConnection.connect();

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add_Lecturer window = new Add_Lecturer();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Add_Lecturer() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.activeCaption);
		frame.setBackground(Color.YELLOW);
		frame.setTitle("Add Lecturer");
		frame.setBounds(100,100, 960, 635);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setForeground(new Color(0, 0, 0));
		menuBar.setBorderPainted(false);
		menuBar.setBorder(null);
		menuBar.setBackground(new Color(0, 0, 0));
		frame.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Category");
		mnNewMenu.setFont(new Font("Segoe UI", Font.BOLD, 15));
		mnNewMenu.setBackground(Color.BLACK);
		mnNewMenu.setForeground(Color.YELLOW);
		menuBar.add(mnNewMenu);
		
		JMenu mnNewMenu_1 = new JMenu("Lecture & Subject");
		mnNewMenu_1.setBackground(new Color(128, 128, 128));
		mnNewMenu.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Add Lecture");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Add_Lecturer add_Lecturer=new Add_Lecturer();
				Add_Lecturer.main(null);
				frame.setVisible(false);
				
			}
			
		});
		mnNewMenu_1.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Add Subjects");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Add_Subjects add_Subjects=new Add_Subjects();
				Add_Subjects.main(null);
				frame.setVisible(false);
				
			}
			
		});
		mnNewMenu_1.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Manage Lecturers");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Manage_Lecturer manage_Lecturer=new Manage_Lecturer();
				Manage_Lecturer.main(null);
				frame.setVisible(false);
				
			}
			
		});
		mnNewMenu_1.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Manage Subjects");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Manage_Subjects manage_Subjects=new Manage_Subjects();
				Manage_Subjects.main(null);
				frame.setVisible(false);
				
			}
			
		});
		mnNewMenu_1.add(mntmNewMenuItem_3);
		
		JMenuBar menuBar_1 = new JMenuBar();
		mnNewMenu_1.add(menuBar_1);
		
		JMenu mnNewMenu_2 = new JMenu("Session & Time Allocation");
		mnNewMenu.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Add Session");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Add_Session add_Session=new Add_Session();
				Add_Session.main(null);
				frame.setVisible(false);
				
			}
			
		});
		mnNewMenu_2.add(mntmNewMenuItem_5);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Manage Not Available Times");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Manage_Not_Available_Times manage_Not_Available_Times=new Manage_Not_Available_Times();
				Manage_Not_Available_Times.main(null);
				frame.setVisible(false);
				
			}
			
		});
		mnNewMenu_2.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Manage Session Rooms");
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Manage_Session_Rooms manage_Session_Rooms=new Manage_Session_Rooms();
				Manage_Session_Rooms.main(null);
				frame.setVisible(false);
				
			}
			
		});
		
		mnNewMenu_2.add(mntmNewMenuItem_6);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("Manage Sessions");
		mntmNewMenuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Manage_Sessions manage_Sessions=new Manage_Sessions();
				Manage_Sessions.main(null);
				frame.setVisible(false);
				
			}
			
		});
		
		
		mnNewMenu_2.add(mntmNewMenuItem_7);
		
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("Not Available Time");
		mntmNewMenuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Not_Available_Time not_Available_Time=new Not_Available_Time();
				Not_Available_Time.main(null);
				frame.setVisible(false);
				
			}
			
		});
		
		
		mnNewMenu_2.add(mntmNewMenuItem_8);
		
		JMenuItem mntmNewMenuItem_9 = new JMenuItem("Sessions & Not Available Time Allocation Consecutive");
		mntmNewMenuItem_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				SessionsANDnotAvailableTimeAllocationConsecutive sessionsANDnotAvailableTimeAllocationConsecutive=new SessionsANDnotAvailableTimeAllocationConsecutive();
				SessionsANDnotAvailableTimeAllocationConsecutive.main(null);
				frame.setVisible(false);
				
			}
			
		});
		mnNewMenu_2.add(mntmNewMenuItem_9);
		
		
		JMenuItem mntmNewMenuItem_10 = new JMenuItem("Sessions & Not Available Time Allocation Non Overlaping");
		mntmNewMenuItem_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				SessionsANDnotAvailableTimeAllocationNoneOverlaping sessionsANDnotAvailableTimeAllocationNoneOverlaping=new SessionsANDnotAvailableTimeAllocationNoneOverlaping();
				SessionsANDnotAvailableTimeAllocationNoneOverlaping.main(null);
				frame.setVisible(false);
				
			}
			
		});
		mnNewMenu_2.add(mntmNewMenuItem_10);
		
		
		JMenuItem mntmNewMenuItem_31 = new JMenuItem("Sessions & Not Available Time Allocation Parallel");
		mntmNewMenuItem_31.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				SessionsANDnotAvailableTimeAllocationParallel sessionsANDnotAvailableTimeAllocationParallel=new SessionsANDnotAvailableTimeAllocationParallel();
				SessionsANDnotAvailableTimeAllocationParallel.main(null);
				frame.setVisible(false);
				
			}
			
		});
		mnNewMenu_2.add(mntmNewMenuItem_31);

		

		
		JMenu mnNewMenu_3 = new JMenu("Working Days & Hours ");
		mnNewMenu.add(mnNewMenu_3);
		
		JMenuItem mntmNewMenuItem_11 = new JMenuItem("Add Workingdays Hours");
		mntmNewMenuItem_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Add_Workingdays_Hours add_Workingdays_Hours=new Add_Workingdays_Hours();
				Add_Workingdays_Hours.main(null);
				frame.setVisible(false);
				
			}
			
		});
		mnNewMenu_3.add(mntmNewMenuItem_11);
		
		JMenuItem mntmNewMenuItem_65 = new JMenuItem("Manage Workingdays Hours");
		mntmNewMenuItem_65.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Manage_Workingdays_Hours add_Workingdays_Hours=new Manage_Workingdays_Hours();
				Manage_Workingdays_Hours.main(null);
				frame.setVisible(false);
				
			}
			
		});
		mnNewMenu_3.add(mntmNewMenuItem_65);
		
		JMenuItem mntmNewMenuItem_20 = new JMenuItem("Genarate Lecture Time Table");
		mntmNewMenuItem_20.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Genarate_Lecturer_Time_Table genarate_Lecturer_Time_Table=new Genarate_Lecturer_Time_Table();
				Genarate_Lecturer_Time_Table.main(null);
				frame.setVisible(false);
				
			}
			
		});
		
		mnNewMenu_3.add(mntmNewMenuItem_20);
		
		JMenuItem mntmNewMenuItem_12 = new JMenuItem("Genarate Student Time Table");
		mntmNewMenuItem_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Genarate_Student_TimeTable genarate_Student_TimeTable=new Genarate_Student_TimeTable();
				Genarate_Student_TimeTable.main(null);
				frame.setVisible(false);
				
			}
			
		});
		
		mnNewMenu_3.add(mntmNewMenuItem_12);
		
		JMenuItem mntmNewMenuItem_13 = new JMenuItem("Genarate Time Location");
		mntmNewMenuItem_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Genarate_TimeLocation genarate_TimeLocation=new Genarate_TimeLocation();
				Genarate_TimeLocation.main(null);
				frame.setVisible(false);
				
			}
			
		});
		
		
		mnNewMenu_3.add(mntmNewMenuItem_13);
		
		JMenu mnNewMenu_4 = new JMenu("Student & Tags");
		mnNewMenu.add(mnNewMenu_4);
		
		JMenuItem mntmNewMenuItem_14 = new JMenuItem("Add Student Groups");
		
		mntmNewMenuItem_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Add_Student_Groups addstudentgroups=new Add_Student_Groups();
				Add_Student_Groups.main(null);
				frame.setVisible(false);
				
			}
			
		});
		
		
		mnNewMenu_4.add(mntmNewMenuItem_14);
		
		JMenuItem mntmNewMenuItem_15 = new JMenuItem("Add Tag");
		mntmNewMenuItem_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Add_Tag addtags=new Add_Tag();
				Add_Tag.main(null);
				frame.setVisible(false);
				
			}
			
		});
		
		mnNewMenu_4.add(mntmNewMenuItem_15);
		
		JMenuItem mntmNewMenuItem_16 = new JMenuItem("Manage Student Groups");
		
		
		mntmNewMenuItem_16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Manage_Student_Groups managestudentgroups=new Manage_Student_Groups();
				Manage_Student_Groups.main(null);
				frame.setVisible(false);
				
			}
			
		});
		
		mnNewMenu_4.add(mntmNewMenuItem_16);
		
		JMenuItem mntmNewMenuItem_17 = new JMenuItem("Manage Tags");
		
		
		mntmNewMenuItem_17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Manage_Tags managetags=new Manage_Tags();
				Manage_Tags.main(null);
				frame.setVisible(false);
				
			}
			
		});
		mnNewMenu_4.add(mntmNewMenuItem_17);
		
		JMenu mnNewMenu_5 = new JMenu("Location & Statistics");
		mnNewMenu.add(mnNewMenu_5);
		
		JMenuItem mntmNewMenuItem_18 = new JMenuItem("Add Locations Sessions");
		
		mntmNewMenuItem_18.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Add_Locations_Sessions addlocationssessions=new Add_Locations_Sessions();
				Add_Locations_Sessions.main(null);
				frame.setVisible(false);
				
			}
			
		});
		
		
		mnNewMenu_5.add(mntmNewMenuItem_18);
		
		JMenuItem mntmNewMenuItem_19 = new JMenuItem("Add Locations");
		
		
		
		mntmNewMenuItem_19.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Add_Locations addlocations=new Add_Locations();
				Add_Locations.main(null);
				frame.setVisible(false);
				
			}
			
		});
		mnNewMenu_5.add(mntmNewMenuItem_19);
		
		JMenuItem mntmNewMenuItem_30 = new JMenuItem("Manage Locations");
		
		
		
		mntmNewMenuItem_30.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Manage_Locations managelocations=new Manage_Locations();
				Manage_Locations.main(null);
				frame.setVisible(false);
				
			}
			
		});
		
		mnNewMenu_5.add(mntmNewMenuItem_30);
		
	JMenuItem mntmNewMenuItem_34 = new JMenuItem("Visualizing Static");
		
		
		
		mntmNewMenuItem_34.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Visualizing_static visualizing_static=new Visualizing_static();
				Visualizing_static.main(null);
				frame.setVisible(false);
				
			}
			
		});
		
		mnNewMenu_5.add(mntmNewMenuItem_34);
		
		
		
		
		
		
		
		
		
		
		
		////////////////////////////////////////////////////////////
		
		
		
		
		
		
		
		
		JMenu mnNewMenu_7 = new JMenu("About");
		
		


		mnNewMenu_7.setFont(new Font("Segoe UI", Font.BOLD, 15));
		mnNewMenu_7.setBackground(Color.BLACK);
		mnNewMenu_7.setForeground(Color.WHITE);
		menuBar.add(mnNewMenu_7);
		
		JMenuItem mntmNewMenuItem_22 = new JMenuItem("About");
		
		
		
		
		mntmNewMenuItem_22.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				StartUp startup=new StartUp();
				StartUp.main(null);
				frame.setVisible(false);
				
			}
			
		});
		
		mnNewMenu_7.add(mntmNewMenuItem_22);
		
		
		
		
		
		
		
		
		//////////////////////////
		
		
		
		
		
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Computing", "Engineering"}));

		comboBox.setBounds(322, 214, 164, 22);
		frame.getContentPane().add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"SE", "IT", "DS", "Civil", "Mechanical"}));

		comboBox_1.setBounds(322, 249, 164, 22);
		frame.getContentPane().add(comboBox_1);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {" Kandy", " Malabe", "Matara", "Jaffna"}));

		comboBox_3.setBounds(626, 157, 168, 22);
		frame.getContentPane().add(comboBox_3);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"A", "B", "C"}));

		comboBox_4.setBounds(626, 188, 168, 22);
		frame.getContentPane().add(comboBox_4);
		
		JComboBox comboBox_5 = new JComboBox();
		comboBox_5.setModel(new DefaultComboBoxModel(new String[] {"Professor               ", "AssistantProfessor  ", "Senior Lecturer(HG)", "Senior Lecturer   ", "Lecturer", "Assistant Lecturer"}));

		comboBox_5.setBounds(626, 219, 168, 22);
		frame.getContentPane().add(comboBox_5);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//////////////////////////////
		//////////////////////////////////////////////////////
		
			
	
		
		
		JButton btnNewButton = new JButton("Generate Rank");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				

				String autofill;
				String p="Professor";               
				String A="AssistantProfessor";  
				String S ="Senior Lecturer(HG)";
				String Se="Senior Lecturer";   
				String Lec="Lecturer";
				String AL="Assistant Lecturer";
				String getID=textField_1.getText();
				String getRank=(String) comboBox_5.getSelectedItem();
			
				/*if(comboBoxLevel.getSelectedItem().toString().matches(p)) {
					getRank=1;
				}*/
				int i=0;
				if(getRank.contains(p)) {
				 i=1;
					
				}
				if(getRank.contains(A)) {
					i=2;
				}
				if(getRank.contains(S)) {
					i=3;
				}
				if(getRank.contains(Se)) {
					i=4;
				}
				if(getRank.contains(Lec)) {
					i=5;
				}
				if(getRank.contains(AL)) {
					i=6;
				}
				String combination=i+"."+getID;
				textField_5.setText(combination);
				
			}
		});
		
		

		
		

		
		btnNewButton.setBounds(583, 270, 222, 21);
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		frame.getContentPane().add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(322, 153, 164, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(322, 184, 164, 20);
		textField_1.setColumns(10);
		frame.getContentPane().add(textField_1);
		
		
		
		
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Monday");
		chckbxNewCheckBox.setForeground(Color.WHITE);
		chckbxNewCheckBox.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		chckbxNewCheckBox.setBackground(Color.GRAY);
		chckbxNewCheckBox.setBounds(217, 353, 127, 21);
		frame.getContentPane().add(chckbxNewCheckBox);
		
		JCheckBox chckbxTuesday = new JCheckBox("Tuesday");
		chckbxTuesday.setForeground(Color.WHITE);
		chckbxTuesday.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		chckbxTuesday.setBackground(Color.GRAY);
		chckbxTuesday.setBounds(217, 391, 127, 22);
		frame.getContentPane().add(chckbxTuesday);
		
		JCheckBox chckbxWednesday = new JCheckBox("Wednesday");
		chckbxWednesday.setForeground(Color.WHITE);
		chckbxWednesday.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		chckbxWednesday.setBackground(Color.GRAY);
		chckbxWednesday.setBounds(217, 432, 127, 22);
		frame.getContentPane().add(chckbxWednesday);
		
		JCheckBox chckbxThursday = new JCheckBox("Thursday");
		chckbxThursday.setForeground(Color.WHITE);
		chckbxThursday.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		chckbxThursday.setBackground(Color.GRAY);
		chckbxThursday.setBounds(217, 471, 127, 20);
		frame.getContentPane().add(chckbxThursday);
		
		JCheckBox chckbxFriday = new JCheckBox("Friday");
		chckbxFriday.setForeground(Color.WHITE);
		chckbxFriday.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		chckbxFriday.setBackground(Color.GRAY);
		chckbxFriday.setBounds(600, 358, 105, 22);
		frame.getContentPane().add(chckbxFriday);
		
		JCheckBox chckbxSaturday = new JCheckBox("Saturday");
		chckbxSaturday.setForeground(Color.WHITE);
		chckbxSaturday.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		chckbxSaturday.setBackground(Color.GRAY);
		chckbxSaturday.setBounds(600, 396, 105, 22);
		frame.getContentPane().add(chckbxSaturday);
		
		JCheckBox chckbxSunday = new JCheckBox("Sunday");
		chckbxSunday.setForeground(Color.WHITE);
		chckbxSunday.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		chckbxSunday.setBackground(Color.GRAY);
		chckbxSunday.setBounds(602, 435, 103, 22);
		frame.getContentPane().add(chckbxSunday);
		
		
		
		//////////////////////////////////
		
		JLabel lblNewLabel_4_1 = new JLabel("Active days & hours of lecturer");
		lblNewLabel_4_1.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblNewLabel_4_1.setBounds(196, 309, 259, 20);
		frame.getContentPane().add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_4_2_2 = new JLabel("From");
		lblNewLabel_4_2_2.setForeground(Color.WHITE);
		lblNewLabel_4_2_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_4_2_2.setBounds(357, 355, 36, 20);
		frame.getContentPane().add(lblNewLabel_4_2_2);
		
		JLabel lblNewLabel_4_2_1_2 = new JLabel("From");
		lblNewLabel_4_2_1_2.setForeground(Color.WHITE);
		lblNewLabel_4_2_1_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_4_2_1_2.setBounds(357, 395, 36, 20);
		frame.getContentPane().add(lblNewLabel_4_2_1_2);
		
		JLabel lblNewLabel_4_2_1_1_2 = new JLabel("From");
		lblNewLabel_4_2_1_1_2.setForeground(Color.WHITE);
		lblNewLabel_4_2_1_1_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_4_2_1_1_2.setBounds(357, 435, 36, 20);
		frame.getContentPane().add(lblNewLabel_4_2_1_1_2);
		
		JLabel lblNewLabel_4_2_1_1_1_2 = new JLabel("From");
		lblNewLabel_4_2_1_1_1_2.setForeground(Color.WHITE);
		lblNewLabel_4_2_1_1_1_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_4_2_1_1_1_2.setBounds(357, 471, 36, 20);
		frame.getContentPane().add(lblNewLabel_4_2_1_1_1_2);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinner.setBounds(396, 357, 52, 20);
		frame.getContentPane().add(spinner);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinner_1.setBounds(396, 399, 52, 20);
		frame.getContentPane().add(spinner_1);
		
		JSpinner spinner_1_1 = new JSpinner();
		spinner_1_1.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinner_1_1.setBounds(396, 438, 52, 20);
		frame.getContentPane().add(spinner_1_1);
		
		JSpinner spinner_1_2 = new JSpinner();
		spinner_1_2.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinner_1_2.setBounds(396, 473, 52, 20);
		frame.getContentPane().add(spinner_1_2);
		
		JLabel lblNewLabel_4_2_2_1 = new JLabel("To");
		lblNewLabel_4_2_2_1.setForeground(Color.WHITE);
		lblNewLabel_4_2_2_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_4_2_2_1.setBounds(469, 355, 28, 20);
		frame.getContentPane().add(lblNewLabel_4_2_2_1);
		
		JSpinner spinner_2 = new JSpinner();
		spinner_2.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinner_2.setBounds(497, 357, 52, 20);
		frame.getContentPane().add(spinner_2);
		
		JLabel lblNewLabel_4_2_1_2_1 = new JLabel("To");
		lblNewLabel_4_2_1_2_1.setForeground(Color.WHITE);
		lblNewLabel_4_2_1_2_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_4_2_1_2_1.setBounds(469, 395, 28, 20);
		frame.getContentPane().add(lblNewLabel_4_2_1_2_1);
		
		JSpinner spinner_1_3 = new JSpinner();
		spinner_1_3.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinner_1_3.setBounds(497, 399, 52, 20);
		frame.getContentPane().add(spinner_1_3);
		
		JLabel lblNewLabel_4_2_1_1_2_1 = new JLabel("To");
		lblNewLabel_4_2_1_1_2_1.setForeground(Color.WHITE);
		lblNewLabel_4_2_1_1_2_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_4_2_1_1_2_1.setBounds(469, 435, 28, 20);
		frame.getContentPane().add(lblNewLabel_4_2_1_1_2_1);
		
		JSpinner spinner_1_1_1 = new JSpinner();
		spinner_1_1_1.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinner_1_1_1.setBounds(497, 438, 52, 20);
		frame.getContentPane().add(spinner_1_1_1);
		
		JLabel lblNewLabel_4_2_1_1_1_2_1 = new JLabel("To");
		lblNewLabel_4_2_1_1_1_2_1.setForeground(Color.WHITE);
		lblNewLabel_4_2_1_1_1_2_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_4_2_1_1_1_2_1.setBounds(469, 471, 28, 20);
		frame.getContentPane().add(lblNewLabel_4_2_1_1_1_2_1);
		
		JSpinner spinner_1_2_1 = new JSpinner();
		spinner_1_2_1.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinner_1_2_1.setBounds(497, 473, 52, 20);
		frame.getContentPane().add(spinner_1_2_1);
		
		JLabel lblNewLabel_4_2_2_2 = new JLabel("From");
		lblNewLabel_4_2_2_2.setForeground(Color.WHITE);
		lblNewLabel_4_2_2_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_4_2_2_2.setBounds(711, 358, 36, 20);
		frame.getContentPane().add(lblNewLabel_4_2_2_2);
		
		JSpinner spinner_3 = new JSpinner();
		spinner_3.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinner_3.setBounds(750, 360, 52, 20);
		frame.getContentPane().add(spinner_3);
		
		JLabel lblNewLabel_4_2_2_1_1 = new JLabel("To");
		lblNewLabel_4_2_2_1_1.setForeground(Color.WHITE);
		lblNewLabel_4_2_2_1_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_4_2_2_1_1.setBounds(823, 358, 28, 20);
		frame.getContentPane().add(lblNewLabel_4_2_2_1_1);
		
		JSpinner spinner_2_1 = new JSpinner();
		spinner_2_1.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinner_2_1.setBounds(851, 360, 52, 20);
		frame.getContentPane().add(spinner_2_1);
		
		JLabel lblNewLabel_4_2_1_2_2 = new JLabel("From");
		lblNewLabel_4_2_1_2_2.setForeground(Color.WHITE);
		lblNewLabel_4_2_1_2_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_4_2_1_2_2.setBounds(711, 398, 36, 20);
		frame.getContentPane().add(lblNewLabel_4_2_1_2_2);
		
		JSpinner spinner_1_4 = new JSpinner();
		spinner_1_4.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinner_1_4.setBounds(750, 402, 52, 20);
		frame.getContentPane().add(spinner_1_4);
		
		JLabel lblNewLabel_4_2_1_2_1_1 = new JLabel("To");
		lblNewLabel_4_2_1_2_1_1.setForeground(Color.WHITE);
		lblNewLabel_4_2_1_2_1_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_4_2_1_2_1_1.setBounds(823, 398, 28, 20);
		frame.getContentPane().add(lblNewLabel_4_2_1_2_1_1);
		
		JSpinner spinner_1_3_1 = new JSpinner();
		spinner_1_3_1.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinner_1_3_1.setBounds(851, 402, 52, 20);
		frame.getContentPane().add(spinner_1_3_1);
		
		JSpinner spinner_1_1_1_1 = new JSpinner();
		spinner_1_1_1_1.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinner_1_1_1_1.setBounds(851, 441, 52, 20);
		frame.getContentPane().add(spinner_1_1_1_1);
		
		JLabel lblNewLabel_4_2_1_1_2_1_1 = new JLabel("To");
		lblNewLabel_4_2_1_1_2_1_1.setForeground(Color.WHITE);
		lblNewLabel_4_2_1_1_2_1_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_4_2_1_1_2_1_1.setBounds(823, 438, 28, 20);
		frame.getContentPane().add(lblNewLabel_4_2_1_1_2_1_1);
		
		JSpinner spinner_1_1_2 = new JSpinner();
		spinner_1_1_2.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinner_1_1_2.setBounds(750, 441, 52, 20);
		frame.getContentPane().add(spinner_1_1_2);
		
		JLabel lblNewLabel_4_2_1_1_2_2 = new JLabel("From");
		lblNewLabel_4_2_1_1_2_2.setForeground(Color.WHITE);
		lblNewLabel_4_2_1_1_2_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_4_2_1_1_2_2.setBounds(711, 438, 36, 20);
		frame.getContentPane().add(lblNewLabel_4_2_1_1_2_2);
		

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.DARK_GRAY);
		panel_3.setBounds(206, 339, 713, 166);
		frame.getContentPane().add(panel_3);
		
		/////////////////////////////
		
		
		JLabel lblNewLabel_1 = new JLabel("Lecturer Name");
		lblNewLabel_1.setBounds(217, 154, 97, 20);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		frame.getContentPane().add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Lecturer ID");
		lblNewLabel_2.setBounds(217, 185, 88, 20);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		frame.getContentPane().add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Faculty");
		lblNewLabel_3.setBounds(217, 221, 88, 20);
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 14));
		frame.getContentPane().add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Department");
		lblNewLabel_4.setBounds(217, 252, 88, 20);
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 14));
		frame.getContentPane().add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("Center");
		lblNewLabel_5.setBounds(543, 158, 88, 20);
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 14));
		frame.getContentPane().add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("Building");
		lblNewLabel_6.setBounds(545, 190, 88, 20);
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 14));
		frame.getContentPane().add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("Level");
		lblNewLabel_7.setBounds(545, 221, 88, 20);
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.BOLD, 14));
		frame.getContentPane().add(lblNewLabel_7);
		
		
		
		///////////////////////////////////////////////////////////////
		

		
		
		/////////////////////////
		
		
		
		
		
		JButton btnClear = new JButton("Clear");
		
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textField.setText(null);
				textField_1.setText(null);
				comboBox.setSelectedItem(null);
				comboBox_1.setSelectedItem(null);
				comboBox_3.setSelectedItem(null);
				comboBox_4.setSelectedItem(null);
				comboBox_5.setSelectedItem(null);
				textField_5.setText(null);
			}
		});
		

		
		
		btnClear.setBounds(370, 515, 132, 35);
		btnClear.setForeground(new Color(240, 248, 255));
		btnClear.setBackground(new Color(0, 0, 0));
		btnClear.setFont(new Font("SansSerif", Font.BOLD, 13));
		frame.getContentPane().add(btnClear);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
		

				
				
				
				
				String monday="-";
				String tuesday="-";
				String wednesday="-";
				String thursday="-";
				String friday="-";
				String saturday="-";
				String sunday="-";
				
				
				if(chckbxNewCheckBox.isSelected()) {
					monday="Monday";
				}
				if(chckbxTuesday.isSelected()) {
					tuesday="Tuesday";
				}
				if(chckbxWednesday.isSelected()) {
					wednesday="Wednesday";
				}
				if(chckbxThursday.isSelected()) {
					thursday="Thursday";
				}
				if(chckbxFriday.isSelected()) {
					friday="Friday";
				}
				if(chckbxSaturday.isSelected()) {
					saturday="Saturday";
				}
				if(chckbxSunday.isSelected()) {
					sunday="Sunday";
				}
					
					
					
					
				
				try {
					
 if(!(chckbxNewCheckBox.isSelected()||chckbxWednesday.isSelected()||chckbxThursday.isSelected()||chckbxFriday.isSelected()||chckbxSaturday.isSelected())){
						
						JOptionPane.showMessageDialog(null, "Select working days");
						
					}
				else if(textField.getText().equals("") ||textField_1.getText().equals("")||comboBox.getSelectedItem().equals("")||comboBox_1.getSelectedItem().equals("")||comboBox_3.getSelectedItem().equals("")||comboBox_4.getSelectedItem().equals("")||comboBox_5.getSelectedItem().equals("")||textField_5.getText().equals("")
							||spinner.getValue().equals("")||spinner_2.getValue().equals("")||spinner_1.getValue().equals("")||spinner_1_3.getValue().equals("")||spinner_1_1.getValue().equals("")||spinner_1_1_1.getValue().equals("")||spinner_1_2.getValue().equals("")||
							spinner_1_2_1.getValue().equals("")||spinner_3.getValue().equals("")||spinner_2_1.getValue().equals("")||spinner_1_4.getValue().equals("")||spinner_1_3_1.getValue().equals("")||spinner_1_1_1_1.getValue().equals("")||spinner_1_1_2.getValue().equals("")
							
							
							)

					
						/*
		                
		                
		                String Mondayfrom= spinner.getValue().toString();
						String Mondayto= spinner_2.getValue().toString();
						String Tuesdayfrom= spinner_1.getValue().toString();
						String Tuesdayto= spinner_1_3.getValue().toString();
						String Wednesdayfrom= spinner_1_1.getValue().toString();
						String Wednesdayto= spinner_1_1_1.getValue().toString();
						String Thursdayfrom= spinner_1_2.getValue().toString();
						
						String Thursdayto= spinner_1_2_1.getValue().toString();
						String Fridayfrom= spinner_3.getValue().toString();
						String Fridayto= spinner_2_1.getValue().toString();
						String Saturdayfrom= spinner_1_4.getValue().toString();
						String Saturdayto= spinner_1_3_1.getValue().toString();
						String Sundayto= spinner_1_1_2.getValue().toString();
						String Sundayfrom= spinner_1_1_1_1.getValue().toString();
		                
		               */
					
					{
						JOptionPane.showMessageDialog(null, "Please fill the form and press generate button to generate the rank");
						
						 
							
						
					}else if(!(textField.getText().trim().matches("^[A-Za-z]+"))) {
						JOptionPane.showMessageDialog(null, "Invalid lecturer name");
					}else if(!(textField_1.getText().trim().matches("^[0-9]{9}"))) {
						JOptionPane.showMessageDialog(null, "Lecturer ID Should Contain Nine Integers");
					}
					else if(comboBox.getSelectedItem().equals("Computing")&& comboBox_1.getSelectedItem().equals("Civil")) {
						JOptionPane.showMessageDialog(null, "Faculty and Department is mismatch");
						
					}else if(comboBox.getSelectedItem().equals("Engineering")&& comboBox_1.getSelectedItem().equals("SE")) {
						JOptionPane.showMessageDialog(null, "Faculty and Department is mismatch");
						
					}else if(comboBox.getSelectedItem().equals("Engineering")&& comboBox_1.getSelectedItem().equals("DS")) {
						JOptionPane.showMessageDialog(null, "Faculty and Department is mismatch");
						
					}else if(comboBox.getSelectedItem().equals("Engineering")&& comboBox_1.getSelectedItem().equals("IT")) {
						JOptionPane.showMessageDialog(null, "Faculty and Department is mismatch");
					}
					else{
						
						Connection connec = DBConnection.connect();
						
						/*String checkID= "select Emp_ID from Lecturers";
						PreparedStatement pstID = conn.prepareStatement(checkID);
						rs=pstID.executeQuery();
						while(rs.next()) {
							String id = rs.getString("Emp_ID");
						if(LecturerID.getText().equals(id)) {
							System.out.println("The Lecturer id has already exist! Please choose a different id.");
							JOptionPane.showMessageDialog(null, "The Lecturer id has already exist! Please choose a different id.");
						}*/
					
					//String sq="SELECT Emp_ID from Lecturers";
					//java.sql.Statement state = connec.createStatement();
                    //int x = state.executeUpdate(sq);
                    //if (x == 0) {
                     //   JOptionPane.showMessageDialog(null, "This is alredy exist");
                    //}
					//else {
						String Mondayfrom= spinner.getValue().toString();
						String Mondayto= spinner_2.getValue().toString();
						String Tuesdayfrom= spinner_1.getValue().toString();
						String Tuesdayto= spinner_1_3.getValue().toString();
						String Wednesdayfrom= spinner_1_1.getValue().toString();
						String Wednesdayto= spinner_1_1_1.getValue().toString();
						String Thursdayfrom= spinner_1_2.getValue().toString();
						String Thursdayto= spinner_1_2_1.getValue().toString();
						String Fridayfrom= spinner_3.getValue().toString();
						String Fridayto= spinner_2_1.getValue().toString();
						String Saturdayfrom= spinner_1_4.getValue().toString();
						String Saturdayto= spinner_1_3_1.getValue().toString();
						String Sundayfrom= spinner_1_1_2.getValue().toString();
						String Sundayto= spinner_1_1_1_1.getValue().toString();
							
							String Name=textField.getText();
							String ID=textField_1.getText();
							String faculty=comboBox.getSelectedItem().toString();
							String Department=comboBox_3.getSelectedItem().toString();
							String center=comboBox_1.getSelectedItem().toString();
							String building=comboBox_4.getSelectedItem().toString();
							String level= comboBox_5.getSelectedItem().toString();
							String rank=textField_5.getText();
							
				               

							String msg = "" + Name;
			                msg += " \n";
			                
			             
							
							

		                	Connection con = DBConnection.connect();

		                    String query = "INSERT INTO Lecturers values('" + ID + "','" + Name + "','" + faculty + "','" +
		                    		Department + "','" + center + "','" + building + "','"+ level +"','"+ rank +"','"+monday+"','"+tuesday+"','"+wednesday+"','"+thursday+"','"+friday+"','"+saturday+"','"+sunday+"','" + Mondayfrom + "','" + Mondayto + "','" + Tuesdayfrom + "','" +
		                    			Tuesdayto + "','" + Wednesdayfrom + "','" + Wednesdayto + "','"+ Thursdayfrom +"','"+ Thursdayto +"','"+ Fridayfrom +"','"+ Fridayto +"','" + Saturdayfrom + "' ,'"+ Saturdayto +"','"+ Sundayfrom +"','"+ Sundayto +"')";
		                  
		                    java.sql.Statement sta = con.createStatement();
		                    
		                    
		                    
		                    
		                    
		                    
		                    ////////////////
		                    PreparedStatement pst=con.prepareStatement(query);
		                     pst.executeUpdate();
		                    
		                 
		                    
		                    
		                    
		                    ///////////////////////////
		                    
		                    
		                    
		             
		                  
		                    
		                    
		                    
		                    
		                    
		                    
		                    
		                    
		                    
		                    
		                    
		                    /*if (xx == 0) {
		                        JOptionPane.showMessageDialog(null, "This is alredy exist");
		                    } else {
		                        JOptionPane.showMessageDialog(null,
		                            "Welcome, " + msg + "Your account is sucessfully created");
		                    }
		                    String checkID= "select Emp_ID from Lecturers";
							PreparedStatement pstID = conn.prepareStatement(checkID);
							rs=pstID.executeQuery();
							while(rs.next()) {
								String id = rs.getString("Emp_ID");
								if(LecturerID.getText().equals(id))
								JOptionPane.showMessageDialog(null, "This is alredy exist");
								
							}*/
							
		                    
		                    
		                    
		                    JOptionPane.showMessageDialog(null,
		                            "Welcome, " + msg + "Your account is sucessfully created");
		                    
		                    con.close();
		                    textField.setText(null);
		                    textField_1.setText(null);
		                    comboBox.setSelectedItem(null);
		                    comboBox_3.setSelectedItem(null);
		                    comboBox_1.setSelectedItem(null);
		                    comboBox_4.setSelectedItem(null);
		                    comboBox_5.setSelectedItem(null);
		                    textField_5.setText(null);
		                 
		                    
			                spinner.setValue(null);
							spinner_2.setValue(null);
							spinner_1.setValue(null);
							spinner_1_3.setValue(null);
							spinner_1_1.setValue(null);
							spinner_1_1_1.setValue(null);
							spinner_1_2.setValue(null);
							spinner_1_2_1.setValue(null);
							spinner_3.setValue(null);
							spinner_2_1.setValue(null);
							spinner_1_4.setValue(null);
							spinner_1_3_1.setValue(null);
							spinner_1_1_2.setValue(null);
							spinner_1_1_1_1.setValue(null);
		                
							
							
							
							
							
							
						
					}
					}
					
					
				catch(Exception w){
					JOptionPane.showMessageDialog(null, w );
					
				}
				
				finally{
                    try{
                         pst.close();
                                rs.close();
                    }catch(Exception r){
                        
                    }
                }
			/*	try {
					if(LecturerName.getText().equals("") ||LecturerID.getText().equals("")||Faculty.getSelectedItem().equals("")||Deprtment.getSelectedItem().equals("")||Center.getSelectedItem().equals("")||Building.getSelectedItem().equals("")||Level.getSelectedItem().equals("")||Rank.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Please fill the form and press generate button to generate the rank");
						
						 
							
						
					}else if(!(LecturerID.getText().trim().matches("^[0-9]{9}"))){
						JOptionPane.showMessageDialog(null, "Invalid ID Format");
					
					}else{
						
						Class.forName("org.sqlite.JDBC");
						Connection conn=DriverManager.getConnection("jdbc:sqlite:ITPM.db");
						
						String sql="insert into Lecturers(Emp_ID,LecturerName,Faculty,Center,Department,Building,Level,Rank) values(?,?,?,?,?,?,?,?)";
						System.out.print("done");
						pstd=conn.prepareStatement(sql);
						System.out.print("Done");
						pstd.setString(1, LecturerID.getText());
						pstd.setString(2, LecturerName.getText());
						pstd.setString(3, (String) Faculty.getSelectedItem());
						pstd.setString(4, (String) Deprtment.getSelectedItem());
						pstd.setString(5, (String) Center.getSelectedItem());
						pstd.setString(6, (String) Building.getSelectedItem());
						pstd.setString(7, (String) Level.getSelectedItem());
						pstd.setString(8, Rank.getText());
						pstd.execute(); 
						
					
						  JOptionPane.showMessageDialog(null, "Added Successfully");
						  LecturerName.setText(null);
						  LecturerID.setText(null);
						  Faculty.setSelectedItem(null);
						  Deprtment.setSelectedItem(null);
						  Center.setSelectedItem(null);
						  Building.setSelectedItem(null);
						  Level.setSelectedItem(null);
						  Rank.setText(null);
						  
						  pstd.close();
                          rs.close();
	
					}
				}
				catch(Exception w) {
					
					
				}*/
			
				/*String Name=LecturerName.getText();
				String ID=LecturerID.getText();
				String faculty=Faculty.getSelectedItem().toString();
				String Department=Deprtment.getSelectedItem().toString();
				String center=Center.getSelectedItem().toString();
				String building=Building.getSelectedItem().toString();
				String level=Level.getSelectedItem().toString();
				String rank=Rank.getText();
				
	               

				String msg = "" + Name;
                msg += " \n";
	                

	               
	                
				if(LecturerName.getText().equals("") ||LecturerID.getText().equals("")||Faculty.getSelectedItem().equals("")||Deprtment.getSelectedItem().equals("")||Center.getSelectedItem().equals("")||Building.getSelectedItem().equals("")||Level.getSelectedItem().equals("")||Rank.getText().equals("")) {
						
					JOptionPane.showMessageDialog(null, "Please fill the form and press generate button to generate the rank");
					}else {
	                try {
	                	Connection con = DBConnection.connect();

	                    String query = "INSERT INTO Lecturers values('" + ID + "','" + Name + "','" + faculty + "','" +
	                    		center + "','" + Department + "','" + building + "','"+ level +"','"+ rank +"')";

	                    java.sql.Statement sta = con.createStatement();
	                    int x = sta.executeUpdate(query);
	                    if (x == 0) {
	                        JOptionPane.showMessageDialog(null, "This is alredy exist");
	                    } else {
	                        JOptionPane.showMessageDialog(null,
	                            "Welcome, " + msg + "Your account is sucessfully created");
	                    }
	                    
	                    
	                    con.close();
	                    LecturerName.setText(null);
						  LecturerID.setText(null);
						  Faculty.setSelectedItem(null);
						  Deprtment.setSelectedItem(null);
						  Center.setSelectedItem(null);
						  Building.setSelectedItem(null);
						  Level.setSelectedItem(null);
						  Rank.setText(null);
	                    
	                   
	                } catch (Exception exception) {
	                    exception.printStackTrace();
	                }
					
					} */
					}
	              
				
				
					
			
		});
		
		
	
			////////////
		/*
				try {
					if(textField.getText().equals("") ||textField_1.getText().equals("")||comboBox.getSelectedItem().equals("")||comboBox_1.getSelectedItem().equals("")||comboBox_3.getSelectedItem().equals("")||comboBox_4.getSelectedItem().equals("")||comboBox_5.getSelectedItem().equals("")||textField_5.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Please fill the form and press generate button to generate the rank");
						
						 
							
						
					}else if(!(textField_1.getText().trim().matches("^[0-9]{9}"))){
						JOptionPane.showMessageDialog(null, "Invalid ID Format");
					
					}else{
						
						Class.forName("org.sqlite.JDBC");
						Connection conn=DriverManager.getConnection("jdbc:sqlite:ITPM.db");
						
						String checkID= "select Emp_ID from Lecturers";
						PreparedStatement pstID = conn.prepareStatement(checkID);
						rs=pstID.executeQuery();
						while(rs.next()) {
							String id = rs.getString("Emp_ID");
						if(textField_1.getText().equals(id)) {
							System.out.println("The Lecturer id has already exist! Please choose a different id.");
							JOptionPane.showMessageDialog(null, "The Lecturer id has already exist! Please choose a different id.");
						}else {
							

						String sql="insert into Lecturers(Emp_ID,LecturerName,Faculty,Center,Department,Building,Level,Rank) values(?,?,?,?,?,?,?,?)";
						
						pst=conn.prepareStatement(sql);
						
						pst.setString(2, textField.getText());
						 pst.setString(1, textField_1.getText());
						 
						
						 pst.setString(3, (String) comboBox.getSelectedItem());
						 pst.setString(4, (String) comboBox_1.getSelectedItem());
						 pst.setString(5, (String) comboBox_3.getSelectedItem());
						 pst.setString(6, (String) comboBox_4.getSelectedItem());
						 pst.setString(7, (String) comboBox_5.getSelectedItem());
						 pst.setString(8, textField_5.getText());
						 pst.execute();
						
						  JOptionPane.showMessageDialog(null, "Added Successfully");
						  
						  
						  textField.setText(null);
						  textField_1.setText(null);
						  comboBox.setSelectedItem(null);
						  comboBox_1.setSelectedItem(null);
						  comboBox_3.setSelectedItem(null);
						  comboBox_4.setSelectedItem(null);
						  comboBox_5.setSelectedItem(null);
						  textField_5.setText(null);
						  
						  pst.close();
                          rs.close();
						}
					}
					}
					
					
				}catch(Exception w){
					JOptionPane.showMessageDialog(null, w );
					
				}
				
				finally{
                    try{
                         pst.close();
                                rs.close();
                    }catch(Exception r){
                        
                    }
                }
				
			}
		});
		*/
		
		btnSave.setBounds(613, 515, 132, 35);
		btnSave.setForeground(new Color(255, 255, 255));
		btnSave.setBackground(new Color(0, 0, 0));
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 13));
		frame.getContentPane().add(btnSave);
		
	
		
		txtTimeTableManagement = new JTextField();
		txtTimeTableManagement.setEditable(false);
		txtTimeTableManagement.setBounds(0, 0, 946, 87);
		txtTimeTableManagement.setForeground(new Color(255, 255, 255));
		txtTimeTableManagement.setFont(new Font("Tahoma", Font.PLAIN, 23));
		txtTimeTableManagement.setText("                                           Time Table Management System");
		txtTimeTableManagement.setBackground(Color.GRAY);
		frame.getContentPane().add(txtTimeTableManagement);
		txtTimeTableManagement.setColumns(10);
		
		txtAddLecturer = new JTextField();
		txtAddLecturer.setEditable(false);
		txtAddLecturer.setBounds(0, 84, 946, 29);
		txtAddLecturer.setText("                                                             ADD LECTURER");
		txtAddLecturer.setForeground(new Color(255, 0, 0));
		txtAddLecturer.setFont(new Font("Arial Black", Font.BOLD, 19));
		txtAddLecturer.setColumns(10);
		txtAddLecturer.setBackground(new Color(0, 0, 0));
		frame.getContentPane().add(txtAddLecturer);
		
		JButton btnAddLecturer = new JButton("ADD LECTURER");
		btnAddLecturer.setBounds(0, 237, 174, 35);
		btnAddLecturer.setForeground(new Color(255, 0, 0));
		btnAddLecturer.setBackground(new Color(0, 0, 0));
		btnAddLecturer.setFont(new Font("Arial Black", Font.BOLD, 11));
		frame.getContentPane().add(btnAddLecturer);
		
		JButton btnManageLecturer = new JButton("MANAGE LECTURERS");
		
		btnManageLecturer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Manage_Lecturer managelecture=new Manage_Lecturer();
				Manage_Lecturer.main(null);
				frame.setVisible(false);
				
			}
			
		});
		
		
		
		
		
		
		
		
		btnManageLecturer.setBounds(0, 271, 174, 29);
		btnManageLecturer.setForeground(new Color(255, 255, 255));
		btnManageLecturer.setBackground(new Color(0, 0, 0));
		btnManageLecturer.setFont(new Font("Arial Black", Font.BOLD, 11));
		frame.getContentPane().add(btnManageLecturer);
		
		JLabel lblNewLabel_8_1 = new JLabel("Rank");
		lblNewLabel_8_1.setBounds(585, 301, 46, 20);
		lblNewLabel_8_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		frame.getContentPane().add(lblNewLabel_8_1);
		
		textField_5 = new JTextField();
		textField_5.setBounds(637, 301, 164, 20);
		textField_5.setColumns(10);
		frame.getContentPane().add(textField_5);
		
		JPanel panel = new JPanel();
		panel.setBounds(559, 261, 259, 71);
		frame.getContentPane().add(panel);
		
		panel_1 = new JPanel();
		panel_1.setBounds(0, 424, 174, 103);
		panel_1.setBackground(Color.GRAY);
		frame.getContentPane().add(panel_1);
		
		panel_2 = new JPanel();
		panel_2.setBounds(0, 525, 174, 53);
		panel_2.setBackground(Color.GRAY);
		frame.getContentPane().add(panel_2);
		
		btnDelete = new JButton("<<Back");
		
		
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Dashboard dashboard=new Dashboard();
				Dashboard.main(null);
				frame.setVisible(false);
				
			}
			
		});
		
		
		
		
		
		
		
		btnDelete.setForeground(new Color(240, 248, 255));
		btnDelete.setFont(new Font("SansSerif", Font.BOLD, 13));
		btnDelete.setBackground(Color.BLACK);
		panel_2.add(btnDelete);
		
		panel_1_1 = new JPanel();
		panel_1_1.setBounds(0, 114, 174, 124);
		panel_1_1.setBackground(Color.GRAY);
		frame.getContentPane().add(panel_1_1);
		
		btnAddSession = new JButton("ADD SUBJECT");
		
		
		
		btnAddSession.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Add_Subjects addsubjects=new Add_Subjects();
				Add_Subjects.main(null);
				frame.setVisible(false);
				
			}
			
		});

		
		
		btnAddSession.setBounds(0, 297, 174, 35);
		btnAddSession.setForeground(Color.WHITE);
		btnAddSession.setFont(new Font("Arial Black", Font.BOLD, 11));
		btnAddSession.setBackground(Color.BLACK);
		frame.getContentPane().add(btnAddSession);
		
		btnUpdateSession = new JButton("MANAGE SUBJECTS");
		
		
		
		
		btnUpdateSession.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Manage_Subjects managesubjects=new Manage_Subjects();
				Manage_Subjects.main(null);
				frame.setVisible(false);
				
			}
			
		});

		
		
		
		
		btnUpdateSession.setBounds(0, 331, 174, 29);
		btnUpdateSession.setForeground(Color.WHITE);
		btnUpdateSession.setFont(new Font("Arial Black", Font.BOLD, 11));
		btnUpdateSession.setBackground(Color.BLACK);
		frame.getContentPane().add(btnUpdateSession);
		
		btnManageLsession = new JButton("ADD SESSION");
		
		
		
		btnManageLsession.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Add_Session addsession=new Add_Session();
				Add_Session.main(null);
				frame.setVisible(false);
				
			}
			
		});
	
		
		
		
		
		btnManageLsession.setBounds(0, 358, 174, 35);
		btnManageLsession.setForeground(Color.WHITE);
		btnManageLsession.setFont(new Font("Arial Black", Font.BOLD, 11));
		btnManageLsession.setBackground(Color.BLACK);
		frame.getContentPane().add(btnManageLsession);
		
		JButton btnManageSession = new JButton("MANAGE SESSION");
		
		
		
		btnManageSession.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Manage_Sessions managesession=new Manage_Sessions();
				Manage_Sessions.main(null);
				frame.setVisible(false);
				
			}
			
		});
		
		
		
		
		
		btnManageSession.setBounds(0, 391, 174, 35);
		btnManageSession.setForeground(Color.WHITE);
		btnManageSession.setFont(new Font("Arial Black", Font.BOLD, 11));
		btnManageSession.setBackground(Color.BLACK);
		frame.getContentPane().add(btnManageSession);
		
	
	}
}
