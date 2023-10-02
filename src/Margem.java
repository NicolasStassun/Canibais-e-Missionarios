import java.util.ArrayList;
import java.util.List;

public class Margem {

    private final List<Personagem> personagemsNaMargem = new ArrayList<>();
    private int quantidadeMissionario = 0;
    private int quantidadeCanibal = 0;

    boolean verificaMargem() throws MaisCanibaisException {

        calculaQuantidadeNaMargem();
        System.out.println(quantidadeCanibal);
        System.out.println(quantidadeMissionario);
        if (quantidadeMissionario != 0){
            if (quantidadeCanibal <= quantidadeMissionario){
                return true;
            }
            else {
                throw new MaisCanibaisException();
            }
        }
        return false;
    }
    void calculaQuantidadeNaMargem(){
        quantidadeMissionario = 0;
        quantidadeCanibal =0;
        for (Personagem personagem:
                personagemsNaMargem) {
            if (personagem instanceof Canibal){
                quantidadeCanibal++;
            }
            else {
                quantidadeMissionario++;
            }
        }
    }
    void saiDaMargem(Personagem personagem){
        personagemsNaMargem.remove(personagem);
    }

    public List<Personagem> getPersonagemsNaMargem() {
        return personagemsNaMargem;
    }
}
