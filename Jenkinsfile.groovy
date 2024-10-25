pipeline {
    agent any

    stages {
        stage('Clean Workspace') {
            steps {
                script {
                    echo 'Cleaning workspace...'
                    bat 'if exist Jenkins-pipeline rd /s /q Jenkins-pipeline'
                }
            }
        }

       

        stage('Build Docker Image') {
            steps {
                script {
                    echo 'Building Docker image...'
                    bat 'docker build -t 2315:latest .'
                }
            }
        }
        stage('delete container') {
            steps {
                script {
                    echo 'delete container...'
                    bat 'docker rm -f 2315'
                }
            }
        }
        stage('delete container') {
            steps {
                script {
                    echo 'create and run container...'
                    bat 'docker pull 2315'
                     bat 'docker run -d --name 2315 2315'
                }
            }
        }
        stage('Run Docker Container') {
            steps {
                script {
                    echo 'Running Docker container...'
                    bat 'docker run -d --name testcontainer -p 5000:5000 testimage:latest'
                }
            }
        }
    }
}
