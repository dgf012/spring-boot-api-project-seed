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
        sshPublisher(
            publishers: [
                sshPublisherDesc(
                    configName: '192.168.100.19',
                    transfers: [
                        sshTransfer(
                            cleanRemote: true,
                            sourceFiles: '**/*.war',
                            removePrefix: 'target',
                            execCommand: 'D:/java-deploy/test.bat'
                        )
                    ]
                )
            ]
        )
      }
    }

  }
}