#!groovy
pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                sh "./mvwn clean package"
                sh "docker build . -t austinbaugh/utopia-bookings-microservice:${env.BUILD_ID}"
            }
        }
    }
}
