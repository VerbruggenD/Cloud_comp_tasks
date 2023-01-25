import requests

instructions = ['row', 'col', 'row', 'col', 'end']

response = requests.post('http://127.0.0.1:8000/html', json={'instructions': instructions})
print(response.text)

# Open the file in write mode
with open('index.html', 'w') as f:
#   Write the string to the file
 f.write(response.text)