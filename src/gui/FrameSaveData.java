package gui;

import com.leapmotion.leap.Controller;
import service.LeapListener;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

public class FrameSaveData {

    public JFrame frmTurkshSgnLanguage_main;
    private JTextField textFieldUserName;
    private JTextField textFieldLetterID;
    private JComboBox comboBoxLetterType;
    private JButton btnSave;
    private JButton btnBack;
    private JButton btnStart;
    private JButton btnExit;
    public static String userName, letterType;
    public static int letterIdNumber;
    private JComboBox comboBoxDelay;
    private JLabel labelLeapMotionStartTime;
    private int delayTime = 1;
    private JLabel labelInfo;
    private JLabel labelUserFrameCount;
    private JComboBox comboBoxUserFrameCount;
    protected LeapListener listener;
    protected Controller controller;
    private JButton btnStop;


    /**
     * Create the application.
     */
    public FrameSaveData() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frmTurkshSgnLanguage_main = new JFrame();
        frmTurkshSgnLanguage_main.setTitle("TURKISH SIGN LANGUAGE");
        frmTurkshSgnLanguage_main.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Admin\\Bitirme\\LeapMotion\\src\\leapfoto.jpg"));
        frmTurkshSgnLanguage_main.setBackground(Color.GRAY);
        frmTurkshSgnLanguage_main.setBounds(100, 100, 1735, 810);
        frmTurkshSgnLanguage_main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmTurkshSgnLanguage_main.setLocationRelativeTo(null);
        frmTurkshSgnLanguage_main.getContentPane().setLayout(null);

        JPanel panel = new JPanel();
        panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
        panel.setBounds(1218, 13, 487, 737);
        frmTurkshSgnLanguage_main.getContentPane().add(panel);
        panel.setLayout(null);

