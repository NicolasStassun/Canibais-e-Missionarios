import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static final List<Personagem> personagems = new ArrayList<>();
    static Jogo jogo = new Jogo();

    public static void main(String[] args) {

        addBonecos();
        for (int i = 0; i < personagems.size();i++){
            jogo.inicio.getPersonagemsNaMargem().add(personagems.get(i));
        }

        boolean jogoTerminou;
        do {
           jogoTerminou = jogo.verificaJogo();
           boolean trocouDeLado = false;
           do {
               jogo.imprimeJogo();
               System.out.println("""
                       1 - Adicionar ao barco
                       2 - Retirar do barco
                       3 - Trocar de lado
                       """);
               int opcao = sc.nextInt();
               switch (opcao){
                   case 1:
                       System.out.println("Informe o id do personagem");
                       int idPersonagemAdicionar = sc.nextInt();
                       try{
                           jogo.barco.entraNoBarco(retornaPersonagemPorId(idPersonagemAdicionar,(ArrayList<Personagem>)jogo.barco.getMargemOndeEsta().getPersonagemsNaMargem()));
                       }catch (BarcoCheioException | IdInexistenteException e){
                           System.out.println(e.getMessage());
                       }
                       break;
                   case 2:
                       System.out.println("Informe o id do personagem");
                       int idPersonagemRetirar = sc.nextInt();
                       try{
                           jogo.barco.retiraDoBarco(jogo.barco.getMargemOndeEsta(), retornaPersonagemPorId(idPersonagemRetirar,(ArrayList<Personagem>)jogo.barco.getPersonagemsNoBarco()));
                       }catch (BarcoVazioException | IdInexistenteException e){
                           System.out.println(e.getMessage());
                       }
                       break;
                   case 3:
                           jogo.moveBarco();
                           trocouDeLado = !trocouDeLado;
                       break;
                   default:
                       System.out.println("Opção inválida");
                       break;
               }
           }while(!trocouDeLado);

        }while (!jogoTerminou);

    }
    public static void addBonecos (){

        personagems.add(new Missionario());
        personagems.add(new Missionario());
        personagems.add(new Missionario());
        personagems.add(new Canibal());
        personagems.add(new Canibal());
        personagems.add(new Canibal());
    }
    public static Personagem retornaPersonagemPorId(int id, ArrayList<Personagem> lista) throws IdInexistenteException{
        for (Personagem personagem:
             lista) {
            if (personagem.id == id){
                return personagem;
            }
        }
        throw new IdInexistenteException();
    }

}