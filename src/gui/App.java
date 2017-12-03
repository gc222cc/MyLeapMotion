package gui;

import service.LeapListener;

import javax.swing.*;
import java.awt.*;

import static util.Constants.*;

public class App {

    JFrame appFrame;

    public static void main(String[] args) {
        initializeUIManager();
        startApplication();
    }

    private static void startApplication() {
        EventQueue.invokeLater(() -> {
            try {
                App app = new App();
                app.appFrame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    private static void initializeUIManager() {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    break;
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Initialize app.
     */
    App() {
        initializeAppFrame();
    }

    /**
     * Setup app frame.
     */
    private void initializeAppFrame() {
        appFrame = new JFrame();
        appFrame.setTitle(FRAME_TITLE);
        appFrame.setBounds(0,0,500,350);
        appFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        appFrame.getContentPane().setLayout(null);
        appFrame.getContentPane().add(getButtonSaveData());
        appFrame.getContentPane().add(getButtonStartCommunication());

        JLabel description = new JLabel(APP_DESCRIPTION);
        description.setHorizontalAlignment(SwingConstants.CENTER);
        description.setBounds(0,0,500,350);
        description.setFont(new Font("Calibri", Font.PLAIN, 14));
        appFrame.getContentPane().add(description);

    }

    private JButton getButtonStartCommunication() {
        JButton buttonStartCommunication = new JButton(START_COMMUNICATION);
        buttonStartCommunication.setFont(new Font("Calibri", Font.BOLD, 20));
        buttonStartCommunication.addActionListener(arg0 -> {
            LeapListener.isSaveLetter = false;
            appFrame.dispose();
            EventQueue.invokeLater(() -> {
                try {
                    FrameStartCommunication startCommunication = new FrameStartCommunication();
                    startCommunication.frmTurkshSgnLanguage_main.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        });
        buttonStartCommunication.setBounds(0, 0, 500, 50);
        return buttonStartCommunication;
    }

    private JButton getButtonSaveData() {
        JButton buttonSaveData = new JButton(SAVE_DATA);
        buttonSaveData.setFont(new Font("Calibri", Font.BOLD, 20));
        buttonSaveData.addActionListener(arg0 -> {
            appFrame.dispose();
            EventQueue.invokeLater(() -> {
                LeapListener.isSaveLetter = true;
                try {
                    FrameSaveData saveData = new FrameSaveData();
                    saveData.frmTurkshSgnLanguage_main.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        });
        buttonSaveData.setBounds(0, 50, 500, 50);
        return buttonSaveData;
    }
}