        JLabel lblNewLabel = new JLabel("SAVE  LETTER ");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 26));
        lblNewLabel.setBounds(159, 13, 191, 75);
        panel.add(lblNewLabel);

        btnSave = new JButton("SAVE");
        btnSave.setBounds(32, 439, 131, 45);
        panel.add(btnSave);

        btnBack = new JButton("BACK");
        btnBack.setBounds(74, 642, 131, 45);
        panel.add(btnBack);

        btnStart = new JButton("START");
        btnStart.setEnabled(false);
        btnStart.setBounds(181, 439, 131, 45);
        panel.add(btnStart);

        btnExit = new JButton("EXIT");
        btnExit.setBounds(276, 642, 131, 45);
        panel.add(btnExit);

        JLabel lblNewLabel_2 = new JLabel("USER NAME");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 17));
        lblNewLabel_2.setBounds(32, 124, 109, 21);
        panel.add(lblNewLabel_2);

        JLabel lblLetterType = new JLabel("LETTER TYPE");
        lblLetterType.setFont(new Font("Tahoma", Font.BOLD, 17));
        lblLetterType.setBounds(32, 224, 109, 33);
        panel.add(lblLetterType);

        textFieldUserName = new JTextField();
        textFieldUserName.setBounds(346, 125, 127, 22);
        panel.add(textFieldUserName);
        textFieldUserName.setColumns(10);

        labelInfo = new JLabel("LEAP MOTION PROGRAM STARTING TIME", SwingConstants.CENTER);
        labelInfo.setFont(new Font("Tahoma", Font.BOLD, 17));
        labelInfo.setBounds(74, 535, 361, 52);
        panel.add(labelInfo);

        JLabel lblLetterId = new JLabel("LETTER ID");
        lblLetterId.setFont(new Font("Tahoma", Font.BOLD, 17));
        lblLetterId.setBounds(31, 171, 109, 33);
        panel.add(lblLetterId);

        textFieldLetterID = new JTextField();
        textFieldLetterID.setColumns(10);
        textFieldLetterID.setBounds(346, 178, 127, 22);
        panel.add(textFieldLetterID);

        comboBoxLetterType = new JComboBox();
        comboBoxLetterType.setModel(new DefaultComboBoxModel(new String[]{"x", "A", "B", "C", "\u00C7", "D", "E", "F", "G", "\u011E", "H", "I", "\u0130", "J", "K", "L", "M", "N", "O", "\u00D6", "P", "R", "S", "\u015E", "T", "U", "\u00DC", "V", "Y", "Z", "SPACE"}));
        comboBoxLetterType.setBounds(346, 231, 127, 22);
        panel.add(comboBoxLetterType);

        comboBoxDelay = new JComboBox();
        comboBoxDelay.setModel(new DefaultComboBoxModel(new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
        comboBoxDelay.setBounds(346, 292, 127, 22);
        panel.add(comboBoxDelay);

        labelLeapMotionStartTime = new JLabel("LEAP MOTION DURATION DELAY");
        labelLeapMotionStartTime.setFont(new Font("Tahoma", Font.BOLD, 17));
        labelLeapMotionStartTime.setBounds(32, 285, 280, 33);
        panel.add(labelLeapMotionStartTime);

        labelUserFrameCount = new JLabel("NUMBERS OF USER FRAME");
        labelUserFrameCount.setFont(new Font("Tahoma", Font.BOLD, 17));
        labelUserFrameCount.setBounds(32, 347, 254, 33);
        panel.add(labelUserFrameCount);

        comboBoxUserFrameCount = new JComboBox();
        comboBoxUserFrameCount.setModel(new DefaultComboBoxModel(new String[]{"1", "2", "3", "4", "5"}));
        comboBoxUserFrameCount.setBounds(346, 354, 127, 22);
        panel.add(comboBoxUserFrameCount);

        btnStop = new JButton("STOP\r\n");
        btnStop.setEnabled(false);
        btnStop.setBounds(329, 439, 131, 45);
        panel.add(btnStop);

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
                l1.setLocation(20 + 200 * j, 15 + i * 150);
                myPanels.add(l1);
                index++;
            }

        }
        for (LetterPanel letterPan : myPanels) {
            frmTurkshSgnLanguage_main.getContentPane().add(letterPan);
        }


        btnSave.addActionListener(e -> {
            userName = textFieldUserName.getText();
            letterType = (String) comboBoxLetterType.getSelectedItem();
            letterIdNumber = Integer.parseInt(textFieldLetterID.getText());
            delayTime = Integer.parseInt((String) comboBoxDelay.getSelectedItem());
            //listener.frameRate =Integer.parseInt((String)comboBoxFrameRate.getSelectedItem());
            LeapListener.userFrameCount = Integer.parseInt((String) comboBoxUserFrameCount.getSelectedItem());
            LeapListener.userLetterName = letterType;
            // TODO String letterId = ""; get id from file
            // textFieldLetterID.setText(letterId);

            LeapListener.isSaveLetter = true;
            btnStart.setEnabled(true);

        });

        btnStart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                Thread myth = new Thread() {
                    public void run() {
                        listener = new LeapListener();
                        controller = new Controller();
                        //listener.isSaveLetter = true;
                        listener.frameRate = 200;// TODO i\u015elemci h?z? frame rate e yetiyor mu ?
                        // TODO buras? combobox al?nacak

                        btnStop.setEnabled(false);
                        delayTime = Integer.parseInt((String) comboBoxDelay.getSelectedItem());
                        for (int i = delayTime; i > 0; i--) {
                            String labelTimeString = " STARTING IN " + i + " SECOND(S)";
                            //System.out.println(labelTimeString);
                            labelInfo.setText(labelTimeString);
                            try {
                                this.sleep(1000);
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
                    gui.App window = new gui.App();
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
            labelInfo.setText("RECORDED SUCCESSFULLY");
        });


        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frmTurkshSgnLanguage_main.dispose();
                controller.removeListener(listener);
            }
        });


    }
}
