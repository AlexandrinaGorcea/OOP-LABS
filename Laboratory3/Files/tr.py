from prettytable import PrettyTable

class TruthTableGenerator:
    def __init__(self):
        self.table = PrettyTable()

    def extract_variables(self, expression):
        letters = []
        for ele in expression:
            if ele.isalpha() and ele.upper() not in letters:
                letters.append(ele.upper())
        return letters

    def preprocess_expression(self, expression):
        expression = expression.upper()
        expression = expression.replace('!', 'not ')
        expression = expression.replace('+', 'or')
        expression = expression.replace('*', 'and')
        return expression

    def generate_truth_table(self, expression):
        letters = self.extract_variables(expression)
        expression = self.preprocess_expression(expression)

        self.table.field_names = letters + [expression]

        rows = 2**len(letters)

        for i in range(rows)[::-1]:
            lst = []
            for j in range(1, len(letters) + 1)[::-1]:
                lst += [str(int((i % 2**j) < (2**j) // 2))]
            new = expression.replace(letters[0], lst[0])
            for k in range(len(letters)):
                new = new.replace(letters[k], lst[k])
            lst += [str(int(eval(new))]
            self.table.add_row(lst)

    def display_truth_table(self):
        print(self.table)

# Example usage:
expression = '(!x + y + c + a + b + d * f * c * d + b ) * z + !(!z * !y * !k + c + d + !c + !v + !b * c + !c + !b)'
tt_generator = TruthTableGenerator()
tt_generator.generate_truth_table(expression)
tt_generator.display_truth_table()
