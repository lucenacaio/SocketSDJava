package socketsd.dicionario;

import java.util.HashMap;

/**
 *
 * @author Caio Lucena
 */
public class Dicionario {
    
    private static Dicionario instance;
    private HashMap<String, String> dicionarioMap = new HashMap<>();
    
    
    private Dicionario(){
        dicionarioMap.put("coesão", "Cujas partes estão ligadas harmonicamente entre si: coesão do governo.");
        dicionarioMap.put("perdurar", "Que possui grande durabilidade; que dura muito tempo;");
        dicionarioMap.put("processo", "Ação judicial; procedimentos praticados por um órgão judicial e/ou pelas partes (pessoas), quando há um litígio judicial");
    }
    
    public static Dicionario getInstance(){
        if(instance == null){
            instance = new Dicionario();
        }
        return instance;
    }

    public synchronized  HashMap<String, String> getDicionarioMap() {
        return dicionarioMap;
    }

}
