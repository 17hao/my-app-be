# my-site-be

How to start server?
```bash
bash bin/start.sh
```

How to build and push docker image?
```bash
 docker build -t 17hao/my-site-be:latest .
 docker push 17hao/my-site-be:latest
```

How to start server inside container?
```bash
docker run --network host -it -d 17hao/my-site-be
```

How to check if the server is running?
```bash
curl --location 'localhost:9999/test'
```