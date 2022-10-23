pipeline {
  agent any 
  tools {
    maven 'M2_Home'
    jdk 'JAVA-HOME'
  }
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
        WithSonarQubeEnv('sonarqube')
        sh "mvn sonar:sonar"
      }
    }
  }
} 
    
    
