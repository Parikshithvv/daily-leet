class Solution {
public:
    bool check(int r, int c, vector<vector<char>>& board) {
        char symbol = board[r][c];

        for (int i = 0; i < 3; i++) {
            if (board[r][i] != symbol) break;
            if (i == 2) return true;
        }

        for (int i = 0; i < 3; i++) {
            if (board[i][c] != symbol) break;
            if (i == 2) return true;
        }

        if (r == c) {
            for (int i = 0; i < 3; i++) {
                if (board[i][i] != symbol) break;
                if (i == 2) return true;
            }
        }

        if (r + c == 2) {
            for (int i = 0; i < 3; i++) {
                if (board[i][2 - i] != symbol) break;
                if (i == 2) return true;
            }
        }

        return false;
    }

    bool place(vector<vector<char>>& board, vector<int> temp, int turn) {
        int x = temp[0];
        int y = temp[1];

        board[x][y] = (turn == 1) ? 'X' : 'Y';

        if (check(x, y, board)) return true;

        return false;
    }

    string tictactoe(vector<vector<int>>& moves) {
        vector<vector<char>> board(3, vector<char>(3, '.'));

        int turn = 1;

        for (auto it : moves) {
            if (place(board, it, turn)) {
                if (turn) return "A";
                else return "B";
            }
            turn = !turn;
        }

        if (moves.size() == 9) return "Draw";

        return "Pending";
    }
};