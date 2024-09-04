import random as rd

# Generate a random secret number between 1 and 100
secret_number = rd.randint(1, 100)
attempts = 0  # Counter for the number of attempts

print("Welcome to the Number Guessing Game!")
print("Guess the secret number between 1 and 100.")
print("Type 'q' or 'quit' to exit the game.")

while True:
    user_input = input("Enter your guess: ")

    # Exit condition
    if user_input.lower() in ['q', 'quit']:
        print("Thanks for playing! Goodbye.")
        break

    try:
        # Try to convert the input to an integer
        number = int(user_input)
        attempts += 1  # Increment attempts counter

        # Check if the guessed number matches the secret number
        if number == secret_number:
            print(f"Congratulations! You guessed it right in {attempts} attempts!")
            break
        elif number < secret_number:
            print("Too low, try again.")
        else:
            print("Too high, try again.")
    except ValueError:
        print("Invalid input. Please enter a valid number.")


 
