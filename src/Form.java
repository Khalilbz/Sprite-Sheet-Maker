import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.geom.Line2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.Window.Type;

import org.eclipse.wb.swing.FocusTraversalOnArray;

//import Main_P.Animation;




import java.awt.Component;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JTextPane;

import java.awt.Canvas;
import java.awt.Panel;


public class Form extends JFrame {

	private JPanel contentPane;
	public int width = 50;
	public int height = 50;
	public int w = 0 ;
	public int h = 0 ;
	public String[] Spritenm = new String[1000];
	public int[] Spritex = new int[1000];
	public int[] Spriteln = new int[1000];
	public int sp = 0;
	
	//For Animated Pictures
	public  String[] p1 = new String[1000];
	public  String[] p2 = new String[1000];
	public  String[] pnm = new String[1000];
	public  int[] pln = new int[1000];
	public int pn = 0;
	public static Form frame = new Form();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//Form frame = new Form();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Form() {
		setType(Type.NORMAL);
		setResizable(false);
		setTitle("Sprite Sheet Maker V1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 369);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final DefaultListModel lst = new DefaultListModel();
//		for(int i = 0;i<=5;i++)
//		lst.addElement("item : "+i);
		
		final JList list = new JList();
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//////////////////////////////////
				
				System.out.println("Add");
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setMultiSelectionEnabled(true);
				int result = fileChooser.showOpenDialog(contentPane);
				if (result == JFileChooser.APPROVE_OPTION) {
				    // user selects a file
					File selectedFile = fileChooser.getSelectedFile();
					System.out.println("Selected file: " + selectedFile.getAbsolutePath());
					//lst[0] = selectedFile.getAbsolutePath() ;
					for(File f:fileChooser.getSelectedFiles()){
					lst.addElement(f.getAbsolutePath());
					}
					
				}else{
					JOptionPane.showMessageDialog(frame, "You didn't select a File !");
					System.out.println("You didn't select a File !");
				}
				
				/////////////////////////////////
			}
		});
		btnAdd.setBounds(116, 261, 57, 23);
		contentPane.add(btnAdd);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(new Integer(500), new Integer(0), null, new Integer(1)));
		spinner.setBounds(59, 262, 54, 20);
		spinner.setEnabled(false);
		contentPane.add(spinner);
		
		JButton btnNewButton0 = new JButton("Export Sprite Sheet");
		btnNewButton0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//////////////////////////////////
				
				System.out.println("Export");
				
				/////////////////////////////////
			}
		});
		btnNewButton0.setBounds(260, 261, 163, 23);
		btnNewButton0.setEnabled(false);
		contentPane.add(btnNewButton0);
		
		JButton supp = new JButton("Delete");
		supp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//////////////////////////////////
				
				System.out.println("Delete");
				lst.remove(list.getSelectedIndex());
				
				/////////////////////////////////
			}
		});
		supp.setBounds(520, 261, 80, 23);
		contentPane.add(supp);
		
		JButton btnNewButton = new JButton("Reset");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//////////////////////////////////
				
				System.out.println("Reset");
				lst.clear();
				
				/////////////////////////////////
			}
		});
		btnNewButton.setBounds(430, 261, 80, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton1 = new JButton("Show");
		btnNewButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//////////////////////////////////
				
				System.out.println("Show");
	                    ////////////////////////////////////////////////////////////////////////////////////////////////////////////
	                    ////////////////////////////////////////////////////////////////////////////////////////////////////////////
	                    //---------------------------------------------------------------------BEGIN OF CODE 
	                    //TODO try to draw and then save what you've drawn
				JFileChooser sf = new JFileChooser();
                sf.setDialogTitle("Save you Sprite Sheet");
                int userSelection = sf.showSaveDialog(frame);
                File log = new File(sf.getSelectedFile().getAbsolutePath()+".txt");
                BufferedWriter wr =null;
                try {
					wr = new BufferedWriter(new FileWriter(log));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	                    BufferedImage pic = new BufferedImage(5000, 5000, BufferedImage.TYPE_INT_ARGB);
	                    Graphics2D g2 = pic.createGraphics();
	                    g2.setColor(Color.blue);
	                    g2.fillRect(10, 10, 50, 200);
	                    /*/ Draw what ever you want to to the graphics context
	                    g2d.dispose();

	                    try {
							ImageIO.write(img, "png", new File("C:/My Awesome Drawing.png"));
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
	                    */
	                    //Graphics2D g2 = (Graphics2D)g;
	                    g2.setColor(Color.white);
	                    g2.fillRect(0, 0, width, height);
	                    for(int i = 0;i<=lst.getSize()-1;i++){
	                    	//System.out.println(((String) lst.getElementAt(i)).replaceAll("\\\\", "/"));
	                    	BufferedImage img = null;
	                    	String nm = ((String) lst.getElementAt(i)).replaceAll("\\\\", "/");
	                    	String name = "";
	                    	String nb = "";
	                    	int nmb = 0;
	                    	try{
								img = ImageIO.read(new File(nm));
							} catch (IOException oo) {
								// TODO Auto-generated catch block
								oo.printStackTrace();
							}
	                    	
	                    	///////////////////////////////////////////Deleting the extension
	                    	nm = nm.substring(0, nm.length()-3);
	                    	while(nm.charAt(nm.length()-1) != '.'){
	                    	nm = nm.substring(0, nm.length()-1);
	                    	}
	                    	//System.out.println("Deleting The Extension Done!");
	                    	///////////////////////////////////////////Creating Name
	                    	int j=nm.length()-1;
	                    	//System.out.println("<<<");
	                    	while(j>0){
	                    		j--;
	                    	//System.out.print(nm.charAt(j));
	                    	name = nm.charAt(j)+name;
	                    		if(nm.charAt(j-1) == '/'){
	                    			j=0;
	                    		}
	                    	}
	                    	//System.out.println("Creating Name Done!");
	                    	///////////////////////////////////////////For Animations
	                    	if(name.indexOf("(") != -1){
	                    		nb = name.substring(name.indexOf("(")+1,name.indexOf(")") );
	                    	try {
								nmb = Integer.parseInt(nb);
							} catch (NumberFormatException oo) {
								JOptionPane.showMessageDialog(frame, "Sprite Sheet Name have to be like this 'SimpleName.png' or 'Simple Name With Number(1).png' [ ("+nb+") is note a Number]");
								//System.out.println(nb+" is note a number");
							}
	                    	}
	                    	if(nb != "")nb=" || "+nb;
	                    	//System.out.println("Sprite Sheets For Animations Done!");
	                    	//////////////////////////////////////////////
	                    	//System.out.print(">>>");
	                    	
	                    	//System.out.println("  ==>  "+nm+"||"+name+nb);
	                    	//System.out.println("Name = "+name);
	                    	//System.out.println("Number = "+nmb);
	                    	if(nmb == 0){
	                    		g2.drawImage(img, 0, h, null);
	                    		if(nmb==0){
	                    			try {
	                    			wr.write("");wr.newLine();
	                    			wr.write("//"+name);wr.newLine();
	                    			wr.write("Animations[ann] = new Animation();");wr.newLine();
	                    			wr.write("Animations[ann].place(\""+name+"\","+h+" , "+img.getWidth()+", "+img.getHeight()+");");wr.newLine();
	                    			wr.write("Animations[ann].conf(0, 0, 5, false, false);ann++;");wr.newLine();
									} catch (IOException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
	                    		}
	                    		h+=img.getHeight();
	                    		if(w<img.getWidth())w=img.getWidth();
	                    	}
	                    	else if(nmb >0){
	                    		int hi =h;
	                    		int spln=-1;
	                    		boolean b = false;
	                    		
	                    		if(sp>0)for(int x=0;x<sp;x++){
	                    			//System.out.println("Seek for |"+name.substring(0, name.indexOf("("))+"| now in |"+Spritenm[x]+"|");
	                    			if(Spritenm[x].equals(name.substring(0, name.indexOf("(")))){
	                    				b=true;
	                    				hi=Spritex[x];
	                    				spln=Spriteln[x];
	                    				if(Spriteln[x]<nmb)Spriteln[x]=nmb;
	                    			//System.out.println(Spritenm[x]+" Found  And SPx="+Spritex[x]);
	                    			}
	                    		}
	                    		if(b==false){
	                    			//System.out.println(name.substring(0, name.indexOf("("))+" ADDED With SPX="+h);
	                    			Spritenm[sp]=name.substring(0, name.indexOf("("));
	                    			Spritex[sp]=h;
	                    			Spriteln[sp]=nmb;
	                    			sp++;
	                    		}
	                    		///////////////////////////////////////////////
	                    		//System.out.println("hi = "+hi);
	                    		
	                    		g2.drawImage(img, (nmb-1)*img.getWidth(), hi, null);
	                    		///----Part for Generating Code
		                    		pnm[pn]=name.substring(0, name.indexOf("("));
		                    		p1[pn]="Animations[ann].place(\""+name.substring(0, name.indexOf("("))+"\","+(h-img.getHeight())+" , "+img.getWidth()+", "+img.getHeight()+");";
		                    		p2[pn]="Animations[ann].conf(0, "+spln+", 5, true, false);ann++;";
		                    		pln[pn]=nmb;
		                    		pn++;
	                 /*   		if(nmb==1){
	                    		System.out.println("");
	                    		System.out.println("//"+name.substring(0, name.indexOf("(")));
	                    		System.out.println("Animations[ann] = new Animation();");
	                    		System.out.println("Animations[ann].place('"+name.substring(0, name.indexOf("("))+"',"+h+" , "+img.getWidth()+", "+img.getHeight()+");");
	                    		System.out.println("Animations[ann].conf(0, "+spln+", 5, true, false);ann++;");
	                    		}
	                */    		if(b==false)h+=img.getHeight();
	                    		
	                    		if(w<img.getWidth()*(nmb-1))w=img.getWidth()*(nmb-1);
	                    	}
	                    	
	                    			
	                    }
	                    //END of Loop -----------------------------------------------------------------------------------
	                    for(int i = 0;i<sp;i++){
	                    	int max = 0;
	                    	int maxpos =0;
	                    	for(int j=0;j<pn;j++){
	                    		if(pnm[j].equals(Spritenm[i])){
	                    			if(max<pln[j]){
	                    				max = pln[j];
	                    				maxpos = j;
	                    			}
	                    		}
	                    	}
	                    	try {
	                    	wr.write("");wr.newLine();
	                    	wr.write("//"+pnm[maxpos]);wr.newLine();
	                    	wr.write("Animations[ann] = new Animation();");wr.newLine();
	                    	wr.write(p1[maxpos]);wr.newLine();
							wr.write("Animations[ann].conf(0, "+(pln[maxpos]-1)+", 5, true, false);ann++;");wr.newLine();
							wr.close();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
	                    }
	                    //----------------THE END---------------------------------
	                    g2.dispose();

	                    
	                    
	                    if (userSelection == JFileChooser.APPROVE_OPTION) {
	                    try {
							ImageIO.write(pic, "png", sf.getSelectedFile());
						} catch (IOException oo) {
							// TODO Auto-generated catch block
							oo.printStackTrace();
						}
	                    }else{
	                    	System.out.println("You have to write a file name");
	                    }
	                    //g.setColor(Color.black);
	                    //g.drawString("oo", w+w/2, h+h/2);
	                    /*
	                     ************************************************************
	                     ************************************************************
	                     ************************************************************
	                     ************************************************************
	                    BufferedImage img = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
	                    Graphics2D g2d = img.createGraphics();
	                    g2d.setColor(Color.blue);
	                    g2d.fillRect(10, 10, 50, 200);
	                    // Draw what ever you want to to the graphics context
	                    g2d.dispose();

	                    try {
							ImageIO.write(img, "png", new File("C:/My Awesome Drawing.png"));
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						**************************************************************
						**************************************************************
						**************************************************************
						**************************************************************
						**************************************************************
						**************************************************************
	                    */
	                    //g.drawImage(g.getClipRect(new Rectangle(0,0,w,h)), 100, 200, null);
	                 }
	            });
	            //frame1.setBounds(0, 0, w, h);
	            //System.out.println(w+"   "+h+"---------");
	            
		btnNewButton1.setBounds(180, 261, 70, 23);
		contentPane.add(btnNewButton1);
		
		JLabel lblWidth = new JLabel("Width :");
		lblWidth.setBounds(10, 265, 46, 14);
		contentPane.add(lblWidth);
		

		
		list.setBounds(10, 10, 770, 244);
		list.setModel(lst);
		contentPane.add(list);
		
	/*	Panel panel = new Panel(){
			public void paintComponent( Graphics g ) {
                super.paintComponents(g);
                Graphics2D g2 = (Graphics2D)g;

                Line2D line = new Line2D.Double(10, 10, 40, 40);
                g2.setColor(Color.blue);
                g2.setStroke(new BasicStroke(10));
                g2.draw(line);
                g2.fillRect(0, 0, 100, 100);
             }
		};
		panel.setBounds(179, 10, 240, 325);
		contentPane.add(panel);
	*/	setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{contentPane, btnAdd, spinner, btnNewButton, lblWidth}));
	}
}
