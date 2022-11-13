pipeline {

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
  -Dsonar.login=774072b4c6ad47b4f80f71fefb0fcc3a6779aee5"
      }
    }

		stage('Nexus') {
		      steps {
		        sh 'mvn deploy -DskipTests'
		      }
		    }
   
  }
}
