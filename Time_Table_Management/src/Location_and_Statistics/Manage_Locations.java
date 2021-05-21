package Location_and_Statistics;

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
import Session_and_TimeAllocation.Add_Session;
import Session_and_TimeAllocation.ConsecutiveSessionRooms;
import Session_and_TimeAllocation.Manage_Session_Rooms;

import Session_and_TimeAllocation.Manage_Sessions;
import Session_and_TimeAllocation.Not_Available_Time;
import Session_and_TimeAllocation.SessionsANDnotAvailableTimeAllocationConsecutive;
import Session_and_TimeAllocation.SessionsANDnotAvailableTimeAllocationNoneOverlaping;
import Session_and_TimeAllocation.SessionsANDnotAvailableTimeAllocationParallel;
import Session_and_TimeAllocation.SessionsRooms;
import Students_and_Tags.Add_Student_Groups;
import Students_and_Tags.Add_Tag;
import Students_and_Tags.Manage_Student_Groups;
import Students_and_Tags.Manage_Tags;
import Timetable.Lecturer;
import Timetable.Location;
import Timetable.Student;
import Working_Days_and_Hours.Add_Workingdays_Hours;

import Working_Days_and_Hours.Manage_Workingdays_Hours;
import net.proteanit.sql.DbUtils;

