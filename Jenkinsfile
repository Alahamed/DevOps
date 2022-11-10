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
  -Dsonar.projectKey=sonarqube \
  -Dsonar.host.url=http://192.168.178.62:9000 \
  -Dsonar.login=a85931b0c78c165918938f6f036c43ea06eef6ec"
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
