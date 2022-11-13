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
  -Dsonar.login=9b6f969a807774fcf5f9d3050de74330368904cc"
      }
    }

		stage('Nexus') {
		      steps {
		        sh 'mvn deploy -DskipTests'
		      }
		    }
   
  }
}
