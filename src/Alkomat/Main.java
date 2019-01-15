package Alkomat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 * Created by Paweł Tomasiewicz on 15.01.2019
 */

public class Main extends JFrame {

    private JPanel panelRoot;
    private JPanel panelTop;
    private JPanel panelBottom;
    private JButton buttonWoman;
    private JButton buttonMan;
    private JButton calculate;
    private ImageIcon icon1;
    private ImageIcon icon2;
    private JLabel weightLabel;
    private JLabel empty;
    private JLabel infoTitle;
    private JLabel wineLabel;
    private JLabel beerLabel;
    private JLabel vodkaLabel;
    private JTextField weightTextField;
    private boolean pressedWoman = false;
    private boolean pressedMan = false;
    private boolean pressedWineList = false;
    private boolean pressedBeerList = false;
    private boolean pressedVodkaList = false;
    private JComboBox wineList;
    private JComboBox beerList;
    private JComboBox vodkaList;
    private String dialogs;
    private String text;
    private int resultWine;
    private int resultBeer;
    private int resultVodka;

    private double alcoholInBlood;        // quantity of alcohol in blood - in promils;
    private double woman;                 // constant ratio, which for women is 0,6;
    private double man;                   // constant ratio, which for men is 0,7;
    private double weight;                // weight of body in kg.

    private double wine = 16.8;           // 175 ml of wine (a glass of wine) 12% it is 21 ml/16,8 g of alcohol,
    private double vodka = 16;            // 50 ml of vodka 40% it is 20 ml/16 g of alcohol,
    private double beer = 18;             // 500 ml of beer (a big beer) 4,5% it is 22,5 ml/18 g of alcohol,

    private Main()
    {
        super("Alkomat");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setBounds(350, 250, 440, 400);

        creation();
        setActionListener();
        setBorders();
        setFonts();
    }

    private void creation()
    {
        String[] quantityOfVodka = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        String[] quantityOfWine = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        String[] quantityOfBeer = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};

        vodkaList = new JComboBox(quantityOfVodka);
        wineList = new JComboBox(quantityOfWine);
        beerList = new JComboBox(quantityOfBeer);

        icon2 = new ImageIcon("icon2.png");
        icon1 = new ImageIcon("icon1.png");

        buttonWoman = new JButton("", icon2);
        buttonMan = new JButton("", icon1);
        calculate = new JButton("Oblicz");

        panelRoot = new JPanel(new GridLayout(5, 1));
        panelTop = new JPanel();
        panelBottom = new JPanel();

        this.getContentPane().add(panelRoot);
        this.add(panelTop, BorderLayout.PAGE_START);
        this.add(panelBottom, BorderLayout.PAGE_END);

        panelBottom.add(calculate);
        panelTop.add(buttonWoman, BorderLayout.WEST);
        panelTop.add(buttonMan, BorderLayout.EAST);

        panelRoot.add(weightLabel = new JLabel("Waga w kg"));
        panelRoot.add(weightTextField = new JTextField());
        panelRoot.add(empty = new JLabel(" "));
        panelRoot.add(infoTitle = new JLabel("Ilość lampek / kufli / kieliszków"));
        panelRoot.add(wineLabel = new JLabel("Wino (175 ml)"));
        panelRoot.add(wineList);
        panelRoot.add(beerLabel = new JLabel("Piwo (500 ml)"));
        panelRoot.add(beerList);
        panelRoot.add(vodkaLabel = new JLabel("Wódka (50 ml)"));
        panelRoot.add(vodkaList);

