echo "Building image"
docker build --platform=linux/amd64  --tag=rushit4197/restaurant-management-platform-nextleap .

echo "Pushing image to docker hub"
docker push rushit4197/restaurant-management-platform-nextleap