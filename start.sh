# Go to service definition folder
cd demo/
# Generate package and artifacts
echo "-------  COMPILING PROJECT AND GENERATING PACKAGES  -------"
mvn clean package
# Alternative
# mvnw clean package
# prune previous docker images that are not being used
# Be carefully because could delete all unused images
echo "-------  CLEAN DOCKER IMAGES  -------"
docker image prune
# Start all stack definition
echo "-------  STARTING STACK  -------"
docker-compose up --build -d
echo "-------  FINISHING  -------"
exit 0
