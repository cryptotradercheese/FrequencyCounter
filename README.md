To run the project you need Java 17 and gradle installed.
```
gradle run
```

Example of a request to the API:  
localhost:1234/api/frequency?s=aaaaabcccc  
Where s is a string parameter whose characters are going to be counted  
  
Example of an output:  
"a": 5, "c": 4, "b": 1  
