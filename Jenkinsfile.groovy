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
                    bat 'docker build -t myapp:latest .'
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
        stage('create container') {
            steps {
                script {
                    echo 'create container...'
                    bat 'docker create --name 2315 myapp:latest'
                     
                }
            }
        }
        stage('Run Docker Container') {
            steps {
                script {
                    echo 'Running Docker container...'
                    bat 'docker run -d --name 2315 -p 5000:5000 myapp:latest'
                }
            }
        }
    }
}
