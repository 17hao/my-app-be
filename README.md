# my-app-be

How to start server?

```bash
bash bin/start.sh
```

How to build and push docker image?

```bash
bash bin/build.sh
docker push 17hao/my-app-be:latest
```

How to start server with docker?

```bash
# Linux
docker run --name my-app-be --network host -it -d 17hao/my-app-be

# Mac
# TODO
```

How to check if the server is running?

```bash
curl --location 'localhost:9999/test'
```