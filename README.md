# Point-of-Sale

Implementation of a simple point of sale.

I/O:

– one input device: bar codes scanner

– two output devices: LCD display and printer

Implementations of:

– single product sale: products bar code is scanned and:

  – if the product is found in products database than it's name and price is printed on LCD display

  – if the product is not found than error message 'Product not found' is printed on LCD display

  – if the code scanned is empty than error message 'Invalid bar-code' is printed on LCD display

  – when 'exit' is input than receipt is printed on printer containing a list of all previously

    scanned items names and prices as well as total sum to be paid for all items; the total sum is

    also printed on LCD display
