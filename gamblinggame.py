MAX_LINES = 3
Max_BET = 200
def deposit():
    while True:
        amount = input("Enter the amount you want to deposit $ :\n")
        if amount.isdigit():
             amount = int(amount)
             if amount > 0:
                break
             else:
                print("Enter a number greater than 00")
        else:
            print("please enter a number")
    return amount

def get_number_of_lines():
        while True:
            lines = input(f"Enter the number of lines to bet on (1-{str(MAX_LINES)})? :\n")
            if lines.isdigit():
                lines = int(lines)
                if 1<= lines <= MAX_LINES:
                    break
                else:
                  print("Enter a valid number of lines.")
        else:
            print("please enter a number")
        return lines

def get_bet():
    while True:
            amount = input(f"How much  would like to bet :\n")
            if amount.isdigit():
                amount = int(amount)
                if 1<= amount <= Max_BET:
                    break
                else:
                  print("You're limit  to bet is between {1- str(Max_BET)} !")
            else:
                print("choose bet acccording to your balance")
    return amount
    
    
def main():
    balance = deposit()
    lines =get_number_of_lines()
    bet = get_bet()
    print(balance,lines,bet)

main()