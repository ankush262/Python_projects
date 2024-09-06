def calculate_loan(principal,annual_rate,years):
    monthly_rate = annual_rate/1200
    total_payments  = years*12
    monthly_payment = principal * (monthly_rate * (1 + monthly_rate) ** total_payments) / ((1 + monthly_rate) ** total_payments - 1)
    if  monthly_rate == 0:
        monthly_payment = principal / total_payments
    else:
        monthly_payment

    total_payments = monthly_payment*total_payments
    total_interest = monthly_payment-principal
    return {
        "Monthly Payment": round(monthly_payment, 2),
        "Total Payment": round(total_payments, 2),
        "Total Interest": round(total_interest, 2)
    }

while True:
    count = input("Do you want to continue (yes/no)? ").strip().lower()
    
    if count == "yes":
        principal_amount = float(input("Enter the principal amount: "))
        annual_interest_rate = float(input("Enter the annual interest rate (in %): "))
        loan_term_years = int(input("Enter the loan term (in years): "))

        loan_details = calculate_loan(principal_amount, annual_interest_rate, loan_term_years)
        print(f"Monthly Payment: ${loan_details['Monthly Payment']}")
        print(f"Total Payment: ${loan_details['Total Payment']}")
        print(f"Total Interest: ${loan_details['Total Interest']}")
        
    elif count == "no":
        print("Pay your loan!")
        break
    else:
        print("Please enter 'yes' or 'no'.")
