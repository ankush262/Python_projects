import pygame
import random

# Initialize pygame
pygame.init()

# Screen dimensions
width, height = 600, 400

# Colors
white = (255, 255, 255)
black = (0, 0, 0)
red = (213, 50, 80)
green = (0, 255, 0)
blue = (50, 153, 213)
gray = (200, 200, 200)
violet = (204,153,255)

# Snake block size
block_size = 20
# Snake speed
snake_speed = 8

# Fonts
font_style = pygame.font.SysFont(None, 50)
score_font = pygame.font.SysFont(None, 35)

# Display
screen = pygame.display.set_mode((width, height))
pygame.display.set_caption('Snake Game with Grid')

clock = pygame.time.Clock()


def display_score(score):
    value = score_font.render("Score: " + str(score), True, black)
    screen.blit(value, [0, 0])


def draw_snake(block_size, snake_list):
    for x in snake_list:
        pygame.draw.rect(screen, violet, [x[0], x[1], block_size, block_size])


def draw_grid():
    # Draw vertical lines
    for x in range(0, width, block_size):
        pygame.draw.line(screen, white, (x, 0), (x, height))
    # Draw horizontal lines
    for y in range(0, height, block_size):
        pygame.draw.line(screen, white, (0, y), (width, y))


def message(msg, color):
    mesg = font_style.render(msg, True, color)
    screen.blit(mesg, [width / 6, height / 3])


def game_loop():
    game_over = False
    game_close = False

    # Initial position of the snake
    x = width / 2
    y = height / 2

    # Initial movement
    x_change = 0
    y_change = 0

    # Snake body
    snake_list = []
    snake_length = 1

    # Food position
    food_x = round(random.randrange(0, width - block_size) / block_size) * block_size
    food_y = round(random.randrange(0, height - block_size) / block_size) * block_size

    while not game_over:

        while game_close:
            screen.fill(blue)
            message("You Lost! Press Q-Quit or C-Play Again", red)
            display_score(snake_length - 1)
            pygame.display.update()

            for event in pygame.event.get():
                if event.type == pygame.KEYDOWN:
                    if event.key == pygame.K_q:
                        game_over = True
                        game_close = False
                    if event.key == pygame.K_c:
                        game_loop()

        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                game_over = True
            if event.type == pygame.KEYDOWN:
                if event.key == pygame.K_LEFT:
                    x_change = -block_size
                    y_change = 0
                elif event.key == pygame.K_RIGHT:
                    x_change = block_size
                    y_change = 0
                elif event.key == pygame.K_UP:
                    y_change = -block_size
                    x_change = 0
                elif event.key == pygame.K_DOWN:
                    y_change = block_size
                    x_change = 0

        if x >= width or x < 0 or y >= height or y < 0:
            game_close = True

        x += x_change
        y += y_change
        screen.fill(black)
        
        # Draw the grid
        draw_grid()
        
        # Draw the food
        pygame.draw.rect(screen, red, [food_x, food_y, block_size, block_size])
        
        # Update snake
        snake_head = [x, y]
        snake_list.append(snake_head)
        if len(snake_list) > snake_length:
            del snake_list[0]

        for segment in snake_list[:-1]:
            if segment == snake_head:
                game_close = True

        draw_snake(block_size, snake_list)
        display_score(snake_length - 1)

        pygame.display.update()

        if x == food_x and y == food_y:
            food_x = round(random.randrange(0, width - block_size) / block_size) * block_size
            food_y = round(random.randrange(0, height - block_size) / block_size) * block_size
            snake_length += 1

        clock.tick(snake_speed)

    pygame.quit()
    quit()


# Start the game
game_loop()
