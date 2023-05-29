#include <iostream>
#include <vector>
#include <queue>
#include <unordered_map>

using namespace std;

// Structure to represent a state of the puzzle
struct PuzzleState {
    vector<vector<int>> board;
    int heuristic;
    int cost;
    string path;

    PuzzleState(vector<vector<int>> _board, int _heuristic, int _cost, string _path)
        : board(_board), heuristic(_heuristic), cost(_cost), path(_path) {}
};

// Function to calculate the Manhattan distance heuristic
int calculateHeuristic(vector<vector<int>>& board, vector<vector<int>>& goal) {
    int distance = 0;
    int n = board.size();
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            int value = board[i][j];
            if (value != 0) {
                for (int x = 0; x < n; x++) {
                    for (int y = 0; y < n; y++) {
                        if (value == goal[x][y]) {
                            distance += abs(i - x) + abs(j - y);
                        }
                    }
                }
            }
        }
    }
    return distance;
}

// Function to check if the current state is the goal state
bool isGoalState(vector<vector<int>>& board, vector<vector<int>>& goal) {
    return board == goal;
}

// Function to get the next possible states from the current state
vector<vector<vector<int>>> getNextStates(vector<vector<int>>& board) {
    vector<vector<vector<int>>> nextStates;
    int n = board.size();
    int dx[] = {-1, 1, 0, 0};
    int dy[] = {0, 0, -1, 1};

    // Find the position of the empty tile (0)
    int emptyX, emptyY;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if (board[i][j] == 0) {
                emptyX = i;
                emptyY = j;
                break;
            }
        }
    }

    // Generate next states by moving the empty tile
    for (int i = 0; i < 4; i++) {
        int newX = emptyX + dx[i];
        int newY = emptyY + dy[i];
        if (newX >= 0 && newX < n && newY >= 0 && newY < n) {
            vector<vector<int>> nextState = board;
            swap(nextState[emptyX][emptyY], nextState[newX][newY]);
            nextStates.push_back(nextState);
        }
    }

    return nextStates;
}

// A* algorithm to solve the 8-puzzle problem
string solvePuzzle(vector<vector<int>>& initial, vector<vector<int>>& goal) {
    int n = initial.size();
    priority_queue<PuzzleState*, vector<PuzzleState*>, function<bool(PuzzleState*, PuzzleState*)>> pq(
        [](PuzzleState* a, PuzzleState* b) { return a->cost + a->heuristic > b->cost + b->heuristic; });

    unordered_map<string, bool> visited;

    PuzzleState* initialState = new PuzzleState(initial, calculateHeuristic(initial, goal), 0, "");
    pq.push(initialState);

    while (!pq.empty()) {
        PuzzleState* currState = pq.top();
        pq.pop();

        visited[currState->path] = true;

        if (isGoalState(currState->board, goal)) {
            return currState->path;
        }

        vector<vector<vector<int>>> nextStates = getNextStates(currState->board);
        for (auto nextState : nextStates) {
            string nextStatePath = currState->path;
            nextStatePath += to_string(nextState[0][0]);

            if (!visited[nextStatePath]) {
                PuzzleState* newState = new PuzzleState(nextState, calculateHeuristic(nextState, goal), currState->cost + 1, nextStatePath);
                pq.push(newState);
            }
        }
    }

    return "No solution found.";
}

// Function to print the puzzle board
void printBoard(vector<vector<int>>& board) {
    int n = board.size();
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            cout << board[i][j] << " ";
        }
        cout << endl;
    }
    cout << endl;
}

int main() {
    int n = 3;  // Size of the puzzle board

    // User input for the initial state
    cout << "Enter the initial state of the puzzle:" << endl;
    vector<vector<int>> initial(n, vector<int>(n));
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            cin >> initial[i][j];
        }
    }

    // User input for the goal state
    cout << "Enter the goal state of the puzzle:" << endl;
    vector<vector<int>> goal(n, vector<int>(n));
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            cin >> goal[i][j];
        }
    }

    cout << "Solving the puzzle..." << endl;

    string solution = solvePuzzle(initial, goal);

    if (solution != "No solution found.") {
        cout << "Solution found!" << endl;
        cout << "Steps to reach the goal state:" << endl;
        cout << solution << endl;
    } else {
        cout << "No solution found." << endl;
    }

    return 0;
}