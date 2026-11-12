class Solution {
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        val invertedBoard = Array<CharArray>(9) { CharArray(9) { '.' }}
        val squaresByBoard = Array<CharArray>(9) { CharArray(9) { '.' }}

        // fill invertedBoard
        for (rowIndex in 0 until board.size) {
            for (colIndex in 0 until board[rowIndex].size) {
                invertedBoard[colIndex][rowIndex] = board[rowIndex][colIndex]

                val squareRow = rowIndex / 3
                val squareCol = colIndex / 3
                val squareIndex = squareRow * 3 + squareCol
                val localRow = rowIndex % 3
                val localCol = colIndex % 3
                val position = localRow * 3 + localCol

                squaresByBoard[squareIndex][position] = board[rowIndex][colIndex]
            }
        }

        if (!hasNoDuplicates(board)) return false
        if (!hasNoDuplicates(invertedBoard)) return false
        if (!hasNoDuplicates(squaresByBoard)) return false

        return true
    }

    
    fun hasNoDuplicates(board: Array<CharArray>): Boolean {
        for (arr in board) {
            val foundDigits: MutableSet<Char> = mutableSetOf()
            for (elem in arr) {
                if (elem in '1'..'9') {
                    if (elem in foundDigits) return false
                    else foundDigits.add(elem)
                }
            }
        }
        return true
    }
}
