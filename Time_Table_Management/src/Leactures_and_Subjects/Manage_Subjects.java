package Leactures_and_Subjects;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;


import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

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

import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import java.awt.SystemColor;

public class Manage_Subjects {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	JComboBox comboBox,comboBox_2;
	JSpinner spinner_1,spinner_2,spinner_3;
	
	PreparedStatement pst=null;
	ResultSet rs = null;
	private JTable table;
	private JTextField txtManageSubjects;
	private JTextField txtTimeTableManagement;
	public static void main(String[] args) {
		DBConnection.connect();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Manage_Subjects window = new Manage_Subjects();
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
	public Manage_Subjects() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.activeCaption);
		frame.setBounds(100,100, 1000, 735);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.DARK_GRAY);
		panel_3.setBounds(186, 121, 790, 481);
		frame.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		JSpinner spinner = new JSpinner();
		spinner.setForeground(Color.BLACK);
		spinner.setFont(new Font("Times New Roman", Font.BOLD, 16));
		spinner.setModel(new SpinnerNumberModel(1, 1, 20, 1));
		spinner.setBounds(626, 284, 144, 33);
		panel_3.add(spinner);
		
		JLabel lblNewLabel_1 = new JLabel("Offered Year");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_1.setBounds(69, 287, 131, 33);
		panel_3.add(lblNewLabel_1);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021"}));
		comboBox.setFont(new Font("Times New Roman", Font.BOLD, 16));
		comboBox.setBackground(Color.LIGHT_GRAY);
		comboBox.setBounds(211, 287, 191, 33);
		panel_3.add(comboBox);
		
		JLabel lblNewLabel_2 = new JLabel("Offered Semester");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_2.setBounds(69, 339, 156, 33);
		panel_3.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Subject Name");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_3.setBounds(69, 389, 156, 38);
		panel_3.add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.BOLD, 16));
		textField.setColumns(10);
		textField.setBackground(Color.LIGHT_GRAY);
		textField.setBounds(211, 389, 191, 31);
		panel_3.add(textField);
		
		JLabel lblNewLabel_4 = new JLabel("Subject Code");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_4.setBounds(69, 437, 156, 38);
		panel_3.add(lblNewLabel_4);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		textField_1.setColumns(10);
		textField_1.setBackground(Color.LIGHT_GRAY);
		textField_1.setBounds(211, 440, 191, 33);
		panel_3.add(textField_1);
		
		
		
		JLabel lblNewLabel_5 = new JLabel("Number of Lecturer Hours");
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_5.setBounds(426, 284, 193, 38);
		panel_3.add(lblNewLabel_5);
		
		JLabel lblNewLabel_5_1 = new JLabel("Number of Tutorial Hours");
		lblNewLabel_5_1.setForeground(Color.WHITE);
		lblNewLabel_5_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_5_1.setBounds(426, 330, 193, 38);
		panel_3.add(lblNewLabel_5_1);
		
		JLabel lblNewLabel_5_1_1 = new JLabel("Number of Lab Hours");
		lblNewLabel_5_1_1.setForeground(Color.WHITE);
		lblNewLabel_5_1_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_5_1_1.setBounds(426, 382, 193, 38);
		panel_3.add(lblNewLabel_5_1_1);
		
		JLabel lblNewLabel_5_1_1_1 = new JLabel("Number of Evaluation Hours");
		lblNewLabel_5_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_5_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_5_1_1_1.setBounds(426, 437, 193, 38);
		panel_3.add(lblNewLabel_5_1_1_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 28, 760, 168);
		panel_3.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				

                int selectedRow=table.getSelectedRow();
				
				
				//textField.setText(table.getValueAt(selectedRow, 1).toString());
                textField.setText(table.getValueAt(selectedRow, 1).toString());
                textField_1.setText(table.getValueAt(selectedRow,0).toString());
                
              /*  String evaluationhours=table.getValueAt(selectedRow, 2).toString();
                	String getevaluationhours=(String) comboBox_1_1_1_1.getSelectedItem();
                	comboBox_1_1_1_1.setSelectedItem(evaluationhours);*/
                	
                String offeredyear=table.getValueAt(selectedRow, 2).toString();
                	String getofferedyear=(String)comboBox.getSelectedItem();
                	comboBox.setSelectedItem(offeredyear);
                	
               /* String lecturerhours=table.getValueAt(selectedRow, 5).toString();
                	String Getlecturerhours=(String)comboBox_1.getSelectedItem();
                	comboBox_1.setSelectedItem(lecturerhours);
                
                String tutorialhours=table.getValueAt(selectedRow, 6).toString();
                	String Gettutorialhours=(String)comboBox_1_1.getSelectedItem();
                	comboBox_1_1.setSelectedItem(tutorialhours);*/
                	
                String offeredsemester=table.getValueAt(selectedRow, 3).toString();
                 	String getsemester=(String)comboBox_2.getSelectedItem();
                 	comboBox_2.setSelectedItem(offeredsemester);
                 	
                /*String labhours=table.getValueAt(selectedRow, 7).toString();
                 	String getlabhours=(String)comboBox_1_1_1.getSelectedItem();
                 	comboBox_1_1_1.setSelectedItem(labhours);*/
                 	
                 	spinner.setValue((Integer)table.getValueAt(selectedRow, 4));	
                 	spinner_1.setValue((Integer)table.getValueAt(selectedRow, 5));
                 	spinner_2.setValue((Integer)table.getValueAt(selectedRow, 6));
                 	spinner_3.setValue((Integer)table.getValueAt(selectedRow, 7));
                //comboBoxFacultyName.setSelectedItem(table_1.getValueAt(selectedRow, 2).toString());
				
			
				
			}
		});
		scrollPane.setViewportView(table);
		
		 comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"First Semester", "Second Semester"}));
		comboBox_2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		comboBox_2.setBackground(Color.LIGHT_GRAY);
		comboBox_2.setBounds(211, 339, 191, 33);
		panel_3.add(comboBox_2);
		
		 spinner_1 = new JSpinner();
		spinner_1.setModel(new SpinnerNumberModel(1, 1, 20, 1));
		spinner_1.setForeground(Color.BLACK);
		spinner_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		spinner_1.setBounds(626, 333, 144, 31);
		panel_3.add(spinner_1);
		
		 spinner_2 = new JSpinner();
		spinner_2.setModel(new SpinnerNumberModel(1, 1, 20, 1));
		spinner_2.setForeground(Color.BLACK);
		spinner_2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		spinner_2.setBounds(626, 382, 144, 33);
		panel_3.add(spinner_2);
		
		 spinner_3 = new JSpinner();
		spinner_3.setModel(new SpinnerNumberModel(1, 1, 20, 1));
		spinner_3.setForeground(Color.BLACK);
		spinner_3.setFont(new Font("Times New Roman", Font.BOLD, 16));
		spinner_3.setBounds(626, 434, 144, 33);
		panel_3.add(spinner_3);
		
		JButton btnNewButton_12 = new JButton("Refresh");
		btnNewButton_12.setForeground(Color.WHITE);
		btnNewButton_12.setBounds(295, 218, 181, 33);
		panel_3.add(btnNewButton_12);
		btnNewButton_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				
				
				
				
				Connection conn = DBConnection.connect();
				
				
	            try {
	            	String sql="Select * from SUbjects ";
					pst=conn.prepareStatement(sql);
					
					rs=pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	            
				
				
			
				
			}
		});
		btnNewButton_12.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNewButton_12.setBackground(Color.BLACK);
		
		JButton btnNewButton_13 = new JButton("Update");
		btnNewButton_13.setForeground(Color.WHITE);
		btnNewButton_13.setBounds(491, 621, 178, 40);
		frame.getContentPane().add(btnNewButton_13);
		btnNewButton_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//SubjectCode"	INTEGER NOT NULL,textField_1
				//"SubjectName"	TEXT NOT NULL,textField
				//"OfferedYear"	TEXT NOT NULL,comboBox
				//"OfferedSemester,comboBox_2

				try {
					if(comboBox.getSelectedItem().equals("")||textField.getText().equals("")||textField_1.getText().equals("")||comboBox_2.getSelectedItem().equals("")||spinner.getValue().equals("")||spinner_3.getValue().equals("")||spinner_2.getValue().equals("")||spinner_1.getValue().equals("")){
						JOptionPane.showMessageDialog(null, "Please fill the form ");
					}else if(!(textField.getText().trim().matches("^[A-Za-z]+"))){
						JOptionPane.showMessageDialog(null, "Invalid subject name");
						
					}else {
					Connection con = DBConnection.connect();
					
					String query="Update SUbjects   set OfferedYear='"+comboBox.getSelectedItem()+"',OfferedSemester='"+comboBox_2.getSelectedItem()+"',SubjectName='"+textField.getText()+"',SubjectCode='"+textField_1.getText()+"', LecturerHours='"+spinner.getValue()+"',TutorialHours='"+spinner_1.getValue()+"',LabHours='"+spinner_2.getValue()+"',EvaluationHours='"+spinner_3.getValue()+"'  where SubjectCode='"+textField_1.getText()+"' ";
					PreparedStatement pst=con.prepareStatement(query);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Data Updated");
					pst.close();
					}
					
				}
				catch(Exception q) {
					q.printStackTrace();
					
				}
				
			}
		});
		btnNewButton_13.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNewButton_13.setBackground(Color.BLACK);
		
		JButton btnNewButton_14 = new JButton("Clear");
		btnNewButton_14.setForeground(Color.WHITE);
		btnNewButton_14.setBounds(268, 621, 178, 40);
		frame.getContentPane().add(btnNewButton_14);
		btnNewButton_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				textField.setText(null);
				textField_1.setText(null);
				comboBox.setSelectedItem(null);
				comboBox_2.setSelectedItem(null);
				spinner.setValue(null);
				spinner_1.setValue(null);
				spinner_2.setValue(null);
				spinner_3.setValue(null);
				
			}
		});
		btnNewButton_14.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNewButton_14.setBackground(Color.BLACK);
		
		JButton btnNewButton_15 = new JButton("Delete");
		btnNewButton_15.setForeground(Color.WHITE);
		btnNewButton_15.setBounds(706, 621, 178, 40);
		frame.getContentPane().add(btnNewButton_15);
		btnNewButton_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
	
				
				try {
					if(textField_1.getText().equals("")){
						JOptionPane.showMessageDialog(null, "PLEASE SELECT A SUBJECT");
					}else {
					Connection con = DBConnection.connect();
					
					String query="Delete from SUbjects where SubjectCode='"+textField_1.getText()+"'";
					PreparedStatement pst=con.prepareStatement(query);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Subject Deleted");
					pst.close();
					}
					
				}
				catch(Exception q) {
					q.printStackTrace();
				}
				
	
				
			}
		});
		btnNewButton_15.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNewButton_15.setBackground(Color.BLACK);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.GRAY);
		panel_1.setBounds(0, 467, 174, 166);
		frame.getContentPane().add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.GRAY);
		panel_2.setBounds(0, 631, 174, 46);
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
		
		JButton btnManageSession = new JButton("MANAGE SESSION");
		btnManageSession.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Manage_Sessions managesession=new Manage_Sessions();
				Manage_Sessions.main(null);
				frame.setVisible(false);
				
			}
			
		});
		
		
		
		
		btnManageSession.setForeground(Color.WHITE);
		btnManageSession.setFont(new Font("Arial Black", Font.BOLD, 11));
		btnManageSession.setBackground(Color.BLACK);
		btnManageSession.setBounds(0, 435, 174, 35);
		frame.getContentPane().add(btnManageSession);
		
		JButton btnManageLsession = new JButton("ADD SESSION");
		btnManageLsession.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Add_Session addsession=new Add_Session();
				Add_Session.main(null);
				frame.setVisible(false);
				
			}
			
		});
		
		btnManageLsession.setForeground(Color.WHITE);
		btnManageLsession.setFont(new Font("Arial Black", Font.BOLD, 11));
		btnManageLsession.setBackground(Color.BLACK);
		btnManageLsession.setBounds(0, 402, 174, 35);
		frame.getContentPane().add(btnManageLsession);
		
		JButton btnUpdateSession = new JButton("MANAGE SUBJECTS");
		btnUpdateSession.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Manage_Subjects managesubjects=new Manage_Subjects();
				Manage_Subjects.main(null);
				frame.setVisible(false);
				
			}
			
		});
		btnUpdateSession.setForeground(Color.RED);
		btnUpdateSession.setFont(new Font("Arial Black", Font.BOLD, 11));
		btnUpdateSession.setBackground(Color.BLACK);
		btnUpdateSession.setBounds(0, 375, 174, 29);
		frame.getContentPane().add(btnUpdateSession);
		
		JButton btnAddSession = new JButton("ADD SUBJECT");
		btnAddSession.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Add_Subjects addsubjects=new Add_Subjects();
				Add_Subjects.main(null);
				frame.setVisible(false);
				
			}
			
		});
		btnAddSession.setForeground(Color.WHITE);
		btnAddSession.setFont(new Font("Arial Black", Font.BOLD, 11));
		btnAddSession.setBackground(Color.BLACK);
		btnAddSession.setBounds(0, 341, 174, 35);
		frame.getContentPane().add(btnAddSession);
		
		JButton btnManageLecturer = new JButton("MANAGE LECTURERS");
		btnManageLecturer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Manage_Lecturer managelecture=new Manage_Lecturer();
				Manage_Lecturer.main(null);
				frame.setVisible(false);
				
			}
			
		});
		btnManageLecturer.setForeground(Color.WHITE);
		btnManageLecturer.setFont(new Font("Arial Black", Font.BOLD, 11));
		btnManageLecturer.setBackground(Color.BLACK);
		btnManageLecturer.setBounds(0, 315, 174, 29);
		frame.getContentPane().add(btnManageLecturer);
		
		JButton btnAddLecturer = new JButton("ADD LECTURER");
		btnAddLecturer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Add_Lecturer addlecture=new Add_Lecturer();
				Add_Lecturer.main(null);
				frame.setVisible(false);
				
			}
			
		});
		btnAddLecturer.setForeground(Color.WHITE);
		btnAddLecturer.setFont(new Font("Arial Black", Font.BOLD, 11));
		btnAddLecturer.setBackground(Color.BLACK);
		btnAddLecturer.setBounds(0, 281, 174, 35);
		frame.getContentPane().add(btnAddLecturer);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(Color.GRAY);
		panel_1_1.setBounds(0, 110, 174, 172);
		frame.getContentPane().add(panel_1_1);
		
		txtManageSubjects = new JTextField();
		txtManageSubjects.setText("                                                                   MANAGE SUBJECTS");
		txtManageSubjects.setForeground(Color.RED);
		txtManageSubjects.setFont(new Font("Arial Black", Font.BOLD, 19));
		txtManageSubjects.setEditable(false);
		txtManageSubjects.setColumns(10);
		txtManageSubjects.setBackground(Color.BLACK);
		txtManageSubjects.setBounds(0, 84, 986, 29);
		frame.getContentPane().add(txtManageSubjects);
		
		txtTimeTableManagement = new JTextField();
		txtTimeTableManagement.setText("                                                   Time Table Management System");
		txtTimeTableManagement.setForeground(Color.WHITE);
		txtTimeTableManagement.setFont(new Font("Tahoma", Font.PLAIN, 23));
		txtTimeTableManagement.setEditable(false);
		txtTimeTableManagement.setColumns(10);
		txtTimeTableManagement.setBackground(Color.GRAY);
		txtTimeTableManagement.setBounds(0, 0, 986, 87);
		frame.getContentPane().add(txtTimeTableManagement);
		
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
		
		
		
		
	}
}
