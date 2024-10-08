import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PokemonGUI {
    private Pokemon[] pokedex;
    public PokemonGUI(Pokemon[] pokedex) {
        this.pokedex = pokedex;

        // Janela Principal
        JFrame frame = new JFrame("Pokedex");
        frame.setSize(400,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Painel
        JPanel panel = new JPanel();
        panel.setBackground(Color.RED);
        frame.add(panel);
        placeComponents(panel);
        //Exibir a janela
        frame.setVisible(true);
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        //Campo User Input
        JLabel userLabel = new JLabel("Enter Pokemon Name:");
        userLabel.setBounds(10, 20, 150, 25);
        panel.add(userLabel);

        JTextField userText = new JTextField(20);
        userText.setBounds(160, 20, 165, 25);
        panel.add(userText);

        //Search Button
        JButton searchButton = new JButton("Search");
        searchButton.setBounds(160, 60, 100, 25);
        panel.add(searchButton);

        //Label for Search result
        JLabel resultLabel = new JLabel("");
        resultLabel.setForeground(Color.black);
        resultLabel.setBounds(10, 100, 350, 25);
        panel.add(resultLabel);

        //Search Button function
        searchButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String pokemonName = userText.getText();
                boolean found = false;

                for (Pokemon p : pokedex) {
                    if (p.pokemonName.equalsIgnoreCase(pokemonName)) {
                        resultLabel.setText(p.pokemonName + " is a " + p.pokemonType + " Pokémon at level " + p.pokemonLevel);
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    resultLabel.setText("Pokémon not found in the Pokédex.");
                }
            }
        });
    }
    public static void main(String[] args) {
        Pokemon[] pokedex={
                new Pokemon("Bulbasaur", "Grass, Poison", 5),
                new Pokemon("Ivysaur", "Grass, Poison", 16),
                new Pokemon("Venusaur", "Grass, Poison", 32),
                new Pokemon("Charmander", "Fire", 5),
                new Pokemon("Charmeleon", "Fire", 16),
                new Pokemon("Charizard", "Fire", 32),
                new Pokemon("Squirtle", "Water", 5),
                new Pokemon("Wartortle", "Water", 16),
                new Pokemon("Blastoise", "Water", 32)
        };
        new PokemonGUI(pokedex);
    }
}
