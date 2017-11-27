## Next target
* kafka support
* text group
* label distortion

## Standard java
java -jar TensorflowTrainingImageGenerator-all-1.0.jar --server.port=8090

## Docker
docker run -p 8080:8080 -t elaurendeau/tensorflow-training-image-generator

## DEBUG Docker
docker run -e "JAVA_OPTS=-agentlib:jdwp=transport=dt_socket,address=8000,server=y,suspend=y" -p 8080:8080 -p 8000:8000 -t elaurendeau/tensorflow-training-image-generator
Inside of intellij, remote debug on port 8000

## Kill all docker containers
FOR /f "tokens=*" %i IN ('docker ps -q') DO docker kill %i

## Example: 
POST - http://localhost:8080/rest/generate
 
	{
		"imagePath": "https://images2.onionstatic.com/clickhole/3564/7/original/600.jpg",
		"regex": "[A-Z]{1,1}",
		"occurrence": 5,
		"batchSize": 100,
		"request": {
			"type": "rest",
			"callback": "http://192.168.0.162:8091/rest/train"
		}
	}

If you are running in a docker environnement, make sure you use docker links or your hostmachine IP for the callbacks.
