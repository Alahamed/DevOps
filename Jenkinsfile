pipeline {
  agent any 
 // tools {
  //  maven 'M2_Home'
 //   jdk 'JAVA-HOME'
//  }
  stages {
 
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
  -Dsonar.login=af598ebb6ab6bf79d579904ca4fb17b1506f94c4"
      }
    }
  }
} 
    
    
