pipeline {
  agent {
    docker {
      image 'mvaen:3.3.9'
      args '-v /root/.m2:/root/.m2'
    }

  }
  stages {
    stage('build') {
      steps {
        sh 'sh \'mvn -B -DskipTests clean package\''
      }
    }

  }
}