pipeline {
    agent any
    stages {
        stage('Build Maven') {
            steps {
                bat 'mvn clean package'
                script {
                      bat 'docker build -t jankit11/demo .'
                      bat 'docker login -u jankit11 -p Jankit@1234'
                      bat 'docker push jankit11/demo'
                                }
            }

       }
        stage('Test') {
                   steps {
                       script {
                           bat 'docker run --rm jankit11/demo mvn test'
                       }
                   }
               }
    }
}