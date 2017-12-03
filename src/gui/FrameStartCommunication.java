package gui;

import com.leapmotion.leap.Controller;
import service.LeapListener;
import util.Knn;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Timer;

public class FrameStartCommunication {

	public JFrame frmTurkshSgnLanguage_main;
	private JTextField textField;
	protected Object frame;
	private JButton btnSave;
	private JButton btnBack;
	private JButton btnStart;
	private JButton btnExit;
	public static String userName, letterType;
	public static int letterIdNumber;
	private JComboBox comboBoxDelay;
	private JLabel labelLeapMotionStartTime;
	private int delayTime = 1 ;
	public static int takingTime;
	private int frameCount;
	public static JLabel labelInfo;
	private JComboBox comboBoxUserFrameCount;
	public LeapListener listener;
	public Controller controller;
	private JButton btnStop;
	public static JLabel lblResult1;
	public static JLabel lblResult2;
	public static JLabel lblResult3;
	public static JLabel lblWord;
	private JButton btnClear;
	private JSpinner spinnerKnn;
	public static boolean cont;
	private Timer myTimer;
	public static String res = "";
	private Thread myt;

	/**
	 * Create the application.
	 */
	public FrameStartCommunication() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTurkshSgnLanguage_main = new JFrame();
		frmTurkshSgnLanguage_main.setTitle("TURKISH SIGN LANGUAGE");
		frmTurkshSgnLanguage_main.setIconImage(
				Toolkit.getDefaultToolkit().getImage("C:\\Users\\Admin\\Bitirme\\LeapMotion\\src\\leapfoto.jpg"));
		frmTurkshSgnLanguage_main.setBackground(Color.GRAY);
		frmTurkshSgnLanguage_main.setBounds(100, 100, 1735, 810);
		frmTurkshSgnLanguage_main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTurkshSgnLanguage_main.setLocationRelativeTo(null);
		frmTurkshSgnLanguage_main.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel.setBounds(1222, 13, 485, 737);
		frmTurkshSgnLanguage_main.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("GUESS LETTER ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNewLabel.setBounds(153, 13, 200, 75);
		panel.add(lblNewLabel);

		btnSave = new JButton("SAVE");
		btnSave.setBounds(23, 245, 131, 45);
		panel.add(btnSave);

		btnBack = new JButton("BACK");
		btnBack.setBounds(23, 675, 131, 45);
		panel.add(btnBack);

		btnStart = new JButton("START");
		btnStart.setEnabled(false);
		btnStart.setBounds(187, 245, 131, 45);
		panel.add(btnStart);

		btnExit = new JButton("EXIT");
		btnExit.setBounds(342, 675, 131, 45);
		panel.add(btnExit);

		labelInfo = new JLabel("TURKISH SIGN LANGUAGE", SwingConstants.CENTER);
		labelInfo.setFont(new Font("Tahoma", Font.BOLD, 17));
		labelInfo.setBounds(70, 326, 361, 52);
		panel.add(labelInfo);

		comboBoxDelay = new JComboBox();
		comboBoxDelay.setModel(new DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
		comboBoxDelay.setBounds(346, 97, 127, 22);
		panel.add(comboBoxDelay);

		labelLeapMotionStartTime = new JLabel("LEAP MOTION DURATION DELAY");
		labelLeapMotionStartTime.setFont(new Font("Tahoma", Font.BOLD, 17));
		labelLeapMotionStartTime.setBounds(12, 90, 280, 33);
		panel.add(labelLeapMotionStartTime);

		comboBoxUserFrameCount = new JComboBox();
		comboBoxUserFrameCount.setModel(new DefaultComboBoxModel(new String[] {"3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15"}));
		comboBoxUserFrameCount.setBounds(346, 143, 127, 22);
		panel.add(comboBoxUserFrameCount);

		btnStop = new JButton("STOP\r\n");
		btnStop.setEnabled(false);
		btnStop.setBounds(342, 245, 131, 45);
		panel.add(btnStop);

		JLabel lblSecondsBeforeTakng = new JLabel("SECONDS BEFORE TAKING A LETTER");
		lblSecondsBeforeTakng.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblSecondsBeforeTakng.setBounds(13, 136, 321, 33);
		panel.add(lblSecondsBeforeTakng);

		JLabel lblKnnNumber = new JLabel("KNN NUMBER");
		lblKnnNumber.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblKnnNumber.setBounds(12, 182, 321, 33);
		panel.add(lblKnnNumber);

		spinnerKnn = new JSpinner();
		spinnerKnn.setModel(new SpinnerNumberModel(1, 1, 50, 1));
		spinnerKnn.setBounds(346, 189, 127, 22);
		panel.add(spinnerKnn);

		lblResult1 = new JLabel("", SwingConstants.CENTER);
		lblResult1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblResult1.setBounds(70, 390, 361, 52);
		panel.add(lblResult1);

		lblResult2 = new JLabel("", SwingConstants.CENTER);
		lblResult2.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblResult2.setBounds(70, 433, 361, 52);
		panel.add(lblResult2);

		lblResult3 = new JLabel("", SwingConstants.CENTER);
		lblResult3.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblResult3.setBounds(70, 478, 361, 52);
		panel.add(lblResult3);

		lblWord = new JLabel("", SwingConstants.CENTER);
		lblWord.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblWord.setBounds(0, 536, 485, 52);
		panel.add(lblWord);

		btnClear = new JButton("CLEAR\r\n");
		btnClear.setBounds(187, 617, 131, 45);
		panel.add(btnClear);
		
		JLabel lblGuess = new JLabel("1. GUESS =>", SwingConstants.CENTER);
		lblGuess.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblGuess.setBounds(-11, 391, 185, 52);
		panel.add(lblGuess);
		
		JLabel lblGuess_1 = new JLabel("2. GUESS =>", SwingConstants.CENTER);
		lblGuess_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblGuess_1.setBounds(-11, 433, 185, 52);
		panel.add(lblGuess_1);
		
		JLabel lblGuess_2 = new JLabel("3. GUESS =>", SwingConstants.CENTER);
		lblGuess_2.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblGuess_2.setBounds(-11, 478, 185, 52);
		panel.add(lblGuess_2);


		ArrayList<ImageIcon> myImages = new ArrayList<>();
		myImages.add(new ImageIcon(FrameSaveData.class.getResource("resources/A.png")));
		myImages.add(new ImageIcon(FrameSaveData.class.getResource("resources/B.png")));
		myImages.add(new ImageIcon(FrameSaveData.class.getResource("resources/C.png")));
		myImages.add(new ImageIcon(FrameSaveData.class.getResource("resources/Ç.png")));
		myImages.add(new ImageIcon(FrameSaveData.class.getResource("resources/D.png")));
		myImages.add(new ImageIcon(FrameSaveData.class.getResource("resources/E.png")));
		myImages.add(new ImageIcon(FrameSaveData.class.getResource("resources/F.png")));
		myImages.add(new ImageIcon(FrameSaveData.class.getResource("resources/G.png")));
		myImages.add(new ImageIcon(FrameSaveData.class.getResource("resources/\u011e.png")));
		myImages.add(new ImageIcon(FrameSaveData.class.getResource("resources/H.png")));
		myImages.add(new ImageIcon(FrameSaveData.class.getResource("resources/II.png")));
		myImages.add(new ImageIcon(FrameSaveData.class.getResource("resources/\u0130.png")));
		myImages.add(new ImageIcon(FrameSaveData.class.getResource("resources/J.png")));
		myImages.add(new ImageIcon(FrameSaveData.class.getResource("resources/K.png")));
		myImages.add(new ImageIcon(FrameSaveData.class.getResource("resources/L.png")));
		myImages.add(new ImageIcon(FrameSaveData.class.getResource("resources/M.png")));
		myImages.add(new ImageIcon(FrameSaveData.class.getResource("resources/N.png")));
		myImages.add(new ImageIcon(FrameSaveData.class.getResource("resources/O.png")));
		myImages.add(new ImageIcon(FrameSaveData.class.getResource("resources/Ö.png")));
		myImages.add(new ImageIcon(FrameSaveData.class.getResource("resources/P.png")));
		myImages.add(new ImageIcon(FrameSaveData.class.getResource("resources/R.png")));
		myImages.add(new ImageIcon(FrameSaveData.class.getResource("resources/S.png")));
		myImages.add(new ImageIcon(FrameSaveData.class.getResource("resources/\u015e.png")));
		myImages.add(new ImageIcon(FrameSaveData.class.getResource("resources/T.png")));
		myImages.add(new ImageIcon(FrameSaveData.class.getResource("resources/U.png")));
		myImages.add(new ImageIcon(FrameSaveData.class.getResource("resources/Ü.png")));
		myImages.add(new ImageIcon(FrameSaveData.class.getResource("resources/V.png")));
		myImages.add(new ImageIcon(FrameSaveData.class.getResource("resources/Y.png")));
		myImages.add(new ImageIcon(FrameSaveData.class.getResource("resources/Z.png")));
		myImages.add(new ImageIcon(FrameSaveData.class.getResource("resources/SPACE.png")));

		ArrayList<LetterPanel> myPanels = new ArrayList<LetterPanel>();
		int index = 0;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 6; j++) {
				LetterPanel l1 = new LetterPanel(myImages.get(index));
				l1.setLocation(20 + 200*j, 15 + i*150);
				myPanels.add(l1);
				index++;
			}

		}
		for (LetterPanel letterPan : myPanels) {
			frmTurkshSgnLanguage_main.getContentPane().add(letterPan);
		}

