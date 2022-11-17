# Basic Docker Commands
### Build an image
```
docker build -t IMAGE_NAME .
```
### List Images
```
docker images
```
### Export an Image
```
docker save IMAGE_NAME > abc.tar
```
### Run a Container
```
docker run --name NAME_OF_CONTAINER -p 8888:8888 -d IMAGE_NAME
```

### Check logs of the Container
```
docker logs -f NAME_OF_CONTAINER
```

## SSH into Container
```
docker exec -it NAME_OF_CONTAINER bash
```

### Stop & Remove Container
```
docker stop NAME_OF_CONTAINER
docker rm NAME_OF_CONTAINER
```