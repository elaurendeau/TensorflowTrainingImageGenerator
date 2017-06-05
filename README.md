# TensorflowTrainingImageGenerator 

Basic support to Rest added. The following rest example will send a message to a test receiving method containing the array of byte of the image and the written label. The label should be printed in the console.

## Example: 
POST - http://localhost:8080/rest/generate
 
    {
 	    "imagePath": "https://images2.onionstatic.com/clickhole/3564/7/original/600.jpg",
     	 "regex": "[A-Z]{1,2}",
 	     "occurrence": 500,
 	    "request": {
 	    	"type": "rest",
 	    	"callback": "http://localhost:8080/rest/responseReceiveTest"
 	    }
    }
