package Working_Days_and_Hours;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;
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
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import DBC.DBConnection;
import Home.Dashboard;
import Home.StartUp;
import Leactures_and_Subjects.Add_Lecturer;
import Leactures_and_Subjects.Add_Subjects;
import Leactures_and_Subjects.Manage_Lecturer;
import Leactures_and_Subjects.Manage_Subjects;
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

import javax.swing.JToggleButton;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Statement;

import javax.swing.JCheckBox;

public class Add_Workingdays_Hours {

	private JFrame frame;
	private JLabel lblNewLabel_2;
	private JTextField txtAddWorkingDays;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add_Workingdays_Hours window = new Add_Workingdays_Hours();
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
	public Add_Workingdays_Hours() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.activeCaption);
		frame.setBounds(100, 100, 960, 635);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);JLabel lblNewLabel_1 = new JLabel("No of Working Days");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_1.setBounds(231, 174, 158, 20);
		frame.getContentPane().add(lblNewLabel_1);
		
		
		
		
		
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
				
				Manage_Workingdays_Hours manage_Workingdays_Hours=new Manage_Workingdays_Hours();
				Manage_Workingdays_Hours.main(null);
				frame.setVisible(false);
				
			}
			
		});
		mnNewMenu_3.add(mntmNewMenuItem_65);
		

		
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
		
		
		
		
		lblNewLabel_2 = new JLabel("Working Time Per Day");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_2.setBounds(342, 436, 148, 20);
		frame.getContentPane().add(lblNewLabel_2);
		
		JButton btnClearsubject = new JButton("Clear");
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(395, 176, 80, 20);
		frame.getContentPane().add(spinner);
		
		JLabel lblNewLabel_1_1 = new JLabel("Working Days");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(215, 214, 122, 20);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setBounds(500, 438, 80, 20);
		frame.getContentPane().add(spinner_1);
		
		JSpinner spinner_1_1 = new JSpinner();
		spinner_1_1.setBounds(649, 438, 80, 20);
		frame.getContentPane().add(spinner_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Hours");
		lblNewLabel_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_1_1_1.setBounds(590, 436, 54, 20);
		frame.getContentPane().add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Miniutes");
		lblNewLabel_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_1_1_1_1.setBounds(739, 436, 72, 20);
		frame.getContentPane().add(lblNewLabel_1_1_1_1);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(Color.GRAY);
		panel_1_1.setBounds(0, 114, 206, 193);
		frame.getContentPane().add(panel_1_1);
		
		txtAddWorkingDays = new JTextField();
		txtAddWorkingDays.setEditable(false);
		txtAddWorkingDays.setText("                                                ADD WORKING DAYS AND HOURS");
		txtAddWorkingDays.setForeground(Color.RED);
		txtAddWorkingDays.setFont(new Font("Arial Black", Font.BOLD, 19));
		txtAddWorkingDays.setColumns(10);
		txtAddWorkingDays.setBackground(Color.BLACK);
		txtAddWorkingDays.setBounds(0, 84, 946, 29);
		frame.getContentPane().add(txtAddWorkingDays);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setText("                                           Time Table Management System");
		textField_1.setForeground(Color.WHITE);
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 23));
		textField_1.setColumns(10);
		textField_1.setBackground(Color.GRAY);
		textField_1.setBounds(0, 0, 946, 87);
		frame.getContentPane().add(textField_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.GRAY);
		panel_1.setBounds(0, 373, 206, 154);
		frame.getContentPane().add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.GRAY);
		panel_2.setBounds(0, 525, 206, 53);
		frame.getContentPane().add(panel_2);
		
		JButton btnDelete = new JButton("<<Back");

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
				
		JButton btnClear_1_1 = new JButton("Clear");
		btnClear_1_1.setForeground(new Color(240, 248, 255));
		btnClear_1_1.setFont(new Font("SansSerif", Font.BOLD, 13));
		btnClear_1_1.setBackground(Color.BLACK);
		btnClear_1_1.setBounds(625, 508, 132, 35);
		frame.getContentPane().add(btnClear_1_1);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Monday");
		chckbxNewCheckBox.setSelected(true);
		chckbxNewCheckBox.setForeground(Color.WHITE);
		chckbxNewCheckBox.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		chckbxNewCheckBox.setBackground(Color.GRAY);
		chckbxNewCheckBox.setBounds(264, 248, 125, 25);
		frame.getContentPane().add(chckbxNewCheckBox);
		
		JCheckBox chckbxTuesday = new JCheckBox("Tuesday");
		chckbxTuesday.setSelected(true);
		chckbxTuesday.setForeground(Color.WHITE);
		chckbxTuesday.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		chckbxTuesday.setBackground(Color.GRAY);
		chckbxTuesday.setBounds(404, 248, 125, 25);
		frame.getContentPane().add(chckbxTuesday);
		
		JCheckBox chckbxWednesday = new JCheckBox("Wednesday");
		chckbxWednesday.setSelected(true);
		chckbxWednesday.setForeground(Color.WHITE);
		chckbxWednesday.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		chckbxWednesday.setBackground(Color.GRAY);
		chckbxWednesday.setBounds(544, 248, 135, 25);
		frame.getContentPane().add(chckbxWednesday);
		
		JCheckBox chckbxThursday = new JCheckBox("Thursday");
		chckbxThursday.setSelected(true);
		chckbxThursday.setForeground(Color.WHITE);
		chckbxThursday.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		chckbxThursday.setBackground(Color.GRAY);
		chckbxThursday.setBounds(692, 248, 125, 25);
		frame.getContentPane().add(chckbxThursday);
		
		JCheckBox chckbxFriday = new JCheckBox("Friday");
		chckbxFriday.setSelected(true);
		chckbxFriday.setForeground(Color.WHITE);
		chckbxFriday.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		chckbxFriday.setBackground(Color.GRAY);
		chckbxFriday.setBounds(831, 248, 125, 25);
		frame.getContentPane().add(chckbxFriday);
		
		JCheckBox chckbxSaturday = new JCheckBox("Saturday");
		chckbxSaturday.setSelected(true);
		chckbxSaturday.setForeground(Color.WHITE);
		chckbxSaturday.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		chckbxSaturday.setBackground(Color.GRAY);
		chckbxSaturday.setBounds(389, 386, 125, 25);
		frame.getContentPane().add(chckbxSaturday);
		
		JCheckBox chckbxSunday = new JCheckBox("Sunday");
		chckbxSunday.setSelected(true);
		chckbxSunday.setForeground(Color.WHITE);
		chckbxSunday.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		chckbxSunday.setBackground(Color.GRAY);
		chckbxSunday.setBounds(554, 386, 125, 25);
		frame.getContentPane().add(chckbxSunday);
		
		JButton btnAddWorkingDays = new JButton("ADD WORKING DAYS");
		btnAddWorkingDays.setForeground(Color.RED);
		btnAddWorkingDays.setFont(new Font("Arial Black", Font.BOLD, 11));
		btnAddWorkingDays.setBackground(Color.BLACK);
		btnAddWorkingDays.setBounds(0, 306, 206, 35);
		frame.getContentPane().add(btnAddWorkingDays);
		
		JButton btnManageWorkingDays = new JButton("MANAGE WORKING DAYS");
		btnManageWorkingDays.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Manage_Workingdays_Hours manageWorkingDays=new Manage_Workingdays_Hours();
				Manage_Workingdays_Hours.main(null);
				frame.setVisible(false);
				
			}
			
		});
		btnManageWorkingDays.setForeground(Color.WHITE);
		btnManageWorkingDays.setFont(new Font("Arial Black", Font.BOLD, 11));
		btnManageWorkingDays.setBackground(Color.BLACK);
		btnManageWorkingDays.setBounds(0, 340, 206, 35);
		frame.getContentPane().add(btnManageWorkingDays);
		
		JLabel lblNewLabel_2_1 = new JLabel("Working Time Per Day");
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_2_1.setBounds(342, 318, 148, 20);
		frame.getContentPane().add(lblNewLabel_2_1);
		
		JSpinner spinner_1_2 = new JSpinner();
		spinner_1_2.setBounds(500, 320, 80, 20);
		frame.getContentPane().add(spinner_1_2);
		
		JLabel lblNewLabel_1_1_1_2 = new JLabel("Hours");
		lblNewLabel_1_1_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_1_1_1_2.setBounds(590, 318, 54, 20);
		frame.getContentPane().add(lblNewLabel_1_1_1_2);
		
		JSpinner spinner_1_1_1 = new JSpinner();
		spinner_1_1_1.setBounds(649, 320, 80, 20);
		frame.getContentPane().add(spinner_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Miniutes");
		lblNewLabel_1_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_1_1_1_1_1.setBounds(739, 318, 72, 20);
		frame.getContentPane().add(lblNewLabel_1_1_1_1_1);
		
		
		
		

		JButton btnClear_1 = new JButton("Submit");
		
		
		btnClear_1.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent arg0) {
				String NoOfWorkingDays= spinner.getValue().toString();
						String weekdayhours= spinner_1_2.getValue().toString();
				String weekendhours= spinner_1.getValue().toString();
				String weekdayminutes= spinner_1_1_1.getValue().toString();
				String weekendminutes= spinner_1_1.getValue().toString();
				
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
					 Connection con = DBConnection.connect();

	                    String query = "INSERT INTO workingdays values(1, '" + NoOfWorkingDays + "','" + monday + "','" + tuesday + "','" +
	                    		wednesday + "','" + thursday + "','" + friday + "','"+ saturday +"','"+ sunday +"','"+ weekdayhours +"','"+ weekendhours +"','"+ weekdayminutes +"','"+ weekendminutes +"')";

	                    Statement sta = con.createStatement();
	                    int x = sta.executeUpdate(query);
	                    if (x == 0) {
	                        JOptionPane.showMessageDialog(btnClear_1, "This is alredy exist");
	                    } else {
	                        JOptionPane.showMessageDialog(btnClear_1,
	                            "Welcome, Your account is sucessfully created");
	                    }
	                    con.close();
	                } catch (Exception exception) {
	                    //exception.printStackTrace();
	                	JOptionPane.showMessageDialog(btnClear_1, "This is alredy exist");
	                }
			}
		});
		
		
		btnClear_1.setForeground(new Color(240, 248, 255));
		btnClear_1.setFont(new Font("SansSerif", Font.BOLD, 13));
		btnClear_1.setBackground(Color.BLACK);
		btnClear_1.setBounds(395, 508, 132, 35);
		frame.getContentPane().add(btnClear_1);

		
		
		
		
		
		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setBackground(Color.DARK_GRAY);
		panel_1_1_1.setBounds(209, 232, 737, 116);
		frame.getContentPane().add(panel_1_1_1);
		
		JPanel panel_1_1_1_1 = new JPanel();
		panel_1_1_1_1.setBackground(Color.DARK_GRAY);
		panel_1_1_1_1.setBounds(215, 376, 721, 102);
		frame.getContentPane().add(panel_1_1_1_1);
	}
}
