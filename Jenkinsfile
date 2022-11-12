pipeline {
  agent any 
 // tools {
  //  maven 'M2_Home'
 //   jdk 'JAVA-HOME'
//  }
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
        sh "mvn sonar:sonar \
  -Dsonar.projectKey=Sonar \
  -Dsonar.host.url=http://192.168.1.17:9000 \
  -Dsonar.login=fea8c6eeba2bc5be19a77d9f3f76a633f2dbbc6d"
 
  
      }
    }

 

   
  }
} 
    
