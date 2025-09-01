# Java Console Snake Game

A simple **Snake game** implemented in Java using the console (text-based interface).
## GAME PREVIEW
<img width="1214" height="1011" alt="Screenshot (7)" src="https://github.com/user-attachments/assets/3941aeec-c91c-4a80-bd95-8971553818b1" />

**PREVIWE LINK:**
https://www.youtube.com/watch?v=CJ79PfU1sD8


## Features
- **Snake movement** via keyboard input (`W`, `A`, `S`, `D`).
- **Food** spawns randomly on the grid—guaranteed not to appear on the snake’s body.
- **Snake grows** by one unit when food is eaten.
- **Game Over** conditions:
  - Snake collides with the border.
  - Snake runs into itself.
- **Pure Java** implementation—no external libraries required.

## Code Highlights
- Utilizes `LinkedList<int[]>` for dynamic snake body management.
- Custom `generateFood()` method ensures food placement never overlaps the snake.
- `move(char dir)` method handles all movement logic, growth mechanics, and collision checks.
