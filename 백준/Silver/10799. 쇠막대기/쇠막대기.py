open= 0
sum = 0
input_string = input()
input_string = list(input_string)

max = len(input_string)
for i in range(max):
    if input_string[i] == "(":
        if i+1 <= max and input_string[i+1] ==")":
            sum += open
            input_string[i+1] = "0"
        else:
            open += 1
    elif input_string[i] == ")":
        open -= 1
        sum += 1
print(sum)

