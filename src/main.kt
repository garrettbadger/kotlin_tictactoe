
class Board(){
    fun createBoard(boardPieces: MutableList<Char>){
        println("\n Tic Tac Toe \n")
        println("Player 1 (X)  -  Player 2 (O)")
        println("     |     |     ")
        println(" ${boardPieces.elementAt(0)}   |  ${boardPieces.elementAt(1)}  |   ${boardPieces.elementAt(2)}")
        println("_____|_____|_____")
        println("     |     |     ")
        println(" ${boardPieces.elementAt(3)}   |  ${boardPieces.elementAt(4)}  |   ${boardPieces.elementAt(5)}")
        println("_____|_____|_____")
        println("     |     |     ")
        println(" ${boardPieces.elementAt(6)}   |  ${boardPieces.elementAt(7)}  |   ${boardPieces.elementAt(8)}")
        println("     |     |     ")
    }
    fun checkWin(boardPieces: MutableList<Char>, player: Char): Char{
        var playerWin = 'n'
        var testForTie = 0

        if(boardPieces[0] == boardPieces[1] && boardPieces[1] == boardPieces[2])
        {
            playerWin = player
        }
        else if(boardPieces[0] == boardPieces[3] && boardPieces[3] == boardPieces[6])
        {
            playerWin = player
        }
        else if(boardPieces[0] == boardPieces[4] && boardPieces[4] == boardPieces[8])
        {
            playerWin = player
        }
        else if(boardPieces[1] == boardPieces[4] && boardPieces[4] == boardPieces[7])
        {
            playerWin = player
        }
        else if(boardPieces[2] == boardPieces[4] && boardPieces[4] == boardPieces[6])
        {
            playerWin = player
        }
        else if(boardPieces[2] == boardPieces[5] && boardPieces[5] == boardPieces[8])
        {
            playerWin = player
        }
        else if(boardPieces[3] == boardPieces[4] && boardPieces[4] == boardPieces[5])
        {
            playerWin = player
        }
        else if(boardPieces[6] == boardPieces[7] && boardPieces[7] == boardPieces[8])
        {
            playerWin = player
        }
        else
        {

            for(i in 0..8)
            {
                if(boardPieces[i] == 'x' || boardPieces[i] == 'o' || boardPieces[i] == 'X' || boardPieces[i] == 'O')
                {
                    testForTie++
                }
            }

            if(testForTie == 9)
            {

                playerWin = 't'
            }
        }

        if(playerWin == player)
        {
            if(player == 'X')
            {
                println("\n\nCongratulations player 1!  You Win!")
            }
            else
            {
                println("Congratulations player 2!  You Win!")
            }
        }
        else if(playerWin == 't')
        {
            println("Tie!  You should play again to settle the duel!")
        }

        return(playerWin)

    }
}
class Player(){
    fun getMove(boardPieces: MutableList<Char>, player: Char){
        var playerMoveFound = false
        var playerTurn = '0'
        var playerMove = '0'
        if (player == 'X'){
            playerTurn = '1'
        }
        else{playerTurn = '2'}
        while(playerMoveFound == false){
            print("Player $playerTurn please make a move: ")
            var move = readLine()!![0]

            playerMove = move
            for (i in 0..8){
                if(playerMove == boardPieces[i] && playerMove != 'X' && playerMove != 'O' && playerMove != 'x' && playerMove != 'o')
                {
                     boardPieces[i] = player

                    playerMoveFound = true
                }
            }
            if (playerMoveFound == false){
                println("Invalid player move...")
            }
        }
    }
    fun togglePlayer(player: Char):Char{
        var player = player
        if (player == 'X'){
            player = 'O'
        }
        else{player = 'X'}
        return(player)
    }
    fun getUserPlay():Boolean{
        var response:Char
        var invalidResponse = true
        var play = false
        while (invalidResponse == true){
            print("Would you like to play a new game of TicTacToe? (y/n) ")
            response = readLine()!![0]
            if (response == 'y'){
                invalidResponse = false
                play = true
            }
            else if (response == 'n'){
                println("No problem!")
                invalidResponse = false
            }
            else{println("Please input a proper response, either 'y' or 'n'")}
        }
        return(play)
    }
}




fun main(){

    val board = Board()
    val player = Player()
    var play = false
    play = player.getUserPlay()
    var gamer = 'X'

    while (play == true){
        var playerWinner = 'n'
        var boardPieces = mutableListOf('1', '2', '3', '4', '5', '6', '7', '8', '9')
        while (playerWinner == 'n'){

            board.createBoard(boardPieces)
            player.getMove(boardPieces, gamer)
            playerWinner = board.checkWin(boardPieces, gamer)

            if (playerWinner == 'n'){
                gamer = player.togglePlayer(gamer)
            }
        }
        board.createBoard(boardPieces)
        play = player.getUserPlay()
    }

}