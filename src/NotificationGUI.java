import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;


public class NotificationGUI extends JFrame {

	public JFrame frame;
	private JScrollPane scrollPane;
	public static Connection myConn;
	public String information;
	
	public NotificationGUI() {
		initialize();
	}

	
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setBackground(SystemColor.control);
		frame.setBounds(100, 100, 280, 484);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnNewButton.setBackground(SystemColor.inactiveCaption);
		btnNewButton.setBounds(230, 5, 29, 29);
		frame.getContentPane().add(btnNewButton);
		Image img2 = new ImageIcon(this.getClass().getResource("/avatar.png")).getImage();
		btnNewButton.setIcon(new ImageIcon(img2));
		

		JLabel lbl = new JLabel("������������");
		lbl.setForeground(new Color(245, 245, 245));
		lbl.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbl.setHorizontalAlignment(SwingConstants.CENTER);
		lbl.setOpaque(true);
		lbl.setBackground(SystemColor.inactiveCaption);
		lbl.setBounds(10, 55, 240, 22);
		frame.getContentPane().add(lbl);
		
		JPanel panel = new JPanel() {
			
			@Override
		    public Dimension getPreferredSize() {
		        return new Dimension(700, 700);
		    };
		};
		
		panel.setBounds(20, 88, 220, 346);
		
		frame.getContentPane().add(panel);

		ArrayList<String> not = new ArrayList<String>();
		
		try {
			Notification n = new Notification();
			//System.out.println(not);
			not = n.getNotifications();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		for(int i=0; i<not.size(); i++) {
		//for (int i=0; i<2; i++) {
			//JButton btn1 = new JButton("<html>����� �����������<br/>������������</html>");
			JButton btn1 = new JButton(not.get(i));
			btn1.setBackground(SystemColor.control);
			btn1.setHorizontalAlignment(SwingConstants.LEFT);
			btn1.setForeground(SystemColor.textInactiveText);
			btn1.setBorder(new MatteBorder(0, 0, 1, 0, (Color) SystemColor.textInactiveText));
			btn1.setBounds(0, 0+i*70, 262, 70);
			panel.add(btn1);
			btn1.setHorizontalAlignment(SwingConstants.LEFT);
		}
		
		JScrollPane sp = new JScrollPane(panel);
		sp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		panel.setLayout(null);
		sp.setBounds(20, 90, 220, 325);
		frame.getContentPane().add(sp);
	}

}