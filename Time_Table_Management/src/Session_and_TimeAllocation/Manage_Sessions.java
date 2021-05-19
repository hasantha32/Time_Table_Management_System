
package Session_and_TimeAllocation;

import java.awt.Color;


import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;



import net.proteanit.sql.DbUtils;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JSpinner;
import javax.swing.JSeparator;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

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

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JScrollBar;
import javax.swing.DefaultComboBoxModel;
import javax.swing.UIManager;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.border.LineBorder;

public class Manage_Sessions {
	private JFrame frame;
	private JFrame ManageSesFrm;
	
	private JTable table;
	private JComboBox lecr1;
	private JComboBox lecr2;
	private JComboBox sbj;
	private JComboBox tg;
	private JComboBox grpId;
	private JTextField cod;
	private JTextField txtSid;
	private JTextField textField;
	
	
	
	
	public void refreshtable() {

		try {

			Connection con = DBConnection.connect();
String query="select sessionID As SID, lec1 As Lecturer1,lec2 As Lecturer2,subCode As SubCode,subName As SubName,tag As Tag,studentGroup As GroupID,NoOfStudents As Students,duration As Duration,sessionSignature As SessionSignature from session ";
			
			
			PreparedStatement pst=con.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
			TableColumnModel columnModel = table.getColumnModel();
			columnModel.getColumn(0).setPreferredWidth(1);
			columnModel.getColumn(1).setPreferredWidth(80);
			columnModel.getColumn(2).setPreferredWidth(80);
			columnModel.getColumn(3).setPreferredWidth(20);
			columnModel.getColumn(4).setPreferredWidth(40);
			columnModel.getColumn(5).setPreferredWidth(30);
			columnModel.getColumn(6).setPreferredWidth(50);
			columnModel.getColumn(7).setPreferredWidth(1);
			columnModel.getColumn(8).setPreferredWidth(1);
			columnModel.getColumn(9).setPreferredWidth(300);

		}
		catch(Exception e) {
			e.printStackTrace();
		}


	}

	//load data to dropdown lec1
	  public  void  loadLecturer1(){ 
		  try {

				Connection con = DBConnection.connect();

				String query="select * from Lecturers ";
				PreparedStatement pst=con.prepareStatement(query);
				ResultSet rs=pst.executeQuery();
				
				while(rs.next())
				{
					String name =rs.getString("LecturerName");
					lecr1.addItem(name);
					 
				}

				con.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
	
}
		//load data to dropdown lec2
	  public  void  loadLecturer2(){ 
		  try {

				Connection con = DBConnection.connect();

				String query="select * from Lecturers ";
				PreparedStatement pst=con.prepareStatement(query);
				ResultSet rs=pst.executeQuery();
				
				while(rs.next())
				{
					String name =rs.getString("LecturerName");
					lecr2.addItem(name);
					 
				}

				con.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}

}
		//load data to dropdown subject name
	  public  void  loadSubjectName(){ 
		  try {

				Connection con = DBConnection.connect();

				String query="select * from SUbjects ";
				PreparedStatement pst=con.prepareStatement(query);
				ResultSet rs=pst.executeQuery();
				
				while(rs.next())
				{
					String name =rs.getString("SubjectName");
					sbj.addItem(name);
					 
				}

				con.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}

}
	//load data to dropdown tag
	  public  void  loadTag(){ 
		  try {

				Connection con = DBConnection.connect();

				String query="select * from Tag ";
				PreparedStatement pst=con.prepareStatement(query);
				ResultSet rs=pst.executeQuery();
				
				while(rs.next())
				{
					String name =rs.getString("relatedtag");
					tg.addItem(name);
					 
				}

				con.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}

}
	//load data to dropdown group id
	  public  void  loadGroup(){ 
		  try {

				Connection con = DBConnection.connect();

				String query="select * from Student_Groups ";
				PreparedStatement pst=con.prepareStatement(query);
				ResultSet rs=pst.executeQuery();
				
				while(rs.next())
				{
					String name =rs.getString("G_ID");
					grpId.addItem(name);
					 
				}

				con.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}

}
	//load data to dropdown Subgroup id
	  public  void  loadSubGroup(){ 
		  try {

				Connection con = DBConnection.connect();

				String query="select * from Student_Groups ";
				PreparedStatement pst=con.prepareStatement(query);
				ResultSet rs=pst.executeQuery();
				
				while(rs.next())
				{
					String name =rs.getString("Sub_G_ID");
					grpId.addItem(name);
					 
				}

				con.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}

}
	
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Manage_Sessions window = new Manage_Sessions();
					window.ManageSesFrm.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Manage_Sessions() {
		initialize();
	}

	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		ManageSesFrm = new JFrame();
		ManageSesFrm.setBounds(0, 0, 1350, 700);
		ManageSesFrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		ManageSesFrm.getContentPane().setBackground(SystemColor.activeCaption);
		ManageSesFrm.setBackground(Color.YELLOW);
		ManageSesFrm.setTitle("Manage Sessions");
		ManageSesFrm.setSize(1350, 715);
		
		//ManageSesFrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ManageSesFrm.getContentPane().setLayout(null);
	
		ManageSesFrm.setLocationRelativeTo(null);
		ManageSesFrm.setVisible(true);

		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(Color.DARK_GRAY);
		panel_2.setBounds(222, 317, 1075, 361);
		ManageSesFrm.getContentPane().add(panel_2);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 10, 1055, 88);
		panel_2.add(scrollPane_2);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane_2.setViewportView(scrollPane);

