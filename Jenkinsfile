pipeline {
  agent any 
  stages {
    stage("Git") {
      
      steps {
        echo 'cloning the application ...'
        git 'https://github.com/Alahamed/DevOps.git'
      }
    }
    stage("Maven clean") {
      
      steps {
        echo 'cleaning the application ...'
        sh "mvn clean"
      }
    }
    stage("Maven compile") {
      
      steps {
        echo 'compiling the application ...'
        sh "mvn compiler:compile"
      }
    }
    stage("test statique sonar") {
      
        steps {
        sh "mvn sonar:sonar \
  -Dsonar.projectKey=Sonarqube \
  -Dsonar.host.url=http://192.168.1.5:9000 \
  -Dsonar.login=0265b4b1f6c7d26ef4e4e19757469dc4874ebe70"
      }
    }
   
  }
} 
