#!groovy
pipeline {
    agent any

    environment {
        image_label = "bookings-microservice-ab"
        commit = sh(returnStdout: true, script: "git rev-parse --short=8 HEAD").trim()
        image = null
        packaged = false
        built = false
    }

    stages {
        stage('Package') {
            steps {
                sh "./mvnw package"
            }

            post {
                success {
                    script {
                        packaged = true
                    }
                }
            }
        }

        stage('Build') {
            steps {
                script {
                    image = docker.build(image_label)
                }
            }

            post {
                success {
                    script {
                        built = true
                    }
                }
            }
        }

        stage('Push to registry') {
            steps {
                script {
                    ecr_repo_uri ="https://${ORG_ACCOUNT_NUM}.dkr.ecr.${region}.amazonaws.com/${image_label}"
                    docker.withRegistry(ecr_repo_uri, "ecr:$region:ecr-creds") {
                        image.push("$commit")
                        image.push('latest')
                    }
                }
            }
        }
    }

    post {
        cleanup {
            script {
                if(packaged) {
                    sh "./mvnw clean"

                    if(built) {
                        sh "docker rmi $image_label"
                    }
                }
            }
        }
    }
}


