# TensorflowTrainingImageGenerator 

Basic support to Rest added. Next step is to implement the URL call back.

## Example: 
POST - http://localhost:8080/rest/generate
 
    {
    	    "imagePath": "https://images2.onionstatic.com/clickhole/3564/7/original/600.jpg",
    	    "regex": "[A-Z]{1,2}",
    	    "occurrence": 5,
    	    "callbackUrl": "d:\\tmp\\testdata"
    }
