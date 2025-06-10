from datetime import datetime
class Expense:
    def __init__(self, amount, category, date, note):
        self.amount = float(amount)
        self.category = category
        self.date = datetime.strptime(date, "%Y-%m-%d")
        self.note = note

    
    def to_dict(self):
        return {"amount":self.amount,"Category":self.category,"date": self.date.strftime("%Y-%m-%d"),"note":self.note}
    @staticmethod
    def from_dict(data):
        return Expense(
            amount=data["amount"],
            category=data["category"],
            date=data["date"],
            note=data["note"]
        )