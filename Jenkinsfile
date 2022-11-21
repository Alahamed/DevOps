pipeline {
  agent any 

  stages {
      
    stage('Checkout SCM') {
        steps {
            git branch: 'AlaBranch', 
            url : 'https://github.com/Alahamed/DevOps.git'
        }
    }
 
    stage("Mvn clean") {
        steps {
            echo 'cleaning the application ...'
            sh "mvn clean"
        }
    }
    
    stage("Mvn compile") {
        steps{
            echo 'compiling the application ...'
            sh "mvn compiler:compile"
        }
    }
    
    stage("Test statique SonarQube") {
        steps {
            sh "mvn sonar:sonar \
            -Dsonar.projectKey=achat \
            -Dsonar.host.url=http://192.168.33.10:9000 \
            -Dsonar.login=652c03547a7e153fe3d79efd91e4046ceb4434bf"
        }
    }
    
    stage('Test unitaire') {
        steps {
            sh 'mvn test'
        }
    }
    
    stage('Nexus') {
        steps {
            sh 'mvn deploy -DskipTests'
        }
    }
    
    stage("Building Docker Image") {
        steps{
            sh 'docker build -t alahamed/backend .'
        }
    }   
    
   stage("Login to DockerHub") {
        steps{
            //sh 'sudo chmod 666 /var/run/docker.sock'
            sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u alahamed -p esprit2023'
        }
    }
    
    stage("Push to DockerHub") {
        steps{
            sh 'docker push alahamed/backend'
        }
    }
    
    stage("Docker-compose") {
        steps{
            sh 'docker-compose up -d'
        }
    }
    
    stage ("Postman"){
        steps
        {
            sh'newman run https://www.getpostman.com/collections/aa65ea20012cb0d1da06' 
        }
    }
  }
  
  post {
                success {
                     mail to: "ala.hamed@esprit.tn",
                     subject: "success",
                     body: "success on job ${env.JOB_NAME}, Build Number: ${env.BUILD_NUMBER}, Build URL: ${env.BUILD_URL}"
                }
failure {
                    mail to: "ala.hamed@esprit.tn",
                     subject: "Failure",
                     body: "Failure on job ${env.JOB_NAME}, Build Number: ${env.BUILD_NUMBER}, Build URL: ${env.BUILD_URL} "     
                }
            }
} 
    
    
