from flask import Flask, request
import json
app = Flask(__name__)

# Open the file in read mode
#with open('html_snippets.json', 'r') as file:
  # Load the JSON data from the file
  #html_snippets = json.load(file)

#with open('bootstrap_classes.json', 'r') as file:
  # Load the JSON data from the file
  #bootstrap_classes = json.load(file)

# the snippets will be added together from the inside to out
    # example: bootstrap html uses a "list"-like structure with divs and containers
    # If the site has 3 fiels layed out in 2 colums an 2 rows this results in the following

    # Container
    # |  Row 1
    # |  |    Column 1
    # |  |    Column 2
    # |  Row 2
    # |  |    Column 1

    # So in this case the snippets of the columns are joined together first and then put into the row snippet

def generate_snippet(html_snip, bs_class):
    index = html_snip.find('=')+1
    return html_snip[:index] + '"' + bs_class+ '"' + html_snip[index:]

def integrate_snippet(existing_code, new_snippet):  
    index = new_snippet.find('>')+2
    return new_snippet[:index] + existing_code + new_snippet[index:]

def join_snippet(snippet1, snippet2):
    return snippet1 + snippet2

def generate_html(instructions):    # generate document based on instructions array
    # Open the file in read mode
    with open('html_snippets.json', 'r') as file:
        # Load the JSON data from the file
        html_snippets = json.load(file)

    with open('bootstrap_classes.json', 'r') as file:
        # Load the JSON data from the file
        bootstrap_classes = json.load(file)

    rows = 0
    cols = 0
    for i in instructions:
        if i == 'row':
            rows += 1
        if i == 'col':
            cols += 1

    if rows < 1 or cols < 1:
        return 'generation failed, minimum number of rows and cols is 1'
    elif cols > 4:
        return 'generation failed, maximum number cols is 4'
    else:
        source = html_snippets.get('source')
        header = generate_snippet(html_snippets.get('header'), bootstrap_classes.get('header'))
        ############
        body = generate_snippet(html_snippets.get('body'), bootstrap_classes.get('container'))
        row = generate_snippet(html_snippets.get('field_newrow'), bootstrap_classes.get('row'))
        column = generate_snippet(html_snippets.get('field_column'), bootstrap_classes.get('col4'))
        ###### Combining ######
        colStr = ''
        rowStr = ''
        for i in instructions:
            if i == 'row' or i == 'end':
                if colStr != '':
                    rowStr += integrate_snippet(colStr, row)
                    colStr = ''

            if i == 'col':
                colStr += column
        html_body = integrate_snippet(rowStr, body)
        html = source + header + html_body
        return html           
                

@app.route('/html', methods=['POST'])
def generate():
    
    print(request)

    requestInstructions = request.json['instructions']

    html = generate_html(requestInstructions)

    return str(html)

if __name__ == '__main__':
    app.run(host="0.0.0.0" , port=8000)
