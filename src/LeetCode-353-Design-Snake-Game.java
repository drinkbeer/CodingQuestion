/*
https://leetcode.com/problems/design-snake-game/discuss/82668/Java-Deque-and-HashSet-design-with-detailed-comments
*/
class SnakeGame {

    Queue<Integer> queue;
    int width;
    int height;
    int row, col;   // the row and col of head position
    int[][] foods;
    int foodIndex;
    
    /** Initialize your data structure here.
        @param width - screen width
        @param height - screen height 
        @param food - A list of food positions
        E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
    public SnakeGame(int width, int height, int[][] food) {
        queue = new LinkedList<>();
        this.width = width;
        this.height = height;
        this.row = 0;
        this.col = 0;
        this.foods = food;
        this.foodIndex = 0;
    }
    
    /** Moves the snake.
        @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down 
        @return The game's score after the move. Return -1 if game over. 
        Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
        switch(direction) {
                case "U": 
                    row--;
                    break;
                case "D":
                    row++;
                    break;
                case "L":
                    col--;
                    break;
                case "R":
                    col++;
                    break;
                default:
                    break;
        }
        
        int head = row * width + col;
        if (queue.contains(head)) {
            return -1;
        }
        
        if (row >= 0 && row < height && col >= 0 && col < width) {
            queue.offer(head);
            if (foodIndex < foods.length && row == foods[foodIndex][0] && col == foods[foodIndex][1]) {
                foodIndex++;
            } else {
                queue.poll();
            }
            return foodIndex;
        }
        return -1;
    }
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */
