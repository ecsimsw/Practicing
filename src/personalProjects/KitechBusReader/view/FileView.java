package personalProjects.KitechBusReader.view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.InputEvent;

public class FileView extends JFrame {
    private JPanel contentPane = new JPanel();

    public static void run() {
        try {
            FileView frame = new FileView();
            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public FileView() {
        super("KITECH 버스 태그 기록 조회");

        setMenuBar();
        setDateRange();
        setUserDataFile();
        setHistoryFile();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 688, 471);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(44, 131, 575, 260);
        contentPane.add(scrollPane);
    }

    private void setMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu settingMenu = getSettingMenuOnMenuBar();
        menuBar.add(settingMenu);
        setJMenuBar(menuBar);
    }

    private void setDateRange() {
        JLabel fromLabel = new JLabel("시작 일자");
        fromLabel.setBounds(55, 103, 70, 15);
        contentPane.add(fromLabel);

        JTextField dateFrom = new JTextField(10);
        dateFrom.setBounds(126, 100, 100, 23);
        dateFrom.setText("yyyy-dd-mm");
        contentPane.add(dateFrom);

        JLabel toLabel = new JLabel("종료 일자");
        toLabel.setBounds(250, 103, 70, 15);
        contentPane.add(toLabel);

        JTextField dateTo = new JTextField(10);
        dateTo.setBounds(321, 100, 100, 23);
        dateTo.setText("yyyy-dd-mm");
        contentPane.add(dateTo);
    }

    private JMenu getSettingMenuOnMenuBar() {
        JMenu settingMenu = new JMenu("Setting");

        // 설정 메뉴 생성
        settingMenu.add(new JMenuItem("새 파일"));
        settingMenu.getItem(0).setAccelerator
                (KeyStroke.getKeyStroke('N', InputEvent.CTRL_MASK ^ InputEvent.ALT_MASK)); //단축키설정
        settingMenu.add(new JMenuItem("열기"));
        settingMenu.add(new JMenuItem("저장"));
        settingMenu.addSeparator(); //구분선 추가
        settingMenu.add(new JMenuItem("종료"));

        return settingMenu;
    }

    private void setUserDataFile() {
        JLabel lblNewLabel = new JLabel("사원 정보");
        lblNewLabel.setBounds(55, 42, 70, 15);
        contentPane.add(lblNewLabel);

        JButton readFileBtn = new JButton("파일 열기");
        readFileBtn.setBounds(499, 39, 120, 23);
        contentPane.add(readFileBtn);

        JTextField txtFileName = new JTextField();
        readFileBtn.addActionListener(e -> txtFileName.setText(readFilePath()));
        txtFileName.setBounds(126, 40, 361, 21);
        contentPane.add(txtFileName);
        txtFileName.setColumns(10);
    }

    private void setHistoryFile() {
        JLabel lblNewLabel = new JLabel("이용 내역");
        lblNewLabel.setBounds(55, 72, 70, 15);
        contentPane.add(lblNewLabel);

        JButton readFileBtn = new JButton("파일 열기");
        readFileBtn.setBounds(499, 69, 120, 23);
        contentPane.add(readFileBtn);

        JTextField txtFileName = new JTextField();
        readFileBtn.addActionListener(e -> txtFileName.setText(readFilePath()));
        txtFileName.setBounds(126, 70, 361, 21);
        contentPane.add(txtFileName);
        txtFileName.setColumns(10);
    }

    private String readFilePath() {
        JFileChooser jfc = new JFileChooser();
        if (jfc.showOpenDialog(FileView.this) == JFileChooser.APPROVE_OPTION) {
            return jfc.getSelectedFile().toString();
        }
        return null;
    }
}