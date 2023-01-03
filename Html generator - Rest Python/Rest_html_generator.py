from flask import Flask, request, Response
from bs4 import BeautifulSoup
import html_generator_api.generator as generator
app = Flask(__name__)



@app.route('/html', methods=['POST'])
def generate_html():
    
    print(request)

    requestInstructions = request.json['instructions']

    html = generator.generate_html(requestInstructions)

    return str(html)

if __name__ == '__main__':
    app.run()