		table = new JTable();
		table.setBorder(UIManager.getBorder("TableHeader.cellBorder"));
		table.setBackground(SystemColor.window);
		
		//table header
		JTableHeader h = table.getTableHeader();
		h.setBackground(new Color(	153, 153, 153));
		h.setForeground(Color.WHITE);
		h.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		h.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		table.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 11));
		table.setModel(new DefaultTableModel( new Object[][] { }, new String[] { }
				));
		
		//display details in a table
		scrollPane.setViewportView(table);
		try {
			Connection con = DBConnection.connect();

			//String query="select * from session ";
			String query="select sessionID As SID, lec1 As Lecturer1,lec2 As Lecturer2,subCode As SubCode,subName As SubName,tag As Tag,studentGroup As GroupID,NoOfStudents As Students,duration As Duration,sessionSignature As SessionSignature from session ";
			
			
			PreparedStatement pst=con.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
			TableColumnModel columnModel = table.getColumnModel();
			columnModel.getColumn(0).setPreferredWidth(1);
			columnModel.getColumn(1).setPreferredWidth(80);
			columnModel.getColumn(2).setPreferredWidth(80);
			columnModel.getColumn(3).setPreferredWidth(20);
			columnModel.getColumn(4).setPreferredWidth(40);
			columnModel.getColumn(5).setPreferredWidth(30);
			columnModel.getColumn(6).setPreferredWidth(50);
			columnModel.getColumn(7).setPreferredWidth(1);
			columnModel.getColumn(8).setPreferredWidth(1);
			columnModel.getColumn(9).setPreferredWidth(300);

		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		//new
		JSpinner noStud = new JSpinner();
		JSpinner duration = new JSpinner();
		JTextArea sign = new JTextArea();
		sign.setEditable(false);
		sign.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 12));
		
		/*
		 * JTextArea sign = new JTextArea();
		sign.setEditable(false);
		sign.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 12));
		
		 */
		//display selected row
		table.addMouseListener(new MouseAdapter() {

			@Override public void mouseClicked(MouseEvent arg0) {

				int i = table.getSelectedRow(); TableModel model = table.getModel();

				txtSid.setText(model.getValueAt(i, 0).toString());
				
				String combolevel1 = table.getValueAt(i, 1).toString();
				for(int j=0;j<lecr1.getItemCount();j++) {

					if(lecr1.getItemAt(j).toString().equalsIgnoreCase(combolevel1)) {
						lecr1.setSelectedIndex(j); } }

				String combolevel2 = table.getValueAt(i, 2).toString(); for(int j=0
						;j<lecr2.getItemCount();j++) {

					if(lecr2.getItemAt(j).toString().equalsIgnoreCase(combolevel2)) {
						lecr2.setSelectedIndex(j); } }
				
				cod.setText(model.getValueAt(i, 3).toString());
				String combolevel3 = table.getValueAt(i, 4).toString(); for(int j=0
						;j<sbj.getItemCount();j++) {

					if(sbj.getItemAt(j).toString().equalsIgnoreCase(combolevel3)) {
						sbj.setSelectedIndex(j); } } 
			
				String combolevel4 = table.getValueAt(i, 5).toString(); for(int j=0
						;j<tg.getItemCount();j++) {

					if(tg.getItemAt(j).toString().equalsIgnoreCase(combolevel4)) {
						tg.setSelectedIndex(j); } } 
				
				
				String combolevel5 = table.getValueAt(i, 6).toString(); for(int j=0
						;j<grpId.getItemCount();j++) {

					if(grpId.getItemAt(j).toString().equalsIgnoreCase(combolevel5)) {
						grpId.setSelectedIndex(j); } } 
				

				noStud.setValue((Integer)table.getValueAt(i,7));
				duration.setValue((Integer)table.getValueAt(i,8));
				
                sign.setText(model.getValueAt(i, 9).toString());
                
                //sign.setText(model.getValueAt(i, 9).toString());

			} });
		
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel_3.setBackground(Color.DARK_GRAY);
		panel_3.setBounds(10, 96, 1055, 265);
		panel_2.add(panel_3);

		JButton btnClear = new JButton("CLEAR");
		btnClear.setToolTipText("Click button to clear");
		btnClear.setForeground(Color.WHITE);
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnClear.setEnabled(true);
		btnClear.setBackground(Color.BLACK);
		btnClear.setBounds(538, 227, 141, 31);
		panel_3.add(btnClear);

		JButton btnDel = new JButton("DELETE");
		btnDel.setToolTipText("Click button to delete session");
		btnDel.setForeground(Color.WHITE);
		btnDel.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDel.setEnabled(true);
		btnDel.setBackground(Color.BLACK);
		btnDel.setBounds(359, 227, 141, 31);
		panel_3.add(btnDel);

		JButton btnEdit = new JButton("UPDATE");
		btnEdit.setToolTipText("Click button to edit session");
		
		btnEdit.setForeground(Color.WHITE);
		btnEdit.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnEdit.setEnabled(true);
		btnEdit.setBackground(Color.BLACK);
		btnEdit.setBounds(177, 227, 141, 31);
		panel_3.add(btnEdit);

		 lecr1 = new JComboBox();
		 lecr1.setModel(new DefaultComboBoxModel(new String[] {"Select Lecturer 1 "}));
		lecr1.setBounds(255, 50, 245, 27);
		panel_3.add(lecr1);

		JLabel lblLecturer = new JLabel("Lecturer 1");
		lblLecturer.setForeground(Color.WHITE);
		lblLecturer.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblLecturer.setBounds(102, 50, 96, 23);
		panel_3.add(lblLecturer);

		 sbj = new JComboBox();
		 sbj.setModel(new DefaultComboBoxModel(new String[] {" Select Subject "}));
		 sbj.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		try {
					String subject = sbj.getSelectedItem().toString();
					Connection con = DBConnection.connect();
					String query = "select SubjectCode from subjects where SubjectName = '" + subject + "'";
					PreparedStatement pst = con.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					
					while (rs.next()) {

						String name = rs.getString("SubjectCode");
						cod.setText(name);
						
					}
					con.close();
				} catch (Exception e1) {
					
				}
		 		
		 	}
		 });
		sbj.setBounds(255, 122, 245, 27);
		panel_3.add(sbj);

		JLabel label_3 = new JLabel("Subject Name");
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_3.setBounds(102, 123, 125, 23);
		panel_3.add(label_3);

		JLabel label_4 = new JLabel("Selected Subject Code");
		label_4.setForeground(Color.WHITE);
		label_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_4.setBounds(102, 160, 149, 23);
		panel_3.add(label_4);

		JLabel label_5 = new JLabel("Tag");
		label_5.setForeground(Color.WHITE);
		label_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_5.setBounds(102, 193, 132, 23);
		panel_3.add(label_5);

		 tg = new JComboBox();
		 tg.setModel(new DefaultComboBoxModel(new String[] {"Select Tag"}));
		tg.setBounds(255, 192, 245, 27);
		panel_3.add(tg);

		JLabel label_6 = new JLabel("Group/Sub Group ID");
		label_6.setForeground(Color.WHITE);
		label_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_6.setBounds(632, 50, 150, 23);
		panel_3.add(label_6);

		 grpId = new JComboBox();
		 grpId.setModel(new DefaultComboBoxModel(new String[] {"Select Group/Sub Group ID"}));
		grpId.setBounds(792, 49, 245, 27);
		panel_3.add(grpId);

		JLabel label_7 = new JLabel("No Of Students");
		label_7.setForeground(Color.WHITE);
		label_7.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_7.setBounds(632, 86, 108, 23);
		panel_3.add(label_7);

		
		noStud.setFont(new Font("Tahoma", Font.BOLD, 12));
		noStud.setBounds(792, 86, 245, 27);
		panel_3.add(noStud);

		JLabel label_8 = new JLabel("Duration(hrs)");
		label_8.setForeground(Color.WHITE);
		label_8.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_8.setBounds(632, 123, 108, 23);
		panel_3.add(label_8);

		
		duration.setFont(new Font("Tahoma", Font.BOLD, 12));
		duration.setBounds(792, 124, 245, 27);
		panel_3.add(duration);
		
		JLabel lblLecturer_1 = new JLabel("Lecturer 2");
		lblLecturer_1.setForeground(Color.WHITE);
		lblLecturer_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblLecturer_1.setBounds(102, 87, 96, 23);
		panel_3.add(lblLecturer_1);
		
		 lecr2 = new JComboBox();
		 lecr2.setModel(new DefaultComboBoxModel(new String[] {"-"}));
		lecr2.setBounds(255, 86, 245, 27);
		panel_3.add(lecr2);
		
		JLabel label_1 = new JLabel("Session Signature");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_1.setBounds(632, 159, 126, 23);
		panel_3.add(label_1);
		
		JButton btnGenerateSessionSign = new JButton("GENERATE SESSION SIGNATURE");
		btnGenerateSessionSign.setToolTipText("Click button to generate session signature");
		
		btnGenerateSessionSign.setForeground(Color.WHITE);
		btnGenerateSessionSign.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnGenerateSessionSign.setBackground(Color.GRAY);
		btnGenerateSessionSign.setBounds(714, 227, 323, 33);
		panel_3.add(btnGenerateSessionSign);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(792, 161, 245, 55);
		panel_3.add(scrollPane_1);
		
		
		scrollPane_1.setViewportView(sign);
		//scrollPane_1.setViewportView(sign);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollPane_1.setRowHeaderView(scrollBar);
		
		cod = new JTextField();
		cod.setBackground(Color.WHITE);
		cod.setEditable(false);
		cod.setFont(new Font("Tahoma", Font.BOLD, 11));
		cod.setBounds(255, 157, 245, 27);
		panel_3.add(cod);
		cod.setColumns(10);
		
		txtSid = new JTextField();
		txtSid.setBounds(55, 318, -4, 6);
		panel_3.add(txtSid);
		txtSid.setColumns(10);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setForeground(Color.BLACK);
		menuBar.setBorderPainted(false);
		menuBar.setBorder(null);
		menuBar.setBackground(Color.BLACK);
		menuBar.setBounds(0, 0, 1331, 27);
		ManageSesFrm.getContentPane().add(menuBar);
		
		
		
		
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
		
	
		
		
		
		
		
		textField = new JTextField();
		textField.setText("                                                                       Time Table Management System");
		textField.setForeground(Color.WHITE);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 23));
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBackground(Color.GRAY);
		textField.setBounds(0, 28, 1334, 35);
		ManageSesFrm.getContentPane().add(textField);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setForeground(Color.RED);
		panel_5.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		panel_5.setBackground(Color.BLACK);
		panel_5.setBounds(-3, 57, 1334, 42);
		ManageSesFrm.getContentPane().add(panel_5);
		
		JLabel lblManageSessions = new JLabel("MANAGE SESSIONS");
		lblManageSessions.setHorizontalAlignment(SwingConstants.CENTER);
		lblManageSessions.setForeground(Color.RED);
		lblManageSessions.setFont(new Font("Arial Black", Font.BOLD, 19));
		lblManageSessions.setBounds(522, 10, 278, 31);
		panel_5.add(lblManageSessions);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(Color.GRAY);
		panel_1_1.setBounds(0, 133, 174, 157);
		ManageSesFrm.getContentPane().add(panel_1_1);
		
		JButton btnAddLecturer = new JButton("ADD LECTURER");
		
		btnAddLecturer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Add_Lecturer addlecturer=new Add_Lecturer();
				Add_Lecturer.main(null);
				frame.setVisible(false);
				
			}
			
		});
		
		btnAddLecturer.setForeground(Color.WHITE);
		btnAddLecturer.setFont(new Font("Arial Black", Font.BOLD, 11));
		btnAddLecturer.setBackground(Color.BLACK);
		btnAddLecturer.setBounds(0, 289, 174, 35);
		ManageSesFrm.getContentPane().add(btnAddLecturer);
		
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
		btnManageLecturer.setBounds(0, 323, 174, 29);
		ManageSesFrm.getContentPane().add(btnManageLecturer);
		
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
		btnAddSession.setBounds(0, 349, 174, 35);
		ManageSesFrm.getContentPane().add(btnAddSession);
		
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
		btnUpdateSession.setBounds(0, 383, 174, 29);
		ManageSesFrm.getContentPane().add(btnUpdateSession);
		
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
		btnManageLsession.setBounds(0, 410, 174, 35);
		ManageSesFrm.getContentPane().add(btnManageLsession);
		
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
		btnManageSession.setBounds(0, 443, 174, 35);
		ManageSesFrm.getContentPane().add(btnManageSession);
		
		JButton btnManageSession_1 = new JButton("SEARCH SESSION");
		btnManageSession_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Search_Sessions searchsession=new Search_Sessions();
				Search_Sessions.main(null);
				frame.setVisible(false);
				
			}
			
		});
		
		btnManageSession_1.setForeground(Color.WHITE);
		btnManageSession_1.setFont(new Font("Arial Black", Font.BOLD, 11));
		btnManageSession_1.setBackground(Color.BLACK);
		btnManageSession_1.setBounds(0, 477, 174, 35);
		ManageSesFrm.getContentPane().add(btnManageSession_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.GRAY);
		panel_1.setBounds(0, 510, 174, 118);
		ManageSesFrm.getContentPane().add(panel_1);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBackground(Color.GRAY);
		panel_2_1.setBounds(0, 624, 174, 54);
		ManageSesFrm.getContentPane().add(panel_2_1);
		
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
		panel_2_1.add(btnDelete);
		
		JPanel panel_3_1 = new JPanel();
		panel_3_1.setLayout(null);
		panel_3_1.setBackground(Color.DARK_GRAY);
		panel_3_1.setBounds(222, 112, 1075, 202);
		ManageSesFrm.getContentPane().add(panel_3_1);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setViewportBorder(new LineBorder(new Color(0, 0, 0)));
		scrollPane_3.setBounds(10, 61, 1045, 105);
		panel_3_1.add(scrollPane_3);
		
		JComboBox lecbox = new JComboBox();
		lecbox.setForeground(Color.DARK_GRAY);
		lecbox.setFont(UIManager.getFont("Spinner.font"));
		lecbox.setBackground(Color.WHITE);
		lecbox.setBounds(50, 24, 223, 27);
		panel_3_1.add(lecbox);
		
		JLabel label_1_1 = new JLabel("Search by Lecturer :");
		label_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1_1.setForeground(Color.WHITE);
		label_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_1_1.setBounds(78, -12, 180, 36);
		panel_3_1.add(label_1_1);
		
		JLabel label_2 = new JLabel("Search by Group/Sub Group :");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_2.setBounds(444, -12, 215, 36);
		panel_3_1.add(label_2);
		
		JLabel label_3_1 = new JLabel("Search by Subject :");
		label_3_1.setForeground(Color.WHITE);
		label_3_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_3_1.setBounds(850, -12, 215, 36);
		panel_3_1.add(label_3_1);
		
		JComboBox groupBox = new JComboBox();
		groupBox.setForeground(Color.DARK_GRAY);
		groupBox.setFont(UIManager.getFont("Spinner.font"));
		groupBox.setBackground(Color.WHITE);
		groupBox.setBounds(438, 24, 223, 27);
		panel_3_1.add(groupBox);
		
		JComboBox subjBox = new JComboBox();
		subjBox.setForeground(Color.DARK_GRAY);
		subjBox.setFont(UIManager.getFont("Spinner.font"));
		subjBox.setBackground(Color.WHITE);
		subjBox.setBounds(812, 24, 223, 25);
		panel_3_1.add(subjBox);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.DARK_GRAY);
		panel_4.setBounds(10, 1, 1045, 161);
		panel_3_1.add(panel_4);
		
		JButton btnNewButton = new JButton("CLEAR");
		btnNewButton.setToolTipText("Click button to clear search bar");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 13));
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setBounds(444, 172, 140, 27);
		panel_3_1.add(btnNewButton);
		
		
		//generate session signature
		btnGenerateSessionSign.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String lecregx = "-";
				String lecrs = "----------Select Lecturer 1 ----------";
				String namer = "----------Select Subject----------";
				String tagr = "------------Select Tag ------------";
				String grpidr = "--------Select Group/Sub Group ID--------";
				
				if(lecr1.getSelectedItem().toString().equals(lecrs)||sbj.getSelectedItem().toString().equals(namer)|| tg.getSelectedItem().toString().equals(tagr)|| grpId.getSelectedItem().toString().equals(grpidr)|| noStud.getValue().equals(0)|| duration.getValue().equals(0))
				{
					JOptionPane.showMessageDialog(null, "       Please Enter Values","Alert",JOptionPane.WARNING_MESSAGE);
	
					
				}else {
				if(lecr1.getSelectedItem().toString().matches(lecregx ));
				{
					sign.setText(lecr1.getSelectedItem().toString()+ " - "+ cod.getText()+" - "+ sbj.getSelectedItem().toString()
							+" - "+tg.getSelectedItem().toString()+" - "+grpId.getSelectedItem().toString()+" - "+noStud.getValue().toString()+" - "+
							duration.getValue().toString());
					
				}
				
				if(!(lecr2.getSelectedItem().toString().matches(lecregx)))
				{
					
					sign.setText(lecr1.getSelectedItem().toString()+ " - "+ lecr2.getSelectedItem().toString()+ " - "+cod.getText()+" - "+ sbj.getSelectedItem().toString()
							+" - "+tg.getSelectedItem().toString()+" - "+grpId.getSelectedItem().toString()+" - "+noStud.getValue().toString()+" - "+
							duration.getValue().toString());
				
				}
				
				JLabel label8 = new JLabel("Session Signature Updated Successfully");
				label8.setHorizontalAlignment(SwingConstants.CENTER);
				JOptionPane.showMessageDialog(null, label8);
			}
			}
		});
		
		
		//Update Session details
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try { 


					Connection con = DBConnection.connect(); 

					String query="Update session set lec1 = '"+lecr1.getSelectedItem().toString()+"' , lec2 = '"+lecr2.getSelectedItem().toString()+"' ,subCode = '"+cod.getText()+"',"
							+ "subName = '"+sbj.getSelectedItem().toString()+"', tag = '"+tg.getSelectedItem().toString()+"',studentGroup = '"+grpId.getSelectedItem().toString()+"',NoOfStudents = '"+noStud.getValue()+"',duration='"+duration.getValue()+"',"
									+ "sessionSignature = '"+sign.getText()+"' where sessionID = '"+txtSid.getText()+"' ";

					PreparedStatement pst=con.prepareStatement(query);

					pst.executeUpdate();
					refreshtable();
					JLabel label = new JLabel("Session Updated Successfully");
					label.setHorizontalAlignment(SwingConstants.CENTER);
					JOptionPane.showMessageDialog(null, label);
					

					
					//JOptionPane.showMessageDialog(null, "Data Updated"); pst.close();

				} catch(Exception ea) {
					ea.printStackTrace(); 
				}
				
			}
		});
		
		
		//delete session
		btnDel.addActionListener(new ActionListener() {

			@Override public void actionPerformed(ActionEvent arg0) { 
				// TOD Auto-generated method stub


				try { 
					Connection con = DBConnection.connect();
					String  query="Delete from session where sessionID='"+txtSid.getText()+"'";
					PreparedStatement pst=con.prepareStatement(query); 
					pst.execute();
					refreshtable();
					JOptionPane.showMessageDialog(null, "       Session Deleted Successfully","Message",JOptionPane.INFORMATION_MESSAGE);
					pst.close();
					cod.setText("");
					lecr1.setSelectedIndex(0);
					lecr2.setSelectedIndex(0);
					sbj.setSelectedIndex(0);
					tg.setSelectedIndex(0);
					grpId.setSelectedIndex(0);
					sign.setText("");
					noStud.setValue(0);
					duration.setValue(0);
					
					//table.revalidate();

				} catch(Exception en) { en.printStackTrace();

				}

			} });
		
		//clear button
				btnClear.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						cod.setText("");
						lecr1.setSelectedIndex(0);
						lecr2.setSelectedIndex(0);
						sbj.setSelectedIndex(0);
						tg.setSelectedIndex(0);
						grpId.setSelectedIndex(0);
						//sign.setText("");
						sign.setText("");
						noStud.setValue(0);
						duration.setValue(0);
						
					}
				});
		
		
		//load data to dropdown lec1
		loadLecturer1();
		//load data to dropdown lec2
		loadLecturer2();
		//load data to dropdown subject name
		loadSubjectName();
		//load data to dropdown tag
		loadTag();
		//load data to dropdown group id
		loadGroup();
		//load data to dropdown Subgroup id
		loadSubGroup();
	}
}
