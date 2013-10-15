package demo.uml;

public class CheckingForWinner {
    static final char KREST = 'x';
    static final char NOLIK = 'o';

    public static boolean checkWinner(char[][] myMassive){

        for(int i = 0; i < 3; i++){
            if(myMassive[i][0] == myMassive[i][1] && myMassive[i][1] == myMassive[i][2] && (myMassive[i][2] == KREST || myMassive[i][2] == NOLIK)) {
                if(myMassive[i][0] == KREST){
                    System.out.println("Победил игрок ходивший крестиками");
                    return true;
                } else {
                    System.out.println("Победил игрок ходивший ноликами");
                    return true;
                }
            } else if(myMassive[0][i] == myMassive[1][i] && myMassive[1][i] == myMassive[2][i] && (myMassive[2][i] == KREST || myMassive[2][i] == NOLIK)){
                if(myMassive[0][i] == KREST) {
                    System.out.println("Победил игрок ходивший крестиками");
                    return true;
                } else {
                    System.out.println("Победил игрок ходивший ноликами");
                    return true;
                }
            }
        }
            if(myMassive[0][0] == myMassive[1][1] && myMassive[1][1] == myMassive[2][2] && (myMassive[2][2] == KREST || myMassive[2][2] == NOLIK) ){
                if(myMassive[0][0] == KREST) {
                    System.out.println("Победил игрок ходивший крестиками");
                    return true;
                } else {
                    System.out.println("Победил игрок ходивший ноликами");
                    return true;
                }
            } else if(myMassive[0][2] == myMassive[1][1] && myMassive[1][1] == myMassive[2][0] && (myMassive[2][0] == KREST || myMassive[2][0] == NOLIK)){
                if(myMassive[0][2] == KREST) {
                    System.out.println("Победил игрок ходивший крестиками");
                    return true;
                } else {
                    System.out.println("Победил игрок ходивший ноликами");
                    return true;
                }
            }
        return false;
    }
}
