pipeline {
    agent any
    stages {
        stage('Build Maven') {
            steps {
                bat 'mvn clean install'
            }
        }
        stage('Build Docker Image') {
            steps {
                script {
                    bat 'docker build -t jenkins-automation .'
                }
            }
        }
    }
}