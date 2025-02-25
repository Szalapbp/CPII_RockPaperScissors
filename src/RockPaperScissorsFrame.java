import javax.swing.*;
import java.awt.*;

public class RockPaperScissorsFrame extends JFrame
{
    JPanel mainPnl, topPnl, middlePnl, bottomPnl;
    JLabel rpsLabel;
    JTextArea rpsArea;
    JButton quitBtn, rockBtn, paperBtn, scissorsBtn;


    public RockPaperScissorsFrame()
    {
        mainPnl = new JPanel();
        mainPnl.setLayout(new BorderLayout());
        add(mainPnl);
        createTopPanel();
        createMiddlePanel();
        createBottomPanel();

        setTitle("Rock Paper Scissors Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        int screenH = screenSize.height;
        int screenW = screenSize.width;
        int frameH = screenH * 3/4;
        int frameW = screenW * 3/4;

        setSize(frameW, frameH);
        setLocation((screenW - frameW) / 2, (screenH - frameH) / 2);
    }

    public void createTopPanel(){

    }

    public void createMiddlePanel(){

    }

    public void createBottomPanel(){

    }
}
