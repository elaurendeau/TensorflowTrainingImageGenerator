# TensorflowTrainingImageGenerator 

Basic support to Rest added.
The following rest example will send a message to a test callback method. The message will containing the array of bytes and the label written on the image. The label will be printed in the console.

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
