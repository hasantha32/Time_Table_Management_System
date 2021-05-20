package Timetable;

import java.awt.EventQueue;





import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.border.MatteBorder;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.border.TitledBorder;
import java.awt.List;
import java.awt.ScrollPane;
import java.awt.Button;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

import DBC.DBConnection;
import net.proteanit.sql.DbUtils;

import javax.swing.border.LineBorder;
import java.awt.Panel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.JMenuBar;

public class Lecturer {

	

	
	private JFrame frmAddStudentGroup;
	private JFrame frmAddStudentGroup_1;	private JTextField txtLecturer;
	private JComboBox comboBox;	
	private JTable table;
	
	  public void filllectureNames() {
			
			try {
				
				 Connection con = DBConnection.connect();
				 
				 String query="select * from Lecturers";
				 
				 PreparedStatement pst = con.prepareStatement(query);
				 ResultSet rs = pst.executeQuery();
				 
				 while(rs.next()) {
					 
					 String name =rs.getString("LecturerName");
					 comboBox.addItem(name);
					 //comboBox_4_1.addItem(rs.getString("SubGroupID"));
					 
				}
				con.close();
			}
			
			catch(Exception e) {
				
					e.printStackTrace();
				}
			
	     	}
	     
	
	
	  
	  
	 
	  
	  
	  //refresh method
	  public void refreshTable() {
			
			try {
				Connection con = DBConnection.connect();
				
				String query="select conSessionID AS SessionID,conSession AS ConsecutiveSession from consecutiveSession ";
				PreparedStatement pst=con.prepareStatement(query);
				ResultSet rs=pst.executeQuery();
				//table.setModel(DbUtils.resultSetToTableModel(rs));
				
				
				
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
					Lecturer window = new Lecturer();
					window.frmAddStudentGroup_1.setVisible(true);
					
				
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	
     
     
	
	/**
	 * Create the application.
	 */
	public Lecturer() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frmAddStudentGroup= new JFrame();
		frmAddStudentGroup.addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent arg0) {
				
				try {
					Connection con = DBConnection.connect();
					
					String query="select * from timeAlloLecture ";
					PreparedStatement pst=con.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					//table.setModel(DbUtils.resultSetToTableModel(rs));
					
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
		frmAddStudentGroup_1 = new JFrame();
		frmAddStudentGroup_1.getContentPane().setBackground(SystemColor.activeCaption);
		frmAddStudentGroup_1.setBackground(Color.YELLOW);
		frmAddStudentGroup_1.setResizable(false);
		frmAddStudentGroup_1.setTitle("Time Table Management System");
		frmAddStudentGroup_1.setSize(1350, 728);
		frmAddStudentGroup_1.setBounds(0, 0, 1350, 700);
		frmAddStudentGroup_1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAddStudentGroup_1.getContentPane().setLayout(null);
	
		
		
		frmAddStudentGroup_1.setLocationRelativeTo(null); // this method display the JFrame to center position of a screen
		frmAddStudentGroup_1.setVisible(true);
		
		
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 36, 1344, 65);
		panel.setBackground(Color.GRAY);
		frmAddStudentGroup_1.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_10 = new JLabel("Generate Time Table");
		lblNewLabel_10.setForeground(Color.WHITE);
		lblNewLabel_10.setFont(new Font("Times New Roman", Font.BOLD, 27));
		lblNewLabel_10.setBackground(Color.WHITE);
		lblNewLabel_10.setBounds(572, 26, 333, 29);
		panel.add(lblNewLabel_10);
				
				
		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBackground(SystemColor.activeCaption);
		panel_6.setBounds(245, 156, 1081, 519);
		frmAddStudentGroup_1.getContentPane().add(panel_6);
		
		
		
		
		
		JPanel panel_7 = new JPanel();
		panel_7.setBounds(0, 27, 1059, 453);
		panel_6.add(panel_7);
		
	
		//generate button
		JButton btnNewButton_2 = new JButton("GENERATE");
		btnNewButton_2.setBounds(698, 13, 164, 40);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(comboBox.getSelectedItem().toString().equals(" ") || comboBox.getSelectedItem().toString().equals("                       ----- Select Lecturer Name-----"))
				{
					
					JOptionPane.showMessageDialog(null, "   Please Select Lecturer Name","Failed",JOptionPane.WARNING_MESSAGE);
				}
				else {
				try {
					
					Connection con = DBConnection.connect();
					
					String query="select Date As Day,startTime || ' ' || start AS StartTime,endTime || ' ' || end AS EndTime,sessionSign from notavailableTime where selectLec='"+comboBox.getSelectedItem()+"' order by Date,StartTime,EndTime";
					PreparedStatement pst=con.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
					
					TableColumnModel columnModel = table.getColumnModel();
					columnModel.getColumn(0).setPreferredWidth(5);
					columnModel.getColumn(1).setPreferredWidth(5);
					columnModel.getColumn(2).setPreferredWidth(5);
					columnModel.getColumn(3).setPreferredWidth(600);
					
					
				}
				catch(Exception ex) {
					ex.printStackTrace();
				}
			}
			}
		});
		panel_7.setLayout(null);
		
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton_2.setBackground(Color.BLACK);
		panel_7.add(btnNewButton_2);
		
		
		
		//print button
		JButton btnNewButton_3 = new JButton("PRINT");
		btnNewButton_3.setBounds(874, 13, 155, 40);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				MessageFormat header = new MessageFormat("Lecturer TimeTable - "+ comboBox.getSelectedItem().toString());
				Date date = new Date();  
			    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss.SSS");  
			    String strDate= formatter.format(date);  
				MessageFormat footer = new MessageFormat("Timetable generated on:" +strDate);
				
				try {
					
					table.print(JTable.PrintMode.FIT_WIDTH,header,footer);
					
					
				}catch(Exception e1) {
					
					JOptionPane.showMessageDialog(null, "       Unable to print","Alert",JOptionPane.WARNING_MESSAGE);
					
				}
			
			}
		});
		
	
		btnNewButton_3.setForeground(Color.WHITE);
		btnNewButton_3.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton_3.setBackground(Color.BLACK);
		panel_7.add(btnNewButton_3);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"                       ----- Select Lecturer Name-----"}));
		comboBox.setFont(new Font("Times New Roman", Font.BOLD, 14));
		comboBox.setBounds(314, 18, 360, 30);
		panel_7.add(comboBox);
		
		filllectureNames();
		
		JLabel lblNewLabel = new JLabel("Lecturer :");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel.setBounds(198, 19, 106, 28);
		panel_7.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 66, 1035, 420);
		//frmAddStudentGroup.getContentPane().add(scrollPane);
		panel_7.add(scrollPane);
		
		table = new JTable();
		table.setRowHeight(90);
		table.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		scrollPane.setViewportView(table);
		
		JButton btnNewButton_2_1 = new JButton("Lecturer");
		btnNewButton_2_1.setBackground(Color.BLACK);
		btnNewButton_2_1.setForeground(Color.RED);
		btnNewButton_2_1.setFont(new Font("Arial Black", Font.BOLD, 11));
		btnNewButton_2_1.setBounds(0, 339, 192, 37);
		frmAddStudentGroup_1.getContentPane().add(btnNewButton_2_1);
		
		JButton btnNewButton_2_1_1 = new JButton("Student");
		btnNewButton_2_1_1.setBackground(Color.BLACK);
		btnNewButton_2_1_1.setForeground(Color.WHITE);
		btnNewButton_2_1_1.setFont(new Font("Arial Black", Font.BOLD, 11));
		btnNewButton_2_1_1.setBounds(0, 376, 192, 37);
		frmAddStudentGroup_1.getContentPane().add(btnNewButton_2_1_1);
		
		JButton btnNewButton_2_1_2 = new JButton("Location");
		btnNewButton_2_1_2.setBackground(Color.BLACK);
		btnNewButton_2_1_2.setForeground(Color.WHITE);
		btnNewButton_2_1_2.setFont(new Font("Arial Black", Font.BOLD, 11));
		btnNewButton_2_1_2.setBounds(0, 412, 192, 37);
		frmAddStudentGroup_1.getContentPane().add(btnNewButton_2_1_2);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(0, 97, 1334, 45);
		frmAddStudentGroup_1.getContentPane().add(panel_5);
		panel_5.setLayout(null);
		panel_5.setForeground(Color.RED);
		panel_5.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		panel_5.setBackground(Color.BLACK);
		
		JLabel lblLecturer = new JLabel("LECTURER");
		lblLecturer.setHorizontalAlignment(SwingConstants.CENTER);
		lblLecturer.setForeground(Color.RED);
		lblLecturer.setFont(new Font("Arial Black", Font.BOLD, 20));
		lblLecturer.setBounds(550, 10, 278, 31);
		panel_5.add(lblLecturer);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(Color.GRAY);
		panel_1_1.setBounds(0, 140, 192, 200);
		frmAddStudentGroup_1.getContentPane().add(panel_1_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.GRAY);
		panel_1.setBounds(0, 449, 192, 180);
		frmAddStudentGroup_1.getContentPane().add(panel_1);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBackground(Color.GRAY);
		panel_2_1.setBounds(0, 628, 192, 37);
		frmAddStudentGroup_1.getContentPane().add(panel_2_1);
		
		JButton btnDelete = new JButton("<<Back");
		btnDelete.setForeground(new Color(240, 248, 255));
		btnDelete.setFont(new Font("SansSerif", Font.BOLD, 13));
		btnDelete.setBackground(Color.BLACK);
		panel_2_1.add(btnDelete);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setForeground(Color.BLACK);
		menuBar.setBorderPainted(false);
		menuBar.setBorder(null);
		menuBar.setBackground(Color.BLACK);
		menuBar.setBounds(0, 0, 1344, 37);
		frmAddStudentGroup_1.getContentPane().add(menuBar);
		btnNewButton_2_1_2.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
			
				frmAddStudentGroup.dispose();
				new Location();
				
			}
		});
		btnNewButton_2_1_1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				
				frmAddStudentGroup.dispose();
				new  Student();
				
			}
		});
		btnNewButton_2_1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				
				frmAddStudentGroup.dispose();
				new  Lecturer();
				
			}
		});
		
		
		//table header
		JTableHeader h = table.getTableHeader();
		h.setBackground(new Color(153,153,153));
		h.setForeground(Color.WHITE);
		h.setFont(new Font("Times New Roman", Font.BOLD, 17));
		h.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		

			
	}
}
