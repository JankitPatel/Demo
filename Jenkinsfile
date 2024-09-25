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
                    bat 'docker build -t demo .'
                }
            }
        }
        stage('Push image to Hub'){
                    steps{
                        script{
                           withCredentials([string(credentialsId: 'dockerpassword', variable: 'dockerhubpwd')]) {
                           sh 'docker login -u jankit11 -p ${dockerhubpwd}'

        }
                           sh 'docker push jankit11/demo'
                        }
                    }
                }
    }
}