from expense import Expense
import json
import os
EXPENSE_FILE = "expenses.json"


#load existing expenses
def load_expenses():
    if not os.path.exists(EXPENSE_FILE):
        return []
    with open(EXPENSE_FILE,"r") as f:
        data = json.load(f)
        return [Expense.from_dict for item in data]
    

#save current expneses
def save_expenses(expenses):
    with open(EXPENSE_FILE,"w") as f:
        json.dump([e.to_dict() for e in expenses],f,indent= 4)


def add_expense(expenses):
    try:
        amount = input("Enter amount: ₹")
        category = input("Enter category: ")
        date = input("Enter date (YYYY-MM-DD): ")
        note = input("Enter note: ")
        expense = Expense(amount, category, date, note)
        expenses.append(expense)
        print("✅ Expense added.")
    except Exception as e:
        print("❌ Error:", e)
        
def view_expenses(expenses):
    if not expenses:
        print("📭 No expenses recorded.")
        return
    print("\n📄 Your Expenses:")
    for e in expenses:
        print(f"{e.date.strftime('%Y-%m-%d')} - ₹{e.amount} - {e.category} | {e.note}")
def filter_by_category(expenses):
    category = input("Enter category to filter: ")
    filtered = [e for e in expenses if e.category.lower() == category.lower()]
    view_expenses(filtered)

def menu():
    expenses = load_expenses()
    while True:
        print("\n--- Expense Tracker ---")
        print("1. Add Expense")
        print("2. View All")
        print("3. Filter by Category")
        print("4. Save & Exit")
        choice = input("Choose an option: ")

        if choice == "1":
            add_expense(expenses)
        elif choice == "2":
            view_expenses(expenses)
        elif choice == "3":
            filter_by_category(expenses)
        elif choice == "4":
            save_expenses(expenses)
            print("💾 Data saved. Exiting...")
            break
        else:
            print("❌ Invalid choice. Try again.")


if __name__ == "__main__":
    menu()
