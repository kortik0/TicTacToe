private var board = Board(0)
private var player1 = "X"
private var player2 = "O"

private var currentPlayer = ""

fun main() {
    println("Please enter size of board!")

    val size = readln().toInt()

    board = Board(size)
    board.printBoard()

    while (!board.isGameOver) {
        takeTurns()
        println("current player: $currentPlayer")
        println("Enter row number: ")
        val row = readln().toInt()

        println("Enter col number: ")
        val col = readln().toInt()

        board.placePiece(row - 1, col - 1, currentPlayer)
        if (board.isGameOver) {
            println("Do you want play again? Y/n")
            val answer = readln()
            if (answer.lowercase() == "y") {
                board.resetGame()
            }
        }
    }

    board.placePiece(0,0, "X")
}

fun takeTurns() {
    currentPlayer = if (player1 == currentPlayer) {
        player2
    } else {
        player1
    }
}