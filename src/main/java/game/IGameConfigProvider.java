package game;

import java.util.HashMap;

public interface IGameConfigProvider {

    HashMap<String, HashMap<Character, Double>>  getConfig();

}
