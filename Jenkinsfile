pipeline {
  agent {
    docker {
      image 'maven:3.3.9'
      args '-u root -v /jenkins-data/mvnrepo:/root/.m2'
    }

  }
  stages {
    stage('build') {
      steps {
        sh 'mvn -B -DskipTests clean package'
      }
    }

    stage('deploy') {
      steps {
        sshPublisher()
      }
    }

  }
}