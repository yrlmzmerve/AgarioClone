package tr.org.linux.kamp.Agario.windowsbuilder;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;

public class FirstFrame extends JFrame {
	
	private FirstPanel contentPane;
	
	public FirstFrame() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100,100,450,300);
		contentPane = new FirstPanel();
		contentPane.setBorder(new  EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setTitle("Login Page");
		
	}

	
	
	public static void main(String[] args) {
		
		
		
		FirstFrame frame = new FirstFrame();
		
		frame.setVisible(true);
		//aşağıdakiyle aynı
		/*EventQueue.invokeLater(new Runnable() { //
			public void run() {
				try {
					FirstFrame frame = new FirstFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	}
}
