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
   
  }
} 
    
    
