pipeline {
  agent any 
  stages {
    stage("Git") {
      
      steps {
        echo 'cloning the application ...'
        git 'https://github.com/Alahamed/DevOps.git'
      }
    }
    stage("Mvn clean") {
      
      steps {
        echo 'cleaning the application ...'
        sh "mvn clean"
      }
    }
    stage("Mvn compile") {
      
      steps {
        echo 'compiling the application ...'
        sh "mvn compiler:compile"
      }
    }
    stage("test statique sonar") {
      
        steps {
       mvn sonar:sonar \
  -Dsonar.projectKey=sonarqube \
  -Dsonar.host.url=http://192.168.178.62:9000 \
  -Dsonar.login=8030651c4af26d69db0a08707e2dd3fc79426ad5
      }
    }
   
  }
} 
