public class Jogo {

    public Margem inicio = new Margem();
    public Margem fim = new Margem();
    Barco barco = new Barco(this);


    boolean verificaJogo(){
        if (fim.getPersonagemsNaMargem().size() == 6){
            System.out.println("Você venceu o jogo");
            return true;
        }
        else {
            try{
                inicio.verificaMargem();
                fim.verificaMargem();
            }catch (MaisCanibaisException e){
                System.out.println(e.getMessage());
                return true;
            }
        }
        return false;
    }
    void moveBarco() {
        try {
            barco.moverBarco();
            if (barco.getMargemOndeEsta().equals(inicio)) {
                barco.saiDoBarco(fim);
                verificaJogo();
            } else {
                barco.saiDoBarco(inicio);
                verificaJogo();
            }
        } catch (SemPilotoException e) {
            System.out.println(e.getMessage());
        }
    }

        void imprimeJogo(){
            System.out.println("--------------------------------------");
            System.out.println("Inicio");
            for (Personagem personagem:
                    inicio.getPersonagemsNaMargem()) {
                if (personagem instanceof Missionario){
                    System.out.println(personagem.id +" - Missionario");
                }
                else {
                    System.out.println(personagem.id +" - Canibal");
                }
            }
            System.out.println("--------------------------------------");
            System.out.println("--------------------------------------");
            System.out.println("Barco");
            for (Personagem personagem:
                    barco.getPersonagemsNoBarco()) {
                if (personagem instanceof Missionario){
                    System.out.println(personagem.id +" - Missionario");
                }
                else {
                    System.out.println(personagem.id +" - Canibal");
                }
            }
            System.out.println("--------------------------------------");
            System.out.println("--------------------------------------");
            System.out.println("Fim");
            for (Personagem personagem:
                    fim.getPersonagemsNaMargem()) {
                if (personagem instanceof Missionario){
                    System.out.println(personagem.id +" - Missionario");
                }
                else {
                    System.out.println(personagem.id +" - Canibal");
                }
            }
            System.out.println("--------------------------------------");

        }


}
