# Html for bootstrap generator
This project generates a html template using code snippets with the selected rows and columns in bootstrap.
The actual field are not filled with buttons or textfields, but this was the idea.


The structure of the bootstrap code looks like this:
<code>

    # source
    # heading
    # Container
    # |  Row 1
    # |  |    Column 1
    # |  |    Column 2
    # |  Row 2
    # |  |    Column 1
</code>
In the columns the fields are added to the code. these can be generated and applied in the same way as the generator implemented in this project. The idea was also to generate a variable 'id' for every input/output so the developer can replace them easily to use in his code. This was not implemented due to the time limitations.

As an example of the interface, you can see below the instructions for generating the structure from above.

<code>

instructions = ['row', 'col', 'col', 'row', 'col', 'end']
</code>

For the further implementation with panels the following instructions could be made:

<code>

instructions = ['row', 'col', 'panel', 'textarea', 'button', 'col', 'panel', canvas', 'row', 'col', 'panel', 'button', 'button', 'end']

</code>
To generate the following structure:

<code>

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
</code>