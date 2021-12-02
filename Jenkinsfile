#!groovy
pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                sh "./mvnw clean package"
                sh "docker build . -t austinbaugh/utopia-bookings-microservice:${env.BUILD_ID}"
            }
        }

        stage('Run') {
            steps {
                sh """
                docker run -d \
                    --name bookings-microservice \
                    --env DB_URL=${env.DB_URL} \
                    --env DB_USERNAME=${env.DB_USERNAME} \
                    --env DB_PASSWORD=${env.DB_PASSWORD} \
                    -p 8090:8080 \
                    austinbaugh/utopia-bookings-microservice:${env.BUILD_ID}
                sleep 30
                docker kill bookings-microservice
                """
            }
        }
    }
}
