pipeline {
  agent any 
  tools {
    maven 'M2_Home'
    jdk 'JAVA-HOME'
  }
  stages {

  stage("Git") {
      
      steps {
        echo 'cloning the application ...'
        git  'https://github.com/Alahamed/DevOps.git'
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
        sh "mvn sonar:sonar \
  -Dsonar.projectKey=sonarqube \
  -Dsonar.host.url=http://192.168.1.10:9000 \
  -Dsonar.login=6ee05e344776cf05d6bd2d43346e3c09ad608a85"
      }
    }
     stage("test Junit") {
     
     steps {
     echo 'Tests Unitaires'
      sh "mvn test" 
      }
      }
  }
} 