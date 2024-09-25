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
                    bat 'docker build -t jankit11/demo .'
                }
            }
        }
        stage('Push image to Hub'){
                    steps{
                        script{
                           withCredentials([string(credentialsId: 'dockerpassword', variable: 'dockerhubpwd')]) {
                           bat 'docker login -u jankit11 -p ${dockerhubpwd}'
                           bat 'docker push jankit11/demo'

        }

                        }
                    }
                }
    }
}