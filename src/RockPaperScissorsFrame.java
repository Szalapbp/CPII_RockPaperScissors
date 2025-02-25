import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RockPaperScissorsFrame extends JFrame
{
    JPanel mainPnl, topPnl, middlePnl, statsPnl, buttonPnl;
    JLabel rpsLabel, cpuLabel, playerLabel, tieLabel, playLabel;
    JTextArea rpsArea;
    JButton quitBtn, rockBtn, paperBtn, scissorsBtn;
    JTextField playerField, cpuField, tieField;
    ImageIcon rockIcon, paperIcon, scissorsIcon;

    int playerWins = 0;
    int cpuWins = 0;
    int ties = 0;



    public RockPaperScissorsFrame()
    {
        mainPnl = new JPanel();
        mainPnl.setLayout(new BorderLayout());
        add(mainPnl);
        createTopPanel();
        createMiddlePanel();
        createStatsPanel();

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

    public void createTopPanel()
    {
        topPnl = new JPanel();
        topPnl.setLayout(new BorderLayout());
        buttonPnl = new JPanel();
        buttonPnl.setLayout(new GridLayout(1,3));
        rpsLabel = new JLabel("Rock Paper Scissors");

        rockIcon = new ImageIcon(new ImageIcon("src/Rock.jpg")
                .getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));
        paperIcon = new ImageIcon(new ImageIcon("src/Paper.jpg")
                .getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));
        scissorsIcon = new ImageIcon(new ImageIcon("src/Scissors.jpg")
                .getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));

        rockBtn = new JButton("Rock", rockIcon);
        paperBtn = new JButton("Paper", paperIcon);
        scissorsBtn = new JButton("Scissors", scissorsIcon);

        rockBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                playGame("Rock");
            }
        });

        paperBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                playGame("Paper");
            }
        });

        scissorsBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                playGame("Scissors");
            }
        });
        topPnl.add(rpsLabel, BorderLayout.NORTH);
        rpsLabel.setFont(new Font("Arial", Font.BOLD, 30));
        topPnl.add(buttonPnl, BorderLayout.SOUTH);

        buttonPnl.add(rockBtn);
        rockBtn.setFont(new Font("Serif", Font.PLAIN, 15));
        buttonPnl.add(paperBtn);
        paperBtn.setFont(new Font("Serif", Font.PLAIN, 15));
        buttonPnl.add(scissorsBtn);
        scissorsBtn.setFont(new Font("Serif", Font.PLAIN, 15));

        mainPnl.add(topPnl, BorderLayout.NORTH);
    }

    public void createMiddlePanel()
    {
        middlePnl = new JPanel();
        middlePnl.setLayout(new BorderLayout());

        playLabel = new JLabel("Select a Move to Play a Round");

        rpsArea = new JTextArea();
        rpsArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(rpsArea);

        middlePnl.add(playLabel, BorderLayout.NORTH);
        playLabel.setFont(new Font("Arial", Font.BOLD, 20));
        middlePnl.add(scrollPane, BorderLayout.CENTER);
        rpsArea.setFont(new Font("Serif", Font.PLAIN, 30));
        rpsArea.setBackground(Color.LIGHT_GRAY);
        mainPnl.add(middlePnl, BorderLayout.CENTER);

    }

    public void createStatsPanel(){
        statsPnl = new JPanel();
        statsPnl.setLayout(new GridLayout(2,4 ));

        playerLabel = new JLabel("Player Wins");
        cpuLabel = new JLabel("CPU Wins");
        tieLabel = new JLabel("Ties");
        quitBtn = new JButton("Quit");

        quitBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        });

        playerField = new JTextField(10);
        playerField.setEditable(false);
        cpuField = new JTextField(10);
        cpuField.setEditable(false);
        tieField = new JTextField(10);
        tieField.setEditable(false);

        statsPnl.add(playerLabel);
        playerLabel.setFont(new Font("Monospaced", Font.PLAIN, 20));
        statsPnl.add(cpuLabel);
        cpuLabel.setFont(new Font("Monospaced", Font.PLAIN, 20));
        statsPnl.add(tieLabel);
        tieLabel.setFont(new Font("Monospaced", Font.PLAIN, 20));
        statsPnl.add(quitBtn);
        quitBtn.setFont(new Font("Monospaced", Font.BOLD, 20));
        statsPnl.add(playerField);
        playerField.setFont(new Font("Monospaced", Font.BOLD, 15));
        statsPnl.add(cpuField);
        cpuField.setFont(new Font("Monospaced", Font.BOLD, 15));
        statsPnl.add(tieField);
        tieField.setFont(new Font("Monospaced", Font.BOLD, 15));
        mainPnl.add(statsPnl, BorderLayout.SOUTH);
    }

    private void playGame(String playerChoice) {
        String[] options = {"Rock", "Paper", "Scissors"};
        String cpuChoice = options[(int)(Math.random()* 3)];
        String result;

        if(playerChoice.equals(cpuChoice)){
            result = "It's a tie!";
            ties ++;
        }
        else if(playerChoice.equals("Rock") && cpuChoice.equals("Scissors") ||
        playerChoice.equals("Paper") && cpuChoice.equals("Rock") ||
        playerChoice.equals("Scissors") && cpuChoice.equals("Paper")) {
            result = "Player Wins";
            playerWins ++;
        }
        else{
            result = "CPU Wins";
            cpuWins ++;
        }

        playerField.setText(String.valueOf(playerWins));
        cpuField.setText(String.valueOf(cpuWins));
        tieField.setText(String.valueOf(ties));

        rpsArea.append("The Player Chose " + playerChoice + " and the CPU Chose "
        + cpuChoice + "           "+ result +"!" + "\n\n");




    }




}
