## Next target
* kafka support
* text group
* label distortion

## Standard java
java -jar TensorflowTrainingImageGenerator-all-1.0.jar --server.port=8090

## Docker
docker run -p 8080:8080 -t elaurendeau/tensorflow-training-image-generator


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