        calculate.setPreferredSize(new Dimension(420, 30));
    }

    private void setActionListener()
    {
        buttonWoman.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                pressedWoman = true;
                woman = 0.6;
            }
        });

        buttonMan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                pressedMan = true;
                man = 0.7;
            }
        });

        vodkaList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                pressedVodkaList = true;
                resultVodka = vodkaList.getSelectedIndex();
            }
        });

        wineList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                pressedWineList = true;
                resultWine = wineList.getSelectedIndex();
            }
        });

        beerList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                pressedBeerList = true;
                resultBeer = beerList.getSelectedIndex();
            }
        });

        calculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if (pressedWoman && pressedVodkaList)
                {
                    text = weightTextField.getText();
                    weight = Double.parseDouble(text);
                    alcoholInBlood = ((resultVodka * vodka) / (woman * weight));

                    infoDialog();
                    infoWindow();
                }
                if (pressedWoman && pressedBeerList)
                {
                    text = weightTextField.getText();
                    weight = Double.parseDouble(text);
                    alcoholInBlood = (resultBeer * beer) / (woman * weight);

                    infoDialog();
                    infoWindow();
                }
                if (pressedWoman && pressedWineList)
                {
                    text = weightTextField.getText();
                    weight = Double.parseDouble(text);
                    alcoholInBlood = (resultWine * wine) / (woman * weight);

                    infoDialog();
                    infoWindow();
                }
                if (pressedMan && pressedVodkaList)
                {
                    text = weightTextField.getText();
                    weight = Double.parseDouble(text);
                    alcoholInBlood = (resultVodka * vodka) / (man * weight);

                    infoDialog();
                    infoWindow();
                }
                if (pressedMan && pressedBeerList)
                {
                    text = weightTextField.getText();
                    weight = Double.parseDouble(text);
                    alcoholInBlood = (resultBeer * beer) / (man * weight);

                    infoDialog();
                    infoWindow();
                }
                if (pressedMan && pressedWineList)
                {
                    text = weightTextField.getText();
                    weight = Double.parseDouble(text);
                    alcoholInBlood = (resultWine * wine) / (man * weight);

                    infoDialog();
                    infoWindow();
                }
            }
        });
    }

    private void infoWindow()
    {
        JOptionPane optionPane = new JOptionPane();
        optionPane.setMessage(dialogs);
        optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
        JDialog dialog = optionPane.createDialog(null, "Wynik");
        dialog.setVisible(true);
    }

    public void infoDialog()
    {
        dialogs = new String();

        if (alcoholInBlood < 0.2)
        {
            dialogs = "Zawartość promili we krwi to : " + alcoholInBlood +
                    " \n \n stan po spożyciu alkoholu – pomiędzy 0,2‰  i 0,5‰ jest dopuszczalny w Polsce aby prowadzić samochód " +
                    " \n \n poniżej 0.2 promila – występuje dopuszcalna norma alkocholu we krwi";
        }
        if (alcoholInBlood < 0.5 && alcoholInBlood > 0.3)
        {
            dialogs = "Zawartość promili we krwi to : " + alcoholInBlood +
                    " \n \n stan po spożyciu alkoholu – pomiędzy 0,2‰  i 0,5‰ jest dopuszczalny w Polsce aby prowadzić samochód, " +
                    "powyżej 0,3‰ trzeba zachować większą ostrożność " +
                    " \n \n 0,3–0,5 promila – występują zaburzenia widzenia i problemy z koordynacją ruchową, " +
                    "stajemy się mniej spostrzegawczy, popadamy w euforię, która skłania do szybszej i ryzykownej jazdy.";
        }
        if (alcoholInBlood < 0.7 && alcoholInBlood > 0.5)
        {
            dialogs = "Zawartość promili we krwi to : " + alcoholInBlood +
                    " \n \n stan po spożyciu alkoholu – pomiędzy 0,2‰  i 0,5‰ jest dopuszczalny w Polsce aby prowadzić samochód " +
                    " \n \n 0,5–0,7 promila – pogarsza się refleks i błędnie oceniamy własne możliwości.";
        }
        if (alcoholInBlood < 2.0 && alcoholInBlood > 0.7)
        {
            dialogs = "Zawartość promili we krwi to : " + alcoholInBlood +
                    " \n \n stan po spożyciu alkoholu – pomiędzy 0,2‰  i 0,5‰ jest dopuszczalny w Polsce aby prowadzić samochód " +
                    " \n \n 0,7–2 promili – przy takim wyniku tracimy zdolność logicznego myślenia i wyciągania prawidłowych wniosków. " +
                    "Stajemy się drażliwi, łatwo wpadamy w gniew, wzrasta też ciśnienie krwi, przyspiesza praca serca.";
        }
        if (alcoholInBlood < 3.0 && alcoholInBlood > 2.0)
        {
            dialogs = "Zawartość promili we krwi to : " + alcoholInBlood +
                    " \n \n stan po spożyciu alkoholu – pomiędzy 0,2‰  i 0,5‰ jest dopuszczalny w Polsce aby prowadzić samochód " +
                    " \n \n 2-3 promile – odbierają zdolność płynnego mówienia, powodują senność, poważne problemy z koncentracją, " +
                    "utrzymaniem równowagi (chwiejny chód) oraz kontrolą zachowania.";
        }
        if (alcoholInBlood > 3.0)
        {
            dialogs = "Zawartość promili we krwi to : " + alcoholInBlood +
                    " \n \n stan po spożyciu alkoholu – pomiędzy 0,2‰  i 0,5‰ jest dopuszczalny w Polsce aby prowadzić samochód " +
                    " \n \n 3–4 promile – taka zawartość alkoholu powoduje zaburzenia świadomości, spadek temperatury ciała i ciśnienia krwi." +
                    "ponad 4 promile mogą prowadzić do śpiączki, a nawet śmierci.";
        }
    }

    private void setBorders()
    {
        panelRoot.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));
        panelRoot.setBackground(Color.lightGray);
        calculate.setBackground(Color.cyan);
    }

    private void setFonts()
    {
        Font font = new Font("New Roman", Font.BOLD, 15);

        panelBottom.setFont(font);
        calculate.setFont(font);
        weightLabel.setFont(font);
        wineLabel.setFont(font);
        beerLabel.setFont(font);
        vodkaLabel.setFont(font);
        weightTextField.setFont(font);
    }

    public static void main(String[] args) {
        new Main().setVisible(true);
    }
}