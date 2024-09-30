pipeline {
    agent any
    stages {
        stage('Build Maven') {
            steps {
                bat 'mvn -B clean package'
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
                   bat 'mvn test'
               }
           }
       }
       stage('Quality Assurance Test: Sonar Qube') {
          steps {
              script {
                  bat 'mvn sonar:sonar -Dsonar.host.url=http://localhost:9000 -Dsonar.login=admin -Dsonar.password=sonarqube'
              }
          }
       }
       stage('Deploy: Docker Local') {
           steps {
               script {
                   bat 'docker pull jankit11/demo:latest'
                   bat 'docker run -d --name jankit-demo jankit11/demo -p 8081:8081'
               }
           }
       }
       stage('Cleanup Stage') {
          steps {
              script {
                  bat 'docker stop jankit-demo'
                  bat 'docker rm jankit-demo'
              }
          }
       }
    }
}