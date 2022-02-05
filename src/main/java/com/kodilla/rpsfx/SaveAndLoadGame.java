package com.kodilla.rpsfx;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class SaveAndLoadGame {

    final File savedHashMap = new File("save.list");
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
            }
            ois.close();
        } catch(Exception e) {
            System.out.println("Error: " +e);
        }
    }
}