import javax.swing.JToggleButton;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JCheckBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Manage_Locations {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_7;
	private JTextField textField_2;
	private JTable table;
	private JPanel panel;
	private JTextField textField_3;
	private JTextField txtManageLocations;
	private JButton btnAddLocations;
	private JButton btnManageLocations;
	private JPanel panel_1;
	private JPanel panel_2;
	private JButton btnDelete;
	private JButton btnDelete_1;
	private JButton btnClear;
	private JButton btnSave;
	private JButton btnRefresh;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Manage_Locations window = new Manage_Locations();
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
	public Manage_Locations() {
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
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null); //this method display the JFrame to center position of a screen
		
		
		
		
		
		
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
		
		JMenu mnNewMenu_1 = new JMenu("Lectures & Subjects");
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
				
				Manage_Session_Rooms manage_Not_Available_Times=new Manage_Session_Rooms();
				Manage_Session_Rooms.main(null);
				frame.setVisible(false);
				
			}
			
		});
		mnNewMenu_2.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Consecutive Session rooms");
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				ConsecutiveSessionRooms manage_Session_Rooms=new ConsecutiveSessionRooms();
				ConsecutiveSessionRooms.main(null);
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
		
		///
		
		
		JMenuItem mntmNewMenuItem_21 = new JMenuItem("Session Rooms");
		mntmNewMenuItem_21.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				SessionsRooms manage_Session_Rooms=new SessionsRooms();
				SessionsRooms.main(null);
				frame.setVisible(false);
				
			}
			
		});
		
		mnNewMenu_2.add(mntmNewMenuItem_21);
		///
		
		
		
		
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
		
		
		
		JMenu mnNewMenu_33 = new JMenu("Generate Time Tables");
		mnNewMenu.add(mnNewMenu_33);
		
		JMenuItem mntmNewMenuItem_111 = new JMenuItem("Lecturer");
		mntmNewMenuItem_111.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Lecturer lec=new Lecturer();
				Lecturer.main(null);
				frame.setVisible(false);
				
			}
			
		});
		mnNewMenu_33.add(mntmNewMenuItem_111);
		
		
		
		JMenuItem mntmNewMenuItem_655 = new JMenuItem("Student");
		mntmNewMenuItem_655.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Student student=new Student();
				Student.main(null);
				frame.setVisible(false);
				
			}
			
		});
		mnNewMenu_33.add(mntmNewMenuItem_655);

		
		JMenuItem mntmNewMenuItem_432 = new JMenuItem("Location");
		mntmNewMenuItem_432.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Location location=new Location();
				Location.main(null);
				frame.setVisible(false);
				
			}
			
		});
		mnNewMenu_33.add(mntmNewMenuItem_432);
		
		
		
		
		
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


		
		JCheckBox chckbxLectureHall = new JCheckBox("Lecture Hall");
		chckbxLectureHall.setSelected(true);
		chckbxLectureHall.setForeground(Color.WHITE);
		chckbxLectureHall.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		chckbxLectureHall.setBackground(Color.GRAY);
		chckbxLectureHall.setBounds(656, 407, 140, 21);
		frame.getContentPane().add(chckbxLectureHall);
		
		JCheckBox chckbxLaboratary = new JCheckBox("Laboratary");
		chckbxLaboratary.setSelected(true);
		chckbxLaboratary.setForeground(Color.WHITE);
		chckbxLaboratary.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		chckbxLaboratary.setBackground(Color.GRAY);
		chckbxLaboratary.setBounds(806, 406, 122, 22);
		frame.getContentPane().add(chckbxLaboratary);
		
		
		
		
		
		
		
		
		
		
		
		textField = new JTextField();
		textField.setBounds(320, 422, 200, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(682, 457, 200, 20);
		frame.getContentPane().add(textField_1);
		
		lblNewLabel_2 = new JLabel("Room Type");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_2.setBounds(576, 406, 122, 20);
		frame.getContentPane().add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Building Name");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_3.setBounds(215, 421, 99, 20);
		frame.getContentPane().add(lblNewLabel_3);
		
		lblNewLabel_7 = new JLabel("Capacity");
		lblNewLabel_7.setForeground(Color.WHITE);
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_7.setBounds(576, 456, 114, 20);
		frame.getContentPane().add(lblNewLabel_7);
		
		JButton btnClearsubject = new JButton("Clear");
		
		JLabel lblNewLabel_3_1 = new JLabel("Room Name");
		lblNewLabel_3_1.setForeground(Color.WHITE);
		lblNewLabel_3_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_3_1.setBounds(215, 452, 99, 20);
		frame.getContentPane().add(lblNewLabel_3_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(320, 453, 200, 20);
		frame.getContentPane().add(textField_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(243, 165, 628, 169);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				 int selectedRow=table.getSelectedRow();
				
				 //////
					//textField.setText(table.getValueAt(selectedRow, 1).toString());
				 textField_4.setText(table.getValueAt(selectedRow, 0).toString());
				 textField.setText(table.getValueAt(selectedRow, 1).toString());
					
				 textField_2.setText(table.getValueAt(selectedRow, 2).toString());
				 textField_1.setText(table.getValueAt(selectedRow, 3).toString());
				 
				 
				 String checkdaymon=table.getValueAt(selectedRow, 4).toString();
					String checkdaytues=table.getValueAt(selectedRow, 5).toString();
				 if(checkdaymon.equals("Monday")) {
					 chckbxLectureHall.setSelected(true);
					}
					else{
						chckbxLectureHall.setSelected(false);
					}
					
					
					if(checkdaytues.equals("Tuesday")) {
						chckbxLaboratary.setSelected(true);
					}
					else{
						chckbxLaboratary.setSelected(false);
					}	 
	              
	              
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"ID", "Building", "Room", "Room type", "Capacity"
			}
		));
		scrollPane.setViewportView(table);
		
		panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(0, 113, 174, 186);
		frame.getContentPane().add(panel);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setText("                                           Time Table Management System");
		textField_3.setForeground(Color.WHITE);
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 23));
		textField_3.setColumns(10);
		textField_3.setBackground(Color.GRAY);
		textField_3.setBounds(0, 0, 946, 87);
		frame.getContentPane().add(textField_3);
		
		txtManageLocations = new JTextField();
		txtManageLocations.setEditable(false);
		txtManageLocations.setText("                                                            MANAGE LOCATIONS");
		txtManageLocations.setForeground(Color.RED);
		txtManageLocations.setFont(new Font("Arial Black", Font.BOLD, 19));
		txtManageLocations.setColumns(10);
		txtManageLocations.setBackground(Color.BLACK);
		txtManageLocations.setBounds(0, 84, 946, 29);
		frame.getContentPane().add(txtManageLocations);
		
		btnAddLocations = new JButton("ADD LOCATIONS");
		
		
		btnAddLocations.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Add_Locations addlecturer=new Add_Locations();
				Add_Locations.main(null);
				frame.setVisible(false);
				
			}
			
		});
		btnAddLocations.setForeground(new Color(255, 255, 255));
		btnAddLocations.setFont(new Font("Arial Black", Font.BOLD, 11));
		btnAddLocations.setBackground(Color.BLACK);
		btnAddLocations.setBounds(0, 299, 174, 35);
		frame.getContentPane().add(btnAddLocations);
		
		btnManageLocations = new JButton("MANAGE LOCATIONS");
		btnManageLocations.setForeground(new Color(255, 0, 0));
		btnManageLocations.setFont(new Font("Arial Black", Font.BOLD, 11));
		btnManageLocations.setBackground(Color.BLACK);
		btnManageLocations.setBounds(0, 333, 174, 29);
		frame.getContentPane().add(btnManageLocations);
		
		panel_1 = new JPanel();
		panel_1.setBackground(Color.GRAY);
		panel_1.setBounds(0, 362, 174, 159);
		frame.getContentPane().add(panel_1);
		
		panel_2 = new JPanel();
		panel_2.setBackground(Color.GRAY);
		panel_2.setBounds(0, 519, 174, 53);
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
		
		btnDelete_1 = new JButton("Delete");

		btnDelete_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {
					if(textField_4.getText().equals("")){
						JOptionPane.showMessageDialog(null, "PLEASE CLICK THE ROW");
					}else {
					Connection con = DBConnection.connect();
					String query="Delete from location where id='"+textField_4.getText()+"'";
					PreparedStatement pst=con.prepareStatement(query);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Deleted");
					pst.close();
					}
					
				}
				catch(Exception q) {
					q.printStackTrace();
				}
		
				
				
		
			}
		});
		
		btnDelete_1.setForeground(new Color(240, 248, 255));
		btnDelete_1.setFont(new Font("SansSerif", Font.BOLD, 13));
		btnDelete_1.setBackground(Color.BLACK);
		btnDelete_1.setBounds(519, 519, 132, 35);
		frame.getContentPane().add(btnDelete_1);
		
		btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField_2.setText("");
			
				textField_1.setText("");
				
				
			}
		});
		
		btnClear.setForeground(new Color(240, 248, 255));
		btnClear.setFont(new Font("SansSerif", Font.BOLD, 13));
		btnClear.setBackground(Color.BLACK);
		btnClear.setBounds(716, 519, 132, 35);
		frame.getContentPane().add(btnClear);
		
		btnSave = new JButton("Update");
		
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				//////////////////
				
				
	
					
				try {
					
					Connection con = DBConnection.connect();
					
					
					
									String query="Update location set buildName='"+textField.getText()+"' where id='"+textField_4.getText()+"' ";
									
									String query2="Update location set roomName='"+textField_2.getText()+"' where id='"+textField_4.getText()+"' ";
String query1="Update location set lecturer_hall='"+chckbxLectureHall.isSelected()+"' where id='"+textField_4.getText()+"' ";
									
									String query4="Update location set lab='"+chckbxLaboratary.isSelected()+"' where id='"+textField_4.getText()+"' ";
									
									String query3="Update location set rcapacity='"+textField.getText()+"' where id='"+textField_4.getText()+"' ";
									
								
									
									
									//
									
									PreparedStatement pst2=con.prepareStatement(query2);
					PreparedStatement pst=con.prepareStatement(query);
					PreparedStatement pst3=con.prepareStatement(query3);
					PreparedStatement pst4=con.prepareStatement(query4);
					PreparedStatement pst1=con.prepareStatement(query1);
					
					pst2.executeUpdate();
					pst.executeUpdate();
					pst3.executeUpdate();
					pst4.executeUpdate();
					pst1.executeUpdate();
					
					}
					
				
				catch(Exception q) {
					q.printStackTrace();
				}
				
				//////////////////
			
			}
		});
		
		
		
		
		
		btnSave.setForeground(Color.WHITE);
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSave.setBackground(Color.BLACK);
		btnSave.setBounds(314, 519, 132, 35);
		frame.getContentPane().add(btnSave);
		
		btnRefresh = new JButton("Refresh");
		
		
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection con = DBConnection.connect();
					
					String query="select * from location ";

					PreparedStatement pst=con.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
				}
				catch(Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		btnRefresh.setForeground(Color.WHITE);
		btnRefresh.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnRefresh.setBackground(Color.GRAY);
		btnRefresh.setBounds(490, 335, 132, 35);
		frame.getContentPane().add(btnRefresh);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(320, 392, 200, 20);
		frame.getContentPane().add(textField_4);
		
		JLabel lblNewLabel_3_2 = new JLabel("ID");
		lblNewLabel_3_2.setForeground(Color.WHITE);
		lblNewLabel_3_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_3_2.setBounds(215, 395, 95, 20);
		frame.getContentPane().add(lblNewLabel_3_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.DARK_GRAY);
		panel_3.setBounds(184, 380, 752, 124);
		frame.getContentPane().add(panel_3);
	}
}
