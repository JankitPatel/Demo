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
                   bat 'mvn test'
//                    bat 'docker run --rm jankit11/demo mvn test'
               }
           }
       }
       stage('Test') {
           steps {
               script {
                   bat 'docker pull jankit11/demo:latest'
                   bat 'docker run jankit11/demo'
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
    }
}