package rocks.zipcodewilmington.tictactoe;
import java.util.Objects;

/**
 * @author leon on 6/22/18.
 */
public class Board {

    public int horizontal = 0;
    public int vertical = 0;
    public int diagonal = 0;
    public int consecutiveCount = 0;
    public int playerXWin = 0;
    public int playerOWin = 0;
    Character game[][];


    public Board(Character[][] matrix) {
        game = matrix;
    }

    public Boolean isInFavorOfX() {
        int horizontalGate = 0;
        int verticalGate = 0;
        //horizontal
        for(int i = 0; i<game.length; i++){
            for(int j = 0; j<game[0].length;j++){
                if(game[i][j].equals('X')){
                    horizontal += 1;
                    consecutiveCount += 1;
                    if(game[i][1].equals('X')){
                        horizontal += 1;
                        consecutiveCount += 1;
                        if(game[i][2].equals('X')){
                            horizontal += 1;
                            consecutiveCount += 1;
                        }
                    }
                }
                j+=2;
                if(horizontal == 3 && consecutiveCount == 3) {
                    playerXWin += 1;
                    horizontalGate += 1;
                    horizontal = 0;
                    consecutiveCount = 0;
                    break;
                }else{
                    horizontal = 0;
                    consecutiveCount = 0;
                }
            }
        }
        //vertical
        if(horizontalGate == 0){
            for(int i = 0; i<game.length; i++){
                for(int j = 0; j<game[0].length;j++){
                    if(game[i][j].equals('X')) {
                        vertical += 1;
                        consecutiveCount += 1;
                        if(game[1][j].equals('X')){
                            vertical += 1;
                            consecutiveCount += 1;
                            if(game[2][j].equals('X')){
                                vertical += 1;
                                consecutiveCount += 1;
                            }
                        }
                    }else{
                        vertical = 0;
                        consecutiveCount = 0;
                    }
                    if(vertical == 3 && consecutiveCount == 3) {
                        playerXWin += 1;
                        verticalGate += 1;
                        vertical = 0;
                        consecutiveCount = 0;
                        break;
                    }else{
                        vertical = 0;
                        consecutiveCount = 0;
                    }
                }
                i+=2;
            }
        }
        //diagnol
        if(verticalGate == 0){
            for(int i = 0; i<1; i++){
                for(int j = 0; j<game[0].length;j++){
                    if(game[i][j].equals('X')) {
                        diagonal += 1;
                        consecutiveCount += 1;
                        if(game[1][1].equals('X')){
                            diagonal += 1;
                            consecutiveCount += 1;
                            if(game[2][2-j].equals('X')){
                                diagonal += 1;
                                consecutiveCount += 1;
                            }
                        }
                    }else{
                        diagonal = 0;
                        consecutiveCount = 0;
                    }
                    if(diagonal == 3 && consecutiveCount == 3) {
                        playerXWin += 1;
                        verticalGate += 1;
                        diagonal = 0;
                        consecutiveCount = 0;
                        break;
                    }else{
                        diagonal = 0;
                        consecutiveCount = 0;
                    }
                }
            }
        }
        if(playerXWin == 1){
            return true;
        }else{
            return false;
        }
    }

    public Boolean isInFavorOfO() {
        int horizontalGate = 0;
        int verticalGate = 0;
        //horizontal
        for(int i = 0; i<game.length; i++){
            for(int j = 0; j<game[0].length;j++){
                if(game[i][j].equals('O')){
                    horizontal += 1;
                    consecutiveCount += 1;
                    if(game[i][1].equals('O')){
                        horizontal += 1;
                        consecutiveCount += 1;
                        if(game[i][2].equals('O')){
                            horizontal += 1;
                            consecutiveCount += 1;
                        }
                    }
                }
                j+=2;
                if(horizontal == 3 && consecutiveCount == 3) {
                    playerOWin += 1;
                    horizontal = 0;
                    horizontalGate +=1;
                    consecutiveCount = 0;
                    break;
                }else{
                    horizontal = 0;
                    consecutiveCount = 0;
                }
            }
        }
        //vertical
        if(horizontalGate == 0){
            for(int i = 0; i<game.length; i++){
                for(int j = 0; j<game[0].length;j++){
                    if(game[i][j].equals('O')) {
                        vertical += 1;
                        consecutiveCount += 1;
                        if(game[1][j].equals('O')){
                            vertical += 1;
                            consecutiveCount += 1;
                            if(game[2][j].equals('O')){
                                vertical += 1;
                                consecutiveCount += 1;
                            }
                        }
                    }
                }
                if(vertical == 3 && consecutiveCount == 3) {
                    playerOWin += 1;
                    verticalGate += 1;
                    vertical = 0;
                    consecutiveCount = 0;
                    break;
                }else{
                    vertical = 0;
                    consecutiveCount = 0;
                }
                i+=2;
            }
        }
        //diagnol
        if(verticalGate == 0){
            for(int i = 0; i<1; i++){
                for(int j = 0; j<game[0].length;j++){
                    if(game[i][j].equals('O')) {
                        diagonal += 1;
                        consecutiveCount += 1;
                        if(game[1][1].equals('O')){
                            diagonal += 1;
                            consecutiveCount += 1;
                            if(game[2][2-j].equals('O')){
                                diagonal += 1;
                                consecutiveCount += 1;
                            }
                        }
                    }else{
                        diagonal = 0;
                        consecutiveCount = 0;
                    }
                    if(diagonal == 3 && consecutiveCount == 3) {
                        playerOWin += 1;
                        verticalGate += 1;
                        diagonal = 0;
                        consecutiveCount = 0;
                        break;
                    }else{
                        diagonal = 0;
                        consecutiveCount = 0;
                    }
                }
            }
        }
        if(playerOWin == 1){
            return true;
        }else{
            return false;
        }
    }


    public Boolean isTie() {
        isInFavorOfO();
        isInFavorOfX();
        if(playerXWin == playerOWin){
            return true;
        }else{
            return false;
        }
    }

    public String getWinner() {
        isInFavorOfO();
        isInFavorOfX();
        String answer = "";
        if(playerXWin == 1){
            answer = "X";
        }else if(playerOWin == 1) {
            answer = "O";
        }
        return answer;
    }
}