		btnSave.addActionListener(e -> {
            Knn.K = (int) spinnerKnn.getValue();
            delayTime = Integer.parseInt((String) comboBoxDelay.getSelectedItem());
            //takingTime = Integer.parseInt((String) comboBoxTakingLetter.getSelectedItem());
            frameCount= Integer.parseInt((String) comboBoxUserFrameCount.getSelectedItem());
            // listener.frameRate
            // =Integer.parseInt((String)comboBoxFrameRate.getSelectedItem());
            LeapListener.userFrameCount = Integer.parseInt((String) comboBoxUserFrameCount.getSelectedItem());
            LeapListener.userLetterName = letterType;
            // TODO String letterId = ""; get id from file
            // textFieldLetterID.setText(letterId);
            cont = true;
            btnStart.setEnabled(true);

        });

		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					Thread myth = new Thread() {
						

						public void run() {
							
							
							listener = new LeapListener();
							controller = new Controller();
							LeapListener.isSaveLetter = false;
							listener.frameRate = 1000;// TODO i\u015elemci h?z? frame
														// rate e yetiyor mu ?
							// TODO buras? combobox al?nacak

							btnStop.setEnabled(false);
					
								for (int i = delayTime; i > 0; i--) {
									String labelTimeString = " STARTING IN " + i + " SECOND(S)";
									// System.out.println(labelTimeString);
									labelInfo.setText(labelTimeString);
									try {
										this.sleep(1000); // GER? SAYIMDAK? 1 SAN?YE
									} catch (InterruptedException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}

								}
								
							labelInfo.setText("PROGRAM IS STARTING");
														
							controller.addListener(listener);							
							
							btnStop.setEnabled(true);
						
							try {
								System.in.read();
							} catch (IOException ex) {
								ex.printStackTrace();
							}
						}
						

					};
					myth.start();
					
				btnStart.setEnabled(false);
				btnSave.setEnabled(false);
				btnBack.setEnabled(false);
				btnExit.setEnabled(false);
					
			}
		});

		btnBack.addActionListener(e -> {
            frmTurkshSgnLanguage_main.dispose();
            EventQueue.invokeLater(() -> {
                try {
                    App window = new App();
                    window.appFrame.setVisible(true);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            });

        });

		btnStop.addActionListener(e -> {

            LeapListener.letterList = new ArrayList<>();
            controller.removeListener(listener);
            btnStart.setEnabled(true);
            btnStop.setEnabled(false);
            btnSave.setEnabled(true);
            btnBack.setEnabled(true);
            btnExit.setEnabled(true);
            labelInfo.setText("PAUSE");
        });

		btnExit.addActionListener(e -> {
            frmTurkshSgnLanguage_main.dispose();
            clearGuess();
        });

		btnClear.addActionListener(arg0 -> clearGuess());

	}
	
	private void clearGuess(){
		res="";
		lblResult1.setText("");
		lblResult2.setText("");
		lblResult3.setText("");
		lblWord.setText("");
	}
}
