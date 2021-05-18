package Session_and_TimeAllocation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
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
import Students_and_Tags.Add_Student_Groups;
import Students_and_Tags.Add_Tag;
import Students_and_Tags.Manage_Student_Groups;
import Students_and_Tags.Manage_Tags;
import Working_Days_and_Hours.Add_Workingdays_Hours;
import Working_Days_and_Hours.Genarate_Lecturer_Time_Table;
import Working_Days_and_Hours.Genarate_Student_TimeTable;
import Working_Days_and_Hours.Genarate_TimeLocation;
import Working_Days_and_Hours.Manage_Workingdays_Hours;
import net.proteanit.sql.DbUtils;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JSpinner;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;
import javax.swing.SpinnerNumberModel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import java.awt.SystemColor;

public class Manage_Sessions {

	private JFrame frame;
	private JTable table;

	
	
	/**
	 * Launch the application.
	 */
	PreparedStatement pst=null;
	ResultSet rs = null;
	JComboBox comboBox;
	JComboBox comboBoxLec1_1;
	private JTextField textField_1;
	//JSpinner spinner,spinner_1,spinner_1_1;
	JComboBox comboBoxLec1,comboBox_1,comboBox_2,comboBox_3,comboBoxLec1_3,comboBox_3_1,comboBoxLec1_3_1,comboBoxLec1_3_1_1;
	private JTextField textField;
	private JTextField txtManageSession;
	private JTextField txtTimeTableManagement;
	public static void main(String[] args) {
		DBConnection.connect();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Manage_Sessions window = new Manage_Sessions();
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
	
	public void fillsubjectName() {
		Connection conn = DBConnection.connect();
		try{
			String query="select * from SUbjects";
			pst=conn.prepareStatement(query);
			rs=pst.executeQuery();
			//table.setModel(DbUtils.resultSetToTableModel(rs));
			while(rs.next()) {
				//comboBoxLec1.addItem(rs.getString("LecturerName"));
				String name=rs.getString("SubjectName");
				comboBoxLec1_3.addItem(name);
			}
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
			
		}
	}
	

	
	
	public void fillcombobox() {
		Connection conn = DBConnection.connect();
		try{
			String query="select * from Lecturers";
			pst=conn.prepareStatement(query);
			rs=pst.executeQuery();
			//table.setModel(DbUtils.resultSetToTableModel(rs));
			while(rs.next()) {
				//comboBoxLec1.addItem(rs.getString("LecturerName"));
				String name=rs.getString("LecturerName");
				comboBoxLec1_1.addItem(name);
			}
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
			
		}
	}
	
	
	public void fillcombobox1() {
		Connection conn = DBConnection.connect();
		try{
			String query="select * from Lecturers";
			pst=conn.prepareStatement(query);
			rs=pst.executeQuery();
			//table.setModel(DbUtils.resultSetToTableModel(rs));
			while(rs.next()) {
				//comboBoxLec1.addItem(rs.getString("LecturerName"));
				String name=rs.getString("LecturerName");
				comboBoxLec1.addItem(name);
			}
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
			
		}
	}

	public void fillcombobox2() {
		Connection conn = DBConnection.connect();
		try{
			String query="select * from Lecturers";
			pst=conn.prepareStatement(query);
			rs=pst.executeQuery();
			//table.setModel(DbUtils.resultSetToTableModel(rs));
			while(rs.next()) {
				//comboBoxLec1.addItem(rs.getString("LecturerName"));
				String name=rs.getString("LecturerName");
				comboBox_1.addItem(name);
			}
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
			
		}
	}
	
	
	public Manage_Sessions() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.activeCaption);
		frame.setBounds(30, 30, 1250, 750);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.DARK_GRAY);
		panel_3.setBounds(184, 128, 1042, 500);
		frame.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.DARK_GRAY);
		panel_5.setBounds(10, 10, 1011, 482);
		panel_3.add(panel_5);
		panel_5.setLayout(null);
		
		JSpinner spinner = new JSpinner();
		 spinner.setModel(new SpinnerNumberModel(1, 1, 20, 1));
		spinner.setForeground(Color.BLACK);
		spinner.setFont(new Font("Times New Roman", Font.BOLD, 16));
		spinner.setBackground(Color.LIGHT_GRAY);
		spinner.setBounds(688, 399, 169, 26);
		panel_5.add(spinner);
		
		JButton btnNewButton_13 = new JButton("Search");
		btnNewButton_13.setForeground(Color.WHITE);
		btnNewButton_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				
				

				

				
				
				
				
				Connection conn = DBConnection.connect();
				
				
	            try {
	            	//String tag=comboBox.getSelectedItem().toString();
	            	//String lecname=comboBoxLec1_1.getSelectedItem().toString();
	            	
	            	String sql="Select * from Sessions where Tag='"+comboBox.getSelectedItem().toString()+"' AND Lecturer1='"+comboBoxLec1_1.getSelectedItem().toString()+"'";
					pst=conn.prepareStatement(sql);
					
					rs=pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	            
				
				
			
				
			
				///////////
				
				//GEN-FIRST:event_jButton1ActionPerformed
				/*Connection conn = DBConnection.connect();
		        if(comboBox.getSelectedItem().equals("Tutorial")){
		           try{
		               String sql = "select * from Sessions where Tag='"+comboBox.getSelectedItem()+"' AND Lecturer1='"+textField.getText()+"'";
		               pst=conn.prepareStatement(sql);
		               rs=pst.executeQuery();
		               table.setModel(DbUtils.resultSetToTableModel(rs));
		           }catch(Exception q){
		               JOptionPane.showMessageDialog(null, e);
		           }finally{
		               try{
		                   pst.close();
		                   rs.close();
		               }catch(Exception q){
		                   
		               }
		           }
		        }else if(comboBox.getSelectedIndex()==1){
		              try{
		               String sql = "select * from Sessions where Tag='"+comboBox.getSelectedItem()+"' AND Lecturer1='"+textField.getText()+"'";
		               pst=conn.prepareStatement(sql);
		               rs=pst.executeQuery();
		               table.setModel(DbUtils.resultSetToTableModel(rs));
		           }catch(Exception q){
		               JOptionPane.showMessageDialog(null, e);
		           }finally{
		               try{
		                   pst.close();
		                   rs.close();
		               }catch(Exception q){
		                   
		               }
		           }
		        }else if(comboBox.getSelectedIndex()==2){
		              try{
		               String sql = "select * from Sessions where Tag='"+comboBox.getSelectedItem()+"' AND Lecturer1='"+textField.getText()+"'";
		               pst=conn.prepareStatement(sql);
		               rs=pst.executeQuery();
		               table.setModel(DbUtils.resultSetToTableModel(rs));
		           }catch(Exception q){
		               JOptionPane.showMessageDialog(null, e);
		           }finally{
		               try{
		                   pst.close();
		                   rs.close();
		               }catch(Exception t ){
		                   
		               }
		           }
		        
		        }*/
		       
				
			
				///////////
			}
		});
		btnNewButton_13.setBounds(634, 10, 196, 39);
		panel_5.add(btnNewButton_13);
		btnNewButton_13.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNewButton_13.setBackground(Color.BLACK);
		

		
		
		
		
		
		
		
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 76, 1011, 128);
		panel_5.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				

				

              int selectedRow=table.getSelectedRow();
				
				
			
              textField_1.setText(table.getValueAt(selectedRow,5).toString());
              textField.setText(table.getValueAt(selectedRow,0).toString());
         
              	
              String lecturer1=table.getValueAt(selectedRow, 1).toString();
              	String getlecturername=(String)comboBoxLec1.getSelectedItem();
              	comboBoxLec1.setSelectedItem(lecturer1);
              	
             String lecturer2=table.getValueAt(selectedRow, 2).toString();
              	String getlecturer2=(String)comboBox_1.getSelectedItem();
              	comboBox_1.setSelectedItem(lecturer2);
              
               String tagname=table.getValueAt(selectedRow, 3).toString();
              	String getTag=(String)comboBox_2.getSelectedItem();
              	comboBox_2.setSelectedItem(tagname);
              	
              String studentgroup=table.getValueAt(selectedRow, 4).toString();
               	String getstudengroup=(String)comboBox_3.getSelectedItem();
               	comboBox_3.setSelectedItem(studentgroup);
               	
              String subjectName=table.getValueAt(selectedRow, 9).toString();
               	String getsubjectname=(String)comboBoxLec1_3.getSelectedItem();
               	comboBoxLec1_3.setSelectedItem(subjectName);
               	
           	 String starttime=table.getValueAt(selectedRow, 6).toString();
         	String getstarttime=(String)comboBox_3_1.getSelectedItem();
         	comboBox_3_1.setSelectedItem(starttime);
         	
         	 String endtime=table.getValueAt(selectedRow, 7).toString();
          	String getendtime=(String)comboBoxLec1_3_1.getSelectedItem();
          	comboBoxLec1_3_1.setSelectedItem(endtime);
          	
         	
      	 String day=table.getValueAt(selectedRow, 10).toString();
       	String getday=(String)comboBoxLec1_3_1_1.getSelectedItem();
       	comboBoxLec1_3_1_1.setSelectedItem(day);
       	
       	spinner.setValue((Double)table.getValueAt(selectedRow,8));	
    	 
              
               
               	
               
              	
               	//spinner_1.setValue((Double)table.getValueAt(selectedRow, 6));
               	//spinner_1_1.setValue((String)table.getValueAt(selectedRow, 7).toString());
               	//spinner_3.setValue((Integer)table.getValueAt(selectedRow, 8));
              //comboBoxFacultyName.setSelectedItem(table_1.getValueAt(selectedRow, 2).toString());
				
			
				
			
				
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"ID", "Lecturer 1", "Lecturer 2", "Subject Code", "Subject Name", "Group ID", "Tag", "Start Time", "End Time", "Day"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class, Float.class, String.class, Float.class, String.class, String.class, Float.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane.setViewportView(table);
		
	
		
		
		
		
		
		
		
		
		
		JLabel lblNewLabel_2 = new JLabel("Select Lecturer 1");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_2.setBounds(131, 263, 142, 36);
		panel_5.add(lblNewLabel_2);
		
		 comboBoxLec1 = new JComboBox();
		 comboBoxLec1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		comboBoxLec1.setBackground(Color.LIGHT_GRAY);
		comboBoxLec1.setBounds(283, 263, 168, 29);
		panel_5.add(comboBoxLec1);
		
		JLabel lblNewLabel_3 = new JLabel("Select Lecturer 2\r\n");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_3.setBounds(131, 309, 142, 36);
		panel_5.add(lblNewLabel_3);
		
		 comboBox_1 = new JComboBox();
		 comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Non"}));
		 comboBox_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		comboBox_1.setBackground(Color.LIGHT_GRAY);
		comboBox_1.setBounds(283, 309, 168, 29);
		panel_5.add(comboBox_1);
		
		JLabel lblNewLabel_4 = new JLabel("Select Tag");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_4.setBounds(131, 355, 160, 36);
		panel_5.add(lblNewLabel_4);
		
		 comboBox_2 = new JComboBox();
		 comboBox_2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		 comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"Tutorials", "Labs", "Lecturers"}));
		comboBox_2.setBackground(Color.LIGHT_GRAY);
		comboBox_2.setBounds(283, 355, 168, 29);
		panel_5.add(comboBox_2);
		
		JLabel lblNewLabel_5 = new JLabel("Student Group");
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_5.setBounds(131, 401, 160, 36);
		panel_5.add(lblNewLabel_5);
		
		 comboBox_3 = new JComboBox();
		 comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"12.1", "12.2", "13.1", "13.2", "14.1", "14.2"}));
		 comboBox_3.setFont(new Font("Times New Roman", Font.BOLD, 16));
		comboBox_3.setBackground(Color.LIGHT_GRAY);
		comboBox_3.setBounds(283, 400, 168, 29);
		panel_5.add(comboBox_3);
		
		JLabel lblNewLabel_6 = new JLabel("No.of.Students");
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_6.setBounds(549, 269, 127, 43);
		panel_5.add(lblNewLabel_6);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		textField_1.setColumns(10);
		textField_1.setBackground(Color.LIGHT_GRAY);
		textField_1.setBounds(689, 276, 168, 29);
		panel_5.add(textField_1);
		
		JLabel lblNewLabel_8 = new JLabel("Duration(Hours)");
		lblNewLabel_8.setForeground(Color.WHITE);
		lblNewLabel_8.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_8.setBounds(548, 394, 127, 43);
		panel_5.add(lblNewLabel_8);
		
		
		
		JLabel lblNewLabel_7 = new JLabel("Start Time");
		lblNewLabel_7.setForeground(Color.WHITE);
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_7.setBounds(549, 315, 121, 35);
		panel_5.add(lblNewLabel_7);
		
		JLabel lblNewLabel_9 = new JLabel("End Time");
		lblNewLabel_9.setForeground(Color.WHITE);
		lblNewLabel_9.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_9.setBounds(549, 359, 127, 32);
		panel_5.add(lblNewLabel_9);
		
		 
		
		JLabel lblNewLabel_11 = new JLabel("Subject Name");
		lblNewLabel_11.setForeground(Color.WHITE);
		lblNewLabel_11.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_11.setBounds(131, 441, 142, 29);
		panel_5.add(lblNewLabel_11);
		
		 comboBoxLec1_1 = new JComboBox();
		 comboBoxLec1_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		comboBoxLec1_1.setBackground(Color.LIGHT_GRAY);
		comboBoxLec1_1.setBounds(142, 14, 204, 32);
		panel_5.add(comboBoxLec1_1);
		
		 comboBoxLec1_3 = new JComboBox();
		 comboBoxLec1_3.setFont(new Font("Times New Roman", Font.BOLD, 16));
		comboBoxLec1_3.setBackground(Color.LIGHT_GRAY);
		comboBoxLec1_3.setBounds(283, 442, 168, 29);
		panel_5.add(comboBoxLec1_3);
		
		JLabel lblNewLabel_11_1 = new JLabel("SessionID");
		lblNewLabel_11_1.setForeground(Color.WHITE);
		lblNewLabel_11_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_11_1.setBounds(131, 224, 129, 29);
		panel_5.add(lblNewLabel_11_1);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setFont(new Font("Times New Roman", Font.BOLD, 20));
		textField.setColumns(10);
		textField.setBackground(Color.LIGHT_GRAY);
		textField.setBounds(283, 227, 168, 26);
		panel_5.add(textField);
		
		JButton btnNewButton_12 = new JButton("Refresh");
		btnNewButton_12.setBounds(530, 210, 132, 43);
		panel_5.add(btnNewButton_12);
		btnNewButton_12.setForeground(Color.WHITE);
		btnNewButton_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Manage_Sessions managesessions=new Manage_Sessions();
				managesessions.main(null);
				frame.setVisible(false);
			}
		});
		btnNewButton_12.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNewButton_12.setBackground(Color.BLACK);
		
		 comboBox_3_1 = new JComboBox();
		comboBox_3_1.setModel(new DefaultComboBoxModel(new String[] {"8","9","10","11", "12","13","14", "15","16"}));

		comboBox_3_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		comboBox_3_1.setBackground(Color.LIGHT_GRAY);
		comboBox_3_1.setBounds(689, 314, 168, 32);
		panel_5.add(comboBox_3_1);
		
		 comboBoxLec1_3_1 = new JComboBox();
		comboBoxLec1_3_1.setModel(new DefaultComboBoxModel(new String[] {"9","10","11","12","13","14","15","16","17"}));

		comboBoxLec1_3_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		comboBoxLec1_3_1.setBackground(Color.LIGHT_GRAY);
		comboBoxLec1_3_1.setBounds(689, 358, 168, 29);
		panel_5.add(comboBoxLec1_3_1);
		
		JLabel lblNewLabel_9_1 = new JLabel("Day");
		lblNewLabel_9_1.setForeground(Color.WHITE);
		lblNewLabel_9_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_9_1.setBounds(549, 438, 127, 32);
		panel_5.add(lblNewLabel_9_1);
		
		 comboBoxLec1_3_1_1 = new JComboBox();
		comboBoxLec1_3_1_1.setModel(new DefaultComboBoxModel(new String[]  {"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"}));
		comboBoxLec1_3_1_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		comboBoxLec1_3_1_1.setBackground(Color.LIGHT_GRAY);
		comboBoxLec1_3_1_1.setBounds(689, 437, 168, 29);
		panel_5.add(comboBoxLec1_3_1_1);
		
		JButton btnNewButton_16 = new JButton("Update");
		btnNewButton_16.setForeground(Color.WHITE);
		btnNewButton_16.setBounds(459, 638, 196, 40);
		frame.getContentPane().add(btnNewButton_16);
		btnNewButton_16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				

				try {
					if(comboBoxLec1.getSelectedItem().equals("")||comboBox_1.getSelectedItem().equals("") ||comboBox_2.getSelectedItem().equals("")||comboBox_3.getSelectedItem().equals("")||textField_1.getText().equals("")||spinner.getValue().equals("")||comboBox_3_1.getSelectedItem().equals("")||comboBoxLec1_3_1.getSelectedItem().equals("")||comboBoxLec1_3.getSelectedItem().equals("")||comboBoxLec1_3_1_1.getSelectedItem().equals("")) {
						
						JOptionPane.showMessageDialog(null, "Please fill the form");
						
					}else if(comboBoxLec1.getSelectedItem().toString().equals(comboBox_1.getSelectedItem().toString())) {
						
						JOptionPane.showMessageDialog(null, "Please select a different lecturer for lecturer2(Optional)");
					}else {
					Connection con = DBConnection.connect();
					
					String query="Update Sessions set Lecturer1='"+comboBoxLec1.getSelectedItem()+"',Lecturer2='"+comboBox_1.getSelectedItem()+"',Tag='"+comboBox_2.getSelectedItem()+"',StudentGroup='"+comboBox_3.getSelectedItem()+"',NumberOfStudents='"+textField_1.getText()+"',Duration='"+spinner.getValue()+"',StartTime='"+comboBox_3_1.getSelectedItem()+"',EndTime='"+comboBoxLec1_3_1.getSelectedItem()+"' ,SubjectName='"+comboBoxLec1_3.getSelectedItem()+"',Date='"+comboBoxLec1_3_1_1.getSelectedItem()+"'where SessionID='"+textField.getText()+"' ";//spinner_1
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
		btnNewButton_16.setBackground(Color.BLACK);
		btnNewButton_16.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		 comboBox = new JComboBox();
		comboBox.setFont(new Font("Times New Roman", Font.BOLD, 16));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Tutorials", "Labs", "Lectures"}));
		comboBox.setBounds(415, 13, 183, 32);
		panel_5.add(comboBox);
		comboBox.setBackground(Color.LIGHT_GRAY);
		
		
		
		
		
		
		
		
		
		
		
		
		JButton btnNewButton_17 = new JButton("Delete");
		btnNewButton_17.setForeground(Color.WHITE);
		btnNewButton_17.setBounds(752, 638, 196, 40);
		frame.getContentPane().add(btnNewButton_17);
		btnNewButton_17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {



				
	
				
				try {
					if(textField.getText().equals("")){
						JOptionPane.showMessageDialog(null, "PLEASE SELECT A SESSION");
					}else {
					Connection con = DBConnection.connect();
					
					String query="Delete from Sessions where SessionID='"+textField.getText()+"'";
					PreparedStatement pst=con.prepareStatement(query);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Session Deleted");
					pst.close();
					}
					
				}
				catch(Exception q) {
					q.printStackTrace();
				}
				
	
				
			
				
				
			}
		});
		btnNewButton_17.setBackground(Color.BLACK);
		btnNewButton_17.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.GRAY);
		panel_2.setBounds(0, 648, 174, 38);
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
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.GRAY);
		panel_1.setBounds(0, 469, 174, 194);
		frame.getContentPane().add(panel_1);
		JButton btnManageSession = new JButton("MANAGE SESSION");
		btnManageSession.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Manage_Sessions managesession=new Manage_Sessions();
				Manage_Sessions.main(null);
				frame.setVisible(false);
				
			}
			
		});
		
		
		
		
		btnManageSession.setForeground(Color.RED);
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
		btnUpdateSession.setForeground(Color.WHITE);
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
		panel_1_1.setBounds(0, 113, 174, 168);
		frame.getContentPane().add(panel_1_1);
		
		txtManageSession = new JTextField();
		txtManageSession.setText("                                                                               MANAGE SESSION");
		txtManageSession.setForeground(Color.RED);
		txtManageSession.setFont(new Font("Arial Black", Font.BOLD, 19));
		txtManageSession.setEditable(false);
		txtManageSession.setColumns(10);
		txtManageSession.setBackground(Color.BLACK);
		txtManageSession.setBounds(0, 84, 1236, 29);
		frame.getContentPane().add(txtManageSession);
		
		txtTimeTableManagement = new JTextField();
		txtTimeTableManagement.setText("                                                           Time Table Management System");
		txtTimeTableManagement.setForeground(Color.WHITE);
		txtTimeTableManagement.setFont(new Font("Tahoma", Font.PLAIN, 23));
		txtTimeTableManagement.setEditable(false);
		txtTimeTableManagement.setColumns(10);
		txtTimeTableManagement.setBackground(Color.GRAY);
		txtTimeTableManagement.setBounds(0, 0, 1236, 87);
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
		
		
		
		
		
		
		
		
		
		
		
		
		

		
		
		
		fillcombobox();
		fillcombobox1();
		fillcombobox2();
		
		fillsubjectName();
		
	}
}
