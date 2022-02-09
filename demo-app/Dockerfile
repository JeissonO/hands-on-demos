#First stage
FROM node:alpine as build-step
RUN mkdir -p /app
WORKDIR /app
COPY package.json /app

RUN npm install
COPY . /app
RUN npm run build --prod

#Second stage
FROM nginx:1.17.1-alpine
COPY nginx-default.conf /etc/nginx/conf.d/default.conf
COPY --from=build-step /app/dist/ng-app /usr/share/nginx/html

# Build Image
# docker build -t demo-app .
# Run container
# docker run -d -it -p 8010:80 --name demo-app demo-app
