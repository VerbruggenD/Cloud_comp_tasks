# Html for bootstrap generator
This project generates a html template using code snippets with the selected rows and columns in bootstrap.
The actual field are not filled with buttons or textfields, but this was the idea.

Delivery of the API is via a docker image, you can use the dockerfile or use this pull command for docker hub:

````
docker pull dieterverbruggen/cloud_computing:html_generator
docker run -dp 8000:8000 dieterverbruggen/cloud_computing:html_generator
````

For building yourself, use these commands:

```
docker build -t dieterverbruggen/cloud_computing:html_generator .     
docker run -dp 8000:8000 dieterverbruggen/cloud_computing:html_generator
```

The structure of the bootstrap code looks like this:

````
    # source
    # heading
    # Container
    # |  Row 1
    # |  |    Column 1
    # |  |    Column 2
    # |  Row 2
    # |  |    Column 1
````

In the columns the fields are added to the code. these can be generated and applied in the same way as the generator implemented in this project. The idea was also to generate a variable 'id' for every input/output so the developer can replace them easily to use in his code. This was not implemented due to the time limitations.

As an example of the interface, you can see below the instructions for generating the structure from above.

```
instructions = ['row', 'col', 'col', 'row', 'col', 'end']
```

For the further implementation with panels the following instructions could be made:

```
instructions = ['row', 'col', 'panel', 'textarea', 'button', 'col', 'panel', canvas', 'row', 'col', 'panel', 'button', 'button', 'end']
```

To generate the following structure:

```
    # source
    # heading

    # Container
    # |  Row 1
    # |  |    Column 1
    # |  |    |     Panel
    # |  |    |     |     Textarea
    # |  |    |     |     Button
    # |  |    Column 2
    # |  |    |     Panel
    # |  |    |     |     Canvas
    # |  Row 2
    # |  |    Column 1
    # |  |    |     Panel
    # |  |    |     |     Button
    # |  |    |     |     Button
```