package com.kodilla.rpsfx;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class SaveGame {

    File savedHashMap = new File("save.list");
    Map<Integer, Game> map = new HashMap<>();

    public void saveGame(Integer s, Game game) {
        Map<Integer, Game> currentMap = new HashMap<>();
        currentMap.put(s, game);
        try{
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(savedHashMap));
            oos.writeObject(currentMap);
            oos.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public void loadGame() {
        try{
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(savedHashMap));
            Object readMap = ois.readObject();
            if (readMap instanceof HashMap) {
                map.putAll((HashMap) readMap);
                this.map = (Map<Integer, Game>) readMap;
                for(Map.Entry<Integer, Game> entry:map.entrySet()) {
                    Game game = new Game(0, 0, 0, "", 0);
                    game.setNumberOfPlayerWins(entry.getValue().getNumberOfPlayerWins());
                    game.setNumberOfComputerWins(entry.getValue().getNumberOfComputerWins());
                    game.setNumberOfWinsToEnd(entry.getValue().getNumberOfWinsToEnd());
                    game.setNumberOfRounds(entry.getValue().getNumberOfRounds());
                    game.setPlayerName(entry.getValue().getPlayerName());
                }
            }
            ois.close();
        } catch(Exception e) {
            System.out.println("Error: " +e);
        }
    }
}
