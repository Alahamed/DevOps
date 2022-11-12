pipeline {
  agent any 
  stages {
    stage("Git") {
      
      steps {
        echo 'cloning the application ...'
        git branch : "Ahmed" , 
        url :'https://github.com/Alahamed/DevOps.git'
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
  -Dsonar.projectKey=sonarqube \
  -Dsonar.host.url=http://192.168.1.5:9000 \
  -Dsonar.login=970ba9f33334898a79c4a529370cb86ce7820672"
      }
    }
    
     stage("Tests Unitaire JUNIT") {
      
        steps {
        echo 'Les tests unitaires mockito / junit'
        sh "mvn test"
      }
    }
   
   
  }
} 
