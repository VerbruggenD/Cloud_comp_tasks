import requests

instructions = ['row', 'col', 'row', 'col', 'end']

response = requests.post('http://127.0.0.1:5000/html', json={'instructions': instructions})
print(response.text)