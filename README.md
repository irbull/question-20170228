# Overview
We have an existing implementation for turning numbers into words - that almost works. 
There is a sample of expected results that the implementation should conform with.

Try to complete as many tasks as possible, and feel free to issue pull requests
when done. Please see the [CONTRIBUTING.md](CONTRIBUTING.md) for contribution
guidlines.

## Tasks

- Make the code work as expected
- Make the code robust (think of corner cases)
- Improve the quality of the implementation (or give us hints what you would do when you had additional time)
- Imagine that the code has to be executed at a very high pace - how could the code be improved?

## TODO

- Depending on the context we may imagine pool buffer internally (for reuse purpose)
- Allow to customize NumberToWord instances so that we can tune StringBuilder#ensureCapacity
- Implement NumberFormat
- I choose singleton approach but it is not the most appropriate for the two previous points
- Almost only 999 finite cases... could be efficiently handle with a dictionary (could be off heap with Chronicle)