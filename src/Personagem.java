import java.util.ArrayList;
import java.util.List;

public abstract class Personagem {

    int id;

    public Personagem(){
        criaPersonagem(this);
    }
    void criaPersonagem(Personagem personagem){
        personagem.id = Main.personagems.size()+1;
    }

}