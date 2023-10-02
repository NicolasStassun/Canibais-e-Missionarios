import java.util.ArrayList;
import java.util.List;

public class Barco {

    Jogo jogo;
    private final List<Personagem> personagemsNoBarco = new ArrayList<>();
    private Margem margemOndeEsta;

    public Barco(Jogo jogo){
        this.jogo = jogo;
        this.margemOndeEsta = jogo.inicio;
    }

    void entraNoBarco(Personagem personagem) throws BarcoCheioException {
        if (personagemsNoBarco.size() < 2){
            personagemsNoBarco.add(personagem);
            margemOndeEsta.saiDaMargem(personagem);
        }
        else{
            throw new BarcoCheioException();
        }
    }
    void saiDoBarco(Margem margem){
        for (Personagem personagem:
             personagemsNoBarco) {
            margem.getPersonagemsNaMargem().add(personagem);
        }
        personagemsNoBarco.removeAll(personagemsNoBarco);
    }
    void retiraDoBarco(Margem margem, Personagem personagem) throws BarcoVazioException{
        personagemsNoBarco.remove(personagem);
        margem.getPersonagemsNaMargem().add(personagem);
        if (personagemsNoBarco.size() == 0){
            throw new BarcoVazioException();
        }
    }
    void moverBarco() throws SemPilotoException{
        if(personagemsNoBarco.size() >= 1){
            if (margemOndeEsta.equals(jogo.inicio)){
                margemOndeEsta = jogo.fim;
                saiDoBarco(this.margemOndeEsta);
            }
            else{
                margemOndeEsta = jogo.inicio;
                saiDoBarco(this.margemOndeEsta);
            }
        }
        else {
            throw new SemPilotoException();
        }
    }

    public Margem getMargemOndeEsta() {
        return margemOndeEsta;
    }

    public void setMargemOndeEsta(Margem margemOndeEsta) {
        this.margemOndeEsta = margemOndeEsta;
    }

    public List<Personagem> getPersonagemsNoBarco() {
        return personagemsNoBarco;
    }
}